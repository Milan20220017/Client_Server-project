/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configuration;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author s
 */
public class Configuration {
    private static Configuration instance;
    private Properties properties;
    
    private Configuration(){
        properties = new Properties();
        try {
            properties.load(new FileInputStream("C:\\ProSoft_0000\\0_Projekat_Zajednicki\\config\\dbconfig.properties"));
        } catch (IOException ex) {
            System.out.println("Error occured while writing to file");
//            Ako fajl ne postoji kreitrati ga i aplikacija ne moze da se pokrene dok se ne popuni!!!!!!!!!
            
        }
    }
    public static Configuration getInstance(){
        if(instance == null){
            instance = new Configuration();
        }
        return instance;
    }


    
    public String getProperty(String s){
        return properties.getProperty(s,"n/a");
    }
    public void setProperty(String key, String value){
        properties.setProperty(key, value);
    }
    
    public void saveChanges(){
        
        try {
            properties.store(new FileOutputStream("C:\\ProSoft_0000\\0_Projekat_Zajednicki\\config\\dbconfig.properties"),null);
        } catch (IOException ex) {
            System.out.println("Function saveChanges() was not successful");
        }
    }
    
}
