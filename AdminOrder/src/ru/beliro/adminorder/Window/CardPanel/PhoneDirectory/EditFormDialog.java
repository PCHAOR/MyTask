/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.beliro.adminorder.Window.CardPanel.PhoneDirectory;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import ru.beliro.adminorder.DataController;

/**
 *
 * @author kurbatov
 */
public class EditFormDialog extends JDialog {
    
    private JDialog formDialog;
    private JPanel panel;
    
    private String [] key = {"ФИО","Кабинет","Городской телефон","Внутренний телефон","Email"};
    private int [] countKey = {1,2,3,4,5};
    private HashMap<Integer, JTextField> textFieldStorage = new HashMap<>();
    
    public EditFormDialog(int worker){
       initComponent(worker);
    }
    
    private JDialog initComponent(int worker){
        formDialog = new JDialog(this,"Редактирование контакта",true);
        formDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        formDialog.getContentPane().add(editForm(worker));
        
        formDialog.pack();
        
        formDialog.setMinimumSize(new Dimension(500, 300));
        formDialog.setLocationRelativeTo(null);
        formDialog.setVisible(true);
        
        return formDialog;
    }
    
    private JPanel editForm(int worker){
        
        panel = new JPanel(new GridLayout(6, 2));
        
        for(int i = 0; i < 5; i++){
            createTextField(key[i],countKey[i],worker);
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
                            case 1: name = new String(entry.getValue().getText()); break;
                            case 2: cabinet = Integer.parseInt(entry.getValue().getText()); break;
                            case 3: cityPhone = entry.getValue().getText(); break;
                            case 4: innerPhone = Integer.parseInt(entry.getValue().getText()); break;
                            case 5: email = entry.getValue().getText(); break;
                        }
                        
                        System.out.println(name);
                        System.out.println(cabinet);
                        System.out.println(cityPhone);
                        System.out.println(innerPhone);
                        System.out.println(email);
                }
            
            dataController.addWorker(name, cabinet, cityPhone, innerPhone, email);            
            });
        
        return panel;
    }
    
    private void createTextField(String key, int countKey, int worker){
        DataController dataController = new DataController();
        
        
        JLabel textLabel = new JLabel(key);
        JTextField textField = new JTextField();
        
        textFieldStorage.put(countKey, textField);
        
        panel.add(textLabel);
        panel.add(textField);
    }
    
}
