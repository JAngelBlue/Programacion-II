import random


class Juego:
    """Clase base de los juegos con vidas y récord."""

    def __init__(self, numeroDeVidas: int):
        if numeroDeVidas < 1:
            raise ValueError("El número de vidas debe ser al menos 1.")
        self.vidasIniciales = numeroDeVidas   # vidas al iniciar cada partida
        self.numeroDeVidas = numeroDeVidas    # vidas que le quedan al jugador
        self.record = 0                       # mejor resultado (vidas restantes)

    def reiniciaPartida(self) -> None:
        """Devuelve las vidas al valor inicial para empezar una nueva partida."""
        self.numeroDeVidas = self.vidasIniciales

    def actualizaRecord(self) -> None:
        """Guarda como récord las vidas restantes si superan al récord actual."""
        if self.numeroDeVidas > self.record:
            self.record = self.numeroDeVidas
            print(f"¡Nuevo récord: {self.record} vida(s) restante(s)!")

    def quitaVida(self) -> bool:
        """Quita una vida. Devuelve True si al jugador todavía le quedan vidas."""
        self.numeroDeVidas -= 1
        return self.numeroDeVidas > 0


class JuegoAdivinaNumero(Juego):
    """Juego en el que el usuario debe adivinar un número entre 0 y 10."""

    def __init__(self, numeroDeVidas: int):
        super().__init__(numeroDeVidas)
        self.numeroAAdivinar = 0

    def _leerEntero(self) -> int:
        """Lee un entero del teclado; repite si la entrada no es válida."""
        while True:
            try:
                return int(input("Tu número: "))
            except ValueError:
                print("Entrada no válida: escribe un número entero.")

    def juega(self) -> None:
        self.reiniciaPartida()
        self.numeroAAdivinar = random.randint(0, 10)
        print("Adivina un número entre 0 y 10.")

        while True:
            numero = self._leerEntero()

            if numero == self.numeroAAdivinar:
                print("Acertaste!!")
                self.actualizaRecord()
                return

            if self.quitaVida():
                pista = "mayor" if self.numeroAAdivinar > numero else "menor"
                print(f"Fallaste. El número a adivinar es {pista}. "
                      f"Te quedan {self.numeroDeVidas} vida(s). Prueba otra vez.")
            else:
                print("Fallaste y te quedaste sin vidas. "
                      f"El número era {self.numeroAAdivinar}.")
                return
