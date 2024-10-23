package com.example;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class NoteService {
    private final List<Note> notes = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public NoteService() {
        add(new Note() {{
            setId(counter.incrementAndGet());
            setTitle("First Note");
            setContent("This is the content of the first note.");
        }});
        add(new Note() {{
            setId(counter.incrementAndGet());
            setTitle("Second Note");
            setContent("This is the content of the second note.");
        }});
    }

    public List<Note> listAll() {
        return new ArrayList<>(notes);
    }

    public Note add(Note note) {
        note.setId(counter.incrementAndGet());
        notes.add(note);
        return note;
    }

    public void deleteById(long id) {
        Note note = getById(id);
        if (note != null) {
            notes.remove(note);
        } else {
            throw new RuntimeException("Note not found");
        }
    }

    public void update(Note note) {
        Note existingNote = getById(note.getId());
        if (existingNote != null) {
            existingNote.setTitle(note.getTitle());
            existingNote.setContent(note.getContent());
        } else {
            throw new RuntimeException("Note not found");
        }
    }

    public Note getById(long id) {
        return notes.stream().filter(note -> note.getId() == id).findFirst().orElse(null);
    }
}
