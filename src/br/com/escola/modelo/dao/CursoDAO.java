package br.com.escola.modelo.dao;

import br.com.escola.modelo.bd.InicializaBD;
import br.com.escola.modelo.entidade.Curso;
import br.com.escola.modelo.mensagem.Mensagem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {
    
    private static final String INSERT_SQL = "Insert into curso "
            + "(nome) "
            + "values ('%s')";
    private static final String UPDATE_SQL = "Update curso "
            + "set nome = '%s'"
            + "where id_curso = %d";
    private static final String DELETE_SQL = "Delete from curso "
            + "where id_curso = %d";
    private static final String SELECT_TODOS = "Select * from curso";
    private static final String SELECT_POR_ID = "Select * from curso "
            + "where id_curso = %d;";

    public static void inserir(Curso curso) {
        String sql = String.format(INSERT_SQL,
                curso.getNome());
        InicializaBD.execute(sql, true);

    }

    public static void alterar(Curso curso) {
        String sql = String.format(UPDATE_SQL,
                curso.getNome(),
                curso.getId());
        InicializaBD.execute(sql, true);

    }

    public static void apagar(Curso curso) {
        String sql = String.format(DELETE_SQL, curso.getId());
        InicializaBD.execute(sql, true);
    }

    public static List<Curso> selecionarTodos() {
        List<Curso> lista = new ArrayList<>();
        Connection con = InicializaBD.conectar();
        try {
            ResultSet rst = con.createStatement().executeQuery(SELECT_TODOS);
            while (rst.next()) {
//                int id = rs.getInt("id_curso");
//                String nome = rs.getString("nome"); 
                Curso curso = new Curso(rst.getInt(1), rst.getString(2));
                lista.add(curso);
            }
            InicializaBD.desconectar(con);
        } catch (SQLException e) {
            Mensagem.mensagemDeErro("Não foi possível executar \n" + SELECT_TODOS);
        }
        return lista;
    }

    public static Curso getCursoPorNome(String nome) {
        return null;
    }

    public static Curso getCursoPorId(int idPesquisa) {
        Curso retorno = null;
        Connection con = InicializaBD.conectar();
        try {
            String sql = String.format(SELECT_POR_ID, idPesquisa);
            ResultSet rs = con.createStatement().executeQuery(sql);
            rs.next();
            int id = rs.getInt("id_curso");
            String nome = rs.getString("nome");
            retorno = new Curso(id, nome);
            InicializaBD.desconectar(con);
        } catch (SQLException e) {
            Mensagem.mensagemDeErro("Não foi possível executar \n" + SELECT_POR_ID);
        }
        return retorno;
    }
}

    

