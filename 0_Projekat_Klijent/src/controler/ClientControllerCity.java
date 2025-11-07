/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import Communication.Operation;
import java.util.List;
import Domain.City;
import Domain.AbstractDomainObject;

/**
 *
 * @author s
 */
public class ClientControllerCity extends ClientController{
    
private static ClientControllerCity instance;
    public static ClientControllerCity getInstance(){
        if(instance == null)
            instance = new ClientControllerCity();
        return instance;
    }
    private ClientControllerCity(){
    }
    public City addCity(City city) throws Exception {
        return (City) send(Operation.ADD_CITY, city);
    }
    
    public void deleteCity(AbstractDomainObject odo) throws Exception{
        odo.setWhere(null);
        send(Operation.DELETE_CITY, odo);
    }
    
    public City getCity(City c) throws Exception{
        return (City)send(Operation.ADD_CITY, c);
    }
    
    public boolean changupdateCity(City c) throws Exception{
        return (boolean) send(Operation.UPDATE_CITY, c);
    }
    
    public List<AbstractDomainObject> getCities() throws Exception{
        return (List<AbstractDomainObject>) send(Operation.GET_CITIES,null);
    }
    
       public List<AbstractDomainObject> getCities(String s) throws Exception{
        return (List<AbstractDomainObject>) send(Operation.GET_CITIES,s);
    }
    
}
