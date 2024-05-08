/*Script para crear la Tabla Funko en la BD de ORACLE*/

/*Creacion de la tabla*/
CREATE TABLE Funko(
    id_funko VARCHAR(20),
    nombre VARCHAR(30) NOT NULL,
    numero VARCHAR(6) NOT NULL,
    serie VARCHAR(60) NOT NULL,
    PRIMARY KEY(id_funko)
);

COMMIT;

/*Comando para ver la llave primaria en la tabla*/
 select uc.table_name, column_name from user_cons_columns ucc
  join user_constraints uc
  on ucc.constraint_name=uc.constraint_name
  where uc.constraint_type='P' and
  uc.table_name='FUNKO';

/*Nota:
    El nombre de la tabla debe de ir en MAYUSCULAS

*/

/*INSERCIONES*/
INSERT INTO funko VALUES('889698274487','yami yugi', '387', 'yu-gi-oh',20);
INSERT INTO funko VALUES('889698274505','seto kaiba', '388', 'yu-gi-oh',20);
INSERT INTO funko VALUES('889698469234','joey wheeler', '717', 'yu-gi-oh',20);