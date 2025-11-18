/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author arthurzimmer
 */
public class CadastroFornecedorDialog extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CadastroFornecedorDialog.class.getName());
    private Fornecedor fornecedor;
    Fornecedores fornecedores;
    private boolean cadastrouFornecedor;
    /**
     * Creates new form CadastroFornecedorDialog
     */
    public CadastroFornecedorDialog(java.awt.Frame parent, boolean modal, Fornecedores listaFornecedores) {
        super(parent, modal);        
        initComponents();        
        this.fornecedores = listaFornecedores;        
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
        
        // JLabel titulo
        javax.swing.JLabel lblTitulo = new javax.swing.JLabel("Cadastro de Fornecedor"); 
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

        // estilo
        javax.swing.JLabel[] labels = {jLabel2, jLabel1, jLabel3, jLabel4, jLabel5};
        for (javax.swing.JLabel label : labels) {
            label.setFont(fonteLabel);
            label.setForeground(corTextoLabel);
        }

        // estilo campo de texto
        javax.swing.border.Border bordaCampo = javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(corBordaCampo),
            javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8) // Padding interno
        );
        javax.swing.JTextField[] fields = {IDTextField, NomeTextField, FundacaoTextField, AreaTextField};
        for (javax.swing.JTextField field : fields) {
            field.setFont(fonteCampo);
            field.setBorder(bordaCampo);
        }
        
        // estilo campo quantidade
        QTDCadastTextField.setFont(fonteCampo);
        QTDCadastTextField.setBorder(bordaCampo);
        QTDCadastTextField.setBackground(new java.awt.Color(235, 235, 235)); // Fundo cinza
        QTDCadastTextField.setEditable(false);
        
        // linha (ID)
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = java.awt.GridBagConstraints.WEST; gbc.weightx = 0.1; gbc.fill = java.awt.GridBagConstraints.NONE;
        panelFormulario.add(jLabel2, gbc);
        gbc.gridx = 1; gbc.gridy = 0; gbc.anchor = java.awt.GridBagConstraints.WEST; gbc.weightx = 0.9; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelFormulario.add(IDTextField, gbc);

        // linha 1 (nome)
        gbc.gridx = 0; gbc.gridy = 1; gbc.anchor = java.awt.GridBagConstraints.WEST; gbc.weightx = 0.1; gbc.fill = java.awt.GridBagConstraints.NONE;
        panelFormulario.add(jLabel1, gbc);
        gbc.gridx = 1; gbc.gridy = 1; gbc.anchor = java.awt.GridBagConstraints.WEST; gbc.weightx = 0.9; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelFormulario.add(NomeTextField, gbc);

        // linha 2 (fundação)
        gbc.gridx = 0; gbc.gridy = 2; gbc.anchor = java.awt.GridBagConstraints.WEST; gbc.weightx = 0.1; gbc.fill = java.awt.GridBagConstraints.NONE;
        panelFormulario.add(jLabel3, gbc);
        gbc.gridx = 1; gbc.gridy = 2; gbc.anchor = java.awt.GridBagConstraints.WEST; gbc.weightx = 0.9; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelFormulario.add(FundacaoTextField, gbc);

        // linha 3 (area)
        gbc.gridx = 0; gbc.gridy = 3; gbc.anchor = java.awt.GridBagConstraints.WEST; gbc.weightx = 0.1; gbc.fill = java.awt.GridBagConstraints.NONE;
        panelFormulario.add(jLabel4, gbc);
        gbc.gridx = 1; gbc.gridy = 3; gbc.anchor = java.awt.GridBagConstraints.WEST; gbc.weightx = 0.9; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelFormulario.add(AreaTextField, gbc);

        // linha 4 (qtd cadastrada)
        gbc.gridx = 0; gbc.gridy = 4; gbc.anchor = java.awt.GridBagConstraints.WEST; gbc.weightx = 0.1; gbc.fill = java.awt.GridBagConstraints.NONE;
        panelFormulario.add(jLabel5, gbc);
        gbc.gridx = 1; gbc.gridy = 4; gbc.anchor = java.awt.GridBagConstraints.WEST; gbc.weightx = 0.9; gbc.fill = java.awt.GridBagConstraints.NONE; // Não preencher horizontalmente
        QTDCadastTextField.setPreferredSize(new java.awt.Dimension(80, 38)); // Tamanho fixo
        panelFormulario.add(QTDCadastTextField, gbc);

        // botões
        javax.swing.JPanel panelSul = new javax.swing.JPanel(new java.awt.BorderLayout());
        panelSul.setBackground(corFundo);
        panelSul.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 25, 20, 25));

        // painel esquerdo (liimpar, relatório)
        javax.swing.JPanel panelBotoesEsquerda = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 0));
        panelBotoesEsquerda.setBackground(corFundo);
        
        // painel direito (voltar, cadastrar)
        javax.swing.JPanel panelBotoesDireita = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 0));
        panelBotoesDireita.setBackground(corFundo);

        panelSul.add(panelBotoesEsquerda, java.awt.BorderLayout.WEST);
        panelSul.add(panelBotoesDireita, java.awt.BorderLayout.EAST);

        // funções de estilo
        java.awt.Dimension tamBotaoSecundario = new java.awt.Dimension(110, 35);
        java.awt.Dimension tamBotaoPrimario = new java.awt.Dimension(120, 35);

        // estilo primario (azul)
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
        estiloPrimario.accept(BtnCadastrarFornecedor); // Botão Cadastrar 
        estiloSecundario.accept(jButton1); // Botão Voltar 
        estiloSecundario.accept(btnLimpar); // Botão Limpar 
        estiloSecundario.accept(jToggleButton1); // Botão Relatório

        // adicionar botões aos painéis
        panelBotoesEsquerda.add(btnLimpar);
        panelBotoesEsquerda.add(jToggleButton1);
        
        panelBotoesDireita.add(jButton1); // Voltar
        panelBotoesDireita.add(BtnCadastrarFornecedor); // Cadastrar

        // monta tudo
        getContentPane().add(panelTitulo, java.awt.BorderLayout.NORTH);
        getContentPane().add(panelFormulario, java.awt.BorderLayout.CENTER);
        getContentPane().add(panelSul, java.awt.BorderLayout.SOUTH);

        // ajusta tamanho do painel
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
        IDTextField = new javax.swing.JTextField();
        NomeTextField = new javax.swing.JTextField();
        FundacaoTextField = new javax.swing.JTextField();
        AreaTextField = new javax.swing.JTextField();
        BtnCadastrarFornecedor = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        QTDCadastTextField = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        btnLimpar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Fornecedor");

        jLabel1.setText("Nome:");

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("ID:");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setText("Fundação");

        jLabel4.setText("Área:");

        IDTextField.setName("Digite o ID..."); // NOI18N
        IDTextField.setOpaque(true);

        FundacaoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FundacaoTextFieldActionPerformed(evt);
            }
        });

        BtnCadastrarFornecedor.setText("Cadastrar");
        BtnCadastrarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCadastrarFornecedorActionPerformed(evt);
            }
        });

        jLabel5.setText("Qtd cadastrada:");

        QTDCadastTextField.setEnabled(false);
        QTDCadastTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QTDCadastTextFieldActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Relatório");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AreaTextField)
                            .addComponent(FundacaoTextField)
                            .addComponent(NomeTextField)
                            .addComponent(IDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(QTDCadastTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jButton1)
                        .addGap(34, 34, 34)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnCadastrarFornecedor))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(IDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(NomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(FundacaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(AreaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(QTDCadastTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(btnLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(BtnCadastrarFornecedor)
                    .addComponent(jToggleButton1))
                .addGap(27, 27, 27))
        );

        IDTextField.getAccessibleContext().setAccessibleName("");
        IDTextField.getAccessibleContext().setAccessibleDescription("Digite o ID...");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void FundacaoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FundacaoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FundacaoTextFieldActionPerformed

    private void BtnCadastrarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCadastrarFornecedorActionPerformed
        String codString, nome, fundacao, area;
        long cod;
        try{
            codString = IDTextField.getText();
            if (!codString.matches("^\\d*$"))
                throw new IllegalArgumentException("Formato inválido de código!");
            if(codString.equals(""))
                throw new IllegalArgumentException("O ID é obrigatório!");

            cod = Long.parseLong(codString);

            nome = NomeTextField.getText();
            if(nome.equals(""))
                throw new IllegalArgumentException("Informe algum nome!");
            
            fundacao = FundacaoTextField.getText();
                if(fundacao.equals(""))
                    throw new IllegalArgumentException("Informe alguma data de fundação!");
                
            area = AreaTextField.getText();
                if(area.equals(""))
                    throw new IllegalArgumentException("Informe alguma área!");
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            Date fundacaoAux = null;
            try {
                fundacaoAux = sdf.parse(fundacao);
            } catch (ParseException e) {
                System.err.println("Formato de data inválido: " + fundacao);
            }    
            
            Area areaEnum = null;
            try{
                areaEnum = Area.valueOf(area.trim().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.err.println("Área inválida: " + area + " — valores válidos: TI, ANDROIDES, EMERGENTE, ALIMENTOS");
            }
            
            fornecedor = new Fornecedor(cod, nome, fundacaoAux, areaEnum);
        
            if (fornecedores.addFornecedor(fornecedor)){
                cadastrouFornecedor = true;
                atualizarContador();
            } else {
                cadastrouFornecedor = false;
            } 
        } catch (IllegalArgumentException e){
            System.err.println(e);
        }
    }//GEN-LAST:event_BtnCadastrarFornecedorActionPerformed

    private void QTDCadastTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QTDCadastTextFieldActionPerformed
        String quantidade = String.valueOf(fornecedores.size());
        QTDCadastTextField.setText(quantidade);
    }//GEN-LAST:event_QTDCadastTextFieldActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        //easteregg
        int size = fornecedores.size();
        int start = size + 1;
        int end = start + 100;
        
        for (int i = start; i < end; i++){
            long cod = i;
            String nome = "Usuario" + i;
            String fundacao = i + i + "/" + i + i + "/" + i + i + i + i;
            String area = "ANDROIDES";

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            Date fundacaoAux = null;
            try {
                fundacaoAux = sdf.parse(fundacao);
            } catch (ParseException e) {
                System.err.println("Formato de data inválido em PARTICIPANTESENTRADA.CSV: " + fundacao);
            }

            Area areaEnum = null;
            try {
                areaEnum = Area.valueOf(area.trim().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.err.println("Área inválida no CSV: " + area + " — valores válidos: TI, ANDROIDES, EMERGENTE, ALIMENTOS");
            }

            fornecedor = new Fornecedor(cod, nome, fundacaoAux, areaEnum);
            
            if (fornecedores.addFornecedor(fornecedor)){
                cadastrouFornecedor = true;
                atualizarContador();
            } else {
                cadastrouFornecedor = false;
            } 
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        TelaInicial telaAux = new TelaInicial();
        
        RelatorioFornecedorDialog modalRelatorio = new RelatorioFornecedorDialog(telaAux, true, fornecedores);
        modalRelatorio.setLocationRelativeTo(null);
        modalRelatorio.setVisible(true);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        IDTextField.setText("");
        NomeTextField.setText("");
        FundacaoTextField.setText("");
        AreaTextField.setText("");
        QTDCadastTextField.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed
    
    public void atualizarContador() {
        int total = this.fornecedores.size();
        QTDCadastTextField.setText(String.valueOf(total));
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    /* ... (código do look and feel) ... */

    /* Create and display the dialog */
    java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
                        
            javax.swing.JFrame framePaiParaTeste = new javax.swing.JFrame();
            java.util.ArrayList<Fornecedor> listaTeste = new java.util.ArrayList<>();
            Fornecedores fornecedoresParaTeste = new Fornecedores(listaTeste);
            CadastroFornecedorDialog dialog = new CadastroFornecedorDialog(framePaiParaTeste, true, fornecedoresParaTeste);
            
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
    private javax.swing.JTextField AreaTextField;
    private javax.swing.JButton BtnCadastrarFornecedor;
    private javax.swing.JTextField FundacaoTextField;
    private javax.swing.JTextField IDTextField;
    private javax.swing.JTextField NomeTextField;
    private javax.swing.JTextField QTDCadastTextField;
    private javax.swing.JToggleButton btnLimpar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
