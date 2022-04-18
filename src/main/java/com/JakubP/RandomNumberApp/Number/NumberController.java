package com.JakubP.RandomNumberApp.Number;

import com.JakubP.RandomNumberApp.logic.ChatBot;
import com.JakubP.RandomNumberApp.logic.Generator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/*")
public class NumberController {
    @GetMapping
    String showNumber(Model model) throws IOException {
        ChatBot bot = ChatBot.getBot();
        var RN = new NumberModel();
        RN.setValue(Generator.getRandomNumber(RN.low, RN.high, bot.getNumberFromMsg()).toString());
        model.addAttribute("RandNum", RN);
        return "RNG";
    }

}
