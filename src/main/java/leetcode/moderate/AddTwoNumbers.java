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
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(9);
//        l2.next.next.next = new ListNode(9);

        printListNode(l1);
        printListNode(l2);


        ListNode sumListNod = addTwoNumbers(l1, l2);

        printListNode(sumListNod);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        int add = l1.val + l2.val;
        boolean isCarry = false;
        if(add >= 10){
            add %= 10;
            isCarry = true;
        }
        ListNode sumOfNumber = new ListNode(add);
        ListNode previousPoint = sumOfNumber;
        ListNode currentPoint;

        while (l1.next != null && l2.next != null){
            l1 = l1.next;
            l2 = l2.next;

            if (isCarry) {
                add = l1.val + l2.val + 1;
                isCarry = false;
            } else {
                add = l1.val + l2.val;
            }

            if (add >= 10) {
                add = add % 10;
                isCarry = true;
            }

            currentPoint = new ListNode(add);
            previousPoint.next = currentPoint;
            previousPoint = previousPoint.next;
        }

        // l2 end
        if(l1.next != null){
            l1 = l1.next;
            previousPoint.next = l1;
            while (isCarry && l1 != null){
                previousPoint = l1;
                l1.val += 1;
                isCarry = false;
                if(l1.val >= 10) {
                    l1.val %= 10;
                    isCarry = true;
                }
                l1 = l1.next;
            }
        }

        // l1 end
        if (l2.next != null){
            l2 = l2.next;
            previousPoint.next = l2;
            while (isCarry && l2 != null){
                previousPoint = l2;
                l2.val += 1;
                isCarry = false;
                if(l2.val >= 10) {
                    l2.val %= 10;
                    isCarry = true;
                }
                l2 = l2.next;
            }
        }

        if (isCarry) previousPoint.next = new ListNode(1);

        return sumOfNumber;
    }

    public static boolean hasNext(ListNode listNode){
        return listNode.next != null ? true : false;
    }


    public static void printListNode(ListNode ln) {
        System.out.print(ln.val);
        if (ln.next != null) {
            printListNode(ln.next);
        } else {
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
