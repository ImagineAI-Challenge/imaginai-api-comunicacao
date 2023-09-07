package imagineai.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "personagens")
public class Personagem {
    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @Field(name = "id_historia")
    private int idHistoria;

    private String[] personagens;

    @Field(name = "historia_personagem")
    private String historiaPersonagem;

    @Field(name = "imagem_personagem")
    private String imagemPersonagem;

    public Personagem() {
    }

    public Personagem(String id, int idHistoria, String[] personagens, String historiaPersonagem, String imagemPersonagem) {
        this.id = id;
        this.idHistoria = idHistoria;
        this.personagens = personagens;
        this.historiaPersonagem = historiaPersonagem;
        this.imagemPersonagem = imagemPersonagem;
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

    public String[] getPersonagens() {
        return personagens;
    }

    public void setPersonagens(String[] personagens) {
        this.personagens = personagens;
    }

    public String getHistoriaPersonagem() {
        return historiaPersonagem;
    }

    public void setHistoriaPersonagem(String historiaPersonagem) {
        this.historiaPersonagem = historiaPersonagem;
    }

    public String getImagemPersonagem() {
        return imagemPersonagem;
    }

    public void setImagemPersonagem(String imagemPersonagem) {
        this.imagemPersonagem = imagemPersonagem;
    }
}

