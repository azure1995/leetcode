class Solution {
    int counter;

    public void shift(int[] arr, char ch, int key) {
        if (arr[ch - 'a'] == 0)
            counter++;
        arr[ch - 'a'] += key;
        if (arr[ch - 'a'] == 0)
            counter--;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        counter = 0;
        int[] map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            shift(map, s1.charAt(i), 1);
            shift(map, s2.charAt(i), -1);
        }
        if (counter == 0)
            return true;
        for (int left = 0, right = s1.length(); right < s2.length(); left++, right++) {
            shift(map, s2.charAt(left), 1);
            shift(map, s2.charAt(right), -1);
            if (counter == 0)
                return true;
        }
        return false;
    }
}
