public class Arvore {
    private Nodo raiz;
    private int nElementos = 0;

    private int contFogo = 0;
    public Arvore(){
    this.setRaiz(null);
    }

    public boolean add(Pokemon p) {
        Nodo novo;
        novo = new Nodo(p);
        novo.setChave(getnElementos());
        if(raiz == null){
            raiz = novo;
            pokFogo(novo.getInfo());
             nElementos = getnElementos() + 1;
            return true;
        }
        return add(raiz, novo);
    }

    private boolean add(Nodo atual, Nodo novo){
        if(novo.getChave() == atual.getChave()){
            return false;
        }
        else if(novo.getChave() < atual.getChave()){
            if(atual.getEsq() == null){
                atual.setEsq(novo);
                novo.setChave(getnElementos());
                novo.setPai(atual);
                pokFogo(novo.getInfo());
                nElementos = getnElementos() + 1;
                return true;
            }
            else{
                return add(atual.getEsq(), novo);
            }
        }
        else{
            if(atual.getDir() == null){
                atual.setDir(novo);
                novo.setChave(getnElementos());
                novo.setPai(atual);
                pokFogo(novo.getInfo());
                nElementos = getnElementos() + 1;
                return true;
            }
            else{
                return add(atual.getDir(), novo);
            }
        }
    }

    public int size(){
        return size(this.raiz);
    }
    private int size(Nodo atual){
        if(atual == null)
            return 0;
        return size(atual.getEsq()) + 1 +
                size(atual.getDir());
    }


    public String toString (){
        return toString(this.raiz);
    }
    private String toString(Nodo atual){
        if(atual == null)
            return "";
        return atual.toString() + toString(atual.getEsq())
                + toString(atual.getDir());
    }

    public void ordenar(Nodo atual){
      if(atual.getBalanceamento() == -2){

      }
    }

    public void pokFogo(Pokemon p) {
        if (p.getTipo().equals("Fogo")) {
            this.setContFogo(getContFogo() + 1);
        }
    }


    public void verificarBalanceamento(Nodo atual){
        setBalanceamento(atual);
        int balanceamento = atual.getBalanceamento();

        if (balanceamento == -2) {

            if (altura(atual.getEsq().getEsq()) >= altura(atual.getEsq().getDir())) {
                atual = rotacaoDireita(atual);

            } else {
                atual = duplaRotacaoEsquerdaDireita(atual);
            }

        } else if (balanceamento == 2) {

            if (altura(atual.getDir().getDir()) >= altura(atual.getDir().getEsq())) {
                atual = rotacaoEsquerda(atual);

            } else {
                atual = duplaRotacaoDireitaEsquerda(atual);
            }
        }

        if (atual.getPai() != null) {
            verificarBalanceamento(atual.getPai());
        } else {
            this.raiz = atual;
        }
}

    public int altura(Nodo atual){
        if(atual == null){
            return -1;
        }
        if(atual.getEsq() == null && atual.getDir() == null){
            return 0;
        }
        else if(atual.getEsq() == null){
            return 1 + altura(atual.getDir());
        }
        else if(atual.getDir() == null){
            return 1 + altura(atual.getEsq());
        }
        else{
            return 1 + Math.max(altura(atual.getEsq()), altura((atual.getDir())));
        }
    }

    private void setBalanceamento(Nodo no) {
        no.setBalanceamento(altura(no.getDir()) - altura(no.getEsq()));
    }

    public Nodo rotacaoDireita(Nodo inicial){

        Nodo esquerda = inicial.getEsq();
        esquerda.setPai(inicial.getPai());

        inicial.setEsq(esquerda.getDir());

        if(inicial.getEsq() != null){
            inicial.getEsq().setPai(inicial);
        }

        esquerda.setDir(inicial);
        inicial.setPai(esquerda);

        verify(inicial, esquerda);
        setBalanceamento(inicial);
        setBalanceamento(esquerda);
        return esquerda;
    }

    public Nodo rotacaoEsquerda(Nodo inicial){
        Nodo direita = inicial.getDir();
        direita.setPai(inicial.getPai());

        inicial.setDir(direita.getEsq());

        if(inicial.getDir() != null){
            inicial.getDir().setPai(inicial);
        }

        direita.setEsq(inicial);
        verify(inicial, direita);

        setBalanceamento(inicial);
        setBalanceamento(direita);

        return direita;

    }

    private void verify(Nodo inicial, Nodo lado) {
        if(lado.getPai() != null){
            if(lado.getPai().getDir() == inicial){
                lado.getPai().setDir(lado);
            }
            else if(lado.getPai().getEsq() == inicial){
                lado.getPai().setEsq(lado);
            }
        }
    }

    public Nodo duplaRotacaoEsquerdaDireita(Nodo inicial) {
        inicial.setEsq(rotacaoEsquerda(inicial.getEsq()));
        return rotacaoDireita(inicial);
    }

    public Nodo duplaRotacaoDireitaEsquerda(Nodo inicial) {
        inicial.setDir(rotacaoDireita(inicial.getDir()));
        return rotacaoEsquerda(inicial);
    }

    public Nodo sucessor(Nodo aux){
        if(aux.getDir() != null){
            Nodo novo = aux.getDir();
            while(novo.getEsq() != null){
                novo = novo.getEsq();
            }
            return novo;
        }
        else{
            Nodo novo2 = aux.getPai();
            while(novo2 != null && novo2 == aux.getDir()){
                aux = novo2;
                novo2 = aux.getPai();
            }
            return novo2;
        }
    }

    public boolean remove(int chave) {
        Nodo atual = raiz;
        Nodo pai = raiz;
        return remove(atual, pai, chave);
    }

    private boolean remove(Nodo atual, Nodo pai, int chave){
        if(atual == null){
            return false;
        }
        else if(atual.getChave() == chave){
            return removeEncontrado(atual, pai);
        }
        else if(atual.getChave() > chave){
            return remove(atual.getEsq(), atual, chave);
        }
        return remove(atual.getDir(), atual, chave);
    }
    private boolean removeEncontrado(Nodo atual, Nodo pai){
        if(atual.getEsq() == null && atual.getDir() == null){
            return removeFolha(atual, pai);
        }
        else if(atual.getEsq() == null || atual.getDir() == null){
            return removeUmFilho(atual, pai);
        }
        else
            return removerDoisFilhos(atual, pai);
    }

    private boolean removeFolha(Nodo atual, Nodo pai) {
        if (atual == raiz){
            raiz = null;
        }
        else if(pai.getEsq() == atual){
            pai.setEsq(null);
        }
        else{
            pai.setDir(null);
        }
        return true;
    }

    private boolean removeUmFilho(Nodo atual, Nodo pai){
        if(atual == raiz){
            if(atual.getEsq() != null){
                raiz = atual.getEsq();
            }
            else{
                raiz = atual.getDir();
            }
        }
        else if (pai.getEsq() == atual){
            if(atual.getEsq() != null){
                pai.setEsq(atual.getEsq());
            }
            else{
                pai.setEsq(atual.getDir());
            }
        }
        else{
            if(atual.getEsq() != null){
                pai.setDir(atual.getEsq());
            }
            else{
                pai.setDir(atual.getDir());
            }
        }
        return true;
    }

    private boolean removerDoisFilhos(Nodo atual, Nodo pai){
        Nodo sucessor = sucessor(atual);
        Nodo paiSucessor = atual;
        if(sucessor == atual.getDir()){
            sucessor.setEsq(atual.getEsq());
            if(atual == raiz){
                raiz = sucessor;
                verificarBalanceamento(raiz);
            }
            else if(pai.getEsq() == atual){
                pai.setEsq(sucessor);
                verificarBalanceamento(pai.getEsq());
            }

        }
        else{
            paiSucessor.setEsq(sucessor.getDir());
            sucessor.setDir(atual.getDir());
            sucessor.setEsq(atual.getEsq());
            if(atual == raiz){
                raiz = sucessor;
                verificarBalanceamento(raiz);
            }
            else if(pai.getEsq() == atual){
                pai.setEsq(sucessor);
                verificarBalanceamento(pai.getEsq());
            }
            else
                pai.setDir(sucessor);
                verificarBalanceamento(pai.getDir());
        }

        return true;
    }


    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public int getnElementos() {
        return nElementos;
    }

    public int getContFogo() {
        return contFogo;
    }

    public void setContFogo(int contFogo) {
        this.contFogo = contFogo;
    }
}
