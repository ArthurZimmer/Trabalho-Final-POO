package entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Queue;

import static entidades.Area.ANDROIDES;

public class Venda {
    private long num;
    private Date data;
    private double valorFinal;
    private Comprador comprador;
    private Tecnologia tecnologia;


    public Venda(int num, String dataStr, Comprador comprador, Tecnologia tecnologia) {
        this.num = num;
        this.comprador = comprador;
        this.tecnologia = tecnologia;


        try {
            this.data = new SimpleDateFormat("dd/MM/yyyy").parse(dataStr);
        } catch (ParseException e) {
            System.err.println("Data inválida na venda: " + dataStr);
            this.data = null;
        }

    }


public double calculaValorFinal(Queue<Venda> FilaDevendas) {
    if (tecnologia == null || tecnologia.getFornecedor() == null) {
        System.err.println("Erro: tecnologia ou fornecedor não definido para a venda" + num);
        return 0.0;
    }
    double valorBase = tecnologia.getValorBase();
    double valorAcrescido = valorBase;
    Area areaFornecedor = tecnologia.getFornecedor().getArea();

    switch (areaFornecedor) {
        case TI:
            valorAcrescido = valorBase * 1.2;
            break;
        case ANDROIDES:
            valorAcrescido = valorBase * 1.15;
            break;

        case EMERGENTE:
            valorAcrescido = valorBase * 1.25;
            break;

        case ALIMENTOS:
            valorAcrescido = valorBase * 1.10;
            break;
        default:
            System.err.println("Area desconhecida para vendas" + num);
    }
    int contadorVendas = 0;
    for (Venda v : FilaDevendas) {
        if (v.getComprador().equals(this.comprador) && v.getNum() != this.num) {
            contadorVendas++;
        }
    }

    double descontoPercentual = Math.min(contadorVendas, 10) * 0.01;
    double valorFinal = valorAcrescido * (1 - descontoPercentual);
    this.valorFinal = valorFinal;
    return valorFinal;
}

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public Tecnologia getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(Tecnologia tecnologia) {
        this.tecnologia = tecnologia;
    }
}