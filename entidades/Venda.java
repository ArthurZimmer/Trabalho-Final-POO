package entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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


        this.valorFinal = calculaValorFinal();
    }


    public double calculaValorFinal() {
        if (tecnologia != null) {
            return tecnologia.getValorBase();
        }
        return 0.0;
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