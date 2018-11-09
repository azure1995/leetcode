class Solution {
    public int hIndex(int[] citations) {
        int left = 0, right = citations.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int morePapers = citations.length - mid;
            if (citations[mid] == morePapers || citations[mid] + 1 == morePapers) {
                return citations[mid];
            } else if (citations[mid] > morePapers) {
                if (mid == 0 || citations[mid - 1] <= morePapers) {
                    return morePapers;
                } else {
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }
}