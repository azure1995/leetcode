class Solution {
    public String validIPAddress(String IP) {
        if (IP.contains(".")) {
            String[] nums = IP.split("\\.");
            int counter = 0;
            for (int i = 0; i < IP.length(); i++) {
                if (IP.charAt(i) == '.') {
                    counter++;
                }
            }
            if (nums.length != 4 || counter != 3) {
                return "Neither";
            }
            for (int i = 0; i < 4; i++) {
                if ((nums[i].length() > 1 && nums[i].charAt(0) == '0') || nums[i].length() > 3
                        || nums[i].length() == 0) {
                    return "Neither";
                }
                for (int j = 0; j < nums[i].length(); j++) {
                    if (nums[i].charAt(j) >= '0' && nums[i].charAt(j) <= '9') {
                        continue;
                    } else {
                        return "Neither";
                    }
                }
                if (Integer.parseInt(nums[i]) > 255) {
                    return "Neither";
                }
            }
            return "IPv4";
        } else {
            String[] nums = IP.split(":");
            System.out.println(nums.length);
            int counter = 0;
            for (int i = 0; i < IP.length(); i++) {
                if (IP.charAt(i) == ':') {
                    counter++;
                }
            }
            if (nums.length != 8 || counter != 7) {
                return "Neither";
            }
            for (int i = 0; i < 8; i++) {
                if (nums[i].length() > 4 || nums[i].length() == 0) {
                    return "Neither";
                }
                for (int j = 0; j < nums[i].length(); j++) {
                    char ch = nums[i].charAt(j);
                    if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F')) {
                        continue;
                    } else {
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }
    }
}