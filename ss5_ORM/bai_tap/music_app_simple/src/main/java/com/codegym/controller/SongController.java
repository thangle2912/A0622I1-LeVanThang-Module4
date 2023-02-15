package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/music")
public class SongController {
    @Autowired
    ISongService songService;
    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("songList",songService.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("song", new Song());
        return "create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Song song, RedirectAttributes attributes){
        songService.save(song);
        attributes.addFlashAttribute("mess","Tạo mới thành công");
        return "redirect:/music/list";
    }

    @GetMapping("/update")
    public String showFormUpdate(@RequestParam int id , Model model){
        model.addAttribute("song",new Song());
        Song songUpdate = new Song();
        List<Song> productList = songService.findAll();
        for(Song product: productList){
            if (product.getId()==id){
                songUpdate=product;
            }
        }
        model.addAttribute("song", songUpdate);
        return "update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Song song,RedirectAttributes attributes){
        if (songService.update(song)){
            attributes.addFlashAttribute("mess","Chỉnh sửa thành công");
        }else {
            attributes.addFlashAttribute("mess","Chỉnh sửa thất bại");
        }
        return "redirect:/music/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes attributes){
        Song songDelete = songService.findById(id);
        songService.remove(songDelete);
        return "redirect:/music/list";
    }
}
