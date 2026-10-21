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

    def validaNumero(self, numero: int) -> bool:
        """True si el número está entre 0 y 10 (ambos incluidos)."""
        return 0 <= numero <= 10

    def generaNumero(self) -> int:
        """Genera el número secreto. Las subclases lo adaptan a su regla."""
        return random.randint(0, 10)

    def _leerEntero(self) -> int:
        """Lee un entero del teclado; repite si la entrada no es válida."""
        while True:
            try:
                return int(input("Tu número: "))
            except ValueError:
                print("Entrada no válida: escribe un número entero.")

    def juega(self) -> None:
        self.reiniciaPartida()
        self.numeroAAdivinar = self.generaNumero()
        print("Adivina un número entre 0 y 10.")

        while True:
            numero = self._leerEntero()

            # Un número no válido no cuesta vidas: solo se vuelve a pedir.
            if not self.validaNumero(numero):
                print("Número no válido: no pierdes vidas. Inténtalo de nuevo.")
                continue

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


class JuegoAdivinaPar(JuegoAdivinaNumero):
    """Variante en la que solo se aceptan números pares."""

    def validaNumero(self, numero: int) -> bool:
        if not super().validaNumero(numero):
            return False
        if numero % 2 != 0:
            print("Error: en este juego solo se aceptan números pares.")
            return False
        return True

    def generaNumero(self) -> int:
        return random.randrange(0, 11, 2)     # 0, 2, 4, 6, 8, 10


class JuegoAdivinaImpar(JuegoAdivinaNumero):
    """Variante en la que solo se aceptan números impares."""

    def validaNumero(self, numero: int) -> bool:
        if not super().validaNumero(numero):
            return False
        if numero % 2 == 0:
            print("Error: en este juego solo se aceptan números impares.")
            return False
        return True

    def generaNumero(self) -> int:
        return random.randrange(1, 11, 2)     # 1, 3, 5, 7, 9
