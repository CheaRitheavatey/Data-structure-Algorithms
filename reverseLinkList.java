class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class reverseLinkList {
    public ListNode reverseList(ListNode head) {
        if (head == null) 
            return head;
        
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode tempt = current.next;
            current.next = prev;
            prev = current;
            current = tempt;
           

        }
        

        return prev;
        // time complexity O(1)
        
    }
    
}