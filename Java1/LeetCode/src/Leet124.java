public class Leet124 {

    int maxsum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getGain(root);
        return maxsum;
    }
    public int getGain(TreeNode node){
        if (node == null) return 0;
        //遍历左树
        int leftGain = Math.max(getGain(node.left), 0);
        //遍历右树
        int rightGain = Math.max(getGain(node.right), 0);
        //更新最大和
        maxsum = Math.max(node.val + leftGain + rightGain, maxsum);
        //返回本结点值+子树中大的一个作为上一层的子树最大和
        return node.val + Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {
        int[] data = {-10, 9, 20, -99, -99, 15, 7};
        TreeNode root = new TreeNode().addData(data);
        Leet124 solution = new Leet124();
        System.out.println("maxsum:" + solution.maxPathSum(root));
    }

}
