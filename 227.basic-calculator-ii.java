class Solution {
    public int calculate(String s) {
        s = s.replaceAll("\\s+", "");
        int[] operands = Arrays.stream(s.split("\\D")).mapToInt(Integer::parseInt).toArray();
        char[] operators = new char[operands.length - 1];
        int operatorNum = 0;
        int indexOfoperand = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                operators[operatorNum++] = s.charAt(i);
                operands[operatorNum] = operands[++indexOfoperand];
            } else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                if (s.charAt(i) == '*') {
                    operands[operatorNum] *= operands[indexOfoperand + 1];
                } else {
                    operands[operatorNum] /= operands[indexOfoperand + 1];
                }
                indexOfoperand++;
            }
        }
        for (int i = 0; i < operatorNum; i++) {
            if (operators[i] == '+') {
                operands[i + 1] = operands[i] + operands[i + 1];
            } else {
                operands[i + 1] = operands[i] - operands[i + 1];
            }
        }
        return operands[operatorNum];
    }
}