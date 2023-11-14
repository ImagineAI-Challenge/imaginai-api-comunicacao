package imagineai.controller;

import imagineai.dto.PersonagemDTO;
import imagineai.dto.PromptDTO;
import imagineai.dto.PromptRespostaDTO;
import imagineai.model.Personagem;
import imagineai.service.GptService;
import imagineai.service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gpt")
public class GptController {

    @Autowired
    public GptService gptService;

    @Autowired
    private PersonagemService personagemService;

    @PostMapping("/prompt")
    public PromptRespostaDTO prompt(@RequestBody PromptDTO prompt){
        return gptService.getOpenAiResponse(prompt);
    }

    @PostMapping("/personagem")
    public Personagem criarPersonagem(@RequestBody PersonagemDTO personagemDTO){
        return personagemService.create(personagemDTO);
    }
}
