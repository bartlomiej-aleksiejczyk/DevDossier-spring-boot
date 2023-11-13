package com.example.devdossier.models.comment;

import com.example.devdossier.models.attachment.Attachment;
import com.example.devdossier.models.entry.Entry;
import com.example.devdossier.models.base.NamedDescriptedEntity;
import com.example.devdossier.models.user.User;
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
