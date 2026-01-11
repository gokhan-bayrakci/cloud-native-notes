package de.hskaiserslautern.cnns.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import de.hskaiserslautern.cnns.domain.Note;
import de.hskaiserslautern.cnns.service.NoteService;

@Controller
@RequestMapping("/web")
public class NoteWebController {
    private final NoteService noteService;

    public NoteWebController(NoteService noteService) { this.noteService = noteService; }

    // Zeigt die Liste und das Formular an
    @GetMapping("/notes")
    public String listNotes(Model model) {
        model.addAttribute("notes", noteService.getAllNotes());
        model.addAttribute("newNote", new Note());
        return "index";
    }

    // Speichert eine neue Notiz aus dem Formular
    @PostMapping("/notes")
    public String addNote(@ModelAttribute Note note) {
        noteService.saveNote(note);
        return "redirect:/web/notes";
    }

    // Löscht eine Notiz über die UI
    @GetMapping("/notes/delete/{id}")
    public String deleteNote(@PathVariable String id) {
        noteService.deleteNote(id);
        return "redirect:/web/notes";
    }
}
