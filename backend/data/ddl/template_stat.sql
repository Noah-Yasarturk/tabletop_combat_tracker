CREATE TABLE IF NOT EXISTS public.template_stat (
    template_stat_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    template_id_fk INT REFERENCES public.character_template (template_id),
    template_stat_name VARCHAR(255),
    template_stat_value INT, 
    template_stat_modifier VARCHAR(100),
    created_at timestamp,
    updated_at timestamp
);
