package com.example.fullstack_musik_spring_db.Controller;
import com.example.fullstack_musik_spring_db.Model.Album;
import org.springframework.ui.Model;
import com.example.fullstack_musik_spring_db.Service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@Controller
public class HomeController {

    @Autowired
    AlbumService albumService;

    @GetMapping("/")
    public String index(Model model) throws SQLException {
        model.addAttribute("albums", albumService.get_All_Albums());
        return "home/index";
    }

    @GetMapping("/create")
    public String create(){
        return "home/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Album a){
        albumService.addAlbum(a);
        return "redirect:/";
    }
}
