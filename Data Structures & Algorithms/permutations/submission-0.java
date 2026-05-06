class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // Iterative method
        List<List<Integer>> perms = new ArrayList<>();
        perms.add(new ArrayList<>());

        for(int n : nums){
            List<List<Integer>> permsCopy = new ArrayList<>();

            for(List<Integer> p : perms){
                for(int index = 0; index < p.size() + 1; index++){
                    List<Integer> pCopy = new ArrayList<>();
                    pCopy.addAll(p);
                    pCopy.add(index, n);
                    permsCopy.add(pCopy);
                }
            }
            perms = permsCopy;
        }

        return perms;
    }
}
