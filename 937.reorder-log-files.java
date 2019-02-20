class Solution {
    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    Comparator<String> comp = new Comparator<String>() {
        public int compare(String s1, String s2) {
            String[] arr1 = s1.split(" ");
            String[] arr2 = s2.split(" ");
            if (isDigit(arr1[1].charAt(0)) && !isDigit(arr2[1].charAt(0))) {
                return 1;
            } else if (!isDigit(arr1[1].charAt(0)) && isDigit(arr2[1].charAt(0))) {
                return -1;
            } else if (!isDigit(arr1[1].charAt(0)) && !isDigit(arr2[1].charAt(0))) {
                for (int i = 1; i < Math.min(arr1.length, arr2.length); i++) {
                    if (!arr1[i].equals(arr2[i])) {
                        return arr1[i].compareTo(arr2[i]);
                    }
                }
                return arr1.length > arr2.length ? 1 : -1;
            }
            return 0;
        }
    };

    public String[] reorderLogFiles(String[] logs) {
        List<String> list = Arrays.asList(logs);
        Collections.sort(list, comp);
        return list.toArray(new String[0]);
    }
}