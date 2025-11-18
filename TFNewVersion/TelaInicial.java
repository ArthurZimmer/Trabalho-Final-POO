/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;

/**
 *
 * @author arthurzimmer
 */
public class TelaInicial extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaInicial.class.getName());
    private Fornecedores listaFornecedores = new Fornecedores(new ArrayList<>());
    private Tecnologias listaTecnologias = new Tecnologias(new ArrayList<>());
    private Compradores listaCompradores = new Compradores(new ArrayList<>());
    /**
     * Creates new form NewJFrame
     */
    /**
     * Creates new form NewJFrame
     */
    public TelaInicial() {
        // 1. O NetBeans constrói os componentes
        initComponents();

        // --- DEFINIÇÃO DA PALETA DE CORES E FONTES ---
        java.awt.Color corFundo = java.awt.Color.WHITE; 
        java.awt.Color corPrimaria = new java.awt.Color(0, 80, 160); // Azul-marinho
        java.awt.Color corHover = new java.awt.Color(0, 60, 130); // Azul mais escuro
        java.awt.Color corTextoBotao = java.awt.Color.WHITE; 
        java.awt.Color corFechar = new java.awt.Color(220, 220, 220); 
        java.awt.Color corFecharHover = new java.awt.Color(200, 200, 200);
        java.awt.Color corTextoFechar = new java.awt.Color(50, 50, 50); 
        
        java.awt.Font fonteTitulo = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 26);
        java.awt.Font fonteBotao = new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 18);
        java.awt.Font fonteBotaoFechar = new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14);

        
        // --- 2. CONFIGURAÇÃO DA JANELA ---
        getContentPane().removeAll();
        getContentPane().setLayout(new java.awt.BorderLayout());
        getContentPane().setBackground(corFundo);

        
        // --- 3. PAINEL NORTE (TÍTULO) ---
        javax.swing.JPanel panelTitulo = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER));
        panelTitulo.setBackground(corFundo);
        panelTitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(40, 30, 30, 30));
        
        jLabel1.setFont(fonteTitulo);
        jLabel1.setForeground(corPrimaria);
        panelTitulo.add(jLabel1);

        
        // --- 4. PAINEL CENTRAL (BOTÕES) ---
        javax.swing.JPanel panelBotoes = new javax.swing.JPanel();
        panelBotoes.setBackground(corFundo);
        panelBotoes.setLayout(new java.awt.GridLayout(4, 1, 0, 15));
        panelBotoes.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 300, 30, 300)); 

        java.awt.Dimension tamBotao = new java.awt.Dimension(200, 30); 

        // Função para aplicar o estilo principal
        java.util.function.Consumer<javax.swing.JButton> aplicarEstilo = (botao) -> {
            botao.setPreferredSize(tamBotao);
            botao.setFont(fonteBotao);
            botao.setBackground(corPrimaria);
            botao.setForeground(corTextoBotao);
            botao.setFocusPainted(false);
            
            // --- CORREÇÃO PARA MACOS ---
            // Force o botão a desenhar seu próprio fundo.
            botao.setOpaque(true); 
            // --- FIM DA CORREÇÃO ---
            
            botao.setBorderPainted(false);
            botao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            // Efeito Hover
            botao.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    botao.setBackground(corHover);
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    botao.setBackground(corPrimaria);
                }
            });
        };

        // Aplica o estilo
        aplicarEstilo.accept(btnFornecedores);
        aplicarEstilo.accept(btnTecnologia);
        aplicarEstilo.accept(btnCompradores);
        aplicarEstilo.accept(btnVendas);

        panelBotoes.add(btnFornecedores);
        panelBotoes.add(btnTecnologia);
        panelBotoes.add(btnCompradores);
        panelBotoes.add(btnVendas);

        
        // --- 5. PAINEL SUL (BOTÃO FECHAR) ---
        javax.swing.JPanel panelFechar = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        panelFechar.setBackground(corFundo);
        panelFechar.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 30, 30, 30));

        btnFinalizar.setFont(fonteBotaoFechar);
        btnFinalizar.setBackground(corFechar);
        btnFinalizar.setForeground(corTextoFechar);
        btnFinalizar.setPreferredSize(new java.awt.Dimension(100, 35));
        btnFinalizar.setFocusPainted(false);
        
        // --- CORREÇÃO PARA MACOS (BOTÃO FECHAR) ---
        btnFinalizar.setOpaque(true);
        // --- FIM DA CORREÇÃO ---
        
        btnFinalizar.setBorderPainted(false);
        btnFinalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnFinalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFinalizar.setBackground(corFecharHover);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFinalizar.setBackground(corFechar);
            }
        });
        
        panelFechar.add(btnFinalizar);

        
        // --- 6. MONTAGEM FINAL ---
        getContentPane().add(panelTitulo, java.awt.BorderLayout.NORTH);
        getContentPane().add(panelBotoes, java.awt.BorderLayout.CENTER);
        getContentPane().add(panelFechar, java.awt.BorderLayout.SOUTH);

        
        // --- 7. TAMANHO DA JANELA ---
        this.setSize(1024, 600);
        this.setMinimumSize(new java.awt.Dimension(600, 500));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnFinalizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnFornecedores = new javax.swing.JButton();
        btnCompradores = new javax.swing.JButton();
        btnTecnologia = new javax.swing.JButton();
        btnVendas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Exercício 3 - POO");

        btnFinalizar.setText("Fechar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        jLabel1.setText("Qual categoria deseja gerenciar?");

        btnFornecedores.setText("Fornecedores");
        btnFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFornecedoresActionPerformed(evt);
            }
        });

        btnCompradores.setText("Compradores");
        btnCompradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompradoresActionPerformed(evt);
            }
        });

        btnTecnologia.setText("Tecnologia");
        btnTecnologia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTecnologiaActionPerformed(evt);
            }
        });

        btnVendas.setText("Vendas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFinalizar)
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCompradores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFornecedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTecnologia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVendas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(btnFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(btnTecnologia)
                .addGap(18, 18, 18)
                .addComponent(btnCompradores)
                .addGap(18, 18, 18)
                .addComponent(btnVendas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btnFinalizar)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFornecedoresActionPerformed
        CadastroFornecedorDialog janelaFornecedor = new CadastroFornecedorDialog(this, true, this.listaFornecedores);
        
        this.setVisible(false);
        janelaFornecedor.setLocationRelativeTo(null);
        janelaFornecedor.setVisible(true);
        this.setVisible(true);
    }//GEN-LAST:event_btnFornecedoresActionPerformed

    private void btnCompradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompradoresActionPerformed
        CadastroCompradorDialog janelaComprador = new CadastroCompradorDialog(this, true, listaCompradores);
        
        this.setVisible(false);
        janelaComprador.setLocationRelativeTo(null);
        janelaComprador.setVisible(true);
        this.setVisible(true);
    }//GEN-LAST:event_btnCompradoresActionPerformed

    private void btnTecnologiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTecnologiaActionPerformed
        CadastroTecnologiaDialog janelaTecnologia = new CadastroTecnologiaDialog(this, true, this.listaFornecedores, this.listaTecnologias);
        
        this.setVisible(false);
        janelaTecnologia.setLocationRelativeTo(null);
        janelaTecnologia.setVisible(true);
        this.setVisible(true);
    }//GEN-LAST:event_btnTecnologiaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        // Define o Look and Feel para ser o do sistema operacional (mais profissional)
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            // Cria e centraliza a tela
            TelaInicial tela = new TelaInicial();
            tela.setVisible(true);
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCompradores;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnFornecedores;
    private javax.swing.JButton btnTecnologia;
    private javax.swing.JButton btnVendas;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}