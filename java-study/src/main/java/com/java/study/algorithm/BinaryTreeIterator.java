package com.java.study.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: cxz
 * @create: 2021/5/11 21:00
 * @description: 二叉树遍历
 **/
public class BinaryTreeIterator {

    /**
     * @author: cxz
     * @create: 2021/5/11 21:08
     * @description: 遍历顺序：1、前序遍历（根左右） 2、中序遍历（左根右） 3、后序遍历（左右根） 4、层序遍历（从上往下、从左往右）
     * 遍历算法：1、递归  2：迭代 3：morris
     * 注意：递归和迭代复杂度都为： 时间复杂度o(n),空间复杂度o(n) ，而morris时间复杂度o(n),空间复杂度o(1)
     */


    public static void main(String[] args) {
        BinaryTreeIterator.TreeNode treeNode4 = new BinaryTreeIterator.TreeNode(4, null, null);
        BinaryTreeIterator.TreeNode treeNode6 = new BinaryTreeIterator.TreeNode(6, null, null);
        BinaryTreeIterator.TreeNode treeNode7 = new BinaryTreeIterator.TreeNode(7, null, null);
        BinaryTreeIterator.TreeNode treeNode5 = new BinaryTreeIterator.TreeNode(5, treeNode6, treeNode7);
        BinaryTreeIterator.TreeNode treeNode2 = new BinaryTreeIterator.TreeNode(2, treeNode4, treeNode5);
        BinaryTreeIterator.TreeNode treeNode3 = new BinaryTreeIterator.TreeNode(3, null, null);
        BinaryTreeIterator.TreeNode treeNode1 = new BinaryTreeIterator.TreeNode(1, treeNode2, treeNode3);
        System.out.println("treeNode1 ---------------");
        iterator1(treeNode1); //打印结果1,2,4,5,6,7,3
        System.out.println("treeNode2---------------");
        iterator2(treeNode1); //打印结果4,2,6,5,7,1,3
        System.out.println("iterator3----------------");
        iterator3(treeNode1); //打印结果4,6,7,5,2,3,1
        System.out.println("treeNode4---------------");
        ArrayList<Integer> list = new ArrayList<>();
        iterator4(treeNode1,1,list);//打印结果1,2,3,4,5,6,7
        System.out.println(list);
        System.out.println("treeNode5---------------");
        iterator5(treeNode1); //打印结果4,2,6,5,7,1,3
        System.out.println("treeNode6---------------");
        iterator6(treeNode1);
        System.out.println("treeNode7---------------");
        iterator7(treeNode1);//打印结果4,6,7,5,2,3,1
        System.out.println("treeNode8---------------");
        iterator8(treeNode1);//打印结果1,2,3,4,5,6,7
        System.out.println("treeNode9---------------");
        iterator9(treeNode1);//1,2,4,5,6,7,3
        System.out.println("treeNode10---------------");
        iterator10(treeNode1);//打印结果4,2,6,5,7,1,3
        System.out.println("treeNode11---------------");
        iterator11(treeNode1);//打印结果4,6,7,5,2,3,1

    }

    //1、前序遍历（根左右）---递归算法
    public static void iterator1(BinaryTreeIterator.TreeNode treeNode1){
        if(treeNode1 == null){
            return;//遇到null时出栈
        }
        System.out.println(treeNode1.val);//先遍历（第一次栈顶）
        iterator1(treeNode1.left);//先比遍历左侧
        iterator1(treeNode1.right);//再遍历右侧
    }

    //2、中序遍历（左根右）---递归算法
    public static void iterator2(BinaryTreeIterator.TreeNode treeNode1){
        if(treeNode1 == null){
            return;//遇到null时出栈
        }
        iterator2(treeNode1.left);//先比遍历左侧
        System.out.println(treeNode1.val);//第二次成为栈顶时打印
        iterator2(treeNode1.right);//再遍历右侧
    }

    //3、后序遍历（左右根）---递归算法
    public static void iterator3(BinaryTreeIterator.TreeNode treeNode1){
        if(treeNode1 == null){
            return;//遇到null时出栈
        }
        iterator3(treeNode1.left);//先比遍历左侧
        iterator3(treeNode1.right);//再遍历右侧
        System.out.println(treeNode1.val);//第三次成为栈顶时打印
    }

    //4、后序遍历（从上往下、从左往右）---递归算法
    public static void iterator4(BinaryTreeIterator.TreeNode treeNode1, int position, ArrayList list){
        if(treeNode1 == null){
            return;//遇到null时出栈
        }
        if(position>=list.size()){
            int length = list.size();
            for (int i = 0; i <= position - length; i++) {
                list.add(null);
            }
        }
        list.set(position,treeNode1.val);
        iterator4(treeNode1.left,2*position,list);//先比遍历左侧
        iterator4(treeNode1.right,2 * position + 1,list);//再遍历右侧
    }

    //5、前序遍历（根左右）---迭代算法
    public static void iterator5(BinaryTreeIterator.TreeNode treeNode){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(treeNode);
        while (!stack.empty()){
            TreeNode root = stack.pop();
            if(root != null){
                System.out.println(root.val);
                stack.push(root.right);
                stack.push(root.left);
            }
        }
    }

    //6、中序遍历（左根右）---迭代算法
    public static void iterator6(BinaryTreeIterator.TreeNode treeNode){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.empty() || treeNode != null){
            if(treeNode != null){//当前节点不会空 需要继续push
                stack.push(treeNode);
                treeNode = treeNode.left;
            }else {//为空时则说明达到最左侧，需要打印结果
                treeNode = stack.pop();//弹出需要打印的节点
                System.out.println(treeNode.val);
                treeNode = treeNode.right;//获取右节点
            }
        }
    }

    //7、后序序遍历（左右根）---迭代算法
    public static void iterator7(BinaryTreeIterator.TreeNode treeNode){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;//上一步打印标识
        while (!stack.empty() || treeNode != null){
            //先找到最左侧节点
            while (treeNode != null){
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            //此时已达到最左侧节点
            //弹出该节点
            treeNode  = stack.pop();
            if(treeNode.right == null || treeNode.right == pre){
                //可以打印条件满足其中一项即可  1：右节点为空  2：右节点已经打印过
                System.out.println(treeNode.val);
                pre = treeNode;//将最后打印赋值给pre
                treeNode = null;//很关键，需要继续pop上一个元素 避免进入第二层循环
            }else {
                //将本节点再次入栈
                stack.push(treeNode);
                //将右节点复制给treeNode 继续循环处理
                treeNode = treeNode.right;
            }
        }
    }

    //8、后序遍历（左右根）---迭代算法
    public static void iterator8(BinaryTreeIterator.TreeNode treeNode){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
                System.out.println(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
    }

    //9、前序遍历（根左右）---morris
    public static void iterator9(BinaryTreeIterator.TreeNode treeNode){
        TreeNode curr = treeNode;
        while (curr != null){
            TreeNode mostRight =  curr.left;
            if(mostRight != null){//不为空时
                while (mostRight.right != null && mostRight.right != curr){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){
                    System.out.println(curr.val);//打印根节点
                    mostRight.right = curr;//创建线索指针，将最有指针指向自己
                    curr = curr.left;
                    continue;
                }else {
                    mostRight.right = null;//断开线索指针
                }
            }else {
                //达到最左侧 打印
                System.out.println(curr.val);
            }
            curr = curr.right;
        }
    }

    //10、中序遍历（左根右）---morris
    public static void iterator10(BinaryTreeIterator.TreeNode treeNode){
        TreeNode curr = treeNode;
        while (curr != null){
            TreeNode mostRight =  curr.left;
            if(mostRight != null){//不为空时
                while (mostRight.right != null && mostRight.right != curr){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){
                    mostRight.right = curr;//创建线索指针，将最有指针指向自己
                    curr = curr.left;
                    continue;
                }else {
                    mostRight.right = null;//断开线索指针
                }
            }else {

            }
            System.out.println(curr.val);
            curr = curr.right;
        }
    }

    //11、后序遍历（左右根）---morris
    public static void iterator11(BinaryTreeIterator.TreeNode treeNode){
        TreeNode root = treeNode;
        TreeNode curr = treeNode;
        while (curr != null){
            TreeNode mostRight =  curr.left;
            if(mostRight != null){//不为空时
                while (mostRight.right != null && mostRight.right != curr){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){
                    mostRight.right = curr;//创建线索指针，将最有指针指向自己
                    curr = curr.left;
                    continue;
                }else {
                    mostRight.right = null;//断开线索指针
                    //断开时打印
                    printNode(curr.left);
                }
            }
            curr = curr.right;
        }
        printNode(root);

    }

    public static void printNode(TreeNode head){
        TreeNode tail = reverse(head);
        TreeNode curr = tail;
        while (curr != null){
            System.out.println(curr.val);
            curr = curr.right;
        }
        reverse(tail);
    }

    private static TreeNode reverse(TreeNode head) {
        TreeNode pre = null;
        TreeNode next;
        TreeNode curr;
        curr = head;
        while (curr != null){
            next = head.right;
            curr.right = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }


    static class TreeNode{
        int val;
        BinaryTreeIterator.TreeNode left;
        BinaryTreeIterator.TreeNode right;
        int deep;

        public TreeNode(int val, BinaryTreeIterator.TreeNode left, BinaryTreeIterator.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
