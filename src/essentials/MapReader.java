package essentials;

import elements.FruitType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JFileChooser;

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
    private GameMap map;

    public MapReader(File file) {
        this.numberOfTrees = new HashMap<>();
        this.initialFruitsNumber = new HashMap<>();
        readFile(file);
    }

    private void readFile(File file) {
        // Mapeamento de termos em português para enums e variáveis em inglês, acho que a professora
    	//vai passar arquivos em português, aí criei o hashmap com a tradução
        HashMap<String, String> translationMap = new HashMap<>();
        translationMap.put("dimensao", "size");
        translationMap.put("pedras", "rocksAmount");
        translationMap.put("maximo_maracuja", "maxPassionFruitAmount");
        translationMap.put("inicial_maracuja", "initialPassionFruitAmount");
        translationMap.put("bichadas", "wormyFruitAmount");
        translationMap.put("mochila", "bagCapacity");
        translationMap.put("maracuja", "PASSIONFRUIT");
        translationMap.put("laranja", "ORANGE");
        translationMap.put("abacate", "AVOCADO");
        translationMap.put("coco", "COCONUT");
        translationMap.put("acerola", "BARBADOSCHERRY");
        translationMap.put("amora", "BLACKBERRY");
        translationMap.put("goiaba", "GUAVA");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
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
                    case "bichadas":
                        wormyFruitAmount = Integer.parseInt(parts[1]);
                        break;
                    case "mochila":
                        bagCapacity = Integer.parseInt(parts[1]);
                        break;
                    default:
                        // Usar o mapa de tradução para converter o nome da fruta
                        String fruitNameInEnglish = translationMap.getOrDefault(parts[0], parts[0].toUpperCase());
                        FruitType fruitType = FruitType.valueOf(fruitNameInEnglish);

                        // Verifica se é maracujá para atribuir valores específicos
                        if (fruitType == FruitType.PASSIONFRUIT) {
                            maxPassionFruitAmount = Integer.parseInt(parts[1]);
                            initialPassionFruitAmount = Integer.parseInt(parts[2]);
                        }

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
