package entidades;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Compradores {
    private List<Comprador> compradores = new ArrayList<>();

    public Compradores(List compradores) {
        this.compradores = compradores;
    }

    public List<Comprador> getCompradores() {
        return compradores;
    }

    public void setCompradores(List<Comprador> compradores) {
        this.compradores = compradores;
    }

    public boolean addComprador(Comprador p){
        for (int i = 0; i < compradores.size(); i++) {
            Comprador comp = compradores.get(i);

            if (comp.getCod() == p.getCod())
                throw new IllegalStateException("Código de usuário repetido, tente novamente.");


            if (p.getCod() < comp.getCod()) {
                compradores.add(i, p);
                return true;
            }
        }

        compradores.add(p);
        return true;
    }

    @Override
    public String toString() {
        return "Compradores{" + "compradores=" + compradores + '}';
    }

    public int size() {
        return compradores.size();
    }

    public void alteraDadosComprador(Comprador p, long codigoSolicitadoComprador){
        try {
            Iterator<Comprador> it = compradores.iterator();

            while (it.hasNext()) {
                Comprador comp = it.next();

                if (comp.getCod() == codigoSolicitadoComprador) {
                    System.out.println(codigoSolicitadoComprador);

                    Scanner sc = new Scanner(System.in);
                    System.out.println("Digite o novo nome do comprador: ");
                    comp.setNome(sc.next());

                    System.out.println("Digite o novo pais do comprador: ");
                    comp.setPais(sc.next());

                    System.out.println("Digite o novo email do comprador: ");
                    comp.setEmail(sc.next());

                    System.out.println("Dados alterados com sucesso! ");
                    return;

                }
            }
        }catch (Exception e){
            System.out.println("Erro ao alterar dados do comprador: "+e.getMessage());
        }

    }

}
