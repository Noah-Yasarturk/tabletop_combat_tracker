CREATE TABLE IF NOT EXISTS public.character_instance (
    character_instance_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    encounter_id_fk INT REFERENCES public.encounter (encounter_id), 
    template_id_fk INT REFERENCES public.character_template (template_id),
    current_health INT,
    instance_character_type VARCHAR(100),
    instance_player_type VARCHAR(100),
    created_at timestamp,
    updated_at timestamp
);
