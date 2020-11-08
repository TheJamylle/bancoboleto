package bancoboleto;

import java.util.List;

/**
 *
 * @author jamylle
 */
public interface InterfaceBanco {
    public String lerArquivo(String nomeArquivo);
    public Boleto gerarBoleto(String linha);
    public String lerBoletos();
}
