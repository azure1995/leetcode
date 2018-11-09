class Solution {
    Comparator<int[]> comp = new Comparator<int[]>() {
        public int compare(int[] arr1, int[] arr2) {
            return (arr1[0] + arr1[1] > arr2[0] + arr2[1]) ? 1 : -1;
        }
    };

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (k == 0 || nums1.length == 0 || nums2.length == 0) {
            return Collections.EMPTY_LIST;
        }
        List<int[]> result = new ArrayList<>();
        long max = Long.MIN_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            int j = 0;
            while (j < nums2.length && nums1[i] + nums2[j] < max) {
                int[] arr = new int[] { nums1[i], nums2[j++] };
                int index = Collections.binarySearch(result, arr, comp);
                if (index < 0) {
                    index = -(index + 1);
                }
                if (index < k) {
                    result.add(index, arr);
                    if (result.size() > k) {
                        result.remove(k);
                    }
                } else {
                    break;
                }
            }
            while (j < nums2.length && result.size() < k) {
                result.add(new int[] { nums1[i], nums2[j++] });
            }
            max = result.get(result.size()-1)[0] + result.get(result.size()-1)[1];
        }
        return result;
    }
}