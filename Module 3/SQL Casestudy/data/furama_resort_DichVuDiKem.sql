CREATE TABLE DichVuDiKem
(
    idDichVuDiKem    int         NOT NULL
        PRIMARY KEY,
    tenDichVuDiKem   varchar(45) NULL,
    gia              int         NULL,
    donVi            int         NULL,
    trangThaiKhaDung varchar(45) NULL
);

INSERT INTO furama_resort.DichVuDiKem (idDichVuDiKem, tenDichVuDiKem, gia, donVi, trangThaiKhaDung) VALUES (1, 'Massage', 50, 1, 'San sang');
INSERT INTO furama_resort.DichVuDiKem (idDichVuDiKem, tenDichVuDiKem, gia, donVi, trangThaiKhaDung) VALUES (2, 'Karaoke', 20, 1, 'San sang');
INSERT INTO furama_resort.DichVuDiKem (idDichVuDiKem, tenDichVuDiKem, gia, donVi, trangThaiKhaDung) VALUES (3, 'Food', 50, 1, 'San sang');
INSERT INTO furama_resort.DichVuDiKem (idDichVuDiKem, tenDichVuDiKem, gia, donVi, trangThaiKhaDung) VALUES (4, 'Car', 70, 1, 'Chua san sang');
INSERT INTO furama_resort.DichVuDiKem (idDichVuDiKem, tenDichVuDiKem, gia, donVi, trangThaiKhaDung) VALUES (5, 'Computer', 10, 1, 'San sang');