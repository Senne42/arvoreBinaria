/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebi;

/**
 *
 * @author info-chefe
 */
public class ClasseNo 
{
    //Criando atributos da classe Nó, onde vamos ter itens do tipo Long e dois itens do tipo ClasseNo que vai guardar um No na esquerda e outro na direita
    public Long item; 
    public ClasseNo esq;
    public ClasseNo dir;
    
    public ClasseNo(Long valor)
    {
        this.item = valor;
    }
}
