package Session6;

import java.util.ArrayList;

public class StringsArrayList {
    public static void main(String[] args) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("Artem");
        stringArrayList.add("Vlad");
        stringArrayList.add("Eugen");
        stringArrayList.add("Elena");
        stringArrayList.add("Geram");
        stringArrayList.add("Vitalii");
        stringArrayList.add("Nastia");

        System.out.println(stringArrayList);
        stringArrayList.remove(0);
        stringArrayList.remove("Eugen");
        System.out.println(stringArrayList);

        System.out.println(stringArrayList.size());
        System.out.println(stringArrayList.toArray().length);
    }
}
