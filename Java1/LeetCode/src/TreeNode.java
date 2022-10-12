public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    //构造函数
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode addData(int[] data){
        //按完全二叉树插入数据, -99表示空节点位置,data长度>0
        TreeNode root = new TreeNode(data[0]);
        TreeNode[] queue = new TreeNode[10];
        TreeNode temp;
        int front = 0, rear = 0;
        queue[rear++] = root;
        for (int i=0; i*2+1<data.length; i++){
            temp = queue[front++];
            if (data[i*2+1]!=-99) {
                temp.left = new TreeNode(data[i*2+1]);
                queue[rear++] = temp.left;
            }
            if (i*2+2<data.length && data[i*2+2]!=-99) {
                temp.right = new TreeNode(data[i*2+2]);
                queue[rear++] = temp.right;
            }
        }
        return root;
    }


}
