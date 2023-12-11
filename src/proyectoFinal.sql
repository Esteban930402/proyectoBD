CREATE TABLE paciente (
	cedulaPaciente
	fechaNacimiento
	POS
	telefono
	celular
	email
	nombreContacto
	telefonoContacto
	tipoPaciente
	
	PRIMARY KEY cedula;
)

CREATE TABLE infoPaciente(
	cedulaPaciente
	fechaExamenesPend
	fechaExamenesReal
	FOREIGN KEY cedula 
)

CREATE TABLE entidadSalud(
	nombreEntidad
	direccionEntidad
	telefonoEntidad
	
	PRIMARY KEY nombreEntidad
)

CREATE TABLE medico(
	tarjetaProfesional
	nombre
	apellidos
	telefono
	direccion
	especialidad
	
	PRIMARY KEY tarjetaProfesional
)

CREATE TABLE orden(
	idOrden
	cedulaPaciente
	tarjetaProfesional
	nombreEntidad
	fechaOrden
	fechaIngreso
	
	PRIMARY KEY idOrden
)

CREATE TABLE tipoExamen(
	tipoExamen
	Valor
	
	PRIMARY KEY tipoExamen
)

CREATE TABLE Realiza (
	realizaID
	ordenID
	tipoExamen
	cedulaPaciente
	fechaCita
	fechaRealizacion
	observaciones
	
	PRIMARY KEY realizaID
)

CREATE TABLE factura (
	facturaID
	numeroFactura
	tipoExamen
	fechaRealizacion
	cedulaPaciente
	ordenID
	
	PRIMARY KEY facturaID
)

CREATE TABLE facturaDetalle(
	facturaDetalleID
	facturaID
	tipoExamen
	numeroOrden
	cedulaPaciente
	nombreEntidad
	valortotalFactura
	
	PRIMARY KEY facturaDetalleID
)

CREATE TABLE consolidacionFinDeMes(
	tipoPaciente
	nombreEntidad
	
	PRIMARY KEY tipoPaciente
)

CREATE CLASS medicoPaciente(
	tarjetaProfesional
	ordenID
	cantidadOrdenes
)
