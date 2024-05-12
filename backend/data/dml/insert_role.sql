-- Create admin role
INSERT INTO public.user_role 
(role_name, created_at, updated_at) 
VALUES 
('admin', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);