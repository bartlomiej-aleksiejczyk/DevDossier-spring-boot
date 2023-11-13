package com.example.devdossier.models.app;

import com.example.devdossier.models.base.BaseEntity;
import com.example.devdossier.models.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "apps")
public class App extends BaseEntity {
    private String description;
    private String repoLink;
    @ManyToOne
    private User createdBy;
}
