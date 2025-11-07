    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package repository.db.impl;
    import java.sql.*;
    import Domain.AbstractDomainObject;
    import java.util.List;
    import repository.db.DbConnectionFactory;
    import repository.db.DbRepository;
    /**
     *
     * @author s
     */
    public class DbRepositoryGeneric implements DbRepository<AbstractDomainObject>{
        @Override
        public List<AbstractDomainObject> getAll(AbstractDomainObject param,String condition) throws Exception {
            List<AbstractDomainObject> list;
            String query="SELECT * FROM " + param.getTableName();
            if(condition!=null){
               
                query+=condition;
            }
            Statement statement=DbConnectionFactory.getInstance().getConnection().createStatement();
            ResultSet rs=statement.executeQuery(query);
            list=param.getList(rs);
            rs.close();
            statement.close();
            return list;
        }

        @Override
        public int add(AbstractDomainObject param) throws Exception {
String query = "INSERT INTO " + param.getTableName() + 
                   " (" + param.getInsertColumns() + ") VALUES (" + param.getInsertValues() + ")";
    PreparedStatement ps = DbConnectionFactory.getInstance().getConnection()
            .prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
    ps.executeUpdate();
    ResultSet rs = ps.getGeneratedKeys();
    int generatedId = -1;
    if (rs.next()) {
        generatedId = rs.getInt(1);
    }

    rs.close();
    ps.close();

    return generatedId;
        }

        @Override   
        public int edit(AbstractDomainObject param) throws Exception {
            String query="UPDATE "+ param.getTableName()+" SET "+param.getUpdateValues() +" WHERE "+ param.getPrimaryKeyCondition();
            System.out.println(query);
             Statement statement=DbConnectionFactory.getInstance().getConnection().createStatement();
            int id=statement.executeUpdate(query);
            statement.close();
            return id;
        }

        @Override
        public void delete(AbstractDomainObject param) throws Exception {
            String query="DELETE FROM "+param.getTableName() +" WHERE "+ param.getPrimaryKeyCondition();
           Statement statement=DbConnectionFactory.getInstance().getConnection().createStatement();
            statement.executeUpdate(query);
            statement.close();
        }
    }
