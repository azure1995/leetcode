class Solution {
    Comparator<Interval> comp = new Comparator<Interval>() {
        public int compare(Interval i1, Interval i2) {
            return i1.start > i2.start ? 1 : -1;
        }
    };

    public int eraseOverlapIntervals(Interval[] intervals) {
        List<Interval> list = new ArrayList<>(Arrays.asList(intervals));
        Collections.sort(list, comp);
        int deleted = 0;
        int prevStart = Integer.MAX_VALUE;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).end > prevStart) {
                deleted++;
            } else {
                prevStart = list.get(i).start;
            }
        }
        return deleted;
    }
}