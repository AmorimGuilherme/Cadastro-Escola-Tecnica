package br.com.escola.modelo.mensagem;

import javax.swing.JOptionPane;


public class Mensagem {
    
    
    public static void mensagemDeErro(String msg) {
        JOptionPane.showMessageDialog(null, msg,
                "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void mensagem(String msg) {
        JOptionPane.showMessageDialog(null, msg, 
                "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }

}
    

