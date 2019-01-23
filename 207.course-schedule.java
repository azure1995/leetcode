class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[][] connected = new boolean[numCourses + 1][numCourses + 1];
        int[] numPres = new int[numCourses];
        for (int[] pair : prerequisites) {
            connected[pair[1]][pair[0]] = true;
            numPres[pair[0]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (numPres[i] == 0) {
                connected[numCourses][i] = true;
                numPres[i] = 1;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(numCourses);
        while (!queue.isEmpty()) {
            int head = queue.remove();
            for (int i = 0; i < numCourses; i++) {
                if (connected[head][i] && --numPres[i] == 0) {
                    queue.add(i);
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (numPres[i] > 0) {
                return false;
            }
        }
        return true;
    }
}