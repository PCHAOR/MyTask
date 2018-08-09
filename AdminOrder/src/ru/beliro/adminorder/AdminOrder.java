/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.beliro.adminorder;

import ru.beliro.adminorder.Window.WindowMain;

/**
 *
 * @author kurbatov
 */
public class AdminOrder {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new WindowMain();
        });
    }
}
