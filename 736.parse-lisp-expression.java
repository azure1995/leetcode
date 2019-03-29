class Solution {
    public int evaluate(String expression) {
        return helper(new HashMap<>(), expression);
    }

    private int helper(Map<String, Integer> map, String exp) {
        if (Character.isDigit(exp.charAt(0)) || exp.charAt(0) == '-') {
            return Integer.valueOf(exp);
        } else if (Character.isLowerCase(exp.charAt(0))) {
            return map.get(exp);
        }
        if (exp.charAt(1) == 'a' || exp.charAt(1) == 'm') {
            int st = exp.charAt(1) == 'a' ? 5 : 6;
            int sp = st + 1;
            if (exp.charAt(st) != '(') {
                sp = exp.indexOf(' ', st);
            } else {
                int count = 1;
                while (count > 0) {
                    if (exp.charAt(sp) == ')') {
                        count--;
                    } else if (exp.charAt(sp) == '(') {
                        count++;
                    }
                    sp++;
                }
            }
            String expr1 = exp.substring(st, sp);
            String expr2 = exp.substring(sp + 1, exp.length() - 1);
            int val1 = helper(map, expr1);
            int val2 = helper(map, expr2);
            return exp.charAt(1) == 'a' ? val1 + val2 : val1 * val2;
        } else {
            Map<String, Integer> innerMap = new HashMap<>(map);
            int right = exp.length() - 2;
            if (exp.charAt(exp.length() - 2) == ')') {
                int count = 1;
                right = exp.length() - 3;
                while (count > 0) {
                    if (exp.charAt(right) == '(') {
                        count--;
                    } else if (exp.charAt(right) == ')') {
                        count++;
                    }
                    right--;
                }
            } else {
                while (exp.charAt(right) != ' ') {
                    right--;
                }
            }
            String toCalc = exp.substring(right + 1, exp.length() - 1);
            if (Character.isDigit(toCalc.charAt(0)) || toCalc.charAt(0) == '-') {
                return Integer.valueOf(toCalc);
            }
            for (int i = 5; i < right;) {
                int spi = exp.indexOf(' ', i);
                String var = exp.substring(i, spi);
                int ei = spi + 1;
                if (exp.charAt(ei) != '(') {
                    ei = exp.indexOf(' ', spi + 1);
                } else {
                    int count = 1;
                    ei++;
                    while (count > 0) {
                        if (exp.charAt(ei) == ')') {
                            count--;
                        } else if (exp.charAt(ei) == '(') {
                            count++;
                        }
                        ei++;
                    }
                }
                String expr = exp.substring(spi + 1, ei);
                innerMap.put(var, helper(innerMap, expr));
                i = ei + 1;
            }
            return helper(innerMap, toCalc);
        }
    }
}
