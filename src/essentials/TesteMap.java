package essentials;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class TesteMap {
    public static void main(String[] args) {
//        Map map = new Map();
//        saveMap(map, "mapa.bin");
//
//        Map loadedMap = carregarMapa("mapa.bin");
//        if (loadedMap != null) {
//            System.out.println("Mapa carregado com sucesso!");
//        }
    }

    // Método para salvar o mapa em um arquivo binário
    public static void saveMap(Map map, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(map);
            System.out.println("Mapa salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o mapa: " + e.getMessage());
        }
    }

    // Método para carregar o mapa de um arquivo binário
    public static Map carregarMapa(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (Map) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar o mapa: " + e.getMessage());
            return null;
        }
    }
}
