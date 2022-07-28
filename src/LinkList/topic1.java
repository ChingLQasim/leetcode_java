package LinkList;

import java.util.ArrayList;

/*
描述：输入一个链表的头节点，按链表从尾到头的顺序返回每个节点的值（用数组返回）。
 */
public class topic1 {
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) return new ArrayList<Integer>();
        ArrayList<Integer> ans = new ArrayList<>();
        printList(listNode, ans);
        return ans;
    }
    void printList(ListNode listNode, ArrayList<Integer> ans){
        if (listNode.next == null) {
            ans.add(listNode.val);
            return;
        }
        printList(listNode.next, ans);
        ans.add(listNode.val);
    }
}
