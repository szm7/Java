/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.conference;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author krrah
 */
public class Conference {

    public static void main(String[] args) {
        
        try {
            Class.forName("com.mycompany.conference.Rahul");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conference.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
class Rahul{
    static{
        System.out.println("Static Block");
    }
    {
        System.out.println("Instance Block");
    }
}