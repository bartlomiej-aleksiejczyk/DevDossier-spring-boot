package com.example.devdossier.attachment;

import com.example.devdossier.attachment.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
}