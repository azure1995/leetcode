
import java.util.Stack;

class Solution {
    enum pro {
        START, END, TIME;
    }

    public class ele {
        pro p;
        int val;

        ele(pro p, int val) {
            this.p = p;
            this.val = val;
        }
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<ele> stack = new Stack<>();
        int[] time = new int[n];
        for (int i = 0; i < logs.size(); i++) {
            String[] strs = logs.get(i).split(":");
            int id = Integer.valueOf(strs[0]);
            int t = Integer.valueOf(strs[2]);
            if (strs[1].equals("start")) {
                stack.push(new ele(pro.START, t));
            } else {
                int de = 0;
                if (stack.peek().p == pro.TIME) {
                    de = stack.pop().val;
                }
                int inteveral = t - stack.pop().val + 1;
                time[id] += inteveral - de;
                if (!stack.isEmpty() && stack.peek().p == pro.TIME) {
                    stack.peek().val += inteveral;
                } else {
                    stack.push(new ele(pro.TIME, inteveral));
                }
            }
        }
        return time;
    }
}