/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.customer;

import Domain.*;
import java.util.ArrayList;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author s
 */
public class GetCustomersOperation extends AbstractGenericOperation{
        
List<AbstractDomainObject> allCustomers=new ArrayList<>();


    @Override
    protected void preconditions(Domain.AbstractDomainObject param) throws Exception {
//        if (param != null && !(param instanceof City || param instanceof String)) {
//        throw new Exception("Invalid parameter type for customer retrieval.");
//        }   
    }

    @Override
    protected void executeOperation(Domain.AbstractDomainObject param, String key) throws Exception {
        if(param==null && key==null){
        allCustomers=broker.getAll(new Customer(),key);
        }
        else if(key!=null){
            Customer customer=new Customer();
                   customer.setWhere(key);
           String condition=customer.getWhere();
            allCustomers=broker.getAll(new Customer(), condition);
        }
       else if(param instanceof City){
           String condition=" WHERE "+((City) param).getPrimaryKeyCondition();
            allCustomers=broker.getAll(new Customer(), condition);
        }
     
    }
   public List<AbstractDomainObject> getCustomers(){
       return allCustomers;
   }
}
