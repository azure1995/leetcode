import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * test
 */
public class test {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        sset(set);
        System.out.println(set.size());
    }

    static void sset(Set<Integer> set) {
        (2>1)?set.add(1):set.add(2);
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