/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (56.65%)
 * Total Accepted:    16.4K
 * Total Submissions: 28.2K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 *
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        // 递归的常用解法 【可以发现代码很多冗余的地方，注意代码简洁】
        if (head == null || head.next == null)
            return head;
        ListNode q = head.next;
        head.next = swapPairs(q.next);
        q.next = head;
        return q;
    }

    public ListNode swapPairs1(ListNode head) {
        // 迭代两两交换，遍历到尾部，遍历过程中执行两两交换，使用三个指针，dunmmy节点头
        ListNode dummyead = new ListNode(0);
        dummyead.next = head;
        ListNode p = dummyead;
        while (p.next != null && p.next.next != null) {
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            node2.next = node1;
            node1.next = next;
            p.next = node2;

            p = node1;
        }

        ListNode renode = dummyead.next;
        return renode;
    }
}
