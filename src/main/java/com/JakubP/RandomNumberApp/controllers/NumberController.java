package com.JakubP.RandomNumberApp.controllers;

import com.JakubP.RandomNumberApp.models.NumberModel;
import com.JakubP.RandomNumberApp.services.ChatBotService;
import com.JakubP.RandomNumberApp.services.GeneratorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/*")
public class NumberController {
    private final ChatBotService bot;
    private final GeneratorService gen;

    public NumberController(ChatBotService bot, GeneratorService gen){
        this.bot = bot;
        this.gen = gen;
    }

    @GetMapping
    String showNumber(Model model) throws IOException {
        var RN = new NumberModel();
        RN.setValue(gen.getRandomNumber(RN.low, RN.high, bot.getNumberFromMsg()).toString());
        model.addAttribute("RandNum", RN);
        return "RNG";
    }
}
