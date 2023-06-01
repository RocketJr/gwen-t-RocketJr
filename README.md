# Gwen't

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of the
[_Gwent_](https://www.playgwent.com/en) card game developed by [_CD PROJEKT RED_](https://cdprojektred.com/en/)

---

**The rest of the documentation is left for the users of this template to complete**

Para la entrega parcial 1, empecé realizando los distintos tests para los elementos básicos del juego: Jugador y Carta
Creando las distintas variables usadas en la clase player, como el nombre, su posición, las gemas(vidas), cartas en
el mazo y las cartas en su mano.
Además se crearon 2 funciones principales a la hora del juego, la primera de sacar carta de un mazo, donde se remueven
las cartas del mazo y se agregan a la mano. La otra función descuenta las cartas de una mano cuando son jugadas.

En la entrega final 2, se crearon 2 clases nuevas, la clase Board y WeatherZone. En esta clase Board, se crearon
distintas variables que representan las distintas zonas del tablero. En donde en cada una de ellas se puede jugar una
carta, mostrar su contenido y usar los setters para dejar una zona con contenido predeterminado. Aquí la excepción de
estas variables es la Zona Clima, la cual como clase se inicia como variable en nuestra clase Board. Para poder
usar las funciones como cualquier otra zona, se hace una funcion que llama a otra funcion dentro de la clase
WeatherZone, esto solamente para mantener la consistencia al usar las funciones. Asi todas las funciones que afectan a
las distintas zonas sean iguales. Por ejemplo usar:

val zone1: WeatherZone = WeatherZone.getInstance()

val zone2: WeatherZone = WeatherZone.getInstance()

var board1 = new Board(zone1)

var board2 = new Board(zone2)

board1.getWeatherZone

board1.getSiegeCombatZone

Aunque para mostrar la carta en la zona clima también se puede usar:

zone1.getWeatherCard (La función que se hace llamar si se invoca la clase board primero)

Y como se puede ver puse 2 zonas clima, esto simplemente para demostrar que con el uso de un Singleton, hace que ambas
zonas clima sean exactamente iguales (Eso es solo para uso referencial).

Ahora cómo fue posible hacer que un jugador pueda jugar una carta, primero se crearon las funciones
removeFromHand que remueve una carta específica de la mano, y este es usado en la segunda función para jugar una carta.
Esta segunda función llama a removeFromHand para remover la carta, en el caso de que esa carta no existe o no este en
la mano, no se realiza la acción. Y luego llama a una segunda función playOnBoard, que recibe como parámetros el board
y la carta que escogimos. La función playOnBoard es implementada en todas las clases cartas, y dependiendo del tipo de
board/zona, se usa una función playOnBoard. Cuando esté en su función correcta esta llama a la última función, en
la clase board la cual termina agregando la carta jugada en su respectiva zona. Toda esta parte es lo que consideraríamos
Double Dispatch
