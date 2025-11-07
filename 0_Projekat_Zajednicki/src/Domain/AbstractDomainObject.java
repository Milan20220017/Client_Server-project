/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Domain;
import java.sql.ResultSet;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author s
 */
public interface AbstractDomainObject extends Serializable {
     public String getTableName();
    public List<AbstractDomainObject> getList(ResultSet rs) throws Exception;
    public String getInsertColumns();
    public String getInsertValues();
   public String getPrimaryKeyCondition();
    public AbstractDomainObject getObjectFromResultSet(ResultSet rs) throws Exception;
    public String getUpdateValues();
    public String[] getColumnName();
    public Object[] getObjectArray();
    public String getWhere();
    public void setWhere(Object par0);
}
