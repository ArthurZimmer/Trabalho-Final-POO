package UI;

import aplicacao.ACMETech;
import entidades.Fornecedor;
import entidades.Fornecedores;
import entidades.Tecnologias;

import javax.swing.*;

public class GerenciadorDeJanelas extends JFrame {

    private painelPrincipal primaria;
    private painelCadastro cadastro;
    private painelRelatorio relatorio;
    private painelCadastroVenda venda;
    private painelCadastroTecnologia tecnologia;
    private Fornecedores fornecedores;
    private Tecnologias tecnologias;

    public GerenciadorDeJanelas() {
        super();
        setSize(1000, 1000);
        setTitle("ACMETECH");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        primaria = new painelPrincipal(this);
        cadastro = new painelCadastro(this);
        venda = new painelCadastroVenda(this);
        tecnologia = new painelCadastroTecnologia(this, fornecedores, tecnologias);
        relatorio = new painelRelatorio();

        this.setContentPane(primaria.getPainel());
        setVisible(true);
    }

    public void mudaJanela(int painel) {
        switch(painel) {
            case 1:
                this.setContentPane(cadastro.getPainel());
                this.pack();
                this.setSize(1000,1000);
                break;
            case 2:
                this.setContentPane(relatorio.getPainel());
                this.pack();
                this.setSize(1000, 1000);
                break;
            case 3:
                this.setContentPane(primaria.getPainel());
                this.pack();
                this.setSize(1000, 1000);
                break;
            case 4:
                this.setContentPane(venda.getPanel());
                this.pack();
                this.setSize(1000,1000);
                break;
            case 5:
                this.setContentPane(tecnologia.getPanel());
                this.pack();
                this.setSize(1000,1000);
                break;
        }
    }
}
