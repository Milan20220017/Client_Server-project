/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.painting;
import Domain.*;
import java.util.ArrayList;
import java.util.List;
import operation.AbstractGenericOperation;
/**
 *
 * @author s
 */
public class GetPaintingsOperation extends AbstractGenericOperation{
            
List<AbstractDomainObject> allPaintings=new ArrayList<>();


    @Override
    protected void preconditions(AbstractDomainObject param) throws Exception {
//        if (param != null && !(param instanceof String)) {
//        throw new Exception("Invalid parameter type for painting retrieval.");
//    }
    }

    @Override
    protected void executeOperation(AbstractDomainObject param, String key) throws Exception {
            if(param==null && key==null){
        allPaintings=broker.getAll(new Painting(),key);
        }
       else if(key!=null){
                   Painting painting=new Painting();
                   painting.setWhere(key);
           String condition=painting.getWhere();
            allPaintings=broker.getAll(new Painting(), condition);
        }
     
    }
   public List<AbstractDomainObject> getPaintings(){
       return allPaintings;
   }
}
