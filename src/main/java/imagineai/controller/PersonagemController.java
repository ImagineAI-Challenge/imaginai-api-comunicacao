package imagineai.controller;

import imagineai.dto.PersonagemDTO;
import imagineai.dto.PromptDTO;
import imagineai.dto.PromptRespostaDTO;
import imagineai.model.Personagem;
import imagineai.service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
