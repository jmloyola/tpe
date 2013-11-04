
/*  Ingreso los empleados           Nombre                DNI        Telefono     Fecha Ingreso   NumLegajo   Sueldo       CUIL       EstadoCivil         CantHijos                Domicilio        CodPostal            Luegar Reidencia           Categoria    Estado */
INSERT INTO Empleados VALUES ('ALCARAZ, MIGUEL',       20916222,   02664411111,   '2013-05-04',      30,      7000,    '30-20916222',     'Casado',           0,         'B: BARRIO1 MNA: A C: 21',     5700,   'ARGENTINA', 'SAN LUIS', 'SAN LUIS',    'Encargado',          'Activo');
INSERT INTO Empleados VALUES ('RODRIGUEZ, RODRIGO',    29999999,   02664499999,   '2013-09-20',      10,      5000,    '30-29999999',     'Casado',           2,         'B: BARRIO2 MNA: B C: 1',      5700,   'ARGENTINA', 'SAN LUIS', 'SAN LUIS',    'Operario Laboratorio Categoria A',          'Activo');
INSERT INTO Empleados VALUES ('RAMIREZ, ALBERTO',      28888888,   02664488888,   '2013-05-24',      31,      6000,    '30-28888888',     'Soltero',          1,         'B: BARRIO1 MNA: A C: 11',     5700,   'ARGENTINA', 'SAN LUIS', 'LA PUNTA',    'Categoria A',          'Sancionado');
INSERT INTO Empleados VALUES ('PEREZ, JUAN',           27777777,   02664477777,   '2012-11-14',      35,      6500,    '30-27777777',     'Viudo',            3,         'B: BARRIO3 MNA: L C: 3',      5700,   'ARGENTINA', 'SAN LUIS', 'SAN LUIS',    'Categoria A1',          'Despedido');
INSERT INTO Empleados VALUES ('PEREZ, RAUL',           26666666,   02664466666,   '2012-12-16',      34,      6300,    '30-26666666',     'Divorciado',       0,         'LUGONES 1120',                5700,   'ARGENTINA', 'SAN LUIS', 'SAN LUIS',    'Categoria B',          'De Licencia');


/*  Ingreso los usuarios del sistema     Identificador    Password   Nivel   NumLegajo */
INSERT INTO UsuariosDelSistema VALUES (   'admin',       'admin',     0,       30);
INSERT INTO UsuariosDelSistema VALUES (    'lab',          'lab',     1,       10);

/*  Ingreso los lotes terminados */
INSERT INTO Lotes (L_Identificador, L_FechaCreacion, L_FechaIngresoDeposito, L_Estado, L_FechaVencimiento) VALUES ('L-1010-3', '2013-10-10', '2013-10-15', 'Terminado', '2016-10-15');
INSERT INTO Lotes (L_Identificador, L_FechaCreacion, L_FechaIngresoDeposito, L_Estado, L_FechaVencimiento) VALUES ('L-1030-3', '2013-10-10', '2013-10-15', 'Terminado', '2016-10-15');
INSERT INTO Lotes (L_Identificador, L_FechaCreacion, L_FechaIngresoDeposito, L_Estado, L_FechaVencimiento) VALUES ('L-1050-3', '2013-10-10', '2013-10-15', 'Terminado', '2016-10-15');
INSERT INTO Lotes (L_Identificador, L_FechaCreacion, L_FechaIngresoDeposito, L_Estado, L_FechaVencimiento) VALUES ('L-2410-3', '2013-10-24', '2013-10-26', 'Terminado', '2016-10-26');

/*  Ingreso los lotes defectuosos */
INSERT INTO Lotes (L_Identificador, L_FechaCreacion, L_Estado, L_MotivoDeficiencia) VALUES ('L-0110-3', '2013-10-01', 'Defectuoso', 'Materia prima en mal estado');

/*  Ingreso los lotes en procesamiento */
INSERT INTO Lotes (L_Identificador, L_FechaCreacion, L_Estado) VALUES ('L-0211-3', '2013-11-02', 'Procesando');
INSERT INTO Lotes (L_Identificador, L_FechaCreacion, L_Estado) VALUES ('L-0311-3', '2013-11-03', 'Procesando');
INSERT INTO Lotes (L_Identificador, L_FechaCreacion, L_Estado) VALUES ('L-0411-3', '2013-11-04', 'Procesando');

/* Ingreso los stock mensuales de descarte */
INSERT INTO stocksmensualesdescarte(sm_d_fecha, sm_d_inicio, sm_d_ingreso, sm_d_egreso, sm_d_cantidad) VALUES ('2013-10-01', 100, 0, 0, 100);


/*  Ingreso las etapas */
INSERT INTO Etapas VALUES ('QUEMADO');
INSERT INTO Etapas VALUES ('MEZCLADO');
INSERT INTO Etapas VALUES ('EMPASTILLADO');
INSERT INTO Etapas VALUES ('ENVASADO');
INSERT INTO Etapas VALUES ('EMPAQUETADO');



/* Insumos. Materia Prima */
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('ALUMINIO ARASAN', 'Kilogramo', 150, 'Materia Prima');

INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('AMONIACO', 'Kilogramo', 75, 'Materia Prima');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('ANHIDRIDO CARBONICO', 'Kilogramo', 100, 'Materia Prima');

INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('CARBAMATO DE AMONIO', 'Kilogramo', 500, 'Materia Prima');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('ESTEARATO DE CALCIO', 'Kilogramo', 100, 'Materia Prima');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('ESTEARATO DE ZINC', 'Kilogramo', 175, 'Materia Prima');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('FORSFURO ROJO', 'Kilogramo', 350, 'Materia Prima');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('PARAFINA 800(0600)', 'Kilogramo', 50, 'Materia Prima');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('UREA 46%', 'Kilogramo', 500, 'Materia Prima');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('ZINC EN POLVO M-200', 'Kilogramo', 100, 'Materia Prima');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('ZINC EN POLVO M-235', 'Kilogramo', 100, 'Materia Prima');
	
/* Insumos. Insumo Embalaje */
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('AROS METALICOS BANDAS', 'Cada Uno', 200, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('BANDAS G100 25 BOLSILLOS SIN ARO', 'Cada Uno', 150, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('BANDAS G100 CON ARO Y SELLADAS', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('BANDITA PARA G1 PACK POR 100', 'Cada Uno', 50, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('BANDITA PARA G2 PACK POR 50', 'Cada Uno', 25, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('BANDITA PARA G4 PACK 20', 'Cada Uno', 75, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('BANDITA PARA G8 PACK 20', 'Cada Uno', 30, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('CAJA C1', 'Cada Uno', 200, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('CAJA C15', 'Cada Uno', 275, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('CAJA G100', 'Cada Uno', 35, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('CAJA R15', 'Cada Uno', 500, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('CAJA R15 GEN', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('CAJA T96', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('CAJA T96 GEN', 'Cada Uno', 125, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('CINTA EMBALAR GENERICO', 'Cada Uno', 15, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('CINTA EMBALAR NEOTOXIN', 'Cada Uno', 35, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('CINTA SELLAR LATAS G100 X 50MT', 'Cada Uno', 20, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('ETIQUETAS C1', 'Cada Uno', 800, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('ETIQUETAS C12', 'Cada Uno', 600, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('ETIQUETAS C15', 'Cada Uno', 850, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('ETIQUETAS R15', 'Cada Uno', 550, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('ETIQUETAS R12', 'Cada Uno', 250, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('ETIQUETAS T96', 'Cada Uno', 1000, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('ETIQUETAS G4', 'Cada Uno', 500, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('ETIQUETAS G8', 'Cada Uno', 150, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('ETIQUETAS G100', 'Cada Uno', 600, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('FONDOS CAJAS FRASCOS', 'Cada Uno', 350, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('FONDOS CAJAS FRASCOS MITADES', 'Cada Uno', 300, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('FONDOS CAJAS LATAS', 'Cada Uno', 500, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('FONDOS CAJAS LATAS MITADES', 'Cada Uno', 5, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('FRASCO ROSCA CHIQUITA 1.0KG', 'Cada Uno', 115, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('FRASCO ROSCA EXTERIOR 1.5KG', 'Cada Uno', 130, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('FRASCO TAPA G CON CHAPITA 1.5KG', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('FRASCO TAPA G ROSCAR EXT 1.0KG', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('FRASCOS NUEVOS 1.0KG', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('FRASCOS NUEVOS 1.5KG', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('FRASCOS USADOS C/T 1.5KG LAVADO', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('FRASCOS USADOS C/T 1.5KG P/LAVAR', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('FRASCOS USADOS C/TAPA 1.0KG', 'Cada Uno', 100, 'Insumo Embalaje');

INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('LATAS 20 LTS PARA G4, G8, R12 Y C12', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('LATAS G100', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('LATAS T96', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('O-RING PARA TAPA FRASCOS', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('PEGAMENTO SECADO NORMAL', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('PEGAMENTO SECADO RAPIDO', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('POUCH ALUMINIO G4, G8, R12 Y C12', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('SOBRE IMPRESO MEZCLA 34GR', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('SOBRE IMPRESO MEZCLA 34 X 2', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('SOBRE OXIDO (CAO+CUO) 10 GR', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('SOBRE OXIDO (CAO+CUO) 20 GR', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('SOBRES OXIDO VACIOS 10 GR.', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('SOBRE OXIDO VACIOS 20 GR', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('TAPA TUBO T96', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('TAPAS FRASCOS R15 NUEVAS CON O-RING', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('TAPAS LATAS 10 LTS R12 Y C12', 'Kilogramo', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('TAPAS LATAS G100', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('TAPAS TARROS T96', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('TERMOCONTRAIBLE BLANCO', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('TERMOCONTRAIBLE ROJO BOTELLON', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('TERMOCONTRAIBLE PARA LATAS TUBOS', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('TERMOCONTRAIBLES TUBOS T96', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('TUBOS ALUMINIO T96', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('TUBOS ALUMINIO TG96', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('ETIQUETAS CROPMAX R15CM', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('ETIQUETAS CROPMAX C1CM', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('ETIQUETAS CROPMAX T96CM', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('TERMOCONTRAIBLE TUBOS CROPMAX', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('TERMOCONTRAIBLES TUBOS TI96', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('ETIQUETAS ML-408', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('ETIQUETAS CI15', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('ETIQUETAS RI15', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('ETIQUETAS TI96', 'Cada Uno', 100, 'Insumo Embalaje');
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('HOT MELD 10MM', 'Cada Uno', 100, 'Insumo Embalaje');
	
/* Insumos. Insumo Produccion */
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('ACIDO SULFURICO LABORATORIO', 'Kilogramo', 10, 'Insumo Produccion');

INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('ANHIDRICO CARBONICO', 'Kilogramo', 10, 'Insumo Produccion');

INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('NITROGENO LABORATORIO', 'Kilogramo', 10, 'Insumo Produccion');

INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('OXIDO CUPROSO', 'Kilogramo', 10, 'Insumo Produccion');

INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('OXIDO DE CALCIO', 'Kilogramo', 10, 'Insumo Produccion');

INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('SULFATO CUPRICO', 'Kilogramo', 10, 'Insumo Produccion');

INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('HIDROXIDO DE SODIO', 'Metros Cubicos', 10, 'Insumo Produccion');	

INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('CINTA REPARAR SILO BOLSA', 'Cada Uno', 10, 'Insumo Produccion');

INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('ACEITE INSIGNIA HID37', 'Litros', 10, 'Insumo Produccion');		

INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('BLACK GOLD', 'Litros', 10, 'Insumo Produccion');		
	
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('ACEITE OMALA 220', 'Litros', 10, 'Insumo Produccion');	

INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('SILO BOLSA', 'Metros', 10, 'Insumo Produccion');		

			
/* Productos Terminados */
INSERT INTO productosterminados(
            pt_codificacion, pt_tipo, pt_descripcion, pt_presentacion, pt_destino, 
            pt_kilosporenvase)
    VALUES ('R15', 'Pastillas', 'REDONDAS DE 3 GRAMOS', 'EN FRASCO DE 1.5 KG', 'NEOTOXIN', 
            1.5);
			
INSERT INTO productosterminados(
            pt_codificacion, pt_tipo, pt_descripcion, pt_presentacion, pt_destino, 
            pt_kilosporenvase)
    VALUES ('RI15', 'Pastillas', 'REDONDAS DE 3 GRAMOS', 'EN FRASCO DE 1.5 KG', 'GORPHOS', 
            1.5);
			
INSERT INTO productosterminados(
            pt_codificacion, pt_tipo, pt_descripcion, pt_presentacion, pt_destino, 
            pt_kilosporenvase)
    VALUES ('RG15', 'Pastillas', 'REDONDAS DE 3 GRAMOS', 'EN FRASCO DE 1.5 KG', 'GENERICAS', 
            1.5);
			
INSERT INTO productosterminados(
            pt_codificacion, pt_tipo, pt_descripcion, pt_presentacion, pt_destino, 
            pt_kilosporenvase)
    VALUES ('R12', 'Pastillas', 'REDONDAS DE 3 GRAMOS', 'EN POUCH DE 1.5 KG', 'NEOTOXIN', 
            1.5);
			
INSERT INTO productosterminados(
            pt_codificacion, pt_tipo, pt_descripcion, pt_presentacion, pt_destino, 
            pt_kilosporenvase)
    VALUES ('C15', 'Comprimidos', 'PELLET DE 0.6 GRAMOS', 'EN FRASCO DE 1.5 KG', 'NEOTOXIN', 
            1.5);
			
INSERT INTO productosterminados(
            pt_codificacion, pt_tipo, pt_descripcion, pt_presentacion, pt_destino, 
            pt_kilosporenvase)
    VALUES ('CI15', 'Comprimidos', 'PELLET DE 0.6 GRAMOS', 'EN FRASCO DE 1.5 KG', 'GORPHOS', 
            1.5);
			
INSERT INTO productosterminados(
            pt_codificacion, pt_tipo, pt_descripcion, pt_presentacion, pt_destino, 
            pt_kilosporenvase)
    VALUES ('CG15', 'Comprimidos', 'PELLET DE 0.6 GRAMOS', 'EN FRASCO DE 1.5 KG', 'GENERICAS', 
            1.5);
			
INSERT INTO productosterminados(
            pt_codificacion, pt_tipo, pt_descripcion, pt_presentacion, pt_destino, 
            pt_kilosporenvase)
    VALUES ('C12', 'Comprimidos', 'PELLET DE 0.6 GRAMOS', 'EN POUCH DE 1.5 KG', 'NEOTOXIN', 
            1.5);
			
INSERT INTO productosterminados(
            pt_codificacion, pt_tipo, pt_descripcion, pt_presentacion, pt_destino, 
            pt_kilosporenvase)
    VALUES ('T96', 'Tabletas', 'PLANAS DE 3 GRAMOS', 'EN LATAS DE TUBOS DE 960 GRAMOS', 'NEOTOXIN', 
            0.96);
			
INSERT INTO productosterminados(
            pt_codificacion, pt_tipo, pt_descripcion, pt_presentacion, pt_destino, 
            pt_kilosporenvase)
    VALUES ('TI96', 'Tabletas', 'PLANAS DE 3 GRAMOS', 'EN LATAS DE TUBOS DE 960 GRAMOS', 'GORPHOS', 
            0.96);
			
INSERT INTO productosterminados(
            pt_codificacion, pt_tipo, pt_descripcion, pt_presentacion, pt_destino, 
            pt_kilosporenvase)
    VALUES ('TG96', 'Tabletas', 'PLANAS DE 3 GRAMOS', 'EN LATAS DE TUBOS DE 960 GRAMOS', 'GENERICAS', 
            0.96);

INSERT INTO productosterminados(
            pt_codificacion, pt_tipo, pt_descripcion, pt_presentacion, pt_destino, 
            pt_kilosporenvase)
    VALUES ('G4', 'Granulado', 'SOBRES DE 68 GRAMOS', 'POUCH DE 4 SOBRES', 'NEOTOXIN', 
            0.272);
			
INSERT INTO productosterminados(
            pt_codificacion, pt_tipo, pt_descripcion, pt_presentacion, pt_destino, 
            pt_kilosporenvase)
    VALUES ('G8', 'Granulado', 'SOBRES DE 68 GRAMOS', 'POUCH DE 8 SOBRES', 'NEOTOXIN', 
            0.544);
			
INSERT INTO productosterminados(
            pt_codificacion, pt_tipo, pt_descripcion, pt_presentacion, pt_destino, 
            pt_kilosporenvase)
    VALUES ('G100', 'Granulado', 'SOBRES DE 68 GRAMOS', 'BANDAS DE 100 SOBRES SIMPLES', 'NEOTOXIN', 
            6.8);
			
/* Proveedores */
INSERT INTO proveedores(
            p_razonsocial, p_cuit, p_domicilio, p_sitioweb, p_direccionemail)
    VALUES ('NEOTOXIN', '10-10111213', 'AVENIDA GENERAL ALVEAR 300, GODOY CRUZ, MENDOZA, ARGENTINA', 'WWW.NEOTOXIN.COM.AR', 'CONSULTAS@NEOTOXIN.COM.AR');
	
INSERT INTO proveedores(
            p_razonsocial, p_cuit, p_domicilio, p_sitioweb, p_direccionemail)
    VALUES ('GORPHOS', '20-20212223', 'LA PAZ 220, MERLO,SAN LUIS, ARGENTINA', 'WWW.GORPHOS.COM.AR', 'PEDIDOS@GORPHOS.COM.AR');

/* Ingreso los stocks mensuales de insumos*/
INSERT INTO stocksmensualesinsumos(sm_i_fecha, sm_i_inicio, sm_i_ingreso, sm_i_egreso, sm_i_cantidadcalculada, sm_i_cantidadreal, sm_i_diferencia, i_descripcion_caracterizadoen) VALUES ('2013-10-01', 0, 0, 0, 0, 0, 0, 'AMONIACO');
INSERT INTO stocksmensualesinsumos(sm_i_fecha, sm_i_inicio, sm_i_ingreso, sm_i_egreso, sm_i_cantidadcalculada, sm_i_cantidadreal, sm_i_diferencia, i_descripcion_caracterizadoen) VALUES ('2013-10-01', 0, 0, 0, 0, 0, 0, 'FORSFURO ROJO');
INSERT INTO stocksmensualesinsumos(sm_i_fecha, sm_i_inicio, sm_i_ingreso, sm_i_egreso, sm_i_cantidadcalculada, sm_i_cantidadreal, sm_i_diferencia, i_descripcion_caracterizadoen) VALUES ('2013-10-01', 0, 0, 0, 0, 0, 0, 'CAJA C1');
INSERT INTO stocksmensualesinsumos(sm_i_fecha, sm_i_inicio, sm_i_ingreso, sm_i_egreso, sm_i_cantidadcalculada, sm_i_cantidadreal, sm_i_diferencia, i_descripcion_caracterizadoen) VALUES ('2013-10-01', 0, 0, 0, 0, 0, 0, 'OXIDO CUPROSO');
INSERT INTO stocksmensualesinsumos(sm_i_fecha, sm_i_inicio, sm_i_ingreso, sm_i_egreso, sm_i_cantidadcalculada, sm_i_cantidadreal, sm_i_diferencia, i_descripcion_caracterizadoen) VALUES ('2013-10-01', 0, 0, 0, 0, 0, 0, 'ETIQUETAS C1');

/* Ingreso los stocks mensuales de productos terminados */
INSERT INTO stocksmensualesproductosterminados(sm_pt_fecha, sm_pt_inicio, sm_pt_ingreso, sm_pt_egreso, sm_pt_cantidadcalculada, sm_pt_cantidadreal, sm_pt_diferencia, pt_codificacion_caracterizadoen_pt) VALUES ('2013-10-01', 0, 0, 0, 0, 0, 0, 'R15');
INSERT INTO stocksmensualesproductosterminados(sm_pt_fecha, sm_pt_inicio, sm_pt_ingreso, sm_pt_egreso, sm_pt_cantidadcalculada, sm_pt_cantidadreal, sm_pt_diferencia, pt_codificacion_caracterizadoen_pt) VALUES ('2013-10-01', 0, 0, 0, 0, 0, 0, 'G4');

/* Ingreso nuplas en la relacion ProveeInsumos */
INSERT INTO proveeinsumos(p_razonsocial_proveeinsumos, sm_i_codigo_proveeinsumos, cantidadprovista) VALUES ('NEOTOXIN', 1, 100);
INSERT INTO proveeinsumos(p_razonsocial_proveeinsumos, sm_i_codigo_proveeinsumos, cantidadprovista) VALUES ('NEOTOXIN', 2, 150);
INSERT INTO proveeinsumos(p_razonsocial_proveeinsumos, sm_i_codigo_proveeinsumos, cantidadprovista) VALUES ('GORPHOS', 3, 300);
INSERT INTO proveeinsumos(p_razonsocial_proveeinsumos, sm_i_codigo_proveeinsumos, cantidadprovista) VALUES ('NEOTOXIN', 4, 350);
INSERT INTO proveeinsumos(p_razonsocial_proveeinsumos, sm_i_codigo_proveeinsumos, cantidadprovista) VALUES ('GORPHOS', 5, 100);


/* Ingreso nuplas en la relacion EsUtilizada */
INSERT INTO esutilizada(l_codigo_esutilizada, sm_i_codigo_esutilizada, cantidadutilizada) VALUES (1, 1, 50);
INSERT INTO esutilizada(l_codigo_esutilizada, sm_i_codigo_esutilizada, cantidadutilizada) VALUES (1, 2, 55);
INSERT INTO esutilizada(l_codigo_esutilizada, sm_i_codigo_esutilizada, cantidadutilizada) VALUES (1, 3, 10);
INSERT INTO esutilizada(l_codigo_esutilizada, sm_i_codigo_esutilizada, cantidadutilizada) VALUES (1, 4, 100);
INSERT INTO esutilizada(l_codigo_esutilizada, sm_i_codigo_esutilizada, cantidadutilizada) VALUES (2, 3, 50);
INSERT INTO esutilizada(l_codigo_esutilizada, sm_i_codigo_esutilizada, cantidadutilizada) VALUES (2, 4, 20);
INSERT INTO esutilizada(l_codigo_esutilizada, sm_i_codigo_esutilizada, cantidadutilizada) VALUES (3, 2, 30);
INSERT INTO esutilizada(l_codigo_esutilizada, sm_i_codigo_esutilizada, cantidadutilizada) VALUES (3, 3, 110);
INSERT INTO esutilizada(l_codigo_esutilizada, sm_i_codigo_esutilizada, cantidadutilizada) VALUES (4, 4, 120);
INSERT INTO esutilizada(l_codigo_esutilizada, sm_i_codigo_esutilizada, cantidadutilizada) VALUES (4, 1, 25);
INSERT INTO esutilizada(l_codigo_esutilizada, sm_i_codigo_esutilizada, cantidadutilizada) VALUES (5, 5, 100);

/* Ingreso nuplas en la relacion Produce */
INSERT INTO produce(l_codigo_produce, sm_pt_codigo_produce, cantidadproducida) VALUES (1, 1, 100);
INSERT INTO produce(l_codigo_produce, sm_pt_codigo_produce, cantidadproducida) VALUES (1, 2, 50);
INSERT INTO produce(l_codigo_produce, sm_pt_codigo_produce, cantidadproducida) VALUES (2, 1, 250);
INSERT INTO produce(l_codigo_produce, sm_pt_codigo_produce, cantidadproducida) VALUES (3, 2, 150);
INSERT INTO produce(l_codigo_produce, sm_pt_codigo_produce, cantidadproducida) VALUES (4, 2, 175);


