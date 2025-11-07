/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.ProfessionalDegree;
import Domain.ProfessionalDegree;
import Domain.Receipt;
import Domain.Worker;
import Domain.WrkPD;
import java.util.ArrayList;
import java.util.List;
import operation.*;
/**
 *
 * @author s
 */
public class DeleteProfessionalDegreeOperation extends AbstractGenericOperation{
                    private boolean legal=false;
List<ProfessionalDegree> allDegrees=new ArrayList<>();


    @Override
    protected void preconditions(Domain.AbstractDomainObject param) throws Exception {
    }

    @Override
    protected void executeOperation(Domain.AbstractDomainObject param, String key) throws Exception {
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
