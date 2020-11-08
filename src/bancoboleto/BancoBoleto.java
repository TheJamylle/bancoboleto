package bancoboleto;

import java.util.List;

/**
 *
 * @author jamylle
 */
public class BancoBoleto {

     public static void main(String[] args) {
        BancoBradesco bra = new BancoBradesco();
        BancoDoBrasil bb = new BancoDoBrasil();
        bb.lerArquivo("C:/Users/Jamylle/Downloads/padraoprojeto-main/BancoImplementacao/src/bancoboleto/banco-brasil-1.txt");
        bra.lerArquivo("C:/Users/Jamylle/Downloads/padraoprojeto-main/BancoImplementacao/src/bancoboleto/bradesco-1.csv"); 
        System.out.println("-------Boletos BANCO DO BRASIL-----------");
        for(int i = 0;i < bb.boletos.size(); i++) {
            System.out.println(bb.boletos.get(i).toString()+"\n");
        }
        System.out.println("-------Boletos BRADESCO-----------");
        for(int i = 0;i < bra.boletos.size(); i++) {
            System.out.println(bra.boletos.get(i).toString()+"\n");
        }
    }
}
