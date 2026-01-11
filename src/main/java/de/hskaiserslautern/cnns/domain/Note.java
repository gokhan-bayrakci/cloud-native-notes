package de.hskaiserslautern.cnns.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "notes")
public class Note {
    @Id
    private String id;
    private String title;
    private String content;
    private LocalDateTime createdAt = LocalDateTime.now();
}