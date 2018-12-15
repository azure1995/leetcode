class RLEIterator {
    int[] A;
    int left;
    int index;

    public RLEIterator(int[] A) {
        this.A = A;
        this.left = 0;
        this.index = -2;
    }

    public int next(int n) {
        if (index == A.length - 2 && left < 0) {
            return -1;
        }
        while (index + 2 <= A.length - 2 && left < n) {
            index += 2;
            left = left + A[index];
        }
        left -= n;
        if (left < 0) {
            return -1;
        }
        return A[index + 1];
    }
}
/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */