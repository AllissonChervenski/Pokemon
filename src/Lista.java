import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lista {
    private No inicio;
    private No fim;
    private int nElementos = 0;
    private int contFogo = 0;

    public Lista() {
        this.setInicio(null);
        this.setFim(null);
    }

    public boolean add(Pokemon info) {
        No novo = new No(info);
        if (inicio == null) {
            this.setInicio(novo);
            this.setFim(novo);
            novo.setIdPok(nElementos);
            pokFogo(info);
            nElementos++;
        }
        else {
            novo.setAnterior(this.fim);
            fim.setProximo(novo);
            fim = novo;
            novo.setIdPok(nElementos);
            pokFogo(info);
            nElementos++;
        }
        return true;
    }

    public boolean addDezMil(){
        while(size() < 10000){
            Pokemon p = new Pokemon();
            this.add(p);
        }
        return true;
        }
    public boolean addCemMil(){
        while(size() < 100000){
            Pokemon p = new Pokemon();
            this.add(p);
        }
        return true;
    }
    public boolean addUmMilhao(){
        while(size() < 1000000){
            Pokemon p = new Pokemon();
            this.add(p);
        }
        return true;
    }


    public void clear() {
        inicio = null;
        fim = null;
        nElementos = 0;
    }

    public boolean contains(Pokemon info) {
        No aux = inicio;
        while (aux != null) {
            if (aux.getInfo() == info) {
                return true;
            }
            aux = aux.getProximo();
        }
        return false;
    }


    public boolean remove(Pokemon info) {
        No atual = inicio;
        if (atual != null) {
            if (atual.getInfo() == info) {
                if (atual == fim) {
                    atual = null;
                    fim = null;
                } else if (atual.getAnterior() != null && atual.getProximo() != null) {
                    atual.getAnterior().setProximo(atual.getProximo());
                    atual.getProximo().setAnterior(atual.getAnterior());
                }
            } else {
                atual = atual.getProximo();
            }
        }
        nElementos--;
        return true;
    }

    public int indexOf(Pokemon info) {
        int contador = 0;
        if (inicio != null) {
            No atual = inicio;
            while (atual.getInfo() != info) {
                if (atual.getProximo() != null) {
                    atual = atual.getProximo();
                    contador++;
                } else {
                    return -1;
                }
            }
            return contador;
        }
        return -1;
    }

    public boolean isEmpty() {
        if (inicio == null && fim == null) {
            return true;
        }
        return false;
    }

    public int size() {
        return nElementos;
    }

    public void set(int indice, int info) {

    }

    public String get(int indice) {
        int i = 0;
        No atual = inicio;
        while (atual != null) {
            if (i == indice)
                return atual.getInfo().toString();
            atual = atual.getProximo();
            i++;
        }
        return "Nada";
    }

    public void pokFogo(Pokemon p){
        if(p.getTipo().equals("Fogo")){
            this.contFogo = getContFogo() + 1;
        }
    }

    public String printFogo(){
        return "Quantidade de pokemons tipo fogo: " + contFogo;
    }

    public No getInicio() {
        return inicio;
    }

    public void setInicio(No inicio) {
        this.inicio = inicio;
    }

    public No getFim() {
        return fim;
    }

    public void setFim(No fim) {
        this.fim = fim;
    }

    public int getnElementos() {
        return nElementos;
    }

    public void setnElementos(int nElementos) {
        this.nElementos = nElementos;
    }
    private void leArquivo(){
        File arquivoPokemons = new File("C:\\Users\\ultra\\Downloads\\Pokemon\\Pokemon\\src\\StringRetorno.txt");
        BufferedReader input;
        String pokemon;
        String [] ;

        try {
            input = new BufferedReader(new InputStreamReader(new FileInputStream(arquivoPokemons)));
            while ((pokemon = input.readLine()) != null) {
                atributos = pokemon.split(" ");
                nomes.add(atributos[0]);
                tipos.add(atributos[1]);
                quantidade++;
            }
            input.close();
        } catch (IOException ex) {
            Logger.getLogger(GeradorDePokemons.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String toString() {
        No atual = inicio;
        String poks = "";
        while (atual != fim) {
            poks += atual.getIdPok() + " " + atual.getInfo().toString() + '\n';
            atual = atual.getProximo();
        }
        return poks;
    }

    public int getContFogo() {
        return contFogo;
    }

}