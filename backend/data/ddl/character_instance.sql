CREATE TABLE IF NOT EXISTS public.character_instance (
    character_instance_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    encounter_id INT REFERENCES public.encounter, 
    template_id INT REFERENCES public.character_template,
    created_at timestamp,
    updated_at timestamp
);
