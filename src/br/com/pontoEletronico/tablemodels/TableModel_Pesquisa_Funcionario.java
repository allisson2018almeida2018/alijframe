
package br.com.pontoEletronico.tablemodels;

import br.com.pontoEletronico.entities.Funcionario;
import java.math.BigDecimal;
import java.util.List;


public final class TableModel_Pesquisa_Funcionario extends TableModelDefaultAdapter<Funcionario> {

    private static final long serialVersionUID = 255989609373962604L;
    private final String[] columnsName = new String[]{"Matrícula", "Nome", "CPF", "Salário"};

    public TableModel_Pesquisa_Funcionario() {
        setColumnName(columnsName);
    }

    public TableModel_Pesquisa_Funcionario(List<Funcionario> lista) {
        super(lista);
        setColumnName(columnsName);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Funcionario funcionario = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return funcionario.getMatricula();
            case 1:
                return funcionario.getNome();
            case 2:
                return funcionario.getCpf();
            case 3:
                return funcionario.getSalario();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Funcionario funcionario = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                funcionario.setMatricula(aValue != null ? Long.parseLong(aValue.toString()) : null);
                break;
            case 1:
                funcionario.setNome(aValue != null ? aValue.toString() : null);
                break;
            case 2:
                funcionario.setCpf(aValue != null ? aValue.toString() : null);
            case 3:
                funcionario.setSalario(aValue != null ? new BigDecimal(aValue.toString()) : null);
                break;
        }
    }

}
