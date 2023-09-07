package imagineai.controller;

import imagineai.model.Personagem;
import imagineai.service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personagens")
public class PersonagemController extends BaseController<Personagem, String> {
    @Autowired
    public PersonagemController(PersonagemService personagemService) {
        super(personagemService);
    }
}
