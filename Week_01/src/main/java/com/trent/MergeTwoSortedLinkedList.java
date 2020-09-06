package com.trent;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoSortedLinkedList {
    /**
     * 链表的节点
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 暴力法：逐一比较两个链表各个节点数据的大小
     * 引入哑节点
     *
     * @param l1 第一个链表
     * @param l2 第二个链表
     * @return 合并后的有序链表
     */
    public ListNode mergeTwoSortedLinkedListV1(ListNode l1, ListNode l2) {
        ListNode preNode = new ListNode(-1);
        ListNode prev = preNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 != null ? l1 : l2;
        return preNode.next;
    }

    /**
     * 使用递归方法来解决合并问题
     * 最小可重复的过程：将小元素设为头节点，合并以小节点的下一个为头节点的子链表和另一个链表
     *
     * @param l1 第一个链表
     * @param l2 第二个链表
     * @return 合并后的链表
     */
    public ListNode mergeTwoSortedLinkedListV2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoSortedLinkedListV2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoSortedLinkedListV2(l2.next, l1);
            return l2;
        }
    }

    /**
     * 工具方法，根据数组生成链表
     *
     * @param input 输入的数组
     * @return 生成的链表
     */
    public ListNode genListNodeByArray(int[] input) {
        if (input != null && input.length > 0) {
            ListNode head = new ListNode(-1);
            ListNode last = head;
            for (int element : input) {
                ListNode listNode = new ListNode(element);
                last.next = listNode;
                last = listNode;
            }
            return head.next;
        } else {
            return null;
        }
    }

    /**
     * 工具方法：将链表转换为字符串，用'->'连接各个节点的数据
     *
     * @param listNode 链表的头节点
     * @return 链表的字符串
     */
    public String listNodeToString(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            ListNode current = listNode;
            boolean flag = false;
            while (current != null) {
                if (flag) {
                    stringBuilder.append("->");
                } else {
                    flag = true;
                }
                stringBuilder.append(current.val);
                current = current.next;
            }
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        MergeTwoSortedLinkedList mergeTwoSortedLinkedList = new MergeTwoSortedLinkedList();
        ListNode l1 = mergeTwoSortedLinkedList.genListNodeByArray(new int[]{1, 2, 4});
        ListNode l2 = mergeTwoSortedLinkedList.genListNodeByArray(new int[]{1, 3, 4});
        System.out.println("l1:" + mergeTwoSortedLinkedList.listNodeToString(l1) + ",l2:" + mergeTwoSortedLinkedList.listNodeToString(l2));
        ListNode mergedV1 = mergeTwoSortedLinkedList.mergeTwoSortedLinkedListV1(l1, l2);
        // 上面的l1和l2 的内部的指针已经被修改过，因此重新生成两个链表
        ListNode l1v2 = mergeTwoSortedLinkedList.genListNodeByArray(new int[]{1, 2, 4});
        ListNode l2v2 = mergeTwoSortedLinkedList.genListNodeByArray(new int[]{1, 3, 4});
        ListNode mergedV2 = mergeTwoSortedLinkedList.mergeTwoSortedLinkedListV2(l1v2, l2v2);
        System.out.println("after merge v1 : " + mergeTwoSortedLinkedList.listNodeToString(mergedV1));
        System.out.println("after merge v2 : " + mergeTwoSortedLinkedList.listNodeToString(mergedV2));
    }
}
