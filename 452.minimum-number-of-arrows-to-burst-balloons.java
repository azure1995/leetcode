class Solution {
    Comparator<int[]> comp = new Comparator<int[]>() {
        public int compare(int[] i1, int[] i2) {
            return i1[0] > i2[0] ? 1 : -1;
        }
    };

    public int findMinArrowShots(int[][] points) {
        List<int[]> list = Arrays.asList(points);
        Collections.sort(list, comp);
        int shots = 0;
        long prevStart = Long.MAX_VALUE;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i)[1] < prevStart) {
                shots++;
                prevStart = list.get(i)[0];
            }
        }
        return shots;
    }
}