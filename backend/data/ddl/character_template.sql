CREATE TABLE IF NOT EXISTS public.character_template (
    template_stat_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    total_health INT,
    template_stat_1 INT REFERENCES template_stat  (template_stat_id),
    template_stat_2 INT REFERENCES template_stat  (template_stat_id),
    template_stat_3 INT REFERENCES template_stat  (template_stat_id),
    template_stat_4 INT REFERENCES template_stat  (template_stat_id),
    template_stat_5 INT REFERENCES template_stat  (template_stat_id),
    template_stat_6 INT REFERENCES template_stat  (template_stat_id),
    created_at timestamp,
    updated_at timestamp
);
