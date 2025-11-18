/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author arthurzimmer
 */
public class CadastroCompradorDialog extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CadastroCompradorDialog.class.getName());
    private Comprador comprador;
    private Compradores compradores;
    private boolean cadastrouComprador = false;
    /**
     * Creates new form CadastroCompradorDialog
     */
    public CadastroCompradorDialog(java.awt.Frame parent, boolean modal, Compradores listaCompradores) {
        super(parent, modal);
        initComponents();
        this.compradores = listaCompradores;
        atualizarContador();

        java.awt.Color corFundo = java.awt.Color.WHITE; 
        java.awt.Color corPrimaria = new java.awt.Color(0, 80, 160); // Azul
        java.awt.Color corHover = new java.awt.Color(0, 60, 130); // Azul escuro
        java.awt.Color corTextoBotao = java.awt.Color.WHITE; 
        java.awt.Color corSecundaria = new java.awt.Color(220, 220, 220); // Cinza
        java.awt.Color corSecundariaHover = new java.awt.Color(200, 200, 200);
        java.awt.Color corTextoSecundario = new java.awt.Color(50, 50, 50); 
        java.awt.Color corBordaCampo = new java.awt.Color(200, 200, 200);
        java.awt.Color corTextoLabel = new java.awt.Color(50, 50, 50);

        java.awt.Font fonteTitulo = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 22);
        java.awt.Font fonteLabel = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16);
        java.awt.Font fonteCampo = new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 16);
        java.awt.Font fonteBotao = new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14);

        getContentPane().removeAll();
        getContentPane().setLayout(new java.awt.BorderLayout());
        getContentPane().setBackground(corFundo);
        
        // titulo
        javax.swing.JPanel panelTitulo = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        panelTitulo.setBackground(corFundo);
        panelTitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 25, 15, 25));
        
        javax.swing.JLabel lblTitulo = new javax.swing.JLabel("Cadastro de Comprador"); 
        lblTitulo.setFont(fonteTitulo);
        lblTitulo.setForeground(corPrimaria);
        panelTitulo.add(lblTitulo);
        
        // formulario
        javax.swing.JPanel panelFormulario = new javax.swing.JPanel();
        panelFormulario.setBackground(corFundo);
        panelFormulario.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 30, 20, 30));
        panelFormulario.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.insets = new java.awt.Insets(8, 8, 8, 8); // Espaçamento
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;

        // estilo labels
        javax.swing.JLabel[] labels = {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5};
        for (javax.swing.JLabel label : labels) {
            label.setFont(fonteLabel);
            label.setForeground(corTextoLabel);
        }

        // estilo text fields
        javax.swing.border.Border bordaCampo = javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(corBordaCampo),
            javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8) // Padding interno
        );
        javax.swing.JTextField[] fields = {TFId, TFNome, TFEmail, TFPais};
        for (javax.swing.JTextField field : fields) {
            field.setFont(fonteCampo);
            field.setBorder(bordaCampo);
        }
        
        // estilo quantidade
        TFQtdCadastrada.setFont(fonteCampo);
        TFQtdCadastrada.setBorder(bordaCampo);
        TFQtdCadastrada.setBackground(new java.awt.Color(235, 235, 235));
        TFQtdCadastrada.setEditable(false);
        
        // coluna 0 (labels)
        gbc.gridx = 0; gbc.anchor = java.awt.GridBagConstraints.WEST; gbc.weightx = 0.1; gbc.fill = java.awt.GridBagConstraints.NONE;
        gbc.gridy = 0; panelFormulario.add(jLabel1, gbc); // ID
        gbc.gridy = 1; panelFormulario.add(jLabel2, gbc); // Nome
        gbc.gridy = 2; panelFormulario.add(jLabel3, gbc); // Email
        gbc.gridy = 3; panelFormulario.add(jLabel4, gbc); // País
        gbc.gridy = 4; panelFormulario.add(jLabel5, gbc); // Qtd Cadastrada

        // coluna 1 (campos)
        gbc.gridx = 1; gbc.anchor = java.awt.GridBagConstraints.WEST; gbc.weightx = 0.9; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbc.gridy = 0; panelFormulario.add(TFId, gbc);
        gbc.gridy = 1; panelFormulario.add(TFNome, gbc);
        gbc.gridy = 2; panelFormulario.add(TFEmail, gbc);
        gbc.gridy = 3; panelFormulario.add(TFPais, gbc);
        
        // campo quantidad (tratamento especial)
        gbc.gridy = 4; gbc.fill = java.awt.GridBagConstraints.NONE; // Não esticar
        TFQtdCadastrada.setPreferredSize(new java.awt.Dimension(80, 38)); // Tamanho fixo
        panelFormulario.add(TFQtdCadastrada, gbc);

        // botões
        javax.swing.JPanel panelSul = new javax.swing.JPanel(new java.awt.BorderLayout());
        panelSul.setBackground(corFundo);
        panelSul.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 25, 20, 25));

        javax.swing.JPanel panelBotoesEsquerda = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 0));
        panelBotoesEsquerda.setBackground(corFundo);
        
        javax.swing.JPanel panelBotoesDireita = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 0));
        panelBotoesDireita.setBackground(corFundo);

        panelSul.add(panelBotoesEsquerda, java.awt.BorderLayout.WEST);
        panelSul.add(panelBotoesDireita, java.awt.BorderLayout.EAST);

        // funções pra estilo
        java.awt.Dimension tamBotaoSecundario = new java.awt.Dimension(110, 35);
        java.awt.Dimension tamBotaoPrimario = new java.awt.Dimension(120, 35);

        // estilo primário (azul)
        java.util.function.Consumer<javax.swing.JButton> estiloPrimario = (botao) -> {
            botao.setFont(fonteBotao);
            botao.setBackground(corPrimaria);
            botao.setForeground(corTextoBotao);
            botao.setOpaque(true);
            botao.setBorderPainted(false);
            botao.setFocusPainted(false);
            botao.setPreferredSize(tamBotaoPrimario);
            botao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            botao.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) { botao.setBackground(corHover); }
                public void mouseExited(java.awt.event.MouseEvent evt) { botao.setBackground(corPrimaria); }
            });
        };

        // estilo secundário (cinza)
        java.util.function.Consumer<javax.swing.AbstractButton> estiloSecundario = (botao) -> {
            botao.setFont(fonteBotao);
            botao.setBackground(corSecundaria);
            botao.setForeground(corTextoSecundario);
            botao.setOpaque(true);
            botao.setBorderPainted(false);
            botao.setFocusPainted(false);
            botao.setPreferredSize(tamBotaoSecundario);
            botao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            botao.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) { botao.setBackground(corSecundariaHover); }
                public void mouseExited(java.awt.event.MouseEvent evt) { botao.setBackground(corSecundaria); }
            });
        };

        // aplica estilos
        estiloPrimario.accept(BtnCadastraCompraador); // Botão Cadastrar
        estiloSecundario.accept(jButton1); // Botão Voltar 
        estiloSecundario.accept(btnLimpar); // Botão Limpar
        estiloSecundario.accept(btnRelatorio); // Botão Relatório

        // adicionar botoes nos paineis
        panelBotoesEsquerda.add(btnLimpar);
        panelBotoesEsquerda.add(btnRelatorio);
        
        panelBotoesDireita.add(jButton1); // Voltar
        panelBotoesDireita.add(BtnCadastraCompraador); // Cadastrar

        // monta tudo
        getContentPane().add(panelTitulo, java.awt.BorderLayout.NORTH);
        getContentPane().add(panelFormulario, java.awt.BorderLayout.CENTER);
        getContentPane().add(panelSul, java.awt.BorderLayout.SOUTH);

        // tamanho do painele
        this.pack(); // Ajusta a janela ao tamanho do conteúdo
        this.setMinimumSize(new java.awt.Dimension(650, 550)); // Define um tamanho mínimo
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TFId = new javax.swing.JTextField();
        TFNome = new javax.swing.JTextField();
        TFEmail = new javax.swing.JTextField();
        TFPais = new javax.swing.JTextField();
        TFQtdCadastrada = new javax.swing.JTextField();
        BtnCadastraCompraador = new javax.swing.JButton();
        btnLimpar = new javax.swing.JToggleButton();
        btnRelatorio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ID:");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome:");

        jLabel3.setText("Email:");

        jLabel4.setText("País:");

        jLabel5.setText("Qtd cadastrada:");

        TFId.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        TFQtdCadastrada.setEnabled(false);
        TFQtdCadastrada.setFocusable(false);

        BtnCadastraCompraador.setText("Cadastrar");
        BtnCadastraCompraador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCadastraCompraadorActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnRelatorio.setText("Relatório");
        btnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TFQtdCadastrada, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFPais)
                    .addComponent(TFEmail)
                    .addComponent(TFNome)
                    .addComponent(TFId, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(121, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnCadastraCompraador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TFId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TFPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TFQtdCadastrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(btnLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(BtnCadastraCompraador)
                    .addComponent(btnRelatorio))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BtnCadastraCompraadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCadastraCompraadorActionPerformed
        try{    
            String codString = TFId.getText();
            if (!codString.matches("^\\d*$"))
                    throw new IllegalArgumentException("Formato inválido de código!");
            if(codString.equals(""))
                    throw new IllegalArgumentException("O ID é obrigatório!");
            long cod = Long.parseLong(codString);

            String nome = TFNome.getText();
            if(nome.equals(""))
                throw new IllegalArgumentException("Informe algum nome!");
            
            String email = TFEmail.getText();
            if(email.equals(""))
                throw new IllegalArgumentException("Informe algum email!");
            
            String pais = TFPais.getText();
            if(pais.equals(""))
                throw new IllegalArgumentException("Informe algum pais!");

            comprador = new Comprador(cod, nome, pais, email);

            if (compradores.addComprador(comprador)){
                cadastrouComprador = true;
                atualizarContador();
            } else {
                cadastrouComprador = false;
            } 
        } catch (IllegalArgumentException e) {
            System.err.println(e);
        }    
    }//GEN-LAST:event_BtnCadastraCompraadorActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        for (int i = 0; i < 100; i++) {
            long cod = i;
            String nome = "comprador" + i;
            String email = "comprador" + i + "@email.com";
            String pais = "Brasil";

            comprador = new Comprador(cod, nome, pais, email);

            if (compradores.addComprador(comprador)){
                cadastrouComprador = true;
                atualizarContador();
            } else {
                cadastrouComprador = false;
            } 
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        TFId.setText("");
        TFNome.setText("");
        TFEmail.setText("");
        TFPais.setText("");
        TFQtdCadastrada.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        TelaInicial telaAux = new TelaInicial();
        
        RelatorioCompradorDialog modalRelatorio = new RelatorioCompradorDialog(telaAux, true, compradores);
        modalRelatorio.setLocationRelativeTo(null);
        modalRelatorio.setVisible(true);
    }//GEN-LAST:event_btnRelatorioActionPerformed

    public void atualizarContador() {
        int total = this.compradores.size();
        TFQtdCadastrada.setText(String.valueOf(total));
    }    
    
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                javax.swing.JFrame framePaiParaTeste = new javax.swing.JFrame();
                java.util.ArrayList<Comprador> listaTeste = new java.util.ArrayList<>();
                Compradores compradoresParaTeste = new Compradores(listaTeste);
                CadastroCompradorDialog dialog = new CadastroCompradorDialog(framePaiParaTeste, true, compradoresParaTeste);

                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCadastraCompraador;
    private javax.swing.JTextField TFEmail;
    private javax.swing.JTextField TFId;
    private javax.swing.JTextField TFNome;
    private javax.swing.JTextField TFPais;
    private javax.swing.JTextField TFQtdCadastrada;
    private javax.swing.JToggleButton btnLimpar;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
