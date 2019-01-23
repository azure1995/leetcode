class Solution {
    final String[] numXWords = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
    final String[] num1XWords = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen" };
    final String[] numX0Words = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
            "Ninety" };
    final String[] dict = { "", "Thousand", "Million", "Billion" };

    private String get(int num) {
        StringBuilder sb = new StringBuilder();
        if (num / 100 > 0) {
            sb.append(numXWords[num / 100] + " " + "Hundred");
        }
        if ((num % 100) / 10 == 1) {
            sb.append(((num / 100) > 0 ? " " : "") + num1XWords[(num % 100) - 10]);
        } else {
            if ((num % 100) / 10 >= 2) {
                sb.append(((num / 100) > 0 ? " " : "") + numX0Words[(num % 100) / 10]);
            }
            if (num % 10 >= 1) {
                sb.append(((num / 10) > 0 ? " " : "") + numXWords[num % 10]);
            }
        }
        return sb.toString();
    }

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        int k = 0;
        while (num > 0) {
            if (num % 1000 > 0) {
                sb.insert(0, get(num % 1000) + ( k == 0 ? "" : " " + dict[k]));
                if (num / 1000 > 0) {
                    sb.insert(0, " ");
                }
            }
            num /= 1000;
            k++;
        }
        return sb.toString();
    }
}
