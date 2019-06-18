import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeradorDePokemons {

    private static ArrayList<String> nomes;
    private static ArrayList<String> tipos;
    private int quantidade = 0;
    
    private static Random gerador = new Random();

    private static GeradorDePokemons instancia = null;

    private GeradorDePokemons() {
        nomes = new ArrayList<>();
        tipos = new ArrayList<>();
        leArquivo();
    }

    private void leArquivo(){
        File arquivoPokemons = new File("C:\\Users\\gabri\\Desktop\\Home-Work\\Trabalhooooo\\Pokemon\\src\\Pokemons.txt");
        BufferedReader input;
        String pokemon;
        String [] atributos;
        
        try {
            input = new BufferedReader(new InputStreamReader(new FileInputStream(arquivoPokemons)));
            while ((pokemon = input.readLine()) != null) {
                atributos = pokemon.split(" ");
                nomes.add(atributos[0]);
                tipos.add(atributos[1]);
                quantidade++;
            }
            input.close();
        } catch (IOException ex) {
            Logger.getLogger(GeradorDePokemons.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Captura uma instancia única de GeradorDePokemons.
     * @return A instânica única da classe GeradosDePokemons.
     */
    public static GeradorDePokemons getInstancia() {
        if (instancia == null) {
            instancia = new GeradorDePokemons();
        }
        return instancia;
    }

    /**
     * Método que retorna os atributos de um Pokémon.
     * @return Array de String contendo o nome e o tipo de um Pokémon. 
     */
    public String[] geraPokemon() {
        String [] pokemon = new String[2];
        int nPokemon = gerador.nextInt(quantidade-1);
        pokemon[0] = nomes.get(nPokemon);
        pokemon[1] = tipos.get(nPokemon);
        return pokemon;
    }

    /**
     * Método que exibe o número de Pokémons lidos do arquivo.
     * @return 
     */
    @Override
    public String toString() {
        return "Número de Pokémons no arquivo " + quantidade;
    }

}
