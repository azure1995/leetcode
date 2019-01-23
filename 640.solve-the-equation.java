/*
 * [640] Solve the Equation
 *
 * https://leetcode.com/problems/solve-the-equation/description/
 *
 * algorithms
 * Medium (38.81%)
 * Total Accepted:    12K
 * Total Submissions: 30.9K
 * Testcase Example:  '"x+5-3+x=6+x-2"'
 *
 * 
 * Solve a given equation and return the value of x in the form of string
 * "x=#value". The equation contains only '+', '-' operation, the variable x
 * and its coefficient.
 * 
 * 
 * 
 * If there is no solution for the equation, return "No solution".
 * 
 * 
 * If there are infinite solutions for the equation, return "Infinite
 * solutions".
 * 
 * 
 * If there is exactly one solution for the equation, we ensure that the value
 * of x is an integer.
 * 
 * 
 * Example 1:
 * 
 * Input: "x+5-3+x=6+x-2"
 * Output: "x=2"
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "x=x"
 * Output: "Infinite solutions"
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: "2x=x"
 * Output: "x=0"
 * 
 * 
 * 
 * Example 4:
 * 
 * Input: "2x+3x-6x=x+2"
 * Output: "x=-1"
 * 
 * 
 * 
 * Example 5:
 * 
 * Input: "x=x+2"
 * Output: "No solution"
 * 
 * 
 */
class Solution {
    enum part {
        LEFT, RIGHT;
    }
    public static boolean isOperator (char ch) {
        return ch == '+' || ch == '-';
    } 
    public static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
    public String solveEquation(String equation) {
    // public static String solveEquation(String equation) {
        class equation {
            private String expression;
            private String leftPart;
            private String rightPart;
            private int coefficientOfX = 0;
            private int value = 0;
            private String result;
            equation(String e) {
                this.expression = e;
                int equalIndex = this.expression.indexOf('=');
                this.leftPart = this.expression.substring(0, equalIndex);
                this.rightPart = this.expression.substring(equalIndex + 1);
                cal(this.leftPart, part.LEFT);
                cal(this.rightPart, part.RIGHT);
                result();
            }
            public void cal(String s, part p) {
                int pre = (p == part.LEFT) ? 1 : -1;
                String str_num = "";
                int op = 1;
                for (int i = 0; i < s.length(); i++) {
                    char ch = s.charAt(i); 
                    if (ch == 'x') {
                        if (str_num == "" || str_num == "1") {
                            this.coefficientOfX += pre * op;
                        } else {
                            this.coefficientOfX += pre * op * Integer.valueOf(str_num);
                            str_num = "";
                        }
                    } else if (isOperator(ch)) {
                        if (str_num != "") {
                            this.value += pre * op * Integer.valueOf(str_num);
                            str_num = "";
                        }
                        op = (ch == '+') ? 1 : -1;
                    } else {
                        str_num += ch;
                    }
                }
                if (str_num != "") {
                    this.value += pre * op * Integer.valueOf(str_num);
                }
            }
            public void result() {
                if (this.coefficientOfX == 0 && this.value == 0) {
                    this.result = "Infinite solutions";
                } else if (this.coefficientOfX == 0 && this.value != 0) {
                    this.result = "No solution";
                } else {
                    this.result = "x=" + (-this.value / this.coefficientOfX);
                }
            }
        }
        equation e = new equation(equation);
        return e.result;  
    }
    // public static void main(String[] args) {
    //     System.out.println(solveEquation("-12x+12+2x=22+x-x"));
    // }
}
