-- =====================================================
-- SCHEMA
-- =====================================================

CREATE SCHEMA IF NOT EXISTS financas;

-- =====================================================
-- TABELA: user_account
-- =====================================================

CREATE TABLE IF NOT EXISTS financas.user_account (
    id_user BIGINT GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(255) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NULL,

    CONSTRAINT pk_user_account
        PRIMARY KEY (id_user),
    CONSTRAINT check_updated_at
    	CHECK (updated_at > created_at)
);

-- =====================================================
-- TABELA: occurrence
-- =====================================================

CREATE TABLE IF NOT EXISTS financas.occurrence (
    id_occurrence BIGINT GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(50) NOT NULL,
    recurrence BOOLEAN NOT NULL DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NULL,
    CONSTRAINT pk_occurrence
        PRIMARY KEY (id_occurrence),
    CONSTRAINT uk_occurrence
        UNIQUE (name),
    CONSTRAINT chk_updated_at
    	CHECK (updated_at > created_at)

);

-- =====================================================
-- TABELA: payment_event
-- =====================================================

CREATE TABLE IF NOT EXISTS financas.payment_event (
    id_event BIGINT GENERATED ALWAYS AS IDENTITY,
    id_user BIGINT NOT NULL,
    id_occurrence BIGINT NOT NULL,
    amount NUMERIC(15,2) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NULL,
    CONSTRAINT pk_payment_event
        PRIMARY KEY (id_event),
    CONSTRAINT fk_event_user
        FOREIGN KEY (id_user)
        REFERENCES financas.user_account (id_user),
    CONSTRAINT fk_event_occurrence
        FOREIGN KEY (id_occurrence)
        REFERENCES financas.occurrence (id_occurrence)
);

-- =====================================================
-- ÍNDICES
-- =====================================================

CREATE INDEX idx_payment_event_id_user
    ON financas.payment_event (id_user);

CREATE INDEX idx_payment_event_id_occurrence
    ON financas.payment_event (id_occurrence);

CREATE INDEX idx_payment_event_created_at
    ON financas.payment_event (created_at);