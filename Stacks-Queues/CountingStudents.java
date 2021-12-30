import java.util.*;

public class CountingStudents {
    public static void main(String[] args) {
        int[] students = {1, 1, 1, 0, 0, 1};
        int[] sandwiches = {1,0,0,0,1,1};
        System.out.println(countStudents(students, sandwiches));
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> s = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i : students) {
            q.add(i);
        }
        for (int i : sandwiches) {
            s.add(i);
        }
        int count = 0;
        int size = s.size();
        while (true) {
            if (s.isEmpty() && q.isEmpty()) {
                return 0;
            } else if (s.peek() == q.peek()) {
                s.remove();
                q.remove();
                count = 0;
                size = s.size();
            } else if (count == size) {
                return count;
            } else {
                q.add(q.remove());
                count++;
                for(int i : s)
                {
                    System.out.print(i + " ");
                }
                System.out.println(" ");
                for(int i : q)
                {
                    System.out.print(i + " ");
                }
                System.out.println(" ");
            }
        }
    }
}
