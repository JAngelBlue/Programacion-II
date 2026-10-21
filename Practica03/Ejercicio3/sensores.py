class Sensor:
    """Clase base de todos los sensores del vehículo."""

    tipo: str = "Genérico"                    # atributo de clase

    def __init__(self, id: str, **kwargs):
        # Se llama a super() primero para que la cadena cooperativa (MRO)
        # termine de inicializar a las demás clases antes de este constructor.
        super().__init__(**kwargs)
        self.id: str = id                     # atributo de instancia
        self.encendido: bool = False          # atributo de instancia

    def activar(self) -> None:
        self.encendido = True
        print(f"[{self.tipo} {self.id}] activado")

    def desactivar(self) -> None:
        self.encendido = False
        print(f"[{self.tipo} {self.id}] desactivado")


class Camara(Sensor):
    tipo: str = "Cámara"                      # atributo de clase

    def __init__(self, id: str, resolucion: str, **kwargs):
        super().__init__(id=id, **kwargs)
        self.resolucion: str = resolucion     # atributo de instancia


class SensorLuzLaser(Sensor):
    tipo: str = "Luz Laser"                   # atributo de clase

    def __init__(self, id: str, alcance: int, **kwargs):
        super().__init__(id=id, **kwargs)
        self.alcance: int = alcance           # atributo de instancia


class VehiculoAutonomo(Camara, SensorLuzLaser):
    tipo: str = "Vehículo Autónomo"           # atributo de clase

    def __init__(self, id: str, resolucion: str, alcance: int):
        # Con super() cada constructor de la cadena (Camara -> SensorLuzLaser
        # -> Sensor) se ejecuta una sola vez, aunque Sensor sea el ancestro común.
        super().__init__(id=id, resolucion=resolucion, alcance=alcance)
