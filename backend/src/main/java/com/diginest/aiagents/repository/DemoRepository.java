package com.diginest.aiagents.repository;

import com.diginest.aiagents.model.entity.DemoRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

/**
 * Repository for DemoRequest entities.
 */
@Repository
public interface DemoRepository extends JpaRepository<DemoRequest, Long> {

    /**
     * Find all unprocessed demo requests.
     */
    List<DemoRequest> findByProcessedFalseOrderByCreatedAtDesc();

    /**
     * Find demo requests by email.
     */
    List<DemoRequest> findByEmailOrderByCreatedAtDesc(String email);

    /**
     * Count demo requests from a specific IP in the last hour.
     */
    long countByIpAddressAndCreatedAtAfter(String ipAddress, Instant after);

    /**
     * Anonymize IP addresses older than cutoff date (GDPR compliance).
     */
    @Modifying
    @Query("UPDATE DemoRequest d SET d.ipAddress = 'anonymized' WHERE d.createdAt < :cutoff AND d.ipAddress <> 'anonymized'")
    int anonymizeOldIpAddresses(@Param("cutoff") Instant cutoff);
}
