package controllers;

import entity.Bag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import services.BagServices;

import java.util.List;

@Controller
public class BagController
{
    @Autowired
    private BagServices service;

    @GetMapping("/")
    public String HomePage(Model model){
        List<Bag> listBags = service.listAll();   // type Bag list? with name listBags = list(show) all
        model.addAttribute("listBags", listBags);
        return "index";
    }

    @GetMapping("/add")
    public String AddBag(Model model){           // add new bag
        Bag bag = new Bag();
        model.addAttribute("bag", bag);
        return "added_bag";
    }

    @PostMapping("/add")
    public String SaveBag(@ModelAttribute("bag") Bag bag){   // save changes to some bag
        service.save(bag);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public ModelAndView UpdateForm(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("updated_bag");
        Bag bag = service.get(id);
        mav.addObject("bag", bag);

        return mav;
    }

    @GetMapping("/delete/{id}")
    public String DeleteBag(@PathVariable(name = "id") int id){
        service.delete(id);
        return "redirect:/";
    }
}
