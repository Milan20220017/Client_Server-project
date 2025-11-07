package Domain;

import java.sql.ResultSet;
import java.time.LocalDate;                 
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WrkPD implements AbstractDomainObject {

    private Worker worker;
    private ProfessionalDegree professionalDegree;
    private LocalDate date;  
    private String where;

    public WrkPD() {
    }

    public WrkPD(Worker worker, ProfessionalDegree professionalDegree, LocalDate date) {  
        this.worker = worker;
        this.professionalDegree = professionalDegree;
        this.date = date;
    }

    public Worker getWorker() { return worker; }
    public void setWorker(Worker worker) { this.worker = worker; }

    public ProfessionalDegree getProfessionalDegree() { return professionalDegree; }
    public void setProfessionalDegree(ProfessionalDegree professionalDegree) { this.professionalDegree = professionalDegree; }

    public LocalDate getDate() { return date; }         
    public void setDate(LocalDate date) { this.date = date; } 

    @Override
    public String toString() {
        return "WrkPD{" +
               "worker=" + worker +
               ", professionalDegree=" + professionalDegree +
               ", date=" + date +
               '}';
    }

    @Override
    public int hashCode() { return Objects.hash(worker, professionalDegree, date); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WrkPD other)) return false;
        return Objects.equals(worker, other.worker) &&
               Objects.equals(professionalDegree, other.professionalDegree) &&
               Objects.equals(date, other.date);
    }

    @Override
    public String getTableName() { return "wrkpd"; }

    @Override
    public List<AbstractDomainObject> getList(ResultSet rs) throws Exception {
        List<AbstractDomainObject> list = new ArrayList<>();
        while (rs.next()) {
            Worker w = new Worker();
            w.setWorkerId(rs.getInt("worker"));
            ProfessionalDegree d = new ProfessionalDegree();
            d.setDegreeId(rs.getInt("professionalDegree"));
            LocalDate ld = rs.getDate("date").toLocalDate();
            list.add(new WrkPD(w, d, ld));
        }
        return list;
    }

    @Override
    public String getInsertColumns() {
        return "worker, professionalDegree, date";
    }

    @Override
    public String getInsertValues() {
      
        return worker.getWorkerId() + ", " +
               professionalDegree.getDegreeId() + ", '" +
               date + "'"; 
    }

    @Override
    public String getPrimaryKeyCondition() {
        return "workerId = " + worker.getWorkerId() +
               " AND professionalDegreeId = " + professionalDegree.getDegreeId();
    }

    @Override public AbstractDomainObject getObjectFromResultSet(ResultSet rs) { throw new UnsupportedOperationException(); }
    @Override public String getUpdateValues() {
        return "professionalDegreeId = " + professionalDegree.getDegreeId() +
               ", date = '" + date + "'";     
    }

    @Override public String[] getColumnName() {
    return new String[] {
        "Worker",
        "Degree",
        "Date"
    };
    }
    @Override public Object[] getObjectArray() {
      return new Object[] {
        worker,             
        professionalDegree, 
        date                
    };
    }
    @Override public String getWhere() 
    {
        return where;
    }
@Override
public void setWhere(Object par0) {
    if (par0 instanceof Worker w) {
        this.where = " WHERE worker = " + w.getWorkerId();
    } else if(par0 instanceof ProfessionalDegree pd){
       this.where=" WHERE professionalDegree = "+pd.getDegreeId();
    }
}
}