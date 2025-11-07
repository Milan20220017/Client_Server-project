/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.city;

import Domain.City;
import java.util.ArrayList;
import java.util.List;
import operation.AbstractGenericOperation;
import Domain.AbstractDomainObject;

/**
 *
 * @author s
 */
public class GetCitiesOperation extends AbstractGenericOperation{
    
List<AbstractDomainObject> allCities=new ArrayList<>();


    @Override
    protected void preconditions(Domain.AbstractDomainObject param) throws Exception {
    }

    @Override
    protected void executeOperation(Domain.AbstractDomainObject param, String key) throws Exception {
        if(param!=null){
        allCities=broker.getAll((City) param,null);
        }
     
    }
   public List<AbstractDomainObject> getCity(){
       return allCities;
   }
}
