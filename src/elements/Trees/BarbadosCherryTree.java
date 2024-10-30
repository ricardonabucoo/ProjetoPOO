package elements.Trees;

import elements.Fruits.BarbadosCherry;

import javax.swing.*;

public class BarbadosCherryTree extends Tree{

    public BarbadosCherryTree(int row, int col) {
        super(row, col);
        producedFruit = new BarbadosCherry(this);
        stage1 = new ImageIcon("images/treeBarbados1-export.png");
        stage2 = new ImageIcon("images/treeBarbados2-export.png");
        stage3 = new ImageIcon("images/treeBarbados3-export.png");

    }
}
