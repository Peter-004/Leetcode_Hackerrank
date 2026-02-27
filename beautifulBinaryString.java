//https://www.hackerrank.com/challenges/beautiful-binary-string/problem?isFullScreen=true

/*
Alice has a binary string. She thinks a binary string is beautiful
     if and only if it doesn't contain the substring 010. In one step, Alice can change a bit to another or vice versa.
     Count and print the minimum number of steps needed to make Alice see the string as beautiful.
*/

public static int beautifulBinaryString(String b) {
        // Write your code here
        int result = 0;
        Pattern pattern = Pattern.compile("010");
        Matcher match = pattern.matcher(b);
        int startIndex, endIndex = 0;

        while(match.find()){
            startIndex = match.start();
            endIndex =  match.end();
            b = b.substring(0, endIndex-1) +
                    "1" + b.substring(endIndex);
            result++;
            match = pattern.matcher(b);
        }
        return result;
    }
