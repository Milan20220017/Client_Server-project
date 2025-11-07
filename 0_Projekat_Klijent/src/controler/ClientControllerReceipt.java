/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;
import java.util.List;
import Domain.*;
import Communication.Operation;
import Domain.ReceiptItem;


/**
 *
 * @author s
 */
public class ClientControllerReceipt extends ClientController {

    private static ClientControllerReceipt instance;

    private ClientControllerReceipt() {
    }

    public static ClientControllerReceipt getInstance() {
        if (instance == null) {
            instance = new ClientControllerReceipt();
        }
        return instance;
    }

    public void addReceipt(Receipt receipt) throws Exception {
        send(Operation.ADD_RECEIPT, receipt);
    }
    public List<Receipt> getReceipts(Object o) throws Exception{
        return (List<Receipt>) send(Operation.GET_RECEIPTS,o);
    }

    public boolean update(Receipt updatedReceipt) throws Exception {
        return (boolean) send(Operation.UPDATE_RECEIPT, updatedReceipt);
    }

    public int removeReceiptItem(ReceiptItem stari) throws Exception {
        return(int) send(Operation.DELETE_RECEIPTITEM,stari);
    }

}
