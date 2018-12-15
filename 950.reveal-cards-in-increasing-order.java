class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int N = deck.length;
        for (int i = N - 2; i >= 0; i--) {
            int tmp = deck[N - 1];
            for (int j = N - 1; j >= i + 2; j--) {
                deck[j] = deck[j - 1];
            }
            deck[i + 1] = tmp;
        }
        return deck;
    }
}