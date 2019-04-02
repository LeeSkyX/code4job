/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 *
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/description/
 *
 * algorithms
 * Medium (32.61%)
 * Total Accepted:    12.4K
 * Total Submissions: 33.8K
 * Testcase Example:  '[3,2,0,-4]\n1'
 *
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 *
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 *
 *
 *
 *
 *
 *
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 *
 */
/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
// 两种解释
// (1)假设环内剩余长度为c,则快指针走过的长度为: 2(a+b) = a + b + c + b 所以c=a.
// (2)假设环长度为 b，由于快指针速度是慢指针的2倍，则快指针的走过的路径始终是慢指针的
// 2倍，因此慢指针到入环点时，假设到入环点距离为a，则，快指针走过2a路程，在环内的的路径长度为a,那么剩余长度为b-a，则需要经过b-a次循环，快指针追上慢指针，而慢指针速度为1，则慢指针走过路径为b-a，那么环内剩余路径为b-（b-a）=
// a ,因此设置一个新指针从头结点出发，慢指针与新指针在入环处相遇。
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        boolean hasCycle = false;
        if (head == null)
            return null;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (hasCycle) {// 表示有环
            ListNode newslow = head;
            while (newslow != slow) {
                newslow = newslow.next;
                slow = slow.next;
            }
            return newslow;
        } else
            return null;
    }
}
