/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.customer;

import Domain.City;
import Domain.Customer;
import Domain.Receipt;
import java.util.ArrayList;
import java.util.List;
import operation.*;

/**
 *
 * @author s
 */
public class DeleteCutomerOperation extends AbstractGenericOperation{
            boolean result=false;
List<Customer> allCustomers=new ArrayList<>();


    @Override
    protected void preconditions(Domain.AbstractDomainObject param) throws Exception {
                        if (!(param instanceof Customer)) {
        throw new Exception("Invalid object type. Expected Customer.");
        }        

    }

    @Override
    protected void executeOperation(Domain.AbstractDomainObject param, String key) throws Exception {
                Receipt receipt=new Receipt();
        receipt.setCustomer((Customer) param);
        receipt.setWhere(receipt);
       List<Receipt> allCustomersReceipt=broker.getAll(new Receipt(),receipt.getWhere()); 
       if(!allCustomersReceipt.isEmpty()){
           return;
       }
            broker.delete(param);
            result=true;
        }
    public boolean returnResult(){
        return result;
    }
     
    }


