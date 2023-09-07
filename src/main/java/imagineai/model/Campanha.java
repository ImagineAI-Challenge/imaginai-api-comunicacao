package imagineai.model;

import org.springframework.data.mongodb.core.mapping.*;

@Document(collection = "campanhas")
public class Campanha {
    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @DBRef
    @Field(name = "id_historia")
    private Historia historia;
    
    private String campanha;

    @Field(name = "imagens")
    private String[] imagens;

    public Campanha() {
    }

    public Campanha(String id, Historia historia, String campanha, String[] imagens) {
        this.id = id;
        this.historia = historia;
        this.campanha = campanha;
        this.imagens = imagens;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Historia getIdHistoria() {
        return historia;
    }

    public void setIdHistoria(Historia historia) {
        this.historia = historia;
    }

    public String getCampanha() {
        return campanha;
    }

    public void setCampanha(String campanha) {
        this.campanha = campanha;
    }

    public String[] getImagens() {
        return imagens;
    }

    public void setImagens(String[] imagens) {
        this.imagens = imagens;
    }
}

