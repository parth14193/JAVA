/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.amazone;

import java.text.SimpleDateFormat;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author parth
 */
public class dateformate {
   
    public static void main(String[] args) {
        boolean valid = true;
      try{
          DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MMM-yy HH.ss.mm.SSSSSSSSS a");
      
        String datetime = "01-APR-17 12.13.07.079582000 AM";
        DateTime dob = formatter.parseDateTime(datetime);
            System.out.println(dob);
      }
      catch(Exception e){
          valid = false;
      }
        System.out.println(valid);
    }
    }
