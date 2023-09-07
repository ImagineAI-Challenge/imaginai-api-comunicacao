package imagineai.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "chat")
public class Chat {
    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @Field(name = "id_historia")
    private int idHistoria;

    @Field(name = "respostas")
    private String[] respostas;

    public Chat() {
    }

    public Chat(String id, int idHistoria, String[] respostas) {
        this.id = id;
        this.idHistoria = idHistoria;
        this.respostas = respostas;
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

    public String[] getRespostas() {
        return respostas;
    }

    public void setRespostas(String[] respostas) {
        this.respostas = respostas;
    }
}

