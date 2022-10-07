package br.com.escola.modelo.bd;

import br.com.escola.modelo.mensagem.Mensagem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PopulaBD {

    public static void inicializarBD() {
        String sql;
        Connection con = conectar();

        //  CRIANDO BANCO DE DADOS
        sql = "Create database if not exists escola;";
        execute(con, sql);
        sql = "use escola;";
        execute(con, sql);

        //  DELETA TABELA SE EXISTE
        sql = "Drop table if exists matricula; ";
        execute(con, sql);
        sql = "Drop table if exists curso; ";
        execute(con, sql);
        sql = "Drop table if exists aluno; ";
        execute(con, sql);

        //  CRIANDO TABELA CURSO
        sql = "Create table if not exists curso "
                + "(id_curso int not null auto_increment primary key, "
                + "nome varchar(30) not null); ";
        execute(con, sql);

        // CRIANDO TABELA ALUNO
        sql = "Create table if not exists aluno "
                + "(id_aluno int not null auto_increment primary key, "
                + "nome varchar(45) not null);";
        execute(con, sql);

        //  CRIANDO TABELA MATRICULA
        sql = "Create table if not exists matricula "
                + "(id_matricula int not null auto_increment primary key,"
                + " curso_id int not null,"
                + " aluno_id int not null,"
                + " FOREIGN KEY (curso_id) REFERENCES curso(id_curso), "
                + " FOREIGN KEY (aluno_id) REFERENCES aluno(id_aluno));";
        execute(con, sql);

        // INSERINDO DADOS PARA CURSO
        execute(con, sql);
        sql = "Insert into curso (nome) values ('CSharp');";
        execute(con, sql);
        sql = "Insert into curso (nome) values ('Java');";
        execute(con, sql);
        sql = "Insert into curso (nome) values ('MySQL');";
        execute(con, sql);
        sql = "Insert into curso (nome) values ('PHP');";
        execute(con, sql);
        sql = "Insert into curso (nome) values ('JavaScript');";
        execute(con, sql);
        sql = "Insert into curso (nome) values ('C++');";
        execute(con, sql);
        sql = "Insert into curso (nome) values ('Darth');";
        execute(con, sql);
        sql = "Insert into curso (nome) values ('Kotlin');";
        execute(con, sql);

        // INSERINDO DADOS PARA ALUNO
        sql = "Insert into aluno (nome) values ('Frank');";
        execute(con, sql);
        sql = "Insert into aluno (nome) values ('Sebastian');";
        execute(con, sql);
        sql = "Insert into aluno (nome) values ('Joana');";
        execute(con, sql);
        sql = "Insert into aluno (nome) values ('Giovanna');";
        execute(con, sql);
        sql = "Insert into aluno (nome) values ('Luan');";
        execute(con, sql);
        sql = "Insert into aluno (nome) values ('Antonio');";
        execute(con, sql);
        sql = "Insert into aluno (nome) values ('Carlos');";
        execute(con, sql);
        
//        // INSERIR DADOS PARA MATRICULA
//        sql = "Insert into matricula (curso_id, aluno_id) values (2,3);";
//        execute(con,sql);
        desconectar(con);
    }

    public static Connection conectar() {
        Connection con = null;
        final String USUARIO = "root";
        final String SENHA = "root";
        final String URL = "jdbc:mysql://localhost/escola";
        try {
            con = DriverManager.getConnection(URL,
                    USUARIO, SENHA);
        } catch (SQLException ex) {
            Mensagem.mensagemDeErro("Não foi possível conectar ao banco de dados. "
                    + "Verifique e tente posteriormente");
            System.exit(1);
        }
        return con;
    }

    public static void desconectar(Connection c) {
        try {
            c.close();
        } catch (SQLException ex) {
        }
    }

    private static void execute(Connection con, String sql) {
        try {
            con.createStatement().executeUpdate(sql);
        } catch (SQLException ex) {
            //System.out.println(ex.getLocalizedMessage());
            Mensagem.mensagemDeErro("Não foi possível executar\n" + sql);
            //System.exit(1);
        }
    }
}
