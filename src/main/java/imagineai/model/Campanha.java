package imagineai.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "campanhas")
public class Campanha {
    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @Field(name = "id_historia")
    private int idHistoria;

    private String campanha;

    @Field(name = "imagens")
    private String[] imagens;

    public Campanha() {
    }

    public Campanha(String id, int idHistoria, String campanha, String[] imagens) {
        this.id = id;
        this.idHistoria = idHistoria;
        this.campanha = campanha;
        this.imagens = imagens;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(int idHistoria) {
        this.idHistoria = idHistoria;
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

