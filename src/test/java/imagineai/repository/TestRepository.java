package imagineai.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestRepository {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Test
    public void testando(){
        usuarioRepository.deleteAll();
    }

}
