class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int left_rem = 0, right_rem = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left_rem++;
            } else if (c == ')') {
                if (left_rem > 0) {
                    left_rem--;
                } else {
                    right_rem++;
                }
            }
        }
        Set<String> ret = new HashSet<>();
        helper(0, left_rem, right_rem, 0, s, "", ret);
        return new ArrayList<>(ret);
    }

    private void helper(int from, int left_rem, int right_rem, int diff, String s, String pre, Set<String> ret) {
        if (from == s.length() && left_rem == 0 && right_rem == 0 && diff == 0) {
            ret.add(pre);
            return;
        } else if (from == s.length() || left_rem < 0 || right_rem < 0 || diff < 0) {
            return;
        }
        char cur = s.charAt(from);
        if (cur != '(' && cur != ')') {
            helper(from + 1, left_rem, right_rem, diff, s, pre + cur, ret);
        } else {
            if (cur == '(') {
                helper(from + 1, left_rem, right_rem, diff + 1, s, pre + '(', ret);
                helper(from + 1, left_rem - 1, right_rem, diff, s, pre, ret);
            } else {
                helper(from + 1, left_rem, right_rem, diff - 1, s, pre + ')', ret);
                helper(from + 1, left_rem, right_rem - 1, diff, s, pre, ret);
            }
        }
    }
}