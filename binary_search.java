/**
 * binary_search
 */
public class binary_search {
    public static int binary_search_lower(int[] arr, int l, int r, int key) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= key) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return r + 1;
    }

    public static int binary_search_higher(int[] arr, int l, int r, int key) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > key) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }

    public static void main(String args[]) {
        int[] arr = { 1, 2, 2, 3, 3, 4, 6 };
        System.out.println(binary_search_higher(arr, 0, arr.length, 2));
        System.out.println(binary_search_higher(arr, 0, arr.length, 3));
        System.out.println("haha");
    }
}