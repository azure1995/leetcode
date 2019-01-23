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
    }
}