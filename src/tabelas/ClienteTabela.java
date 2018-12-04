package tabelas;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Cliente;
import model.Pessoa;
import repository.ClienteRep;
import repository.PessoaRep;

public class ClienteTabela extends AbstractTableModel {

    private ClienteRep crep = new ClienteRep();
    private PessoaRep prep = new PessoaRep();
    private List<Cliente> clientes = crep.listar();
    private List<Pessoa> pessoas = prep.listar();
    
    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }
    
    public Cliente get(int row) {
        return clientes.get(row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: 
                return clientes.get(rowIndex).getIdCliente();
            case 1: 
                return pessoas.get(rowIndex).getIdPessoa();
            case 2: 
                return clientes.get(rowIndex).getCpfCliente();
            case 3: 
                return pessoas.get(rowIndex).getEmailPessoa();
            case 4:
                return pessoas.get(rowIndex).getNomePessoa();
            case 5:
                return pessoas.get(rowIndex).getTelPessoa();    
                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0:
                return "Id Cliente";
            case 1:
                return "Id Pessoa";
            case 2:
                return "CPF";
            case 3:
                return "Email";
            case 4:
                return "Nome";
            case 5:
                return "Telefone";    
        }
        return null;
    }
    
    
    
}
