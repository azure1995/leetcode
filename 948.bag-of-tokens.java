class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int points = 0, left = 0, right = tokens.length - 1;
        while (left <= right) {
            if (P >= tokens[left]) {
                P -= tokens[left++];
                points++;
            } else if (points > 0 && left < right) {
                P += tokens[right--];
                points--;
            } else {
                break;
            }
        }
        return points;
    }
}