package imagineai.controller;

import imagineai.service.GptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gpt")
public class GptController {

    @Autowired
    public GptService gptService;

    @GetMapping("/prompt")
    public String prompt(@RequestBody String prompt){
        return gptService.getOpenAiResponse(prompt);
    }
}
