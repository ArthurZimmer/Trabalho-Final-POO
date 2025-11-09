package UI;

import javax.swing.*;

public class GerenciadorDeJanelas extends JFrame {

    private janelaPrincipal janelaPrimaria;

    public GerenciadorDeJanelas() {
        super();
        setVisible(true);
        setSize(800, 400);
        setTitle("Minha Janela");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        janelaPrimaria = new janelaPrincipal();
        add(janelaPrimaria.getPainel());
    }
}
