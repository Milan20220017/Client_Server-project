/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.receipt;

import Domain.*;
import java.util.ArrayList;
import java.util.List;
import operation.*;
/**
 *
 * @author s
 */
public class GetReceiptsOperation extends AbstractGenericOperation{
    List<Receipt> allReceipts=new ArrayList<>();


    @Override
    protected void preconditions(Domain.AbstractDomainObject param) throws Exception {
            if (param != null && !(param instanceof Receipt)) {
        throw new Exception("Invalid parameter type. Expected null or Receipt.");
    }
    }

    @Override
    protected void executeOperation(Domain.AbstractDomainObject param, String key) throws Exception {
        if(param==null){
        allReceipts=broker.getAll(new Receipt(),key);
        }
        else if(param instanceof Receipt){
                   Receipt receipt=new Receipt();
                   receipt.setWhere((Receipt) param);
           String condition=receipt.getWhere();
            allReceipts=broker.getAll(new Receipt(), condition);
        }
        for(int i=0;i<allReceipts.size();i++){
           ReceiptItem recitem=new ReceiptItem();
           recitem.setWhere(allReceipts.get(i));
           allReceipts.get(i).setItemList(broker.getAll(new ReceiptItem(),recitem.getWhere()));
        }
     
    }
   public List<Receipt> getReceipts(){
       return allReceipts;
   }
}
