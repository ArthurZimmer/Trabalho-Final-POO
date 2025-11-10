package UI;

import javax.swing.*;

public class GerenciadorDeJanelas extends JFrame {

    private painelPrincipal primaria;
    private painelCadastro cadastro;

    public GerenciadorDeJanelas() {
        super();
        setSize(800, 800);
        setTitle("Minha Janela");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        primaria = new painelPrincipal(this);
        cadastro = new painelCadastro();

        this.setContentPane(primaria.getPainel());
        setVisible(true);
    }

    public void mudaJanela(int painel) {
        switch(painel) {
            case 1:
                this.setContentPane(cadastro);
                this.pack();
                this.setSize(800,800);
                break;
            case 0:

        }
    }}
