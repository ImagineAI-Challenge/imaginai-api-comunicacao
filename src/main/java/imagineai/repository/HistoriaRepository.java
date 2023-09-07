package imagineai.repository;

import imagineai.model.Historia;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriaRepository extends MongoRepository<Historia, String> {
}

