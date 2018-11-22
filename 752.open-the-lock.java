class Solution {
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) {
            return 0;
        }
        boolean[] tried = new boolean[10000];
        for (int i = 0; i < deadends.length; i++) {
            int num = Integer.valueOf(deadends[i]);
            if (num == 0) {
                return -1;
            }
            tried[num] = true;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        queue.add(null);
        tried[0] = true;
        int step = 0;
        while (true) {
            String head = queue.remove();
            if (head == null) {
                if (queue.isEmpty()) {
                    break;
                }
                queue.add(null);
                step++;
            } else if (head.equals(target)) {
                return step;
            } else {
                char[] cs = head.toCharArray();
                for (int i = 0; i < 4; i++) {
                    char[] cs1 = cs.clone();
                    cs1[i] = cs[i] == '9' ? '0' : (char)(cs[i] + 1);
                    if (!tried[Integer.valueOf(String.valueOf(cs1))]) {
                        tried[Integer.valueOf(String.valueOf(cs1))] = true;
                        queue.add(String.valueOf(cs1));
                    }
                    cs1[i] = cs[i] == '0' ? '9' : (char)(cs[i] - 1);
                    if (!tried[Integer.valueOf(String.valueOf(cs1))]) {
                        tried[Integer.valueOf(String.valueOf(cs1))] = true;
                        queue.add(String.valueOf(cs1));
                    }
                }
            }
        }
        return -1;
    }
}