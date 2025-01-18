package Session16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
     List<Integer> list1 = new ArrayList<>();
     list1.add(1);
     list1.add(3);
     list1.add(5);

    // Second list of integers
    List<Integer> list2 = new ArrayList<>();
    list2.add(2);
    list2.add(4);
    list2.add(6);

        System.out.println(list(list1, list2));
    }

    public static List<Integer> list (List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();
        result.addAll(list1);
        result.addAll(list2);

         Collections.sort(result);
        return result;
    }
}
