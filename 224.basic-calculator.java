class Solution {
    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == ' ')
                continue;
            if (i == s.length() || s.charAt(i) == ')') {
                int acc = 0;
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    int rightOp = Integer.valueOf(stack.pop());
                    if (!stack.isEmpty() && !stack.peek().equals("(")) {
                        acc += stack.pop().equals("+") ? rightOp : -rightOp;
                    } else {
                        acc += rightOp;
                    }
                }
                if (i == s.length()) {
                    return acc;
                }
                stack.pop();
                stack.push(String.valueOf(acc));
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                StringBuilder sb = new StringBuilder();
                sb.append(s.charAt(i));
                while (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    sb.append(s.charAt(i + 1));
                    i++;
                }
                stack.push(sb.toString());
            } else {
                stack.push(String.valueOf(s.charAt(i)));
            }
        }
        throw null;
    }
}