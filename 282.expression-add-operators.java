class Solution {
    private List<String> helper(char[] arr, int from, long target, long t, long preMul, char op) {
        String ns = "";
        List<String> ret = new ArrayList<>();
        for (int i = from; i < arr.length; i++) {
            ns += String.valueOf(arr[i]);
            long num = Long.valueOf(ns);
            List<String> local = new ArrayList<>();
            long res = calc(t, Math.abs(preMul) * num, op);
            if (i == arr.length - 1 && res == target) {
                local.add("");
            } else {
                local.addAll(helper(arr, i + 1, target, res, -1, '+'));
                local.addAll(helper(arr, i + 1, target, res, -1, '-'));
                local.addAll(helper(arr, i + 1, target, t, preMul == -1 ? num : preMul * num, op));
            }
            for (String s : local) {
                if (preMul == -1) {
                    ret.add((from == 0 ? "" : String.valueOf(op)) + ns + s);
                } else {
                    ret.add("*" + ns + s);
                }
            }
            if (num == 0) {
                break;
            }
        }
        return ret;
    }

    public List<String> addOperators(String num, int target) {
        char[] arr = num.toCharArray();
        return helper(arr, 0, target, 0, -1, '+');
    }

    private long calc(long left, long right, char op) {
        return op == '-' ? left - right : left + right;
    }
}
