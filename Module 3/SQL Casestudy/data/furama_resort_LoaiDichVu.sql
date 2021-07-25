CREATE TABLE LoaiDichVu
(
    idLoaiDichVu  int         NOT NULL
        PRIMARY KEY,
    tenLoaiDichVu varchar(45) NULL
);

INSERT INTO furama_resort.LoaiDichVu (idLoaiDichVu, tenLoaiDichVu) VALUES (1, 'Room');
INSERT INTO furama_resort.LoaiDichVu (idLoaiDichVu, tenLoaiDichVu) VALUES (2, 'House');
INSERT INTO furama_resort.LoaiDichVu (idLoaiDichVu, tenLoaiDichVu) VALUES (3, 'Villa');