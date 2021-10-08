package com.java.study.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: cxz
 * @create: 2021/5/10 17:25
 * @description: 判断链表是否存在环形链表
 **/
public class LinkedCircle {

    public static void main(String[] args) {
        ChainReverse.ListNode listNode1 = new ChainReverse.ListNode(5, null);
        ChainReverse.ListNode listNode2 = new ChainReverse.ListNode(4, listNode1);
        ChainReverse.ListNode listNode3 = new ChainReverse.ListNode(3, listNode2);
        ChainReverse.ListNode listNode4 = new ChainReverse.ListNode(2, listNode3);
        ChainReverse.ListNode listNode5 = new ChainReverse.ListNode(1, listNode4);
        listNode1.next = listNode4;
        System.out.println(hasCircle(listNode5));
        System.out.println(hasCircle002(listNode5));


    }
    //迭代 时间复杂度为 o(n)  空间复杂度o(n)
    public static boolean hasCircle(ChainReverse.ListNode listNode){
        Set<ChainReverse.ListNode> set = new HashSet<>();
        while (listNode != null){
            if(set.add(listNode)){
                listNode = listNode.next;
            }else {
                return true;
            }
        }
        return false;
    }

    //快慢双指针 时间复杂度 o(n) 空间复杂度o(1)
    public static boolean hasCircle002(ChainReverse.ListNode listNode){
        if(listNode == null){
            return false;
        }
        ChainReverse.ListNode slow = listNode;
        ChainReverse.ListNode quick = listNode.next;
        while (slow != quick){
            if(quick == null || quick.next == null){
                return false;
            }
            slow = slow.next;//满指针走一步
            quick = quick.next.next;//快指针走两步
        }
        return true;
    }



}
