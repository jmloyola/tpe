CREATE FUNCTION actualizar_egreso_smi() RETURNS TRIGGER
    AS $$ 
    DECLARE 
	codigo_smi INTEGER;
	egreso_nuevo REAL;

    BEGIN
	    egreso_nuevo = NEW.CantidadUtilizada;
	    codigo_smi = NEW.SM_I_Codigo_EsUtilizada;
	    UPDATE stocksmensualesinsumos SET SM_I_Egreso = SM_I_Egreso + egreso_nuevo  , sm_i_cantidadcalculada = sm_i_cantidadcalculada - egreso_nuevo, sm_i_cantidadreal = sm_i_cantidadreal - egreso_nuevo WHERE SM_I_Codigo = codigo_smi;
	    RETURN NULL;
    END;
    $$
    LANGUAGE plpgsql;

CREATE TRIGGER nuevo_insumo_utilizado_trigger
	AFTER INSERT ON EsUtilizada
	FOR EACH ROW EXECUTE PROCEDURE actualizar_egreso_smi();