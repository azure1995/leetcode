class MedianFinder {
    PriorityQueue<Integer> lower, higher;

    /** initialize your data structure here. */
    public MedianFinder() {
        lower = new PriorityQueue<>((a, b) -> a < b ? 1 : -1);
        lower.add(Integer.MIN_VALUE);
        higher = new PriorityQueue<>((a, b) -> a > b ? 1 : -1);
        higher.add(Integer.MAX_VALUE);
    }

    public void addNum(int num) {
        if (lower.size() == higher.size()) {
            if (num <= higher.peek()) {
                lower.add(num);
            } else {
                lower.add(higher.poll());
                higher.add(num);
            }
        } else {
            if (num >= lower.peek()) {
                higher.add(num);
            } else {
                higher.add(lower.poll());
                lower.add(num);
            }
        }
    }

    public double findMedian() {
        if (lower.size() == higher.size()) {
            return (lower.peek() + higher.peek()) / 2.0;
        }
        return 0.0 + lower.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */