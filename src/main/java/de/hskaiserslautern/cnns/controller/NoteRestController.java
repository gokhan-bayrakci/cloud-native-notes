package de.hskaiserslautern.cnns.controller;

import de.hskaiserslautern.cnns.domain.Note;
import de.hskaiserslautern.cnns.service.NoteService;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteRestController {
    private final NoteService noteService;

    public NoteRestController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    @Operation(summary = "Alle Notizen abrufen")
    public List<Note> getAll() { return noteService.getAllNotes(); }

    @PostMapping
    @Operation(summary = "Neue Notiz erstellen")
    public Note create(@RequestBody Note note) { return noteService.saveNote(note); }

    @DeleteMapping("/{id}")
    @Operation(summary = "Notiz löschen")
    public ResponseEntity<String> delete(@PathVariable String id) {
        List<Note> allNotes = noteService.getAllNotes();
        boolean idExists = allNotes.stream().anyMatch(n -> n.getId().equals(id));

        if (!idExists) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Fehler: Eine Notiz mit der ID '" + id + "' wurde nicht gefunden. Löschen fehlgeschlagen.");
        }

        noteService.deleteNote(id);
        return ResponseEntity.ok("Die Notiz wurde erfolgreich gelöscht.");
    }
}
