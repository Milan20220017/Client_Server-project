/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.worker;

import operation.*;
import Domain.Worker;
import java.util.List;
/**
 *
 * @author s
 */
public class LoginOperation extends AbstractGenericOperation{
private Worker worker;


    @Override
    protected void preconditions(Domain.AbstractDomainObject param) throws Exception {
    }

    @Override
    protected void executeOperation(Domain.AbstractDomainObject param, String key) throws Exception {
        List<Worker>  allWorkers=broker.getAll((Worker) param,null);
        Worker workerLogin=(Worker) param;
        for(Worker w: allWorkers){
            if(w.getUsername().equals(workerLogin.getUsername())&& w.getPassword().equals(workerLogin.getPassword())){
                worker=w;
                return;
            }
        }
    }
   public Worker getWorkers(){
       return worker;
   }
    
}
