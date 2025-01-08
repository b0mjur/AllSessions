package Session5;

public class MatrixArray {
    public static void main(String[] args) {
        int[][] matrix = {
                {2, 5, 4},
                {9, 3, 5},
                {3, 7, 5}
        };

        // Call the methods to print the matrix and sum
        printMatrixWithFor(matrix);
        printMatrixForEach(matrix);
        printMatrixSum(matrix);
        printRowSum(matrix); // Call the printRowSum method
        rotateMatrix(matrix); // Call the rotateMatrix method
    }

    //create method to print matrix
    public static void printMatrixWithFor(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    //make it with a new method for each loop
    public static void printMatrixForEach(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    //create a method to print a sum of all integers in the matrix
    public static void printMatrixSum(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix) {
            for (int cell : row) {
                sum += cell;
            }
        }
        System.out.println("Sum of all integers in the matrix: " + sum);
    }

    // create sum of each row
    public static void printRowSum(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
            System.out.println("Sum of row " + i + ": " + sum);
        }
    }

    //rotate the matrix so array 0 will be in column 1 and so on
    public static void rotateMatrix(int[][] matrix) {
        int newMatrix[][] = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                newMatrix[j][i] = matrix[i][j];
            }
        }
        System.out.println("matrix:");
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
