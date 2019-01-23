class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if (name.length() == 0 || typed.length() < name.length()) {
            return false;
        }
        int ti = 0;
        for (int i = 0; i < name.length(); i++) {
            int lenInName = 1;
            while (i + 1 < name.length() && name.charAt(i) == name.charAt(i + 1)) {
                i++;
                lenInName++;
            }
            int lenInTyped = 0;
            while (ti < typed.length() && typed.charAt(ti) == name.charAt(i)) {
                ti++;
                lenInTyped++;
            }
            if (lenInName > lenInTyped) {
                return false;
            }
        }
        return true;
    }
}