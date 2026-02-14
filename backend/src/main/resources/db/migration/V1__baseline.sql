-- =============================================================================
-- V1__baseline.sql
-- Baseline migration: captures existing schema created by Hibernate ddl-auto.
-- Tables: contact_requests, demo_requests
-- =============================================================================

CREATE TABLE IF NOT EXISTS contact_requests (
    id              BIGSERIAL       PRIMARY KEY,
    name            VARCHAR(100)    NOT NULL,
    email           VARCHAR(255)    NOT NULL,
    company         VARCHAR(200),
    phone           VARCHAR(20),
    message         VARCHAR(2000)   NOT NULL,
    source          VARCHAR(50),
    locale          VARCHAR(5),
    ip_address      VARCHAR(45),
    created_at      TIMESTAMP WITH TIME ZONE NOT NULL,
    processed       BOOLEAN         DEFAULT FALSE,
    processed_at    TIMESTAMP WITH TIME ZONE,
    notes           VARCHAR(500)
);

CREATE TABLE IF NOT EXISTS demo_requests (
    id              BIGSERIAL       PRIMARY KEY,
    name            VARCHAR(100)    NOT NULL,
    email           VARCHAR(255)    NOT NULL,
    phone           VARCHAR(20)     NOT NULL,
    company         VARCHAR(200)    NOT NULL,
    industry        VARCHAR(100)    NOT NULL,
    problem         VARCHAR(200)    NOT NULL,
    details         VARCHAR(2000),
    gdpr_consent    BOOLEAN         NOT NULL,
    source          VARCHAR(50),
    locale          VARCHAR(5),
    ip_address      VARCHAR(45),
    created_at      TIMESTAMP WITH TIME ZONE NOT NULL,
    processed       BOOLEAN         DEFAULT FALSE,
    processed_at    TIMESTAMP WITH TIME ZONE,
    notes           VARCHAR(500)
);

-- Indexes for common queries
CREATE INDEX IF NOT EXISTS idx_contact_requests_processed ON contact_requests (processed);
CREATE INDEX IF NOT EXISTS idx_contact_requests_email ON contact_requests (email);
CREATE INDEX IF NOT EXISTS idx_contact_requests_created_at ON contact_requests (created_at);
CREATE INDEX IF NOT EXISTS idx_contact_requests_ip_created ON contact_requests (ip_address, created_at);

CREATE INDEX IF NOT EXISTS idx_demo_requests_processed ON demo_requests (processed);
CREATE INDEX IF NOT EXISTS idx_demo_requests_email ON demo_requests (email);
CREATE INDEX IF NOT EXISTS idx_demo_requests_created_at ON demo_requests (created_at);
CREATE INDEX IF NOT EXISTS idx_demo_requests_ip_created ON demo_requests (ip_address, created_at);
