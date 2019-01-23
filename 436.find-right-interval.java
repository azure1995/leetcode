class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i].start, i);
        }
        List<Integer> list = new ArrayList<>(intervals.length);
        for (int i = 0; i < intervals.length; i++) {
            list.add(intervals[i].start);
        }
        Collections.sort(list);
        int[] result = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int index = Collections.binarySearch(list, intervals[i].end);
            if (index < 0) {
                index = -index - 1;
            }
            if (index == list.size()) {
                result[map.get(intervals[i].start)] = -1;
            } else {
                result[map.get(intervals[i].start)] = map.get(list.get(index));
            }
        }
        return result;
    }
}