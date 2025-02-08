import java.io.*;
import java.util.*;

public class InFileRepository<T> implements CrudRepository<T> {
    private String filePath;

    public InFileRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void save(T entity) {
        try (FileWriter writer = new FileWriter(filePath, true);
             BufferedWriter bw = new BufferedWriter(writer);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(entity.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T findById(int id) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int currentId = 0;
            while ((line = br.readLine()) != null) {
                if (currentId == id) {
                    return (T) line; // Aqui você pode precisar de um método para converter a string de volta para o objeto
                }
                currentId++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(T entity) {
        // Implementação para atualizar a entidade no arquivo
        // Você pode precisar ler todas as entidades, modificar a que corresponde e reescrever o arquivo
    }

    @Override
    public void delete(int id) {
        // Implementação para deletar a entidade do arquivo
        // Você pode precisar ler todas as entidades, ignorar a que corresponde ao id e reescrever o arquivo
    }

    @Override
    public List<T> findAll() {
        List<T> entities = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                entities.add((T) line); // Aqui você pode precisar de um método para converter a string de volta para o objeto
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entities;
    }
}