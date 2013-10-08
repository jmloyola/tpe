﻿
/*  Ingreso los empleados           Nombre                DNI        Telefono     Fecha Ingreso   NumLegajo   Sueldo       CUIL       EstadoCivil   CantHijos                Domicilio        CodPostal            Luegar Reidencia           Categoria    Estado */
INSERT INTO Empleados VALUES ('ALCARAZ, MIGUEL',       20916222,   02664411111,   '2013-05-04',      30,      7000,    '30-20916222',     0,           0,         'B: BARRIO1 MNA: A C: 21',     5700,   'ARGENTINA', 'SAN LUIS', 'SAN LUIS',    6,          0);
INSERT INTO Empleados VALUES ('RODRIGUEZ, RODRIGO',    29999999,   02664499999,   '2013-09-20',      10,      5000,    '30-29999999',     1,           2,         'B: BARRIO2 MNA: B C: 1',      5700,   'ARGENTINA', 'SAN LUIS', 'SAN LUIS',    4,          0);
INSERT INTO Empleados VALUES ('RAMIREZ, ALBERTO',      28888888,   02664488888,   '2013-05-24',      31,      6000,    '30-28888888',     2,           1,         'B: BARRIO1 MNA: A C: 11',     5700,   'ARGENTINA', 'SAN LUIS', 'LA PUNTA',    0,          1);
INSERT INTO Empleados VALUES ('PEREZ, JUAN',           27777777,   02664477777,   '2012-11-14',      35,      6500,    '30-27777777',     3,           3,         'B: BARRIO3 MNA: L C: 3',      5700,   'ARGENTINA', 'SAN LUIS', 'SAN LUIS',    2,          2);
INSERT INTO Empleados VALUES ('PEREZ, RAUL',           26666666,   02664466666,   '2012-12-16',      34,      6300,    '30-26666666',     0,           0,         'LUGONES 1120',                5700,   'ARGENTINA', 'SAN LUIS', 'SAN LUIS',    1,          3);


/*  Ingreso los usuarios del sistema     Identificador    Password   Nivel   NumLegajo */
INSERT INTO UsuariosDelSistema VALUES (   'ADMIN',       'admin',     0,       30);
INSERT INTO UsuariosDelSistema VALUES (    'LAB',          'lab',     1,       10);


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


/*  */