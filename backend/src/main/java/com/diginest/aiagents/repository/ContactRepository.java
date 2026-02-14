package com.diginest.aiagents.repository;

import com.diginest.aiagents.model.entity.ContactRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    /**
     * Anonymize IP addresses older than cutoff date (GDPR compliance).
     * Sets ipAddress to 'anonymized' for records older than the given date.
     */
    @Modifying
    @Query("UPDATE ContactRequest c SET c.ipAddress = 'anonymized' WHERE c.createdAt < :cutoff AND c.ipAddress <> 'anonymized'")
    int anonymizeOldIpAddresses(@Param("cutoff") Instant cutoff);
}
