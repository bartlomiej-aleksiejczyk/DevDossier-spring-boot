package com.example.devdossier.models.tag;

import com.example.devdossier.models.base.BaseEntity;
import com.example.devdossier.models.base.NamedDescriptedEntity;
import com.example.devdossier.models.entry.Entry;
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
