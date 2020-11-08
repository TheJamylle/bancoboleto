package bancoboleto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javafx.scene.control.TextField;

/**
 *
 * @author jamylle
 */
class Boleto {
    private int id;
    private int codBoleto;
    private LocalDate dataVencimento;
    private String dataPagamento;
    private String cpfCliente;
    private double valor;
    private double multa;
    private double juros;
    private String agencia;
    private String contaBancaria;    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getCodBoleto() {
        return codBoleto;
    }

    public void setCodBoleto(int codBoleto) {
        this.codBoleto = codBoleto;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente.substring(0, 3) + "." + cpfCliente.substring(3, 6) + "." +
            cpfCliente.substring(6, 9) + "-" + cpfCliente.substring(9, 11);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(String contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    @Override
    public String toString() {
        return "Boleto: \n" + "Id: " + id + "\nCódigo do Boleto: " +
                codBoleto + "\nVencimento: " + dataVencimento + "\nPagamento: " +
                dataPagamento + "\nCPF: " + cpfCliente + "\nValor: " + valor + 
                "\nMulta: " + multa + "\nJuros: " + juros + "\nAgência: " + agencia + 
                "\nConta Bancária: " + contaBancaria;
    }
    
    
}
