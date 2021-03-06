package tabelas;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Fornecedor;
import repository.FornecedorRep;

public class FornecedoresTabela extends AbstractTableModel {

    private FornecedorRep frep = new FornecedorRep();
    private List<Fornecedor> fornecedores = frep.listar();
    
    @Override
    public int getRowCount() {
        return fornecedores.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
    public Fornecedor get(int row) {
        return fornecedores.get(row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: 
                return fornecedores.get(rowIndex).getIdFornecedor();
            case 1: 
                return fornecedores.get(rowIndex).getCnpjFornecedor();
            case 2: 
                return fornecedores.get(rowIndex).getNomeContato();                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0:
                return "Id";
            case 1:
                return "CNPJ";
            case 2:
                return "Nome de Contato";
        }
        return null;
    }
    
    
    
}
