//https://www.hackerrank.com/challenges/reduced-string/problem?isFullScreen=true

/*
Reduce a string of lowercase characters in range ascii[‘a’..’z’]by doing a series of operations. 
In each operation, select a pair of adjacent letters that match, and delete them.
Delete as many characters as possible using this method and return the resulting string. If the final string is empty, return Empty String
*/

public static String superReducedString(String s) {
        // Write your code here
        String result = s;//s
        //Add while loop
        Pattern pattern = Pattern.compile("(.)\\1");//Two
        Matcher match = pattern.matcher(result);
        while(match.find()){
            //System.out.print(" ||initial_result --> "+ result);
            result = result.replaceAll("(.)\\1", "");
            //System.out.print(" final_result --> "+ result + " ||");
            match = pattern.matcher(result);
        }
        return !result.equals("") ? result : "Empty String";
    }
