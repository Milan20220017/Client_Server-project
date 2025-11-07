/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.util.List;
import Domain.City;
import Domain.Customer;
import Domain.AbstractDomainObject;
import Communication.Operation;

/**
 *
 * @author Andrej
 */
public class ClientControllerCustomer extends ClientController {

    private static ClientControllerCustomer instance;

    private ClientControllerCustomer() {
    }
    public static ClientControllerCustomer getInstance() {
        if (instance == null) {
            instance = new ClientControllerCustomer();
        }
        return instance;
    }
    public int addCustomer(Customer c) throws Exception {

        return (int) send(Operation.ADD_CUSTOMER, c);
    }
     public boolean deleteCustomer(Customer c) throws Exception{
        return (boolean) send(Operation.DELETE_CUSTOMER, c);
    }
    
    public Customer getCustomer(Customer c) throws Exception{
        return (Customer) send(Operation.GET_CUSTOMER, c);
    }
    
    public boolean updateCustomer(AbstractDomainObject odo) throws Exception{
        return (boolean) send(Operation.UPDATE_CUSTOMER, odo);
    }

    public List<AbstractDomainObject> getCustomers(Object o) throws Exception {

        return (List<AbstractDomainObject>) send(Operation.GET_CUSTOMERS, o);
    }    
}
