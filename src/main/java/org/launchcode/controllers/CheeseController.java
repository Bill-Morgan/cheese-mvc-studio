package org.launchcode.controllers;

import org.launchcode.models.Cheese;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

/**
 * Created by LaunchCode
 */

@Controller
@RequestMapping(value = "cheese")
public class CheeseController {

    static ArrayList<Cheese> cheeses = new ArrayList<>();

    // Request path: cheese/
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }

    // Request path: cheese/add
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {

        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    // Request path: cheese/add
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDesc) {

        Cheese cheese = new Cheese(cheeseName, cheeseDesc);
        cheeses.add(cheese);

        // Redirect to cheese/
        return "redirect:";
    }

    // Request path: cheese/remove
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "Remove Cheese");
        return "cheese/remove";
    }

    // Request path: cheese/remove
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam ArrayList<String> cheeseNames) {

        for (String cheeseName : cheeseNames) {
            cheeses.remove(cheeseName);
        }

        // Redirect to cheese/
        return "redirect:";
    }
}
