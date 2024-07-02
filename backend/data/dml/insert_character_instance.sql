INSERT INTO public.character_instance
( encounter_id_fk, template_id_fk, current_health, 
instance_character_type, instance_player_type, created_at, updated_at)
VALUES( <EID>, <TID>, <HLTH>, '<C_TYPE>', '<P_TYPE>', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);