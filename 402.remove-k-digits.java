class Solution {
    public String get(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
        }
        return sb.toString();
    }

    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        } else if (k == 0) {
            return num;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(num.charAt(0));
        for (int i = 1; i < num.length(); i++) {
            while (!stack.isEmpty() && num.charAt(i) < stack.peek()) {
                stack.pop();
                if (--k == 0) {
                    if (stack.isEmpty()) {
                        while (i < num.length() && num.charAt(i) == '0') {
                            i++;
                        }
                        return i == num.length() ? "0" : num.substring(i);
                    } else {
                        return get(stack) + num.substring(i);
                    }
                }
            }
            if (num.charAt(i) > '0' || !stack.isEmpty()) {
                stack.push(num.charAt(i));
            }
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        if (stack.isEmpty()) {
            return "0";
        } else {
            return get(stack);
        }
    }
}