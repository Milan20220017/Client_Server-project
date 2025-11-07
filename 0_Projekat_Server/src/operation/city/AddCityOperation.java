/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.city;
import Domain.*;
import java.util.List;
import operation.*;

/**
 *
 * @author s
 */
public class AddCityOperation extends AbstractGenericOperation {
    
private City cityToAdd;


    @Override
    protected void preconditions(AbstractDomainObject param) throws Exception {
    }

    @Override
    protected void executeOperation(AbstractDomainObject param, String key) throws Exception {
        List<City>  allCities=broker.getAll((City) param,null);
         cityToAdd=(City) param;
        for(City c: allCities){
            if(c.getMunicipality().equals(cityToAdd.getMunicipality()) && c.getPostalCode().equals(cityToAdd.getPostalCode())){
                return;
              
            }
        }
        broker.add(cityToAdd);
       
    }
   public City getCity(){
       return cityToAdd;
   }
   

}
