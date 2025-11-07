package Domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReceiptItem implements AbstractDomainObject {

    private int receiptId;
    private int itemNumber;
    private int quantity;
    private double price;
    private double value;
    private Painting painting;
    private String where;

    public ReceiptItem() {
    }

    public ReceiptItem(int receiptId, int itemNumber, int quantity, double price, double value, Painting painting) {
        this.receiptId = receiptId;
        this.itemNumber = itemNumber;
        this.quantity = quantity;
        this.price = price;
        this.value = value;
        this.painting = painting;
    }

    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Painting getPainting() {
        return painting;
    }

    public void setPainting(Painting painting) {
        this.painting = painting;
    }

    @Override
    public String toString() {
        return "ReceiptItem{" +
               "receiptId=" + receiptId +
               ", itemNumber=" + itemNumber +
               ", quantity=" + quantity +
               ", price=" + price +
               ", value=" + value +
               '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiptId, itemNumber, painting);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReceiptItem other = (ReceiptItem) obj;
        if (this.receiptId != other.receiptId) {
            return false;
        }
        return this.itemNumber == other.itemNumber;
    }


    @Override
    public String getTableName() {
        return "receiptitem";
    }

    @Override
    public List<AbstractDomainObject> getList(ResultSet rs) throws Exception {
        List<AbstractDomainObject> list = new ArrayList<>();
        while (rs.next()) {
            int receiptId = rs.getInt("receiptId");
            int itemNumber = rs.getInt("itemNumber");
            int quantity = rs.getInt("quantity");
            double price = rs.getDouble("price");
            double value = rs.getDouble("value");
            int paintingId = rs.getInt("paintingId");

            Painting painting = new Painting();
            painting.setPaintingId(paintingId);

            ReceiptItem item = new ReceiptItem(receiptId, itemNumber, quantity, price, value, painting);
            list.add(item);
        }
        return list;
    }

    @Override
    public String getInsertColumns() {
        return "receiptId, itemNumber, quantity, price, value, paintingId";
    }

    @Override
    public String getInsertValues() {
        return receiptId + ", " + itemNumber + ", " + quantity + ", " + price + ", " + value + ", " + painting.getPaintingId();
    }

    @Override
    public String getPrimaryKeyCondition() {
        return "receiptId = " + receiptId + " AND itemNumber = " + itemNumber;
    }

    @Override
    public AbstractDomainObject getObjectFromResultSet(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getUpdateValues() {
        return "receiptId = " + receiptId +
               ", itemNumber = " + itemNumber +
               ", quantity = " + quantity +
               ", price = " + price +
               ", value = " + value +
               ", paintingId = " + painting.getPaintingId();
    }

    @Override
    public String[] getColumnName() {
        return new String[]{
            "Receipt ID",
            "Item number",
            "Quantity",
            "Price",
            "Value",
            "Painting ID"
        };
    }

    @Override
    public Object[] getObjectArray() {
        return new Object[]{
            receiptId,
            itemNumber,
            quantity,
            price,
            value,
            painting != null ? painting.getPaintingId() : null
        };
    }

    @Override
    public String getWhere() {
        return where;
    }

    @Override
    public void setWhere(Object par0) {
            Receipt r = (Receipt) par0;

    if (r.getReceiptId() != 0) {
        where = " WHERE receiptId = " + r.getReceiptId();
    } else {
        where = ""; 
    }
    }

}
