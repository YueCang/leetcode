package leetcode.moderate;

/**
 * @ClassName AddTwoNumbers
 * @Description: 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * @Author Lyb
 * @Date 2021/2/8
 **/
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(9);

        printListNode(l1);
        printListNode(l2);

        ListNode sumListNod = addTwoNumbers(l1, l2);

        printListNode(sumListNod);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumOfNumber = new ListNode(0);
        ListNode currentPoint = sumOfNumber;
        ListNode previousPoint = sumOfNumber;
        Boolean isCarry = false;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {

                if (isCarry){
                    currentPoint.val = l1.val + l2.val + 1;
                    isCarry = false;
                }else {
                    currentPoint.val = l1.val + l2.val;
                }

                if (currentPoint.val >= 10) {
                    currentPoint.val = currentPoint.val % 10;
                    isCarry = true;
                }

                previousPoint = currentPoint;
                currentPoint.next = new ListNode(0);
                currentPoint = currentPoint.next;

                l1 = l1.next;
                l2 = l2.next;

                continue;
            }else if (l1 == null) {
                previousPoint.next = l2;
                break;
            }else{
                previousPoint.next = l1;
                break;
            }
        }
        return sumOfNumber;
    }

    public static void printListNode(ListNode ln) {
        System.out.print(ln.val);
        if (ln.next != null) {
            printListNode(ln.next);
        }else {
            System.out.println();
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
