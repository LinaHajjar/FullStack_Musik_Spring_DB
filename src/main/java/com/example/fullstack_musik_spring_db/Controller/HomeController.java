package com.example.fullstack_musik_spring_db.Controller;
import com.example.fullstack_musik_spring_db.Model.Album;
import org.springframework.ui.Model;
import com.example.fullstack_musik_spring_db.Service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/viewAlbum/{id}")
    public String viewAlbum(@PathVariable("id") int id, Model model)throws SQLException{
        model.addAttribute("album", albumService.findAlbumById(id));
        return "home/viewAlbum";
    }

    @GetMapping("/deleteAlbum/{id}")
    public String deleteAlbum(@PathVariable("id") int id)throws SQLException {
        boolean deleted = albumService.deleteAlbum(id);
        return "redirect:/";
    }

    @GetMapping("/updateAlbum/{id}")
    public String updateAlbum(@PathVariable("id") int id, Model model)throws SQLException {
        model.addAttribute("album", albumService.findAlbumById(id));
        return "home/updateAlbum";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Album album) throws SQLException {
        //album.setId(id);
        albumService.updateAlbum(album);
        return "redirect:/";
    }
}
