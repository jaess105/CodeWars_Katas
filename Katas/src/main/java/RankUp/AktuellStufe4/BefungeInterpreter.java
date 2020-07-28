package RankUp.AktuellStufe4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;
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
    private void stackFilling() {
        Boolean moveUp=false,moveDown=false,moveLeft=false,moveRight=true;
        Integer positionX=0,positionY=0, durchlAufCounter=0;

        while(!positionX.equals(field.size())&&!positionY.equals(field.get(positionX).size())){
            String aktuellesZeichen=field.get(positionX).get(positionY);

            if(aktuellesZeichen.equals("@")){
                return;
            }
            if(aktuellesZeichen.equals("?")){
                String directions="<>^v";
                aktuellesZeichen= String.valueOf(directions.charAt((int)(Math.random()*4)));
            }
            if(aktuellesZeichen.equals("_")){
                Integer [] positions=getDirection(moveUp,moveDown,moveLeft,moveRight,new Integer [] {positionX,positionY} );
                aktuellesZeichen=field.get(positions[0]).get(positions[1]);
                field.get(positions[0]).remove((int)positions[1]);
                field.get(positions[0]).add(positions[1]," ");
                moveUp=moveDown=moveLeft=moveRight=false;
                if(aktuellesZeichen.equals("0")){
                    moveRight=true;
                }
                else {
                    moveLeft=true;
                }
            }
            else{
                stack.push(aktuellesZeichen);
            }

            if(aktuellesZeichen.equals(">")){
                moveUp=moveDown=moveLeft=moveRight=false;
                moveRight=true;
            }
            else if(aktuellesZeichen.equals("<")){
                moveUp=moveDown=moveLeft=moveRight=false;
                moveLeft=true;
            }
            else if(aktuellesZeichen.equals("^")){
                moveUp=moveDown=moveLeft=moveRight=false;
                moveUp=true;
            }
            else if(aktuellesZeichen.equals(("v"))){
                moveUp=moveDown=moveLeft=moveRight=false;
                moveDown=true;
            }

            Integer [] positions=getDirection(moveUp,moveDown,moveLeft,moveRight,new Integer [] {positionX,positionY} );
            positionX=positions[0];
            positionY=positions[1];
        }
        System.out.println(durchlAufCounter+" "+field.size());
        durchlAufCounter++;
    }

    private Integer[] getDirection(Boolean moveUp, Boolean moveDown, Boolean moveLeft, Boolean moveRight, Integer[] positions) {
        Integer positionX=positions[0], positionY=positions[1];
        if(moveRight){
            if(positionY==field.get(positionX).size()-1){
                positionX++;
                positionY=0;
            }
            else {
                positionY++;
            }
        }
        else if(moveLeft){
            if(positionY==0){
                positionX--;
                positionY=field.get(positionX).size();
            }
            else {
                positionY--;
            }
        }
        else if(moveDown){
            positionX++;
        }
        else if(moveUp){
            positionX--;
        }
        return new Integer [] {positionX,positionY};
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
