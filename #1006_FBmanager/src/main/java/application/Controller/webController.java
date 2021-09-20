package application.Controller;

import application.Poster.Posting;
import application.Poster.Values;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class webController {

    @Autowired
    Posting toPost;

    @GetMapping(value= {"/", "home"})
    public String main(Model model) {

        return "home";
    }

    @GetMapping("/poster")
    public String posterForm(Values values){
        return "poster";
    }

    @PostMapping("/poster")
    public String posterProcessor(Values values) throws Exception {
        toPost.init(values);
        return "poster";
    }

    @GetMapping("/renamer")
    public String renamer(){
        return "renamer";
    }

    @GetMapping("/faq")
    public String help(){
        return "faq";
    }
}
