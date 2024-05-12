CREATE TABLE IF NOT EXISTS public.encounter (
    encounter_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_id INT REFERENCES tool_user,
    encounter_name VARCHAR(255),
    created_at timestamp,
    updated_at timestamp
);
