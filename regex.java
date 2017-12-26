/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.amazone;
import java.util.regex.*;
import org.apache.log4j.*;

/**
 *
 * @author parth
 */
public class regex {
        static  Logger log = Logger.getLogger(kafkaconsume.class.getName());

    public static void main(String[] args) {
     Pattern p = Pattern.compile("\\w+\\=(.\\d?.\\d.\\d.\\d)");
     Matcher m = p.matcher("src=10.0.0.1");
     boolean b  = m.matches();
     log.debug(m);
     if (b==true)
     {
        for (int i = 0; i <= m.groupCount(); i++)
                System.out.println(m.group(i));
     }
     else 
     {
      System.out.println("capturing group are not matching");
     }
    }
}
