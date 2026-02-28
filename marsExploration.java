/*https://www.hackerrank.com/challenges/mars-exploration/problem?isFullScreen=true
     *A space explorer's ship crashed on Mars! They send a series of SOS messages to Earth for help.
     * Letters in some of the SOS messages are altered by cosmic radiation during transmission.
     * Given the signal received by Earth as a string,
     *  determine how many letters of the SOS message have been changed by radiation.
     */

public static int marsExploration(String s) {
        // Write your code here
        int count = 0;
        Character[] list = {'S', 'O', 'S'};
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) != list[i%3])count++;
        }
        return count;
    }
