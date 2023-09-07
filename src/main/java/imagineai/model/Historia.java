package imagineai.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@Document(collection = "historias")
public class Historia {
    @MongoId
    private Long id;

    private LocalDateTime dataFinalizacao;
    @DBRef
    @Field(name = "id_usuario")
    private Usuario usuario;

    public Historia() {
    }

    public Historia(Long id, LocalDateTime dataFinalizacao, Usuario usuario) {
        this.id = id;
        this.dataFinalizacao = dataFinalizacao;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(LocalDateTime dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
