package imagineai.service;

import imagineai.model.Usuario;
import imagineai.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends BaseService<Usuario, String>{

    public UsuarioService(UsuarioRepository repository) {
        super(repository);
    }
}
