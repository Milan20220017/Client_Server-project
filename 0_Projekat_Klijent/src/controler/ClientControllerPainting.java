/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.util.List;
import Domain.*;
import Communication.Operation;
import java.awt.Image;

/**
 *
 * @author s
 */
public class ClientControllerPainting extends ClientController {

    private static ClientControllerPainting instance;

    private ClientControllerPainting() {
    }

    public static ClientControllerPainting getInstance() {
        if (instance == null) {
            instance = new ClientControllerPainting();
        }
        return instance;
    }

    public int addPainting(AbstractDomainObject odo) throws Exception {
        return (int) send(Operation.ADD_PAINTING, odo);
    }
    
     public void deletePainting(AbstractDomainObject odo) throws Exception{
        odo.setWhere(null);
        send(Operation.DELETE_PAINTING, odo);
    }

    public Image getPainting(AbstractDomainObject odo) throws Exception {
        return (Image) send(Operation.GET_PAINTING, odo);
    }
    
      public boolean updatePainting(AbstractDomainObject odo) throws Exception{
        return (boolean) send(Operation.UPDATE_PAINTING, odo);
    }

    public List<AbstractDomainObject> getPaintings() throws Exception {
        return (List<AbstractDomainObject>) send(Operation.GET_PAINTINGS, null);
    }

        public List<AbstractDomainObject> getPaintings(String s) throws Exception {
        return (List<AbstractDomainObject>) send(Operation.GET_PAINTINGS, s);
    }
}
