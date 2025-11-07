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
public class DeleteWorkerOperation extends AbstractGenericOperation{
                private boolean legal=false;
List<Worker> allWorkers=new ArrayList<>();


    @Override
    protected void preconditions(Domain.AbstractDomainObject param) throws Exception {
           if (param == null || !(param instanceof Worker)) {
        throw new Exception("Invalid data: expected a Worker object.");
    }
    }

    @Override
    protected void executeOperation(Domain.AbstractDomainObject param, String key) throws Exception {
                  Receipt receipt=new Receipt();
        receipt.setWorker((Worker) param);
        receipt.setWhere(receipt);
       List<Receipt> allCustomersReceipt=broker.getAll(new Receipt(),receipt.getWhere()); 
       if(!allCustomersReceipt.isEmpty())return;
       WrkPD wrkpd=new WrkPD();
       wrkpd.setWhere(param);
       List<WrkPD> allWrkPd=broker.getAll(new WrkPD(),wrkpd.getWhere());
       if(!allWrkPd.isEmpty())return;
            broker.delete(param);
            legal=true;
        }
    public boolean isLegal(){
        return legal;
    }
     
}
