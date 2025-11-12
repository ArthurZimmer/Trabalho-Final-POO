package UI;

import entidades.Area;
import entidades.Fornecedor;
import entidades.Fornecedores;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class painelCadastrarFornecedor extends JPanel{
    private JTextField campoArea;
    private JTextField campoFundacao;
    private JTextField campoNome;
    private JTextField campoCodigo;
    private JPanel Jpanel;
    private GerenciadorDeJanelas gerenciadorDeJanelas;
    private Area areaEnum;
    private Fornecedor fornecedor;
    private Fornecedores fornecedores;

    public JPanel getPanel() {
        return Jpanel;
    }

    public painelCadastrarFornecedor(GerenciadorDeJanelas gerenciadorDeJanelas, Fornecedores fornecedores) {
        super();
        this.gerenciadorDeJanelas = gerenciadorDeJanelas;
        this.fornecedores = fornecedores;


    }

    private void BtnCadastrarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCadastrarFornecedorActionPerformed
        String codString = campoCodigo.getText();
        long cod = Long.parseLong(codString);

        String nome = campoNome.getText();
        String fundacao = campoFundacao.getText();
        String area = campoArea.getText();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Date fundacaoAux = null;
        try {
            fundacaoAux = sdf.parse(fundacao);
        } catch (ParseException e) {
            System.err.println("Formato de data inválido em PARTICIPANTESENTRADA.CSV: " + fundacao);
        }

        areaEnum = null;
        try {
            areaEnum = Area.valueOf(area.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.err.println("Área inválida no CSV: " + area + " — valores válidos: TI, ANDROIDES, EMERGENTE, ALIMENTOS");
        }

        fornecedor = new Fornecedor(cod, nome, fundacaoAux, areaEnum);


    }
}
