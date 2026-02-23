/** https://leetcode.com/problems/regular-expression-matching/description/
     * Given an input string s and a pattern p, implement regular expression matching with support for '.'
     * and '*' where:
     * '.' Matches any single character.
     * '*' Matches zero or more of the preceding element.
     * @param s the string in question
     * @param p the string pattern
     * @return a boolean indicating whether the matching covers the entire input string (not partial).
     */
    public static boolean isMatch(String s, String p){
        boolean match = false;
        if(p.contains("*") || p.contains(".")){
            char prev = '*';
            char nextChar;
            int index = -1; //index of the string
            int i = 0;
            while(i<p.length()){
                char c = p.charAt(i);
                nextChar = (i < p.length()-1) ? p.charAt(i+1) : ' ';//if p has a next
                //Read the pattern then match
                if(c == '.'){
                    if(nextChar != '*'){//then it's for the * rule
                        index = (index < s.length()-1) ? index + 1 : -1;//Update index of s
                        if(index >= 0 && Character.isLetter(s.charAt(index))){
                            match = Character.isLetter(s.charAt(index));
                        }
                        else{
                            return false;
                        }
                    }
                }
                else if(c == '*'){ //Handle Cases appropriately
                    if(prev == '.'){
                        // For .*, match any sequence of characters (zero or more)
                        if (index < s.length() - 1) {
                            // Match the rest of the string (greedy approach)
                            index = s.length() - 1;
                            match = true;
                        }
                        // If index is already at the end, zero match is fine
                        match = true;
                    }
                    else if(prev != '*'){// if '*', invalid pattern since nothing precedes '*'
                        // Handle a* pattern (zero or more of prev character)

                        // First, try zero matches - do nothing to index
                        boolean zeroMatch = true;

                        // Then try to match as many as possible
                        int originalIndex = index;
                        int newIndex = index;

                        // Count consecutive prev characters in s starting from current position
                        while (newIndex + 1 < s.length() && s.charAt(newIndex + 1) == prev) {
                            newIndex++;
                        }

                        if (newIndex > originalIndex) {
                            // We found matches
                            index = newIndex;
                            match = true;
                        } else {
                            // No matches found, keep zero match
                            // index stays the same
                            match = true; // Zero matches is valid
                        }
                    }
                    else{
                        return false;//invalid pattern sequence
                    }
                }
                else{ //alphabets
                    if(nextChar != '*'){//then it's for the * rule
                        index = (index < s.length()-1) ? index + 1 : -1;//Update index of s
                        if(index >= 0 && s.charAt(index) == c){
                            match = s.charAt(index) == c;
                        }
                        else{
                            return false;
                        }
                    }
                }
                i++;
                prev = c;//update previous character
            }
            //Final check, if we still have some string unchecked at the end
            if(index < s.length()-1)return false; // we are not on the last char of s when we finished pattern.
            return match;
        }
        return s.equals(p);
    }
