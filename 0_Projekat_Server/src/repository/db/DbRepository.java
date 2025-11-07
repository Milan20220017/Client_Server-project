/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository.db;

import repository.Repository;

/**
 *
 * @author s
 * @param <T>
 */
public interface DbRepository<T> extends Repository<T>{
    default public void connect() throws Exception{
        DbConnectionFactory.getInstance().openConnection();
    }
     default public void disconnect() throws Exception{
DbConnectionFactory.getInstance().closeConnection();
    }
     default public void commit() throws Exception{
DbConnectionFactory.getInstance().commit();
    }
     default public void rollback() throws Exception{
DbConnectionFactory.getInstance().rollback();
    }
     }
