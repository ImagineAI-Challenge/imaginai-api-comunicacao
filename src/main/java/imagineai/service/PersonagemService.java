package imagineai.service;

import imagineai.model.Personagem;
import imagineai.repository.PersonagemRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonagemService extends BaseService<Personagem, String> {
    public PersonagemService(PersonagemRepository repository) {
        super(repository);
    }
}
