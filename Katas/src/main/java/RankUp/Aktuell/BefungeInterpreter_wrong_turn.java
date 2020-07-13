package RankUp.Aktuell;

import java.util.Stack;

public class BefungeInterpreter_wrong_turn {
        private final Stack<String> stack=new Stack<>();
        private String [][] array=new String[100][100];
        private Integer xPointer=0,yPointer=0;
    public String interpret(String code) {
        /*Integer xLength=0;
        Integer yLength=1;
        for(Character character:code.toCharArray()){
            xLength++;
            if(character.equals('\n')){
                yLength=code.length()/xLength;
                array=new String[xLength][yLength];
            }
        }*/
        for(Character character:code.toCharArray()){
            if(character=='\n'){
                xPointer++;
                yPointer=0;
            }
            array[xPointer][yPointer]= String.valueOf(character);
            yPointer++;
        }
        xPointer=yPointer=0;
        String ausgabe="";
        for (;xPointer<array[0].length;xPointer++){
            for(;yPointer<array.length;yPointer++) {
                String interpreter = array[xPointer][yPointer];
                ausgabe += handle(interpreter);
            }
        }
        /*
        while(!stack.empty()){
            String interpreter=stack.pop();
            ausgabe+=handle(interpreter);
        }
        */
        return ausgabe;
    }

    private String handle(String toInterpret) {
        String instructionsWithTwoPops="+-*/%`";
        String instructionsWithOnePop="!";
        String noNewValue="<>v^\n ";
        //a and b are initilized so the Compiler shuts up
        Integer a=0,b=0;
        if (instructionsWithTwoPops.contains(toInterpret)){
            a= Integer.valueOf(stack.pop());
            b= Integer.valueOf(stack.pop());
        }
        else if(instructionsWithOnePop.contains(toInterpret)){
            a= Integer.valueOf(stack.pop());
        }
        else if(noNewValue.contains(toInterpret)){
            return "";
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
