https://leetcode.com/problems/generate-parentheses/description/
/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
*/

public static List<String> generateParenthesis(int n) {
    long st = System.currentTimeMillis();
    List<String> result = new ArrayList<>();
    
    // Base cases
    if (n == 0) {
        return Arrays.asList("");
    }
    if (n == 1) {
        return Arrays.asList("()");
    }
    
    // Recursive case: try all possible splits
    // A valid parentheses string can be represented as (A)B
    // where A and B are valid parentheses strings
    for (int i = 0; i < n; i++) {
        // i = number of pairs inside the outer parentheses
        // n-1-i = number of pairs after the outer parentheses
        for (String inside : generateParenthesis(i)) {
            for (String after : generateParenthesis(n - 1 - i)) {
                result.add("(" + inside + ")" + after);
            }
        }
    }
    
    long et = System.currentTimeMillis();
    System.out.println("Time taken for n = " + n + ": " + (et-st) + "ms. Count: " + result.size());
    return result;
}
