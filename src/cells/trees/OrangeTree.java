package cells.trees;

import elements.fruits.Orange;

import javax.swing.*;

public class OrangeTree extends Tree {

    public OrangeTree(int row, int col) {
        super(row, col);
        producedFruit = new Orange(this);
        stage1 = new ImageIcon("images/treeOrange1-export.png");
        stage2 = new ImageIcon("images/treeOrange2-export.png");
        stage3 = new ImageIcon("images/treeOrange3-export.png");
    }
}
