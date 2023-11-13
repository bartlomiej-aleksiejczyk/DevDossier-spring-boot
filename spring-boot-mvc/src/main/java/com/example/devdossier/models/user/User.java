package com.example.devdossier.models.user;

import com.example.devdossier.models.base.NamedDescriptedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "users")
public class User extends NamedDescriptedEntity {
    LocalDateTime lastLogin;
}
