DROP TABLE MEDICAMENTOS IF EXISTS;
CREATE TABLE MEDICAMENTOS(
ID INT AUTO_INCREMENT PRIMARY KEY,
CODIGO INT NOT NULL,
NOMBRE VARCHAR(50) NOT NULL,
LABORATORIO VARCHAR(50) NOT NULL,
CANTIDAD INT NOT NULL,
PRECIO DECIMAL(7,2)
);

INSERT INTO MEDICAMENTOS VALUES (DEFAULT, 123, 'IBUPIRAC','BAYER', 10, 350),
(DEFAULT, 789, 'ACEMUK','PFIZER', 15, 450), (DEFAULT, 789, 'PARACETAMOL','BAGO', 10, 150);