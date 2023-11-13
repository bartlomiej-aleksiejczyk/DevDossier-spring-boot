package com.example.devdossier.repositories;

import com.example.devdossier.models.attachment.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
}