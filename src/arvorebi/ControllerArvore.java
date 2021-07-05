/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebi;

import java.util.Objects;

/**
 *
 * @author info-chefe
 */
public class ControllerArvore 
{
    //Criando nó raiz vazio
    public ClasseNo raiz = null;
    
    // Carrega o Nó raiz e valor passado pelo usuario no metodo inserindo
    public void inserir(Long valor){ inserindo(raiz, valor);}
        
    public void inserindo(ClasseNo node, Long valor)
    {
        // Verifica se raiz é vazia, se for ela recebe um novo No com o valor do usuario
        if(node == null){raiz = new ClasseNo(valor);}
        else 
        {
            if (valor < node.item)
            {
                // Verifica se a esquerda do nó é vazia se for ele chama novamente a função recursivamente
                if (node.esq != null){ inserindo(node.esq, valor);} 
                // Senão for vazia a esquerda então ele adiciona o novo nó a esquerda
                else { node.esq = new ClasseNo(valor); }
            }
            else 
            {
                // Verifica se a direita do nó é vazia se for ele chama novamente a função recursivamente
                if (node.dir != null){inserindo(node.dir, valor);} 
                // Senão for vazia a direita então ele adiciona o novo nó a esquerda
                else { node.dir = new ClasseNo(valor);}
            }
        } 

    }
    
    public void exibir() 
    {
        System.out.print("\n Exibindo em ordem: ");
        inOrder(raiz);

        System.out.print("\n Exibindo em pos-ordem: ");
        posOrder(raiz);

        System.out.print("\n Exibindo em pre-ordem: ");
        preOrder(raiz);
    }
    
    
    public void inOrder(ClasseNo atual) 
    {
         
        if (atual != null) 
        {
          inOrder(atual.esq);
          System.out.print(atual.item + " ");
          inOrder(atual.dir);
        }
    }
    
    public void preOrder(ClasseNo atual)
    {
        if (atual != null) 
        {
          System.out.print(atual.item + " ");
          preOrder(atual.esq);
          preOrder(atual.dir);
        }
    }
  
    public void posOrder(ClasseNo atual) 
    {
        if (atual != null) 
        {
          posOrder(atual.esq);
          posOrder(atual.dir);
          System.out.print(atual.item + " ");
        }
    } 
    
    public void remover(Long valor){  removendo(raiz, valor); }
       
    public void removendo(ClasseNo rmNo, Long valor)
    {    
        // Verifica se valor passado foi encontrado se sim fica null
        if(rmNo.item == valor){ rmNo = null; }        
        // Senão se o valor for maior andará para esquerda
        else if(valor < rmNo.item)
        {
            // Verificando se o item é igual o valor passado, se sim vamos usar regras de exclusão
            if(rmNo.esq.item == valor){removendoNoEsq(rmNo);}
            // Chmando função recursivamente
            else{removendo(rmNo.esq, valor);}
        }
        else
        {
            // Verificando se o item é igual o valor passado, se sim vamos usar regras de exclusão
            if(rmNo.dir.item == valor){removendoNoDir(rmNo);}
            // Chmando função recursivamente
            else{removendo(rmNo.dir, valor);}
        }
    }
  
    public void removendoNoEsq(ClasseNo noPai)
    {
        //Criamos um contador de filhos do nó passado
        int filhos = 0;
        
        // Criamos um nó para removermos
        ClasseNo noRm = null;
        
        // noRm recebe o valor do noPai passado da função remover
        noRm = noPai.esq;
        
        // Chamamos a função para contar os filhos do nó
        filhos = contFilhos(noRm);
        
        // Se não tem filhos pode remover 
        if(filhos == 0){ removeSemFilhos(noPai, "E");}
        
        else if(filhos == 1){ removeFilhosEsq(noPai, "D");}
        else if(filhos == 2){ removeFilhosEsq(noPai, "E");}
        else if(filhos == 3){ removeFilhosEsq(noPai, "E");}
    }
       
    public void removeFilhosEsq(ClasseNo noPai, String lado)
    {
        if(lado.equals("E")){noPai.esq = noPai.esq.dir;}
        else{noPai.esq = noPai.esq.esq;}
    }
    
       
    public void removendoNoDir(ClasseNo noPai)
    {
        //Criamos um contador de filhos do nó passado
        int filhos = 0;
        
        // Criamos um nó para removermos
        ClasseNo noRm = null;
        
        // noRm recebe o valor do noPai passado da função remover
        noRm = noPai.dir;
        
        // Chamamos a função para contar os filhos do nó
        filhos = contFilhos(noRm);
        
        // Se não tem filhos pode remover 
        if(filhos == 0){ removeSemFilhos(noPai, "D");}
        else if(filhos == 1){ removeFilhosDir(noPai, "E");}
        else if(filhos == 2){ removeFilhosDir(noPai, "D");}
        else if(filhos == 3){ removeFilhos(noPai, "D");}
    }
    
    public void removeFilhosDir(ClasseNo noPai, String lado)
    {
        if(lado.equals("E")){noPai.dir = noPai.dir.esq;}
        else{noPai.dir = noPai.dir.dir;}
    }
    
  
    public void removeFilhos(ClasseNo noPai, String lado)
    {
        if(lado.equals("D")){noPai.dir = noPai.dir.esq;}
        else{noPai.esq = noPai.esq.dir;}
    }
        
    public void removeSemFilhos(ClasseNo noPai, String lado)
    {
        // verifica qual o lado que foi mandado pela função e defini como null
        if(lado.equals("E")){noPai.esq = null;}
        else{noPai.dir = null;}
    }
      
    public int contFilhos(ClasseNo no)
    {
        // Verificamos se a esquerda tem alguma coisa e se a direita tem tambem, se sim soma os resultados
        // Seguindo assim total = 0 (sem filhos, uma folha), total = 1 (filho a esquerda), total = 2 (filho a direita), total = 3 (filho nos dois lados)
        int total = 0;
        if(no.esq != null){total += 1;}
        if(no.dir != null){total += 2;}
        return total;
    }
   
    public Long buscar(Long valor)
    { 
        Long result = buscando(raiz, valor);
        return result;
    }
    
    public Long buscando(ClasseNo no, Long valor) 
    {
        Long resultado = null;
        
        // Verifica se raiz é vazia se sim não existe valores
        if(no == null){ resultado = null; }
        // Verifica se o valor é a raiz
        else if(no.item == valor){ resultado = no.item;}
        // Anda pela arvore recusivamente até encontrar o valor
        else
        {
            if(valor < no.item ){ resultado = buscando(no.esq, valor);}
            else{resultado = buscando(no.dir, valor);}    
        }
        return resultado;
    }
   
}
