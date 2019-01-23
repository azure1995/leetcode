class Solution {
    public class sub {
        int len;
        int indent;

        sub(int len, int indent) {
            this.len = len;
            this.indent = indent;
        }
    }

    public int lengthLongestPath(String input) {
        Stack<sub> stack = new Stack<>();
        int maxPath = 1;
        int start = 0;
        int indent = 0;
        boolean isFile = false;
        for (int i = 0; i <= input.length(); i++) {
            if (i == input.length() || input.charAt(i) == '\n') {
                if (i > start) {
                    while (!stack.isEmpty() && indent <= stack.peek().indent) {
                        stack.pop();
                    }
                    int newPathLen = i - start + (stack.isEmpty() ? 0 : stack.peek().len) + 1;
                    if (isFile) {
                        maxPath = Math.max(maxPath, newPathLen);
                        isFile = false;
                    } else {
                        stack.push(new sub(newPathLen, indent));
                    }
                }
                indent = 0;
                start = i + 1;
            } else if (input.charAt(i) == '\t') {
                start++;
                indent++;
            } else if (input.charAt(i) == '.') {
                isFile = true;
            }
        }
        return maxPath - 1;
    }
};