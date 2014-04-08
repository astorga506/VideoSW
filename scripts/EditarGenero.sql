CREATE PROCEDURE EditarGenero
(
	@cod_genero int,
	@nombre_genero nvarchar(max)
)
AS
BEGIN
	UPDATE Genero
   SET nombre_genero = RTRIM(@nombre_genero)
 WHERE cod_genero = @cod_genero
END
GO
