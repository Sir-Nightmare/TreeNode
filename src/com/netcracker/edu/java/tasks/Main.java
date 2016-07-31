package com.netcracker.edu.java.tasks;

/**
 * Created by Sir Nightmare on 07/31/16.
 */
public class Main {
    public static void main(String[] args) {
        TreeNode node = new TreeNodeImpl("q");
        TreeNode node1 = new TreeNodeImpl("w");
        TreeNode node2 = new TreeNodeImpl("e");
        TreeNode node3 = new TreeNodeImpl("r");
        TreeNode node11 = new TreeNodeImpl("t");
        TreeNode node12 = new TreeNodeImpl("y");
        TreeNode node21 = new TreeNodeImpl("u");
        TreeNode node22 = new TreeNodeImpl(null);
        node.addChild(node1);
        node.addChild(node2);
        node.addChild(node3);
        node1.addChild(node11);
        node1.addChild(node12);
        node2.addChild(node21);
        node2.addChild(node22);
        System.out.println(node.findChild("r").getData());
    }
}

