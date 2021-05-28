package optional.convertbase;

import java.util.Stack;

public class Convert {

    public String convertDecToBin(int dec){
        Stack<Integer> binStack = new Stack<>();
        StringBuilder bin= new StringBuilder();

        while (dec !=0){
            binStack.push(dec%2);
            dec = dec/2;
        }

        while (!binStack.isEmpty()){
            bin.append(binStack.pop());
        }

        return String.valueOf(bin);
    }
}
