import java.util.TreeSet;

class Solution {
    int[][] fromTo;
    int n;
    String[] airport;
    Map<String, Integer> mapToNum;
    List<String> result;

    public void get(int from) {
        for (int to = 0; to < n; to++) {
            if (fromTo[from][to] > 0) {
                fromTo[from][to]--;
                get(to);
            }
        }
        result.add(airport[from]);
    }

    public List<String> findItinerary(String[][] tickets) {
        if (tickets.length == 0) {
            return Collections.singletonList("JFK");
        }
        SortedSet<String> set = new TreeSet<>();
        mapToNum = new HashMap<>();
        result = new ArrayList<>();
        for (int i = 0; i < tickets.length; i++) {
            set.add(tickets[i][0]);
            set.add(tickets[i][1]);
        }
        n = set.size();
        airport = new String[n];
        int index = 0;
        for (String p : set) {
            airport[index] = p;
            mapToNum.put(p, index++);
        }
        fromTo = new int[n][n];
        for (int i = 0; i < tickets.length; i++) {
            fromTo[mapToNum.get(tickets[i][0])][mapToNum.get(tickets[i][1])]++;
        }
        get(mapToNum.get("JFK"));
        Collections.reverse(result);
        return result;
    }
}