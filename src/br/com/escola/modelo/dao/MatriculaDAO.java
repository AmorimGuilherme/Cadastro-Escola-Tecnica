package br.com.escola.modelo.dao;

import br.com.escola.modelo.bd.InicializaBD;
import br.com.escola.modelo.entidade.Aluno;
import br.com.escola.modelo.entidade.Curso;
import br.com.escola.modelo.entidade.Matricula;
import br.com.escola.modelo.mensagem.Mensagem;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MatriculaDAO {

    private static final String INSERT_SQL = "Insert into matricula "
            + "(curso_id, aluno_id) "
            + "values (%d, %d)";
    private static final String DELETE_SQL = "Delete from matricula "
            + "where id_matricula = %d";
    private static final String SELECT_TODOS = "Select * from matricula ";
           
    private static final String SELECT_POR_ID = "Select * from matricula "
            + "where id_matricula = %d;";

    public static void inserir(Matricula matricula) {
        String sql = String.format(INSERT_SQL,
                matricula.getAluno().getId(), matricula.getCurso().getId());
        InicializaBD.execute(sql, true);

    }

//    public static void alterar(Matricula matricula) {
//        String sql = String.format(UPDATE_SQL,
//                curso.getNome(),
//                curso.getId());
//        InicializaBD.execute(sql, true);
//
//    }
    
    public static void apagar(Matricula matricula) {
        String sql = String.format(DELETE_SQL, matricula.getId());
        InicializaBD.execute(sql, true);
    }

    public static List<Matricula> selecionarTodos() {
        List<Matricula> lista = new ArrayList<>();
        Connection con = InicializaBD.conectar();
        try {
            ResultSet rs = con.createStatement().executeQuery(SELECT_TODOS);
            while (rs.next()) {
                int id = rs.getInt("id_matricula");
                int curso_id = rs.getInt("curso_id");
                int aluno_id = rs.getInt("aluno_id");
                Curso curso = new Curso(curso_id);
                Aluno aluno = new Aluno (aluno_id);
                lista.add(new Matricula(id, curso, aluno));
            }
            InicializaBD.desconectar(con);
        } catch (SQLException e) {
            Mensagem.mensagemDeErro("Não foi possível executar \n" + SELECT_TODOS);
        }
        return lista;
    }

    public static Matricula getMatriculaPorId(int idPesquisa) {
        Matricula retorno = null;
        Connection con = InicializaBD.conectar();
        try {
            String sql = String.format(SELECT_POR_ID, idPesquisa);
            ResultSet rs = con.createStatement().executeQuery(sql);
            rs.next();
            int id = rs.getInt("id_matricula");
            retorno = new Matricula(id);
            InicializaBD.desconectar(con);
        } catch (SQLException e) {
            Mensagem.mensagemDeErro("Não foi possível executar \n" + SELECT_POR_ID);
        }
        return retorno;
    }
}
