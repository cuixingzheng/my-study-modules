package com.java.study.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: cxz
 * @create: 2021/5/11 17:08
 * @description: 给定一个二叉树，找出其最小深度 （最小深度是从根节点到最最近叶子节点的最短路径的节点数量） 分为：深度优先和广度优先
 **/
public class TreeDeep {


    public static void main(String[] args) {
        TreeNode treeNode4 = new TreeNode(4, null, null);
        TreeNode treeNode5 = new TreeNode(5, null, null);
        TreeNode treeNode7 = new TreeNode(7, null, null);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode6 = new TreeNode(6, treeNode7, null);
        TreeNode treeNode3 = new TreeNode(3, treeNode6, null);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);
        //System.out.println(findMinDeep(treeNode1));
        System.out.println(findMinDeep2(treeNode1));

    }

    //深度优先,递归算法 (从叶子节点开始) 时间复杂度o(n) 空间复杂度o(logn)
    public static int findMinDeep(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
        if(treeNode.left == null && treeNode.right == null){//达到叶子节点
            return 1;//叶子节点默认为1
        }

        int min = Integer.MAX_VALUE;
        if(treeNode.left != null){
            min = Math.min(findMinDeep(treeNode.left),min);//递归获取左侧最小深度
        }
        if(treeNode.right != null){
            min = Math.min(findMinDeep(treeNode.right),min);//递归获取右侧最小深度
        }

        return min + 1;//加上本身的深度 返回
    }

    //广度优先（一层一层遍历） (从根节点开始) 时间复杂度o(n) 空间复杂度o(n)
    public static int findMinDeep2(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        treeNode.deep = 1;//根节点默认为1
        queue.offer(treeNode);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left == null && node.right == null){//达到叶子节点时，该深度就是最小深度
                return node.deep;
            }
            if(node.left != null){
                node.left.deep = node.deep + 1;
                queue.offer(node.left);
            }

            if(node.right != null){
                node.right.deep = node.deep + 1;
                queue.offer(node.right);
            }
        }
        return -1;
    }


    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        int deep;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
