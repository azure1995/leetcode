class Solution {
    List<Integer> result;

    public void get(int start, int end) {
        for (int i = start; i < end; i++) {
            if (i % 10 == 0) {
                int t = i;
                do {
                    t /= 10;
                } while (t % 10 == 0);
                while (t < i) {
                    result.add(t);
                    t *= 10;
                }
            }
            result.add(i);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        result = new ArrayList<>();
        for (int i = 1; i <= Math.min(n, 9); i++) {
            int temp = i;
            while (temp <= n) {
                result.add(temp);
                temp *= 10;
            }
            temp /= 10;
            int nextBound = temp / i * (i + 1);
            get(temp + 1, Math.min(n + 1, nextBound));
            if (n + 1 < nextBound) {
                get(n / 10 + 1, nextBound / 10);
            }
        }
        return result;
    }
}