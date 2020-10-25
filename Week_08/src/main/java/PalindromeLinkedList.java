import java.util.LinkedList;

public class PalindromeLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 判断链表是否是回文链表。
     * 算法步骤如下：
     * <ol>
     *  <li>找到中间结点</>
     *  <li>反转后半部链表</li>
     *  <li>对比两个链表是否相同</li>
     * </ol>
     *
     * @param head 表头
     * @return 是否是回文链表
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode nextHalfStart = findNextHalfStart(head);
        ListNode secondHalf = reverseList(nextHalfStart);
        ListNode p1 = head;
        ListNode p2 = secondHalf;
        boolean result = true;
        while(result && p2 != null){
            if(p1.val != p2.val){
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return result;
    }

    private ListNode findNextHalfStart(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.next;
    }

    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

}
