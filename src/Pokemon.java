/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;

/**
 *
 * @author Aline
 */
public class Pokemon implements Comparable, Serializable {
    private String nome;
    private String tipo;
    
    public Pokemon(){
        String [] atributos = GeradorDePokemons.getInstancia().geraPokemon();
        nome = atributos[0];
        tipo = atributos[1];
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     * Método que compara se o objeto informado por parâmetro é igual ao atual.
     * @param o Objeto a ser comparado com o atual
     * @return True se o objeto informado é a mesma referência do atual ou se possui p mesmo nome. False em caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        if(!(o instanceof Pokemon)){
            return false;
        }
        Pokemon outro = (Pokemon) o;
        if(this.nome.equals(outro.getNome())){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Compara o nome do Pokémon informado por parâmetro com o nome deste Pokémon.
     * @param t Pokémon a ser comparado
     * @return 1 se o nome do atual vem depois na ordem alfabética, 0 se é igual e -1 se vem antes.
     */
    @Override
    public int compareTo(Object t) {
        if(!(t instanceof Pokemon)){
            throw new ClassCastException();
        }
        Pokemon outro = (Pokemon) t;
        return (this.nome.compareTo(outro.getNome()));
    }
    
    @Override
    public String toString(){
        return "Pokemon "+ nome + " Tipo: "+ tipo;
    }
}
