package de.hskaiserslautern.cnns.controller;

import de.hskaiserslautern.cnns.domain.Note;
import de.hskaiserslautern.cnns.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;

@Controller
public class WebController {

    @Autowired(required = false)
    private NoteRepository noteRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newNote", new Note()); 
        
        if (noteRepository != null) {
            model.addAttribute("notes", noteRepository.findAll());
        } else {
            model.addAttribute("notes", new ArrayList<>());
        }
        
        return "index"; 
    }
}