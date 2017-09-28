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
import java.io.StringWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONException;

public class json {

    
    public static void main(String args[]) throws JSONException, FileNotFoundException, IOException, ParseException
    {
      
        JSONParser parser = new JSONParser();
        //Use JSONObject for simple JSON and JSONArray for array of JSON.
        Object  data =  parser.parse(
              new FileReader("C:\\Users\\parth\\Desktop\\sample.txt"));//path to the JSON file.
              JSONObject jsonObject = (JSONObject) data;
              System.out.println(jsonObject);
              
    }       
    }
    

