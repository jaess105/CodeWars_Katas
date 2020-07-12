package RankUp.Aktuell;

import java.util.Stack;

public class BefungeInterpreter {
        private final Stack<String> stack=new Stack<>();
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

    private String handle(String toInterpret) {
        String instructionsWithTwoPops="+-*/%`";
        String instructionsWithOnePop="!";
        //a and b are initilized so the Compiler shuts up
        Integer a=0,b=0;
        if (instructionsWithTwoPops.contains(toInterpret)){
            a= Integer.valueOf(stack.pop());
            b= Integer.valueOf(stack.pop());
        }
        else if(instructionsWithOnePop.contains(toInterpret)){
            a= Integer.valueOf(stack.pop());
        }
        else {
            return toInterpret;
        }
        return operatorTranslation(toInterpret,a,b);
    }

    private String operatorTranslation(String toInterpret, Integer a, Integer b){
        if(toInterpret.equals("+")){
            stack.push(String.valueOf(a+b));
        }
        else if(toInterpret.equals("-")){
            stack.push(String.valueOf(b-a));
        }
        else if(toInterpret.equals("*")){
            stack.push(String.valueOf(b*a));
        }
        else if(toInterpret.equals("`")){
            if(a>b) {
                stack.push("0");
            } else {
                stack.push("1");
            }
        }
        else if(toInterpret.equals("!")){
            if(a.equals(0)) {
                stack.push("1");
            }else{
                stack.push("0");
            }
        }
        //After Refactoring it was obvious, that those two Methods make this question
        else if(a.equals(0)) {
            stack.push("0");
        }
        else if(toInterpret.equals("/")){
            stack.push(String.valueOf(b / a));
        }
        else if(toInterpret.equals("%")){
            stack.push(String.valueOf(b % a));
        }
        //End of those two
        else {
            return toInterpret;
        }
        return "";
    }


}
