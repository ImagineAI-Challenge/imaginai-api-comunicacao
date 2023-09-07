package imagineai.repository;

import imagineai.model.Personagem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonagemRepository extends MongoRepository<Personagem, String> {
}

