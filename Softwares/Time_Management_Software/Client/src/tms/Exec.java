package tms;


import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DHRUV
 */
class Exec extends Object implements Serializable {
    
    String name;
    String password;
    int id;
    
    Exec(String n,String pass,int empid)
    {
     name=n;
     password=pass;
     id=empid;
    }
}
