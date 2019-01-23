class Solution {
    public int hIndex(int[] citations) {
        int[] sortedCitations = citations.clone();
        Arrays.sort(sortedCitations);
        int left = 0, right = sortedCitations.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int morePapers = sortedCitations.length - mid;
            if (sortedCitations[mid] == morePapers || sortedCitations[mid] + 1 == morePapers) {
                return sortedCitations[mid];
            } else if (sortedCitations[mid] > morePapers) {
                if (mid == 0 || sortedCitations[mid - 1] <= morePapers) {
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