/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.worker;

import Domain.*;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author s
 */
public class AddWorkerOperation extends AbstractGenericOperation{
       private Worker customerToAdd;
       int affectedRows=0;


    @Override
    protected void preconditions(Domain.AbstractDomainObject param) throws Exception {
            if (param == null || !(param instanceof Worker)) {
        throw new Exception("Invalid data: expected a Worker object.");
    }
    }

    @Override
    protected void executeOperation(Domain.AbstractDomainObject param, String key) throws Exception {
        List<Worker>  allWorkers=broker.getAll((Worker) param,null);
         customerToAdd=(Worker) param;
        for(Worker w: allWorkers ){
            if(w.getWorkerId()==customerToAdd.getWorkerId()){
                return;
              
            }
        }
        affectedRows=broker.add(customerToAdd);
       
    }
   public int getWorkers(){
       return affectedRows;
   }
   
}
