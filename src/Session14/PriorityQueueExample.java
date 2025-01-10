package Session14;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {

        Comparator<Task> taskComparator = (t1, t2) -> Integer.compare(t2.priority, t1.priority);

        PriorityQueue<Task> taskQueue = new PriorityQueue<>();

        taskQueue.add(new Task("Prepare queue topic", 3));
        taskQueue.add(new Task("Important", 1));
        taskQueue.add(new Task("Meeting", 5));
        taskQueue.add(new Task("Code review", 4));

        while (!taskQueue.isEmpty()) {
            Task t = taskQueue.poll();
            System.out.println(t.toString());
        }
    }
}
