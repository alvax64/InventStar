DROP PROCEDURE IF EXISTS INSERTAR_MATRIZ;
DROP PROCEDURE IF EXISTS MODIFICAR_MATRIZ;
DROP PROCEDURE IF EXISTS ELIMINAR_MATRIZ;
DROP PROCEDURE IF EXISTS LISTAR_MATRIZ_TODOS;

DROP PROCEDURE IF EXISTS INSERTAR_SUCURSAL;
DROP PROCEDURE IF EXISTS MODIFICAR_SUCURSAL;
DROP PROCEDURE IF EXISTS ELIMINAR_SUCURSAL;
DROP PROCEDURE IF EXISTS LISTAR_SUCURSAL_TODOS;
DROP PROCEDURE IF EXISTS LISTAR_SUCURSAL_POR_NOMBRE;

DROP PROCEDURE IF EXISTS INSERTAR_CARGO;
DROP PROCEDURE IF EXISTS MODIFICAR_CARGO;
DROP PROCEDURE IF EXISTS ELIMINAR_CARGO;
DROP PROCEDURE IF EXISTS LISTAR_CARGO_TODOS;

DROP PROCEDURE IF EXISTS INSERTAR_PERSONAL;
DROP PROCEDURE IF EXISTS LISTAR_PERSONAL;
DROP PROCEDURE IF EXISTS MODIFICAR_PERSONAL;
DROP PROCEDURE IF EXISTS ELIMINAR_PERSONAL;
DROP PROCEDURE IF EXISTS OBTENER_PERSONAL_X_ID;

DROP PROCEDURE IF EXISTS INSERTAR_CUENTA_PERSONAL;
DROP PROCEDURE IF EXISTS LISTAR_CUENTA_PERSONAL;
DROP PROCEDURE IF EXISTS MODIFICAR_CUENTA_PERSONAL;
DROP PROCEDURE IF EXISTS ELIMINAR_CUENTA_PERSONAL;
DROP PROCEDURE IF EXISTS VERIFICAR_CUENTA_PERSONAL;
DROP PROCEDURE IF EXISTS VERIFICAR_CUENTA_PERSONAL_CON_PERMISOS;

DROP PROCEDURE IF EXISTS INSERTAR_TRANSACCION;
DROP PROCEDURE IF EXISTS LISTAR_TRANSACCION;
DROP PROCEDURE IF EXISTS MODIFICAR_TRANSACCION;
DROP PROCEDURE IF EXISTS ELIMINAR_TRANSACCION;

DROP PROCEDURE IF EXISTS INSERTAR_RESENHA;
DROP PROCEDURE IF EXISTS LISTAR_RESENHA;
DROP PROCEDURE IF EXISTS MODIFICAR_RESENHA;
DROP PROCEDURE IF EXISTS ELIMINAR_RESENHA;

DROP PROCEDURE IF EXISTS INSERTAR_CLIENTE;
DROP PROCEDURE IF EXISTS LISTAR_CLIENTE;
DROP PROCEDURE IF EXISTS LISTAR_CLIENTE_POR_NOMBRE_APELLIDO_DNI;
DROP PROCEDURE IF EXISTS MODIFICAR_CLIENTE;
DROP PROCEDURE IF EXISTS ELIMINAR_CLIENTE;

DROP PROCEDURE IF EXISTS INSERTAR_ORDENVENTA;
DROP PROCEDURE IF EXISTS LISTAR_ORDENVENTA;
DROP PROCEDURE IF EXISTS LISTAR_ORDENVENTA_POR_ID;
DROP PROCEDURE IF EXISTS MODIFICAR_ORDENVENTA;
DROP PROCEDURE IF EXISTS ELIMINAR_ORDENVENTA;

DROP PROCEDURE IF EXISTS INSERTAR_TARJETASTAR;
DROP PROCEDURE IF EXISTS LISTAR_TARJETASTAR;
DROP PROCEDURE IF EXISTS MODIFICAR_TARJETASTAR;
DROP PROCEDURE IF EXISTS ELIMINAR_TARJETASTAR;

DROP PROCEDURE IF EXISTS INSERTAR_LINEAORDENVENTA;
DROP PROCEDURE IF EXISTS LISTAR_LINEAORDENVENTA;
DROP PROCEDURE IF EXISTS MODIFICAR_LINEAORDENVENTA;
DROP PROCEDURE IF EXISTS ELIMINAR_LINEAORDENVENTA;

DROP PROCEDURE IF EXISTS INSERTAR_PROMOCIONPERSONALIZADA;
DROP PROCEDURE IF EXISTS LISTAR_PROMOCIONPERSONALIZADA;
DROP PROCEDURE IF EXISTS MODIFICAR_PROMOCIONPERSONALIZADA;
DROP PROCEDURE IF EXISTS ELIMINAR_PROMOCIONPERSONALIZADA;

DROP PROCEDURE IF EXISTS INSERTAR_PROVEEDOR;
DROP PROCEDURE IF EXISTS LISTAR_PROVEEDOR;
DROP PROCEDURE IF EXISTS MODIFICAR_PROVEEDOR;
DROP PROCEDURE IF EXISTS ELIMINAR_PROVEEDOR;

DROP PROCEDURE IF EXISTS INSERTAR_ORDENCOMPRA;
DROP PROCEDURE IF EXISTS LISTAR_ORDENCOMPRA;
DROP PROCEDURE IF EXISTS LISTAR_ORDENCOMPRA_POR_PROVEEDOR;
DROP PROCEDURE IF EXISTS MODIFICAR_ORDENCOMPRA;
DROP PROCEDURE IF EXISTS ELIMINAR_ORDENCOMPRA;

DROP PROCEDURE IF EXISTS INSERTAR_MERMA;
DROP PROCEDURE IF EXISTS LISTAR_MERMA;
DROP PROCEDURE IF EXISTS MODIFICAR_MERMA;
DROP PROCEDURE IF EXISTS ELIMINAR_MERMA;

DROP PROCEDURE IF EXISTS INSERTAR_CONTACTO;
DROP PROCEDURE IF EXISTS LISTAR_CONTACTO;
DROP PROCEDURE IF EXISTS MODIFICAR_CONTACTO;
DROP PROCEDURE IF EXISTS ELIMINAR_CONTACTO;

DROP PROCEDURE IF EXISTS INSERTAR_MERCANCIA;
DROP PROCEDURE IF EXISTS LISTAR_MERCANCIA;
DROP PROCEDURE IF EXISTS MODIFICAR_MERCANCIA;
DROP PROCEDURE IF EXISTS ELIMINAR_MERCANCIA;

DROP PROCEDURE IF EXISTS INSERTAR_UTENSILIOSDESERVICIO;
DROP PROCEDURE IF EXISTS LISTAR_UTENSILIOSDESERVICIO;
DROP PROCEDURE IF EXISTS MODIFICAR_UTENSILIOSDESERVICIO;
DROP PROCEDURE IF EXISTS ELIMINAR_UTENSILIOSDESERVICIO;

DROP PROCEDURE IF EXISTS INSERTAR_COMIDA;
DROP PROCEDURE IF EXISTS LISTAR_COMIDA;
DROP PROCEDURE IF EXISTS MODIFICAR_COMIDA;
DROP PROCEDURE IF EXISTS ELIMINAR_COMIDA;

DROP PROCEDURE IF EXISTS INSERTAR_BEBIDA;
DROP PROCEDURE IF EXISTS LISTAR_BEBIDA;
DROP PROCEDURE IF EXISTS MODIFICAR_BEBIDA;
DROP PROCEDURE IF EXISTS ELIMINAR_BEBIDA;

DROP PROCEDURE IF EXISTS INSERTAR_INGREDIENTE;
DROP PROCEDURE IF EXISTS LISTAR_INGREDIENTE;
DROP PROCEDURE IF EXISTS MODIFICAR_INGREDIENTE;
DROP PROCEDURE IF EXISTS ELIMINAR_INGREDIENTE;

DROP PROCEDURE IF EXISTS INSERTAR_INSUMOPERECIBLE;
DROP PROCEDURE IF EXISTS LISTAR_INSUMOPERECIBLE;
DROP PROCEDURE IF EXISTS MODIFICAR_INSUMOPERECIBLE;
DROP PROCEDURE IF EXISTS ELIMINAR_INSUMOPERECIBLE;

DELIMITER $
/*Matriz*/
CREATE PROCEDURE INSERTAR_MATRIZ(
    OUT _id_matriz INT,
    IN _nombreMatriz VARCHAR(70),
    IN _razonsocialMatriz VARCHAR(70),
    IN _direccionMatriz VARCHAR(70),
    IN _telefonoMatriz VARCHAR(70),
    IN _emailMatriz VARCHAR(70)
)BEGIN
    INSERT INTO matriz(nombreMatriz,razonsocialMatriz,direccionMatriz,telefonoMatriz,emailMatriz,activo) VALUES(_nombreMatriz,_razonsocialMatriz,_direccionMatriz,_telefonoMatriz,_emailMatriz,1);
    SET _id_matriz = @@last_insert_id;
END$

CREATE PROCEDURE MODIFICAR_MATRIZ(
    IN _id_matriz INT,
    IN _nombreMatriz VARCHAR(70),
    IN _razonsocialMatriz VARCHAR(70),
    IN _direccionMatriz VARCHAR(70),
    IN _telefonoMatriz VARCHAR(70),
    IN _emailMatriz VARCHAR(70)
)BEGIN
    UPDATE matriz SET nombreMatriz = _nombreMatriz, razonsocialMatriz = _razonsocialMatriz, direccionMatriz = _direccionMatriz, telefonoMatriz = _telefonoMatriz, emailMatriz = _emailMatriz WHERE id_matriz = _id_matriz;
END$

CREATE PROCEDURE ELIMINAR_MATRIZ(
    IN _id_matriz INT   
)
BEGIN
    UPDATE matriz SET activo = 0 WHERE id_matriz = _id_matriz;
END$    

CREATE PROCEDURE LISTAR_MATRIZ_TODOS()
BEGIN
    SELECT id_matriz, nombreMatriz, razonsocialMatriz, direccionMatriz, telefonoMatriz, emailMatriz FROM matriz WHERE activo = 1;
END$

/*Sucursal*/
CREATE PROCEDURE INSERTAR_SUCURSAL(
    OUT _id_sucursal INT,
    IN _nombreSucursal VARCHAR(70),
    IN _direccionSucursal VARCHAR(70),
    IN _aforoSucursal INT,
    IN _telefonoSucursal VARCHAR(70),
    IN _emailSucursal VARCHAR(70),
    IN _fid_matriz INT
)BEGIN
    INSERT INTO sucursal(nombreSucursal,direccionSucursal,aforoSucursal,telefonoSucursal,emailSucursal,fid_matriz,activo) VALUES(_nombreSucursal,_direccionSucursal,_aforoSucursal,_telefonoSucursal,_emailSucursal,_fid_matriz,1);
    SET _id_sucursal = @@last_insert_id;
END$

CREATE PROCEDURE MODIFICAR_SUCURSAL(
    IN _id_sucursal INT,
    IN _nombreSucursal VARCHAR(70),
    IN _direccionSucursal VARCHAR(70),
    IN _aforoSucursal INT,
    IN _telefonoSucursal VARCHAR(70),
    IN _emailSucursal VARCHAR(70),
    IN _fid_matriz INT
)BEGIN
    UPDATE sucursal SET nombreSucursal = _nombreSucursal, direccionSucursal = _direccionSucursal, aforoSucursal = _aforoSucursal, telefonoSucursal = _telefonoSucursal, emailSucursal = _emailSucursal, fid_matriz = _fid_matriz WHERE id_sucursal = _id_sucursal;
END$

CREATE PROCEDURE ELIMINAR_SUCURSAL(
    IN _id_sucursal INT
)BEGIN
    UPDATE sucursal SET activo = 0 WHERE id_sucursal = _id_sucursal;
END$

CREATE PROCEDURE LISTAR_SUCURSAL_TODOS()
BEGIN
    SELECT s.id_sucursal, s.nombreSucursal, s.direccionSucursal, s.aforoSucursal, s.telefonoSucursal, s.emailSucursal, m.id_matriz, m.nombreMatriz, m.razonsocialMatriz, m.direccionMatriz, m.telefonoMatriz, m.emailMatriz FROM sucursal s INNER JOIN matriz m ON s.fid_matriz=m.id_matriz WHERE s.activo = 1; 
END$

CREATE PROCEDURE LISTAR_SUCURSAL_POR_NOMBRE(
	IN _nombre VARCHAR(100)
)
BEGIN
    SELECT s.id_sucursal, s.nombreSucursal, s.direccionSucursal, s.aforoSucursal, s.telefonoSucursal, s.emailSucursal, m.id_matriz, m.nombreMatriz, m.razonsocialMatriz, m.direccionMatriz, m.telefonoMatriz, m.emailMatriz FROM sucursal s INNER JOIN matriz m ON s.fid_matriz=m.id_matriz WHERE s.activo = 1 AND s.nombreSucursal LIKE CONCAT('%',_nombre,'%') ; 
END$

/*Cargo*/
CREATE PROCEDURE INSERTAR_CARGO(
    OUT _id_cargo INT,
    IN _nombreCargo VARCHAR(70),
    IN _descripcionCargo VARCHAR(70),
    IN _salarioCargo DECIMAL(10,2),
    IN _modificaInventarioCargo TINYINT
)
BEGIN
    INSERT INTO cargo(nombreCargo,descripcionCargo,salarioCargo,modificaInventarioCargo,activo) VALUES(_nombreCargo,_descripcionCargo,_salarioCargo,_modificaInventarioCargo,1);
    SET _id_cargo = @@last_insert_id;
END$

CREATE PROCEDURE MODIFICAR_CARGO(
    IN _id_cargo INT,
    IN _nombreCargo VARCHAR(70),
    IN _descripcionCargo VARCHAR(70),
    IN _salarioCargo DECIMAL(10,2),
    IN _modificaInventarioCargo TINYINT
)
BEGIN
    UPDATE cargo SET nombreCargo = _nombreCargo, descripcionCargo = _descripcionCargo, salarioCargo = _salarioCargo, modificaInventarioCargo = _modificaInventarioCargo WHERE id_cargo = _id_cargo;
END$

CREATE PROCEDURE ELIMINAR_CARGO(
    IN _id_cargo INT   
)
BEGIN
    UPDATE cargo SET activo = 0 WHERE id_cargo = _id_cargo;
END$

CREATE PROCEDURE LISTAR_CARGO_TODOS()
BEGIN
    SELECT id_cargo, nombreCargo, descripcionCargo, salarioCargo, modificaInventarioCargo FROM cargo WHERE activo = 1;
END$

/*Personal*/
CREATE PROCEDURE INSERTAR_PERSONAL(
    OUT _idPersonal INT,
    IN _nombresPersona VARCHAR(70),
    IN _apellidoPatPersona VARCHAR(70),
    IN _apellidoMatPersona VARCHAR(70),
    IN _numDocumentoPersona VARCHAR(20),
    IN _telefono1Persona VARCHAR(70),
    IN _telefono2Persona VARCHAR(70),
    IN _emailPersona VARCHAR(70),
    IN _domicilioPersona VARCHAR(70),
    IN _fechaRegistroPersona DATE,
    IN _fechaNacimientoPersona DATE,
    IN _estadoPersonal VARCHAR(200),
    IN _fidCargo INT,
    IN _fidSucursal INT
)BEGIN
    INSERT INTO persona(nombresPersona,apellidoPatPersona,apellidoMatPersona,numDocumentoPersona,telefono1Persona,telefono2Persona,emailPersona,domicilioPersona,fechaRegistroPersona,fechaNacimientoPersona) VALUES(_nombresPersona,_apellidoPatPersona,_apellidoMatPersona,_numDocumentoPersona,_telefono1Persona,_telefono2Persona,_emailPersona,_domicilioPersona,_fechaRegistroPersona,_fechaNacimientoPersona);
    SET _idPersonal = @@last_insert_id;
    INSERT INTO personal(idPersonal,estadoPersonal,activo,fidCargo,fidSucursal) VALUES(_idPersonal,_estadoPersonal,1,_fidCargo,_fidSucursal);
END$

CREATE PROCEDURE LISTAR_PERSONAL()
BEGIN
    SELECT p.idPersona,p.nombresPersona,p.apellidoPatPersona,p.apellidoMatPersona,p.numDocumentoPersona,p.telefono1Persona,p.telefono2Persona,p.emailPersona,p.domicilioPersona,p.fechaRegistroPersona,p.fechaNacimientoPersona,pe.estadoPersonal,c.id_cargo,c.nombreCargo,c.descripcionCargo,c.salarioCargo,c.modificaInventarioCargo,s.id_sucursal,s.nombreSucursal,s.direccionSucursal,s.aforoSucursal,s.telefonoSucursal,s.emailSucursal FROM persona p INNER JOIN personal pe ON p.idPersonal = pe.idPersonal INNER JOIN cargo c ON pe.fidCargo = c.id_cargo INNER JOIN sucursal s ON pe.fidSucursal = s.id_sucursal WHERE pe.activo=1;
END$

CREATE PROCEDURE MODIFICAR_PERSONAL(
    IN _idPersonal INT,
    IN _nombresPersona VARCHAR(70),
    IN _apellidoPatPersona VARCHAR(70),
    IN _apellidoMatPersona VARCHAR(70),
    IN _numDocumentoPersona VARCHAR(20),
    IN _telefono1Persona VARCHAR(70),
    IN _telefono2Persona VARCHAR(70),
    IN _emailPersona VARCHAR(70),
    IN _domicilioPersona VARCHAR(70),
    IN _fechaRegistroPersona DATE,
    IN _fechaNacimientoPersona DATE,
    IN _estadoPersonal VARCHAR(200),
    IN _fidCargo INT,
    IN _fidSucursal INT
)BEGIN
    UPDATE persona SET nombresPersona = _nombresPersona, apellidoPatPersona = _apellidoPatPersona, apellidoMatPersona = _apellidoMatPersona, numDocumentoPersona = _numDocumentoPersona, telefono1Persona = _telefono1Persona, telefono2Persona = _telefono2Persona, emailPersona = _emailPersona, domicilioPersona = _domicilioPersona, fechaRegistroPersona = _fechaRegistroPersona, fechaNacimientoPersona = _fechaNacimientoPersona WHERE idPersonal = _idPersonal;
    UPDATE personal SET estadoPersonal = _estadoPersonal, fidCargo = _fidCargo, fidSucursal = _fidSucursal WHERE idPersonal = _idPersonal;
END$

CREATE PROCEDURE ELIMINAR_PERSONAL(
    IN _idPersonal INT
)BEGIN
    UPDATE personal SET activo = 0 WHERE idPersonal = _idPersonal;
END$

CREATE PROCEDURE OBTENER_PERSONAL_X_ID(
	IN _id_personal INT
)
BEGIN
	SELECT p.idPersona,p.nombresPersona,p.apellidoPatPersona,
    p.apellidoMatPersona,p.numDocumentoPersona,p.telefono1Persona,
    p.telefono2Persona,p.emailPersona,p.domicilioPersona,p.fechaRegistroPersona,
    p.fechaNacimientoPersona,pe.estadoPersonal,c.id_cargo,c.nombreCargo,c.descripcionCargo,
    c.salarioCargo,c.modificaInventarioCargo,s.id_sucursal,s.nombreSucursal,s.direccionSucursal,
    s.aforoSucursal,s.telefonoSucursal,s.emailSucursal 
    FROM persona p 
    INNER JOIN personal pe ON p.idPersona = pe.idPersonal 
    INNER JOIN cargo c ON pe.fidCargo = c.id_cargo 
    INNER JOIN sucursal s ON pe.fidSucursal = s.id_sucursal 
    WHERE pe.activo=1 AND p.idPersona = _id_personal;
END$
/*Cuenta personal*/
CREATE PROCEDURE INSERTAR_CUENTA_PERSONAL(
    OUT _id_cuenta_personal INT,
    IN _usernameCuentaPersonal VARCHAR(100),
    IN _passwordCuentaPersonal VARCHAR(100),
    IN _fidPersonal INT
)BEGIN
    INSERT INTO cuentaPersonal(usernameCuentaPersonal,passwordCuentaPersonal,fidPersonal,activo) VALUES(_usernameCuentaPersonal,MD5(_passwordCuentaPersonal),_fidPersonal,1);
    SET _id_cuenta_personal = @@last_insert_id;
END$

CREATE PROCEDURE LISTAR_CUENTA_PERSONAL()
BEGIN
    SELECT c.id_cuenta_personal,c.usernameCuentaPersonal,c.passwordCuentaPersonal,p.idPersona,p.nombresPersona,p.apellidoPatPersona,p.apellidoMatPersona,p.numDocumentoPersona,p.telefono1Persona,p.telefono2Persona,p.emailPersona,p.domicilioPersona,p.fechaRegistroPersona,p.fechaNacimientoPersona,pe.estadoPersonal FROM cuentaPersonal c INNER JOIN personal pe ON pe.idPersonal=c.fidPersonal INNER JOIN persona p ON pe.idPersonal=p.idPersona WHERE activo=1;
END$

CREATE PROCEDURE MODIFICAR_CUENTA_PERSONAL(
    IN _id_cuenta_personal INT,
    IN _usernameCuentaPersonal VARCHAR(100),
    IN _passwordCuentaPersonal VARCHAR(100),
    IN _fidPersonal INT
)BEGIN
    UPDATE cuentaPersonal SET usernameCuentaPersonal = _usernameCuentaPersonal, passwordCuentaPersonal = _passwordCuentaPersonal, fidPersonal = _fidPersonal WHERE id_cuenta_personal = _id_cuenta_personal;
END$

CREATE PROCEDURE ELIMINAR_CUENTA_PERSONAL(
    IN _id_cuenta_personal INT  
)BEGIN
    UPDATE cuentaPersonal SET activo = 0 WHERE id_cuenta_personal = _id_cuenta_personal;
END$  

CREATE PROCEDURE VERIFICAR_CUENTA_PERSONAL(
	_username VARCHAR(100),
    _password VARCHAR(100)
)
BEGIN
	SELECT id_cuenta_personal, fidPersonal, usernameCuentaPersonal, 
    passwordCuentaPersonal FROM cuentaPersonal WHERE usernameCuentaPersonal = _username AND passwordCuentaPersonal = 
    MD5(_password) AND activo = 1;
END$

CREATE PROCEDURE VERIFICAR_CUENTA_PERSONAL_CON_PERMISOS(
	_username VARCHAR(100),
    _password VARCHAR(100)
)
BEGIN
	SELECT c.id_cuenta_personal, c.fidPersonal, c.usernameCuentaPersonal, 
    c.passwordCuentaPersonal FROM cuentaPersonal as c JOIN personal as p ON c.fidPersonal=p.idPersonal JOIN cargo as ca ON ca.id_cargo=p.fidCargo WHERE c.usernameCuentaPersonal = _username AND c.passwordCuentaPersonal = 
    MD5(_password) AND c.activo = 1 AND ca.modificaInventarioCargo=1;
END$
/*Transaccion*/
CREATE PROCEDURE INSERTAR_TRANSACCION(
    OUT _idTransaccion INT,
    IN _fechaTransaccion DATE,
    IN _horaTransaccion TIME,
    IN _monedaTransaccion VARCHAR(100),
    IN _tipoDePagoTransaccion VARCHAR(100)
)BEGIN
    INSERT INTO transaccion(fechaTransaccion,horaTransaccion,monedaTransaccion,tipoDePagoTransaccion,activo) VALUES(_fechaTransaccion,_horaTransaccion,_monedaTransaccion,_tipoDePagoTransaccion,1);
    SET _idTransaccion = @@last_insert_id;
END$

CREATE PROCEDURE LISTAR_TRANSACCION()
BEGIN
    SELECT idTransaccion,fechaTransaccion,horaTransaccion,monedaTransaccion,tipoDePagoTransaccion FROM transaccion WHERE activo = 1;
END$    

CREATE PROCEDURE MODIFICAR_TRANSACCION(
    IN _idTransaccion INT,
    IN _fechaTransaccion DATE,
    IN _horaTransaccion TIME,
    IN _monedaTransaccion VARCHAR(100),
    IN _tipoDePagoTransaccion VARCHAR(100)
)BEGIN
    UPDATE transaccion SET fechaTransaccion = _fechaTransaccion, horaTransaccion = _horaTransaccion, monedaTransaccion = _monedaTransaccion, tipoDePagoTransaccion = _tipoDePagoTransaccion WHERE idTransaccion = _idTransaccion;
END$

CREATE PROCEDURE ELIMINAR_TRANSACCION(
    IN _idTransaccion INT
)BEGIN
    UPDATE transaccion SET activo = 0 WHERE idTransaccion = _idTransaccion;
END$

/*ACA ME QUEDOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO*/

/*Resenha*/
CREATE PROCEDURE INSERTAR_RESENHA(
    OUT _idResenha INT,
    IN _comentarioResenha VARCHAR(100),
    IN _valoracionResenha INT   
)BEGIN
    INSERT INTO resenha(comentarioResenha,valoracionResenha,activo) VALUES(_comentarioResenha,_valoracionResenha,1);
    SET _idResenha = @@last_insert_id;
END$

CREATE PROCEDURE LISTAR_RESENHA()
BEGIN
    SELECT idResenha,comentarioResenha,valoracionResenha FROM resenha WHERE activo = 1;
END$

CREATE PROCEDURE MODIFICAR_RESENHA(
    IN _idResenha INT,
    IN _comentarioResenha VARCHAR(100),
    IN _valoracionResenha INT
)BEGIN
    UPDATE resenha SET comentarioResenha = _comentarioResenha, valoracionResenha = _valoracionResenha WHERE idResenha = _idResenha;
END$

CREATE PROCEDURE ELIMINAR_RESENHA(
    IN _idResenha INT   
)BEGIN
    UPDATE resenha SET activo = 0 WHERE idResenha = _idResenha;
END$

/*Cliente*/
CREATE PROCEDURE INSERTAR_CLIENTE(
    OUT _idCliente INT,
    IN _nombresPersona VARCHAR(70),
    IN _apellidoPatPersona VARCHAR(70),
    IN _apellidoMatPersona VARCHAR(70),
    IN _numDocumentoPersona VARCHAR(20),
    IN _telefono1Persona VARCHAR(70),
    IN _telefono2Persona VARCHAR(70),
    IN _emailPersona VARCHAR(70),
    IN _domicilioPersona VARCHAR(70),
    IN _fechaRegistroPersona DATE,
    IN _fechaNacimientoPersona DATE,
    IN _aceptaPublicidadCliente TINYINT
)BEGIN
    INSERT INTO persona(nombresPersona,apellidoPatPersona,apellidoMatPersona,numDocumentoPersona,telefono1Persona,telefono2Persona,emailPersona,domicilioPersona,fechaRegistroPersona,fechaNacimientoPersona) VALUES(_nombresPersona,_apellidoPatPersona,_apellidoMatPersona,_numDocumentoPersona,_telefono1Persona,_telefono2Persona,_emailPersona,_domicilioPersona,_fechaRegistroPersona,_fechaNacimientoPersona);
    SET _idCliente = @@last_insert_id;
    INSERT INTO cliente(idCliente,aceptaPublicidadCliente,activo) VALUES(_idCliente,_aceptaPublicidadCliente,1);
END$

CREATE PROCEDURE LISTAR_CLIENTE()
BEGIN
    SELECT p.idPersona,p.nombresPersona,p.apellidoPatPersona,p.apellidoMatPersona,p.numDocumentoPersona,p.telefono1Persona,p.telefono2Persona,p.emailPersona,p.domicilioPersona,p.fechaRegistroPersona,p.fechaNacimientoPersona,c.aceptaPublicidadCliente FROM persona p INNER JOIN cliente c ON p.idPersona = c.idCliente WHERE c.activo=1;
END$

CREATE PROCEDURE MODIFICAR_CLIENTE(
    IN _idCliente INT,
    IN _nombresPersona VARCHAR(70),
    IN _apellidoPatPersona VARCHAR(70),
    IN _apellidoMatPersona VARCHAR(70),
    IN _numDocumentoPersona VARCHAR(20),
    IN _telefono1Persona VARCHAR(70),
    IN _telefono2Persona VARCHAR(70),
    IN _emailPersona VARCHAR(70),
    IN _domicilioPersona VARCHAR(70),
    IN _fechaRegistroPersona DATE,
    IN _fechaNacimientoPersona DATE,
    IN _aceptaPublicidadCliente TINYINT
)BEGIN
    UPDATE persona SET nombresPersona = _nombresPersona, apellidoPatPersona = _apellidoPatPersona, apellidoMatPersona = _apellidoMatPersona, numDocumentoPersona = _numDocumentoPersona, telefono1Persona = _telefono1Persona, telefono2Persona = _telefono2Persona, emailPersona = _emailPersona, domicilioPersona = _domicilioPersona, fechaRegistroPersona = _fechaRegistroPersona, fechaNacimientoPersona = _fechaNacimientoPersona WHERE idPersona = _idCliente;
    UPDATE cliente SET aceptaPublicidadCliente = _aceptaPublicidadCliente WHERE idCliente = _idCliente;
END$

CREATE PROCEDURE LISTAR_CLIENTE_POR_NOMBRE_APELLIDO_DNI(
	IN _nombre_apellido_DNI VARCHAR(150)
)
BEGIN
    SELECT p.idPersona,p.nombresPersona,p.apellidoPatPersona,p.apellidoMatPersona,p.numDocumentoPersona,
    p.telefono1Persona,p.telefono2Persona,p.emailPersona,p.domicilioPersona,p.fechaRegistroPersona,
    p.fechaNacimientoPersona,c.aceptaPublicidadCliente
    FROM persona p INNER JOIN cliente c 
		ON p.idPersona = c.idCliente 
	WHERE c.activo=1 and 
    ((CONCAT(p.nombresPersona,' ',p.apellidoPatPersona) LIKE CONCAT('%',_nombre_apellido_DNI,'%')) OR (p.numDocumentoPersona LIKE CONCAT('%',_nombre_apellido_DNI,'%')));
END$

CREATE PROCEDURE ELIMINAR_CLIENTE(
    IN _idCliente INT
)BEGIN
    UPDATE cliente SET activo = 0 WHERE idCliente = _idCliente;
END$

/*Orden Venta*/
CREATE PROCEDURE INSERTAR_ORDENVENTA(
    OUT _idOrdenVenta INT,
    IN _fechaOrdenventa DATE,
    IN _horaVentaOrdenventa TIME,
    IN _horaFinPedidoOrdenventa TIME,
    IN _tipoOrdenventa VARCHAR(100),
    IN _estadoOrdenventa VARCHAR(100),
    IN _totalOrdenventa DECIMAL(10,2),
    IN _fidPersonal INT,
    IN _fidCliente INT,
    IN _fid_sucursal INT,
    IN _fid_transaccion INT,
    IN _fid_resenha INT
)BEGIN 
    INSERT INTO ordenventa(fechaOrdenventa,horaVentaOrdenventa,horaFinPedidoOrdenventa,tipoOrdenventa,estadoOrdenventa,totalOrdenventa,fidPersonal,fidCliente,fid_sucursal,fid_transaccion,fid_resenha,activo) VALUES(_fechaOrdenventa,_horaVentaOrdenventa,_horaFinPedidoOrdenventa,_tipoOrdenventa,_estadoOrdenventa,_totalOrdenventa,_fidPersonal,_fidCliente,_fid_sucursal,_fid_transaccion,_fid_resenha,1);
    SET _idOrdenVenta = @@last_insert_id;
END$

CREATE PROCEDURE LISTAR_ORDENVENTA()
BEGIN
    SELECT o.idOrdenVenta,o.fechaOrdenventa,o.horaVentaOrdenventa,o.horaFinPedidoOrdenventa,o.tipoOrdenventa,o.estadoOrdenventa,o.totalOrdenventa,p.idPersona as idPersonaPersonal,p.nombresPersona as nombresPersonaPersonal,p.apellidoPatPersona as apellidoPatPersonaPersonal,p.apellidoMatPersona as apellidoMatPersonaPersonal,p.numDocumentoPersona as numDocumentoPersonaPersonal,p.telefono1Persona as telefono1PersonaPersonal,p.telefono2Persona as telefono2PersonaPersonal,p.emailPersona as emailPersonaPersonal,p.domicilioPersona as domicilioPersonaPersonal,p.fechaRegistroPersona as fechaRegistroPersonaPersonal,p.fechaNacimientoPersona as fechaNacimientoPersonaPersonal,pe.estadoPersonal,pp.idPersona,pp.nombresPersona,pp.apellidoPatPersona,pp.apellidoMatPersona,pp.numDocumentoPersona,pp.telefono1Persona,pp.telefono2Persona,pp.emailPersona,pp.domicilioPersona,pp.fechaRegistroPersona,pp.fechaNacimientoPersona,c.aceptaPublicidadCliente,s.id_sucursal,s.nombreSucursal,s.direccionSucursal,s.aforoSucursal,s.telefonoSucursal,s.emailSucursal,t.idTransaccion,t.fechaTransaccion,t.horaTransaccion,t.monedaTransaccion,t.tipoDePagoTransaccion,r.idResenha,r.comentarioResenha,r.valoracionResenha FROM ordenventa o INNER JOIN personal pe ON pe.idPersonal=o.fidPersonal INNER JOIN persona p ON pe.idPersonal=p.idPersona INNER JOIN cliente c ON c.idCliente=o.fidCliente INNER JOIN persona pp ON c.idCliente=pp.idPersona INNER JOIN sucursal s ON o.fid_sucursal = s.id_sucursal INNER JOIN transaccion t ON o.fid_transaccion = t.idTransaccion INNER JOIN resenha r ON o.fid_resenha = r.idResenha WHERE o.activo = 1;
END$

CREATE PROCEDURE LISTAR_ORDENVENTA_POR_ID(
    IN _idOrdenVenta INT)
BEGIN
    SELECT o.idOrdenVenta,o.fechaOrdenventa,o.horaVentaOrdenventa,o.horaFinPedidoOrdenventa,o.tipoOrdenventa,o.estadoOrdenventa,o.totalOrdenventa,p.idPersona as idPersonaPersonal FROM ordenventa o INNER JOIN personal pe ON pe.idPersonal=o.fidPersonal INNER JOIN persona p ON pe.idPersonal=p.idPersona WHERE o.activo = 1 AND o.idOrdenVenta = _idOrdenVenta;
END$

CREATE PROCEDURE MODIFICAR_ORDENVENTA(
    IN _idOrdenVenta INT,
    IN _fechaOrdenventa DATE,
    IN _horaVentaOrdenventa TIME,
    IN _horaFinPedidoOrdenventa TIME,
    IN _tipoOrdenventa VARCHAR(100),
    IN _estadoOrdenventa VARCHAR(100),
    IN _totalOrdenventa DECIMAL(10,2),
    IN _fidPersonal INT,
    IN _fidCliente INT,
    IN _fid_sucursal INT,
    IN _fid_transaccion INT,
    IN _fid_resenha INT
)BEGIN
    UPDATE ordenventa SET fechaOrdenventa = _fechaOrdenventa, horaVentaOrdenventa = _horaVentaOrdenventa, horaFinPedidoOrdenventa = _horaFinPedidoOrdenventa, tipoOrdenventa = _tipoOrdenventa, estadoOrdenventa = _estadoOrdenventa, totalOrdenventa = _totalOrdenventa, fidPersonal = _fidPersonal, fidCliente = _fidCliente, fid_sucursal = _fid_sucursal, fid_transaccion = _fid_transaccion, fid_resenha = _fid_resenha WHERE idOrdenVenta = _idOrdenVenta;
END$

CREATE PROCEDURE ELIMINAR_ORDENVENTA(
    IN _idOrdenVenta INT
)BEGIN
    UPDATE ordenventa SET activo = 0 WHERE idOrdenVenta = _idOrdenVenta;
END$

/*Tarjeta star*/
CREATE PROCEDURE INSERTAR_TARJETASTAR(
    OUT _idTarjeta INT,
    IN _puntosTarjetastar INT,
    IN _fechaRegistroTarjetastar DATE,
    IN _fidCliente INT
)
BEGIN
    INSERT INTO tarjetastar(puntosTarjetastar,fechaRegistroTarjetastar,fidCliente,activo) VALUES(_puntosTarjetastar,_fechaRegistroTarjetastar,_fidCliente,1);
    SET _idTarjeta = @@last_insert_id;
END$

CREATE PROCEDURE LISTAR_TARJETASTAR()
BEGIN
    SELECT t.idTarjeta,t.puntosTarjetastar,t.fechaRegistroTarjetastar,p.idPersona,p.nombresPersona,p.apellidoPatPersona,p.apellidoMatPersona,p.numDocumentoPersona,p.telefono1Persona,p.telefono2Persona,p.emailPersona,p.domicilioPersona,p.fechaRegistroPersona,p.fechaNacimientoPersona,c.aceptaPublicidadCliente FROM tarjetastar t INNER JOIN cliente c ON t.fidCliente = c.idCliente INNER JOIN persona p ON c.idCliente = p.idPersona WHERE t.activo = 1;
END$

CREATE PROCEDURE MODIFICAR_TARJETASTAR(
    IN _idTarjeta INT,
    IN _puntosTarjetastar INT,
    IN _fechaRegistroTarjetastar DATE,
    IN _fidCliente INT
)
BEGIN
    UPDATE tarjetastar SET puntosTarjetastar = _puntosTarjetastar, fechaRegistroTarjetastar = _fechaRegistroTarjetastar, fidCliente = _fidCliente WHERE idTarjeta = _idTarjeta;
END$

CREATE PROCEDURE ELIMINAR_TARJETASTAR(
    IN _idTarjeta INT
)
BEGIN
    UPDATE tarjetastar SET activo = 0 WHERE idTarjeta = _idTarjeta;
END$

/*Linea Orden Venta*/
CREATE PROCEDURE INSERTAR_LINEAORDENVENTA(
    OUT _idLineaOrdenVenta INT,
    IN _cantidadLineaordenventa INT,
    IN _subtotalLineaordenventa DECIMAL(10,2),
    IN _fidOrdenVenta INT,
    IN _fidItemVenta INT
)BEGIN
    INSERT INTO lineaordenventa(cantidadLineaordenventa,subtotalLineaordenventa,fecha_hora_registro,fidOrdenVenta,fidItemVenta,activo) VALUES(_cantidadLineaordenventa,_subtotalLineaordenventa,now() - INTERVAL 5 HOUR,_fidOrdenVenta,_fidItemVenta,1);
    SET _idLineaOrdenVenta = @@last_insert_id;
END$

CREATE PROCEDURE LISTAR_LINEAORDENVENTA()
BEGIN
    SELECT l.idLineaOrdenVenta,l.cantidadLineaordenventa,l.subtotalLineaordenventa,l.fecha_hora_registro,o.idOrdenVenta,o.fechaOrdenventa,o.horaVentaOrdenventa,o.horaFinPedidoOrdenventa,o.tipoOrdenventa,o.estadoOrdenventa,o.totalOrdenventa,p.idPersona as idPersonaPersonal,p.nombresPersona as nombresPersonaPersonal,p.apellidoPatPersona as apellidoPatPersonaPersonal,p.apellidoMatPersona as apellidoMatPersonaPersonal,p.numDocumentoPersona as numDocumentoPersonaPersonal,p.telefono1Persona as telefono1PersonaPersonal,p.telefono2Persona as telefono2PersonaPersonal,p.emailPersona as emailPersonaPersonal,p.domicilioPersona as domicilioPersonaPersonal,p.fechaRegistroPersona as fechaRegistroPersonaPersonal,p.fechaNacimientoPersona as fechaNacimientoPersonaPersonal,pe.estadoPersonal,pp.idPersona,pp.nombresPersona,pp.apellidoPatPersona,pp.apellidoMatPersona,pp.numDocumentoPersona,pp.telefono1Persona,pp.telefono2Persona,pp.emailPersona,pp.domicilioPersona,pp.fechaRegistroPersona,pp.fechaNacimientoPersona,c.aceptaPublicidadCliente,s.id_sucursal,s.nombreSucursal,s.direccionSucursal,s.aforoSucursal,s.telefonoSucursal,s.emailSucursal,t.idTransaccion,t.fechaTransaccion,t.horaTransaccion,t.monedaTransaccion,t.tipoDePagoTransaccion,r.idResenha,r.comentarioResenha,r.valoracionResenha,i.idItemVenta,i.nombreItemventa,i.descripcionItemventa,i.precioUnitarioItemventa FROM lineaordenventa l INNER JOIN ordenventa o ON l.fidOrdenVenta = o.idOrdenVenta INNER JOIN personal pe ON pe.idPersonal=o.fidPersonal INNER JOIN persona p ON pe.idPersonal=p.idPersona INNER JOIN cliente c ON c.idCliente=o.fidCliente INNER JOIN persona pp ON c.idCliente=pp.idPersona INNER JOIN sucursal s ON o.fid_sucursal = s.id_sucursal INNER JOIN transaccion t ON o.fid_transaccion = t.idTransaccion INNER JOIN resenha r ON o.fid_resenha = r.idResenha INNER JOIN itemventa i ON o.fidItemVenta = i.idItemVenta WHERE l.activo = 1;
END$


CREATE PROCEDURE MODIFICAR_LINEAORDENVENTA(
    IN _idLineaOrdenVenta INT,
    IN _cantidadLineaordenventa INT,
    IN _subtotalLineaordenventa DECIMAL(10,2),
    IN _fidOrdenVenta INT,
    IN _fidItemVenta INT
)BEGIN  
    UPDATE lineaordenventa SET cantidadLineaordenventa = _cantidadLineaordenventa, subtotalLineaordenventa = _subtotalLineaordenventa, fidOrdenVenta = _fidOrdenVenta, fidItemVenta = _fidItemVenta WHERE idLineaOrdenVenta = _idLineaOrdenVenta;
END$

CREATE PROCEDURE ELIMINAR_LINEAORDENVENTA(
    IN _idLineaOrdenVenta INT
)BEGIN
    UPDATE lineaordenventa SET activo = 0 WHERE idLineaOrdenVenta = _idLineaOrdenVenta;
END$

/*Promocion Personalizada*/
CREATE PROCEDURE INSERTAR_PROMOCIONPERSONALIZADA(
    OUT idPromocionPersonalizada INT,
    IN _nombreItemventa VARCHAR(100),
    IN _descripcionItemventa VARCHAR(100),
    IN _precioUnitarioItemventa DECIMAL(10,2),

    IN _fechaInicioPromocion DATE,
    IN _fechaFinPromocion DATE,
    IN _tipoPromocion varchar(100),

    IN _mensajePromocionPersonalizada VARCHAR(200),
    IN _fidTarjeta INT
)BEGIN
    INSERT INTO itemventa(nombreItemventa,descripcionItemventa,precioUnitarioItemventa) VALUES(_nombreItemventa,_descripcionItemventa,_precioUnitarioItemventa);
    SET idPromocionPersonalizada = @@last_insert_id;
    INSERT INTO promocion(fidItemVenta,fechaInicioPromocion,fechaFinPromocion,tipoPromocion) VALUES(idPromocionPersonalizada,_fechaInicioPromocion,_fechaFinPromocion,_tipoPromocion);
    INSERT INTO promocionpersonalizada(idPromocionPersonalizada,mensajePromocionPersonalizada,fidTarjeta,activo) VALUES(idPromocionPersonalizada,_mensajePromocionPersonalizada,_fidTarjeta,1);
END$

CREATE PROCEDURE LISTAR_PROMOCIONPERSONALIZADA()
BEGIN
    SELECT pp.idPromocionPersonalizada,pp.mensajePromocionPersonalizada,p.idPromocion,p.fechaInicioPromocion,p.fechaFinPromocion,p.tipoPromocion,i.idItemVenta,i.nombreItemventa,i.descripcionItemventa,i.precioUnitarioItemventa,t.idTarjeta,t.puntosTarjetastar,t.fechaRegistroTarjetastar,per.idPersona,per.nombresPersona,per.apellidoPatPersona,per.apellidoMatPersona,per.numDocumentoPersona,per.telefono1Persona,per.telefono2Persona,per.emailPersona,per.domicilioPersona,per.fechaRegistroPersona,per.fechaNacimientoPersona,c.aceptaPublicidadCliente FROM promocionpersonalizada pp INNER JOIN promocion p ON pp.idPromocionPersonalizada = p.fidItemVenta INNER JOIN itemventa i ON p.fidItemVenta = i.idItemVenta INNER JOIN tarjetastar t ON pp.fidTarjeta = t.idTarjeta INNER JOIN cliente c ON t.fidCliente = c.idCliente INNER JOIN persona per ON c.idCliente = per.idPersona WHERE pp.activo = 1;
END$
  
CREATE PROCEDURE MODIFICAR_PROMOCIONPERSONALIZADA(
    IN _idPromocionPersonalizada INT,
    IN _mensajePromocionPersonalizada VARCHAR(200),
    IN _fidTarjeta INT
)
BEGIN
    UPDATE promocionpersonalizada SET mensajePromocionPersonalizada = _mensajePromocionPersonalizada,fidTarjeta = _fidTarjeta WHERE idPromocionPersonalizada = _idPromocionPersonalizada;
END$

CREATE PROCEDURE ELIMINAR_PROMOCIONPERSONALIZADA(
    IN _idPromocionPersonalizada INT
)
BEGIN
    UPDATE promocionpersonalizada SET activo = 0 WHERE idPromocionPersonalizada = _idPromocionPersonalizada;
END$
/*Proveedor*/
CREATE PROCEDURE INSERTAR_PROVEEDOR(
    OUT _id_proveedor INT,
    IN _RUCProveedor VARCHAR(20),
    IN _razon_socialProveedor VARCHAR(150),
    IN _direccionProveedor VARCHAR(150),
    IN _emailProveedor VARCHAR(100),
    IN _telefonoProveedor VARCHAR(30)
)
BEGIN
    INSERT INTO proveedor(RUCProveedor, razon_socialProveedor, direccionProveedor, emailProveedor, telefonoProveedor, activo) VALUES(_RUCProveedor, _razon_socialProveedor, _direccionProveedor, _emailProveedor, _telefonoProveedor, 1);
    SET _id_proveedor = @@last_insert_id;
END$

CREATE PROCEDURE LISTAR_PROVEEDOR()
BEGIN
    SELECT id_proveedor,RUCProveedor,razon_socialProveedor,direccionProveedor,emailProveedor,telefonoProveedor FROM proveedor WHERE activo = 1;
END$

CREATE PROCEDURE MODIFICAR_PROVEEDOR(
    IN _id_proveedor INT,
    IN _RUCProveedor VARCHAR(20),
    IN _razon_socialProveedor VARCHAR(150),
    IN _direccionProveedor VARCHAR(150),
    IN _emailProveedor VARCHAR(100),
    IN _telefonoProveedor VARCHAR(30),
    IN _activo TINYINT
)
BEGIN
    UPDATE proveedor SET RUCProveedor = _RUCProveedor, razon_socialProveedor = _razon_socialProveedor, direccionProveedor = _direccionProveedor, emailProveedor = _emailProveedor, telefonoProveedor = _telefonoProveedor WHERE id_proveedor = _id_proveedor;
END$

CREATE PROCEDURE ELIMINAR_PROVEEDOR(
    IN _id_proveedor INT
)
BEGIN
    UPDATE proveedor SET activo = 0 WHERE id_proveedor = _id_proveedor;
END$

/*Orden de compra*/
CREATE PROCEDURE INSERTAR_ORDENCOMPRA(
    OUT _id_compra INT,
    IN _fechaCompraOrdenCompra DATE,
    IN _estadoOrdenCompra VARCHAR(20),
    IN _fid_proveedor INT,
    IN _fid_sucursal INT
)
BEGIN
    INSERT INTO ordenCompra(fechaCompraOrdenCompra,estadoOrdenCompra,fid_proveedor,fid_sucursal,activo) VALUES(_fechaCompraOrdenCompra,_estadoOrdenCompra,_fid_proveedor,_fid_sucursal,1);
    SET _id_compra = @@last_insert_id;
END;

CREATE PROCEDURE LISTAR_ORDENCOMPRA()
BEGIN
    SELECT o.id_compra,o.fechaCompraOrdenCompra,o.estadoOrdenCompra,p.id_proveedor,p.RUCProveedor,p.razon_socialProveedor,p.direccionProveedor,p.emailProveedor,p.telefonoProveedor,s.id_sucursal,s.nombreSucursal,s.direccionSucursal,s.aforoSucursal,s.telefonoSucursal,s.emailSucursal,m.id_matriz,m.nombreMatriz,m.razonsocialMatriz,m.direccionMatriz,m.telefonoMatriz,m.emailMatriz FROM ordenCompra o INNER JOIN proveedor p ON o.fid_proveedor=p.id_proveedor INNER JOIN sucursal s ON o.fid_sucursal=s.id_sucursal INNER JOIN matriz m ON s.fid_matriz=m.id_matriz WHERE activo = 1;
END;

CREATE PROCEDURE LISTAR_ORDENCOMPRA_POR_PROVEEDOR(
    IN _id_proveedor INT
)
BEGIN
    SELECT o.id_compra,o.fechaCompraOrdenCompra,o.estadoOrdenCompra,p.id_proveedor FROM ordenCompra o INNER JOIN proveedor p ON o.fid_proveedor=p.id_proveedor WHERE o.fid_proveedor = _id_proveedor AND activo = 1;
END;

CREATE PROCEDURE MODIFICAR_ORDENCOMPRA(
    IN _id_compra INT,
    IN _fechaCompraOrdenCompra DATE,
    IN _estadoOrdenCompra VARCHAR(20),
    IN _fid_proveedor INT,
    IN _fid_sucursal INT
)
BEGIN
    UPDATE ordenCompra SET fechaCompraOrdenCompra = _fechaCompraOrdenCompra, estadoOrdenCompra = _estadoOrdenCompra, fid_proveedor = _fid_proveedor, fid_sucursal = _fid_sucursal WHERE id_compra = _id_compra;
END;

CREATE PROCEDURE ELIMINAR_ORDENCOMPRA(
    IN _id_compra INT
)
BEGIN
    UPDATE ordenCompra SET activo = 0 WHERE id_compra = _id_compra;
END;

/*LO DEJO AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII X2*/
/*Merma*/
CREATE PROCEDURE INSERTAR_MERMA(
    OUT _idMerma INT,
    IN _fechaRegistroMerma DATE,
    IN _cantidadMerma DECIMAL(10,2),
    IN _motivoMerma VARCHAR(200),
    IN _fid_lote INT
)BEGIN
    INSERT INTO merma(fechaRegistroMerma,cantidadMerma,motivoMerma,fid_lote,activo) VALUES(_fechaRegistroMerma,_cantidadMerma,_motivoMerma,_fid_lote,1);
    SET _idMerma = @@last_insert_id;
END$

CREATE PROCEDURE LISTAR_MERMA()
BEGIN
    SELECT id_merma,fechaRegistroMerma,cantidadMerma,motivoMerma,fid_lote FROM merma WHERE activo = 1;
END$    

CREATE PROCEDURE MODIFICAR_MERMA(
    IN _idMerma INT,
    IN _fechaRegistroMerma DATE,
    IN _cantidadMerma DECIMAL(10,2),
    IN _motivoMerma VARCHAR(200),
    IN _fid_lote INT
)BEGIN
    UPDATE merma SET fechaRegistroMerma = _fechaRegistroMerma, cantidadMerma = _cantidadMerma, motivoMerma = _motivoMerma, fid_lote = _fid_lote WHERE id_merma = _idMerma;
END$

CREATE PROCEDURE ELIMINAR_MERMA(
    IN _idMerma INT
)BEGIN
    UPDATE merma SET activo = 0 WHERE id_merma = _idMerma;
END$

/*Contacto*/
CREATE PROCEDURE INSERTAR_CONTACTO(
    OUT _idContacto INT,
    IN _nombresPersona VARCHAR(70),
    IN _apellidoPatPersona VARCHAR(70),
    IN _apellidoMatPersona VARCHAR(70),
    IN _numDocumentoPersona VARCHAR(20),
    IN _telefono1Persona VARCHAR(70),
    IN _telefono2Persona VARCHAR(70),
    IN _emailPersona VARCHAR(70),
    IN _domicilioPersona VARCHAR(70),
    IN _fechaRegistroPersona DATE,
    IN _fechaNacimientoPersona DATE,
    IN _puestoContacto VARCHAR(100),
    IN _fid_proveedor INT
)BEGIN
    INSERT INTO persona(nombresPersona,apellidoPatPersona,apellidoMatPersona,numDocumentoPersona,telefono1Persona,telefono2Persona,emailPersona,domicilioPersona,fechaRegistroPersona,fechaNacimientoPersona) VALUES(_nombresPersona,_apellidoPatPersona,_apellidoMatPersona,_numDocumentoPersona,_telefono1Persona,_telefono2Persona,_emailPersona,_domicilioPersona,_fechaRegistroPersona,_fechaNacimientoPersona);
    SET _idContacto = @@last_insert_id;
    INSERT INTO contacto(idContacto,puestoContacto,fid_proveedor,activo) VALUES(_idContacto,_puestoContacto,_fid_proveedor,1);
END$

CREATE PROCEDURE LISTAR_CONTACTO()
BEGIN
    SELECT p.idPersonal,p.nombresPersona,p.apellidoPatPersona,p.apellidoMatPersona,p.numDocumentoPersona,p.telefono1Persona,p.telefono2Persona,p.emailPersona,p.domicilioPersona,p.fechaRegistroPersona,p.fechaNacimientoPersona,c.puestoContacto,c.fid_proveedor FROM persona p INNER JOIN contacto c ON p.idPersonal = c.idContacto WHERE c.activo=1;
END$

CREATE PROCEDURE MODIFICAR_CONTACTO(
    IN _idContacto INT,
    IN _nombresPersona VARCHAR(70),
    IN _apellidoPatPersona VARCHAR(70),
    IN _apellidoMatPersona VARCHAR(70),
    IN _numDocumentoPersona VARCHAR(20),
    IN _telefono1Persona VARCHAR(70),
    IN _telefono2Persona VARCHAR(70),
    IN _emailPersona VARCHAR(70),
    IN _domicilioPersona VARCHAR(70),
    IN _fechaRegistroPersona DATE,
    IN _fechaNacimientoPersona DATE,
    IN _puestoContacto VARCHAR(100),
    IN _fid_proveedor INT
)BEGIN
    UPDATE persona SET nombresPersona = _nombresPersona, apellidoPatPersona = _apellidoPatPersona, apellidoMatPersona = _apellidoMatPersona, numDocumentoPersona = _numDocumentoPersona, telefono1Persona = _telefono1Persona, telefono2Persona = _telefono2Persona, emailPersona = _emailPersona, domicilioPersona = _domicilioPersona, fechaRegistroPersona = _fechaRegistroPersona, fechaNacimientoPersona = _fechaNacimientoPersona WHERE idPersonal = _idContacto;
    UPDATE contacto SET puestoContacto = _puestoContacto, fid_proveedor = _fid_proveedor WHERE idContacto = _idContacto;
END$

CREATE PROCEDURE ELIMINAR_CONTACTO(
    IN _idContacto INT
)BEGIN
    UPDATE contacto SET activo = 0 WHERE idContacto = _idContacto;
END$

/*Mercancia*/
CREATE PROCEDURE INSERTAR_MERCANCIA(
    OUT _idMercancia INT,
    IN _nombreItemventa VARCHAR(100),
    IN _descripcionItemventa VARCHAR(100),
    IN _precioUnitarioItemventa DECIMAL(10,2),
    IN _categoriaMercancia VARCHAR(100),
    IN _codigoBarrasMercancia VARCHAR(255),
    IN _fid_lote INT
)BEGIN
    INSERT INTO itemventa(nombreItemventa,descripcionItemventa,precioUnitarioItemventa) VALUES(_nombreItemventa,_descripcionItemventa,_precioUnitarioItemventa);
    SET _idMercancia = @@last_insert_id;
    INSERT INTO producto(idProducto) VALUES(_idMercancia);
    INSERT INTO mercancia(idMercancia,categoriaMercancia,codigoBarrasMercancia,fid_lote,activo) VALUES(_idMercancia,_categoriaMercancia,_codigoBarrasMercancia,_fid_lote,1);
END$

CREATE PROCEDURE LISTAR_MERCANCIA()
BEGIN
    SELECT i.idItemVenta,i.nombreItemventa,i.descripcionItemventa,i.precioUnitarioItemventa,m.categoriaMercancia,m.codigoBarrasMercancia,m.fid_lote FROM itemventa i INNER JOIN producto p ON i.idItemVenta = p.idProducto INNER JOIN mercancia m ON p.idProducto = m.idMercancia WHERE m.activo=1;
END$

CREATE PROCEDURE MODIFICAR_MERCANCIA(
    IN _idMercancia INT,
    IN _nombreItemventa VARCHAR(100),
    IN _descripcionItemventa VARCHAR(100),
    IN _precioUnitarioItemventa DECIMAL(10,2),
    IN _categoriaMercancia VARCHAR(100),
    IN _codigoBarrasMercancia VARCHAR(255),
    IN _fid_lote INT
)BEGIN
    UPDATE itemventa SET nombreItemventa = _nombreItemventa, descripcionItemventa = _descripcionItemventa, precioUnitarioItemventa = _precioUnitarioItemventa WHERE idItemVenta = _idMercancia;
    UPDATE mercancia SET categoriaMercancia = _categoriaMercancia, codigoBarrasMercancia = _codigoBarrasMercancia, fid_lote = _fid_lote WHERE idMercancia = _idMercancia;
END$

CREATE PROCEDURE ELIMINAR_MERCANCIA(
    IN _idMercancia INT
)BEGIN
    UPDATE mercancia SET activo = 0 WHERE idMercancia = _idMercancia;
END$

/*Utensilios de servicio*/
CREATE PROCEDURE INSERTAR_UTENSILIOSDESERVICIO(
    OUT _idUtensiliosDeServicio INT,
    IN _nombreLote VARCHAR(100),
    IN _cantidadLote DECIMAL(10,2),
    IN _fid_compra INT,
    IN _activo TINYINT,
    IN _fidProducto INT
)BEGIN
    INSERT INTO lote(nombreLote,cantidadLote,fid_compra) VALUES(_nombreLote,_cantidadLote,_fid_compra);
    SET _idUtensiliosDeServicio = @@last_insert_id;
    INSERT INTO utensiliosDeServicio(idUtensiliosDeServicio,activo,fidProducto) VALUES(_idUtensiliosDeServicio,1,_fidProducto);
END$

CREATE PROCEDURE LISTAR_UTENSILIOSDESERVICIO()
BEGIN
    SELECT l.id_lote,l.nombreLote,l.cantidadLote,l.fid_compra,u.activo,u.fidProducto FROM lote l INNER JOIN utensiliosDeServicio u ON l.id_lote = u.idUtensiliosDeServicio WHERE u.activo=1;
END$    

CREATE PROCEDURE MODIFICAR_UTENSILIOSDESERVICIO(
    IN _idUtensiliosDeServicio INT,
    IN _nombreLote VARCHAR(100),
    IN _cantidadLote DECIMAL(10,2),
    IN _fid_compra INT,
    IN _activo TINYINT,
    IN _fidProducto INT
)BEGIN
    UPDATE lote SET nombreLote = _nombreLote, cantidadLote = _cantidadLote, fid_compra = _fid_compra WHERE id_lote = _idUtensiliosDeServicio;
    UPDATE utensiliosDeServicio SET fidProducto = _fidProducto WHERE idUtensiliosDeServicio = _idUtensiliosDeServicio;
END$

CREATE PROCEDURE ELIMINAR_UTENSILIOSDESERVICIO(
    IN _idUtensiliosDeServicio INT
)BEGIN
    UPDATE utensiliosDeServicio SET activo = 0 WHERE idUtensiliosDeServicio = _idUtensiliosDeServicio;
END$

/*Comida*/
CREATE PROCEDURE INSERTAR_COMIDA(
    OUT _idComida INT,
    IN _nombreItemventa VARCHAR(100),
    IN _descripcionItemventa VARCHAR(100),
    IN _precioUnitarioItemventa DECIMAL(10,2),
    IN _cantidadAlimento DECIMAL(10,2),
    IN _unidadMedidaAlimento VARCHAR(100),
    IN _caloriasAlimento INT,
    IN _tipoDeComida VARCHAR(100),
    IN _segundosACalentarComida INT
)BEGIN
    INSERT INTO itemventa(nombreItemventa,descripcionItemventa,precioUnitarioItemventa) VALUES(_nombreItemventa,_descripcionItemventa,_precioUnitarioItemventa);
    SET _idComida = @@last_insert_id;
    INSERT INTO producto(idProducto) VALUES(_idComida);
    INSERT INTO alimento(idAlimento,cantidadAlimento,unidadMedidaAlimento,caloriasAlimento) VALUES(_idComida,_cantidadAlimento,_unidadMedidaAlimento,_caloriasAlimento);
    INSERT INTO comida(idComida,tipoDeComida,segundosACalentarComida,activo) VALUES(_idComida,_tipoDeComida,_segundosACalentarComida,1);
END$

CREATE PROCEDURE LISTAR_COMIDA()
BEGIN
    SELECT i.idItemVenta,i.nombreItemventa,i.descripcionItemventa,i.precioUnitarioItemventa,a.cantidadAlimento,a.unidadMedidaAlimento,a.caloriasAlimento,c.tipoDeComida,c.segundosACalentarComida FROM itemventa i INNER JOIN producto p ON i.idItemVenta = p.idProducto INNER JOIN alimento a ON p.idProducto = a.idAlimento INNER JOIN comida c ON a.idAlimento = c.idComida WHERE c.activo=1;
END$

CREATE PROCEDURE MODIFICAR_COMIDA(
    IN _idComida INT,
    IN _nombreItemventa VARCHAR(100),
    IN _descripcionItemventa VARCHAR(100),
    IN _precioUnitarioItemventa DECIMAL(10,2),
    IN _cantidadAlimento DECIMAL(10,2),
    IN _unidadMedidaAlimento VARCHAR(100),
    IN _caloriasAlimento INT,
    IN _tipoDeComida VARCHAR(100),
    IN _segundosACalentarComida INT
)BEGIN
    UPDATE itemventa SET nombreItemventa = _nombreItemventa, descripcionItemventa = _descripcionItemventa, precioUnitarioItemventa = _precioUnitarioItemventa WHERE idItemVenta = _idComida;
    UPDATE alimento SET cantidadAlimento = _cantidadAlimento, unidadMedidaAlimento = _unidadMedidaAlimento, caloriasAlimento = _caloriasAlimento WHERE idAlimento = _idComida;
    UPDATE comida SET tipoDeComida = _tipoDeComida, segundosACalentarComida = _segundosACalentarComida WHERE idComida = _idComida;
END$

CREATE PROCEDURE ELIMINAR_COMIDA(
    IN _idComida INT
)BEGIN
    UPDATE comida SET activo = 0 WHERE idComida = _idComida;
END$

/*Bebida*/
CREATE PROCEDURE INSERTAR_BEBIDA(
    OUT _idBebida INT,
    IN _nombreItemventa VARCHAR(100),
    IN _descripcionItemventa VARCHAR(100),
    IN _precioUnitarioItemventa DECIMAL(10,2),
    IN _cantidadAlimento DECIMAL(10,2),
    IN _unidadMedidaAlimento VARCHAR(100),
    IN _caloriasAlimento INT,
    IN _tipoDeBebida VARCHAR(100),
    IN _esFriaBebida TINYINT,
    IN _tamanhoBebida varchar(100),
    IN _instruccionesPreparacionBebida VARCHAR(500),
    IN _tiempoPreparacionBebida INT
)BEGIN
    INSERT INTO itemventa(nombreItemventa,descripcionItemventa,precioUnitarioItemventa) VALUES(_nombreItemventa,_descripcionItemventa,_precioUnitarioItemventa);
    SET _idBebida = @@last_insert_id;
    INSERT INTO producto(idProducto) VALUES(_idBebida);
    INSERT INTO alimento(idAlimento,cantidadAlimento,unidadMedidaAlimento,caloriasAlimento) VALUES(_idBebida,_cantidadAlimento,_unidadMedidaAlimento,_caloriasAlimento);
    INSERT INTO bebida(idBebida,tipoDeBebida,esFriaBebida,tamanhoBebida,instruccionesPreparacionBebida,tiempoPreparacionBebida,activo) VALUES(_idBebida,_tipoDeBebida,_esFriaBebida,_tamanhoBebida,_instruccionesPreparacionBebida,_tiempoPreparacionBebida,1);
END$

CREATE PROCEDURE LISTAR_BEBIDA()
BEGIN
    SELECT i.idItemVenta,i.nombreItemventa,i.descripcionItemventa,i.precioUnitarioItemventa,a.cantidadAlimento,a.unidadMedidaAlimento,a.caloriasAlimento,b.tipoDeBebida,b.esFriaBebida,b.tamanhoBebida,b.instruccionesPreparacionBebida,b.tiempoPreparacionBebida FROM itemventa i INNER JOIN producto p ON i.idItemVenta = p.idProducto INNER JOIN alimento a ON p.idProducto = a.idAlimento INNER JOIN bebida b ON a.idAlimento = b.idBebida WHERE b.activo=1;
END$    

CREATE PROCEDURE MODIFICAR_BEBIDA(
    IN _idBebida INT,
    IN _nombreItemventa VARCHAR(100),
    IN _descripcionItemventa VARCHAR(100),
    IN _precioUnitarioItemventa DECIMAL(10,2),
    IN _cantidadAlimento DECIMAL(10,2),
    IN _unidadMedidaAlimento VARCHAR(100),
    IN _caloriasAlimento INT,
    IN _tipoDeBebida VARCHAR(100),
    IN _esFriaBebida TINYINT,
    IN _tamanhoBebida varchar(100),
    IN _instruccionesPreparacionBebida VARCHAR(500),
    IN _tiempoPreparacionBebida INT
)BEGIN
    UPDATE itemventa SET nombreItemventa = _nombreItemventa, descripcionItemventa = _descripcionItemventa, precioUnitarioItemventa = _precioUnitarioItemventa WHERE idItemVenta = _idBebida;
    UPDATE alimento SET cantidadAlimento = _cantidadAlimento, unidadMedidaAlimento = _unidadMedidaAlimento, caloriasAlimento = _caloriasAlimento WHERE idAlimento = _idBebida;
    UPDATE bebida SET tipoDeBebida = _tipoDeBebida, esFriaBebida = _esFriaBebida, tamanhoBebida = _tamanhoBebida, instruccionesPreparacionBebida = _instruccionesPreparacionBebida, tiempoPreparacionBebida = _tiempoPreparacionBebida WHERE idBebida = _idBebida;
END$

CREATE PROCEDURE ELIMINAR_BEBIDA(
    IN _idBebida INT
)BEGIN
    UPDATE bebida SET activo = 0 WHERE idBebida = _idBebida;
END$

/*Ingrediente*/
CREATE PROCEDURE INSERTAR_INGREDIENTE(
    OUT _idIngrediente INT,
    IN _nombreIngrediente VARCHAR(100),
    IN _cantidadIngrediente DECIMAL(10,2),
    IN _unidadMedidaIngrediente VARCHAR(20),
    IN _fid_bebida INT
)BEGIN
    INSERT INTO ingrediente(nombreIngrediente,cantidadIngrediente,unidadMedidaIngrediente,fid_bebida,activo) VALUES(_nombreIngrediente,_cantidadIngrediente,_unidadMedidaIngrediente,_fid_bebida,1);
    SET _idIngrediente = @@last_insert_id;
END$

CREATE PROCEDURE LISTAR_INGREDIENTE()
BEGIN
    SELECT id_ingrediente,nombreIngrediente,cantidadIngrediente,unidadMedidaIngrediente,fid_bebida FROM ingrediente WHERE activo = 1;
END$    

CREATE PROCEDURE MODIFICAR_INGREDIENTE(
    IN _idIngrediente INT,
    IN _nombreIngrediente VARCHAR(100),
    IN _cantidadIngrediente DECIMAL(10,2),
    IN _unidadMedidaIngrediente VARCHAR(20),
    IN _fid_bebida INT  
)BEGIN
    UPDATE ingrediente SET nombreIngrediente = _nombreIngrediente, cantidadIngrediente = _cantidadIngrediente, unidadMedidaIngrediente = _unidadMedidaIngrediente, fid_bebida = _fid_bebida WHERE id_ingrediente = _idIngrediente;
END$

CREATE PROCEDURE ELIMINAR_INGREDIENTE(
    IN _idIngrediente INT
)BEGIN
    UPDATE ingrediente SET activo = 0 WHERE id_ingrediente = _idIngrediente;
END$

/*Insumo perecible*/
CREATE PROCEDURE INSERTAR_INSUMOPERECIBLE(
    OUT _id_insumoPerecible INT,
    IN _nombreLote VARCHAR(100),
    IN _cantidadLote DECIMAL(10,2),
    IN _fid_compra INT,

    IN _fechaProduccionInsumoPerecible DATE,
    IN _fechaVencimientoInsumoPerecible DATE,
    IN _fid_comida INT,
    IN _fid_ingrediente INT
)BEGIN
    INSERT INTO lote(nombreLote,cantidadLote,fid_compra) VALUES(_nombreLote,_cantidadLote,_fid_compra);
    SET _id_insumoPerecible = @@last_insert_id;
    INSERT INTO insumoPerecible(id_insumoPerecible,fechaProduccionInsumoPerecible,fechaVencimientoInsumoPerecible,fid_comida,fid_ingrediente,activo) VALUES(_id_insumoPerecible,_fechaProduccionInsumoPerecible,_fechaVencimientoInsumoPerecible,_fid_comida,_fid_ingrediente,1);
END$

CREATE PROCEDURE LISTAR_INSUMOPERECIBLE()
BEGIN
    SELECT l.id_lote,l.nombreLote,l.cantidadLote,l.fid_compra,i.fechaProduccionInsumoPerecible,i.fechaVencimientoInsumoPerecible,i.fid_comida,i.fid_ingrediente FROM lote l INNER JOIN insumoPerecible i ON l.id_lote = i.id_insumoPerecible WHERE i.activo=1;
END$    

CREATE PROCEDURE MODIFICAR_INSUMOPERECIBLE(
    IN _id_insumoPerecible INT,
    IN _nombreLote VARCHAR(100),
    IN _cantidadLote DECIMAL(10,2),
    IN _fid_compra INT,

    IN _fechaProduccionInsumoPerecible DATE,
    IN _fechaVencimientoInsumoPerecible DATE,
    IN _fid_comida INT,
    IN _fid_ingrediente INT
)BEGIN
    UPDATE lote SET nombreLote = _nombreLote, cantidadLote = _cantidadLote, fid_compra = _fid_compra WHERE id_lote = _id_insumoPerecible;
    UPDATE insumoPerecible SET fechaProduccionInsumoPerecible = _fechaProduccionInsumoPerecible, fechaVencimientoInsumoPerecible = _fechaVencimientoInsumoPerecible, fid_comida = _fid_comida, fid_ingrediente = _fid_ingrediente WHERE id_insumoPerecible = _id_insumoPerecible;
END$

CREATE PROCEDURE ELIMINAR_INSUMOPERECIBLE(
    IN _id_insumoPerecible INT
)BEGIN
    UPDATE insumoPerecible SET activo = 0 WHERE id_insumoPerecible = _id_insumoPerecible;
END$




