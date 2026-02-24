//https://leetcode.com/problems/plus-one/description/

/*
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. 
The digits are ordered from most significant to least significant in left-to-right order.
The large integer does not contain any leading 0's.
Increment the large integer by one and return the resulting array of digits.
*/

public static int[] plusOne(int[] digits) {
        int[] array = digits;
        int carry = 1;
        for(int i = array.length-1;i>=0;i--){
            if(array[i] + carry > 9){
                array[i] = 0;
                carry = 1;
            }
            else{
                array[i] += carry;
                carry = 0;
            }
        }
        if(carry == 1) {
            int[] newArray = new int[array.length + 1];
            newArray[0] = carry;
            System.arraycopy(array, 0, newArray, 1, array.length);
            return newArray;
        }
        return array;
    }
