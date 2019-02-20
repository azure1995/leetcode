class Solution {

    public boolean isPossible(int[] nums) {
        Counter counts = new Counter();
        Counter tails = new Counter();
        for (int num : nums) {
            counts.add(num, 1);
        }
        for (int num : nums) {
            if (counts.get(num) == 0) {
                continue;
            } else if (tails.get(num) > 0) {
                counts.add(num, -1);
                tails.add(num, -1);
                tails.add(num + 1, 1);
            } else if (counts.get(num + 1) > 0 && counts.get(num + 2) > 0) {
                counts.add(num, -1);
                counts.add(num + 1, -1);
                counts.add(num + 2, -1);
                tails.add(num + 3, 1);
            } else {
                return false;
            }
        }
        return true;
    }
}

class Counter extends HashMap<Integer, Integer> {

    public void add(int k, int a) {
        put(k, get(k) + a);
    }

    public int get(int k) {
        return containsKey(k) ? super.get(k) : 0;
    }
}