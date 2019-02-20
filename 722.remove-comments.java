class Solution {
    public List<String> removeComments(String[] source) {
        List<String> ret = new ArrayList<>();
        boolean inBlock = false;
        StringBuilder sb = null;
        for (String line : source) {
            if (!inBlock) {
                sb = new StringBuilder();
            }
            for (int j = 0; j < line.length(); j++) {
                if (!inBlock) {
                    if (j < line.length() - 1 && line.charAt(j) == '/' && line.charAt(j + 1) == '*') {
                        j++;
                        inBlock = true;
                    } else if (j < line.length() - 1 && line.charAt(j) == '/' && line.charAt(j + 1) == '/') {
                        break;
                    } else {
                        sb.append(line.charAt(j));
                    }
                } else if (j < line.length() - 1 && line.charAt(j) == '*' && line.charAt(j + 1) == '/') {
                    j++;
                    inBlock = false;
                }
            }
            if (!inBlock && sb.length() > 0) {
                ret.add(sb.toString());
            }
        }
        return ret;
    }
}