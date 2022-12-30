/**
 * Ideas:Use a lot of IF to judge according to the topic.
 * Time complexity:O(1)
 * Space complexity:O(1)
 */
class Solution {
    int number = 0;
    public String intToRoman(int num) {
        // Store the num.
        number = num;
        // The ans is store to the final answer.
        StringBuilder ans = new StringBuilder();
        // Make the coversion.
        while (number != 0) {
            ans.append(getCharacter());
        }

        return ans.toString();
    }

    /**
     * Split the number step by step and convert them to Roman character.
     * @return The Roman characters
     */
    private String getCharacter() {
        if (number >= 1000) {
            number -= 1000;
            return "M";
        } else if (number >= 900) {
            number -= 900;
            return "CM";
        } else if (number >= 500) {
            number -= 500;
            return "D";
        } else if (number >= 400) {
            number -= 400;
            return "CD";
        } else if (number >= 100) {
            number -= 100;
            return "C";
        } else if (number >= 90) {
            number -= 90;
            return "XC";
        } else if (number >= 50) {
            number -= 50;
            return "L";
        } else if (number >= 40) {
            number -= 40;
            return "XL";
        } else if (number >= 10) {
            number -= 10;
            return "X";
        } else if (number >= 9) {
            number -= 9;
            return "IX";
        } else if (number >= 5) {
            number -= 5;
            return "V";
        } else if (number >= 4) {
            number -= 4;
            return "IV";
        }
        number -= 1;
        return "I";
    }
}