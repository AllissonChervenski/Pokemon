public class main {
    public static void main(String[] args) {
        Pokemon pok = new Pokemon();
        Pokemon p = new Pokemon();
        Pokemon pk = new Pokemon();


        System.out.println(GeradorDePokemons.getInstancia().toString());


        Lista lista = new Lista();

        lista.addDezMil();
        System.out.println("Tempo de adi��o de 10000 pokemons: " + System.nanoTime());

        lista.removeAgua();
        System.out.println("Tempo de remo��o pokemons tipo agua: " + System.nanoTime());

        lista.ordena();
        System.out.println(lista.toString() + "Tempo de apresenta��o: " +  System.nanoTime());

        System.out.println(lista.printFogo() + '\n' + "Tempo de remo��o de pokemons tipo fogo: " + System.nanoTime());
        System.out.println("Numero de elementos: " + lista.size());
    }
}
