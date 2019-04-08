import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int maxFreq;

    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        group.computeIfAbsent(f, t -> new Stack<>()).push(x);
        if (f > maxFreq) {
            maxFreq = f;
        }
    }

    public int pop() {
        int ans = group.get(maxFreq).pop();
        freq.put(ans, maxFreq - 1);
        if (group.get(maxFreq).size() == 0) {
            maxFreq--;
        }
        return ans;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such: FreqStack obj
 * = new FreqStack(); obj.push(x); int param_2 = obj.pop();
 */
