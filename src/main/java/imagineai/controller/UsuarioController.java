package imagineai.controller;

import imagineai.model.Usuario;
import imagineai.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends BaseController<Usuario, String> {
    @Autowired
    public UsuarioController(UsuarioService usuarioService){ super(usuarioService);}
}
