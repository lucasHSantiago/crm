package tabelas;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Funcionario;
import model.Pessoa;
import repository.FuncionarioRep;
import repository.PessoaRep;

public class FuncionarioTabela extends AbstractTableModel {

    private PessoaRep prep = new PessoaRep();
    private FuncionarioRep frep = new FuncionarioRep();
    private List<Funcionario> funcionarios = frep.listar();
    private List<Pessoa> pessoas = prep.listar();
    
    @Override
    public int getRowCount() {
        return funcionarios.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    public Funcionario getFuncionario(int row) {
        return funcionarios.get(row);

    }
    public Pessoa getPessoa(int row) {
        return pessoas.get(row);

    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: 
                return funcionarios.get(rowIndex).getId();
            case 1:
                return pessoas.get(rowIndex).getIdPessoa();
            case 2: 
                return funcionarios.get(rowIndex).getLoginFuncionario();
            case 3: 
                return funcionarios.get(rowIndex).getSenhaFuncionario();   
            case 4:
                return pessoas.get(rowIndex).getNomePessoa(); 
            case 5:
                return pessoas.get(rowIndex).getEmailPessoa(); 
            case 6:
                return pessoas.get(rowIndex).getTelPessoa();     
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0:
                return "Id";
            case 1:
                return "Id pessoa";    
            case 2:
                return "Login";
            case 3:
                return "Senha";
            case 4:
                return "Nome";
            case 5:
                return "Email";
            case 6:
                return "Telefone";
        }
        return null;
    }
    
    
    
}
