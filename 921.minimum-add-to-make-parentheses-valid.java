class Solution {
    public int minAddToMakeValid(String S) {
        int ret = 0;
        int counter = 0;
        for (int i = 0; i < S.length(); i++) {
            counter = S.charAt(i) == '(' ? counter + 1 : counter - 1;
            if (counter == -1) {
                counter = 0;
                ret++;
            }
        }
        return ret + counter;
    }
}