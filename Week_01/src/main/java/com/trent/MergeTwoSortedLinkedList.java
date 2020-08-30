package com.trent;

import java.util.LinkedList;

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
     * 使用哑节点的方式实现
     *
     * @param l1 第一个链表
     * @param l2 第二个链表
     * @return 合并后的有序链表
     */
    public ListNode mergeTwoSortedLinkedList(ListNode l1, ListNode l2) {
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
        //TODO 解决多一个元素的情况
        prev.next = l1 != null ? l1 : l2;
        return preNode.next;
    }

    /**
     * 工具方法，根据数组生成链表
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
        ListNode merge = mergeTwoSortedLinkedList.mergeTwoSortedLinkedList(l1, l2);
        System.out.println("after merge : " + mergeTwoSortedLinkedList.listNodeToString(merge));
    }
}
