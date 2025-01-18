package Session16;

public class Task1 {
    String[] strings = {"apple", "banana", "cherry", "fig", "grape"};

    public int binarySearchString(String[] array, String target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid].equals(target)) {
                return mid;
            } else if (array[mid].compareTo(target) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Task1 task = new Task1();
        String target1 = "cherry";
        String target2 = "kiwi";
        int index1 = task.binarySearchString(task.strings, target1);
        int index2 = task.binarySearchString(task.strings, target2);
        System.out.println("Index of " + target1 + ": " + index1);
        System.out.println("Index of " + target2 + ": " + index2);
    }
}