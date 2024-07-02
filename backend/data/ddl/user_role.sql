CREATE TABLE IF NOT EXISTS public.user_role (
    role_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    role_name VARCHAR(255),
    created_at timestamp,
    updated_at timestamp
);
