/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.worker;

import operation.AbstractGenericOperation;
import Domain.*;

/**
 *
 * @author s
 */
public class UpdateWorkerOperation extends AbstractGenericOperation{
        
    @Override
    protected void preconditions(Domain.AbstractDomainObject param) throws Exception {
            if (param == null || !(param instanceof Worker)) {
        throw new Exception("Invalid data: expected a Worker object.");
    }
    }

    @Override
    protected void executeOperation(Domain.AbstractDomainObject param, String key) throws Exception {
        broker.edit(param);

    }
   public boolean getWorkers(){
       return true;
   }
}
