/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import GUI.FrmMain;
import java.awt.Component;
import javax.swing.JDialog;

/**
 *
 * @author chicu
 */
public class ShowDialog {

    private FrmMain frmmain = null;
    private JDialog dialog = null;

    public ShowDialog() {
    }

    public ShowDialog(FrmMain frmmain) {
        this.frmmain = frmmain;
    }

    public void Show(String Title, Component cpt, int width, int height) {
        dialog = new JDialog(frmmain, Title, true);
        dialog.add(cpt);
        dialog.setSize(width, height);
        dialog.setLocationRelativeTo(frmmain);
        dialog.setResizable(false);
        dialog.setVisible(true);
    }
}
