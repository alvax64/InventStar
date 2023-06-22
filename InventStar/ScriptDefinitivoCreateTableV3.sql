DROP TABLE IF EXISTS insumoPerecible;
DROP TABLE IF EXISTS ingrediente;
DROP TABLE IF EXISTS bebida;
DROP TABLE IF EXISTS comida;
DROP TABLE IF EXISTS alimento;
DROP TABLE IF EXISTS utensiliosDeServicio;
DROP TABLE IF EXISTS mercancia;
DROP TABLE IF EXISTS contacto;	
DROP TABLE IF EXISTS merma;
DROP TABLE IF EXISTS lote;
DROP TABLE IF EXISTS ordenCompra;
DROP TABLE IF EXISTS proveedor;
DROP TABLE IF EXISTS productoxpromocion;
DROP TABLE IF EXISTS producto;
DROP TABLE IF EXISTS promocionPersonalizada;
DROP TABLE IF EXISTS promocion;
DROP TABLE IF EXISTS lineaordenventa;
DROP TABLE IF EXISTS itemventa;
DROP TABLE IF EXISTS ordenventa;
DROP TABLE IF EXISTS resenha;
DROP TABLE IF EXISTS transaccion;
DROP TABLE IF EXISTS tarjetastar;
DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS cuentaPersonal;
DROP TABLE IF EXISTS personal;
DROP TABLE IF EXISTS persona;
DROP TABLE IF EXISTS cargo;
DROP TABLE IF EXISTS sucursal;
DROP TABLE IF EXISTS matriz;
/*DROP TABLE IF EXISTS video;
*/
CREATE TABLE matriz(
    id_matriz INT AUTO_INCREMENT,
    nombreMatriz VARCHAR(70),
    razonsocialMatriz VARCHAR(70),
    direccionMatriz VARCHAR(70),
    telefonoMatriz VARCHAR(70),
    emailMatriz VARCHAR(70),
    activo TINYINT,
    PRIMARY KEY(id_matriz)
)ENGINE=InnoDB;

CREATE TABLE sucursal(
    id_sucursal INT AUTO_INCREMENT,
    nombreSucursal VARCHAR(70),
    direccionSucursal VARCHAR(70),
    aforoSucursal INT,
    telefonoSucursal VARCHAR(70),
    emailSucursal VARCHAR(70),
    fid_matriz INT,
    activo TINYINT,
    PRIMARY KEY(id_sucursal),
    FOREIGN KEY(fid_matriz) REFERENCES matriz(id_matriz)
)ENGINE=InnoDB;

CREATE TABLE cargo(
    id_cargo INT AUTO_INCREMENT,
    nombreCargo VARCHAR(70),
    descripcionCargo VARCHAR(70),
    salarioCargo DECIMAL(10,2),
    modificaInventarioCargo TINYINT,
    activo TINYINT,
    PRIMARY KEY(id_cargo)
)ENGINE=InnoDB;

CREATE TABLE persona(
    idPersona INT AUTO_INCREMENT,
    nombresPersona VARCHAR(70),
    apellidoPatPersona VARCHAR(70),
    apellidoMatPersona VARCHAR(70),
    numDocumentoPersona VARCHAR(20),
    telefono1Persona VARCHAR(70),
    telefono2Persona VARCHAR(70),
    emailPersona VARCHAR(70),
    domicilioPersona VARCHAR(70),
    fechaRegistroPersona DATE,
    fechaNacimientoPersona DATE,
    PRIMARY KEY(idPersona)
)ENGINE=InnoDB;

CREATE TABLE personal(
    idPersonal INT PRIMARY KEY,
    estadoPersonal VARCHAR(200),
    activo TINYINT,
    fidCargo INT,
    fidSucursal INT,
    FOREIGN KEY (idPersonal) REFERENCES persona(idPersona),
    FOREIGN KEY (fidCargo) REFERENCES cargo(id_cargo),
    FOREIGN KEY (fidSucursal) REFERENCES sucursal(id_sucursal)
)ENGINE=InnoDB;

CREATE TABLE cuentaPersonal(
    id_cuenta_personal INT AUTO_INCREMENT,
    usernameCuentaPersonal VARCHAR(100),
    passwordCuentaPersonal VARCHAR(100),
    fidPersonal INT UNIQUE,
    activo TINYINT,
    PRIMARY KEY(id_cuenta_personal),
    FOREIGN KEY(fidPersonal) REFERENCES personal(idPersonal)
)ENGINE=InnoDB;

CREATE TABLE cliente(
    idCliente INT PRIMARY KEY,
    aceptaPublicidadCliente TINYINT,
    activo TINYINT,
    FOREIGN KEY (idCliente) REFERENCES persona(idPersona)
)ENGINE=InnoDB;

CREATE TABLE tarjetastar(
    idTarjeta INT PRIMARY KEY AUTO_INCREMENT,
    puntosTarjetastar INT,
    fechaRegistroTarjetastar DATE,
    activo TINYINT,
    fidCliente INT UNIQUE,
    FOREIGN KEY (fidCliente) REFERENCES cliente(idCliente)
)ENGINE=InnoDB; 

CREATE TABLE transaccion(
    idTransaccion INT PRIMARY KEY AUTO_INCREMENT,
    fechaTransaccion DATE,
    horaTransaccion TIME,
    monedaTransaccion VARCHAR(100),
    tipoDePagoTransaccion VARCHAR(100),
    activo TINYINT
)ENGINE=InnoDB;

CREATE TABLE resenha(
    idResenha INT PRIMARY KEY AUTO_INCREMENT,
    comentarioResenha VARCHAR(100),
    valoracionResenha INT,
    activo TINYINT
)ENGINE=InnoDB;

CREATE TABLE ordenventa(
    idOrdenVenta INT PRIMARY KEY AUTO_INCREMENT,
    fechaOrdenventa DATE,
    horaVentaOrdenventa TIME,
    horaFinPedidoOrdenventa TIME,
    tipoOrdenventa varchar(100),
    estadoOrdenventa VARCHAR(100),
    totalOrdenventa DECIMAL(10,2),
    activo TINYINT,
    fidPersonal INT,
    fidCliente INT,
    fid_sucursal INT,
    fid_transaccion INT UNIQUE,
    fid_resenha INT UNIQUE,
    FOREIGN KEY (fidPersonal) REFERENCES personal(idPersonal),
    FOREIGN KEY (fidCliente) REFERENCES cliente(idCliente),
    FOREIGN KEY (fid_sucursal) REFERENCES sucursal(id_sucursal),
    FOREIGN KEY (fid_transaccion) REFERENCES transaccion(idTransaccion),
    FOREIGN KEY (fid_resenha) REFERENCES resenha(idResenha)
)ENGINE=InnoDB;  

CREATE TABLE itemventa(
    idItemVenta INT PRIMARY KEY AUTO_INCREMENT,
    nombreItemventa VARCHAR(100),
    descripcionItemventa VARCHAR(100),
    precioUnitarioItemventa DECIMAL(10,2)
)ENGINE=InnoDB;

CREATE TABLE lineaordenventa(
    idLineaOrdenVenta INT PRIMARY KEY AUTO_INCREMENT,
    cantidadLineaordenventa INT,
    subtotalLineaordenventa DECIMAL(10,2),
    fecha_hora_registro DATETIME,
    activo TINYINT,
    fidOrdenVenta INT,
    fidItemVenta INT,
    FOREIGN KEY (fidOrdenVenta) REFERENCES ordenventa(idOrdenVenta),
    FOREIGN KEY (fidItemVenta) REFERENCES itemventa(idItemVenta)
)ENGINE=InnoDB;

CREATE TABLE promocion(
    fidItemVenta INT PRIMARY KEY,
    fechaInicioPromocion DATE,
    fechaFinPromocion DATE,
    tipoPromocion varchar(100),
    FOREIGN KEY (fidItemVenta) REFERENCES itemventa(idItemVenta)
)ENGINE=InnoDB; 

CREATE TABLE promocionPersonalizada(
    idPromocionPersonalizada INT PRIMARY KEY,
    mensajePromocionPersonalizada VARCHAR(200),
    fidTarjeta INT,
    activo TINYINT,
    FOREIGN KEY (idPromocionPersonalizada) REFERENCES promocion(fidItemVenta),
    FOREIGN KEY (fidTarjeta) REFERENCES tarjetastar(idTarjeta)
)ENGINE=InnoDB;

CREATE TABLE producto(
	idProducto INT,
    PRIMARY KEY (idProducto),
    FOREIGN KEY (idProducto) REFERENCES itemventa(idItemVenta)
)ENGINE=InnoDB;

CREATE TABLE productoxpromocion(
    idProductoXPromocion INT PRIMARY KEY AUTO_INCREMENT,
    fidProducto INT,
    fidPromocion INT,
    activo TINYINT,
    FOREIGN KEY (fidProducto) REFERENCES producto(idProducto),
    FOREIGN KEY (fidPromocion) REFERENCES promocion(fidItemVenta)
)ENGINE=InnoDB;

CREATE TABLE proveedor(
	id_proveedor INT AUTO_INCREMENT,
    RUCProveedor VARCHAR(20),
    razon_socialProveedor VARCHAR(150),
    direccionProveedor VARCHAR(150),
    emailProveedor VARCHAR(100),
    telefonoProveedor VARCHAR(30),
    activo TINYINT, 
    PRIMARY KEY(id_Proveedor)
)ENGINE=InnoDB;

CREATE TABLE ordenCompra(
	id_compra INT AUTO_INCREMENT,
    fechaCompraOrdenCompra DATE,
    estadoOrdenCompra VARCHAR(20), 
	fid_proveedor INT,
	fid_sucursal INT,
    activo TINYINT,
    PRIMARY KEY(id_compra),
    FOREIGN KEY(fid_proveedor) REFERENCES proveedor(id_proveedor),
    FOREIGN KEY(fid_sucursal) REFERENCES sucursal(id_sucursal)
)ENGINE=InnoDB;

CREATE TABLE lote(
	id_lote INT AUTO_INCREMENT,
	nombreLote VARCHAR(100),
    cantidadLote DECIMAL(10,2),
    fid_compra INT,
	PRIMARY KEY(id_lote),
    FOREIGN KEY(fid_compra) REFERENCES ordenCompra(id_compra)
)ENGINE=InnoDB;

CREATE TABLE merma(
	id_merma INT AUTO_INCREMENT,
	fechaRegistroMerma DATE,
    cantidadMerma DECIMAL(10,2),
    motivoMerma VARCHAR(200),
    fid_lote INT,
    activo TINYINT,
    PRIMARY KEY(id_merma),
	FOREIGN KEY(fid_lote) REFERENCES lote(id_lote)
)ENGINE=InnoDB;

CREATE TABLE contacto (
  idContacto INT,
  puestoContacto VARCHAR(100),
  fid_proveedor INT,
  activo TINYINT,
  PRIMARY KEY (idContacto),
  FOREIGN KEY (idContacto) REFERENCES persona(idPersona),
  FOREIGN KEY (fid_proveedor) REFERENCES proveedor(id_proveedor)
)ENGINE=InnoDB;

CREATE TABLE mercancia (
	idMercancia INT,
    categoriaMercancia VARCHAR(100),
    codigoBarrasMercancia VARCHAR(255),
    fid_lote INT,
    activo TINYINT,
    PRIMARY KEY (idMercancia),
    FOREIGN KEY (idMercancia) REFERENCES producto(idProducto),
    FOREIGN KEY (fid_lote) REFERENCES lote(id_lote)
)ENGINE=InnoDB;

CREATE TABLE utensiliosDeServicio (
	idUtensiliosDeServicio INT,
    activo TINYINT,
    fidProducto INT ,
    PRIMARY KEY (idUtensiliosDeServicio),
    FOREIGN KEY (idUtensiliosDeServicio) REFERENCES lote(id_lote),
    FOREIGN KEY (fidProducto) REFERENCES producto(idProducto)
)ENGINE=InnoDB;

CREATE TABLE alimento (
	idAlimento INT,
    cantidadAlimento DECIMAL(10,2),
    unidadMedidaAlimento VARCHAR(100),
    caloriasAlimento INT,
    PRIMARY KEY (idAlimento),
    FOREIGN KEY (idAlimento) REFERENCES producto(idProducto)
)ENGINE=InnoDB;

CREATE TABLE comida (
	idComida INT,
    tipoDeComida VARCHAR(100),
    segundosACalentarComida INT,
    activo TINYINT,
    PRIMARY KEY (idComida),
    FOREIGN KEY (idComida) REFERENCES alimento(idAlimento)
)ENGINE=InnoDB;

CREATE TABLE bebida (
	idBebida INT,
    tipoDeBebida VARCHAR(100),
    esFriaBebida TINYINT,
    tamanhoBebida varchar(100),
    instruccionesPreparacionBebida VARCHAR(500),
    tiempoPreparacionBebida INT,
    activo TINYINT,
    PRIMARY KEY (idBebida),
    FOREIGN KEY (idBebida) REFERENCES alimento(idAlimento)
)ENGINE=InnoDB;

CREATE TABLE ingrediente(
	id_ingrediente INT AUTO_INCREMENT,
	nombreIngrediente VARCHAR(100),
    cantidadIngrediente DECIMAL(10,2),
	unidadMedidaIngrediente VARCHAR(20),
    activo TINYINT,
	fid_bebida INT,
    PRIMARY KEY(id_ingrediente),
	FOREIGN KEY(fid_bebida) REFERENCES bebida(idBebida)
)ENGINE=InnoDB;

CREATE TABLE insumoPerecible(
	id_insumoPerecible INT,
	fechaProduccionInsumoPerecible DATE,
    fechaVencimientoInsumoPerecible DATE,
    activo TINYINT,
	fid_comida INT UNIQUE,
	fid_ingrediente INT,
    PRIMARY KEY(id_insumoPerecible),
	FOREIGN KEY(fid_comida) REFERENCES comida(idComida),
	FOREIGN KEY(fid_ingrediente) REFERENCES ingrediente(id_ingrediente),
    FOREIGN KEY(id_insumoPerecible) REFERENCES lote(id_lote)
)ENGINE=InnoDB;

/*CREATE TABLE video (
    id_video INT AUTO_INCREMENT,
    url LONGBLOB,
    titulo varchar(100),
    descripcion varchar(500),
    duracion int,
    primary key(id_video)
)ENGINE=InnoDB;*/