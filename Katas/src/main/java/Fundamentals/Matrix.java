package Fundamentals;

/**
 * This is the second member of a series of three katas about matrices.
 *
 * In the previous kata, we have familiarized ourselves with the basic concept
 * of the matrix and wrote some methods for accessing and manipulating the elements of the matrix.
 * Now we are going to focus on the operations we can perform on matrices.
 * For now, we will stick onto matrices containing numbers though.
 *
 * Task
 * Your task now is to implement the class Matrix, featuring several operations on matrices like adding and multiplying.
 * The class should represent an immutable matrix object, meaning that neither its size nor its elements are subject to change.
 *
 * The Matrix() constructor takes a two-dimensional array of numbers,
 * which represents the structure of the matrix: the i-th element of the input array stores the elements in the i-th row of the matrix.
 * Invalid array inputs (such as empty arrays, or arrays with sub-arrays of different lengths) should be properly handled,
 * in the form of throwing an IllegalArgumentException when necessary.
 *
 * You should also be able to create another constructor,
 * taking two integers, the number of rows and columns in the matrix,
 * and an only one-dimensional array (varargs) of double values representing the elements in the matrix,
 * from left to right and top to bottom. (So if the matrix is of type m x n,
 * then the first set of n values in the array are the elements in the first row of the matrix,
 * the second set of n values represent the next row etc., up until the m-th set.)
 * Also, don't forget to check for input validity.
 *
 * The methods are the following:
 *
 * The transpose method returns a new Matrix object representing a matrix with the rows and columns of this matrix swapped.
 *
 * The add method takes another Matrix and returns a new one that is the sum of is this matrix and the one provided as the argument.
 * The rules of matrix addition are the following:
 * the sum of matrix A and matrix B is the matrix A + B,
 * where every element of A + B is obtained by adding the corresponding values in the addends.
 * The definition implies that matrix addition is only possible if the matrices A and B are of the same types
 * (have the same number of rows and columns).
 * If this not the case, throw an IllegalArgumentException.
 *
 * The multiply method has two overloads:
 * one taking a number, the other taking a Matrix as an argument.
 *
 * The first method is for scalar multiplication, which simply multiplies every element of the matrix with the given number.
 *
 * The second one is more exciting. It is for matrix multiplication, which is defined as follows:
 * the product of an m x n matrix A and an n x k matrix B is the m x k matrix AB,
 * in which the element at a given (i, j) position is the scalar product of the i-th row of A and the j-th column of B.
 * The scalar product of two vectors (matrices with one row or column) is the sum of the products of the corresponding elements
 * (being at positions (i, k) and (k, j)).
 *
 * I also added a toArray method which you need to fill in,
 * which returns the elements in the matrix in the form of a two-dimensional array of double values.
 * An example of matrix-matrix multiplication:
 *
 *                ( 9,  8,  7 )
 *                ( 6,  5,  4 )
 *                ( 3,  2,  1 )
 *
 * ( 1,  2,  3 )  (30, 24, 18)
 * ( 4,  5,  6 )  (84, 69, 54)
 * ( 7,  8,  9 )  (138,114,90)
 * where the top-left element (30) was obtained by the following computation: 30 = 1 * 9 + 2 * 6 + 3 * 3.
 * If the above doesn't make sense, check matrix multiplication on wikipedia for example.
 *
 * See the test cases for suggested usage.
 */
public class Matrix {
    private final double [][] matrix;
    public Matrix(double[][] elements) {
        matrix = elements;
        // TODO: Write constructor
    }

    public Matrix(int rows, int cols, double... elements) {
        matrix = new double[rows][cols];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                matrix[i][j]=elements[i*matrix[0].length+j];
            }
        }
    }

    public Matrix transpose() {
        int row = this.matrix[0].length;
        int col= this.matrix.length;
         double [][] m1 = new double [row][col];
         for (int i=0; i<row;i++){
             for(int j=0;j<col;j++){
                 m1[i][j] = matrix [j][i];
             }
         }
         return new Matrix(m1);
    }

    public double[][] toArray() {
        return matrix;
    }

    // TODO: Add transpose, add, mutliply(double), multiply(Matrix)
}
