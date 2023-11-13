package com.example.devdossier.models.base;

import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NamedDescriptedEntity extends BaseEntity {
    String name;

    String description;
}
