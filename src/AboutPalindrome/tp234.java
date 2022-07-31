package AboutPalindrome;

/*
给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class tp234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode pre = head, slow = head, quick = head, cur = head, nex = head.next;
        while(quick != null && quick.next != null){
            quick = quick.next.next;
            nex = slow.next;
            slow.next = pre;
            pre = slow;
            slow = nex;
        }
        if (quick != null){
            slow = slow.next;
        }
        while(slow != null){
            if (slow.val != pre.val){
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null, cur = head, nex;
        while(cur != null){
            nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        return pre;
    }

}
