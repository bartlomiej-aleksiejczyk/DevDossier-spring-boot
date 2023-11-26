package com.example.devdossier.comment;

import com.example.devdossier.attachment.Attachment;
import com.example.devdossier.entry.Entry;
import com.example.devdossier.shared.models.NamedDescriptedEntity;
import com.example.devdossier.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "comments")
public class Comment extends NamedDescriptedEntity {
    private String body;
    @OneToOne
    private Attachment attachment;
    @ManyToOne
    private User createdBy;
    @ManyToOne
    private Entry entry;
}
