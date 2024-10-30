package cells.trees;

import elements.fruits.Coconut;

import javax.swing.*;

public class CoconutTree extends Tree {

    public CoconutTree(int row, int col) {
        super(row, col);
        producedFruit = new Coconut(this);
        stage1 = new ImageIcon("images/treeCoconut1-export.png");
        stage2 = new ImageIcon("images/treeCoconut2-export.png");
        stage3 = new ImageIcon("images/treeCoconut3-export.png");
    }
}
