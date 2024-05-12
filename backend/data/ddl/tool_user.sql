CREATE TABLE IF NOT EXISTS public.tool_user (
    user_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    role_id INT REFERENCES public.user_role,
    user_name VARCHAR(255),
    created_at timestamp,
    updated_at timestamp
);
