package bancoboleto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jamylle
 */
public class BancoBradesco implements InterfaceBanco {
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
        
        return null;
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
                    b.setAgencia(dados[i]);
                    break;
                case 3:
                    b.setContaBancaria(dados[i]);
                    break;
                case 4:
                    b.setDataVencimento(LocalDate.parse(dados[i],dateTimeFormatter));
                    break;
                case 5:
                    b.setDataPagamento(dados[i]);
                    break;
                case 6:
                    b.setCpfCliente(dados[i]);
                    break;
                case 7:
                    b.setValor(Double.parseDouble(dados[i]));
                    break;
                case 8:
                    b.setMulta(Double.parseDouble(dados[i]));
                    break;
                case 9:
                    b.setJuros(Double.parseDouble(dados[i]));
                    break;      
            }
        }
        return b;
    }

    @Override
    public String lerBoletos() {
      for(Boleto b: boletos)
          b.toString();
      
      return null;
    }
    
}
