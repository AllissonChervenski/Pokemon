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
            novo.setId(nElementos);
            pokFogo(info);
            nElementos++;
        } else {
            novo.setAnterior(this.fim);
            fim.setProximo(novo);
            fim = novo;
            pokFogo(info);
            novo.setId(nElementos);
            nElementos++;
        }

        return true;
    }

    public boolean addDezMil() {
        while (size() < 10000) {
            Pokemon p = new Pokemon();
            this.add(p);
        }
        return true;
    }

    public boolean addCemMil() {
        while (size() < 100000) {
            Pokemon p = new Pokemon();
            this.add(p);
        }
        return true;
    }

    public boolean addUmMilhao() {
        while (size() < 1000000) {
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

    public boolean contains(String info) {
        No aux = inicio;
        while (aux != null) {
            if (aux.getInfo().getNome().equals(info)) {
                return true;
            }
            aux = aux.getProximo();
        }
        return false;
    }

    public void remove(Pokemon e) {
        No aux = inicio;
        while (aux != null) {
            if (aux.getInfo().getNome().equals(e.getNome())) {
                if (aux == fim && aux.getAnterior() != null) {
                    fim = aux.getAnterior();
                    fim.setProximo(null);
                } else if (aux == inicio && aux.getProximo() != null) {
                    inicio = aux.getProximo();
                    inicio.setAnterior(null);
                } else if (aux.getAnterior() != null && aux.getProximo() != null) {
                    aux.getAnterior().setProximo(aux.getProximo());
                    aux.getProximo().setAnterior(aux.getAnterior());
                } else if (aux == inicio && aux == fim) {
                    this.clear();
                }
            }
            aux = aux.getProximo();
        }
        nElementos --;
    }

    public int indexOf(String info) {
        int contador = 0;
        if (inicio != null) {
            No atual = inicio;
            while (!atual.getInfo().getNome().equals(info)) {
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

    public void set(int indice, Pokemon info) {

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

    public void pokFogo(Pokemon p) {
        if (p.getTipo().equals("Fogo")) {
            this.contFogo = getContFogo() + 1;
        }
    }

    public String toString() {
        String poks = "";
        No atual = inicio;
        while (atual != null) {
            poks += atual.getId() + " " + atual.getInfo().toString() + '\n';
            atual = atual.getProximo();
        }
        return poks;
    }


    public String printFogo() {
        return "Quantidade de pokemons tipo fogo: " + contFogo;
    }

    public void ordena() {
        No atual = inicio;
        No aux;
        No aux1 = atual.getProximo();
        while (atual.getProximo() != null){
            while (aux1 != null) {
                if (atual.getInfo().compareTo(aux1.getInfo()) > 0) {
                    //um novo objeto para copiar o proximo do aux1
                    aux = new No(aux1.getInfo());
                    aux.setProximo(aux1.getProximo());
                    aux.setAnterior(aux.getAnterior());

                    aux1.setInfo(atual.getInfo());
                    atual.setInfo(aux.getInfo());
                    aux1 = aux1.getProximo();
                } else {
                    aux1 = aux1.getProximo();
                }
            }
        atual = atual.getProximo();
        aux1 = atual.getProximo();
    }
}

    public void removeAgua(){
        No atual = inicio;
        while(atual != null){
            if(atual.getInfo().getTipo().equals("Agua")){
                remove(atual.getInfo());
                atual = atual.getProximo();
            }
            atual = atual.getProximo();
        }
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

    public int getContFogo() {
        return contFogo;
    }

}