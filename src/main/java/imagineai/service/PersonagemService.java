package imagineai.service;

import imagineai.dto.PromptDTO;
import imagineai.dto.PersonagemDTO;
import imagineai.dto.PromptRespostaDTO;
import imagineai.model.Personagem;
import imagineai.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonagemService extends BaseService<Personagem, String> {
    @Autowired
    private GptService gptService;

    public PersonagemService(PersonagemRepository repository) {
        super(repository);
    }

    public Personagem create(PersonagemDTO personagemDTO) {
        Personagem entity = parseDTOtoEntity(personagemDTO);
        String prompt = "Escreva uma pequena história para um personagem que seja da raça " + entity.getRaca() + ", da classe " + entity.getClasse() + " que se chame " + entity.getNome();
        PromptDTO promptDTO = new PromptDTO(prompt, 500);
        PromptRespostaDTO response = gptService.getOpenAiResponse(promptDTO);
        entity.setHistoriaPersonagem(response.gptResponse());
        return super.create(entity);
    }

    private Personagem parseDTOtoEntity(PersonagemDTO personagemDTO){
        Personagem entity = new Personagem();
        entity.setNome(personagemDTO.nome());
        entity.setRaca(personagemDTO.raca());
        entity.setClasse(personagemDTO.classe());
        return entity;
    }
}
