class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int N = pushed.length;
        Stack<Integer> stack = new Stack<>();
        for (int po = 0, pu = 0; po < N; po++) {
            while (stack.isEmpty() || stack.peek() != popped[po]) {
                if (pu == N) return false;
                stack.push(pushed[pu++]);
            }
            stack.pop();
        }
        return true;
    }
}