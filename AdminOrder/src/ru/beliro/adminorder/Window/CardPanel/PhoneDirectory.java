/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.beliro.adminorder.Window.CardPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
import ru.beliro.adminorder.DataController;
import ru.beliro.adminorder.Window.WindowMain;
import ru.beliro.adminorder.tables.TablePhoneDirectory;

/**
 *
 * @author kurbatov
 */
public class PhoneDirectory extends JPanel{
    
    private JPanel panelMain;
    private JPanel panelSouth;
    private JTable table;
    private JScrollPane scrollPane;
    
    private TableRowSorter<TablePhoneDirectory> rowSorter = new TableRowSorter<>(new TablePhoneDirectory());
    
    private JTextField jtfFilter = new JTextField();
    
    DataController dataController = new DataController();  //Для тестирования добавления данных

    public PhoneDirectory() {
        createNewPanel();
    }

    private void createNewPanel(){
                
        panelMain = new JPanel(new BorderLayout());
        /********************************************/
        table = new JTable(new TablePhoneDirectory());
        table.getColumnModel().getColumn(0).setMinWidth(30);
        table.getColumnModel().getColumn(0).setMaxWidth(30);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setRowSorter(rowSorter);
        
        /********************************************/
        
        dataController.addWorker(1, "Вася", 919, "341964", 111, "vasy@beliro.ru");
        dataController.addWorker(2, "Петя", 921, "346419", 107, "pety@beliro.ru");

        scrollPane = new JScrollPane(table);
        
        /********************************************/
        
        panelMain.add(scrollPane,BorderLayout.CENTER);  
        panelMain.add(searchForm(), BorderLayout.SOUTH);
    }
    
    private JPanel searchForm(){
        
        panelSouth = new JPanel(new BorderLayout());
        
        panelSouth.add(new JLabel("Specify a word to match:"), BorderLayout.WEST);
        panelSouth.add(jtfFilter, BorderLayout.CENTER);
        
        
        jtfFilter.getDocument().addDocumentListener(new DocumentListener(){
            
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }  
        });
        
        return panelSouth;
    }
    
    
    public JPanel getPanel(){
        return panelMain;
    }
}
