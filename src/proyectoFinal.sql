CREATE TABLE paciente (
    cedulaPaciente INT PRIMARY KEY,
    fechaNacimiento DATE,
    POS VARCHAR(255),
    telefono VARCHAR(15),
    celular VARCHAR(15),
    email VARCHAR(255),
    nombreContacto VARCHAR(255),
    telefonoContacto VARCHAR(15),
    tipoPaciente VARCHAR(255)
);

CREATE TABLE infoPaciente (
    cedulaPaciente INT,
    fechaExamenesPend DATE,
    fechaExamenesReal DATE,
    FOREIGN KEY (cedulaPaciente) REFERENCES paciente(cedulaPaciente)
);

CREATE TABLE entidadSalud (
    nombreEntidad VARCHAR(255) PRIMARY KEY,
    direccionEntidad VARCHAR(255),
    telefonoEntidad VARCHAR(15)
);

CREATE TABLE medico (
    tarjetaProfesional INT PRIMARY KEY,
    nombre VARCHAR(255),
    apellidos VARCHAR(255),
    telefono VARCHAR(15),
    direccion VARCHAR(255),
    especialidad VARCHAR(255)
);

CREATE TABLE orden (
    idOrden INT PRIMARY KEY,
    cedulaPaciente INT,
    tarjetaProfesional INT,
    nombreEntidad VARCHAR(255),
    fechaOrden DATE,
    fechaIngreso DATE,
    FOREIGN KEY (cedulaPaciente) REFERENCES paciente(cedulaPaciente),
    FOREIGN KEY (tarjetaProfesional) REFERENCES medico(tarjetaProfesional),
    FOREIGN KEY (nombreEntidad) REFERENCES entidadSalud(nombreEntidad)
);

CREATE TABLE tipoExamen (
    tipoExamen VARCHAR(255) PRIMARY KEY,
    Valor DECIMAL(10, 2)
);

CREATE TABLE Realiza (
    realizaID INT PRIMARY KEY,
    ordenID INT,
    tipoExamen VARCHAR(255),
    cedulaPaciente INT,
    fechaCita DATE,
    fechaRealizacion DATE,
    observaciones VARCHAR(255),
    FOREIGN KEY (ordenID) REFERENCES orden(idOrden),
    FOREIGN KEY (tipoExamen) REFERENCES tipoExamen(tipoExamen),
    FOREIGN KEY (cedulaPaciente) REFERENCES paciente(cedulaPaciente)
);

CREATE TABLE factura (
    facturaID INT PRIMARY KEY,
    numeroFactura INT,
    tipoExamen VARCHAR(255),
    fechaRealizacion DATE,
    cedulaPaciente INT,
    ordenID INT,
    FOREIGN KEY (ordenID) REFERENCES orden(idOrden),
    FOREIGN KEY (tipoExamen) REFERENCES tipoExamen(tipoExamen),
    FOREIGN KEY (cedulaPaciente) REFERENCES paciente(cedulaPaciente)
);

CREATE TABLE facturaDetalle (
    facturaDetalleID INT PRIMARY KEY,
    facturaID INT,
    tipoExamen VARCHAR(255),
    numeroOrden INT,
    cedulaPaciente INT,
    nombreEntidad VARCHAR(255),
    valortotalFactura DECIMAL(10, 2),
    FOREIGN KEY (facturaID) REFERENCES factura(facturaID),
    FOREIGN KEY (tipoExamen) REFERENCES tipoExamen(tipoExamen),
    FOREIGN KEY (cedulaPaciente) REFERENCES paciente(cedulaPaciente),
    FOREIGN KEY (nombreEntidad) REFERENCES entidadSalud(nombreEntidad)
);

CREATE TABLE consolidacionFinDeMes (
    tipoPaciente VARCHAR(255),
    nombreEntidad VARCHAR(255),
    PRIMARY KEY (tipoPaciente, nombreEntidad)
);

CREATE TABLE medicoPaciente (
    tarjetaProfesional INT,
    ordenID INT,
    cantidadOrdenes INT,
    PRIMARY KEY (tarjetaProfesional, ordenID),
    FOREIGN KEY (tarjetaProfesional) REFERENCES medico(tarjetaProfesional),
    FOREIGN KEY (ordenID) REFERENCES orden(idOrden)
);

