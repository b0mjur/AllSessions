package Session13;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("One");
        list.add("Two");
        list.add("Three");

        //Get by index
        System.out.println("Element at index 1: " + list.get(1));

        // Delete element
        list.remove("Two");
        System.out.println("List is: " + list);

        for (String number : list) {
            System.out.println(number);
        }
    }
}
