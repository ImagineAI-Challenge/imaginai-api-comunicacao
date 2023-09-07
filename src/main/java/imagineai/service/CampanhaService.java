package imagineai.service;

import imagineai.model.Campanha;
import imagineai.repository.CampanhaRepository;
import org.springframework.stereotype.Service;

@Service
public class CampanhaService extends BaseService<Campanha, String> {
    public CampanhaService(CampanhaRepository repository) {
        super(repository);
    }
}
