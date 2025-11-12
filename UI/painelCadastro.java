package UI;

import entidades.Area;
import aplicacao.ACMETech;
import entidades.Fornecedor;

import java.util.Date;
import javax.swing.*;
import java.text.SimpleDateFormat;

public class painelCadastro extends JPanel {
    private final ACMETech sistema;
    private JPanel panelCadastro;
    private JLabel texto;
    private JButton cadastrarVenda;
    private JButton cadastrarComprador;
    private JButton cadastrarTecnologia;
    private JButton cadastrarFornecedor;
    private JButton botaoExit;

    private JTextField campoCodigo;
    private JTextField campoNome;
    private JTextField campoFundacao;
    private JComboBox<String> comboArea;
    private JButton ConfirmaBotaoCadastrar;
    GerenciadorDeJanelas gerenciadorDeJanelas;


    public JPanel getPainel() {
        return panelCadastro;
    }

    public painelCadastro(GerenciadorDeJanelas gerenciadorDeJanelas) {
        super();
        this.gerenciadorDeJanelas = gerenciadorDeJanelas;
        this.sistema = sistema;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        campoCodigo = new JTextField(10);
        campoNome = new JTextField(20);
        campoFundacao = new JTextField(10);
        comboArea = new JComboBox<>(new String[]{"TI", "ANDROIDES", "EMERGENTE", "ALIMENTOS"});
        ConfirmaBotaoCadastrar = new JButton("Cadastrar Fornecedor");

        add(new JLabel("Codigo"));
        add(campoCodigo);
        add(new JLabel("Nome"));
        add(campoNome);
        add(new JLabel("Fundacao"));
        add(campoFundacao);
        add(new JLabel("Area"));
        add(comboArea);

        add(ConfirmaBotaoCadastrar);

        ConfirmaBotaoCadastrar.addActionListener(e -> cadastrarFornecedor(sistema));

        botaoExit.addActionListener(e -> gerenciadorDeJanelas.mudaJanela(3));

    }

    private void cadastrarFornecedor(ACMETech sistema) {
        try {
            long cod = Long.parseLong(campoCodigo.getText());
            String nome = campoNome.getText();
            String dataStr = campoFundacao.getText();
            String areaStr = comboArea.getSelectedItem().toString();

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fundacao = sdf.parse(dataStr);
            Area area = Area.valueOf(areaStr.toUpperCase());

            Fornecedor f = new Fornecedor(cod, nome, fundacao, area);
            boolean ok = sistema.getFornecedores().addFornecedor(f);

            if (ok)
                JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso!");
            else
                JOptionPane.showMessageDialog(null, "Código já existente!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar fornecedor: " + e.getMessage());
        }
    }
}

