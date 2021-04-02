package Fundamentals;
/*
Welcome. In this kata, you are asked to square every digit of a number and concatenate them.
For example, if we run 9119 through the function, 811181 will come out, because 92 is 81 and 12 is 1.
Note: The function accepts an integer and returns an integer
https://www.codewars.com/kata/546e2562b03326a88e000020/train/java
https://www.codewars.com/kata/546e2562b03326a88e000020/solutions
 */


import static java.util.stream.Collectors.joining;

public class SquareDigit {
    public int squareDigits(int n) {
        return Integer.parseInt(  //The endproduct is a String because we need to join the integers and not add them
                String.valueOf(n)  //converting to String to stream over every singel digit
                        .chars()  //a Integer Stream of the Char value
                        .mapToObj(x->String.valueOf((int)Math.pow((x-48),2))) //48 must be subtracted from x because x is the char representation. Then it is risen by the power oft 2
                        .collect(joining())); //collecting every risen number by conncating them in one String
    }
}
