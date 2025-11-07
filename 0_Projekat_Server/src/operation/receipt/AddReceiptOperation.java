    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package operation.receipt;
    import Domain.*;
    import java.util.List;
    import operation.AbstractGenericOperation;
    /**
     *
     * @author s
     */
    public class AddReceiptOperation extends AbstractGenericOperation{
                private Receipt receiptToAdd;
                private int affectedRows=0;


        @Override
        protected void preconditions(Domain.AbstractDomainObject param) throws Exception {
    if (!(param instanceof Receipt)) {
        throw new Exception("Invalid object type. Expected Receipt.");
    }
        Receipt receipt = (Receipt) param;

    if (receipt.getCustomer() == null) {
        throw new Exception("Receipt must have a customer.");
    }

    if (receipt.getWorker() == null) {
        throw new Exception("Receipt must have a worker.");
    }

    if (receipt.getItemList() == null || receipt.getItemList().isEmpty()) {
        throw new Exception("Receipt must contain at least one item.");
    }

    for (ReceiptItem item : receipt.getItemList()) {
        if (item.getPainting() == null) {
            throw new Exception("Each receipt item must have an associated painting.");
        }

        if (item.getQuantity() <= 0) {
            throw new Exception("Quantity must be greater than zero for all receipt items.");
        }

        if (item.getPrice() <= 0) {
            throw new Exception("Price must be greater than zero for all receipt items.");
        }
    }
        }

        @Override
        protected void executeOperation(Domain.AbstractDomainObject param, String key) throws Exception {
            List<Receipt>  allReceipts=broker.getAll((Receipt) param,null);
             receiptToAdd=(Receipt) param;
            for(Receipt r: allReceipts ){
                if(r.getReceiptId()==receiptToAdd.getReceiptId()){
                    return;

                }
            }
            affectedRows=broker.add(receiptToAdd);
            if(affectedRows>0){
                for(ReceiptItem recItem: receiptToAdd.getItemList()){
                    recItem.setReceiptId(affectedRows);
                    broker.add(recItem);

                }
            }

        }
       public int getReceipt(){
           return affectedRows;
       }
    }
