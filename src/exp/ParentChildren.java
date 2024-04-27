package exp;
import java.util.*;
public class ParentChildren {
    /*Pt. 1 Suppose we have some input data describing a graph of relationships between
    parents and children over multiple generations.
    The data is formatted as a list of (parent, child) pairs,
    where each individual is assigned a unique integer identifier.
    For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:

    parentChildPairs = [  (1, 3), (2, 3), (3, 6), (5, 6),
            (5, 7), (4, 5), (4, 8), (8, 10)  ]
    Write a function that takes this data as input and returns two collections:
    one containing all individuals with zero known parents,
    and one containing all individuals with exactly one known parent.
            findNodesWithZeroAndOneParents(parentChildPairs) =>
            [ [1, 2, 4],    // Individuals with zero parents
            [5, 7, 8, 10] // Individuals with exactly one parent ]*/

    public static void main(String[] args) {
        String[][] parentChildPairs = {  {"1", "3"}, {"2", "3"},{"3", "6"}, {"5", "6"},
                {"5", "7"}, {"4", "5"}, {"4", "8"},{"8", "10"} };

        List<String> nop = new ArrayList<>();
        List<String> onep = new ArrayList<>();
        Map<String, Integer> noOfAnc = new HashMap<>();
        for(String[] pair: parentChildPairs){
            noOfAnc.put(pair[0], noOfAnc.getOrDefault(pair[0],0));
            noOfAnc.put(pair[1], noOfAnc.getOrDefault(pair[1],0)+1);
        }
        for (String node: noOfAnc.keySet()){
            if(noOfAnc.get(node) == 0) nop.add(node);
            if(noOfAnc.get(node)== 1) onep.add(node);
        }
        System.out.println(nop);
        System.out.println(onep);
    }

    /*Pt.2 Write a function that takes the graph, as well as two of the
    individuals in our dataset, as its inputs and returns true if and
    only if they share at least one ancestor.
    Sample input and output: （input as same as last part）

    hasCommonAncestor(parentChildPairs, 3, 8) => false*/

    public static boolean commonAncestor2(int[][] pairs, int node1, int node2){
        Set<Integer> p1 = new HashSet<>(), p2 = new HashSet<>();
        help_commonAncestor2(p1, node1, pairs);
        help_commonAncestor2(p2, node2, pairs);
        for(int parent : p1){
            if(p2.contains(parent)) return true;
        }
        return false;
    }
    public static void help_commonAncestor2(Set<Integer> parents, int node, int[][] pairs){
        for(int[] pair : pairs){
            if(pair[1] == node){
                parents.add(pair[0]);
                help_commonAncestor2(parents, pair[0], pairs);
            }
        }
    }

    public static Map<String, Set<String>> adj_graph = new HashMap<>();
    public static String find_earliest_ancestor(String[][] parentChildPairs, String x) {


        for (String[] pair : parentChildPairs) {
            adj_graph.putIfAbsent(pair[1], new HashSet<>()).add(pair[0]);
            adj_graph.putIfAbsent(pair[0], new HashSet<>());

            if (!adj_graph.get(x).isEmpty()) {
                return "None";
            }

        }

        return null;//findEarliestAncestor(x);
    }

    public static Integer findEarliestAncestor(Map<Integer, List<Integer>> graph, int individual) {
        Set<Integer> visited = new HashSet<>();
        Stack<int[]> stack = new Stack<>();

        stack.push(new int[]{individual, 0}); // Pair of node and its distance from the individual

        int earliestAncestor = -1;
        int maxDistance = -1;

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int node = current[0];
            int distance = current[1];

            if (distance > maxDistance) {
                earliestAncestor = node;
                maxDistance = distance;
            }

            visited.add(node);

            List<Integer> parents = graph.get(node);

            if (parents != null) {
                for (int parent : parents) {
                    if (!visited.contains(parent)) {
                        stack.push(new int[]{parent, distance + 1});
                    }
                }
            }
        }

        // If the visited set is empty, it means the individual has no parents
        if (visited.isEmpty()) {
            return null;
        }

        return earliestAncestor;
    }

}
