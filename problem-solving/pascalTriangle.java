public class PascalTriangle {
    public ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(A == 0) return result;
        
        for(int level = 0; level < A; level++) {
            result.add(new ArrayList<Integer>());
            result.get(level).add(1);
            if(level - 1 >= 0) {
                for(int i = 1; i < result.get(level - 1).size(); i++) {
                    int sum = result.get(level-1).get(i) + result.get(level-1).get(i-1);
                    result.get(level).add(sum);
                }
                result.get(level).add(1);
            }
        }
        return result;
    }
}