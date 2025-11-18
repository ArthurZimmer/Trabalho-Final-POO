/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author arthurzimmer
 */
public class RelatorioCompradorDialog extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(RelatorioCompradorDialog.class.getName());
    private Compradores compradores;
    /**
     * Creates new form RelatorioCompradorDialog
     */
    public RelatorioCompradorDialog(java.awt.Frame parent, boolean modal, Compradores listaCompradores) {
        super(parent, modal);        
        initComponents();        
        this.compradores = listaCompradores;

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
        java.awt.Font fonteRelatorio = new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 14); // Fonte monoespaçada

        // dialog
        getContentPane().removeAll();
        getContentPane().setLayout(new java.awt.BorderLayout());
        getContentPane().setBackground(corFundo);
        
        // titulo
        javax.swing.JPanel panelTitulo = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        panelTitulo.setBackground(corFundo);
        panelTitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 25, 15, 25));
        
        javax.swing.JLabel lblTitulo = new javax.swing.JLabel("Relatório de Compradores");
        lblTitulo.setFont(fonteTitulo);
        lblTitulo.setForeground(corPrimaria);
        panelTitulo.add(lblTitulo);
        
        // relatorio
        javax.swing.JPanel panelCentro = new javax.swing.JPanel(new java.awt.BorderLayout());
        panelCentro.setBackground(corFundo);
        panelCentro.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 25, 20, 25)); // Padding
        
        // rext pane relatorio
        TPRelatorio.setEditable(false); 
        TPRelatorio.setFont(fonteRelatorio);
        TPRelatorio.setBackground(corFundoRelatorio);
        TPRelatorio.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding interno
        
        // scroll pane relatorio
        jScrollPane1.setViewportView(TPRelatorio);
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(corBordaCampo)); // Borda cinza
        
        panelCentro.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        // botoes
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

        // estilo primário (azul)
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
        estiloPrimario.accept(jButton2); // Botão Gerar Relatório (Principal)
        estiloSecundario.accept(jButton1); // Botão Voltar (Secundário)

        // adicionar botões aos painéis
        panelBotoesEsquerda.add(jButton2); // Gerar Relatório
        panelBotoesDireita.add(jButton1); // Voltar

        // monta tudo
        getContentPane().add(panelTitulo, java.awt.BorderLayout.NORTH);
        getContentPane().add(panelCentro, java.awt.BorderLayout.CENTER);
        getContentPane().add(panelSul, java.awt.BorderLayout.SOUTH);

        // tamanho e visibilidade
        this.setSize(800, 600);
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TPRelatorio.setEnabled(false);
        TPRelatorio.setFocusable(false);
        jScrollPane1.setViewportView(TPRelatorio);

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Gerar Relatório");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int tam = compradores.size();
        String relatorio = "";
        
        for (int i = 0; i < tam; i++) {
            relatorio = relatorio + "DADOS DO COMPRADOR " + (i + 1) + ": " + compradores.getComprador(i).toString() + "\n\n";
        }
        
        TPRelatorio.setText(relatorio);
    }//GEN-LAST:event_jButton2ActionPerformed

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
                RelatorioCompradorDialog dialog = new RelatorioCompradorDialog(new javax.swing.JFrame(), true, compradoresParaTeste);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
