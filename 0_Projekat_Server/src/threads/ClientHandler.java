/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import Communication.Operation;
import static Communication.Operation.DELETE_CUSTOMER;
import static Communication.Operation.UPDATE_CUSTOMER;
import Communication.Response;
import Communication.Sender;
import Communication.Receiver;
import Communication.Request;
import Domain.*;
import controller.Controller;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author s
 */
public class ClientHandler extends Thread {
    private Socket socket;
    private Sender sender;
    private Receiver receiver;
    private boolean flag;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        this.sender = new Sender(socket);
        this.receiver = new Receiver(socket);
        this.flag = true;
    }

    public void stopThread() {
        try {
            flag = false;
            socket.close();
            interrupt();
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while (flag) {
            try {
                Request request = (Request) receiver.receive();
                Response response = new Response();
             if(request!=null){
                    switch (request.getOperation()) {
                    case ADD_CITY:
                        City city=(City) request.getArgument();
                        city=Controller.getInstance().addCity(city);
                        response.setResult(city);
                            break;
                    case ADD_CUSTOMER:
                        Customer customer=(Customer) request.getArgument();
                        int addedCustomer=Controller.getInstance().addCustomer(customer);
                        response.setResult(addedCustomer);
                        break;
                    case ADD_WORKER:
                        Worker worker=(Worker) request.getArgument();
                        int addedWorker=Controller.getInstance().addWorker(worker);
                        response.setResult(addedWorker);
                        break;
                    case ADD_WS:
                        Worker workerWithPd=(Worker) request.getArgument();
                        int addedWrkdPd=Controller.getInstance().addWrkPD(workerWithPd);
                        response.setResult(addedWrkdPd);
                        break;
                    case ADD_PAINTING:
                        Painting paintingToAdd=(Painting) request.getArgument();
                        int addedPainting=Controller.getInstance().addPainting(paintingToAdd);
                        response.setResult(addedPainting);
                        break;
                    case ADD_RECEIPT:
                        Receipt receiptToAdd=(Receipt) request.getArgument();
                        int addedReceipt=Controller.getInstance().addReceipt(receiptToAdd);
                        response.setResult(addedReceipt);
                        break;
                    case ADD_PROFESSIONAMDEGREE:
                        ProfessionalDegree degreeToAdd=(ProfessionalDegree) request.getArgument();
                        int addedDegree=Controller.getInstance().addDegree(degreeToAdd);
                        response.setResult(addedDegree);
                        break;
                    case GET_PROFFESIONALDEGREES:
                        ProfessionalDegree professionalDegreeToAdd=(ProfessionalDegree) request.getArgument();
                        List<AbstractDomainObject> allDegrees=Controller.getInstance().getProfessionalDegrees(professionalDegreeToAdd);
                        response.setResult(allDegrees);
                        break;
                    case GET_CUSTOMERS:
                        Object getCusParam=request.getArgument();
                        List<AbstractDomainObject> allCustomers=Controller.getInstance().getCustomers(getCusParam);
                        response.setResult(allCustomers);
                        break;
                    case GET_RECEIPTS:
                        Object getRecParam=(Object) request.getArgument();
                        List<Receipt> allReceipts=Controller.getInstance().getReceipts(getRecParam);
                        response.setResult(allReceipts);
                        break;
                    case GET_WORKERS:
                        Object getWorParam=request.getArgument();
                        List<AbstractDomainObject> allWorkers=Controller.getInstance().getWorkers(getWorParam);
                        response.setResult(allWorkers);
                        break;
                    case GET_PAINTINGS:
                        Object getPaintParam=request.getArgument();
                        List<AbstractDomainObject> allPaintings=Controller.getInstance().getPaintings(getPaintParam);
                        response.setResult(allPaintings);
                        break;
                    case UPDATE_PD:
                        ProfessionalDegree professionalDegreeToEdit=(ProfessionalDegree) request.getArgument();
                        int EditedDegree=Controller.getInstance().editProfessionalDegrees(professionalDegreeToEdit);
                        response.setResult(EditedDegree);
                        break;
                    case UPDATE_CUSTOMER:
                        Customer customerToChange=(Customer) request.getArgument();
                        boolean isCustomerUpdated = Controller.getInstance().updateCustomer(customerToChange);
                        response.setResult(isCustomerUpdated);
                        break;
                        case UPDATE_WORKER:
                        Worker workerToChange=(Worker) request.getArgument();
                        boolean isWorkerUpdated = Controller.getInstance().updateWorker(workerToChange);
                        response.setResult(isWorkerUpdated);
                        break;
                        case UPDATE_RECEIPT:
                            Receipt updatedReceipt=(Receipt) request.getArgument();
                            boolean isReceiptUpdated=Controller.getInstance().updateReceipt(updatedReceipt);
                            response.setResult(isReceiptUpdated);
                            break;
                    case DELETE_CUSTOMER:
                        Customer deleteCustomer=(Customer) request.getArgument();
                        boolean isDeleted=Controller.getInstance().deleteCustomer(deleteCustomer);
                        response.setResult(isDeleted);
                       break;
                       case DELETE_WORKER:
                       Worker deleteWorker=(Worker) request.getArgument();
                        boolean isWorkerDeleted=Controller.getInstance().deleteWorker(deleteWorker);
                        response.setResult(isWorkerDeleted);
                       break;
                       case DELETE_PROFFESIONALDEGREE:
                           ProfessionalDegree pdToDelete=(ProfessionalDegree) request.getArgument();
                           boolean deletedSuccessfully=Controller.getInstance().deleteProfessionalDegree(pdToDelete);
                           response.setResult(deletedSuccessfully);
                           break;
                       case DELETE_RECEIPTITEM:
                           ReceiptItem itemForDeleting=(ReceiptItem) request.getArgument();
                           int affectedRows=Controller.getInstance().deleteReceiptItem(itemForDeleting);
                            response.setResult(affectedRows);
                           break;
                    case GET_CITIES:
                        List<AbstractDomainObject> allCities=Controller.getInstance().getCities();
                        response.setResult(allCities);
                        break;
                    case LOGIN:
                        Worker w=(Worker) request.getArgument();
                        w=Controller.getInstance().login(w);
                        response.setResult(w);
                        break;
                    default:
                        throw new AssertionError();
                }
                sender.send(response);
                }
                else{
                    stopThread();
                }
            } catch (Exception ex) {
    Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, "Client disconnected or error occurred", ex);
                stopThread();
            break;   
            }
        }
    }
}