package UI;

import javax.swing.*;

public class GerenciadorDeJanelas extends JFrame {

    private painelPrincipal primaria;
    private painelCadastro cadastro;
    private painelRelatorio relatorio;

    public GerenciadorDeJanelas() {
        super();
        setSize(800, 800);
        setTitle("ACMETECH");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        primaria = new painelPrincipal(this);
        cadastro = new painelCadastro(this);
        relatorio = new painelRelatorio();

        this.setContentPane(primaria.getPainel());
        setVisible(true);
    }

    public void mudaJanela(int painel) {
        switch(painel) {
            case 1:
                this.setContentPane(cadastro.getPainel());
                this.pack();
                this.setSize(800,1200);
                break;
            case 2:
                this.setContentPane(relatorio.getPainel());
                this.pack();
                this.setSize(800, 1200);
                break;
            case 3:
                this.setContentPane(primaria.getPainel());
                this.pack();
                this.setSize(800, 1200);
                break;
        }
    }}
