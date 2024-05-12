CREATE TABLE IF NOT EXISTS public.instance_stat (
    instance_stat_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    instance_stat_name VARCHAR(255),
    instance_stat_value INT, 
    instance_stat_modifier VARCHAR(100),
    created_at timestamp,
    updated_at timestamp
);
