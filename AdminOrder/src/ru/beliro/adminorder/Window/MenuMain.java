/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.beliro.adminorder.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import static javax.swing.Action.NAME;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

/**
 *
 * @author kurbatov
 */
public class MenuMain extends JFrame{
    
    private static JMenuBar menuBar;
    
    public MenuMain(){
        menuBar = new JMenuBar();
        menuBar.add(createFileMenu());
    }
    
    public JMenuBar getMenuMain(){
        return menuBar;
    }

    private JMenu createFileMenu() {
        
        JMenu file = new JMenu("Файл");
        JMenuItem openFile = new JMenuItem("Открыть");
        JMenuItem saveFile = new JMenuItem("Сохранить");
        JMenuItem loadFile = new JMenuItem("Загрузить");
        JMenuItem exit = new JMenuItem(new ExitAction());
        
        file.add(openFile);
        file.add(saveFile);
        file.add(loadFile);
        file.addSeparator();
        file.add(exit);
        
        return file;
    }
    
    class ExitAction extends AbstractAction
    {
        private static final long serialVersionUID = 1L;
        ExitAction() {
            putValue(NAME, "Выход");
        }
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    
}
