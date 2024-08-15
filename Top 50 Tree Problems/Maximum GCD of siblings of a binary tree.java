class Solution {
    static int maxBinTreeGCD(ArrayList<ArrayList<Integer>> arr, int N) {
        // Edge case: if there are less than 2 nodes, there are no siblings.
        if (N < 2) {
            return 0;
        }

        // Map to store parent node and list of its children
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        // Populate the map with the edges
        for (ArrayList<Integer> edge : arr) {
            int parent = edge.get(0);
            int child = edge.get(1);
            
            // If parent already has a list of children, add the child to the list
            if (map.containsKey(parent)) {
                map.get(parent).add(child);
            } else {
                // Otherwise, create a new list and add the child
                ArrayList<Integer> children = new ArrayList<>();
                children.add(child);
                map.put(parent, children);
            }
        }

        int maxGCD = 0;

        // Iterate through the map to find maximum GCD of sibling pairs
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            ArrayList<Integer> children = entry.getValue();
            
            // If there are at least two children, check their GCD
            if (children.size() > 1) {
                for (int i = 0; i < children.size() - 1; i++) {
                    for (int j = i + 1; j < children.size(); j++) {
                        int gcd = GCD(children.get(i), children.get(j));
                        maxGCD = Math.max(maxGCD, gcd);
                    }
                }
            }
        }

        return maxGCD;
    }

    // Helper function to calculate GCD of two numbers
    static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }
}