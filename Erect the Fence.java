class Solution {
    public int[][] outerTrees(int[][] trees) {
        int[] start = trees[0];
        for(int i = 1; i < trees.length; i++){
            if(trees[i][0] < start[0]){
                start = trees[i];
            }
        }
        int[] cur = start;
        Set<int[]> set = new HashSet<>();
        set.add(start);
        List<int[]> coll = new ArrayList<>();
        while(true){
            int[] next = trees[0];
            for(int i = 1; i < trees.length; i++){
                if(trees[i].equals(cur)){
                    continue;
                }
                int val = crossProduct(cur, next, trees[i]);
                if(val > 0){
                    next = trees[i];
                    coll = new ArrayList<>();
                }else if(val == 0){
                    if(distance(cur, next, trees[i]) < 0){
                        coll.add(next);
                        next = trees[i];
                    }else{
                        coll.add(trees[i]);
                    }
                }
            }
            for(int[] x: coll){
                set.add(x);
            }
            if(next.equals(start)){
                break;
            }
            set.add(next);
            cur = next;
        }
        int n = set.size();
        int res[][] = new int[n][2];
        int i = 0;
        Iterator itr = set.iterator();
        while(itr.hasNext()){
            res[i] = (int[])itr.next();
            i++;
        }
        return res;
        
    }
    private int distance(int[] a, int[] b, int[] c){
        int y1 = a[1] - b[1];
        int y2 = a[1] - c[1];
        int x1 = a[0] - b[0];
        int x2 = a[0] - c[0];
        return Integer.compare(y1 * y1 + x1 * x1, y2 * y2 + x2 * x2);
    }
    private int crossProduct(int[] a, int[] b, int[] c){
        int y1 = a[1] - b[1];
        int y2 = a[1] - c[1];
        int x1 = a[0] - b[0];
        int x2 = a[0] - c[0];
        return y2 * x1 - y1 * x2;
    }
}