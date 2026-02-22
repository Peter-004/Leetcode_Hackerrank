/*
https://leetcode.com/problems/string-to-integer-atoi/description/
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
*/

/**
 * @param {string} s
 * @return {number}
 */
var myAtoi = function(s) {
    const INT_MIN = -Math.pow(2, 31); // -2147483648
    const INT_MAX = Math.pow(2, 31) - 1; // 2147483647
    let i = 0;
    let n = s.length;
    let sign = 1;
    let result = 0;

    //Ignore leading whitespace
    while (i < n && s[i] === ' ') {
        i++;
    }

    //Handle signedness
    if (i < n && (s[i] === '+' || s[i] === '-')) {
        sign = (s[i] === '-') ? -1 : 1;
        i++;
    }

    //Conversion
    while (i < n && s[i] >= '0' && s[i] <= '9') {
        const digit = s[i].charCodeAt(0) - '0'.charCodeAt(0);

        // --- Check for overflow/underflow BEFORE adding the digit ---
        if (result > Math.floor((INT_MAX - digit) / 10)) {
            // Rounding: Return the appropriate limit based on sign
            return sign === 1 ? INT_MAX : INT_MIN;
        }

        // Build the number
        result = result * 10 + digit;
        i++;
    }

    // Apply the sign and return
    const finalResult = sign * result;
    
    // Clamp the result to the 32-bit range (though overflow check above should handle it)
    if (finalResult < INT_MIN) return INT_MIN;
    if (finalResult > INT_MAX) return INT_MAX;
    return finalResult;
};
