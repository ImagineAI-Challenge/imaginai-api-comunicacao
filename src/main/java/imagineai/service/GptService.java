package imagineai.service;

import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import imagineai.config.OpenAIConfig;
import imagineai.dto.PromptDTO;
import imagineai.dto.PromptRespostaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GptService {

    public PromptRespostaDTO getOpenAiResponse(PromptDTO prompt){

        OpenAiService service = OpenAIConfig.getInstance();

        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(prompt.prompt())
                .model("text-davinci-003")
                .echo(true)
                .maxTokens(prompt.maxTokens())
                .build();

        String text = service.createCompletion(completionRequest).getChoices().get(0).getText();
        return new PromptRespostaDTO(text.replace(prompt.prompt()+"\n\n", ""));
    }

}
