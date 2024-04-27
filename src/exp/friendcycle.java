package exp;
import java.util.*;
public class friendcycle {

    public static void main(String[] args) {

        String[][] employees = {
                {"1","Bill", "Engineer"},
                {"2", "Joe", "HR"},
                {"3", "Sally", "Engineer"},
                {"4", "Richard", "Business"},
                {"6", "Tom", "Engineer"}};
        String[][] friendships = {
                {"1", "2"},
                {"1", "3"},
                {"3", "4"}};

//        Friendship Sample Output: Basically adjacency matrix
//        Output:
//        1: 2, 3
//        2: 1
//        3: 1, 4
//        4: 3
//        6: None

        Map<String, Set<String>> res = new HashMap<>();

        for(String[] emp: employees){
            res.putIfAbsent(emp[0], new HashSet<>());
        }

        for (String[] frnd: friendships){
            res.get(frnd[0]).add(frnd[1]);
            res.get(frnd[1]).add(frnd[0]);
        }
        System.out.println(res);

        // Now for each department count the number of employees that have a friend in another department
//        Sample Output:
//        Output:
//        "Engineer: 2 "
//        "HR: 1"
//        "Business: 1 "
        Map<String, String> empDep = new HashMap();
        for(String[] emp: employees){
            empDep.putIfAbsent(emp[0], emp[2]);
        }
        Map<String, Integer> res2 = new HashMap<>();
        for (String e: res.keySet()){
            res2.putIfAbsent(empDep.get(e), 0);
           for (String s: res.get(e)){
               if(!empDep.get(s).equals(empDep.get(e))){
                   res2.put(empDep.get(e), res2.get(empDep.get(e))+1);
               }
           }
        }
        System.out.println(res2);

        // .Output if all the employees are in a same friend cycle.
    }
}


