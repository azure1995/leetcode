<<<<<<< HEAD
import java.util.*;

public class test {
    enum pro {
        SATRT, END;
    }
    class charCount {
        int c;
        int count;

        charCount(int c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    static Comparator<charCount> comp = new Comparator<charCount>() {
        public int compare(charCount c1, charCount c2) {
            return c1.count < c2.count ? 1 : -1;
        }
    };

    public static void main(String[] args) {
        System.out.println(Byte.MAX_VALUE);
=======
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * test
 */
public class test {
    static String[] numXWords = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
    static String[] num1XWords = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen" };
    static String[] numX0Words = { "", "Ten", "Twenty", "Thirty", "fourty", "Fifty", "Sixty", "Seventy", "Eighty",
            "Ninety" };

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[] { 1, 2, 3 });
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.addAll(list);
        TreeMap<Integer,Integer> map = new TreeMap<>();
        map.floorKey(key)
        System.out.println(pq.peek());
    }

    static String get(int num) {
        StringBuilder sb = new StringBuilder();
        if (num >= 100) {
            sb.append(numXWords[num / 100] + " " + "Hundred");
        }
        if ((num % 100) / 10 == 1) {
            sb.append(" " + num1XWords[(num % 100) - 10]);
        } else {
            if ((num % 100) / 10 >= 2) {
                sb.append(" " + numX0Words[(num % 100) / 10]);
            }
            if (num % 10 >= 1) {
                sb.append(" " + numXWords[num % 10]);
            }
        }
        return sb.toString();
    }

    static void set(String s) {
        s = s + "aa";
    }
}

class Counter extends HashMap<Integer, Integer> {

    public void add(int k, int a) {
        put(k, get(k) + a);
    }

    public int get(int k) {
        return containsKey(k) ? super.get(k) : 0;
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284
    }
}