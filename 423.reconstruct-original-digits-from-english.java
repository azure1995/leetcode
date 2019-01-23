class Solution {
    public String originalDigits(String s) {
        char[] unique = { 'z', 'w', 'u', 'x', 'g', 'o', 't', 'f', 's', 'i' };
        String[] number = { "o", "to", "fo", "si", "it", "", "", "i", "", "" };
        StringBuilder[] sbs = new StringBuilder[10];
        Map<Character, Long> map = s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        for (int i = 0; i < 5; i++) {
            if (map.containsKey(unique[i])) {
                long num = map.get(unique[i]);
                int val = 2 * i;
                sbs[val] = new StringBuilder();
                for (int j = 0; j < num; j++) {
                    sbs[val].append((char) (val + '0'));
                }
                for (int j = 0; j < number[i].length(); j++) {
                    char ch = number[i].charAt(j);
                    map.put(ch, map.get(ch) - num);
                }
            }
        }
        for (int i = 5; i < 10; i++) {
            if (map.containsKey(unique[i]) && map.get(unique[i]) > 0) {
                long num = map.get(unique[i]);
                int val = (2 * i + 1) % 10;
                sbs[val] = new StringBuilder();
                for (int j = 0; j < num; j++) {
                    sbs[val].append((char) (val + '0'));
                }
                for (int j = 0; j < number[i].length(); j++) {
                    char ch = number[i].charAt(j);
                    map.put(ch, map.get(ch) - num);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            if (sbs[i] != null) {
                result.append(sbs[i]);
            }
        }
        return result.toString();
    }
}