<<<<<<< HEAD
/*
 * [166] Fraction to Recurring Decimal
 *
 * https://leetcode.com/problems/fraction-to-recurring-decimal/description/
 *
 * algorithms
 * Medium (18.60%)
 * Total Accepted:    74.3K
 * Total Submissions: 399.6K
 * Testcase Example:  '1\n2'
 *
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in
 * parentheses.
 * 
 * Example 1:
 * 
 * 
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 * 
 * Example 3:
 * 
 * 
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 * 
 * 
 */
/**
 * @param {number} numerator
 * @param {number} denominator
 * @return {string}
 */
var fractionToDecimal = function (numerator, denominator) {
    if (numerator == 0) {
        return '0';
    }
    let gcd = (function getGCD(a, b) {
        return b == 0 ? a : getGCD(b, a % b);
    })(numerator, denominator);
    numerator /= gcd;
    denominator /= gcd;
    let sign = (numerator / denominator) > 0 ? '' : '-';
    numerator = Math.abs(numerator);
    denominator = Math.abs(denominator);
    let test = denominator;
    while (test % 2 == 0) {
        test /= 2;
    }
    while (test % 5 == 0) {
        test /= 5;
    }
    if (test == 1) {
        return sign + (numerator / denominator);
    } else {
        let p = 1;
        numerator %= denominator;
        while ((10 ** p) % denominator != 1) {
            p++;
        }
        let repeat = String((Number.parseInt((10 ** p) / denominator) * numerator));
        repeat = '0'.repeat(p - repeat.length) + repeat;
        return sign + Number.parseInt(numerator / denominator) + '.(' + repeat + ')';
    }
};
=======
/*
 * [166] Fraction to Recurring Decimal
 *
 * https://leetcode.com/problems/fraction-to-recurring-decimal/description/
 *
 * algorithms
 * Medium (18.60%)
 * Total Accepted:    74.3K
 * Total Submissions: 399.6K
 * Testcase Example:  '1\n2'
 *
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in
 * parentheses.
 * 
 * Example 1:
 * 
 * 
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 * 
 * Example 3:
 * 
 * 
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 * 
 * 
 */
/**
 * @param {number} numerator
 * @param {number} denominator
 * @return {string}
 */
var fractionToDecimal = function (numerator, denominator) {
    if (numerator == 0) {
        return '0';
    }
    let gcd = (function getGCD(a, b) {
        return b == 0 ? a : getGCD(b, a % b);
    })(numerator, denominator);
    numerator /= gcd;
    denominator /= gcd;
    let sign = (numerator / denominator) > 0 ? '' : '-';
    numerator = Math.abs(numerator);
    denominator = Math.abs(denominator);
    let test = denominator;
    while (test % 2 == 0) {
        test /= 2;
    }
    while (test % 5 == 0) {
        test /= 5;
    }
    if (test == 1) {
        return sign + (numerator / denominator);
    } else {
        let p = 1;
        numerator %= denominator;
        while ((10 ** p) % denominator != 1) {
            p++;
        }
        let repeat = String((Number.parseInt((10 ** p) / denominator) * numerator));
        repeat = '0'.repeat(p - repeat.length) + repeat;
        return sign + Number.parseInt(numerator / denominator) + '.(' + repeat + ')';
    }
};
>>>>>>> a07c39f2ecee05469bc7938cd2530a4d83ca0284
