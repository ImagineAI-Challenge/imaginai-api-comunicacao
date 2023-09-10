package imagineai.service;

import imagineai.dto.UsuarioLogin;
import imagineai.model.Usuario;
import imagineai.repository.UsuarioRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends BaseService<Usuario, String>{

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    public UsuarioService(UsuarioRepository repository) {
        super(repository);
    }

    @Override
    public Usuario create(Usuario usuario) {
        usuario.setSenha(encriptografarSenha(usuario.getSenha()));
        return super.create(usuario);
    }

    public String encriptografarSenha(String senha){
        return BCrypt.hashpw(senha, BCrypt.gensalt());
    }

    public Usuario login(UsuarioLogin usuario){
        Usuario usuarioBanco = repository.findByEmail(usuario.email());
        if(usuarioBanco != null){
            if(BCrypt.checkpw(usuario.senha(), usuarioBanco.getSenha())){
                return usuarioBanco;
            }
        }
        return null;
    }
}
