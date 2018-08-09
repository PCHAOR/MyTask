/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.beliro.adminorder.Window.CardPanel;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import ru.beliro.adminorder.DataController;
import ru.beliro.adminorder.tables.TablePhoneDirectory;

/**
 *
 * @author kurbatov
 */
public class PhoneDirectory extends JFrame{
    
    private JPanel panel;
    private JTable table;
    DataController dataController = new DataController();

    public PhoneDirectory() {
        createNewPanel();
    }

    private JPanel createNewPanel(){
        panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        dataController.addWorker(0, "Вася", 0, "341964", 0, "vasy@beliro.ru");
        
        table = new JTable(new TablePhoneDirectory(dataController.getWorkers()));
        JScrollPane scrollPane = new JScrollPane(table);
        
        panel.add(scrollPane);
        
        return panel;
    }
}
