import java.util.Scanner;
import java.util.Stack;

/*
Given a string s of lower and upper case English letters.
A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1]
(where 0 <= i <= s.length - 2) and s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
To make the string good, you can choose two adjacent characters that make the string bad and remove them.
You can keep doing this until the string becomes good. Return the string after making it good. The answer is guaranteed to be unique under the given constraints.
Notice that an empty string is also good.

 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Input string:\n");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        System.out.println(makeGoodString(text));
    }
    //implementing using Stack
    public static String makeGoodString(String text) {
        Stack<Character> stack = new Stack<Character>(); //creating a stack to store characters of the given string
        int stringLength = text.length();
        if (text.isEmpty()) {
            return "(ALERT! STRING IS EMPTY)\n";
        } else {
            stack.push(text.charAt(0));
            for (int i = 1; i < stringLength; i++) {
                if(stack.empty()){ //if there are no elements in stack to compare, just push the character
                    stack.push(text.charAt(i));
                }
                else if (text.charAt(i) - 32 == stack.peek() || text.charAt(i) + 32 == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(text.charAt(i));
                }
            }
        }

        String goodText = "";
        String reverseText = "";

        int stackSize = stack.size();
        if(stackSize == 0){
            return "(EMPTY STRING!)";
        }
        for (int i = 0; i < stackSize; i++) {
            reverseText += stack.pop();
        }

        for (int i = stackSize - 1; i >= 0; i--) {
            goodText += reverseText.charAt(i);
        }
        return goodText;
    }
}