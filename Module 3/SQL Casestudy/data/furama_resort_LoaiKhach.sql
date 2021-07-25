CREATE TABLE LoaiKhach
(
    idLoaiKhach  int         NOT NULL
        PRIMARY KEY,
    tenLoaiKhach varchar(45) NULL
);

INSERT INTO furama_resort.LoaiKhach (idLoaiKhach, tenLoaiKhach) VALUES (1, 'Member');
INSERT INTO furama_resort.LoaiKhach (idLoaiKhach, tenLoaiKhach) VALUES (2, 'Silver');
INSERT INTO furama_resort.LoaiKhach (idLoaiKhach, tenLoaiKhach) VALUES (3, 'Gold');
INSERT INTO furama_resort.LoaiKhach (idLoaiKhach, tenLoaiKhach) VALUES (4, 'Platinum');
INSERT INTO furama_resort.LoaiKhach (idLoaiKhach, tenLoaiKhach) VALUES (5, 'Diamond');