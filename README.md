## URLs relevantes
- ~[Vídeo de explicação do projeto em geral](https://www.youtube.com/watch?v=wf3xPOcDF8E) (Sprint 03)~
- [Video com uma explicação breve do projeto bem como demonstração do funcionamento](https://www.youtube.com/watch?v=8rPGuNSa_C8) (Sprint 04)
- [Projeto de IA geradora de mapas](https://github.com/ImagineAI-Challenge/imaginai-api-MagGen-IA-App)
- [Frontend em react-native](https://github.com/ImagineAI-Challenge/imaginai-front)

# imaginai-api-comunicacao

Para testar a integração com o GPT, primeiro é necessário configurar a sua API_KEY
no arquivo `config.properties` no diretório `src/main/resources/`. Substitua `<API_KEY>`
pela sua chave de API. Você pode obter a sua [aqui](https://platform.openai.com/account/api-keys).
Lembre-se de conferir se voce tem saldo disponível para fazer as requisições [aqui](https://platform.openai.com/account/usage).

```properties
api.key=<API_KEY>
```
Para se conectar no projeto, é necessário criar uma imagem docker com os comandos:

```bash
docker pull mongo:4.4
docker run -d -p 27017:27017 -e AUTH=no --name banco_mongodb mongo:4.4
```
## Sprint 04 - Resumo geral

No planejamento que fizemos na sprint 03, a arquitetura geral do projeto seria a da imagem abaixo. Acabou  que não integreamos a API geradora de imagens ao projeto. É uma funcionalidade dificil de se implementar e não conseguimos entregá-la nessa sprint.

![image](https://github.com/ImagineAI-Challenge/imaginai-api-comunicacao/assets/101985616/636ab555-22e9-4079-b4ef-a9f1b12dd7d5)

### Criação de personagem

De novidade nessa sprint nós temos, principalmente, o endpoint de criação de personagem. Ele reebe o nome, raca e classe e monta uma requisição para o GPT pedindo que faça uma história para esse personagem. Essa história é colocada na entidade e guardada no banco. Sendo possível consulta-la posteriormente.

**Endpoint**

`POST`/gpt/personagem

**Corpo da requisição**

```json
{
  "nome": "Fulano",
  "raca": "Humano",
  "classe": "Guerreiro"
}
```
**Resposta**

```json
{
  "nome": "Fulano",
  "raca": "Humano",
  "classe": "Guerreiro",
  "historiaPersonagem": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vitae nisl euismod, aliquam nisl quis, ultricies nisl. Sed vitae nisl euismod, aliquam nisl quis, ultricies nisl. Sed vitae nisl euismod, aliquam nisl quis, ultricies nisl. Sed vitae nisl euismod, aliquam nisl quis, ultricies nisl. Sed vitae nisl euismod, aliquam nisl quis, ultricies nisl.",
  "id":"23K5B235LJV23"
}
```

## Sobre a API

A API foi desenvolvida utilizando o framework Spring Boot, com o banco de dados MongoDB. O propósito
dela é servir como um intermediário entre o GPT-3, o frontend e o banco - daí seu nome: comunicação.
A API recebe uma requisição com o texto da mensagem e retorna a resposta do GPT-3. Além disso,
ela também salvará as mensagens, bem como personagens, histórias e usuários no banco de dados.

É importante saber que ela ainda está muito crua, então não possui muitas validações e não está
muito bem organizada. Porém, ela já está funcional e pode ser utilizada para testes e avanço de outros
projetos que dependem dela em certos locais, como o frontend.

Em breve, a API será melhorada e terá mais funcionalidades, como a possibilidade de criar histórias
e personagens pelo frontend, além de um sistema de login e autenticação.

No momento, a API possui um endpoint principal:

### POST /gpt/prompt

Esse endpoint é responsável por receber um JSON com o texto da mensagem e retornar um JSON com a resposta do GPT-3.

| Parâmetro | Tipo    | Descrição                                         |
|-----------|---------|---------------------------------------------------|
| prompt    | String  | Texto da mensagem                                 |
| maxTokens | Integer | Número máximo de tokens que o GPT-3 pode retornar |
Exemplo de requisição:
```json
{
  "prompt": "Faça uma piada",
  "maxTokens": 100
}
```

Exemplo de resposta:
```json
{
  "gptResponse": "Faça uma piada\n\nQual é o peixe favorito do Barba Azul?\nA pesca-mulher!"
}
```

## CRUD básico

A API também possui um CRUD básico para as entidades. Eles seguem o mesmo padrão, então
aqui está uma tabela com os endpoints e métodos para algumas das entidades:

### Personagem
| Método | Endpoint          | Descrição                                   |
|--------|-------------------|---------------------------------------------|
| GET    | /personagens      | Retorna todos os personagens                |
| GET    | /personagens/{id} | Retorna o personagem com o id especificado  |
| POST   | /personagens      | Cria um novo personagem                     |
| PUT    | /personagens/{id} | Atualiza o personagem com o id especificado |
| DELETE | /personagens/{id} | Deleta o personagem com o id especificado   |

Exemplo de JSON de um personagem:
```json
{
  "nome": "Barba Azul",
  "historiaPersonagem": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vitae nisl euismod, aliquam nisl quis, ultricies nisl. Sed vitae nisl euismod, aliquam nisl quis, ultricies nisl. Sed vitae nisl euismod, aliquam nisl quis, ultricies nisl. Sed vitae nisl euismod, aliquam nisl quis, ultricies nisl. Sed vitae nisl euismod, aliquam nisl quis, ultricies nisl.",
  "imagemPersonagem": "https://i.imgur.com/3Z0Qj5u.png",
  "historia": "id da história"
}
```

Além dos campos acima, um personagem possui também um ID que é gerado pelo banco de dados e estará incluso em retornos diferentes do de criação.

### Usuário
| Método | Endpoint       | Descrição                                |
|--------|----------------|------------------------------------------|
| GET    | /usuarios      | Retorna todos os usuários                |
| GET    | /usuarios/{id} | Retorna o usuário com o id especificado  |
| POST   | /usuarios      | Cria um novo usuário                     |
| PUT    | /usuarios/{id} | Atualiza o usuário com o id especificado |
| DELETE | /usuarios/{id} | Deleta o usuário com o id especificado   |

Exemplo de JSON de um usuário:
```json
{
  "email": "exemplo@exemplo.com",
  "senha": "12345678"
}
```

Além dos campos acima, um usuário possui também um ID que é gerado pelo banco de dados e estará incluso em retornos diferentes do de criação.
