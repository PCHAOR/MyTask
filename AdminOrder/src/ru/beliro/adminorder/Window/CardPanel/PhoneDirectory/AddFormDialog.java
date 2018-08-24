/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.beliro.adminorder.Window.CardPanel.PhoneDirectory;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import ru.beliro.adminorder.DataController;

/**
 *
 * @author kurbatov
 */
public class AddFormDialog extends JDialog{
    
    private JDialog formDialog;
    private JPanel panel;
    
    private String [] key = {"ФИО","Кабинет","Городской телефон","Внутренний телефон","Email"};
    private int [] countKey = {1,2,3,4,5};
    private HashMap<Integer, JTextField> textFieldStorage = new HashMap<>();
    
    //ArrayList<JTextField> textFieldStorage = new ArrayList<>();
    
    public AddFormDialog(){
       initComponent();
    }
    
    private JDialog initComponent(){
        formDialog = new JDialog(this,"Создать новый контакт",true);
        formDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        formDialog.getContentPane().add(addForm());
        
        formDialog.pack();
        
        formDialog.setMinimumSize(new Dimension(500, 300));
        formDialog.setLocationRelativeTo(null);
        formDialog.setVisible(true);
        
        return formDialog;
    }
    
    private JPanel addForm(){
        
        panel = new JPanel(new GridLayout(6, 2));
        
        for(int i = 0; i < 5; i++){
            createTextField(key[i],countKey[i]);
        }
        
        JButton addButton = new JButton("Добавить");
        
        panel.add(addButton);
        
        addButton.addActionListener((ActionEvent e) -> {
            DataController dataController = new DataController();
            
            String name = null, cityPhone = null, email = null;
            int cabinet = 0, innerPhone = 0;
            
            for(HashMap.Entry<Integer, JTextField> entry : textFieldStorage.entrySet()){
                
                        int key1 = entry.getKey();

                        System.out.println(key1);

                        switch(key1){
                            case 1: name = entry.getValue().getText();
                            case 2: cabinet = Integer.parseInt(entry.getValue().getText());
                            case 3: cityPhone = entry.getValue().getText();
                            case 4: innerPhone = Integer.parseInt(entry.getValue().getText());
                            case 5: email = entry.getValue().getText();
                        }
                }
            
            dataController.addWorker(name, cabinet, cityPhone, innerPhone, email);
            dispose();
            
            });
        
        return panel;
    }
    
    private void createTextField(String key, int countKey){
        JLabel textLabel = new JLabel(key);
        JTextField textField = new JTextField();
        
        textFieldStorage.put(countKey, textField);
        
        panel.add(textLabel);
        panel.add(textField);
    }
    
}
