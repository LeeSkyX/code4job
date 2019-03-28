/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 *
 * https://leetcode-cn.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (57.27%)
 * Total Accepted:    42.9K
 * Total Submissions: 72.6K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 *
 *
 */
// 使用头插法的一般做法(迭代法) 从前到后
// 时间复杂度 O(1)
class Solution {
    public ListNode reverseList1(ListNode head) {
        ListNode pre = null, cur = head, q;
        while (cur != null) {
            q = cur.next;
            cur.next = pre;
            pre = cur;
            cur = q;
        }
        return pre;
    }

    // 递归法 递归层层深入从后到前
    // 时间复杂度 O(1)
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newhead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newhead;
    }
}
