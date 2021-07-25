CREATE TABLE KieuThue
(
    idKieuThue  int         NOT NULL
        PRIMARY KEY,
    tenKieuThue varchar(45) NULL,
    gia         int         NULL
);

INSERT INTO furama_resort.KieuThue (idKieuThue, tenKieuThue, gia) VALUES (1, 'Gio', 100);
INSERT INTO furama_resort.KieuThue (idKieuThue, tenKieuThue, gia) VALUES (2, 'Ngay', 2000);
INSERT INTO furama_resort.KieuThue (idKieuThue, tenKieuThue, gia) VALUES (3, 'Thang', 10000);
INSERT INTO furama_resort.KieuThue (idKieuThue, tenKieuThue, gia) VALUES (4, 'Nam', 99999);