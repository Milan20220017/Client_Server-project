/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.ProfessionalDegree;


import Domain.*;
import java.util.ArrayList;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author s
 */
public class GetProfessionalDegreeOperation extends AbstractGenericOperation{
    List<AbstractDomainObject> allProfessionalDegrees=new ArrayList<>();

    @Override
    protected void preconditions(Domain.AbstractDomainObject param) throws Exception {
    }
    @Override
        protected void executeOperation(AbstractDomainObject param, String key) throws Exception {
        if(param==null){
        allProfessionalDegrees=broker.getAll(new ProfessionalDegree(),key);
        }
       else if(param instanceof ProfessionalDegree){
                ProfessionalDegree pd=new ProfessionalDegree();
                pd.setWhere(param);
           String condition=pd.getWhere();
            allProfessionalDegrees=broker.getAll(new ProfessionalDegree(), condition);
        }
     
    }
   public List<AbstractDomainObject> getWorkers(){
       return allProfessionalDegrees;
   }

}
