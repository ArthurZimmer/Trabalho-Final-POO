package aplicacao;

import java.util.Date;
import entidades.Area;
import entidades.Comprador;
import entidades.Fornecedor;
import entidades.Tecnologia;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


import static java.nio.file.Files.newBufferedReader;

public class ACMETech {

    private List <Fornecedor> fornecedores = new ArrayList<>();
    private List <Comprador> compradores = new ArrayList<>();
    private List <Tecnologia> tecnologias = new ArrayList<>();


	public void inicializar() {
        Path pathParticipantes = Paths.get("PARTICIPANTESENTRADA.CSV");
        try (BufferedReader br = newBufferedReader(pathParticipantes, Charset.forName("UTF-8"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("cod")) continue;
                Scanner sc = new Scanner(linha).useDelimiter(";");

                long cod = sc.nextLong();
                String nome = sc.next();
                int tipo = sc.nextInt();

                if (tipo == 1) {
                    String fundacaoStr = sc.next();
                    String areaStr = sc.next();

                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date fundacao = null;
                    try {
                        fundacao = sdf.parse(fundacaoStr);
                    } catch (ParseException e) {
                        System.err.println("Formato de data inválido em PARTICIPANTESENTRADA.CSV: " + fundacaoStr);
                        continue;
                    }
                    Area areaEnum;
                    try {
                        areaEnum = Area.valueOf(areaStr.trim().toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.err.println("Área inválida no CSV: " + areaStr + " — valores válidos: TI, ANDROIDES, EMERGENTE, ALIMENTOS");
                        continue;
                    }

                    fornecedores.add(new Fornecedor(cod, nome, fundacao, areaEnum));
                } else if (tipo == 2) {
                    String pais = sc.next();
                    String email = sc.next();
                    compradores.add(new Comprador(cod, nome, pais, email));
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler PARTICIPANTESENTRADA.CSV: " + e.getMessage());
        }
        Path pathTecnologias = Paths.get("TECNOLOGIASENTRADA.CSV");
        try (BufferedReader br = newBufferedReader(pathTecnologias, Charset.forName("UTF-8"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("id")) continue;
                Scanner sc = new Scanner(linha).useDelimiter(";");

                int id = sc.nextInt();
                String modelo = sc.next();
                String descricao = sc.next();
                double valorBase = sc.nextDouble();
                double peso = sc.nextDouble();
                double temperatura = sc.nextDouble();
                int codFornecedor = sc.nextInt();

                Fornecedor fornecedor = buscarFornecedorPorCodigo(codFornecedor);
                Tecnologia t = new Tecnologia(id, modelo, descricao, valorBase, peso, temperatura, fornecedor);
                tecnologias.add(t);
            }
        }catch (IOException e){
            System.err.println("Erro ao ler TECNOLOGIAS.CSV: " + e.getMessage());
        }
    }
	public void executar() {

	}
    private Fornecedor buscarFornecedorPorCodigo(int codFornecedor){
        for (Fornecedor fornecedor : fornecedores) {
            if (fornecedor.getCod() == codFornecedor) {
                return fornecedor;
            }
        }
        return null;
    }
}
