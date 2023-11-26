package com.example.devdossier.attachment;

import com.example.devdossier.shared.models.BaseEntity;
import com.example.devdossier.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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
@Table(name = "attachments")
public class Attachment extends BaseEntity {
    String filePath;
    String type;
    @ManyToOne
    User createdBy;
}
