class Solution {
    public String countOfAtoms(String formula) {
        StringBuilder sb = new StringBuilder();
        TreeMap<String, Integer> map = helper(formula, 1);
        for (String ele : map.keySet()) {
            sb.append(ele);
            if (map.get(ele) > 1) sb.append(map.get(ele));
        }
        return sb.toString();
    }

    private TreeMap<String, Integer> helper(String formula, int re) {
        TreeMap<String, Integer> res = new TreeMap<>();
        for (int i = 0; i < formula.length(); i++) {
            if (formula.charAt(i) == '(') {
                int start = i + 1;
                int counter = 1;
                while (counter > 0) {
                    i++;
                    if (formula.charAt(i) == '(') {
                        counter++;
                    } else if (formula.charAt(i) == ')') {
                        counter--;
                    }
                }
                String sub = formula.substring(start, i);
                StringBuilder sb = new StringBuilder();
                while (i + 1 < formula.length() && Character.isDigit(formula.charAt(i + 1))) {
                    sb.append(formula.charAt(i + 1));
                    i++;
                }
                int count = sb.length() == 0 ? 1 : Integer.valueOf(sb.toString());
                TreeMap<String, Integer> subMap = helper(sub, count);
                for (String ele : subMap.keySet()) {
                    res.put(ele, res.getOrDefault(ele, 0) + subMap.get(ele) * count);
                }
            } else {
                StringBuilder sb1 = new StringBuilder();
                sb1.append(formula.charAt(i));
                while (i + 1 < formula.length() && Character.isLowerCase(formula.charAt(i + 1))) {
                    sb1.append(formula.charAt(i + 1));
                    i++;
                }
                String ele = sb1.toString();
                StringBuilder sb2 = new StringBuilder();
                while (i + 1 < formula.length() && Character.isDigit(formula.charAt(i + 1))) {
                    sb2.append(formula.charAt(i + 1));
                    i++;
                }
                int count = sb2.length() == 0 ? 1 : Integer.valueOf(sb2.toString());
                res.put(ele.toString(), res.getOrDefault(ele, 0) + count);
            }
        }
        return res;
    }
}
