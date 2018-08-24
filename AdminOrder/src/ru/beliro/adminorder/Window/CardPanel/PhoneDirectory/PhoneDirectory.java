/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.beliro.adminorder.Window.CardPanel.PhoneDirectory;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
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
import ru.beliro.adminorder.tables.TablePhoneDirectory;

/**
 *
 * @author kurbatov
 */
public class PhoneDirectory extends JPanel{
    
    private JPanel panelMain;
    private JPanel panelSouth;
    private JPanel panelNorth;
    private JTable table;
    private JScrollPane scrollPane;
    
    private TableRowSorter<TablePhoneDirectory> rowSorter = new TableRowSorter<>(new TablePhoneDirectory());
    
    private JTextField jtfFilter = new JTextField();
    
    DataController dataController = new DataController();  //Для тестирования добавления данных

    public PhoneDirectory() {
        createPanelMain();
    }

    private void createPanelMain(){
                
        panelMain = new JPanel(new BorderLayout());
        /********************************************/
        table = new JTable(new TablePhoneDirectory());
        table.getColumnModel().getColumn(0).setMinWidth(30);
        table.getColumnModel().getColumn(0).setMaxWidth(30);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setRowSorter(rowSorter);
        
        /********************************************/
        
        /*dataController.addWorker(1, "Вася", 919, "341964", 111, "vasy@beliro.ru");
        dataController.addWorker(2, "Петя", 921, "346419", 107, "pety@beliro.ru");*/
        dataController.addWorker("Вася", 919, "341964", 111, "vasy@beliro.ru");
        dataController.addWorker("Петя", 921, "346419", 107, "pety@beliro.ru");

        scrollPane = new JScrollPane(table);
        
        /********************************************/
        
        panelMain.add(scrollPane,BorderLayout.CENTER);  
        panelMain.add(searchForm(), BorderLayout.SOUTH);
        panelMain.add(editorForm(), BorderLayout.NORTH);
    }
    
    private JPanel editorForm(){
        panelNorth = new JPanel(new GridLayout(1, 3));
        
        JButton addButton = new JButton("Добавить контакт");
        
        /* Добавление не работает*/
        
        addButton.addActionListener((ActionEvent e) -> {
            AddFormDialog addFormDialog = new AddFormDialog();
        });
        
        /********************************************/
        
        /*Редактирование еще не делал*/
        
        JButton editButton = new JButton("Редактировать контакт");
        
        /********************************************/
        
        JButton deleteButton = new JButton("Удалить отмеченное");
        
        /*Это удаление работает криво, надо исправить*/
        
        deleteButton.addActionListener((ActionEvent e) -> {
            
           dataController.removeWorker(table.getSelectedRows());
           table.repaint();
        
        });
        
        
        /********************************************/
        
        panelNorth.add(addButton);
        panelNorth.add(editButton);
        panelNorth.add(deleteButton);
        
        return panelNorth;
    }
    
    /**
     * 
     * Строка поиска в телефонном справочнике
     * 
     * @return panelSouth
     */
    
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
