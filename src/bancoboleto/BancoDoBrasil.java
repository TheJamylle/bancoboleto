package bancoboleto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jamylle
 */
public class BancoDoBrasil implements InterfaceBanco{
    public List<Boleto> boletos;

    @Override
    public String lerArquivo(String nomeArquivo) {
        boletos = new ArrayList();
        ProcessaBoleto process = new ProcessaBoleto();
        List<String> linhas = process.processar(nomeArquivo);
        for(String linha: linhas){
            Boleto bol = gerarBoleto(linha);
            boletos.add(bol);
        }
        
        return lerBoletos();
    }

    @Override
    public Boleto gerarBoleto(String linha) {
        Boleto b = new Boleto();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String[] dados = linha.split(";");
        for(int i =0; i< dados.length; i++){
            switch(i){
                case 0:
                    b.setId(Integer.parseInt(dados[i]));
                    break;
                case 1:
                    b.setCodBoleto(Integer.parseInt(dados[i]));
                    break;
                case 2:
                    b.setDataVencimento(LocalDate.parse(dados[i],dateTimeFormatter));
                    break;
                case 3:
                    b.setDataPagamento((LocalDate.parse(dados[i],dateTimeFormatter)).toString());
                    break;
                case 4:
                    b.setCpfCliente(dados[i]);
                    break;
                case 5:
                    b.setValor(Double.parseDouble(dados[i]));
                    break;
                case 6:
                    b.setMulta(Double.parseDouble(dados[i]));
                    break;
                case 7:
                    b.setJuros(Double.parseDouble(dados[i]));
                    break;         
            }
        }
        return b;
    }

    @Override
    public String lerBoletos() {
        String result = "";
        for(Boleto b: boletos){
            result += b.toString();
        }
        
        return result;
    }

}
