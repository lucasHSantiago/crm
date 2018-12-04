package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Fornecedor;
import util.ConexaoBD;

public class FornecedorRep {

    private static final String INSERT = "insert into tb_fornecedor (cnpj_fornecedor, id_pessoa, nome_contato) values (?,?,?);";

    private static final String SELECT = "select id_fornecedor, id_pessoa, cnpj_fornecedor, nome_contato from tb_fornecedor";

    private static final String DELETE = "delete from tb_fornecedor where id_fornecedor = ?";

    private static final String UPDATE = "update tb_fornecedor set cnpj_fornecedor = ?, nome_contato = ? where id_fornecedor = ?";

    private Connection connection = ConexaoBD.conectarBanco();
    private PreparedStatement pstm;

    public void salvar(Fornecedor fornecedor) {

        try {
            if (fornecedor.getIdFornecedor()>0) {
                pstm = connection.prepareStatement(UPDATE);
                pstm.setString(1, fornecedor.getCnpjFornecedor());
                pstm.setString(2, fornecedor.getNomeContato());
            } else {
                pstm = connection.prepareStatement(INSERT);
                pstm.setString(1, fornecedor.getCnpjFornecedor());
                pstm.setString(2, fornecedor.getNomeContato());
            }
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar salvar: " + ex.getMessage());
        }
    }

    public void excluir(Fornecedor fornecedor) {
        try {
            pstm = connection.prepareStatement(DELETE);
            pstm.setString(1, fornecedor.getCnpjFornecedor());
            pstm.setString(2, fornecedor.getNomeContato());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar excluir: " + ex.getMessage());
        }

    }

    public List<Fornecedor> listar() {
        List<Fornecedor> fornecedor = new ArrayList<>();
        ResultSet res;

        try {
            pstm = connection.prepareStatement(SELECT);
            res = pstm.executeQuery();

            while (res.next()) {
                Fornecedor f = new Fornecedor();
                f.setCnpjFornecedor(res.getString("cnpj_fornecedor"));
                f.setNomeContato(res.getString("nome_contato"));
                fornecedor.add(f);
            }

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar buscar os fornecedores do banco: " + ex.getMessage());
        }
        return fornecedor;
    }
}
