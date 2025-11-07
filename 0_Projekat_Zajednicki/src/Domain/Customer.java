/* * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author s
 */
public class Customer implements AbstractDomainObject{
     private int customerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private City city;
    private String where;

    public Customer() {
    }

    public Customer(int customerId, String firstName, String lastName, String phoneNumber, City city) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.city = city;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        if(firstName==null)return customerId+"";
        return  firstName+" "+ lastName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final Customer other = (Customer) obj;
        return this.customerId == other.customerId &&
               Objects.equals(this.firstName, other.firstName) &&
               Objects.equals(this.phoneNumber, other.phoneNumber) &&
               Objects.equals(this.city, other.city);
    }

    @Override
    public String getTableName() {
        return "customer";
    }

    @Override
    public List<AbstractDomainObject> getList(ResultSet rs) throws Exception {
        List<AbstractDomainObject> list = new ArrayList<>();
        while (rs.next()) {
            int customerId = rs.getInt("customerId");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String phoneNumber = rs.getString("phoneNumber");
            int cityId = rs.getInt("cityId");
            City city = new City();
            city.setCityId(cityId);

            Customer customer = new Customer(customerId, firstName, lastName, phoneNumber, city);
            list.add(customer);
        }
        return list;
    }

    @Override
    public String getInsertColumns() {
        return "firstName, lastName, phoneNumber, cityId";
    }

    @Override
    public String getInsertValues() {
          return "'" + firstName + "', '" 
           + lastName + "', '" 
           + phoneNumber + "', " 
           + city.getCityId();
    }

    @Override
    public String getPrimaryKeyCondition() {
        return "customerId = " + customerId;
    }

    @Override
    public AbstractDomainObject getObjectFromResultSet(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getUpdateValues() {
        return "firstName = '" + firstName + "', lastName = '" + lastName + "', phoneNumber = '" + phoneNumber + "', cityId = " + city.getCityId();
    }

    @Override
    public String[] getColumnName() {
         return new String[] {
        "ID",
        "First name",
        "Last name",
        "Phone",
        "City"
    };
    }

    @Override
    public Object[] getObjectArray() {
          return new Object[] {
        customerId,
        firstName,
        lastName,
        phoneNumber,
        city.getCityId()
    };
    }

    @Override
    public String getWhere() {
        return where;
    }

    @Override
    public void setWhere(Object par0) {
            String s = (String) par0;
    where = " WHERE LOWER(firstName) LIKE '%" + s.toLowerCase() + "%'"
          + " OR LOWER(lastName) LIKE '%" + s.toLowerCase() + "%'"
          + " OR phoneNumber LIKE '%" + s + "%'";
    }

}
