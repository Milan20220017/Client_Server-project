/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.customer;
import Domain.Customer;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author s
 */
public class AddCustomerOperation extends AbstractGenericOperation {
    private Customer customerToAdd;
    private int affectedRows;


    @Override
    protected void preconditions(Domain.AbstractDomainObject param) throws Exception {
            if (!(param instanceof Customer)) {
        throw new Exception("Invalid object type. Expected Customer.");
        }
    }

    @Override
    protected void executeOperation(Domain.AbstractDomainObject param, String key) throws Exception {
        List<Customer>  allCustomers=broker.getAll((Customer) param,null);
         customerToAdd=(Customer) param;
        for(Customer c: allCustomers ){
            if(c.getCustomerId()==customerToAdd.getCustomerId()){
                return;
              
            }
        }
        affectedRows=broker.add(customerToAdd);
       
    }
   public int getCustomer(){
       return affectedRows;
   }
   
}
