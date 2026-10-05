
-- =====================================================================
-- SEGURIDAD (roles y usuarios)  ->  admin / (tu contraseña) ; cliente1 / cliente123 ; proveedor1 / proveedor123
-- =====================================================================
INSERT INTO rol (name) VALUES ('ROLE_ADMIN');
INSERT INTO rol (name) VALUES ('ROLE_CLIENTE');
INSERT INTO rol (name) VALUES ('ROLE_PROVEEDOR');

INSERT INTO usuario (username, password, id_rol) VALUES ('admin', '$2a$12$nOdsqOBuJkgd4QotKGPc9OGpauXfOK8ckLINgWdMU3MWm/VuDk9du', 1);
INSERT INTO usuario (username, password, id_rol) VALUES ('cliente1', '$2a$10$hW4NAYyfd2egzfjt0wNJKuKwRZnxWEnAkYSfJ4y.eOqGuiAVfNxUa', 2);
INSERT INTO usuario (username, password, id_rol) VALUES ('proveedor1', '$2a$10$AX5kE5Aoddbcm8gqW2Bh9e7yepVxyRNL00D0Y2TsXv28jKeZlSe0e', 3);

-- =====================================================================
-- NEGOCIO (los ids salen en orden 1, 2, 3... por eso no se escriben)
-- =====================================================================
INSERT INTO administrador (nombre, apellido, dni) VALUES ('Rosa', 'Villanueva', '40123456');
INSERT INTO administrador (nombre, apellido, dni) VALUES ('Luis', 'Campos', '41234567');

INSERT INTO proveedor (razon_social, ruc, telefono, direccion) VALUES ('Distribuidora Salud Perú SAC', '20512345678', '014551111', 'Av. Argentina 2450, Callao');
INSERT INTO proveedor (razon_social, ruc, telefono, direccion) VALUES ('Farmalider SAC', '20523456789', '014552222', 'Jr. Lampa 890, Lima');
INSERT INTO proveedor (razon_social, ruc, telefono, direccion) VALUES ('Medicorp Perú SRL', '20534567890', '014553333', 'Av. Venezuela 1500, Lima');

INSERT INTO cliente (nombre, apellido, dni) VALUES ('Juan', 'Pérez', '70123456');
INSERT INTO cliente (nombre, apellido, dni) VALUES ('María', 'Torres', '71234567');
INSERT INTO cliente (nombre, apellido, dni) VALUES ('Pedro', 'Gómez', '72345678');

INSERT INTO tipo_servicio (nombre) VALUES ('Consulta');
INSERT INTO tipo_servicio (nombre) VALUES ('Laboratorio');
INSERT INTO tipo_servicio (nombre) VALUES ('Diagnóstico');
INSERT INTO tipo_servicio (nombre) VALUES ('Vacunación');
INSERT INTO tipo_servicio (nombre) VALUES ('Farmacia');

INSERT INTO especialidad (nombre, descripcion) VALUES ('Medicina General', 'Atención primaria y control general de salud');
INSERT INTO especialidad (nombre, descripcion) VALUES ('Pediatría', 'Atención médica de niños y adolescentes');
INSERT INTO especialidad (nombre, descripcion) VALUES ('Cardiología', 'Diagnóstico y tratamiento del corazón');
INSERT INTO especialidad (nombre, descripcion) VALUES ('Dermatología', 'Enfermedades de la piel');

INSERT INTO centro_medico (direccion, latitud, longitud, tipo_gestion, telefono, distrito, ciudad, id_administrador) VALUES ('Av. Larco 345', -12.1219, -77.0297, 'Privada', '014445555', 'Miraflores', 'Lima', 1);
INSERT INTO centro_medico (direccion, latitud, longitud, tipo_gestion, telefono, distrito, ciudad, id_administrador) VALUES ('Av. Javier Prado Este 1200', -12.0977, -77.0365, 'Privada', '014446666', 'San Isidro', 'Lima', 1);
INSERT INTO centro_medico (direccion, latitud, longitud, tipo_gestion, telefono, distrito, ciudad, id_administrador) VALUES ('Av. Primavera 890', -12.1050, -76.9700, 'Pública', '014447777', 'Santiago de Surco', 'Lima', 2);
INSERT INTO centro_medico (direccion, latitud, longitud, tipo_gestion, telefono, distrito, ciudad, id_administrador) VALUES ('Jr. Cusco 120', -12.0464, -77.0428, 'Pública', '014448888', 'Cercado de Lima', 'Lima', 2);

INSERT INTO medico (numerocolegiatura, nombre, apellido, fecha_nacimiento, id_centro_medico) VALUES (45123, 'Carlos', 'Mendoza', '1980-04-12', 1);
INSERT INTO medico (numerocolegiatura, nombre, apellido, fecha_nacimiento, id_centro_medico) VALUES (38210, 'Lucía', 'Paredes', '1985-09-23', 1);
INSERT INTO medico (numerocolegiatura, nombre, apellido, fecha_nacimiento, id_centro_medico) VALUES (51002, 'Jorge', 'Salazar', '1978-01-30', 2);
INSERT INTO medico (numerocolegiatura, nombre, apellido, fecha_nacimiento, id_centro_medico) VALUES (47789, 'Marta', 'Quispe', '1983-06-15', 3);
INSERT INTO medico (numerocolegiatura, nombre, apellido, fecha_nacimiento, id_centro_medico) VALUES (52341, 'Andrea', 'Rojas', '1990-11-02', 4);

INSERT INTO medico_especialidad (id_medico, id_especialidad) VALUES (1, 1);
INSERT INTO medico_especialidad (id_medico, id_especialidad) VALUES (1, 3);
INSERT INTO medico_especialidad (id_medico, id_especialidad) VALUES (2, 2);
INSERT INTO medico_especialidad (id_medico, id_especialidad) VALUES (3, 1);
INSERT INTO medico_especialidad (id_medico, id_especialidad) VALUES (3, 3);
INSERT INTO medico_especialidad (id_medico, id_especialidad) VALUES (4, 3);
INSERT INTO medico_especialidad (id_medico, id_especialidad) VALUES (5, 4);

INSERT INTO medicamento (nommbre_comercial, principio_activo, laboratorio, presentacion, fecha_registro, descripcion, precio, stock, id_proveedor, id_centro_medico) VALUES ('Panadol', 'Paracetamol', 'GSK', 'Tableta 500mg', '2026-01-10', 'Analgésico y antipirético', 8.50, 120, 1, 1);
INSERT INTO medicamento (nommbre_comercial, principio_activo, laboratorio, presentacion, fecha_registro, descripcion, precio, stock, id_proveedor, id_centro_medico) VALUES ('Paracetamol Genfar', 'Paracetamol', 'Genfar', 'Jarabe 120ml', '2026-01-15', 'Analgésico pediátrico', 12.90, 60, 1, 1);
INSERT INTO medicamento (nommbre_comercial, principio_activo, laboratorio, presentacion, fecha_registro, descripcion, precio, stock, id_proveedor, id_centro_medico) VALUES ('Panadol', 'Paracetamol', 'GSK', 'Tableta 500mg', '2026-02-01', 'Analgésico y antipirético', 9.20, 80, 2, 2);
INSERT INTO medicamento (nommbre_comercial, principio_activo, laboratorio, presentacion, fecha_registro, descripcion, precio, stock, id_proveedor, id_centro_medico) VALUES ('Amoxidal', 'Amoxicilina', 'Medifarma', 'Cápsula 500mg', '2026-02-10', 'Antibiótico de amplio espectro', 15.00, 50, 2, 2);
INSERT INTO medicamento (nommbre_comercial, principio_activo, laboratorio, presentacion, fecha_registro, descripcion, precio, stock, id_proveedor, id_centro_medico) VALUES ('Ibuprofeno MK', 'Ibuprofeno', 'Tecnoquímicas', 'Tableta 400mg', '2026-03-05', 'Antiinflamatorio', 6.80, 200, 3, 3);
INSERT INTO medicamento (nommbre_comercial, principio_activo, laboratorio, presentacion, fecha_registro, descripcion, precio, stock, id_proveedor, id_centro_medico) VALUES ('Loratadina Portugal', 'Loratadina', 'Portugal', 'Tableta 10mg', '2026-03-12', 'Antialérgico', 5.50, 90, 3, 3);
INSERT INTO medicamento (nommbre_comercial, principio_activo, laboratorio, presentacion, fecha_registro, descripcion, precio, stock, id_proveedor, id_centro_medico) VALUES ('Omeprazol Genfar', 'Omeprazol', 'Genfar', 'Cápsula 20mg', '2026-04-01', 'Protector gástrico', 11.40, 70, 1, 4);
INSERT INTO medicamento (nommbre_comercial, principio_activo, laboratorio, presentacion, fecha_registro, descripcion, precio, stock, id_proveedor, id_centro_medico) VALUES ('Panadol', 'Paracetamol', 'GSK', 'Tableta 500mg', '2026-04-20', 'Analgésico y antipirético', 8.90, 150, 2, 4);

INSERT INTO servicio (nombre, precio, descripcion, id_centro_medico, id_medicamento, id_medico, id_tipo_servicio) VALUES ('Consulta de medicina general', 80.00, 'Consulta médica de 30 minutos', 1, NULL, 1, 1);
INSERT INTO servicio (nombre, precio, descripcion, id_centro_medico, id_medicamento, id_medico, id_tipo_servicio) VALUES ('Consulta pediátrica', 100.00, 'Control del niño sano', 1, NULL, 2, 1);
INSERT INTO servicio (nombre, precio, descripcion, id_centro_medico, id_medicamento, id_medico, id_tipo_servicio) VALUES ('Entrega de Panadol 500mg', 8.50, 'Dispensación en farmacia', 1, 1, NULL, 5);
INSERT INTO servicio (nombre, precio, descripcion, id_centro_medico, id_medicamento, id_medico, id_tipo_servicio) VALUES ('Entrega de Panadol 500mg', 9.20, 'Dispensación en farmacia', 2, 3, NULL, 5);
INSERT INTO servicio (nombre, precio, descripcion, id_centro_medico, id_medicamento, id_medico, id_tipo_servicio) VALUES ('Hemograma completo', 45.00, 'Análisis de sangre', 2, NULL, NULL, 2);
INSERT INTO servicio (nombre, precio, descripcion, id_centro_medico, id_medicamento, id_medico, id_tipo_servicio) VALUES ('Electrocardiograma', 120.00, 'Evaluación cardiaca', 3, NULL, 4, 3);
INSERT INTO servicio (nombre, precio, descripcion, id_centro_medico, id_medicamento, id_medico, id_tipo_servicio) VALUES ('Vacuna contra la influenza', 55.00, 'Dosis anual', 3, NULL, NULL, 4);
INSERT INTO servicio (nombre, precio, descripcion, id_centro_medico, id_medicamento, id_medico, id_tipo_servicio) VALUES ('Consulta dermatológica', 110.00, 'Evaluación de la piel', 4, NULL, 5, 1);

INSERT INTO centro_med_cliente_fav (id_cliente, id_centro_medico) VALUES (1, 1);
INSERT INTO centro_med_cliente_fav (id_cliente, id_centro_medico) VALUES (1, 3);
INSERT INTO centro_med_cliente_fav (id_cliente, id_centro_medico) VALUES (2, 2);