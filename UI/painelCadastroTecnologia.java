package UI;

import entidades.Fornecedor;
import entidades.Fornecedores;
import entidades.Tecnologia;
import entidades.Tecnologias;

import javax.swing.*;

public class painelCadastroTecnologia extends JPanel {
    private JTextField campoValorBase;
    private JTextField campoID;
    private JTextField campoModelo;
    private JTextField campoDescricao;
    private JTextField campoPeso;
    private JPanel Jpanel;
    private JComboBox comboFornecedor;
    private JButton botaoExit;
    private JButton botaoCadastrar;
    private JTextField campoTemperatur;
    private GerenciadorDeJanelas gerenciadorDeJanelas;
    private Fornecedores fornecedores;
    private Tecnologias tecnologias;
    private Fornecedor fornecedor;


    public JPanel getPanel() {
        return Jpanel;
    }

    public painelCadastroTecnologia (GerenciadorDeJanelas gerenciadorDeJanelas, Fornecedores fornecedores, Tecnologias tecnologias) {
        super();
        this.gerenciadorDeJanelas = gerenciadorDeJanelas;
        this.fornecedores = fornecedores;
        this.tecnologias = tecnologias;


        botaoExit.addActionListener(e -> gerenciadorDeJanelas.mudaJanela(4));
    }

    private void BtnCadastraTecnologiaActionPerformed(java.awt.event.ActionEvent evt) {
        String idStr = campoID.getText();
        long id = Long.parseLong(idStr);

        String modelo = campoModelo.getText();
        String desc = campoDescricao.getText();

        String valorStr = campoValorBase.getText();
        double valorBase = Double.parseDouble(valorStr);

        String pesoStr = campoPeso.getText();
        double peso = Double.parseDouble(pesoStr);

        String tempStr = campoTemperatur.getText();
        double temperatura = Double.parseDouble(tempStr);

        String fornecedor = comboFornecedor.getName();
        Fornecedor fornecedor1 = null;

        if (!idStr.isEmpty()) {
            try {
                fornecedor = fornecedores.buscarFornecedorPorCodigo(idStr);
            } catch (NullPointerException e) {
                System.err.println("Nome de fornecedor inválido: " + fornecedor);
            }
        }
        Tecnologia t = new Tecnologia(id, modelo, desc, valorBase, peso, temperatura, fornecedor);
        tecnologias.addTecnologia(t);
    }

}

