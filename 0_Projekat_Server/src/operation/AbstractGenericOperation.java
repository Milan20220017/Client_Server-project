/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation;
import repository.*;
import repository.db.DbRepository;
import repository.db.impl.DbRepositoryGeneric;
import Domain.AbstractDomainObject;
/**
 *
 * @author s
 */
public abstract class AbstractGenericOperation {
    protected final Repository broker;

    public AbstractGenericOperation() {
        this.broker = new DbRepositoryGeneric();
    }
       public final void execute(AbstractDomainObject ado, String key) throws Exception{
        try{
            preconditions(ado);
            startTransaction();
            executeOperation(ado,key);
            confirmTransaction();
        }catch(Exception e){
            cancelTransaction();
            throw e;
        }finally{
           closeConnection();
        }
    }
    protected abstract void preconditions(AbstractDomainObject param) throws Exception;
    protected abstract void executeOperation(AbstractDomainObject param, String key) throws Exception;
    private void startTransaction()throws Exception{
        ((DbRepository)broker).connect();
    }   
    private void confirmTransaction() throws Exception{
                ((DbRepository)broker).commit();

    }
    private void cancelTransaction() throws Exception{
           try {
        ((DbRepository) broker).connect();   
        ((DbRepository) broker).rollback();
    } catch (Exception ex) {
               System.out.println("Catched exception");
               
    }

    }
       private void closeConnection() throws Exception{
                ((DbRepository)broker).disconnect();

    }
    
}
