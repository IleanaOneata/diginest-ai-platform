package com.diginest.aiagents.repository;

import com.diginest.aiagents.model.entity.ContactRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

/**
 * Repository for ContactRequest entities.
 */
@Repository
public interface ContactRepository extends JpaRepository<ContactRequest, Long> {

    /**
     * Find all unprocessed contact requests.
     */
    List<ContactRequest> findByProcessedFalseOrderByCreatedAtDesc();

    /**
     * Find contact requests by email.
     */
    List<ContactRequest> findByEmailOrderByCreatedAtDesc(String email);

    /**
     * Find contact requests created after a specific time.
     */
    List<ContactRequest> findByCreatedAtAfterOrderByCreatedAtDesc(Instant after);

    /**
     * Count contact requests from a specific IP in the last hour.
     * Used for additional rate limiting validation.
     */
    long countByIpAddressAndCreatedAtAfter(String ipAddress, Instant after);
}
