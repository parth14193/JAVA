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
        boolean valid = false;
      try{
          DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyyHH:mm:ss");
      
        String datetime = "03/08/2017 08:46:00";
        DateTime dob = formatter.parseDateTime(datetime);
            System.out.println(dob);
      }
      catch(Exception e){
          System.out.println(e);
      }
    }
    }
