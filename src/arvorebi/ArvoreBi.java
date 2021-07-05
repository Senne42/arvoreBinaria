/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebi;

import java.util.Scanner;

/**
 *
 * @author info-chefe
 */
public class ArvoreBi {

    /**
     * @param args the command line arguments
     */
    
    ControllerArvore arvCon = new ControllerArvore();
        
    
    public static void main(String[] args) 
    {
        // TODO code application logic here
        
        Scanner le = new Scanner(System.in);
        ControllerArvore arv = new ControllerArvore();
        int opcao;
        Long valor;
        
        ClasseNo node = new ClasseNo(null);
        
        // Titulo do Programa
        System.out.println("Arvore binária com numeros");
        
        // Criando menu para opções
        do 
        {
            System.out.print("\n***********************************");
            System.out.print("\nEntre com a opcao:");
            System.out.print("\n ----1: Inserir");
            System.out.print("\n ----2: Excluir");
            System.out.print("\n ----3: Exibir");
            System.out.print("\n ----4: Sair do programa");
            System.out.print("\n***********************************");
            System.out.print("\n-> ");
            opcao = le.nextInt();
            
            
            switch(opcao) 
            {
                    // Opção do menu INSERIR
                    case 1: 
                    {
                           System.out.print("\n Informe o valor (long) -> ");
                           valor = le.nextLong();
                           arv.inserir(valor);
                           break;
                    }
                    // Opção do menu REMOVER
                    case 2: 
                    {
                           System.out.print("\n Informe o valor (long) -> ");
                           valor = le.nextLong();
                           if(arv.buscar(valor) != null){arv.remover(valor);}
                           else{System.out.println("Valor não encontrado na arvore");}
                           
                           break;
                    }
                    // Opção do menu CAMINHAR
                    case 3: 
                    {
                          arv.exibir();
                          break; 
                    }
            } // fim switch
        } 
        while(opcao != 4);

    }
    
}
