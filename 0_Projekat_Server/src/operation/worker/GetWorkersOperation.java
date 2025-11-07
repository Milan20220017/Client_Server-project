/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.worker;

import Domain.*;
import java.util.ArrayList;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author s
 */
public class GetWorkersOperation extends AbstractGenericOperation{
            
List<AbstractDomainObject> allWorkers=new ArrayList<>();


    @Override
    protected void preconditions(AbstractDomainObject param) throws Exception {
//           if (param != null && !(param instanceof String)) {
//        throw new Exception("Invalid parameter type. Expected null or String.");
//    }
    }

    @Override
    protected void executeOperation(AbstractDomainObject param, String key) throws Exception {
        if(param==null && key==null){
        allWorkers=broker.getAll(new Worker(),key);
        }
       else if(key!=null){
                   Worker worker=new Worker();
                   worker.setWhere(key);
                   String condition=worker.getWhere();
            allWorkers=broker.getAll(new Worker(), condition);
        }
     
    }
   public List<AbstractDomainObject> getWorkers(){
       return allWorkers;
   }
}
