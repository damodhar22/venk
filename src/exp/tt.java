package exp;

import java.util.*;

public class tt {



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
        Map<String, Set<String>> courseToStudents = new HashMap<>();

        // Iterate through each student and their courses
        for (Map.Entry<String, Set<String>> entry : studentsCourses.entrySet()) {
            String student = entry.getKey();
            Set<String> courses = entry.getValue();

            // Update courseToStudents map
            for (String course : courses) {
                courseToStudents.computeIfAbsent(course, k -> new HashSet<>()).add(student);
            }
        }

        // Find shared courses for each pair of students
        for (Map.Entry<String, Set<String>> entry : studentsCourses.entrySet()) {
            String student = entry.getKey();
            Set<String> courses = entry.getValue();

            for (String course : courses) {
                Set<String> studentsWithSameCourse = courseToStudents.get(course);

                if (studentsWithSameCourse.size() > 1) {
                    Set<String> sharedCoursesSet = new HashSet<>(courses);
                    sharedCoursesSet.retainAll(studentsCourses.get(student));

                    if (!sharedCoursesSet.isEmpty()) {
                        String[] pair = {student, String.join(", ", studentsWithSameCourse)};
                        sharedCourses.put(pair, sharedCoursesSet);
                    }
                }
            }
        }

        return sharedCourses;
    }
}
