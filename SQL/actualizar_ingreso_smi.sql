CREATE FUNCTION actualizar_ingreso_smi() RETURNS TRIGGER
    AS $$ 
    DECLARE 
	codigo_smi INTEGER;
	ingreso_nuevo REAL;

    BEGIN
	    ingreso_nuevo = NEW.CantidadProvista;
	    codigo_smi = NEW.SM_I_Codigo_ProveeInsumos;
	    UPDATE stocksmensualesinsumos SET sm_i_ingreso = sm_i_ingreso + ingreso_nuevo  , sm_i_cantidadcalculada = sm_i_cantidadcalculada + ingreso_nuevo, sm_i_cantidadreal = sm_i_cantidadreal + ingreso_nuevo WHERE SM_I_Codigo = codigo_smi;
	    RETURN NULL;
    END;
    $$
    LANGUAGE plpgsql;

CREATE TRIGGER nueva_provision_trigger
	AFTER INSERT ON ProveeInsumos
	FOR EACH ROW EXECUTE PROCEDURE actualizar_ingreso_smi();