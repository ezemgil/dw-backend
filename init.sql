CREATE TABLE words (
  id SERIAL PRIMARY KEY,
  word VARCHAR(255) NOT NULL,
  gender VARCHAR(3),
  plural VARCHAR(255),
  word_type VARCHAR(255),
  hint VARCHAR(255),
  category VARCHAR(255),
  cefr_level VARCHAR(255),
  menschen_unit INTEGER,
  image_query VARCHAR(255),
  audio_query VARCHAR(255),
  is_active BOOLEAN DEFAULT TRUE,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

COPY words (id, word, gender, plural, word_type, hint, category, cefr_level, menschen_unit, image_query, audio_query, is_active, created_at, updated_at)
FROM '/docker/wortliste.csv'
WITH (FORMAT csv, DELIMITER ';', HEADER true, ENCODING 'UTF8');

UPDATE words
SET created_at = COALESCE(created_at, CURRENT_TIMESTAMP),
    updated_at = COALESCE(updated_at, CURRENT_TIMESTAMP),
    is_active = COALESCE(is_active, true)
WHERE created_at IS NULL OR updated_at IS NULL OR is_active IS NULL;