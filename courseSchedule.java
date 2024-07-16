/*
Graph approach by converting tress to graph
make independent to depedent mapping and also keep the count of all incoming network

TC --> O(v+e)
Sc --> O(v+e)
 */
import java.util.*;

class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //we can make use of topological sort my creating a incoming edges
        if (prerequisites.length == 0) {
            return true;
        }
        int[] incoming = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int ind = prerequisites[i][1];

            int dep = prerequisites[i][0];
            incoming[dep]++;

            if (!map.containsKey(ind)) {
                map.put(ind, new ArrayList<>());
            }
            List<Integer> ls = map.get(ind);
            ls.add(dep);

        }//for
        System.out.print(map);
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        //Add all independent variables to Queue and count++
        for (int i = 0; i < incoming.length; i++) {
            if (incoming[i] == 0) {
                q.add(i);
                count++;
            }
        }//for

        while (!q.isEmpty()) {
            int node = q.poll();
            if (map.get(node) != null) {

                for (Integer val : map.get(node)) {
                    incoming[val]--;
                    if (incoming[val] == 0) {
                        q.add(val);
                        count++;

                        if (count == numCourses) {
                            return true;
                        }
                    }//if
                }//for

            }

        }//while

        return false;

    }
}
