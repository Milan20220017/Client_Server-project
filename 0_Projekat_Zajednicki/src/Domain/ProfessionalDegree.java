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
public class ProfessionalDegree implements AbstractDomainObject{
   private int degreeId;
    private String name;
    private String certificate;
    private String where;

    public ProfessionalDegree() {
    }

    public ProfessionalDegree(int degreeId, String name, String certificate) {
        this.degreeId = degreeId;
        this.name = name;
        this.certificate = certificate;
    }

    public int getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(int degreeId) {
        this.degreeId = degreeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    @Override
    public String toString() {
        return "ProfessionalDegree{" + "name=" + name + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(degreeId, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final ProfessionalDegree other = (ProfessionalDegree) obj;
        return this.degreeId == other.degreeId &&
               Objects.equals(this.name, other.name);
    }

    @Override
    public String getTableName() {
        return "professionaldegree";
    }

    @Override
    public List<AbstractDomainObject> getList(ResultSet rs) throws Exception {
        List<AbstractDomainObject> list = new ArrayList<>();
        while (rs.next()) {
            int degreeId = rs.getInt("degreeId");
            String name = rs.getString("name");
            String certificate = rs.getString("certificate");
            ProfessionalDegree degree = new ProfessionalDegree(degreeId, name, certificate);
            list.add(degree);
        }
        return list;
    }

    @Override
    public String getInsertColumns() {
        return "name, certificate";
    }

    @Override
    public String getInsertValues() {
        return "'" + name + "', '" + certificate + "'";
    }

    @Override
    public String getPrimaryKeyCondition() {
        return "degreeId = " + degreeId;
    }

    @Override
    public AbstractDomainObject getObjectFromResultSet(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getUpdateValues() {
        return "name = '" + name + "', certificate = '" + certificate + "'";
    }

    @Override
    public String[] getColumnName() {
          return new String[] {
        "ID",
        "Name",
        "Certificate"
    };
    }

    @Override
    public Object[] getObjectArray() {
          return new Object[] {
        degreeId,
        name,
        certificate
    };
    }

    @Override
    public String getWhere() {
        if (where != null) {
            return where;
        }
        return "";
    }
    @Override
    public void setWhere(Object par0) {
        ProfessionalDegree pd=(ProfessionalDegree) par0;
     List<String> conditions = new ArrayList<>();

    if (pd.getDegreeId() > 0) {
        where = " WHERE profesionaldegree.id = " + pd.getDegreeId();
        return;
    }

    if (pd.getName() != null && !pd.getName().isEmpty()) {
        conditions.add("name LIKE '%" + pd.getName() + "%'");
    }

    if (pd.getCertificate() != null && !pd.getCertificate().isEmpty()) {
        conditions.add("certificate LIKE '%" + pd.getCertificate() + "%'");
    }

    if (!conditions.isEmpty()) {
        where = " WHERE " + String.join(" OR ", conditions);
    }
    }
}
