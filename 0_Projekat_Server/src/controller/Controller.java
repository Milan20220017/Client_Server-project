/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Domain.*;
import java.util.List;
import operation.worker.LoginOperation;
import operation.customer.*;
import operation.city.*;
import operation.worker.*;
import operation.ProfessionalDegree.*;
import operation.painting.*;
import operation.receipt.*;


/**
 *
 * @author s
 */
public class Controller {
    private static Controller instance;
    int broj=0;

    public static Controller getInstance() {
        if(instance==null){
            instance=new Controller();
        }
        return instance;
    }

    private Controller() {
    }
    public Worker login(Worker w) throws Exception{
        LoginOperation operation=new LoginOperation();
        operation.execute(w, null);
        return operation.getWorkers();
    }
      public City addCity(City city) throws Exception {

          AddCityOperation addCity=new AddCityOperation();
        addCity.execute(city, null);
        return addCity.getCity();

    }
      public List<AbstractDomainObject> getCities() throws Exception{
          GetCitiesOperation getcities=new GetCitiesOperation();
          getcities.execute(new City(), null);
          return getcities.getCity();
      }

    public int addCustomer(Customer customer) throws Exception {
        AddCustomerOperation addcustomer=new AddCustomerOperation();
        addcustomer.execute(customer, null);
        return addcustomer.getCustomer();
    }

    public List<AbstractDomainObject> getCustomers(Object o) throws Exception {
        GetCustomersOperation getcustomers=new GetCustomersOperation();
        if(o instanceof String){
        getcustomers.execute(null, (String) o);
        return getcustomers.getCustomers();
        }
         else{
        getcustomers.execute((AbstractDomainObject) o, (String) o);
        return getcustomers.getCustomers();
        }
    }

    public boolean deleteCustomer(Customer c) throws Exception {
          DeleteCutomerOperation deletecustomer=new DeleteCutomerOperation();
        deletecustomer.execute(c,null);
        return deletecustomer.returnResult();
       
    }

    public boolean updateCustomer(Customer customerToChange) throws Exception {  
        UpdateCustomerOperation updatecustomer=new UpdateCustomerOperation();
        updatecustomer.execute(customerToChange, null);
        return updatecustomer.getCustomers();
        
    }

    public int addWorker(Worker worker) throws Exception {
        AddWorkerOperation addworker=new AddWorkerOperation();
        addworker.execute(worker, null);
        return addworker.getWorkers();
    }

    public boolean deleteWorker(Worker deleteWorker) throws Exception {
        DeleteWorkerOperation deleteworker=new DeleteWorkerOperation();
         deleteworker.execute(deleteWorker,null);
         return deleteworker.isLegal();
    }

    public boolean updateWorker(Worker workerToChange) throws Exception {
        UpdateWorkerOperation updateworker=new UpdateWorkerOperation();
        updateworker.execute(workerToChange, null);
        return updateworker.getWorkers();
    }

    public List<AbstractDomainObject> getWorkers(Object worParam) throws Exception {
        GetWorkersOperation getworkers=new GetWorkersOperation();
        if(worParam instanceof String){
            getworkers.execute(null, (String) worParam);
        return getworkers.getWorkers();
        }
        else{
        getworkers.execute((AbstractDomainObject) worParam,null);
        return getworkers.getWorkers();
    }
    }

    public int addWrkPD(Worker w) throws Exception {
        AddWrkPdOperation addwrkpd=new AddWrkPdOperation();
        addwrkpd.execute(w, null);
        return addwrkpd.getWrkPd();
    }

    public int addProfessionalDegre(ProfessionalDegree professionalDegreeToAdd) throws Exception {
        AddProfessionalDegreeOperation addprofessionaldegree=new AddProfessionalDegreeOperation();
        addprofessionaldegree.execute(professionalDegreeToAdd, null);
        return addprofessionaldegree.getDegree();
    }
       public List<AbstractDomainObject> getProfessionalDegrees(ProfessionalDegree profesional) throws Exception {
        GetProfessionalDegreeOperation getdegrees=new GetProfessionalDegreeOperation();
        getdegrees.execute(profesional,null);
        return getdegrees.getWorkers();
    }

    public int addPainting(Painting paintingToAdd) throws Exception {
        AddPaintingOperation addpainting=new AddPaintingOperation();
        addpainting.execute(paintingToAdd, null);
        return addpainting.getPainting();
    }

    public List<AbstractDomainObject> getPaintings(Object paintParam) throws Exception {
        GetPaintingsOperation getpaintings=new GetPaintingsOperation();
        if(paintParam instanceof String){
        getpaintings.execute(null, (String) paintParam);
        return getpaintings.getPaintings();
        }
        else{
        getpaintings.execute((AbstractDomainObject) paintParam,null);
        return getpaintings.getPaintings();
        }
    }

    public int addReceipt(Receipt receiptToAdd) throws Exception {
        AddReceiptOperation addreceipt=new AddReceiptOperation();
        addreceipt.execute(receiptToAdd, null);
       return addreceipt.getReceipt();
    }

    public List<Receipt> getReceipts(Object recParam) throws Exception {
        GetReceiptsOperation getreceipt=new GetReceiptsOperation();
        getreceipt.execute((AbstractDomainObject) recParam,null);
        return getreceipt.getReceipts();
    }

    public int deleteReceiptItem(ReceiptItem itemForDeleting) throws Exception {
        DeleteReceiptItemOperation deletereceipt=new DeleteReceiptItemOperation();
        deletereceipt.execute(itemForDeleting, null);
        return 1;
        
    }

    public boolean updateReceipt(Receipt updatedReceipt) throws Exception {
        UpdateReceiptOperation updatereceiptitem=new UpdateReceiptOperation();
        updatereceiptitem.execute(updatedReceipt,null);
        return true;
    }

    public int addDegree(ProfessionalDegree degreeToAdd) throws Exception {
        AddProfessionalDegreeOperation addprofessionaldegree=new AddProfessionalDegreeOperation();
        addprofessionaldegree.execute(degreeToAdd, null);
        return addprofessionaldegree.getDegree();
    }

    public int editProfessionalDegrees(ProfessionalDegree professionalDegreeToEdit) {
        return 0;
    }

    public boolean deleteProfessionalDegree(ProfessionalDegree pdToDelete) throws Exception {
        DeleteProfessionalDegreeOperation deletedegree=new DeleteProfessionalDegreeOperation();
        deletedegree.execute(pdToDelete, null);
        return deletedegree.isLegal();
    }
}


    
