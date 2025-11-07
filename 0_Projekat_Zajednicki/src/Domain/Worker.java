package Domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Worker implements AbstractDomainObject {
    private int workerId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private double salary; 
    private String where = "";
        private List<WrkPD> ws;
    public Worker() {
    }

    public Worker(int workerId, String firstName, String lastName, String username, String password, double salary) {
        this.workerId = workerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.salary = salary;
    }

    public Worker(int workerId, String firstName, String lastName, String username, String password, double salary, List<WrkPD> ws) {
        this.workerId = workerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.salary = salary;
        this.ws = ws;
    }
    

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
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

    public void setWs(List<WrkPD> ws) {
        this.ws = ws;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<WrkPD> getWs() {
        return ws;
    }

    @Override
    public String toString() {
        if(firstName==null)return workerId+"";
        return firstName + ", username=" + username;
    }

    @Override
    public int hashCode() {
        return Objects.hash(workerId, username, password);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final Worker other = (Worker) obj;
        return this.workerId == other.workerId &&
               Objects.equals(this.username, other.username) &&
               Objects.equals(this.password, other.password);
    }

    @Override
    public String getTableName() {
        return "worker";
    }

    @Override
    public List<AbstractDomainObject> getList(ResultSet rs) throws Exception {
        List<AbstractDomainObject> list = new ArrayList<>();
        while (rs.next()) {
            int workerId = rs.getInt("workerId");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String username = rs.getString("username");
            String password = rs.getString("password");
            double salary = rs.getDouble("salary");

            Worker worker = new Worker(workerId, firstName, lastName, username, password, salary);
            list.add(worker);
        }
        return list;
    }

    @Override
    public String getInsertColumns() {
        return "firstName, lastName, username, password, salary";
    }

    @Override
    public String getInsertValues() {
        return "'" + firstName + "', '" + lastName + "', '" + username + "', '" + password + "', " + salary;
    }

    @Override
    public String getPrimaryKeyCondition() {
        return "workerId = " + workerId;
    }

    @Override
    public AbstractDomainObject getObjectFromResultSet(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getUpdateValues() {
        return "firstName = '" + firstName + "', lastName = '" + lastName +
               "', username = '" + username + "', password = '" + password +
               "', salary = " + salary;
    }

    @Override
    public String[] getColumnName() {
            return new String[] {
        "ID",
        "First name",
        "Last name",
        "Username",
        "Password",
        "Salary"
    };
    }

    @Override
    public Object[] getObjectArray() {
            return new Object[] {
        workerId,
        firstName,
        lastName,
        username,
        password,
        salary
    };
    }


  
   
    @Override
    public String getWhere() {
        return where;
    }
@Override
      public void setWhere(Object s) {
          String s_to_String=(String) s;
        where = " WHERE LOWER(firstName) like '%" + s_to_String.toLowerCase() + "%' OR LOWER(lastName) LIKE '%" + s_to_String.toLowerCase() + "%' OR LOWER(username) LIKE '%" + s_to_String.toLowerCase() + "%'";
    }

    public void setLogin() {
        where = "WHERE username ='" + getUsername() + "' AND password = '" + getPassword() + "'";
    }



}