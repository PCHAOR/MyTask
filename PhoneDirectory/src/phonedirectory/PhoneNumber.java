/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonedirectory;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author User
 */
public class PhoneNumber {
    
    private ArrayList<String> phoneNumber = new ArrayList<>();
    
    public PhoneNumber(String ... name) {
        for(int i = 0; i < name.length;i++){
           setPhoneNumber(name[i]); 
        }
    }

    public ArrayList<String> getPhoneNumber() {
        return phoneNumber;
    }

    private void setPhoneNumber(String name) {
        this.phoneNumber.add(name);
    }
    
    @Override
    public String toString(){
        String result = "";
        int i = 1;
        for (Iterator<String> iterator = getPhoneNumber().iterator(); iterator.hasNext();) {
            String next = iterator.next();
            result += "\n"+ i + ". " + next;
            i++;
        }
        return result;
    }
}
