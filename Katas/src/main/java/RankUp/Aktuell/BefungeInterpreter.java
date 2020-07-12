package RankUp.Aktuell;

import java.util.Queue;
import java.util.Stack;
import java.util.stream.Stream;

public class BefungeInterpreter {
        private final         Stack<String> stack=new Stack<>();
    public String interpret(String code) {
        for(Character character:code.toCharArray()){
            stack.push(String.valueOf(character));
        }

        //stack.pop();S
        String ausgabe="";
        while(!stack.empty()){
            String interpreter=stack.pop();
            ausgabe+=handle(interpreter);
        }
        return ausgabe;
    }

    private String handle(String interpreter) {
        if(interpreter.equals("+")){
            Integer a= Integer.valueOf(stack.pop());
            Integer b= Integer.valueOf(stack.pop());
            stack.push(String.valueOf(a+b));
        }
        else if(interpreter.equals("-")){
            Integer a= Integer.valueOf(stack.pop());
            Integer b= Integer.valueOf(stack.pop());
            stack.push(String.valueOf(b-a));
        }
        else if(interpreter.equals("*")){
            Integer a= Integer.valueOf(stack.pop());
            Integer b= Integer.valueOf(stack.pop());
            stack.push(String.valueOf(b*a));
        }
        else if(interpreter.equals("/")){
            Integer a= Integer.valueOf(stack.pop());
            Integer b= Integer.valueOf(stack.pop());
            if(a.equals(0)) return "0";
            stack.push(String.valueOf(b/a));
        }
        else if(interpreter.equals("%")){
            Integer a= Integer.valueOf(stack.pop());
            Integer b= Integer.valueOf(stack.pop());
            if(a.equals(0)){
                stack.push("0");
                return "";
            }
            stack.push(String.valueOf(b%a));
        }
        else if(interpreter.equals("!")){
            Integer a= Integer.valueOf(stack.pop());
            if(a.equals(0)) {
                stack.push("1");
                return "";
            }
            stack.push("0");
        }
        else if(interpreter.equals("`")){
            Integer a= Integer.valueOf(stack.pop());
            Integer b= Integer.valueOf(stack.pop());
            if(a>b) {
                stack.push("0");
                return "";
            }
            stack.push("1");
        }
        else {
            return interpreter;
        }
        return "";
    }


}
