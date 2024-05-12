CREATE TABLE IF NOT EXISTS public.character_template (
    template_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    total_health INT,
    created_at timestamp,
    updated_at timestamp
);
