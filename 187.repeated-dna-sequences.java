import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * [187] Repeated DNA Sequences
 *
 * https://leetcode.com/problems/repeated-dna-sequences/description/
 *
 * algorithms
 * Medium (34.23%)
 * Total Accepted:    107.1K
 * Total Submissions: 312.8K
 * Testcase Example:  '"AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"'
 *
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and
 * T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to
 * identify repeated sequences within the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) that
 * occur more than once in a DNA molecule.
 * 
 * Example:
 * 
 * 
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 * 
 * 
 */
class Solution {
    final char[] decode = { 'A', 'C', 'G', 'T' };

    public String translate(int num) {
        StringBuilder s = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            s.append(decode[num % 4]);
            num /= 4;
        }
        return s.toString();
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 11) {
            return result;
        }
        byte[] array_s = new byte[s.length()];
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
            case 'A':
                array_s[i] = 0;
                break;
            case 'C':
                array_s[i] = 1;
                break;
            case 'G':
                array_s[i] = 2;
                break;
            case 'T':
                array_s[i] = 3;
                break;
            default:
                array_s[i] = -1;
                break;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        int window = 0;
        for (int i = 0; i < 10; i++) {
            window += array_s[i] * (1 << (2 * i));
        }
        map.put(window, 1);
        for (int i = 10; i < s.length(); i++) {
            window /= 4;
            window += array_s[i] * (1 << 18);
            if (!map.containsKey(window)) {
                map.put(window, 1);
            } else {
                map.put(window, map.get(window) + 1);
            }
        }
        return map.keySet().stream().filter(num -> num > 1).map(num -> translate(map.get(num)))
                .collect(Collectors.toList());
    }
}
