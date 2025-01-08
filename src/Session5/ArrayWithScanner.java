package Session5;

import java.util.Scanner;

public class ArrayWithScanner {
    public static void main(String[] args) {
        //Using scanner accept number to search for
        //array = {24,54,67,54,32,33,47,39}

        Scanner scanner = new Scanner(System.in);
        int num[] = {24, 54, 67, 54, 32, 33, 47, 39};
        System.out.println("Enter a number to search: ");
        int search = scanner.nextInt();

        for(int i = 0; i < num.length; i++) {
            if (num[i] == search) {
                System.out.println("Number found at index: " + i);
                break;

            }
            scanner.close();
        }

        //create fibonacci sequence
        int n = 10;
        int fib[] = new int[n];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < n; i++) {

        }
        for (int i = 0; i < n; i++) {
            System.out.print(fib[i] + " ");
        }

    }
}
