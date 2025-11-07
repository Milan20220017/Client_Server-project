/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.worker;

import Domain.*;
import operation.AbstractGenericOperation;
import java.util.List;

/**
 *
 * @author s
 */
public class AddWrkPdOperation extends AbstractGenericOperation{
           private int affectedRows=0;


    @Override
    protected void preconditions(Domain.AbstractDomainObject param) throws Exception {
            if (param == null || !(param instanceof Worker)) {
        throw new Exception("Invalid data: expected a Worker object.");
    }
    }

    @Override
    protected void executeOperation(Domain.AbstractDomainObject param, String key) throws Exception {
        Worker worker=(Worker) param;
        int lastOne=worker.getWs().size()-1;
        WrkPD added=worker.getWs().get(lastOne);
        added.setWhere(worker);
        List<WrkPD>  allWrkPd=broker.getAll(new WrkPD(),added.getWhere());
        if(allWrkPd.contains(added))return;
        for(WrkPD w: allWrkPd){
            if(w.getProfessionalDegree().getDegreeId()==added.getProfessionalDegree().getDegreeId()){
                return;
            }
        }
        affectedRows=broker.add(added);
    }
   public int getWrkPd(){
       return affectedRows;
   }
   
}
