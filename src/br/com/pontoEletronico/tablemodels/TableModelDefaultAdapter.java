
package br.com.pontoEletronico.tablemodels;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**

 * @param <T>
 */
public abstract class TableModelDefaultAdapter<T> extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    protected List<T> lista;
    private String[] columnsName;
    private int selectedIndex = -1;

    public TableModelDefaultAdapter() {
        this.lista = new ArrayList();
    }

    public TableModelDefaultAdapter(List<T> lista) {
        this.lista = lista != null ? lista : new ArrayList();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return columnsName != null ? columnsName.length : 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    public void addLista(List<T> lista) {
        this.lista.addAll(lista);
        fireTableDataChanged();
    }

    public void setLista(List<T> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    public List<T> getLista() {
        return lista;
    }

    public void deletarLista() {
        lista.removeAll(lista);
        fireTableDataChanged();
    }

    public void setSelectedRow(int rowIndex) {
        selectedIndex = rowIndex;
    }

    public void addObject(T object) {
        lista.add(object);
        fireTableDataChanged();
    }

    public void updateObject(int rowIndex, T object) {
        lista.set(rowIndex, object);
        fireTableRowsUpdated(rowIndex, rowIndex);
    }

    public void removeObject(T object) {
        lista.remove(object);
        fireTableDataChanged();
    }

    public T getObject(int rowIndex) {
        return lista.get(rowIndex);
    }

    @Override
    public String getColumnName(int column) {
        return columnsName[column];
    }

    public void setColumnName(String[] columnsName) {
        this.columnsName = columnsName;
    }
}
