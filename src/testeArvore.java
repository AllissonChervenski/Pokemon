public class testeArvore {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        Pokemon p = new Pokemon();
        Pokemon e = new Pokemon();
        Pokemon i = new Pokemon();
        Pokemon f = new Pokemon();
        arvore.add(i);
        arvore.add(p);
        arvore.add(e);
        arvore.add(f);
        System.out.println(arvore.toString());
    }
}
