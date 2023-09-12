package imagineai.controller;

import imagineai.dto.PromptDTO;
import imagineai.dto.PromptRespostaDTO;
import imagineai.service.GptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gpt")
public class GptController {

    @Autowired
    public GptService gptService;

    @PostMapping("/prompt")
    public PromptRespostaDTO prompt(@RequestBody PromptDTO prompt){
        return gptService.getOpenAiResponse(prompt);
    }
}
