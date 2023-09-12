package imagineai.dto;

public record PromptDTO(
        String prompt,
        Integer maxTokens
) {
}
