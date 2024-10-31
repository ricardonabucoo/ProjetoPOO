package cells.trees;

import elements.fruits.Guava;

import javax.swing.*;

public class GuavaTree extends Tree {

    public GuavaTree(int row, int col) {
        super(row, col);
        producedFruit = new Guava();
        stage1 = new ImageIcon("images/treeGuava1-export");
        stage2 = new ImageIcon("images/treeGuava2-export");
        stage3 = new ImageIcon("images/treeGuava3-export");
    }
}
