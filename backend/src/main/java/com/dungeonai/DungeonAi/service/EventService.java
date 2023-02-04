package com.dungeonai.DungeonAi.service;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Random;

@Service
public class EventService {

    private HashMap<Integer, String> prompts = new HashMap<>();

    public String setUpEventDesc(int diceRoll) throws InterruptedException {
        initializeHashMap();
        String token = "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";
        OpenAiService service = new OpenAiService(token);

        System.out.println("\nCreating completion...");
        String prompt = getPrompt(diceRoll);
        System.out.println(prompt);
        String text = "";
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt(prompt)
                .echo(true)
                .user("testing")
                .maxTokens(250)
                .build();
        text = service.createCompletion(completionRequest).getChoices().get(0).getText();
        text = text.replace(prompt + "\n\n", "");
        return text;
    }

    public String getPrompt(int diceRoll) {
        Random rand = new Random();
        if (diceRoll >= 15) {
            return prompts.get(rand.nextInt(1, 5));
        } else if (diceRoll >= 10) {
            return prompts.get(rand.nextInt(5, 9));
        } else if (diceRoll >= 5) {
            return prompts.get(rand.nextInt(9, 13));
        } else {
            return prompts.get(rand.nextInt(13, 17));
        }
    }

    public void initializeHashMap() {
        prompts.put(1, "generate a dungeons and dragons short encounter where you level up and gain 3 skill points.");
        prompts.put(2, "generate a dungeons and dragons short encounter where you regenerate 30 health points.");
        prompts.put(3, "generate a dungeons and dragons short scenario where you gain 100 gold pieces.");
        prompts.put(4, "generate a dungeons and dragons short scenario where you gain 2 attack points.");

        prompts.put(5, "generate a dungeons and dragons short encounter where you gain 1 skill point.");
        prompts.put(6, "generate a dungeons and dragons short encounter where you regenerate 10 health points.");
        prompts.put(7, "generate a dungeons and dragons short scenario where you find 30 gold pieces.");
        prompts.put(8, "generate a dungeons and dragons short scenario where you gain 1 attack point.");

        prompts.put(9, "generate a dungeons and dragons short encounter where you lose 1 skill point.");
        prompts.put(10, "generate a dungeons and dragons short battle where you lose 15 health points.");
        prompts.put(11, "generate a dungeons and dragons short scenario where you lose 50 gold pieces.");
        prompts.put(12, "generate a dungeons and dragons short scenario where you lose 1 attack point.");

        prompts.put(13, "generate a dungeons and dragons short encounter where you lose 3 skill points.");
        prompts.put(14, "generate a dungeons and dragons short dramatic battle where you lose 40 health points.");
        prompts.put(15, "generate a dungeons and dragons short scenario where you lose 130 gold pieces.");
        prompts.put(16, "generate a dungeons and dragons short scenario where you lose 2 attack points.");
    }
}
