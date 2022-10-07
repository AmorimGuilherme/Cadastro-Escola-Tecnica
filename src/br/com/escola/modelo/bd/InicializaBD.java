package br.com.escola.modelo.bd;

import br.com.escola.modelo.mensagem.Mensagem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InicializaBD {
    
     public static void execute(String sql, boolean continuaNoErro) {
        Connection con = conectar();
        try {
            con.createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            Mensagem.mensagemDeErro("Não foi possível executar \n" + e);
            if (!continuaNoErro) {
                System.exit(1);
            }
        }
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
}

