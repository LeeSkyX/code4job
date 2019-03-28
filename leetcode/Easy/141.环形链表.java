import java.util.HashSet;
import java.util.Set;

import org.w3c.dom.NodeList;

/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 *
 * https://leetcode-cn.com/problems/linked-list-cycle/description/
 *
 * algorithms
 * Easy (33.42%)
 * Total Accepted:    30.9K
 * Total Submissions: 84.5K
 * Testcase Example:  '[3,2,0,-4]\n1'
 *
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 *
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 *
 *
 *
 *
 *
 * 进阶：
 *
 * 你能用 O(1)（即，常量）内存解决此问题吗？ 空间复杂度 O(1)快慢指针
 *
 */
/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    // 快慢指针，此方法时间复杂度 O(n),空间复杂度为 O(1)，只使用了两个变量。
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        else {
            ListNode fast = head.next;
            ListNode slow = head;
            while (fast != slow) {
                if (fast == null || fast.next == null)
                    return false;
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        }
    }

    // 使用哈希表，时间复杂度最优 O(n),空间复杂度 O(n)
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodehash = new HashSet<>();
        while (head != null) {
            if (nodehash.contain(head))
                return true;
            else
                nodehash.add(head);
            head = head.next;
        }
        return false;
    }
}
