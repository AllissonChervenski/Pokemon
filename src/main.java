public class main {
    public static void main(String[] args) {
        Pokemon pok = new Pokemon();
        Pokemon p = new Pokemon();
        Pokemon pk = new Pokemon();


        System.out.println((GeradorDePokemons.getInstancia().toString()));


        Lista lista = new Lista();

        long inicio = System.nanoTime() / 1000;
        lista.addDezMil();
        long fim = System.nanoTime() / 1000;
        System.out.println("Tempo de adição de 10000 pokemons: " + (fim - inicio));

        inicio = System.nanoTime() / 1000;
        lista.removeAgua();
        fim = System.nanoTime() / 1000;
        System.out.println("Tempo de remoção pokemons tipo agua: " + (fim - inicio));

        inicio = System.nanoTime() / 1000;
        lista.ordena();
        fim = System.nanoTime() / 1000;
        System.out.println(lista.toString() + "Tempo de apresentação: " + (fim - inicio));

        inicio = System.nanoTime() / 1000;
        System.out.println(lista.printFogo());
        fim = System.nanoTime() / 1000;
        System.out.println("Tempo de contagem de pokemons tipo fogo: " + (fim - inicio));

        System.out.println("Numero de elementos: " + lista.size());
    }
}
