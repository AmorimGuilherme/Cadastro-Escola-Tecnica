package br.com.escola.modelo.dao;

import br.com.escola.modelo.bd.InicializaBD;
import br.com.escola.modelo.entidade.Aluno;
import br.com.escola.modelo.mensagem.Mensagem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    
    private static final String INSERT_SQL = "Insert into aluno "
            + "(nome) "
            + "values ('%s')";
    private static final String UPDATE_SQL = "Update aluno "
            + "set nome = '%s'"
            + "where id_aluno = %d";
    private static final String DELETE_SQL = "Delete from aluno "
            + "where id_aluno = %d";
    private static final String SELECT_TODOS = "Select * from aluno";
    private static final String SELECT_POR_ID = "Select * from aluno "
            + "where id_aluno = %d;";

    public static void inserir(Aluno aluno) {
        String sql = String.format(INSERT_SQL,
                aluno.getNome());
        InicializaBD.execute(sql, true);

    }

    public static void alterar(Aluno aluno) {
        String sql = String.format(UPDATE_SQL,
                aluno.getNome(),
                aluno.getId());
        InicializaBD.execute(sql, true);

    }

    public static void apagar(Aluno aluno) {
        String sql = String.format(DELETE_SQL, aluno.getId());
        InicializaBD.execute(sql, true);
    }

    public static List<Aluno> selecionarTodos() {
        List<Aluno> lista = new ArrayList<>();
        Connection con = InicializaBD.conectar();
        try {
            ResultSet rs = con.createStatement().executeQuery(SELECT_TODOS);
            while (rs.next()) {
                int id = rs.getInt("id_aluno");
                String nome = rs.getString("nome"); 
                lista.add(new Aluno(id, nome));
            }
            InicializaBD.desconectar(con);
        } catch (SQLException e) {
            Mensagem.mensagemDeErro("Não foi possível executar \n" + SELECT_TODOS);
        }
        return lista;
    }

    public static Aluno getAlunoPorNome(String nome) {
        return null;
    }

    public static Aluno getAlunoPorId(int idPesquisa) {
        Aluno retorno = null;
        Connection con = InicializaBD.conectar();
        try {
            String sql = String.format(SELECT_POR_ID, idPesquisa);
            ResultSet rs = con.createStatement().executeQuery(sql);
            rs.next();
            int id = rs.getInt("id_aluno");
            String nome = rs.getString("nome");
            retorno = new Aluno(id, nome);
            InicializaBD.desconectar(con);
        } catch (SQLException e) {
            Mensagem.mensagemDeErro("Não foi possível executar \n" + SELECT_POR_ID);
        }
        return retorno;
    }
}

    


    

