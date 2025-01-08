package Session6;

import java.util.ArrayList;

public class ArrayListEx {
    public static void main(String[] args) {
        int [] intArray = new int[5];
        ArrayList<Integer> intArrayList = new ArrayList<>();
        intArrayList.add(10);
        intArrayList.add(20);
        System.out.println(intArrayList);
        intArrayList.add(1, 15);
        System.out.println(intArrayList);
        intArrayList.remove(0);
        System.out.println(intArrayList);

    }
}
