package org.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.project.backend.model.Inquiry;
import org.springframework.stereotype.Repository;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
}