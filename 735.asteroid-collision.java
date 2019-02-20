class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int ast : asteroids) {
            if (ast > 0 || stack.isEmpty() || stack.peek() < 0) {
                stack.push(ast);
            } else {
                boolean broken = false;
                while (!stack.isEmpty() && stack.peek() > 0) {
                    if (stack.peek() + ast == 0) {
                        stack.pop();
                        broken = true;
                        break;
                    } else if (stack.peek() + ast < 0) {
                        stack.pop();
                    } else {
                        broken = true;
                        break;
                    }
                }
                if (!broken) {
                    stack.push(ast);
                }
            }
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}