public class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    ListNode(int[] data){
        //data长度>0
        this.val = data[0];
        ListNode p = this;
        for (int i=1; i<data.length; i++){
            ListNode temp = new ListNode(data[i]);
            p.next = temp;
            temp.next = null;
            p = temp;
        }
    }

    public ListNode addData(int[] data){
        //从节点的末尾添加数据,data长度>0
        ListNode p = this;
        while (p.next!=null) p=p.next;
        for (int datum : data) {
            ListNode temp = new ListNode(datum);
            p.next = temp;
            temp.next = null;
            p = temp;
        }
        return this;
    }

    public void show(){
        System.out.print(this.val+" ");
        ListNode p = this.next;
        while (p!=null){
            System.out.print(p.val+" ");
            p=p.next;
        }
        System.out.println();
    }

}
