class Solution {
    public boolean isMutable(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < 8; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (++diff > 1) {
                    return false;
                }
            }
        }
        return diff == 1;
    }

    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) {
            return 0;
        }
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        bankSet.add(start);
        List<String> bankList = new ArrayList<>(bankSet);
        if (!bankSet.contains(end)) {
            return -1;
        }
        boolean[][] mutable = new boolean[bankList.size()][bankList.size()];
        for (int i = 0; i < bankList.size() - 1; i++) {
            for (int j = i + 1; j < bankList.size(); j++) {
                if (isMutable(bankList.get(i), bankList.get(j))) {
                    mutable[i][j] = true;
                    mutable[j][i] = true;
                }
            }
        }
        int startIndex = bankList.indexOf(start);
        int endIndex = bankList.indexOf(end);
        boolean[] visited = new boolean[bankList.size()];
        int dist = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startIndex);
        queue.add(null);
        visited[startIndex] = true;
        while (!queue.isEmpty()) {
            Integer head = queue.remove();
            if (head == null) {
                if (queue.isEmpty()) {
                    return -1;
                } else {
                    dist++;
                    queue.add(null);
                }
            } else if (head == endIndex) {
                return dist;
            } else {
                for (int i = 0; i < bankList.size(); i++) {
                    if (mutable[head][i] && !visited[i]) {
                        queue.add(i);
                        visited[i] = true;
                    }
                }
            }
        }
        return -1;
    }
}