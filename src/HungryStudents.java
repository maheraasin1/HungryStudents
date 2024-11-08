import java.util.Stack;
import java.util.LinkedList;

public class HungryStudents {
    public static void main(String[] args) {
        HungryStudentsTest();
    }

    public static int NumHungryStudents(Stack<Integer> sandwiches, LinkedList<Integer> students) {
        int rotations = 0; // Tracks consecutive rotations without matching a sandwich

        // Process until all sandwiches are matched or no further matches can be made
        while (!sandwiches.isEmpty() && rotations < students.size()) {
            // Check if the student at the front of the queue matches the sandwich
            if (students.peek() == sandwiches.peek()) {
                // Match found: Remove both the student and the sandwich
                sandwiches.pop();
                students.poll();
                rotations = 0; // Reset rotations after a match
            } else {
                // No match: Move the student to the back of the queue
                students.add(students.poll());
                rotations++;
            }
        }

        // Return the number of students remaining in the queue
        return students.size();
    }

    public static void HungryStudentsTest() {
        Stack<Integer> sandwiches = new Stack<>();
        LinkedList<Integer> students = new LinkedList<>();

        // Test Case 1: All students get sandwiches
        sandwiches.push(0);
        sandwiches.push(1);
        sandwiches.push(0);
        sandwiches.push(1);
        students.add(0);
        students.add(1);
        students.add(1);
        students.add(0);
        assert NumHungryStudents(sandwiches, students) == 0;

        // Test Case 2: None of the students want the sandwiches
        sandwiches.clear();
        students.clear();
        sandwiches.push(1);
        sandwiches.push(1);
        sandwiches.push(0);
        students.add(1);
        students.add(1);
        students.add(1);
        assert NumHungryStudents(sandwiches, students) == 3;

        // Test Case 3: One student left without a match
        sandwiches.clear();
        students.clear();
        sandwiches.push(0);
        sandwiches.push(1);
        sandwiches.push(0);
        students.add(1);
        students.add(1);
        students.add(0);
        assert NumHungryStudents(sandwiches, students) == 1;

        // Test Case 4: Extra sandwiches available
        sandwiches.clear();
        students.clear();
        sandwiches.push(1);
        sandwiches.push(1);
        sandwiches.push(0);
        sandwiches.push(0);
        students.add(1);
        students.add(0);
        students.add(0);
        assert NumHungryStudents(sandwiches, students) == 0;

        // Test Case 5: Not enough sandwiches
        sandwiches.clear();
        students.clear();
        sandwiches.push(1);
        sandwiches.push(0);
        sandwiches.push(1);
        students.add(1);
        students.add(1);
        students.add(0);
        students.add(0);
        students.add(1);
        assert NumHungryStudents(sandwiches, students) == 2;

        System.out.println("All test cases passed!");
    }
}


