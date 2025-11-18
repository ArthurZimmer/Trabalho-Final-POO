/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.mavenproject1;

import static com.mycompany.mavenproject1.Area.ANDROIDES;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author arthurzimmer
 */
public class CadastroTecnologiaDialog extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CadastroTecnologiaDialog.class.getName());
    private Fornecedores fornecedores;
    private Tecnologias tecnologias;
    private Fornecedor fornecedor;
    /**
     * Creates new form CadastroTecnologiaDialog
     */
    public CadastroTecnologiaDialog(java.awt.Frame parent, boolean modal, Fornecedores listaFornecedores, Tecnologias listaTecnologias) {
        super(parent, modal);        
        initComponents();        
        this.fornecedores = listaFornecedores;
        this.tecnologias = listaTecnologias;        
        this.iniciaComboboxFornecedores();
        this.incrementaTecCadastradas();

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

        // dialog
        getContentPane().removeAll();
        getContentPane().setLayout(new java.awt.BorderLayout());
        getContentPane().setBackground(corFundo);
        
        // titulo
        javax.swing.JPanel panelTitulo = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        panelTitulo.setBackground(corFundo);
        panelTitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 25, 15, 25));
        
        javax.swing.JLabel lblTitulo = new javax.swing.JLabel("Cadastrar Tecnologia"); 
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

        // labels
        javax.swing.JLabel[] labels = {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8};
        for (javax.swing.JLabel label : labels) {
            label.setFont(fonteLabel);
            label.setForeground(corTextoLabel);
        }

        // text fields
        javax.swing.border.Border bordaCampo = javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(corBordaCampo),
            javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8) // Padding interno
        );
        javax.swing.JTextField[] fields = {TFId, TFModelo, TFDesc, TFPBase, TFPeso, TFTemp};
        for (javax.swing.JTextField field : fields) {
            field.setFont(fonteCampo);
            field.setBorder(bordaCampo);
        }
        
        // quantidade cadastrada
        TFTecCadastradas.setFont(fonteCampo);
        TFTecCadastradas.setBorder(bordaCampo);
        TFTecCadastradas.setBackground(new java.awt.Color(235, 235, 235));
        TFTecCadastradas.setEditable(false);
        
        // combobox
        CBForn.setFont(fonteCampo);
        CBForn.setBackground(java.awt.Color.WHITE);
        CBForn.setBorder(javax.swing.BorderFactory.createLineBorder(corBordaCampo)); // Borda simples
        ((javax.swing.JLabel)CBForn.getRenderer()).setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Padding interno
        
        // coluna 0 (labels)
        gbc.gridx = 0; gbc.anchor = java.awt.GridBagConstraints.WEST; gbc.weightx = 0.1; gbc.fill = java.awt.GridBagConstraints.NONE;
        gbc.gridy = 0; panelFormulario.add(jLabel1, gbc);
        gbc.gridy = 1; panelFormulario.add(jLabel2, gbc);
        gbc.gridy = 2; panelFormulario.add(jLabel3, gbc);
        gbc.gridy = 3; panelFormulario.add(jLabel4, gbc);
        gbc.gridy = 4; panelFormulario.add(jLabel5, gbc);
        gbc.gridy = 5; panelFormulario.add(jLabel6, gbc);
        gbc.gridy = 6; panelFormulario.add(jLabel7, gbc);
        gbc.gridy = 7; panelFormulario.add(jLabel8, gbc);

        // coluna 1 (campos)
        gbc.gridx = 1; gbc.anchor = java.awt.GridBagConstraints.WEST; gbc.weightx = 0.9; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbc.gridy = 0; panelFormulario.add(TFId, gbc);
        gbc.gridy = 1; panelFormulario.add(TFModelo, gbc);
        gbc.gridy = 2; panelFormulario.add(TFDesc, gbc);
        gbc.gridy = 3; panelFormulario.add(TFPBase, gbc);
        gbc.gridy = 4; panelFormulario.add(TFPeso, gbc);
        gbc.gridy = 5; panelFormulario.add(TFTemp, gbc);
        gbc.gridy = 6; panelFormulario.add(CBForn, gbc);
        
        // campo quantidade (tratamento especial)
        gbc.gridy = 7; gbc.fill = java.awt.GridBagConstraints.NONE; // Não esticar
        TFTecCadastradas.setPreferredSize(new java.awt.Dimension(80, 38)); // Tamanho fixo
        panelFormulario.add(TFTecCadastradas, gbc);


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

        // funções de estilo
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
        estiloPrimario.accept(BtnCadastraTecnologia); // Botão Cadastrar 
        estiloSecundario.accept(jButton1); // Botão Voltar
        estiloSecundario.accept(btnLimpar); // Botão Limpar
        estiloSecundario.accept(btnRelatorio); // Botão Relatório

        // adiciona botões aos painéis
        panelBotoesEsquerda.add(btnLimpar);
        panelBotoesEsquerda.add(btnRelatorio);
        
        panelBotoesDireita.add(jButton1); // Voltar
        panelBotoesDireita.add(BtnCadastraTecnologia); // Cadastrar

        // monta tudo
        getContentPane().add(panelTitulo, java.awt.BorderLayout.NORTH);
        getContentPane().add(panelFormulario, java.awt.BorderLayout.CENTER);
        getContentPane().add(panelSul, java.awt.BorderLayout.SOUTH);

        // ajustes do painel
        this.pack(); // Ajusta a janela ao tamanho do conteúdo
        this.setMinimumSize(new java.awt.Dimension(700, 750)); // Define um tamanho mínimo
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TFId = new javax.swing.JTextField();
        TFModelo = new javax.swing.JTextField();
        TFDesc = new javax.swing.JTextField();
        TFPBase = new javax.swing.JTextField();
        TFPeso = new javax.swing.JTextField();
        TFTemp = new javax.swing.JTextField();
        BtnCadastraTecnologia = new javax.swing.JButton();
        CBForn = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        TFTecCadastradas = new javax.swing.JTextField();
        btnLimpar = new javax.swing.JToggleButton();
        btnRelatorio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Tecnologia");

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

        jLabel2.setText("Modelo:");

        jLabel3.setText("Descrição:");

        jLabel4.setText("Preço base:");

        jLabel5.setText("Peso:");

        jLabel6.setText("Temperatura:");

        jLabel7.setText("Fornecedor:");

        BtnCadastraTecnologia.setText("Cadastrar");
        BtnCadastraTecnologia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCadastraTecnologiaActionPerformed(evt);
            }
        });

        CBForn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("Tec. Cadastradas:");

        TFTecCadastradas.setEnabled(false);
        TFTecCadastradas.setFocusable(false);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TFId)
                                    .addComponent(TFModelo)
                                    .addComponent(TFDesc)
                                    .addComponent(TFPBase)
                                    .addComponent(TFPeso)
                                    .addComponent(TFTemp)
                                    .addComponent(CBForn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TFTecCadastradas, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(BtnCadastraTecnologia)))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TFId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TFModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TFDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TFPBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TFPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TFTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(CBForn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(TFTecCadastradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnLimpar)
                        .addGap(6, 6, 6)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(BtnCadastraTecnologia)
                    .addComponent(btnRelatorio))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BtnCadastraTecnologiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCadastraTecnologiaActionPerformed
        try{
            String idStr = TFId.getText();
            if (!idStr.matches("^\\d*$"))
                    throw new IllegalArgumentException("Formato inválido de código!");
            if(idStr.equals(""))
                    throw new IllegalArgumentException("O ID é obrigatório!");
            long id = Long.parseLong(idStr);

            String modelo = TFModelo.getText();
            if(modelo.equals(""))
                    throw new IllegalArgumentException("Informe algum modelo!");

            String desc = TFDesc.getText();
            if(desc.equals(""))
                    throw new IllegalArgumentException("Informe alguma descrição!");

            String valorStr = TFPBase.getText();
            if(!valorStr.matches("^\\d*$"))
                    throw new IllegalArgumentException("Informe um valor válido!");
            if(valorStr.equals(""))
                    throw new IllegalArgumentException("O Valor é obrigatório!");
            double valorBase = Double.parseDouble(valorStr);

            String pesoStr = TFPeso.getText();
            if(!pesoStr.matches("^\\d*$"))
                    throw new IllegalArgumentException("Informe um peso válido!");
            if(pesoStr.equals(""))
                    throw new IllegalArgumentException("O peso é obrigatório!");
            double peso = Double.parseDouble(pesoStr);

            String tempStr = TFTemp.getText();
            if(!tempStr.matches("^\\d*$"))
                    throw new IllegalArgumentException("Informe uma temperatura válida!");
            if(tempStr.equals(""))
                    throw new IllegalArgumentException("A temperatura é obrigatória!");
            double temperatura = Double.parseDouble(tempStr);

            Object fornecedor = CBForn.getSelectedItem();
            String nomeFornecedor = fornecedor.toString();            
                        
            if(nomeFornecedor == null || nomeFornecedor.equals("Selecione um Fornecedor"))
                    throw new IllegalArgumentException("Selecione um fornecedor!");
           
            Fornecedor fornTeste = fornecedores.buscarFornecedorPorNome(nomeFornecedor);

            Tecnologia t = new Tecnologia(id, modelo, desc, valorBase, peso, temperatura, fornTeste);
            System.out.println(t.toString());
            tecnologias.addTecnologia(t);
            incrementaTecCadastradas();
        } catch (IllegalArgumentException e) {
            System.err.println(e);
        } catch (NullPointerException e) {
            System.err.println("Verifique os valores nulos: " + e);
        }
    }//GEN-LAST:event_BtnCadastraTecnologiaActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        //easter egg
        if (fornecedores.size() == 0){
            Area area = ANDROIDES;
            String fundacao = "10/10/1010";
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fundacaoAux = null;
            try {
                fundacaoAux = sdf.parse(fundacao);
            } catch (ParseException e) {
                System.err.println("Formato de data inválido em PARTICIPANTESENTRADA.CSV: " + fundacao);
            }
            
            fornecedor = new Fornecedor(1, "Fornecedor teste", fundacaoAux, area);
            fornecedores.addFornecedor(fornecedor);
        }
        
        for (int i = 0; i < 100; i++) {
            long id = i;

            String modelo = "modelo teste" + i;
            String desc = "desc teste" + i;
            double valorBase = i;
            double peso = i;
            double temperatura = i;
            String fornecedor = "Fornecedor teste";
            Fornecedor forn = fornecedores.getFirst();
                
            Tecnologia t = new Tecnologia(id, modelo, desc, valorBase, peso, temperatura, forn);
            tecnologias.addTecnologia(t);
            incrementaTecCadastradas();
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        TFId.setText("");
        TFModelo.setText("");
        TFDesc.setText("");
        TFPBase.setText("");
        TFPeso.setText("");
        TFTemp.setText("");
        CBForn.setSelectedIndex(0);
        TFTecCadastradas.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        TelaInicial telaAux = new TelaInicial();
        
        RelatorioTecnologiaDialog modalRelatorio = new RelatorioTecnologiaDialog(telaAux, true, tecnologias);
        modalRelatorio.setLocationRelativeTo(null);
        modalRelatorio.setVisible(true);
    }//GEN-LAST:event_btnRelatorioActionPerformed

    public void incrementaTecCadastradas() {
        int total = this.tecnologias.size();
        TFTecCadastradas.setText(String.valueOf(total));
    }
    
    public void iniciaComboboxFornecedores() {
        
        CBForn.removeAllItems();
        CBForn.addItem("Selecione um Fornecedor"); 

        List<Fornecedor> fornecedoresList = fornecedores.getFornecedores(); 

        for(int i = 0; i < fornecedoresList.size(); i++){
            Fornecedor f = fornecedoresList.get(i);
            CBForn.addItem(f.getNome());
        }
        CBForn.setSelectedIndex(0);
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
    private javax.swing.JButton BtnCadastraTecnologia;
    private javax.swing.JComboBox<String> CBForn;
    private javax.swing.JTextField TFDesc;
    private javax.swing.JTextField TFId;
    private javax.swing.JTextField TFModelo;
    private javax.swing.JTextField TFPBase;
    private javax.swing.JTextField TFPeso;
    private javax.swing.JTextField TFTecCadastradas;
    private javax.swing.JTextField TFTemp;
    private javax.swing.JToggleButton btnLimpar;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
