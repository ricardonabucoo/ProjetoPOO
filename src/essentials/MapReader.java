package essentials;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MapReader {

    // Atributos
    private int size;
    private int rocksAmount;
    private int maxPassionFruitAmount;
    private int initialPassionFruitAmount;
    private HashMap<FruitType, Integer> numberOfTrees;
    private HashMap<FruitType, Integer> initialFruitsNumber;
    private int wormyFruitAmount;
    private int bagCapacity;

    // Construtor
    public MapReader() {
        this.numberOfTrees = new HashMap<>();
        this.initialFruitsNumber = new HashMap<>();
    }

    // Método para ler o arquivo e salvar os dados em variáveis
    public void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                switch (parts[0]) {
                    case "dimensao":
                        size = Integer.parseInt(parts[1]);
                        break;
                    case "pedras":
                        rocksAmount = Integer.parseInt(parts[1]);
                        break;
                    case "maximo_maracuja":
                        maxPassionFruitAmount = Integer.parseInt(parts[1]);
                        break;
                    case "inicial_maracuja":
                        initialPassionFruitAmount = Integer.parseInt(parts[1]);
                        break;
                    case "bichadas":
                        wormyFruitAmount = Integer.parseInt(parts[1]);
                        break;
                    case "mochila":
                        bagCapacity = Integer.parseInt(parts[1]);
                        break;
                    default:
                        // Assume que o restante são árvores e frutas (formato: fruta árvores frutas)
                        FruitType fruitType = FruitType.valueOf(parts[0].toUpperCase());
                        numberOfTrees.put(fruitType, Integer.parseInt(parts[1]));
                        initialFruitsNumber.put(fruitType, Integer.parseInt(parts[2]));
                        break;
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar a configuração: " + e.getMessage());
        }
    }

    // Métodos get para acessar os valores carregados
    public int getSize() {
        return size;
    }

    public int getRocksAmount() {
        return rocksAmount;
    }

    public int getMaxPassionFruitAmount() {
        return maxPassionFruitAmount;
    }

    public int getInitialPassionFruitAmount() {
        return initialPassionFruitAmount;
    }

    public int getWormyFruitAmount() {
        return wormyFruitAmount;
    }

    public int getBagCapacity() {
        return bagCapacity;
    }

    public HashMap<FruitType, Integer> getNumberOfTrees() {
        return numberOfTrees;
    }

    public HashMap<FruitType, Integer> getInitialFruitsNumber() {
        return initialFruitsNumber;
    }


}
