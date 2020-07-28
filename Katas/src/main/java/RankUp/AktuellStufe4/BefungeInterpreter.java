package RankUp.AktuellStufe4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Stack;

public class BefungeInterpreter {
        private final Stack<String> stack=new Stack<>();
        private Integer breakingPoint=0;
        private ArrayList<ArrayList<String>> field=new ArrayList<>();

    public String interpret(String code) {
        fieldCreation(code);
        stackFilling();

        //stack.pop();S
        String ausgabe="";
        while(!stack.empty()){
            String interpreter=stack.pop();
            ausgabe+=handle(interpreter);
        }
        return ausgabe;
    }

    private void stackFilling() {
        Boolean moveUp=false,moveDown=false,moveBack=false,moveForeward=true;
        Integer positionX=0,positionY=0, durchlAufCounter=0;

        while(!positionX.equals(field.size())&&!positionY.equals(field.get(positionX).size())){
            String aktuellesZeichen=field.get(positionX).get(positionY);

            if(aktuellesZeichen.equals("@")){
                return;
            }

            stack.push(aktuellesZeichen);

            if(aktuellesZeichen.equals(">")){
                moveUp=moveDown=moveBack=moveForeward=false;
                moveForeward=true;
            }
            else if(aktuellesZeichen.equals("<")){
                moveUp=moveDown=moveBack=moveForeward=false;
                moveBack=true;
            }
            else if(aktuellesZeichen.equals("^")){
                moveUp=moveDown=moveBack=moveForeward=false;
                moveUp=true;
            }
            else if(aktuellesZeichen.equals(("v"))){
                moveUp=moveDown=moveBack=moveForeward=false;
                moveDown=true;
            }
            if(moveForeward){
                if(positionY==field.get(positionX).size()-1){
                    positionX++;
                    positionY=0;
                }
                else {
                    positionY++;
                }
            }
            else if(moveBack){
                if(positionY==0){
                    positionX--;
                    positionY=field.get(positionX).size();
                }
                else {
                    positionY++;
                    positionY--;
                }
            }
            else if(moveDown){
                positionX++;
            }
            else if(moveUp){
                positionX--;
            }
        }
        System.out.println(durchlAufCounter+" "+field.size());
        durchlAufCounter++;
    }

    private void fieldCreation(String code) {
        ArrayList<String> line=new ArrayList<>();
        for(int i=0;i<code.length();i++){
            line.add(String.valueOf(code.charAt(i)));
            if(code.charAt(i)=='\n'){
                field.add(line);
                line=new ArrayList<>();
            }
        }
        field.add(line);
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
