package cells.trees;

import elements.fruits.BlackBerry;

import javax.swing.*;

public class BlackBerryTree extends Tree {

    public BlackBerryTree(int row, int col) {
        super(row, col);
        producedFruit = new BlackBerry();
        stage1 = new ImageIcon("images/treeBlackBerry1-export.png");
        stage2 = new ImageIcon("images/treeBlackBerry2-export.png");
        stage3 = new ImageIcon("images/treeBlackBerry3-export.png");
    }
}
