from sensores import Sensor, Camara, SensorLuzLaser, VehiculoAutonomo


def main() -> None:
    sensor = Sensor("S-001")
    camara = Camara("C-001", "1920x1080")
    laser = SensorLuzLaser("L-001", 150)
    vehiculo = VehiculoAutonomo("V-001", "3840x2160", 200)
    objetos = (sensor, camara, laser, vehiculo)

    print("--- 1. Atributos de clase (compartidos por todas las instancias) ---")
    for clase in (Sensor, Camara, SensorLuzLaser, VehiculoAutonomo):
        print(f"{clase.__name__}.tipo = {clase.tipo!r}")

    print("\n--- 2. Atributos de instancia (propios de cada objeto) ---")
    for obj in objetos:
        print(f"{type(obj).__name__:<16} {vars(obj)}")

    print("\n--- 3. Orden de resolución de métodos (MRO) de VehiculoAutonomo ---")
    print(" -> ".join(clase.__name__ for clase in VehiculoAutonomo.__mro__))

    print("\n--- 4. Herencia múltiple (cámara y sensor láser a la vez) ---")
    for clase in (Camara, SensorLuzLaser, Sensor):
        print(f"isinstance(vehiculo, {clase.__name__}):", isinstance(vehiculo, clase))

    print("\n--- 5. Métodos heredados de Sensor ---")
    print("Encendido antes de activar:", vehiculo.encendido)
    vehiculo.activar()
    print("Encendido después de activar:", vehiculo.encendido)
    vehiculo.desactivar()
    print("Encendido después de desactivar:", vehiculo.encendido)


if __name__ == "__main__":
    main()
