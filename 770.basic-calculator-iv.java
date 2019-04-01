class Solution {
    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < evalvars.length; i++) {
            map.put(evalvars[i], evalints[i]);
        }
        Map<String, Integer> ans = helper(expression, map);
        Integer c = ans.remove("#");
        Map<String, Integer> arranged = new HashMap<>();
        for (String s : ans.keySet()) {
            String[] vars = s.split("\\*");
            Arrays.sort(vars);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < vars.length; i++) {
                sb.append(i == 0 ? vars[i] : "*" + vars[i]);
            }
            String ns = sb.toString();
            arranged.put(ns, arranged.getOrDefault(ns, 0) + ans.get(s));
        }
        TreeMap<String, Integer> sorted = new TreeMap<>((s1, s2) -> {
            String[] arr1 = s1.split("\\*");
            String[] arr2 = s2.split("\\*");
            if (arr1.length != arr2.length) {
                return arr2.length - arr1.length;
            }
            for (int i = 0; i < arr1.length; i++) {
                if (!arr1[i].equals(arr2[i])) {
                    return arr1[i].compareTo(arr2[i]);
                }
            }
            return 0;
        });
        sorted.putAll(arranged);
        List<String> ret = new ArrayList<>();
        for (String s : sorted.keySet()) {
            if (sorted.get(s) != 0) {
                ret.add(sorted.get(s) + "*" + s);
            }
        }
        if (c != null && c != 0) {
            ret.add(c + "");
        }
        return ret;
    }

    private Map<String, Integer> helper(String expr, Map<String, Integer> map) {
        Map<String, Integer> ans = new HashMap<>();
        int op = 1;
        for (int i = 0; i < expr.length(); i += 2) {
            int co = 1;
            Map<String, Integer> subMap = new HashMap<>();
            while (i < expr.length()) {
                if (expr.charAt(i) == '(') {
                    int count = 1;
                    int st = i;
                    i++;
                    while (count > 0) {
                        if (expr.charAt(i) == '(') {
                            count++;
                        } else if (expr.charAt(i) == ')') {
                            count--;
                        }
                        i++;
                    }
                    Map<String, Integer> sMap = helper(expr.substring(st + 1, i - 1), map);
                    if (subMap.size() == 0) {
                        subMap = sMap;
                    } else {
                        subMap = multiply(subMap, sMap);
                    }
                } else if (expr.charAt(i) == '-' || Character.isDigit(expr.charAt(i))) {
                    int index = expr.indexOf(' ', i);
                    index = index == -1 ? expr.length() : index;
                    co *= Integer.valueOf(expr.substring(i, index));
                    i = index;
                } else {
                    // System.out.println(i);
                    int index = expr.indexOf(' ', i);
                    index = index == -1 ? expr.length() : index;
                    String var = expr.substring(i, index);
                    if (map.containsKey(var)) {
                        co *= map.get(var);
                    } else {
                        if (subMap.size() == 0) {
                            subMap.put(var, 1);
                        } else {
                            Map<String, Integer> tmp = new HashMap<>();
                            tmp.put(var, 1);
                            subMap = multiply(subMap, tmp);
                        }
                    }
                    i = index;
                }
                i++;
                if (i >= expr.length() || expr.charAt(i) != '*') {
                    break;
                }
                i += 2;
            }
            if (co != 0) {
                if (subMap.size() == 0) {
                    ans.put("#", ans.getOrDefault("#", 0) + op * co);
                } else {
                    for (String s : subMap.keySet()) {
                        ans.put(s, ans.getOrDefault(s, 0) + op * co * subMap.get(s));
                    }
                }
            }
            if (i < expr.length()) {
                op = expr.charAt(i) == '-' ? -1 : 1;
            }
        }
        if (!ans.containsKey("#")) ans.put("#", 0);
        return ans;
    }

    private Map<String, Integer> multiply(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> ans = new HashMap<>();
        for (String s1 : map1.keySet()) {
            for (String s2 : map2.keySet()) {
                if (s1.equals("#") && s2.equals("#")) {
                    ans.put("#", ans.getOrDefault("#", 0) + map1.get("#") * map2.get("#"));
                } else if (s1.equals("#") && !s2.equals("#")) {
                    ans.put(s2, ans.getOrDefault(s2, 0) + map1.get("#") * map2.get(s2));
                } else if (!s1.equals("#") && s2.equals("#")) {
                    ans.put(s1, ans.getOrDefault(s1, 0) + map1.get(s1) * map2.get("#"));
                } else {
                    String comb = s1 + "*" + s2;
                    ans.put(comb, ans.getOrDefault(comb, 0) + map1.get(s1) * map2.get(s2));
                }
            }
        }
        return ans;
    }
}
