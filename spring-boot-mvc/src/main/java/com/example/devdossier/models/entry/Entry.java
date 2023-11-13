package com.example.devdossier.models.entry;

import com.example.devdossier.models.base.NamedDescriptedEntity;
import com.example.devdossier.models.entry.enums.EntryPriority;
import com.example.devdossier.models.entry.enums.EntryStatus;
import com.example.devdossier.models.entry.enums.EntryType;
import com.example.devdossier.models.app.App;
import com.example.devdossier.models.entry.Entry;
import com.example.devdossier.models.tag.Tag;
import com.example.devdossier.models.user.User;
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
