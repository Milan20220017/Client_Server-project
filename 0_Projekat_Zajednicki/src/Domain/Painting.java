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
public class Painting implements AbstractDomainObject {

    private int paintingId;
    private String title;
    private double price;
    private String imageFormat;
    private String painter;
    private String where;

    public Painting() {
    }

    public Painting(int paintingId, String title, double price, String imageFormat, String painter) {
        this.paintingId = paintingId;
        this.title = title;
        this.price = price;
        this.imageFormat = imageFormat;
        this.painter = painter;
    }

    public int getPaintingId() {
        return paintingId;
    }

    public void setPaintingId(int paintingId) {
        this.paintingId = paintingId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageFormat() {
        return imageFormat;
    }

    public void setImageFormat(String imageFormat) {
        this.imageFormat = imageFormat;
    }

    public String getPainter() {
        return painter;
    }

    public void setPainter(String painter) {
        this.painter = painter;
    }

    @Override
    public String toString() {
        return title + ", painter=" + painter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(paintingId, title);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final Painting other = (Painting) obj;
        return this.paintingId == other.paintingId &&
               Objects.equals(this.title, other.title);
    }

    @Override
    public String getTableName() {
        return "painting";
    }

    @Override
    public List<AbstractDomainObject> getList(ResultSet rs) throws Exception {
        List<AbstractDomainObject> list = new ArrayList<>();
        while (rs.next()) {
            int paintingId = rs.getInt("paintingId");
            String title = rs.getString("title");
            double price = rs.getDouble("price");
            String imageFormat = rs.getString("imageFormat");
            String painter = rs.getString("painter");

            Painting painting = new Painting(paintingId, title, price, imageFormat, painter);
            list.add(painting);
        }
        return list;
    }

    @Override
    public String getInsertColumns() {
        return "title, price, imageFormat, painter";
    }

    @Override
    public String getInsertValues() {
        return "'" + title + "', " + price + ", '" + imageFormat + "', '" + painter + "'";
    }

    @Override
    public String getPrimaryKeyCondition() {
        return "paintingId = " + paintingId;
    }

    @Override
    public AbstractDomainObject getObjectFromResultSet(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getUpdateValues() {
        return "title = '" + title + "', price = " + price + 
               ", imageFormat = '" + imageFormat + "', painter = '" + painter + "'";
    }

    @Override
    public String[] getColumnName() {
        return new String[] {
            "ID", "Title", "Price", "Format", "Painter"
        };
    }

    @Override
    public Object[] getObjectArray() {
        return new Object[] {
            paintingId, title, price, imageFormat, painter
        };
    }

    @Override
    public String getWhere() {
        return where;
    }

    @Override
    public void setWhere(Object par0) {
        String s=(String) par0;
          if (s != null && s.trim().length() > 0) {
            where = " WHERE LOWER(title) LIKE '%" + s.toLowerCase() + "%'" +
        " OR LOWER(painter) LIKE '%" + s.toLowerCase() + "%'" +
        " OR LOWER(imageFormat) LIKE '%" + s.toLowerCase() + "%'";
        }
    }

}