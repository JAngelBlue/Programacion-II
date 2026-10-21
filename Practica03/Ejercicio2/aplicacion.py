from juegos import JuegoAdivinaNumero, JuegoAdivinaPar, JuegoAdivinaImpar


class Aplicacion:

    @staticmethod
    def main() -> None:
        juego1 = JuegoAdivinaNumero(3)
        juego2 = JuegoAdivinaPar(3)
        juego3 = JuegoAdivinaImpar(3)

        # Polimorfismo: juega() actúa según la clase real de cada objeto.
        for juego in (juego1, juego2, juego3):
            print(f"=== {type(juego).__name__} ===")
            juego.juega()
            print()


if __name__ == "__main__":
    Aplicacion.main()
