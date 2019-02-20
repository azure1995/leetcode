<<<<<<< HEAD
class Solution {
    public String getHint(String secret, String guess) {
        int bullNum = 0;
        int len = secret.length();
        int[] countArray = new int[10];
        for (int i = 0; i < len; i++) {
            char sChar = secret.charAt(i);
            char gChar = guess.charAt(i);
            if (sChar == gChar) {
                bullNum++;
            } else {
                countArray[sChar - '0']++;
                countArray[gChar - '0']--;
            }
        }
        int sum = Arrays.stream(countArray).map(Math::abs).sum();
        int cowNum = len - bullNum - sum / 2;
        return bullNum + "A" + cowNum + "B";
    }
=======
class Solution {
    public String getHint(String secret, String guess) {
        int bullNum = 0;
        int len = secret.length();
        int[] countArray = new int[10];
        for (int i = 0; i < len; i++) {
            char sChar = secret.charAt(i);
            char gChar = guess.charAt(i);
            if (sChar == gChar) {
                bullNum++;
            } else {
                countArray[sChar - '0']++;
                countArray[gChar - '0']--;
            }
        }
        int sum = Arrays.stream(countArray).map(Math::abs).sum();
        int cowNum = len - bullNum - sum / 2;
        return bullNum + "A" + cowNum + "B";
    }
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284
}