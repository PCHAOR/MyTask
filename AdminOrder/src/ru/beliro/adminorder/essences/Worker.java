/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.beliro.adminorder.essences;

/**
 *
 * @author kurbatov
 */
public class Worker {
    
    private int id;
    private String name;
    private int cabinet;
    private String cityPhone;
    private int innerPhone;
    private String email;

    public Worker() {
    }
    
    public Worker(int id, String name, int cabinet, String cityPhone, int innerPhone, String email) {
        this.id = id;
        this.name = name;
        this.cabinet = cabinet;
        this.cityPhone = cityPhone;
        this.innerPhone = innerPhone;
        this.email = email;
    }

    public int getId() {return id;}

    public String getName() {return name;}

    public int getCabinet() {return cabinet;}

    public String getCityPhone() {return cityPhone;}

    public int getInnerPhone() {return innerPhone;}

    public String getEmail() {return email;}
    
}
