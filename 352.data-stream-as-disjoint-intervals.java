/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class SummaryRanges {
    Set<Integer> set;
    TreeSet<Integer> start;
    TreeSet<Integer> end;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        set = new HashSet<>();
        start = new TreeSet<>();
        end = new TreeSet<>();
    }

    public void addNum(int val) {
        if (!set.contains(val)) {
            if (!end.contains(val - 1) && !start.contains(val + 1)) {
                start.add(val);
                end.add(val);
            } else if (end.contains(val - 1) && !start.contains(val + 1)) {
                end.remove(val - 1);
                end.add(val);
            } else if (!end.contains(val - 1) && start.contains(val + 1)) {
                start.remove(val + 1);
                start.add(val);
            } else {
                end.remove(val - 1);
                start.remove(val + 1);
            }
            set.add(val);
        }
    }

    public List<Interval> getIntervals() {
        List<Interval> ret = new ArrayList<>();
        Iterator<Integer> it_s = start.iterator(), it_e = end.iterator();
        while (it_s.hasNext() && it_e.hasNext()) {
            ret.add(new Interval(it_s.next(), it_e.next()));
        }
        return ret;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */