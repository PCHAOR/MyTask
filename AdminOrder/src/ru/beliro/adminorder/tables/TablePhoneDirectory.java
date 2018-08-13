/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.beliro.adminorder.tables;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ru.beliro.adminorder.DataController;
import ru.beliro.adminorder.essences.Worker;

/**
 *
 * @author kurbatov
 */
public class TablePhoneDirectory extends AbstractTableModel {

    DataController dataController = new DataController();
    
    /*public TablePhoneDirectory(ArrayList<Worker> workers) {
        dataController.setWorkers(workers);
    }*/

    @Override
    public int getRowCount() {
        return dataController.getWorkers().size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }
    
    @Override
    public String getColumnName(int c) {
        String result = "";
        switch (c) {
            case 0:
                result = "ID";
                break;
            case 1:
                result = "ФИО";
                break;
            case 2:
                result = "Кабинет";
                break;
            case 3:
                result = "Городской";
                break;
            case 4:
                result = "Внутренний";
                break;
            case 5:
                result = "E-mail";
                break;
        }
        return result;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return dataController.getWorkers().get(rowIndex).getId();
            case 1:
                return dataController.getWorkers().get(rowIndex).getName();
            case 2:
                return dataController.getWorkers().get(rowIndex).getCabinet();
            case 3:
                return dataController.getWorkers().get(rowIndex).getCityPhone();
            case 4:
                return dataController.getWorkers().get(rowIndex).getInnerPhone();
            case 5:
               return dataController.getWorkers().get(rowIndex).getEmail();
            default:
                return "";
        }
    }
    
}
