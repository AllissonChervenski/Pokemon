public class main {
    public static void main(String[] args) {
        Pokemon pok = new Pokemon();
        Pokemon p = new Pokemon();
        Pokemon pk = new Pokemon();


        System.out.println(GeradorDePokemons.getInstancia().toString());


        Lista lista = new Lista();
        lista.add(pok);
        lista.add(p);
        lista.add(pk);
        lista.add(pk);
        lista.addDezMil();


        lista.removeAgua();
        lista.ordena();



        System.out.println(lista.toString());
        System.out.println(lista.size());
        System.out.println(lista.printFogo());
    }
}
