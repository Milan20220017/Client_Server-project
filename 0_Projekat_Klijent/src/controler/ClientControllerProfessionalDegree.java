/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;
import Domain.*;
import java.util.List;
import Communication.*;

/**
 *
 * @author s
 */
public class ClientControllerProfessionalDegree extends ClientController{

    private static ClientControllerProfessionalDegree instance;

    private ClientControllerProfessionalDegree() {
    }

    public static ClientControllerProfessionalDegree getInstance() {
        if (instance == null) {
            instance = new ClientControllerProfessionalDegree();
        }
        return instance;
    }
    public List<AbstractDomainObject> getProfessionalDegree(ProfessionalDegree pd) throws Exception {
        return (List<AbstractDomainObject>) send(Operation.GET_PROFFESIONALDEGREES, pd);
    }
    public void addProfessionalDegree(ProfessionalDegree pd) throws Exception {
        send(Operation.ADD_PROFESSIONAMDEGREE, pd);
    }

    public boolean deleteProfessionalDegree(ProfessionalDegree odo) throws Exception {
       return (boolean) send(Operation.DELETE_PROFFESIONALDEGREE, odo);
    }

    public int update(ProfessionalDegree pd) throws Exception {
         return  (int) send(Operation.UPDATE_PD, pd);
        }
    }

