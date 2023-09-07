package imagineai.repository;

import imagineai.model.Campanha;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampanhaRepository extends MongoRepository<Campanha, String> {
}
