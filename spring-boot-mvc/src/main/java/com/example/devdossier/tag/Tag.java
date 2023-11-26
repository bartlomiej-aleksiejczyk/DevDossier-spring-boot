package com.example.devdossier.tag;

import com.example.devdossier.entry.Entry;
import com.example.devdossier.shared.models.NamedDescriptedEntity;
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
@Table(name = "tags")
public class Tag extends NamedDescriptedEntity {
    String tagColor;
    @ManyToMany
    @JoinTable(name = "entry_tag", joinColumns = @JoinColumn(name = "tag_id"), inverseJoinColumns = @JoinColumn(name = "entry_id"))
    Set<Entry> entries;
}
