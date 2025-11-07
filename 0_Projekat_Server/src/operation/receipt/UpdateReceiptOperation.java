/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.receipt;

import Domain.Receipt;
import Domain.ReceiptItem;
import java.util.ArrayList;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author s
 */
public class UpdateReceiptOperation extends AbstractGenericOperation{
        List<ReceiptItem> oldList=new ArrayList<>();
        Receipt updatedReceipt=new Receipt();
    @Override
    protected void preconditions(Domain.AbstractDomainObject param) throws Exception {
            if (param == null || !(param instanceof Receipt)) {
        throw new Exception("Invalid data: expected a Receipt object.");
    }
    }

    @Override
    protected void executeOperation(Domain.AbstractDomainObject param, String key) throws Exception {
        
        updatedReceipt=(Receipt) param;
        
        ReceiptItem onlyForCondition=new ReceiptItem();
        onlyForCondition.setWhere(updatedReceipt);
  oldList=broker.getAll(new ReceiptItem(),onlyForCondition.getWhere());
for (ReceiptItem newItem : updatedReceipt.getItemList()) {
    int index = oldList.indexOf(newItem);
    if (index == -1) {
        broker.add(newItem);
    } else {
        ReceiptItem oldItem = oldList.get(index);
            if(hasContentChanged(newItem, oldItem)){
            broker.edit(newItem);
        }
    }
}

for (ReceiptItem oldItem : oldList) {
    if (!updatedReceipt.getItemList().contains(oldItem)) {
        broker.delete(oldItem);
    }
         }
broker.edit(updatedReceipt);
    }
   public boolean getCustomers(){
       return true;
   }

   public boolean hasContentChanged(ReceiptItem newItem, ReceiptItem oldItem) {
    if (!newItem.getPainting().equals(oldItem.getPainting())) return true;
    if (newItem.getPrice() != oldItem.getPrice()) return true;
    return newItem.getValue() != oldItem.getValue();
    }
}
