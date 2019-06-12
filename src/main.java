public class main {
    public static void main(String[] args) {
        Pokemon pok = new Pokemon();
        System.out.println(pok.toString());
        System.out.println(GeradorDePokemons.getInstancia().toString());

        Lista lista = new Lista();
        lista.addUmMilhao();
        System.out.println(lista.size());
        System.out.println(lista.printFogo());
    }
}
