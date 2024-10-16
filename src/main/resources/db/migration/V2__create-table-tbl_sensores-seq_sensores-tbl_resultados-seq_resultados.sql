CREATE TABLE TBL_SENSORES (
                              ID INT AUTO_INCREMENT PRIMARY KEY,
                              NOME VARCHAR(100) NOT NULL,
                              INICIO TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                              ATIVO INT NOT NULL
);

CREATE TABLE TBL_RESULTADOS (
                                ID INT AUTO_INCREMENT PRIMARY KEY,
                                ID_SENSOR INT NOT NULL,
                                UMIDADE FLOAT NOT NULL,
                                HORARIO TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                                CONSTRAINT FK_SENSORES_RESULTADO FOREIGN KEY (ID_SENSOR)
                                    REFERENCES TBL_SENSORES(ID)
);