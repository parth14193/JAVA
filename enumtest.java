/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.amazone;



/**
 *
 * @author parth
 */
public class enumtest {
   
 enum GuideView {
    SEVEN_DAY,
    NOW_SHOWING,
    ALL_TIMESLOTS
}
    
    public static void main(String[] args) {
     int which = 0;
   
         GuideView whichView = GuideView.values()[which];
    switch (whichView) {
        case SEVEN_DAY:
            System.err.println("1");
            break;
        case NOW_SHOWING:
            System.err.println("2");
            break;
    }
    
    }
    
}
