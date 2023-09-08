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
