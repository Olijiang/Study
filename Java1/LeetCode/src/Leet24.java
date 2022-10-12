public class Leet24 {
    public ListNode swapPairs(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode p=head, temp=null, pre=null;
        while (p.next!=null){
            if (temp==null) head = p.next;  //头节点换到第二个
            temp = p.next;
            p.next = p.next.next;
            temp.next = p;
            if (pre!=null) pre.next = temp; //记录前一个节点
            pre = p;
            if (p.next!=null) p=p.next;
        }
        return head;
    }

    public ListNode swapPairs2(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode tail = head.next;
        head.next = swapPairs(tail.next);
        tail.next = head;

        return tail;
    }

    public static void main(String[] args) {
        int[] data = {1,2,3,4,5};
        ListNode head = new ListNode(data);
        Leet24 solution = new Leet24();
        head.show();
        head = solution.swapPairs(head);
        head.show();
        head = solution.swapPairs2(head);
        head.show();
    }
}