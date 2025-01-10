package Session14;

import java.util.HashSet;

public class HashSetTask {
    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 4, 5, 1 };
        HashSet<Integer> numSet = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            boolean added = numSet.add(numbers[i]);

            if (!added) {
                System.out.println("Duplicate found " + numbers[i]);
            }
        }
    }
}
