package tabelas;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Produto;
import repository.ProdutoRep;

public class ProdutoTabela extends AbstractTableModel {

    private ProdutoRep prep = new ProdutoRep();
    private List<Produto> produtos = prep.listar();

    @Override
    public int getRowCount() {
        return produtos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    public Produto get(int row) {
        return produtos.get(row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return produtos.get(rowIndex).getIdProduto();
            case 1:
                return produtos.get(rowIndex).getNomeProduto();
            case 2:
                return produtos.get(rowIndex).getQtdeEstoque();
            case 3:
                return produtos.get(rowIndex).getPrecoCusto();
            case 4:
                return produtos.get(rowIndex).getPrecoVenda();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id";
            case 1:
                return "Nome";
            case 2:
                return "Estoque";
            case 3:
                return "Custo";
            case 4:
                return "Venda";
        }
        return null;
    }

}
