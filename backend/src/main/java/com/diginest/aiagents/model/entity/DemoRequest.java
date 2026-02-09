package com.diginest.aiagents.model.entity;

import jakarta.persistence.*;
import java.time.Instant;

/**
 * Entity for storing demo request form submissions.
 *
 * Table: demo_requests
 * Auto-created by Hibernate ddl-auto: update
 */
@Entity
@Table(name = "demo_requests")
public class DemoRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, length = 20)
    private String phone;

    @Column(nullable = false, length = 200)
    private String company;

    @Column(nullable = false, length = 100)
    private String industry;

    @Column(nullable = false, length = 200)
    private String problem;

    @Column(length = 2000)
    private String details;

    @Column(name = "gdpr_consent", nullable = false)
    private boolean gdprConsent;

    @Column(length = 50)
    private String source;

    @Column(length = 5)
    private String locale;

    @Column(name = "ip_address", length = 45)
    private String ipAddress;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "processed")
    private boolean processed = false;

    @Column(name = "processed_at")
    private Instant processedAt;

    @Column(length = 500)
    private String notes;

    // Constructors
    public DemoRequest() {
    }

    public DemoRequest(String name, String email, String phone, String company,
                       String industry, String problem, String details,
                       boolean gdprConsent, String source, String locale, String ipAddress) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.company = company;
        this.industry = industry;
        this.problem = problem;
        this.details = details;
        this.gdprConsent = gdprConsent;
        this.source = source;
        this.locale = locale;
        this.ipAddress = ipAddress;
        this.createdAt = Instant.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getIndustry() { return industry; }
    public void setIndustry(String industry) { this.industry = industry; }

    public String getProblem() { return problem; }
    public void setProblem(String problem) { this.problem = problem; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }

    public boolean isGdprConsent() { return gdprConsent; }
    public void setGdprConsent(boolean gdprConsent) { this.gdprConsent = gdprConsent; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public String getLocale() { return locale; }
    public void setLocale(String locale) { this.locale = locale; }

    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public boolean isProcessed() { return processed; }
    public void setProcessed(boolean processed) { this.processed = processed; }

    public Instant getProcessedAt() { return processedAt; }
    public void setProcessedAt(Instant processedAt) { this.processedAt = processedAt; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    @PrePersist
    protected void onCreate() {
        if (createdAt == null) {
            createdAt = Instant.now();
        }
    }
}
