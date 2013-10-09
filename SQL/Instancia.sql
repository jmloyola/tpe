
/*  Ingreso los empleados           Nombre                DNI        Telefono     Fecha Ingreso   NumLegajo   Sueldo       CUIL       EstadoCivil         CantHijos                Domicilio        CodPostal            Luegar Reidencia           Categoria    Estado */
INSERT INTO Empleados VALUES ('ALCARAZ, MIGUEL',       20916222,   02664411111,   '2013-05-04',      30,      7000,    '30-20916222',     'Casado',           0,         'B: BARRIO1 MNA: A C: 21',     5700,   'ARGENTINA', 'SAN LUIS', 'SAN LUIS',    'Encargado',          'Activo');
INSERT INTO Empleados VALUES ('RODRIGUEZ, RODRIGO',    29999999,   02664499999,   '2013-09-20',      10,      5000,    '30-29999999',     'Casado',           2,         'B: BARRIO2 MNA: B C: 1',      5700,   'ARGENTINA', 'SAN LUIS', 'SAN LUIS',    'Operario Laboratorio Categoria A',          'Activo');
INSERT INTO Empleados VALUES ('RAMIREZ, ALBERTO',      28888888,   02664488888,   '2013-05-24',      31,      6000,    '30-28888888',     'Soltero',          1,         'B: BARRIO1 MNA: A C: 11',     5700,   'ARGENTINA', 'SAN LUIS', 'LA PUNTA',    'Categoria A',          'Sancionado');
INSERT INTO Empleados VALUES ('PEREZ, JUAN',           27777777,   02664477777,   '2012-11-14',      35,      6500,    '30-27777777',     'Viudo',            3,         'B: BARRIO3 MNA: L C: 3',      5700,   'ARGENTINA', 'SAN LUIS', 'SAN LUIS',    'Categoria A1',          'Despedido');
INSERT INTO Empleados VALUES ('PEREZ, RAUL',           26666666,   02664466666,   '2012-12-16',      34,      6300,    '30-26666666',     'Divorciado',       0,         'LUGONES 1120',                5700,   'ARGENTINA', 'SAN LUIS', 'SAN LUIS',    'Categoria B',          'De Licencia');


/*  Ingreso los usuarios del sistema     Identificador    Password   Nivel   NumLegajo */
INSERT INTO UsuariosDelSistema VALUES (   'admin',       'admin',     0,       30);
INSERT INTO UsuariosDelSistema VALUES (    'lab',          'lab',     1,       10);


/*  Ingreso los lotes en procesamiento */
INSERT INTO Lotes (L_Identificador, L_FechaCreacion, L_Estado) VALUES ('ID20130920', '2013-09-20', 0);
INSERT INTO Lotes (L_Identificador, L_FechaCreacion, L_Estado) VALUES ('ID20130915', '2013-09-15', 0);

/*  Ingreso los lotes terminados */
INSERT INTO Lotes (L_Identificador, L_FechaCreacion, L_FechaIngresoDeposito, L_Estado, L_FechaVencimiento) VALUES ('ID20130810', '2013-08-10', '2013-08-15', 1, '2014-08-15');

/*  Ingreso los lotes defectuosos */
INSERT INTO Lotes (L_Identificador, L_FechaCreacion, L_FechaIngresoDeposito, L_Estado, L_MotivoDeficiencia, L_FechaVencimiento) VALUES ('ID20130811', '2013-08-10', '2013-08-15', 2, 'Materia prima en mal estado', '2014-08-15');


/*  Ingreso las etapas */
INSERT INTO Etapas VALUES ('QUEMADO');
INSERT INTO Etapas VALUES ('MEZCLADO');
INSERT INTO Etapas VALUES ('EMPASTILLADO');
INSERT INTO Etapas VALUES ('ENVASADO');
INSERT INTO Etapas VALUES ('EMPAQUETADO');

/* Insumo */
INSERT INTO insumos(
            i_descripcion, i_unidad, i_limitepedido, i_tipo)
    VALUES ('Aluminio', 'Kilogramo', 200, 'Materia Prima');


/* Stock Mensual Insumo */
INSERT INTO stocksmensualesinsumos(
            sm_i_fecha, sm_i_inicio, sm_i_ingreso, sm_i_egreso, 
            sm_i_cantidadcalculada, sm_i_cantidadreal, sm_i_diferencia, i_descripcion_caracterizadoen)
    VALUES ('2013-10-01', 0, 10, 0, 
            10, 10, 0, 'Aluminio');
			
/* Producto Terminado */
INSERT INTO productosterminados(
            pt_codificacion, pt_tipo, pt_descripcion, pt_presentacion, pt_destino, 
            pt_kilosporenvase)
    VALUES ('G10', 'Pastillas', 'pastillas de 5 g', 'Lata', 'San Luis', 
            10);

			
/* Stock Mensual Producto Terminado */
INSERT INTO stocksmensualesproductosterminados(
            sm_pt_fecha, sm_pt_inicio, sm_pt_ingreso, sm_pt_egreso, 
            sm_pt_cantidadcalculada, sm_pt_cantidadreal, sm_pt_diferencia, 
            pt_codificacion_caracterizadoen_pt)
    VALUES ('2013-10-01', 0, 0, 0, 
            0, 0, 0, 
            'G10');

			
			