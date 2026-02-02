//https://www.hackerrank.com/challenges/non-divisible-subset/problem
/*
Given a set of distinct integers, print the size of a maximal subset of 
S where the sum of any 2 numbers in S′ is not evenly divisible by k.
*/
//Runtime error for larger sizes of list s. 
// Recursive algorithm to find all maximal cliques by deepseek AI
    public static void bronKerbosch(
            Set<Integer> R, Set<Integer> P, Set<Integer> X,
            List<Set<Integer>> cliques,
            List<Integer>[] adjList) {

        // If P and X are both empty, R is a maximal clique
        if (P.isEmpty() && X.isEmpty()) {
            cliques.add(new HashSet<>(R));
            return;
        }

        // Choose a pivot from P Union X for optimization
        Set<Integer> pivotSet = new HashSet<>(P);
        pivotSet.addAll(X);
        int pivot = pivotSet.iterator().next();

        // P \ N(pivot)
        Set<Integer> candidates = new HashSet<>(P);
        for (int neighbor : adjList[pivot]) {
            candidates.remove(neighbor);
        }

        // Try each candidate
        for (int v : new ArrayList<>(candidates)) {
            Set<Integer> newR = new HashSet<>(R);
            newR.add(v);

            // P Intersect N(v)
            Set<Integer> newP = new HashSet<>();
            for (int neighbor : adjList[v]) {
                if (P.contains(neighbor)) {
                    newP.add(neighbor);
                }
            }

            // X INTERSECT N(v)
            Set<Integer> newX = new HashSet<>();
            for (int neighbor : adjList[v]) {
                if (X.contains(neighbor)) {
                    newX.add(neighbor);
                }
            }

            bronKerbosch(newR, newP, newX, cliques, adjList);

            // Move v from P to X
            P.remove(v);
            X.add(v);
        }
    }

    // Find all maximal cliques in the graph
    public static List<Set<Integer>> findAllMaximalCliques(List<Integer>[] adjList, int n) {
        List<Set<Integer>> cliques = new ArrayList<>();
        Set<Integer> P = new HashSet<>();
        Set<Integer> X = new HashSet<>();

        // Initialize P with all nodes
        for (int i = 0; i < n; i++) {
            P.add(i);
        }

        bronKerbosch(new HashSet<>(), P, X, cliques, adjList);
        return cliques;
    }
    public static int nonDivisibleSubset(int k, List<Integer> s){
        /*
         * gOING THROUGH EVERY POSSIBLE combinations is nC1 + nC2+ ...+ nCn possibilities.
         * Summation nCr r=1 to r = n,
         * which is 2^n possible ways. No good
         * */

        //Use graphs with index as nodes instead of actual values since duplicates arouses issues.
        List<Integer>[] adjList = new ArrayList[s.size()];
        for(int index = 0;index<s.size()-1;index++){
            if(adjList[index] == null)adjList[index] = new ArrayList<>();
            int i = s.get(index);
            for(int j = index+1;j<s.size();j++){
                if(adjList[j] == null)adjList[j] = new ArrayList<>();
                if((i + s.get(j)) % k != 0){
                    adjList[index].add(j);
                    adjList[j].add(index);
                }
            }
        }

        List<Set<Integer>> cliques = findAllMaximalCliques(adjList, s.size());
        int maxSize = cliques.stream()
                .mapToInt(Set::size)
                .max()
                .orElse(0);
        //System.out.println(cliques + "-maxsize->" +maxSize);
        return maxSize;
    }
