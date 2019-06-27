public class Pilha {
    private No topo;
    private int nElementos;
    private int contFogo = 0;

    public Pilha() {

        this.topo = null;
        this.nElementos = 0;
    }

    public void clear() {
        No aux = topo;
        while (aux.getProximo() != null) {
            this.pop();
            aux = aux.getProximo();
            if (aux == topo) {
                this.topo = null;
                this.nElementos = 0;
            }
        }
    }


    public void push10K() {
        for (int i = 0; i < 10000; i++) {
            Pokemon pok = new Pokemon();
            this.push(pok);
        }
    }

    public void push30() {
        for (int i = 0; i < 100; i++) {
            Pokemon pok = new Pokemon();
            this.push(pok);
        }
    }

    public boolean push(Pokemon pok) {
        No novo = new No(pok);
        novo.setId(this.nElementos);
        if (topo == null) {
            topo = novo;
            this.nElementos++;
        } else {
            novo.setProximo(topo);
            topo = novo;
            this.nElementos++;
        }
        return true;
    }

    public void push100K() {
        for (int i = 0; i < 100000; i++) {
            Pokemon pok = new Pokemon();
            this.push(pok);
        }
    }

    public void push1M() {
        for (int i = 0; i < 1000000; i++) {
            Pokemon pok = new Pokemon();
            this.push(pok);
        }
    }

    public String printFire() {
        No aux = topo;
        while (aux.getProximo() != null) {
            if (aux.getInfo().getTipo().equals("Fogo")) {
                this.contFogo++;
            }
            aux = aux.getProximo();
        }
        return "Quantidade de pokemons tipo fogo: " + this.contFogo;
    }

    public int pop() {
        int info = -1;
        if (topo != null) {
            info = topo.getId();
            topo = topo.getProximo();
        }
        return info;
    }

    Pokemon top() {
        if (topo == null) {
            return null;
        } else {
            return topo.getInfo();
        }
    }

    int size() {
        return this.nElementos;
    }

    @Override
    public String toString() {
        No aux = topo;
        String values = "";
        int value = 0;

        if (aux == null) {
            return "A pilha está vazia";
        } else {
            while (aux != null) {
                values += aux.getInfo().toString() + " " + aux.getId() + " \n";
                aux = aux.getProximo();
            }
            return values;
        }
    }

    public void removeWater() {
        Pilha auxPile = new Pilha();
        No aux = topo;
        while (aux != null) {
            if (aux.getInfo().getTipo().equals("Agua")) {
                aux = aux.getProximo();
            } else {
                auxPile.push(aux.getInfo());
            }
            aux = aux.getProximo();
        }

        this.clear();
        No auxAuxPile = auxPile.getTopo();
        while (auxAuxPile != null) {
            this.push(auxAuxPile.getInfo());

            auxAuxPile = auxAuxPile.getProximo();
        }
    }


    public void SortPile() {
        No auxNode = topo;
        No parse;
        No auxSort = auxNode.getProximo();
        while (auxNode.getProximo() != null) {
            while (auxSort != null) {

                if (auxNode.getInfo().compareTo(auxSort.getInfo()) > 0) {
                    parse = new No(auxNode.getInfo());
                    auxNode.setInfo(auxSort.getInfo());
                    auxSort.setInfo(parse.getInfo());
                    auxSort = auxSort.getProximo();
                } else {
                    auxSort = auxSort.getProximo();
                }

            }
            auxNode = auxNode.getProximo();
            auxSort = auxNode.getProximo();
        }
    }

    public No getTopo() {
        return topo;
    }

    public static void main(String[] args) {
        long inicio0, inicio1, inicio2, inicio3;
        long fim0, fim1, fim2, fim3;
        Pilha p1 = new Pilha();

        inicio0 = System.nanoTime() / 1000;
        p1.push100K();
        fim0 = System.nanoTime() / 1000;

        inicio1 = System.nanoTime() / 1000;
        p1.removeWater();
        fim1 = System.nanoTime() / 1000;

        inicio2 = System.nanoTime() / 1000;
        p1.SortPile();
        System.out.println(p1.toString());
        fim2 = System.nanoTime() / 1000;

        inicio3 = System.nanoTime() / 1000;
        p1.printFire();
        fim3 = System.nanoTime() / 1000;


        System.out.println("Metricas coletadas : \n");
        System.out.println("Tempo de adição de 10000 pokemons: " + (fim0 - inicio0));
        System.out.println("Tempo de remoção pokemons tipo agua: " + (fim1 - inicio1));
        System.out.println("Tempo de apresentação: " + (fim2 - inicio2));
        System.out.println("Tempo de contagem de pokemons tipo fogo: " + (fim3 - inicio3));
        System.out.println(p1.printFire());
        System.out.println("Numero de elementos: " + p1.size());

    }

}
