package optional.palindrome_bracketscheck;

import java.util.*;

public class Check {
    private String str;

    public Check(String str) {
        this.str = str;
    }

    public boolean checkPalindrome(){
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        char[] charArr = str.toCharArray();
        for (char c : charArr) {
            stack.push(c);
            queue.add(c);
        }

        while (!stack.isEmpty()){
            if (!stack.pop().equals(queue.poll())){
                return false;
            }
        }

        return true;
    }

    public boolean checkBrackets(){
        Stack<Character> stack = new Stack<>();

        for (char sym : str.toCharArray()) {
            if (sym == '('){
                stack.push(sym);
            }else if (sym == ')'){
                if (stack.isEmpty()){
                    return false;
                }

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
