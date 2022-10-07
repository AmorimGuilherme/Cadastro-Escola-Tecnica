package br.com.escola.visao;

import br.com.escola.modelo.bd.PopulaBD;
import br.com.escola.modelo.dao.AlunoDAO;
import br.com.escola.modelo.dao.CursoDAO;
import br.com.escola.modelo.dao.MatriculaDAO;
import br.com.escola.modelo.entidade.Aluno;
import br.com.escola.modelo.entidade.Curso;
import br.com.escola.modelo.entidade.Matricula;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guilh
 */
public class EscolaGUI extends javax.swing.JFrame {

    /**
     * Creates new form Escola
     */
    public EscolaGUI() {
        initComponents();
        PopulaBD.inicializarBD();
        populaTodosOsCombos();
        atualizaTodos();
    }
    
    private void populaTodosOsCombos(){
        populaComboBoxAluno();
        populaComboBoxCurso();
    }

    private void populaComboBoxCurso() {
        jcIdCurso.removeAllItems();
        List<Curso> cursos = CursoDAO.selecionarTodos();
        for (Curso curso : cursos) {
            jcIdCurso.addItem(String.valueOf(curso.getId()));
        }
    }

    private void populaComboBoxAluno() {
        jcIdAluno.removeAllItems();
        List<Aluno> alunos = AlunoDAO.selecionarTodos();
        for (Aluno aluno : alunos) {
            jcIdAluno.addItem(String.valueOf(aluno.getId()));
        }
    }

    private void atualizaTodos() {
        atualizaAluno();
        atualizaCurso();
        atualizaMatricula();

    }

    private void atualizaMatricula() {
        String[] camposMatricula = {"Id", "Id_Curso", "Id_Aluno"};
        List<Matricula> matriculas = MatriculaDAO.selecionarTodos();
        String[][] dadosMatricula = new String[matriculas.size()][];
        int posicao = 0;
        for (Matricula matricula : matriculas) {
            String[] umaMatricula = new String[matriculas.size()];
            umaMatricula[0] = String.valueOf(matricula.getId());
            umaMatricula[1] = String.valueOf(matricula.getCurso().getId());
            umaMatricula[2] = String.valueOf(matricula.getAluno().getId());
            dadosMatricula[posicao++] = umaMatricula;
        }
        DefaultTableModel modeloMatricula = new DefaultTableModel(
                dadosMatricula, camposMatricula);
        jtMatricula.setModel(modeloMatricula);
    }


    private void atualizaAluno() {
        String[] camposAlunos = {"Id", "Nome"};
        List<Aluno> alunos = AlunoDAO.selecionarTodos();
        String[][] dadosAlunos = new String[alunos.size()][];
        int posicao = 0;
        for (Aluno aluno : alunos) {
            String[] umAluno = new String[alunos.size()];
            umAluno[0] = String.valueOf(aluno.getId());
            umAluno[1] = aluno.getNome();
            dadosAlunos[posicao++] = umAluno;
        }
        DefaultTableModel modeloAluno = new DefaultTableModel(
                dadosAlunos, camposAlunos);
        jtAluno.setModel(modeloAluno);

    }

    private void atualizaCurso() {
        String[] camposCursos = {"Id", "Nome"};
        List<Curso> cursos = CursoDAO.selecionarTodos();
        String[][] dadosCursos = new String[cursos.size()][];
        int posicao = 0;
        for (Curso curso : cursos) {
            String[] umCurso = new String[cursos.size()];
            umCurso[0] = String.valueOf(curso.getId());
            umCurso[1] = curso.getNome();
            dadosCursos[posicao++] = umCurso;
        }
        DefaultTableModel modeloCurso = new DefaultTableModel(
                dadosCursos, camposCursos);
        jtCurso.setModel(modeloCurso);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPrincipal = new javax.swing.JPanel();
        jtpAbas = new javax.swing.JTabbedPane();
        jpCurso = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCurso = new javax.swing.JTable();
        jbAdicionaCursp = new javax.swing.JButton();
        jbAlteraCurso = new javax.swing.JButton();
        jbDeletaCurso = new javax.swing.JButton();
        JbAtualizaCurso = new javax.swing.JButton();
        jpAluno = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtAluno = new javax.swing.JTable();
        jbAdicionaAluno = new javax.swing.JButton();
        jbAlteraAluno = new javax.swing.JButton();
        jbDeletaAluno = new javax.swing.JButton();
        jpMatricula = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtMatricula = new javax.swing.JTable();
        jbMatriculaAluno = new javax.swing.JButton();
        jcIdCurso = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcIdAluno = new javax.swing.JComboBox<>();
        jbAlteraMatricula = new javax.swing.JButton();
        jbDeletaMatricula = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtCurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtCurso);

        jbAdicionaCursp.setText("ADD");
        jbAdicionaCursp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdicionaCurspActionPerformed(evt);
            }
        });

        jbAlteraCurso.setText("ALT");
        jbAlteraCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlteraCursoActionPerformed(evt);
            }
        });

        jbDeletaCurso.setText("DEL");
        jbDeletaCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeletaCursoActionPerformed(evt);
            }
        });

        JbAtualizaCurso.setText("ATUALIZA");
        JbAtualizaCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbAtualizaCursoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpCursoLayout = new javax.swing.GroupLayout(jpCurso);
        jpCurso.setLayout(jpCursoLayout);
        jpCursoLayout.setHorizontalGroup(
            jpCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCursoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jpCursoLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(JbAtualizaCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbAdicionaCursp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbAlteraCurso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbDeletaCurso)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpCursoLayout.setVerticalGroup(
            jpCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCursoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAdicionaCursp)
                    .addComponent(jbAlteraCurso)
                    .addComponent(jbDeletaCurso)
                    .addComponent(JbAtualizaCurso))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jtpAbas.addTab("Cursos", jpCurso);

        jtAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jtAluno);

        jbAdicionaAluno.setText("ADD");
        jbAdicionaAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdicionaAlunoActionPerformed(evt);
            }
        });

        jbAlteraAluno.setText("ALT");
        jbAlteraAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlteraAlunoActionPerformed(evt);
            }
        });

        jbDeletaAluno.setText("DEL");
        jbDeletaAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeletaAlunoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpAlunoLayout = new javax.swing.GroupLayout(jpAluno);
        jpAluno.setLayout(jpAlunoLayout);
        jpAlunoLayout.setHorizontalGroup(
            jpAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAlunoLayout.createSequentialGroup()
                .addGroup(jpAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpAlunoLayout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jbAdicionaAluno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbAlteraAluno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbDeletaAluno))
                    .addGroup(jpAlunoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpAlunoLayout.setVerticalGroup(
            jpAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAlunoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAdicionaAluno)
                    .addComponent(jbAlteraAluno)
                    .addComponent(jbDeletaAluno))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jtpAbas.addTab("Alunos", jpAluno);

        jtMatricula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jtMatricula);

        jbMatriculaAluno.setText("Nova Matricula");
        jbMatriculaAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMatriculaAlunoActionPerformed(evt);
            }
        });

        jcIdCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcIdCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcIdCursoActionPerformed(evt);
            }
        });

        jLabel1.setText("Id Curso");

        jLabel2.setText("Id Aluno");

        jcIdAluno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jbAlteraMatricula.setText("Altera Matricula");
        jbAlteraMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlteraMatriculaActionPerformed(evt);
            }
        });

        jbDeletaMatricula.setText("Deleta Matricula");
        jbDeletaMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeletaMatriculaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpMatriculaLayout = new javax.swing.GroupLayout(jpMatricula);
        jpMatricula.setLayout(jpMatriculaLayout);
        jpMatriculaLayout.setHorizontalGroup(
            jpMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMatriculaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                    .addGroup(jpMatriculaLayout.createSequentialGroup()
                        .addGroup(jpMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jcIdCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMatriculaLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(16, 16, 16))
                            .addComponent(jcIdAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbMatriculaAluno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbAlteraMatricula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbDeletaMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addContainerGap())
        );
        jpMatriculaLayout.setVerticalGroup(
            jpMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMatriculaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jpMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMatriculaLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcIdCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMatriculaLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcIdAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbMatriculaAluno)
                        .addComponent(jbDeletaMatricula)
                        .addComponent(jbAlteraMatricula)))
                .addGap(23, 23, 23))
        );

        jtpAbas.addTab("Matricula", jpMatricula);

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtpAbas)
                .addContainerGap())
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtpAbas, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbDeletaCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeletaCursoActionPerformed
        // TODO add your handling code here:

        int linha = jtCurso.getSelectedRow();
        Byte id = Byte.parseByte((String) jtCurso.getValueAt(
                linha, 0));
        String nome = (String) jtCurso.getValueAt(linha, 1);
        Curso cursoDeletado = new Curso(id, nome);
        CursoDAO.apagar(cursoDeletado);
        atualizaTodos();
    }//GEN-LAST:event_jbDeletaCursoActionPerformed


    private void jbDeletaAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeletaAlunoActionPerformed
        // TODO add your handling code here:
        int linha = jtAluno.getSelectedRow();
        Byte id = Byte.parseByte((String) jtAluno.getValueAt(
                linha, 0));
        String nome = (String) jtAluno.getValueAt(linha, 1);
        Aluno alunoDeletado = new Aluno(id, nome);
        AlunoDAO.apagar(alunoDeletado);
        atualizaTodos();
    }//GEN-LAST:event_jbDeletaAlunoActionPerformed

    private void jbAdicionaCurspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdicionaCurspActionPerformed
        // TODO add your handling code here:
        String nome = JOptionPane.showInputDialog(
                null, "Nome");
        Curso curso = new Curso(nome);
        CursoDAO.inserir(curso);
        atualizaTodos();

    }//GEN-LAST:event_jbAdicionaCurspActionPerformed

    private void jbAlteraCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlteraCursoActionPerformed
        // TODO add your handling code here:
        String nome = JOptionPane.showInputDialog(
                null, "Nome");
        int linha = jtCurso.getSelectedRow();
        Byte id = Byte.parseByte((String) jtCurso.getValueAt(
                linha, 0));
        Curso cursoAlterado = new Curso(id, nome);
        CursoDAO.alterar(cursoAlterado);
        atualizaTodos();

    }//GEN-LAST:event_jbAlteraCursoActionPerformed

    private void jbAdicionaAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdicionaAlunoActionPerformed
        // TODO add your handling code here:
        String nome = JOptionPane.showInputDialog(
                null, "Nome");
        Aluno aluno = new Aluno(nome);
        AlunoDAO.inserir(aluno);
        atualizaTodos();
    }//GEN-LAST:event_jbAdicionaAlunoActionPerformed

    private void jbAlteraAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlteraAlunoActionPerformed
        // TODO add your handling code here:
        String nome = JOptionPane.showInputDialog(
                null, "Nome");
        int linha = jtAluno.getSelectedRow();
        Byte id = Byte.parseByte((String) jtAluno.getValueAt(
                linha, 0));
        Aluno alunoAlterada = new Aluno(id, nome);
        AlunoDAO.alterar(alunoAlterada);
        atualizaTodos();
    }//GEN-LAST:event_jbAlteraAlunoActionPerformed

    private void jbMatriculaAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMatriculaAlunoActionPerformed
        // TODO add your handling code here:
         JOptionPane.showMessageDialog(rootPane, "Não implementado", "Deleta Matricula", JOptionPane.ERROR_MESSAGE, null);
//        int linhaSelecionada = jtMatricula.getSelectedRow();
//        if(jtMatricula.isRowSelected(linhaSelecionada));
//        Matricula matricula = getMatriculaPorLinha(linhaSelecionada);
//        String idCursoString = jcIdCurso.getSelectedItem().toString();
//        int idCursoInt = Integer.parseInt(idCursoString);
//        String idAlunoString = jcIdAluno.getSelectedItem().toString();
//        int idAlunoInt = Integer.parseInt(idAlunoString);
//        
//        Aluno alunoMatriculado = new Aluno(idAlunoInt);
//        Curso cursoCadastrado = new Curso(idCursoInt);
//        
//        matricula.setAluno(alunoMatriculado);
//        matricula.setCurso(cursoCadastrado);
//        
//        MatriculaDAO.inserir(matricula);
//        atualizaTodos();
    
        
        

    }//GEN-LAST:event_jbMatriculaAlunoActionPerformed

    private void jcIdCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcIdCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcIdCursoActionPerformed

    private void jbDeletaMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeletaMatriculaActionPerformed
        // TODO add your handling code here:
//        JOptionPane.showMessageDialog(rootPane, "Não implementado", "Deleta Matricula",
//                JOptionPane.ERROR_MESSAGE, null);
        int linha = jtMatricula.getSelectedRow();
        Byte id = Byte.parseByte((String) jtMatricula.getValueAt(
                linha, 0));
        Byte id_curso = Byte.parseByte((String) jtMatricula.getValueAt(
                linha, 1));
        Byte id_aluno = Byte.parseByte((String) jtMatricula.getValueAt(
                linha, 2));
        Curso idCursoDeletado = new Curso(id_curso);
        Aluno idAlunoDeletado = new Aluno(id_aluno);
        
        Matricula matriculaDeletada = new Matricula(id, idCursoDeletado, idAlunoDeletado);
        MatriculaDAO.apagar(matriculaDeletada);
        atualizaTodos();
    }//GEN-LAST:event_jbDeletaMatriculaActionPerformed

    private void jbAlteraMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlteraMatriculaActionPerformed
        // TODO add your handling code here:
         JOptionPane.showMessageDialog(rootPane, "Não implementado", "Deleta Matricula", JOptionPane.ERROR_MESSAGE, null);
    }//GEN-LAST:event_jbAlteraMatriculaActionPerformed

    private void JbAtualizaCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbAtualizaCursoActionPerformed
        // TODO add your handling code here:
        atualizaCurso();
    }//GEN-LAST:event_JbAtualizaCursoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EscolaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EscolaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EscolaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EscolaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EscolaGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbAtualizaCurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbAdicionaAluno;
    private javax.swing.JButton jbAdicionaCursp;
    private javax.swing.JButton jbAlteraAluno;
    private javax.swing.JButton jbAlteraCurso;
    private javax.swing.JButton jbAlteraMatricula;
    private javax.swing.JButton jbDeletaAluno;
    private javax.swing.JButton jbDeletaCurso;
    private javax.swing.JButton jbDeletaMatricula;
    private javax.swing.JButton jbMatriculaAluno;
    private javax.swing.JComboBox<String> jcIdAluno;
    private javax.swing.JComboBox<String> jcIdCurso;
    private javax.swing.JPanel jpAluno;
    private javax.swing.JPanel jpCurso;
    private javax.swing.JPanel jpMatricula;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JTable jtAluno;
    private javax.swing.JTable jtCurso;
    private javax.swing.JTable jtMatricula;
    private javax.swing.JTabbedPane jtpAbas;
    // End of variables declaration//GEN-END:variables
}