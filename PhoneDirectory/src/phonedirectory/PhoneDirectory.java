/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonedirectory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class PhoneDirectory {
    
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
    private static HashMap<String,PhoneNumber> contacts = new HashMap<String,PhoneNumber>();

    public PhoneDirectory(String fio, PhoneNumber phoneNumber) {
       addContact(fio, phoneNumber); 
    }
    
    private HashMap<String,PhoneNumber> addContact(String fio, PhoneNumber phoneNumber){  
        contacts.put(fio, phoneNumber);
        return contacts;
    }
    
    public static void getHashMap() throws IOException{
        String cmd = reader.readLine();
        boolean count = false;
         for(HashMap.Entry<String, PhoneNumber> entry : contacts.entrySet()){
             
             String key = new String(entry.getKey().getBytes("UTF-8"));
             
             if(cmd.hashCode() == entry.getKey().hashCode()){
                 System.out.println(key + " " + entry.getValue());
                 count = true;
             }
         }
         
         if(count == false){
             System.out.println("Такого контакта не существует");}         
    }
    
    public static void main(String[] args) throws IOException {
        
        PhoneDirectory pd = new PhoneDirectory("Иванов И.И.", new PhoneNumber("+8 800 2000 500","+8 800 200 600"));
        PhoneDirectory pd1 = new PhoneDirectory("Петров П.П.", new PhoneNumber("+8 800 2000 700"));
        PhoneDirectory pd2 = new PhoneDirectory("Сидоров С.С.", new PhoneNumber("+8 800 2000 800","+8 800 2000 900","+8 800 2000 000"));
        
        getHashMap();
      }
}
