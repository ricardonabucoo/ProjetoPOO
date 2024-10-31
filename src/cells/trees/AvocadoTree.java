package cells.trees;

import elements.fruits.Avocado;

import javax.swing.*;

public class AvocadoTree extends Tree{

    public AvocadoTree(int row, int col) {
        super(row, col);
        producedFruit = new Avocado();
        stage1 = new ImageIcon("images/treeAvocado1-export.png");
        stage2 = new ImageIcon("images/treeAvocado2-export.png");
        stage3 = new ImageIcon("images/treeAvocado3-export.png");
    }
}
