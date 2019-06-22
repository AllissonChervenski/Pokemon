public class Nodo {
        private Nodo esq;
        private Nodo dir;
        private Nodo pai;
        private Pokemon info;
        private int chave;
        private int balanceamento;

        public Nodo(Pokemon p) {
            this.setPai(null);
            this.info = p;
            this.esq = null;
            this.dir = null;
        }

    public String toString(){
            return "Nome: " +  this.getInfo().getNome() + " Tipo: " + this.getInfo().getTipo() + " Id: " + this.getChave() +  '\n';

        }

    public Nodo getEsq() { return this.esq; }
    public Nodo getDir() { return this.dir; }
    public void setEsq(Nodo n) { this.esq = n; }
    public void setDir(Nodo n) {this.dir = n;}
    public Pokemon getInfo(){
            return this.info;
        }
    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public int getBalanceamento() {
        return balanceamento;
    }

    public void setBalanceamento(int balanceamento) {
        this.balanceamento = balanceamento;
    }

    public Nodo getPai() {
        return pai;
    }

    public void setPai(Nodo pai) {
        this.pai = pai;
    }
}
