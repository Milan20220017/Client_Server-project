/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.receipt;

import Domain.Customer;
import Domain.Receipt;
import java.util.ArrayList;
import java.util.List;
import operation.*;

/**
 *
 * @author s
 */
public class DeleteReceiptItemOperation extends AbstractGenericOperation{
                
List<Customer> allCustomers=new ArrayList<>();


    @Override
    protected void preconditions(Domain.AbstractDomainObject param) throws Exception {
           if (!(param instanceof Receipt)) {
        throw new Exception("Invalid object type. Expected Receipt.");
    }
    }

    @Override
    protected void executeOperation(Domain.AbstractDomainObject param, String key) throws Exception {
            broker.delete(param);
        }

}
