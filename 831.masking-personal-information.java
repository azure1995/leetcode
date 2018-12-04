class Solution {

    public String maskPII(String S) {
        if ((S.charAt(0) >= 'a' && S.charAt(0) <= 'z') || (S.charAt(0) >= 'A' && S.charAt(0) <= 'Z')) {
            StringBuilder sb = new StringBuilder();
            sb.append(S.charAt(0));
            sb.append("*****");
            for (int i = 1; i < S.length(); i++) {
                if (i + 1 < S.length() && S.charAt(i + 1) == '@') {
                    sb.append(S.charAt(i));
                    sb.append(S.substring(i + 1));
                }
            }
            return sb.toString().toLowerCase();
        } else {
            String[] cc = { "", "+*-", "+**-", "+***-" };
            int digits = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) >= '0' && S.charAt(i) <= '9') {
                    digits++;
                    sb.append(S.charAt(i));
                    if (sb.length() > 4) {
                        sb.deleteCharAt(0);
                    }
                }
            }
            return cc[digits - 10] + "***-***-" + sb.toString();
        }
    }
}