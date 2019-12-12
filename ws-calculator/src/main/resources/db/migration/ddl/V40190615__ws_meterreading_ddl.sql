DROP TABLE IF EXISTS meterreading;
CREATE TABLE meterreading
(
  id character varying(64),
  connectionNo character varying(64),
  billingPeriod character varying(64) NOT NULL,
  meterStatus character varying(64) NOT NULL,
  lastReading int NOT NULL,
  lastReadingDate bigint NOT NULL,
  currentReading int NOT NULL,
  currentReadingDate bigint NOT NULL,
  CONSTRAINT uk_meterreading UNIQUE (id)
);