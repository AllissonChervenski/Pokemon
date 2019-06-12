public class No {
    private No proximo;
    private No anterior;
    private Pokemon info;
    private int idPok = 0;

    public No(Pokemon p){
        this.info = p;
        this.proximo = null;
        this.setAnterior(null);
    }

    public int getIdPok() {
        return idPok;
    }

    public void setIdPok(int idPok) {
        this.idPok = idPok;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public Pokemon getInfo() {
        return info;
    }

    public void setInfo(Pokemon info) {
        this.info = info;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }
}

