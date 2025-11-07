/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import Domain.*;

/**
 *
 * @author s
 * @param <T>
 */
public class TableModel <T extends AbstractDomainObject>  extends AbstractTableModel {

    private List<T> list;
    private String[] kolone;

    public TableModel(List<T> list) {
        this.list = list;
        if (list == null ||list.isEmpty()) {

        } else {
            kolone = list.get(0).getColumnName();
        }
    }

    public List<T> get() {
        return list;
    }

    public T get(int i) {
        return list.get(i);
    }

    @Override
    public int getRowCount() {
        if(list == null)
            return 0;
        return list.size();
    }

    @Override
    public int getColumnCount() {
        if(kolone == null)
            return 0;
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object[] o = list.get(rowIndex).getObjectArray();
        return o[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

}
