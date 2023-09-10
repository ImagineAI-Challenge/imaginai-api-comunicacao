package imagineai.controller;

import imagineai.dto.UsuarioLogin;
import imagineai.model.Usuario;
import imagineai.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends BaseController<Usuario, String> {

    @Autowired
    private UsuarioService service;

    @Autowired
    public UsuarioController(UsuarioService usuarioService){ super(usuarioService);}

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody UsuarioLogin usuarioLogin) {
        Usuario usuarioLogado = service.login(usuarioLogin);

        if (usuarioLogado == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        return ResponseEntity.ok(usuarioLogado);
    }
}
