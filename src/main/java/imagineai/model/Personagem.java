package imagineai.model;

import org.springframework.data.mongodb.core.mapping.*;

@Document(collection = "personagens")
public class Personagem {
    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @DBRef
    @Field(name = "id_historia")
    private Historia historia;

    private String nome;

    @Field(name = "historia_personagem")
    private String historiaPersonagem;

    @Field(name = "imagem_personagem")
    private String imagemPersonagem;

    public Personagem() {
    }

    public Personagem(String id, Historia historia, String nome, String historiaPersonagem, String imagemPersonagem) {
        this.id = id;
        this.historia = historia;
        this.nome = nome;
        this.historiaPersonagem = historiaPersonagem;
        this.imagemPersonagem = imagemPersonagem;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

