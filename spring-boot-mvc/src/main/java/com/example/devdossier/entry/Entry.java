package com.example.devdossier.entry;

import com.example.devdossier.entry.enums.EntryType;
import com.example.devdossier.shared.models.NamedDescriptedEntity;
import com.example.devdossier.entry.enums.EntryPriority;
import com.example.devdossier.entry.enums.EntryStatus;
import com.example.devdossier.app.App;
import com.example.devdossier.user.User;
import com.example.devdossier.tag.Tag;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "entries")
public class Entry extends NamedDescriptedEntity {
    @Enumerated(EnumType.STRING)
    private EntryType type;
    @ManyToOne
    private User createdBy;
    @Enumerated(EnumType.STRING)
    private EntryStatus status;
    @Enumerated(EnumType.STRING)
    private EntryPriority priority;
    @ManyToOne
    private App app;
    @ManyToMany(mappedBy = "entries")
    private Set<Tag> tags;
}
