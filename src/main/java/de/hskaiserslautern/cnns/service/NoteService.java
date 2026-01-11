package de.hskaiserslautern.cnns.service;

import de.hskaiserslautern.cnns.domain.Note;
import de.hskaiserslautern.cnns.repository.NoteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAllNotes() { return noteRepository.findAll(); }
    public Note saveNote(Note note) { return noteRepository.save(note); }
    public void deleteNote(String id) { noteRepository.deleteById(id); }
    public Note getNoteById(String id) { 
        return noteRepository.findById(id).orElseThrow(() -> new RuntimeException("Notiz nicht gefunden")); 
    }
}