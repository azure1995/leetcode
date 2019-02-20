<<<<<<< HEAD
import java.util.Map;
class Solution {
    final int mod = 1337;

    Map<Integer, Integer> log2 = new HashMap<>();
    public int superPow(int a, int[] b) {
        if (b.length == 0) {
            return 1;
        }
        log2.put(1, 0);
        log2.put(2, 1);
        log2.put(4, 2);
        log2.put(8, 3);
        int[][] record = new int[b.length][4];
        record[0][0] = a % mod;
        for (int i = 0; i < b.length; i++) {
            if (i > 0) {
                record[i][0] = (record[i - 1][1] * record[i - 1][3]) % mod;
            }
            for (int p = 1; p < 4; p++) {
                record[i][p] = (record[i][p - 1] * record[i][p - 1]) % mod;
            }
        }
        int result = 1;
        for (int i = 0; i < b.length; i++) {
            int t = b[b.length - 1 - i];
            while (t > 0) {
                int f = t & -t;
                result = (result * record[i][log2.get(f)]) % mod;
                t -= f;
            }
        }
        return result;
    }
=======
import java.util.Map;
class Solution {
    final int mod = 1337;

    Map<Integer, Integer> log2 = new HashMap<>();
    public int superPow(int a, int[] b) {
        if (b.length == 0) {
            return 1;
        }
        log2.put(1, 0);
        log2.put(2, 1);
        log2.put(4, 2);
        log2.put(8, 3);
        int[][] record = new int[b.length][4];
        record[0][0] = a % mod;
        for (int i = 0; i < b.length; i++) {
            if (i > 0) {
                record[i][0] = (record[i - 1][1] * record[i - 1][3]) % mod;
            }
            for (int p = 1; p < 4; p++) {
                record[i][p] = (record[i][p - 1] * record[i][p - 1]) % mod;
            }
        }
        int result = 1;
        for (int i = 0; i < b.length; i++) {
            int t = b[b.length - 1 - i];
            while (t > 0) {
                int f = t & -t;
                result = (result * record[i][log2.get(f)]) % mod;
                t -= f;
            }
        }
        return result;
    }
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284
}