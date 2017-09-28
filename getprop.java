/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.amazone;

import java.io.*;
import java.util.Properties;

/**
 *
 * @author parth
 */
public class getprop {
    
    public static void main(String args[]) throws IOException
    {
      Properties prop = new Properties();
      InputStream input = null;
      
      input = new FileInputStream("C:\\Users\\parth\\Documents\\NetBeansProjects\\amazone\\src\\main\\java\\com\\mycompany\\amazone\\aws.properties");
      
      prop.load(input);
     
        System.out.println(prop.getProperty("AWS_ACCESS_KEY_ID"));
        System.err.println(prop.getProperty("AWS_SECRET_ACCESS_KEY"));
        System.err.println(prop.getProperty("bucket_name"));
    }
    
}
