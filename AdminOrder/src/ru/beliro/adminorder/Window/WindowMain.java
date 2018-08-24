/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.beliro.adminorder.Window;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import ru.beliro.adminorder.DataController;
import ru.beliro.adminorder.Window.CardPanel.PhoneDirectory.PhoneDirectory;

/**
 *
 * Класс главной формы приложения
 * 
 * @author kurbatov
 */
public class WindowMain extends JFrame {
    
    private JFrame frame;
    private MenuMain menuBar = new MenuMain();
    private JPanel backgroundPanelLeft;
    private JPanel backgroundPanelRight;
    
    private CardLayout card = new CardLayout();
    
    DataController dataController = new DataController();

    public WindowMain() {
       initComponents();
    }
    
    private void initComponents(){
       frame = new JFrame("Органайзер");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       frame.getContentPane().add(createBackgroundPanelLeft(),BorderLayout.WEST);
       frame.getContentPane().add(createBackgroundPanelRight(),BorderLayout.CENTER);
       frame.setJMenuBar(menuBar.getMenuMain());
       
       frame.pack();
       
       //dataController.addWorker(1, "Вася", 919, "341964", 111, "vasy@beliro.ru");
       
       //frame.setBounds(0,0,1000,300);
       frame.setMinimumSize(new Dimension(1000, 500));
       frame.setLocationRelativeTo(null);
       frame.setVisible(true);
    }
    
    private JPanel createBackgroundPanelLeft(){
        backgroundPanelLeft = new JPanel(new GridLayout(4, 1));
        backgroundPanelLeft.add(addButton("Сотрудники"));
        backgroundPanelLeft.add(addButton("Создать заявку"));
        backgroundPanelLeft.add(addButton("Просмотр заявок",new ShowOneCardAction()));
        backgroundPanelLeft.add(addButton("Телефонный справочник", new ShowTwoCardAction()));
        
        
        return backgroundPanelLeft;
    }
    
    private JPanel createBackgroundPanelRight(){
        backgroundPanelRight = new JPanel(card);
        
        JPanel card1 = new JPanel();
        card1.add(new Label("Первая карта"));
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        
        backgroundPanelRight.add(card1, "1");
        backgroundPanelRight.add(phoneDirectory.getPanel(), "2");

        return backgroundPanelRight;
    }
    
    private JButton addButton(String name){
        JButton button = new JButton(name);
        return button;
    }
    
    private JButton addButton(String name, AbstractAction ab){
        JButton button = new JButton(name);
        button.addActionListener(ab);
        return button;
    }
   
   private class ShowOneCardAction extends AbstractAction {
      @Override
      public void actionPerformed(ActionEvent e) {
         card.show(backgroundPanelRight, "1");
      }
   }
   private class ShowTwoCardAction extends AbstractAction {
      @Override
      public void actionPerformed(ActionEvent e) {
         card.show(backgroundPanelRight, "2");
      }
   }    
}
