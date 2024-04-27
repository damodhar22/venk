import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        // Sample data: Map representing students and their courses
        Map<String, Set<String>> studentsCourses = new HashMap<>();
        studentsCourses.put("Student1", Set.of("Math", "Physics", "Chemistry"));
        studentsCourses.put("Student2", Set.of("Physics", "History", "Biology"));
        studentsCourses.put("Student3", Set.of("Math", "Computer Science", "Chemistry"));
        studentsCourses.put("Student4", Set.of("Physics", "Computer Science", "Geography"));
        studentsCourses.put("Student5", Set.of("Chemistry", "Biology", "Geography"));

        // Find and print pairs of students sharing courses
        Map<String[], Set<String>> result = findSharedCourses(studentsCourses);

        for (Map.Entry<String[], Set<String>> entry : result.entrySet()) {
            String[] pair = entry.getKey();
            Set<String> sharedCourses = entry.getValue();
            System.out.printf("Students %s and %s share courses: %s%n",
                    pair[0], pair[1], String.join(", ", sharedCourses));
        }
    }

    // Function to find pairs of students sharing courses
    private static Map<String[], Set<String>> findSharedCourses(Map<String, Set<String>> studentsCourses) {
        Map<String[], Set<String>> sharedCourses = new HashMap<>();

        // Create a list of students and their courses
        List<Map.Entry<String, Set<String>>> studentsList = new ArrayList<>(studentsCourses.entrySet());

        // Iterate through each pair of students
        for (int i = 0; i < studentsList.size(); i++) {
            String student1 = studentsList.get(i).getKey();
            Set<String> courses1 = studentsList.get(i).getValue();

            for (int j = i + 1; j < studentsList.size(); j++) {
                String student2 = studentsList.get(j).getKey();
                Set<String> courses2 = studentsList.get(j).getValue();

                // Find common courses between the two students
                Set<String> commonCourses = new HashSet<>(courses1);
                commonCourses.retainAll(courses2);

                // Store the pair and their shared courses in the result map
                if (!commonCourses.isEmpty()) {
                    String[] pair = {student1, student2};
                    sharedCourses.put(pair, commonCourses);
                }
            }
        }

        return sharedCourses;
    }

}