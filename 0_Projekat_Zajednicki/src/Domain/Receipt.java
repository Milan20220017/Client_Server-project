/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.time.LocalDate;

/**
 *
 * @author s
 */
public class Receipt implements AbstractDomainObject{
  private int receiptId;
    private LocalDate date;
    private double totalAmount;
    private Worker worker;
    private Customer customer;
    private List<ReceiptItem> itemList;
    private String where;

    public Receipt() {
    }

public Receipt(int receiptId, LocalDate date, double totalAmount, Worker worker, Customer customer) {
    this.receiptId = receiptId;
    this.date = date;
    this.totalAmount = totalAmount;
    this.worker = worker;
    this.customer = customer;
}
    public Receipt(int receiptId, LocalDate date, double totalAmount, Worker worker, Customer customer, List<ReceiptItem> itemList) {
        this.receiptId = receiptId;
        this.date = date;
        this.totalAmount = totalAmount;
        this.worker = worker;
        this.customer = customer;
        this.itemList = itemList;
    }

    public List<ReceiptItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<ReceiptItem> itemList) {
        this.itemList = itemList;
    }

    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }
public LocalDate getDate() {
    return date;
}

public void setDate(LocalDate date) {
    this.date = date;
}

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Receipt{" + "date=" + date + ", totalAmount=" + totalAmount + '}'+worker+"Predposta";
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiptId, date, totalAmount, worker, customer);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final Receipt other = (Receipt) obj;
        return this.receiptId == other.receiptId &&
               Double.doubleToLongBits(this.totalAmount) == Double.doubleToLongBits(other.totalAmount) &&
               Objects.equals(this.date, other.date) &&
               Objects.equals(this.worker, other.worker) &&
               Objects.equals(this.customer, other.customer);
    }

    @Override
    public String getTableName() {
        return "receipt";
    }

    @Override
    public List<AbstractDomainObject> getList(ResultSet rs) throws Exception {
        List<AbstractDomainObject> list = new ArrayList<>();
        while (rs.next()) {
            int receiptId = rs.getInt("receiptId");
            LocalDate date = rs.getDate("date").toLocalDate();
            double totalAmount = rs.getDouble("totalAmount");

            int workerId = rs.getInt("workerId");
            Worker worker = new Worker();
            worker.setWorkerId(workerId);

            int customerId = rs.getInt("customerId");
            Customer customer = new Customer();
            customer.setCustomerId(customerId);
            Receipt receipt = new Receipt(receiptId, date, totalAmount, worker, customer);
            list.add(receipt);
        }
        return list;
    }

    @Override
    public String getInsertColumns() {
        return "date, totalAmount, workerId, customerId";
    }

    @Override
   public String getInsertValues() {
    return "'" + date.toString() + "', '" + totalAmount + "', " + worker.getWorkerId() + ", " + customer.getCustomerId();
}

    @Override
    public String getPrimaryKeyCondition() {
        return "receiptId = " + receiptId;
    }

    @Override
    public AbstractDomainObject getObjectFromResultSet(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
   public String getUpdateValues() {
    return "date = '" + date.toString() + "', totalAmount = " + totalAmount +
           ", workerId = " + worker.getWorkerId() +
           ", customerId = " + customer.getCustomerId();
}

    @Override
    public String[] getColumnName() {
          return new String[] {
        "ID",
        "Date",
        "Total amount",
        "Worker",
        "Customer"
    };
    }

    @Override
    public Object[] getObjectArray() {
          return new Object[] {
        receiptId,
        date,        
        totalAmount,
        worker.getWorkerId(),       
        customer.getCustomerId()   
    };
    }

    @Override
    public String getWhere() {
   return where;
    }

    @Override
    public void setWhere(Object par0) {
Receipt r = (Receipt) par0;
StringBuilder sb = new StringBuilder();
boolean hasCondition = false;

if (r.getReceiptId() != 0) {
    sb.append(" receiptId = ").append(r.getReceiptId());
    hasCondition = true;
}
if (r.getWorker() != null) {
    if (hasCondition) sb.append(" AND ");
    sb.append(" workerId = ").append(r.getWorker().getWorkerId());
    hasCondition = true;
}

if (r.getCustomer() != null) {
    if (hasCondition) sb.append(" AND ");
    sb.append(" customerId = ").append(r.getCustomer().getCustomerId());
    hasCondition = true;
}

if (r.getDate() != null) {
    if (hasCondition) sb.append(" AND ");
    sb.append(" date = '").append(java.sql.Date.valueOf(r.getDate())).append("'");
}

if (sb.length() > 0) {
    where = " WHERE " + sb.toString();
} else {
    where = "";
    }
    }

}
