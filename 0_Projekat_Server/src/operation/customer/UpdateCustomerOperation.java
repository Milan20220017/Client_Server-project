/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.customer;

import Domain.City;
import Domain.Customer;
import java.util.ArrayList;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author s
 */
public class UpdateCustomerOperation extends AbstractGenericOperation{
    
    @Override
    protected void preconditions(Domain.AbstractDomainObject param) throws Exception {
                      if (!(param instanceof Customer)) {
        throw new Exception("Invalid object type. Expected Customer.");
        } 
    }

    @Override
    protected void executeOperation(Domain.AbstractDomainObject param, String key) throws Exception {
        broker.edit(param);

    }
   public boolean getCustomers(){
       return true;
   }
}
