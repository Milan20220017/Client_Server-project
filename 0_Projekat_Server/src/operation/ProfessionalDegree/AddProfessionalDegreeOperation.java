/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.ProfessionalDegree;

import Domain.*;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author s
 */
public class AddProfessionalDegreeOperation extends AbstractGenericOperation{
           private ProfessionalDegree degreeToAdd;
           int affectedRows=0;


    @Override
    protected void preconditions(Domain.AbstractDomainObject param) throws Exception {

    }

    @Override
    protected void executeOperation(AbstractDomainObject param, String key) throws Exception {
        List<ProfessionalDegree>  allDegrees=broker.getAll((ProfessionalDegree) param,null);
         degreeToAdd=(ProfessionalDegree) param;
        for(ProfessionalDegree p: allDegrees ){
            if(p.getDegreeId()==degreeToAdd.getDegreeId()){
                return;
              
            }
        }
        affectedRows=broker.add(degreeToAdd);
       
    }
   public int getDegree(){
      return affectedRows;
   }
}
