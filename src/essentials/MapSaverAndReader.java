package essentials;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MapSaverAndReader {

    // Atributos
    public int size;
    public int rocksAmount;
    public int maxPassionFruitAmount;
    public int initialPassionFruitAmount;
    public HashMap<FruitType, Integer> numberOfTrees;
    public HashMap<FruitType, Integer> initialFruitsNumber;
    public int wormyFruitAmount;
    public int bagCapacity;

    // Construtor
    public MapSaverAndReader() {
        this.numberOfTrees = new HashMap<>();
        this.initialFruitsNumber = new HashMap<>();
    }

    // Método para ler o arquivo e salvar os dados em variáveis
    public void ReadFile(String fileName) {
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

    // Exemplo de uso da classe
    public static void main(String[] args) {
        MapSaverAndReader mapSaver = new MapSaverAndReader();

        // Carrega a configuração do arquivo
        mapSaver.ReadFile("map_config.txt");

        // Exibe as configurações carregadas
        System.out.println("Dimensão: " + mapSaver.getSize());
        System.out.println("Quantidade de pedras: " + mapSaver.getRocksAmount());
        System.out.println("Máximo de maracujás: " + mapSaver.getMaxPassionFruitAmount());
        System.out.println("Maracujás iniciais: " + mapSaver.getInitialPassionFruitAmount());
        System.out.println("Frutas bichadas: " + mapSaver.getWormyFruitAmount());
        System.out.println("Capacidade da mochila: " + mapSaver.getBagCapacity());

        System.out.println("\nÁrvores e Frutas Inicial:");
        for (FruitType fruit : mapSaver.getNumberOfTrees().keySet()) {
            System.out.println("Fruta: " + fruit.name().toLowerCase() + 
                               " | Árvores: " + mapSaver.getNumberOfTrees().get(fruit) + 
                               " | Frutas: " + mapSaver.getInitialFruitsNumber().get(fruit));
        }
    }
}
