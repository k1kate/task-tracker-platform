CREATE TABLE organization (
      id SERIAL PRIMARY KEY,
      name VARCHAR(255) NOT NULL,
      setup_complete BOOLEAN NOT NULL DEFAULT FALSE,
      created_at TIMESTAMP DEFAULT NOW(),
      updated_at TIMESTAMP DEFAULT NOW()
);