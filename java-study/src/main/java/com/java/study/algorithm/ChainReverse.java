package com.java.study.algorithm;

/**
 * @author: cxz
 * @create: 2021/5/7 10:18
 * @description: 单链表反转
 **/
public class ChainReverse {


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(5, null);
        ListNode listNode2 = new ListNode(4, listNode1);
        ListNode listNode3 = new ListNode(3, listNode2);
        ListNode listNode4 = new ListNode(2, listNode3);
        ListNode listNode5 = new ListNode(1, listNode4);

        //ListNode node = reverseList(listNode5);
        ListNode node = reverseList002(listNode5);
        System.out.println(node);


    }

    //递归方式
    //由于递归方式的特殊性，需要从链表尾部进行反转（如果从头部开始反转将无法找到下一个元素）
    public static ListNode reverseList002(ListNode head){
        if(head == null || head.next == null){
            //递归结束条件为，最后一个元素的指针为null，并返回最后一个元素
            return head;
        }
        //执行递归，止到最后一个
        ListNode last = reverseList002(head.next);
        //每两两指针进行交换
        //现将第二元素的指针指向第一个
        head.next.next = head;
        //将第一个元素指针变成null
        head.next = null;
        //返回最后一个元素（反转后，最后一个元素就是链表的头）
        return last;
    }

    //迭代方式
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next;
        ListNode curr = head;
        while (curr != null){
            //先把当前元素的下一个 赋值给一个中间变量
            next = curr.next;
            //将当前的元素的指针指向上一个
            curr.next = pre;
            //将当前元素赋值给中间元素 等下一次遍历使用
            pre = curr;
            //将当前元素变成下一个，继续遍历
            curr = next;
        }
        //此时pre就是链表头部
        return pre;
    }

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
