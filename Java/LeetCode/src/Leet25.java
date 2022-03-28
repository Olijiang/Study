public class Leet25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        ListNode[] ha = new ListNode[k];    //记录节点
        ListNode pre = null, rear = null;
        ListNode p = head, temp;
        boolean flag = true;
        while (flag) {
            int i;
            for (i = 0; i < k; i++) {
                if (p == null) flag = false;
                else {
                    ha[i] = p;  //这里用了数组记录k个节点,空间复杂度度起始不是严格的O(1);
                    p = p.next; //可以记录这k个节点的第一个节点,然后将这部分链表原地反转,空间复杂度为O(1);
                }
            }
            if (flag) {
                rear = p;   //更新下一组第一个
                for (i = k - 1; i > 0; i--)   //倒着链接链表
                    ha[i].next = ha[i - 1];

                if (pre == null) head = ha[k - 1];  //pre为空说明是第一组,更新一下head节点
                else pre.next = ha[k - 1];    //不是第一组的话把倒序的第一个 ha[k-1] 连到 pre 后面
                ha[0].next = rear;  //倒序的最后一个和后面接上
                pre = ha[0];    //pre设为本组最后一个，为下一组的前一个

            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] data = {1,2,3,4,5,6};
        ListNode head = new ListNode(data);
        Leet25 solution = new Leet25();
        int k=2;
        head = solution.reverseKGroup(head, k);
        head.show();
    }
}
