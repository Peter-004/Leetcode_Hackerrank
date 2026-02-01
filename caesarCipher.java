//https://www.hackerrank.com/challenges/caesar-cipher-1
/*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */
    public static boolean isEnglishAlphabet(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    public static String caesarCipher(String s, int k) {
        // Write your code here
        //(char) ('A' + number - 1);letter - 'A' + 1 88 120
        String ans = "";
        //Reduce with mod
        k = k % 26;
        for(int i = 0; i < s.length();i++){
            char c = s.charAt(i);
            if(isEnglishAlphabet(c)){
                boolean isUpper = Character.isUpperCase(c);
                if(!isUpper && (int) c >= 122 - k + 1){
                    char t = (char) (c % (122-k+1) + 'a');
                    ans += t;
                }
                else if(isUpper && (int) c >= 90 - k + 1){
                    char t = (char) (c % (90-k+1) + 'A');
                    ans += t;
                }
                else{
                    ans += (char) (c + k);
                }
            }
            else{
                ans += c;
            }
        }
        return ans;
    }
