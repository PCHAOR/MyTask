/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.beliro.adminorder;

import java.util.ArrayList;
import ru.beliro.adminorder.essences.Worker;

/**
 *
 * Класс предназначен для контроля изменений данных(добавление, редактирование, обновление)
 * 
 * @author kurbatov
 * 
 */
public class DataController {
    
    private static ArrayList<Worker> workers = new ArrayList<>();
    
    public ArrayList<Worker> getWorkers(){
        return workers;
    }

    public void setWorkers(ArrayList<Worker> workers) {
        this.workers.addAll(workers);
    }
    
    public void addWorker(String name, int cabinet, String cityPhone, int innerPhone, String email){
        workers.add(new Worker(workers.size() + 1, name, cabinet, cityPhone, innerPhone, email));
    }
    
    public void removeWorker(int[]index){
        for(int i = 0; i < index.length; i++){
            workers.remove(index[i]);
        }
    } 
}
