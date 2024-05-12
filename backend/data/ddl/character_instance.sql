CREATE TABLE IF NOT EXISTS public.character_instance (
    character_instance_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    encounter_id INT REFERENCES public.encounter, 
    template_id INT REFERENCES public.character_template,
    instance_stat_1 INT REFERENCES instance_stat  (instance_stat_id),
    instance_stat_2 INT REFERENCES instance_stat  (instance_stat_id),
    instance_stat_3 INT REFERENCES instance_stat  (instance_stat_id),
    instance_stat_4 INT REFERENCES instance_stat  (instance_stat_id),
    instance_stat_5 INT REFERENCES instance_stat  (instance_stat_id),
    instance_stat_6 INT REFERENCES instance_stat  (instance_stat_id),
    created_at timestamp,
    updated_at timestamp
);
