/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.painting;
import Domain.Customer;
import Domain.Painting;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author s
 */
public class AddPaintingOperation extends AbstractGenericOperation{
        private Painting paintingToAdd;
        int affectedRows=0;


    @Override
    protected void preconditions(Domain.AbstractDomainObject param) throws Exception {
            if (!(param instanceof Painting)) {
        throw new Exception("Invalid object type. Expected Painting.");
        }
    }

    @Override
    protected void executeOperation(Domain.AbstractDomainObject param, String key) throws Exception {
        List<Painting>  allCustomers=broker.getAll((Painting) param,null);
         paintingToAdd=(Painting) param;
        for(Painting p: allCustomers ){
            if(p.getPaintingId()==paintingToAdd.getPaintingId()){
                return;
              
            }
        }
        affectedRows=broker.add(paintingToAdd);
       
    }
   public int getPainting(){
        return affectedRows;
   }
}
