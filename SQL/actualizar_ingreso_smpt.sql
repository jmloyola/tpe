CREATE FUNCTION actualizar_ingreso_smpt() RETURNS TRIGGER
    AS $$ 
    DECLARE 
	codigo_smpt INTEGER;
	ingreso_nuevo REAL;

    BEGIN
	    ingreso_nuevo = NEW.CantidadProducida;
	    codigo_smpt = NEW.SM_PT_Codigo_Produce;
	    UPDATE StocksMensualesProductosTerminados SET SM_PT_Ingreso = SM_PT_Ingreso + ingreso_nuevo  , SM_PT_CantidadCalculada = SM_PT_CantidadCalculada + ingreso_nuevo, SM_PT_CantidadReal = SM_PT_CantidadReal + ingreso_nuevo WHERE SM_PT_Codigo = codigo_smpt;
	    RETURN NULL;
    END;
    $$
    LANGUAGE plpgsql;

CREATE TRIGGER nuevo_producto_terminado_producido_trigger
	AFTER INSERT ON Produce
	FOR EACH ROW EXECUTE PROCEDURE actualizar_ingreso_smpt();