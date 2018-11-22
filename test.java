import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * test
 */
public class test {

    public static void main(String[] args) {
        SortedSet<Integer> ss = new TreeSet<>();
        ss.add(5);
        ss.add(2);
        ss.add(6);
        List<Integer> list = new ArrayList<>(ss);
        System.out.println(list.get(0));
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