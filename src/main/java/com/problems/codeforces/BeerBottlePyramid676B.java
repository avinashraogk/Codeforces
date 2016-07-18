package com.problems.codeforces;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * Copyright (c) Rakuten, Inc. All Rights Reserved.
 * 
 * This program is the information assets which are handled
 * as "Strictly Confidential".
 * Permission of Use is only admitted in Rakuten Inc.
 * Development Department.
 * If you don't have permission , MUST not be published,
 * broadcast, rewritten for broadcast or publication
 * or redistributed directly or indirectly in any medium.
 * 
 * $Id$
 * Created on May 27, 2016
 * Updated on $Date$
 */
public class BeerBottlePyramid676B {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        TreeNode root = TreeNode.getRootNode();
        if (n > 1)
            createPyramid(n, initializeQueue(root));
        fillTtimes(root, t);
        // traverse(root);
        // resetVisited(root);
        countNode(root);
        System.out.println(TreeNode.totalFilledNodes);
    }

    private static void resetVisited(TreeNode node) {
        node.setVisited(false);
        if (node.getLeft() != null) {
            resetVisited(node.getLeft());
        }
        if (node.getRight() != null) {
            resetVisited(node.getRight());
        }
    }

    private static void fillTtimes(TreeNode root, int t) {
        for (int i = 0; i < t; i++)
            root.addLevel(1);
    }

    private static Queue<TreeNode> initializeQueue(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        return q;
    }

    private static void countNode(TreeNode node) {
        if (node.getLeft() != null) {
            countNode(node.getLeft());
        }
        if (!node.isVisited()) {
            node.setVisited(true);
            if (node.isFilled)
                TreeNode.totalFilledNodes++;
        }
        if (node.getRight() != null) {
            countNode(node.getRight());
        }
    }

    private static void traverse(TreeNode node) {
        if (node.getLeft() != null) {
            traverse(node.getLeft());
        }
        if (!node.isVisited()) {
            System.out.println(node);
            node.setVisited(true);
        }
        if (node.getRight() != null) {
            traverse(node.getRight());
        }
    }

    private static void createPyramid(int level, Queue<TreeNode> queue) {
        // System.out.println(1);
        for (int i = 2, p = 2; i <= level; i++) {
            TreeNode qElement = queue.remove();
            for (int j = 1; j <= i; j++, p++) {
                // System.out.print(p + " ");
                TreeNode currentNode = new TreeNode(p);
                currentNode.setDenominator(1 << i - 1);
                if (j == 1) {
                    qElement.setLeft(currentNode);
                    currentNode.addNumerator(qElement.getNumerator());
                } else if (j == i) {
                    qElement.setRight(currentNode);
                    currentNode.addNumerator(qElement.getNumerator());
                } else {
                    qElement.setRight(currentNode);
                    currentNode.addNumerator(qElement.getNumerator());
                    qElement = queue.remove();
                    qElement.setLeft(currentNode);
                    currentNode.addNumerator(qElement.getNumerator());
                }
                queue.add(currentNode);
            }
            // System.out.println();
        }
    }
}

class TreeNode {

    static int totalnumberOfNodes;
    static int totalFilledNodes;
    private int number;
    private TreeNode left;
    private TreeNode right;
    boolean isFilled, isVisited;

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    int numerator, denominator, level;

    public int getLevel() {
        return level;
    }

    public static TreeNode getRootNode() {
        TreeNode root = new TreeNode(1);
        root.number = 1;
        root.numerator = 1;
        root.denominator = 1;
        root.isFilled = false;
        root.left = root.right = null;
        return root;
    }

    public void addLevel(int levelToAdd) {
        this.level += levelToAdd;
        if (level >= denominator) {
            setFilled(true);
            int extra = level - denominator;
            overFlow(extra);
            level = denominator;
        }
    }

    private void overFlow(int extra) {
        if (left != null && right != null) {
            left.addLevel(extra);
            right.addLevel(extra);
        }
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean isFilled) {
        this.isFilled = isFilled;
    }

    public int getNumerator() {
        return numerator;
    }

    public void addNumerator(int numerator) {
        this.numerator += numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    TreeNode(int n) {
        number = n;
        left = right = null;
        totalnumberOfNodes++;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node: " + number + " Ratio: " + numerator + "/" + denominator + " Level: " + level + " Filled: "
                + isFilled + " Left: "
                + (left != null ? left.number : "null") + " Right: "
                + (right != null ? right.number : "null") + "\n";
    }
}