class Solution {
    public int largestRectangleArea(int[] heights) {
        int ret = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            while (!stack.isEmpty() && (i == heights.length || heights[i] <= heights[stack.peek()])) {
                int height = heights[stack.pop()];
                int width = i - 1 - (stack.isEmpty() ? -1 : stack.peek()); 
                ret = Math.max(ret, height * width);
            }
            stack.push(i);
        }
        return ret;
    }
}