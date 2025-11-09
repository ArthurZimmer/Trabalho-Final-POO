package UI;

import javax.swing.*;

public class janelaCadastro extends JDialog {
    private JPanel panelCadastro;
    private JLabel titulo;
    private JButton cadastrarVenda;
    private JButton cadastrarComprador;
    private JButton cadastrarTecnologia;
    private JButton cadastrarFornecedor;

    public janelaCadastro(JFrame parent) {
        super(parent, "Cadastro", true); // modal
        setContentPane(panelCadastro);
        setSize(800, 400);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
