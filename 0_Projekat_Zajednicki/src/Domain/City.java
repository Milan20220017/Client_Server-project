/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
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
public class City implements AbstractDomainObject{
      private int cityId;
    private String name;
    private String postalCode;
    private String municipality;

    public City() {
    }

    public City(int cityId, String name, String postalCode, String municipality) {
        this.cityId = cityId;
        this.name = name;
        this.postalCode = postalCode;
        this.municipality = municipality;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final City other = (City) obj;
        return this.cityId == other.cityId &&
               Objects.equals(this.name, other.name) &&
               Objects.equals(this.postalCode, other.postalCode) &&
               Objects.equals(this.municipality, other.municipality);
    }

    @Override
    public String toString() {
            return String.format("%s – %s (%s)", name, municipality, postalCode);
    }

    @Override
    public String getTableName() {
        return "city";
    }

    @Override
    public List<AbstractDomainObject> getList(ResultSet rs) throws Exception {
        List<AbstractDomainObject> list = new ArrayList<>();
        while (rs.next()) {
            int cityId = rs.getInt("cityId");
            String name = rs.getString("name");
            String postalCode = rs.getString("postalCode");
            String municipality = rs.getString("municipality");

            City city = new City(cityId, name, postalCode, municipality);
            list.add(city);
        }
        return list;
    }

    @Override
    public String getInsertColumns() {
        return "name, postalCode, municipality";
    }

    @Override
    public String getInsertValues() {
        return "'" + name + "', '" + postalCode + "', '" + municipality + "'";
    }

    @Override
    public String getPrimaryKeyCondition() {
        return "cityId = " + cityId;
    }

    @Override
    public AbstractDomainObject getObjectFromResultSet(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getUpdateValues() {
        return "name = '" + name + "', postalCode = '" + postalCode + "', municipality = '" + municipality + "'";
    }

    @Override
    public String[] getColumnName() {
       return new String[] {
        "ID",
        "City",
        "Postal code",
        "Municipality"
    };

    }

    @Override
    public Object[] getObjectArray() {
          return new Object[] {
        cityId,
        name,
        postalCode,
        municipality
    };
    }

    @Override
    public String getWhere() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setWhere(Object par0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
