/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author arthurzimmer
 */
public class RelatorioTecnologiaDialog extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(RelatorioTecnologiaDialog.class.getName());
    private Tecnologias tecnologias;
    /**
     * Creates new form RelatorioTecnologiaDialog
     */
    public RelatorioTecnologiaDialog(java.awt.Frame parent, boolean modal, Tecnologias listaTecnologias) {
        super(parent, modal);        
        initComponents();        
        this.tecnologias = listaTecnologias;

        java.awt.Color corFundo = java.awt.Color.WHITE; 
        java.awt.Color corPrimaria = new java.awt.Color(0, 80, 160); // Azul
        java.awt.Color corHover = new java.awt.Color(0, 60, 130); // Azul escuro
        java.awt.Color corTextoBotao = java.awt.Color.WHITE; 
        java.awt.Color corSecundaria = new java.awt.Color(220, 220, 220); // Cinza
        java.awt.Color corSecundariaHover = new java.awt.Color(200, 200, 200);
        java.awt.Color corTextoSecundario = new java.awt.Color(50, 50, 50); 
        java.awt.Color corBordaCampo = new java.awt.Color(200, 200, 200);
        java.awt.Color corFundoRelatorio = new java.awt.Color(248, 248, 248); // Fundo quase branco

        java.awt.Font fonteTitulo = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 22);
        java.awt.Font fonteBotao = new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14);
        java.awt.Font fonteRelatorio = new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 14);

        // dialog
        getContentPane().removeAll();
        getContentPane().setLayout(new java.awt.BorderLayout());
        getContentPane().setBackground(corFundo);
        
        // titulo
        javax.swing.JPanel panelTitulo = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        panelTitulo.setBackground(corFundo);
        panelTitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 25, 15, 25));
        
        javax.swing.JLabel lblTitulo = new javax.swing.JLabel("Relatório de Tecnologia");
        lblTitulo.setFont(fonteTitulo);
        lblTitulo.setForeground(corPrimaria);
        panelTitulo.add(lblTitulo);
        
        // relatorio
        javax.swing.JPanel panelCentro = new javax.swing.JPanel(new java.awt.BorderLayout());
        panelCentro.setBackground(corFundo);
        panelCentro.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 25, 20, 25)); // Padding
        
        // text pane relatorio
        TPRelatorio.setEditable(false); 
        TPRelatorio.setFont(fonteRelatorio);
        TPRelatorio.setBackground(corFundoRelatorio);
        TPRelatorio.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding interno
        
        // scrollpane relatorio
        jScrollPane1.setViewportView(TPRelatorio);
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(corBordaCampo)); // Borda cinza
        
        panelCentro.add(jScrollPane1, java.awt.BorderLayout.CENTER);

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

        // funcoes de estilo
        java.awt.Dimension tamBotaoSecundario = new java.awt.Dimension(110, 35);
        java.awt.Dimension tamBotaoPrimario = new java.awt.Dimension(160, 35); // Botão "Gerar"

        // estilo primario - azul
        java.util.function.Consumer<javax.swing.AbstractButton> estiloPrimario = (botao) -> {
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

        // estilo secundario - cinza
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

        // aplica style
        estiloPrimario.accept(btnRelatório); // Botão Gerar Relatório (Principal)
        estiloSecundario.accept(btnVoltar); // Botão Voltar (Secundário)

        // adicionar botões aos painéis
        panelBotoesEsquerda.add(btnRelatório); // Gerar Relatório
        panelBotoesDireita.add(btnVoltar); // Voltar

        // monta tudo
        getContentPane().add(panelTitulo, java.awt.BorderLayout.NORTH);
        getContentPane().add(panelCentro, java.awt.BorderLayout.CENTER);
        getContentPane().add(panelSul, java.awt.BorderLayout.SOUTH);

        // ajusta tamanho e visibilidade
        this.setSize(800, 600); // Tamanho padrão
        this.setMinimumSize(new java.awt.Dimension(500, 400));
        this.setResizable(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TPRelatorio = new javax.swing.JTextPane();
        btnVoltar = new javax.swing.JButton();
        btnRelatório = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório Tecnologia");

        TPRelatorio.setEnabled(false);
        TPRelatorio.setFocusable(false);
        jScrollPane1.setViewportView(TPRelatorio);

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnRelatório.setText("Gerar Relatório");
        btnRelatório.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatórioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnVoltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRelatório)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnRelatório))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnRelatórioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatórioActionPerformed
        int tam = tecnologias.size();
        String relatorio = "";
        
        for (int i = 0; i < tam; i++) {
            relatorio = relatorio + "DADOS DA TECNOLOGIA " + (i + 1) + ": " + tecnologias.getTecnologia(i).toString() + "\n\n";
        }
        
        TPRelatorio.setText(relatorio);
    }//GEN-LAST:event_btnRelatórioActionPerformed

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
                java.util.ArrayList<Tecnologia> listaTeste = new java.util.ArrayList<>();
                Tecnologias tecnologiasParaTeste = new Tecnologias(listaTeste);
                java.util.ArrayList<Fornecedor> listaFornTeste = new java.util.ArrayList<>();
                Fornecedores fornecedoresParaTeste = new Fornecedores(listaFornTeste);
                CadastroTecnologiaDialog dialog = new CadastroTecnologiaDialog(framePaiParaTeste, true, fornecedoresParaTeste, tecnologiasParaTeste);
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
    private javax.swing.JTextPane TPRelatorio;
    private javax.swing.JButton btnRelatório;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
