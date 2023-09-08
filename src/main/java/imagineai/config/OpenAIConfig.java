package imagineai.config;

import com.theokanning.openai.service.OpenAiService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class OpenAIConfig {
    private static OpenAiService instance;
    private final static String API_KEY = loadApiKeyFromConfigFile();

    public static OpenAiService getInstance(){
        if(instance == null){
            instance = new OpenAiService(API_KEY);
        }
        return instance;
    }

    private static String loadApiKeyFromConfigFile() {
        Properties properties = new Properties();
        try (InputStream configFile = OpenAIConfig.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (configFile == null) {
                throw new FileNotFoundException("Arquivo de configuração 'config.properties' não encontrado");
            }
            properties.load(configFile);
            return properties.getProperty("api.key");
        } catch (IOException e) {
            throw new RuntimeException("Falha ao ler a chave da API do arquivo de configuração", e);
        }
    }

}
