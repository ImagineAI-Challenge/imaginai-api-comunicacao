package imagineai.service;

import imagineai.model.Historia;
import imagineai.repository.HistoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class HistoriaService extends BaseService<Historia, String> {
    public HistoriaService(HistoriaRepository repository) {
        super(repository);
    }
}
