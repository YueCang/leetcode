package leetcode;

import java.util.List;

/**
 * @ClassName SumOfNumbers
 * @Description: 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * @Author Lyb
 * @Date 2021/2/8
 **/
public class SumOfNumbers {
    public static void main(String[] args) {
        ListNode ln1 = new ListNode(2);
        ln1.next = new ListNode(4);
        ln1.next.next = new ListNode(3);
        ListNode ln2 = new ListNode(5);
        ln2.next = new ListNode(6);
        ln2.next.next = new ListNode(4);
        ln2.next.next.next = new ListNode(9);

        ListNode sumListNod = sumOfNumbers(ln1, ln2);

        printListNode(sumListNod);
    }

    public static ListNode sumOfNumbers(ListNode ln1, ListNode ln2) {
        ListNode currentPoint = new ListNode(0);
        ListNode sumOfNumber = currentPoint;
        Boolean isCarry = false;
        while (ln1 != null || ln2 != null) {
            if (ln1 != null && ln2 != null) {
                currentPoint.val = ln1.val + ln2.val;
                ln1 = ln1.next;
                ln2 = ln2.next;

                if (isCarry) currentPoint.val += 1;
                if (currentPoint.val >= 10) {
                    currentPoint.val = currentPoint.val % 10;
                    isCarry = true;
                }

                continue;
            }
            if (ln1 != null) {
                currentPoint.next = ln1;
                ln1 = null;
                continue;
            }

            if (ln2 != null) {
                currentPoint.next = ln2;
                ln2 = null;
                continue;
            }
        }
        return sumOfNumber.next;
    }

    public static void printListNode(ListNode ln) {
        System.out.println(ln.val);
        if (ln.next != null) {
            printListNode(ln.next);
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
