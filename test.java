import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Innertest
 */
public class test {
    public static void main(String[] args) {
        int[][] ori = { { 0, 1 } };
        int[][] copy = Arrays.copyOf(ori, 1);
        copy[0][0] = 2;
        System.out.println(ori[0][0]);
    }

    /**
     * test
     */
    static public class node {
        int val;

        node(int val) {
            this.val = val;
        }
    }
}
