/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Communication;

import java.io.Serializable;

/**
 *
 * @author s
 */
public enum Operation implements Serializable{
      ADD_CITY, ADD_CUSTOMER, ADD_RECEIPT, ADD_PAINTING, ADD_WORKER,ADD_PROFESSIONAMDEGREE,ADD_WS,
    DELETE_CITY, DELETE_WORKER, DELETE_CUSTOMER, DELETE_PAINTING,DELETE_PROFFESIONALDEGREE,DELETE_RECEIPTITEM,
    LOGIN, GET_CITY, GET_CUSTOMER, GET_PAINTING, GET_WORKER,GET_PROFFESIONALDEGREES,
    UPDATE_CITY, UPDATE_CUSTOMER, UPDATE_PAINTING, UPDATE_WORKER,UPDATE_RECEIPT,UPDATE_PD,
    GET_CITIES, GET_CUSTOMERS, GET_PAINTINGS, GET_WORKERS,GET_RECEIPTS

}
