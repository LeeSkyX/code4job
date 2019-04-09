/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] k个一组翻转链表
 *
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/description/
 *
 * algorithms
 * Hard (48.22%)
 * Total Accepted:    8.9K
 * Total Submissions: 17.8K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    /*
     * // 两种方法 递归和非递归法 // 首先是递归方法，递归方法的关键是找到终止条件【起始先写终止条件】，本题为不满足长度k停止 public
     * ListNode reverseKGroup(ListNode head, int k) { ListNode pre = null, cur =
     * head, temp = null, check = head; int canrun = 0, count = 0; // 检查链表长度是否满足翻转
     * while (canrun < k && check != null) { canrun++; check = check.next; } //
     * 满足条件开始翻转 if (canrun == k) { while (count < k) { temp = cur.next; cur.next =
     * pre; pre = cur; cur = temp; count++; } // 内层递归 if (temp != null) { head.next
     * = reverseKGroup(temp, k); } return pre;//
     * 函数返回至，函数执行结束，返回翻转部分的最后一个节点，作为新链表的第一个结点 } //
     * 不满足条件直接返回head即可(递归的时候输入的head为temp) else return head; }
     */

    // 非递归方法
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head, prev = null, result = new ListNode(0), tail = result;
        int i = 0;
        for (; node != null; ++i) {
            ListNode next = node.next;
            if (i % k == 0 && i != 0) {
                tail.next = prev;
                tail = head;
                head = node;
                head.next = null;
            } else {
                node.next = prev;
            }
            prev = node;
            node = next;
        }
        if (i % k != 0) {
            for (node = prev, prev = null; node != null;) {
                ListNode next = node.next;
                node.next = prev;
                prev = node;
                node = next;
            }
        }
        tail.next = prev;
        return result.next;
    }
}
