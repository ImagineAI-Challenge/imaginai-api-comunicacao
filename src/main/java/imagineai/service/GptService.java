package imagineai.service;

import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import imagineai.config.OpenAIConfig;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GptService {

    public String getOpenAiResponse(String prompt){

        OpenAiService service = OpenAIConfig.getInstance();

        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(prompt)
                .model("text-davinci-003")
                .echo(true)
                .maxTokens(100)
                .build();

        return service.createCompletion(completionRequest).getChoices().get(0).getText();
    }

}
