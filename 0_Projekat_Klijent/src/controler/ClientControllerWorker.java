/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import Communication.Operation;
import java.util.List;
import Domain.AbstractDomainObject;
import Domain.Worker;
import Domain.WrkPD;

/**
 *
 * @author s
 */
public class ClientControllerWorker extends ClientController {
    
    private static ClientControllerWorker instance;

    private ClientControllerWorker() {
    }
    
    public static ClientControllerWorker getInstance(){
        if(instance ==null)
            instance = new ClientControllerWorker();
        return instance;
    }
    
    public int addWorker(AbstractDomainObject odo) throws Exception{
        return (int) send(Operation.ADD_WORKER, odo);
    }
    
    public boolean deleteWorker(AbstractDomainObject odo) throws Exception{
//        odo.setWhere(null);
      return   (boolean) send(Operation.DELETE_WORKER, odo);
    }
    
    public Worker getWorker(AbstractDomainObject odo) throws Exception{
        odo.setWhere(null);
        return (Worker) send(Operation.GET_WORKER, odo);
    }
    
        public boolean updateWorker(AbstractDomainObject odo) throws Exception{
        return (boolean) send(Operation.UPDATE_WORKER, odo);
    }

    public Worker login(Worker w) throws Exception {
        w.setLogin();
        return (Worker) send(Operation.LOGIN, w);

    }
    
    public List<AbstractDomainObject> getWorkers(Object getWorParam) throws Exception{
        return (List<AbstractDomainObject>) send(Operation.GET_WORKERS, getWorParam);
    }
      public Worker getWorker(String s) throws Exception{
        return (Worker) send(Operation.GET_WORKERS, s);
    }
    public int addWS(Worker w) throws Exception{
       return (int) send(Operation.ADD_WS, w);
    }
    
    
    
}
