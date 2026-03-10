#https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

'''
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
'''

def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        
        result = []
        dict = {
            '2' : ["a","b","c"],
            '3' : ["d","e","f"],
            '4' : ["g","h","i"],
            '5' : ["j","k","l"],
            '6' : ["m","n","o"],
            '7' : ["p","q","r","s"],
            '8' : ["t","u","v"],
            '9' : ["w","x","y","z"]
        }

        #base case
        if (len(digits) == 1):
            return dict[digits]

        for i, c in enumerate(digits):
            for letter in dict[c]:
                subList = self.letterCombinations(digits[(i+1):])
                for j in subList:
                    result.append(letter + j) if len(letter+j) == len(digits) else None
            

        return result
