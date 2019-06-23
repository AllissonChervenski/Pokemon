public class Pilha {
    private No topo;

    public Pilha() {
        this.topo = null;
    }

    public boolean push(Pokemon pok) {
        No novo = new No(pok);
        if (topo == null) {
            topo = novo;
        } else {
            novo.setProximo(topo);
            topo = novo;
        }
        return true;
    }

    public void push10K(){
        for (int i=0; i<10000; i++){
            Pokemon pok = new Pokemon();
            this.push(pok);
        }
    }
    public void push100K(){
        for (int i=0; i<100000; i++){
            Pokemon pok = new Pokemon();
            this.push(pok);
        }
    }
    public void push1M(){
        for (int i=0; i<1000000; i++){
            Pokemon pok = new Pokemon();
            this.push(pok);
        }
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
        No aux = topo;
        int size = 0;
        while (aux != null) {
            aux = topo.getProximo();
            size++;
        }
        return size;
    }
    @Override
    public String toString() {
        No aux = topo;
        String values = "";
        int size = 0;
        while (aux != null) {
            aux = topo.getProximo();
            values += aux.getInfo().toString() + " ";
        }
        return values;
    }

    public static void main(String[] args) {
        Pokemon pok = new Pokemon();
        Pokemon pok1 = new Pokemon();
        Pokemon pok2 = new Pokemon();
        Pokemon pok3 = new Pokemon();
        Pilha p1 = new Pilha();
        p1.push(pok);
        p1.push(pok1);
        p1.push(pok2);
        p1.push(pok3);

        System.out.println(p1.toString());
    }

}
