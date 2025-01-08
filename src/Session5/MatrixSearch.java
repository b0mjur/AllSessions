package Session5;

import java.util.Random;
import java.util.Scanner;

public class MatrixSearch {
    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.print(r.nextInt(20) + " ");
        }
        System.out.println();

        // Create a matrix of 4x4 using random
        int[][] matrix = new int[4][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = r.nextInt(20);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Ask user to provide a number
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number to search for: ");
        int searchFor = scanner.nextInt();
        scanner.close();

        boolean found = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == searchFor) {
                    matrix[i][j] = -10;
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Number not found!");
        }

        System.out.println("Modified matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
