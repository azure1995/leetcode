import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * test
 */
public class test {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a < b ? 1 : -1);
        pq.offer(1);
        pq.offer(2);
        System.out.println(pq.remove());
    }
}

class Counter extends HashMap<Integer, Integer> {

    public void add(int k, int a) {
        put(k, get(k) + a);
    }

    public int get(int k) {
        return containsKey(k) ? super.get(k) : 0;
    }
}