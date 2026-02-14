package com.diginest.aiagents.config;

import com.diginest.aiagents.repository.ContactRepository;
import com.diginest.aiagents.repository.DemoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * GDPR compliance: scheduled task to anonymize IP addresses older than 90 days.
 *
 * IP addresses are personal data under GDPR (Art. 4(1)).
 * This task runs daily at 3:00 AM and replaces old IPs with 'anonymized'.
 * The 90-day retention period is aligned with our Privacy Policy.
 */
@Component
public class GdprCleanupTask {

    private static final Logger log = LoggerFactory.getLogger(GdprCleanupTask.class);
    private static final int RETENTION_DAYS = 90;

    private final ContactRepository contactRepository;
    private final DemoRepository demoRepository;

    public GdprCleanupTask(ContactRepository contactRepository, DemoRepository demoRepository) {
        this.contactRepository = contactRepository;
        this.demoRepository = demoRepository;
    }

    /**
     * Anonymize IP addresses older than 90 days.
     * Runs daily at 03:00 UTC (low-traffic period).
     */
    @Scheduled(cron = "0 0 3 * * *") // Every day at 3:00 AM
    @Transactional
    public void anonymizeOldIpAddresses() {
        Instant cutoff = Instant.now().minus(RETENTION_DAYS, ChronoUnit.DAYS);

        int contactCount = contactRepository.anonymizeOldIpAddresses(cutoff);
        int demoCount = demoRepository.anonymizeOldIpAddresses(cutoff);

        if (contactCount > 0 || demoCount > 0) {
            log.info("GDPR IP cleanup: anonymized {} contact + {} demo records older than {} days",
                contactCount, demoCount, RETENTION_DAYS);
        }
    }
}
