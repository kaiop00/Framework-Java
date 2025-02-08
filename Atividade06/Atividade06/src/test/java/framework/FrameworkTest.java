import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class FrameworkTest {
    private CrudRepository<Produto> produtoRepo;

    @BeforeEach
    public void setUp() {
        produtoRepo = new InMemoryRepository<>();
    }

    @Test
    public void testSaveAndFindById() {
        Produto produto = new Produto("Laptop", 3000.0);
        produtoRepo.save(produto);
        Produto found = produtoRepo.findById(1);
        assertNotNull(found);
        assertEquals("Laptop", found.getNome());
    }

    @Test
    public void testUpdate() {
        Produto produto = new Produto("Mouse", 50.0);
        produtoRepo.save(produto);
        produto.setPreco(45.0);
        produtoRepo.update(produto);
        Produto updated = produtoRepo.findById(2);
        assertEquals(45.0, updated.getPreco());
    }

    @Test
    public void testDelete() {
        Produto produto = new Produto("Teclado", 100.0);
        produtoRepo.save(produto);
        produtoRepo.delete(3);
        Produto deleted = produtoRepo.findById(3);
        assertNull(deleted);
    }

    @Test
    public void testFindAll() {
        Produto p1 = new Produto("Monitor", 800.0);
        Produto p2 = new Produto("Impressora", 400.0);
        produtoRepo.save(p1);
        produtoRepo.save(p2);
        List<Produto> produtos = produtoRepo.findAll();
        assertEquals(2, produtos.size());
    }
}