package imagineai.model;

import org.springframework.data.mongodb.core.mapping.*;

@Document(collection = "chat")
public class Chat {
    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @DBRef
    @Field(name = "id_historia")
    private Historia historia;

    @Field(name = "respostas")
    private String[] respostas;

    public Chat() {
    }

    public Chat(String id, Historia historia, String[] respostas) {
        this.id = id;
        this.historia = historia;
        this.respostas = respostas;
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

    public String[] getRespostas() {
        return respostas;
    }

    public void setRespostas(String[] respostas) {
        this.respostas = respostas;
    }
}

