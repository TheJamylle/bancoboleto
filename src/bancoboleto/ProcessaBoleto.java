package bancoboleto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jamylle
 */
public class ProcessaBoleto{
    
    public  List<String> linhas;
    
    public  List<String> processar(String path){
        linhas = new ArrayList();
        String linha = "";
        try {
            File myObj = new File(path);
            Scanner scanner = new Scanner(myObj);
            while (scanner.hasNextLine()) {
                linha = scanner.nextLine();
                System.out.println(linha);
                linhas.add(linha);
            }
        scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("Não foi possível ler");
      e.printStackTrace();
    }
        return linhas;
    }
    

 }
    
    

