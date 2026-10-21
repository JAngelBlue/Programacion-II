from juegos import JuegoAdivinaNumero


class Aplicacion:

    @staticmethod
    def main() -> None:
        juego = JuegoAdivinaNumero(3)
        juego.juega()


if __name__ == "__main__":
    Aplicacion.main()
