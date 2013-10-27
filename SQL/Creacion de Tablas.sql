
CREATE TABLE Empleados(
	E_Nombre	VARCHAR (50)	NOT NULL,
	E_DNI	INT	NOT NULL	UNIQUE,
	E_Telefono	BIGINT NOT NULL,
	E_FechaIngreso	DATE	NOT NULL,
	E_NumeroLegajo	INT NOT NULL	PRIMARY KEY,
	E_Sueldo	REAL NOT NULL,
	E_CUIL	VARCHAR (20)	NOT NULL UNIQUE,
	E_EstadoCivil	VARCHAR (15)	NOT NULL,
	E_CantidadHijos	INT	NOT NULL,
	E_Domicilio	VARCHAR (60) NOT NULL,
	E_CodigoPostal	INT NOT NULL,
	E_PaisResidencia	VARCHAR (15) NOT NULL,
	E_ProvinciaResidencia	VARCHAR (20) NOT NULL,
	E_CiudadResidencia	VARCHAR (20) NOT NULL,
	E_Categoria	VARCHAR (35) NOT NULL,
	E_Estado	VARCHAR (12) NOT NULL
);

CREATE TABLE HistorialAccidentes(
	HA_Codigo	SERIAL	NOT NULL PRIMARY KEY, /* Este atributo es SERIAL lo que indica que su valor se ira autoincrementando para cada nueva instancia del esquema */
	E_NumeroLegajo_HA	INT	NOT NULL,
	HA_FechaBaja	DATE NOT NULL,
	HA_NumeroSiniestro	INT	NOT NULL,
	HA_Causa	VARCHAR (75)	NOT NULL,
	HA_FechaAlta	DATE	NOT NULL,
	UNIQUE (E_NumeroLegajo_HA, HA_FechaBaja, HA_NumeroSiniestro, HA_Causa, HA_FechaAlta),
	FOREIGN KEY (E_NumeroLegajo_HA) REFERENCES Empleados(E_NumeroLegajo)
);

CREATE TABLE HistorialSanciones(
	HS_Codigo	SERIAL	NOT NULL PRIMARY KEY, /* Este atributo es SERIAL lo que indica que su valor se ira autoincrementando para cada nueva instancia del esquema */
	E_NumeroLegajo_HS	INT	NOT NULL,
	HS_Fecha	DATE NOT NULL,
	HS_Causa	VARCHAR (75)	NOT NULL,
	HS_Descargo	VARCHAR (75)	NOT NULL,
	HS_Sancion	VARCHAR (50)	NOT NULL,
	UNIQUE (E_NumeroLegajo_HS, HS_Fecha, HS_Causa, HS_Descargo, HS_Sancion),
	FOREIGN KEY (E_NumeroLegajo_HS) REFERENCES Empleados(E_NumeroLegajo)
);

CREATE TABLE HistorialPremios(
	HS_Codigo	SERIAL	NOT NULL PRIMARY KEY, /* Este atributo es SERIAL lo que indica que su valor se ira autoincrementando para cada nueva instancia del esquema */
	E_NumeroLegajo_HP	INT	NOT NULL,
	HS_Fecha	DATE NOT NULL,
	HS_Premio	REAL	NOT NULL,
	HS_Motivo	VARCHAR (75)	NOT NULL,
	UNIQUE (E_NumeroLegajo_HP, HS_Fecha, HS_Premio, HS_Motivo),
	FOREIGN KEY (E_NumeroLegajo_HP) REFERENCES Empleados(E_NumeroLegajo)
);

CREATE TABLE UsuariosDelSistema(
	US_Identificador	VARCHAR (15)	NOT NULL	PRIMARY KEY,
	US_Password	VARCHAR (15)	NOT NULL,
	US_Nivel	INT	NOT NULL,
	E_NumeroLegajo_TieneAsignado	INT	NOT NULL,
	US_Activo	BOOLEAN	NOT NULL	DEFAULT 'true',
	FOREIGN KEY (E_NumeroLegajo_TieneAsignado) REFERENCES Empleados(E_NumeroLegajo)
);

CREATE TABLE Insumos(
	I_Descripcion	VARCHAR (50)	NOT NULL	PRIMARY KEY,
	I_Unidad	VARCHAR (15)	NOT NULL,
	I_LimitePedido	REAL	NOT NULL,
	I_Tipo	VARCHAR (20)	NOT NULL,
	I_Activo	BOOLEAN	NOT NULL	DEFAULT 'true'
);

CREATE TABLE ProductosTerminados(
	PT_Codificacion	VARCHAR (10)	NOT NULL	PRIMARY KEY,
	PT_Tipo	VARCHAR (15)	NOT NULL,
	PT_Descripcion	VARCHAR (50)	NOT NULL,
	PT_Presentacion	VARCHAR (50)	NOT NULL,
	PT_Destino	VARCHAR (30)	NOT NULL,
	PT_KilosPorEnvase	REAL	NOT NULL,
	PT_Activo	BOOLEAN	NOT NULL	DEFAULT 'true'
);

CREATE TABLE StocksMensualesDescarte(
	SM_D_Codigo	SERIAL	NOT NULL	PRIMARY KEY, /* Este atributo es SERIAL lo que indica que su valor se ira autoincrementando para cada nueva instancia del esquema */
	SM_D_Fecha	DATE	NOT NULL UNIQUE,
	SM_D_Inicio	REAL	NOT NULL,
	SM_D_Ingreso	REAL	NOT NULL,
	SM_D_Egreso	REAL	NOT NULL,
	SM_D_Cantidad	REAL	NOT NULL
);

CREATE TABLE Lotes(
	L_Codigo	SERIAL	NOT NULL	PRIMARY KEY, /* Este atributo es SERIAL lo que indica que su valor se ira autoincrementando para cada nueva instancia del esquema */
	L_Identificador	VARCHAR (20)	NOT NULL,
	L_FechaCreacion	DATE	NOT NULL,
	L_FechaIngresoDeposito	DATE,
	L_Estado	VARCHAR (15)	NOT NULL,
	L_MotivoDeficiencia	VARCHAR (50),
	L_FechaVencimiento	DATE,
	L_CantidadDescarteUtilizado	REAL DEFAULT 0.0,
	SM_D_Codigo_UtilizadoEn	INT,
	UNIQUE (L_Identificador, L_FechaCreacion),
	FOREIGN KEY (SM_D_Codigo_UtilizadoEn) REFERENCES StocksMensualesDescarte(SM_D_Codigo)
);

CREATE TABLE Analisis(
	A_ProtocoloDeAnalisis	VARCHAR (20)	NOT NULL	PRIMARY KEY,
	A_Fecha	DATE NOT NULL,
	A_PorcentajeFosfuroAluminio	REAL	NOT NULL,
	E_NumeroLegajo_Elabora	INT	NOT NULL,
	L_Codigo_EsCertificado	INT NOT NULL,
	FOREIGN KEY (E_NumeroLegajo_Elabora) REFERENCES Empleados(E_NumeroLegajo),
	FOREIGN KEY (L_Codigo_EsCertificado) REFERENCES Lotes(L_Codigo)
);

CREATE TABLE Etapas(
	Etapa_Descripcion	VARCHAR (20)	NOT NULL	PRIMARY KEY,
	Etapa_Activo	BOOLEAN	NOT NULL	DEFAULT 'true'
);

CREATE TABLE StocksMensualesInsumos(
	SM_I_Codigo	SERIAL	NOT NULL	PRIMARY KEY, /* Este atributo es SERIAL lo que indica que su valor se ira autoincrementando para cada nueva instancia del esquema */
	SM_I_Fecha	DATE	NOT NULL,
	SM_I_Inicio	REAL	NOT NULL,
	SM_I_Ingreso	REAL	NOT NULL,
	SM_I_Egreso	REAL,
	SM_I_CantidadCalculada	REAL,
	SM_I_CantidadReal	REAL,
	SM_I_Diferencia	REAL,
	I_Descripcion_CaracterizadoEn	VARCHAR (50)	NOT NULL,
	UNIQUE (SM_I_Fecha, I_Descripcion_CaracterizadoEn),
	FOREIGN KEY (I_Descripcion_CaracterizadoEn) REFERENCES Insumos(I_Descripcion)
);

CREATE TABLE StocksMensualesProductosTerminados(
	SM_PT_Codigo	SERIAL	NOT NULL	PRIMARY KEY, /* Este atributo es SERIAL lo que indica que su valor se ira autoincrementando para cada nueva instancia del esquema */
	SM_PT_Fecha	DATE	NOT NULL,
	SM_PT_Inicio	REAL	NOT NULL,
	SM_PT_Ingreso	REAL	NOT NULL,
	SM_PT_Egreso	REAL,
	SM_PT_CantidadCalculada	REAL,
	SM_PT_CantidadReal	REAL,
	SM_PT_Diferencia	REAL,
	PT_Codificacion_CaracterizadoEn_PT	VARCHAR (10)	NOT NULL,
	UNIQUE (SM_PT_Fecha, PT_Codificacion_CaracterizadoEn_PT),
	FOREIGN KEY (PT_Codificacion_CaracterizadoEn_PT) REFERENCES ProductosTerminados(PT_Codificacion)
);

CREATE TABLE Proveedores(
	P_RazonSocial	VARCHAR (30)	NOT NULL	PRIMARY KEY,
	P_CUIT	VARCHAR (20)	NOT NULL,
	P_Domicilio	VARCHAR (60)	NOT NULL,
	P_SitioWeb	VARCHAR (60),
	P_DireccionEmail	VARCHAR (40)
);

CREATE TABLE TelefonosProveedor(
	P_RazonSocial_TP	VARCHAR (30) NOT NULL,
	TP_Telefono	BIGINT NOT NULL,
	PRIMARY KEY (P_RazonSocial_TP, TP_Telefono),
	FOREIGN KEY (P_RazonSocial_TP) REFERENCES Proveedores(P_RazonSocial)
);

CREATE TABLE ContactosProveedor(
	P_RazonSocial_CP	VARCHAR (30)	NOT NULL,
	CP_Nombre	VARCHAR (50)	NOT NULL,
	CP_Cargo	VARCHAR (30)	NOT NULL,
	CP_Telefono	BIGINT	NOT NULL,
	PRIMARY KEY (P_RazonSocial_CP, CP_Nombre, CP_Cargo, CP_Telefono),
	FOREIGN KEY (P_RazonSocial_CP) REFERENCES Proveedores(P_RazonSocial)
);

CREATE TABLE SeEncuentra(
	L_Codigo_SeEncuentra	INT NOT NULL,
	Etapa_Descripcion_SeEncuentra	VARCHAR (20)	NOT NULL,
	E_NumeroLegajo_SeEncuentra	INT	NOT NULL,
	Fecha	DATE	NOT NULL,
	PRIMARY KEY (L_Codigo_SeEncuentra, Etapa_Descripcion_SeEncuentra, E_NumeroLegajo_SeEncuentra),
	FOREIGN KEY (L_Codigo_SeEncuentra) REFERENCES Lotes(L_Codigo),
	FOREIGN KEY (Etapa_Descripcion_SeEncuentra) REFERENCES Etapas(Etapa_Descripcion),
	FOREIGN KEY (E_NumeroLegajo_SeEncuentra) REFERENCES Empleados(E_NumeroLegajo)
);

CREATE TABLE Produce(
	L_Codigo_Produce	INT	NOT NULL,
	SM_PT_Codigo_Produce	INT	NOT NULL,
	CantidadProducida	REAL	NOT NULL,
	PRIMARY KEY (L_Codigo_Produce, SM_PT_Codigo_Produce),
	FOREIGN KEY (L_Codigo_Produce) REFERENCES Lotes(L_Codigo),
	FOREIGN KEY (SM_PT_Codigo_Produce) REFERENCES StocksMensualesProductosTerminados(SM_PT_Codigo)
);

CREATE TABLE EsUtilizada(
	L_Codigo_EsUtilizada	INT	NOT NULL,
	SM_I_Codigo_EsUtilizada	INT	NOT NULL,
	CantidadUtilizada	REAL	NOT NULL,
	PRIMARY KEY (L_Codigo_EsUtilizada, SM_I_Codigo_EsUtilizada),
	FOREIGN KEY (L_Codigo_EsUtilizada) REFERENCES Lotes(L_Codigo),
	FOREIGN KEY (SM_I_Codigo_EsUtilizada) REFERENCES StocksMensualesInsumos(SM_I_Codigo)
);

CREATE TABLE ProveeInsumos(
	P_RazonSocial_ProveeInsumos	VARCHAR (30)	NOT NULL,
	SM_I_Codigo_ProveeInsumos	INT	NOT NULL,
	CantidadProvista	REAL	NOT NULL,
	PRIMARY KEY (P_RazonSocial_ProveeInsumos, SM_I_Codigo_ProveeInsumos),
	FOREIGN KEY (P_RazonSocial_ProveeInsumos) REFERENCES Proveedores(P_RazonSocial),
	FOREIGN KEY (SM_I_Codigo_ProveeInsumos) REFERENCES StocksMensualesInsumos(SM_I_Codigo)
);