[![logo](https://www.gnu.org/graphics/gplv3-127x51.png)](https://choosealicense.com/licenses/gpl-3.0/)
# Ontologías para el curso 2019-20
## OntoJuegoTablero

En este documento se presenta el análisis, diseño e implementación para las ontologías que se utilizarán en el desarrollo de las prácticas para el curso 2019-20 de la asignatura. El diseño de las ontologías estará pensado para resolver las necesidades de comunicación de los agentes implicados en las prácticas. Estos agentes estarán diseñados para responder a los eventos necesarios para:

- Localizar a los agentes especializados:
	- Agentes que se encargan de completar los juegos y presentar una representación del juego.
	- Agentes organizadores que distribuyen los juegos para que los agentes especializados en el juego puedan completarlo.
	- Agentes jugadores para uno o varios juegos. Los agentes que se diseñen para los diferentes juegos se suponen que juegan correctamente, es decir, no tienen la posibilidad para *hacer trampa*.

- Realizar las tareas necesarias para los diferentes juegos:
	- Recopilar a los agentes jugadores que estén dispuestos a jugar una partida o un torneo.
	- Completar los turnos necesarios para una partida individual entre dos agentes jugadores.
	- Comunicar el resultado de las diferentes partidas.

En este curso se van ha diseñar ontologías para los siguientes juegos:

 1. [Tres en Raya](https://es.wikipedia.org/wiki/Tes_en_l%C3%ADnea#Reglas). 
 2. [Quatro!](https://drive.google.com/file/d/0B5KQ_9DlCmReakFKQ3hPZV85Vnc/view?usp=sharing). 
 3. [Quoridor](https://drive.google.com/file/d/0B5KQ_9DlCmRec3hYVXN1Y2xnVFE/view?usp=sharing).

Como el diseño de las ontologías estará enfocado en resolver las necesidades de comunicación entre los agentes se incluirán los diagramas UML para los diferentes protocolos de comunicación entre **agentes-FIPA** que las resuelven.

## 1 Análisis de la ontología

Nuestra ontología debe responder apropiadamente a las siguientes preguntas:

1. ¿Cómo diferenciar a los diferentes agentes especializados?
2. ¿Cómo proponer a los diferentes jugadores que participen en un juego?
3. ¿Cómo debe completarse un juego ?
4. ¿Cómo obtener el resultado del juego propuesto?
5. ¿Cómo generar las partidas que componen un juego?
6. ¿Cómo completar un turno de una partida? ¿Cómo completar la partida?
7. ¿Cómo informar del resultado final de la partida?

Estas preguntas van a necesitar que se intercambie información entre los agentes de la plataforma. Para resolver las diferentes preguntas se presentan los diagramas UML para la secuencia de mensajes que deben intercambiarse entre los agentes implicados.

### 1.1 ¿Cómo diferenciar a los diferentes agentes especializados?

Para resolver esta pregunta utilizaremos la utilidad del servicio de páginas amarillas que nos proporciona la plataforma de **agentes-FIPA**. De esta forma no será necesario tener elementos en la ontología para poder resolver el problema de comunicación pero sí será necesario un elemento en el vocabulario para que los agentes puedan subscribirse en el servicio de páginas amarillas de forma homogénea:

- `TipoServicio` : Los agentes especializados tendrán asociado un tipo de servicio y utilizan este elemento del vocabulario. Los agentes especializados serán:
	- `JUGADOR` : Representa el tipo de servicio para cualquier agente jugador de alguno de los tipos de juegos representados en la ontología.
	- `TABLERO` : Representa el tipo de servicio para cualquier agente que completa una partida para alguno de los tipos de juegos representados en la ontología.
	- `ORGANIZADOR` : Representa el tipo de servicio que proporcionan los agentes que se encargarán de la organización de las partidas que representan un juego, de alguno de los tipos de la ontología, y computarán el resultado.

- `TipoJuego` : Representa a los tipos de juegos representados en la ontología y que formará parte del nombre del servicio del agente y también forma parte del vocabulario.
	- [`TRES_EN_RAYA` | `QUORIDOR` | `QUATRO`]

Hay un agente especializado que será el encargado en localizar a todos los agentes especializados. Este agente es `AgenteMonitor` y que deberá conocer todos los elementos de la ontología y será desarrollado por el profesor de la asignatura.

### 1.2 ¿Cómo proponer a los diferentes jugadores que participen en un juego?

El `AgenteMonitor` propondrá un juego, de alguno de los tipos que conoce, a los `AgenteJugador` para ese tipo de juego. El juego debe identificarse de forma unívoca y los jugadores pueden tomar su decisión para participar en el juego atendiendo a su estado actual.

![][imagen1]

En el diagrama se presentan los elementos de la ontología que deberán formar parte del contenido del mensaje que se envía al agente. Los elementos de la ontología tendrán los siguientes atributos:

- `ProponerJuego` : Tiene la información necesaria para que los agentes puedan tomar su decisión
	- `Juego` : representa al juego en el que debe participar el jugador.
		- `idJuego` : identificará de forma unívoca el juego.
		- `TipoJuego` : [`TRES_EN_RAYA` | `QUORIDOR` | `QUATRO`] uno de los tipos de juego disponibles en la ontología.
	- `Modo` : [`UNICO` | `ELIMINATORIA` | `TORNEO`] desarrollo del juego. Esto determina en el número de partidas que deberá completar cada jugador en el juego.
	- `InfoJuego` : es un concepto abstracto que permite representar los datos necesarios de un juego. De esta forma se extender la ontología con nuevos tipos de juegos.
		- `TresEnRaya` : los atributos necesarios para el juego del Tres en Raya.
			- `Tablero` : dimensiones del tablero para un juego de Tres en Raya.
		- `Quoridor` : los atributos necesarios para el juego Quoridor.
			- `Tablero` : dimensiones del tablero para un juego Quoridor.
			- `numJugadores` : número de jugadores para el juego.
			- `numMuros` : número de muros que dispone un jugador.
			- `centro` : punto central donde se colocará la ficha del jugador en su posición del tablero.
		- `Quatro` : los atributos necesarios para un juego Quatro!
			- `Tablero` : dimensiones del tablero para un juego Quatro!
			- `Version` : [`NORMAL` | `AVANZADA`] valores presentes en el vocabulario para establecer la versión del juego.
			- `numFichas` : número de fichas que se disponen para el juego.

- `Justificacion` : Es un elemento del vocabulario y contendrá las posibilidades que dispone el agente para indicar el rechazo para participar en el juego.
	- `Juego` :  representa el juego en el que no se desea participar.
	- `Motivo` : justificación para no participar en el juego. Los posibles motivos estarán recogidos en el vocabulario:
```
JUEGOS_ACTIVOS_SUPERADOS | PARTICIPACION_EN_JUEGOS_SUPERADA | 
TIPO_JUEGO_NO_IMPLEMENTADO | DEMASIADOS_JUEGOS_SIN_COMPLETAR | SUPERADO_LIMITE_PARTIDAS 
| SUBSCRIPCION_ACEPTADA | ERROR_SUBSCRIPCION | ERROR_CANCELACION | ONTOLOGIA_DESCONOCIDA
```

- `JuegoAceptado` : Permite al agente indicar que desea participar en el juego. Ya sea como jugador u organizador.
	- `Juego` : representa el juego en el que desea participar el agente. 
	- `AgenteJuego` : representa al agente especializado que desea participar en el juego. Es un concepto abstracto que permite representar a los agentes especializados y así poder extender la ontología para atender la posibilidad que se añadan más agentes especializados.


### 1.3 ¿Cómo debe completarse un juego ?

Cuando el `AgenteMonitor` ha localizado jugadores que están dispuestos a participar en un juego hay que localizar a un `AgenteOrganizador` que se encargue de generar las partidas necesarias para completar ese juego.

![][imagen2]

En el diagrama se presentan los elementos de la ontología que deberán formar parte del contenido del mensaje que se envía al agente. Los elementos de la ontología tendrán los siguientes atributos:

- `CompletarJuego` : Tiene la información necesaria para generar las partidas individuales que permitan completar el juego propuesto.
	- `Juego` : juego que se debe completar.
	- `Modo` : [`UNICO` | `ELIMINATORIA` | `TORNEO`] desarrollo del juego. Esto determina en el número de partidas que deberá completar cada jugador en el juego.
	- `InfoJuego` : es un concepto abstracto que permite representar los datos necesarios de un juego. De esta forma se extender la ontología con nuevos tipos de juegos.
	- `ListaJugadores` : es una colección de elementos `Jugador`, y al menos deben ser dos, que participarán en las partidas que definen el juego. 

Los otros elementos de la ontología ya han sido descritos en el punto anterior.

### 1.4 ¿Cómo obtener el resultado del juego propuesto?

Para que el `AgenteMonitor` pueda recibir la información del resultado de los juegos que proponga a diferentes `AgenteOrganizador` será necesario el siguiente intercambio de mensajes:

![][imagen3]

En el diagrama se presentan los elementos de la ontología que deberán formar parte del contenido del mensaje que se envía al agente. Los elementos de la ontología tendrán los siguientes atributos:

- `InformarResultado` : Representa la información del agente que quiere recibir la información del resultado del juego
	- `AgenteJuego` : representa al agente especializado que desea recibir la información. Es un concepto abstracto que permite representar a los agentes especializados y así poder extender la ontología para atender la posibilidad que se añadan más agentes especializados.

- `SubInform` : Elemento abstracto para representar las posibilidades de información que puede recibir el agente especializado. En este caso los valores pueden ser:
	-  [`ClasificacionJuego` | `IncidenciaJuego` ] contempla las posibilidades de finalización de un juego.

- `ClasificacionJuego` : Si el juego ha finalizado correctamente se envía la información relativa a la clasificación del juego con los jugadores implicados.
	- `Juego` : representa el juego que ha finalizado.
	- `ListaJugadores` : colección de elementos `Jugador` que han participado en el juego ordenados desde el campeón en adelante.
	- `ListaPuntuacion` : colección con los puntos obtenidos por cada uno de los jugadores de la lista anterior. 

- `IncidenciaJuego` : si la partida no finaliza de forma normal este elemento indicará el motivo
	- [`CANCELADO`, `JUGADORES_INSUFICIENTES`] posibles valores recogidos en el vocabulario para una finalización incompleta del juego.

### 1.5 ¿Cómo generar las partidas que componen un juego?

El `AgenteOrganizador` se encarga de ir generando las rondas necesarias para completar el juego. El número de rondas dependerá del atributo `Modo` del elemento `CompletarJuego`. En cada ronda se generan un número de partidas que deben ser completadas por el `AgenteTablero`.

![][imagen5]

En el diagrama se presentan los elementos de la ontología que deberán formar parte del contenido del mensaje que se envía al agente. Los elementos de la ontología tendrán los siguientes atributos:

- `CompletarPartida` : Contiene la información necesaria de la partida que se tiene que jugar.
	- `Partida` : datos de la partida que se ha completado.
		- `Juego` : juego al que corresponde la partida.
		- `ronda` : indica la ronda de la partida dentro del juego.
	- `ListaJugadores` : es una colección de elementos `Jugador`, y al menos deben ser dos, que participarán en la partida. Este atributo contempla la extensión de jugadores que disputan la partida, es decir, que el número de jugadores sea mayor que 2.

###  1.6 ¿Cómo completar un turno de una partida? ¿Cómo completar la partida?

El `AgenteTablero` es el encargado de organizar los turnos que componen una partida. De esta forma lo importante es identificar los elementos de información necesarios para completar un turno de juego. Para completar la partida hay que ir generando los turnos necesarios hasta obtener un ganador o declarar un empate.

Para completar un turno de juego se envía el mismo mensaje a los jugadores que tiene la partida. La información necesaria depende del tipo de juego:

#### Turno para los juegos: TresEnRaya y Quoridor

![][imagen6]

En el diagrama se presentan los elementos de la ontología que deberán formar parte del contenido del mensaje que se envía al agente. Los elementos de la ontología tendrán los siguientes atributos:

- `PedirMovimiento` : Información necesaria para completar el turno de juego.
	- `Partida` : partida a la que corresponde el turno.
	- `Jugador` : jugador que tiene que realizar el movimiento, **jugador activo**.

- `EstadoPartida` : Información sobre posibles contingencias que pueden ocurrir durante la partida.
	- `Partida` : partida a la que corresponde el turno.
	- `Estado` : posibles estados en los que se puede encontrar la partida. Sus valores están definidos en el vocabulario.
		- [`GANADOR` | `ABANDONO` | `SEGUIR_JUGANDO` | `FIN_PARTIDA` | `JUGADOR_NO_ACTIVO`]

- `MovimientoEntregado` : Información del movimiento que realiza el jugador activo del turno.
	- `Partida` : partida a la que corresponde el turno.
	- `Movimiento` : un movimiento válido, suponemos que los jugadores juegan correctamente.
		- `FichaJuego` : elemento abstracto que permite representar las posibles fichas de un juego.
		- `Posicion` : localización de la ficha en el tablero.
			- (`Fila` , `Columna`)

- `FichaJuego`
	- **TresEnRaya** : para este juego el elemento necesario es:
		- `Ficha` : ficha para el Tres en Raya
			- `Jugador` : jugador asociado a la ficha
			- `Color` : [`BLANCO` | `NEGRO`] una de las posibilidades definidas en el vocabulario de la ontología.
	- **Quoridor** : para el juego los elementos necesarios son:
		- `Ficha` : ficha para el Tres en Raya
			- `Jugador` : jugador asociado a la ficha
			- `Color` : [`BLANCO` | `NEGRO` | `AZUL` | `ROJO`] una de las posibilidades definidas en el vocabulario de la ontología. Se tiene en cuenta todas las posibilidades del juego.
		- `Muro` : en este juego es tipo de elemento especial que disponen los jugadores en una cantidad limitada
			- `Orientacion` : [`HORIZONTAL` | `VERTICAL`] los valores están definidos en el vocabulario de la ontología para las posibilidades de colocación que tenemos en el juego.

#### Turno para el juego Quoridor!

![][imagen7]

En el diagrama se presentan los elementos de la ontología que deberán formar parte del contenido del mensaje que se envía al agente. Los elementos de la ontología tendrán los siguientes atributos:

- `PedirMovimientoQuatro` : Especialización de `PedirMovimiento` para este juego.
	- `Movimiento` : movimiento del turno anterior del juego. 
		- `FichaJuego` : ficha colocada en el turno anterior, para el primer turno se utiliza la inicialización `NULA` de sus atributos.
		- `Posicion` : posición de la ficha en el turno anterior, para el primer turno se utiliza la inicialización `NULA` de sus atributos.

- `FichaEntregada` : Ficha que debe entregar el jugador que no mueve en el turno.
	- `Partida` : partida a a que corresponde el turno.
	- `Ficha` : ficha del juego Quatro! que se entrega. Sus atributos son:
		- `Color` : [`BLANCO` | `NEGRO` | `NULO`] valores posibles de esta característica recogidos en el vocabulario.
		- `Forma` : [`REDONDO` | `CUADRADO` | `NULO`]  valores posibles de esta característica recogidos en el vocabulario.
		- `Relleno` : [`SOLIDO`, `HUECO` | `NULO`] valores posibles de esta característica recogidos en el vocabulario.
		- `Altura` : [`BAJO` | `ALTO` | `NULO`] valores posibles de esta característica recogidos en el vocabulario.

- `MovimientoEntregadoQuatro` : Especialización de `MovimientoEntregado` para este juego.
	- `Estado` : siguiendo las reglas el **jugador activo** debe comunicar el estado del juego. 


### 1.7 ¿Cómo informar del resultado final de la partida?

Un `AgenteOrganizador` o `AgenteJugador` que participe en partidas dirigidas por un `AgenteTablero` necesita conocer el resultado de las partidas que el `AgenteTablero` complete. La información que remite el `AgenteTablero` debe identificar el agente que la solicita para reciba solo las partidas en las que está implicado.

![][imagen8]

En el diagrama se presentan los elementos de la ontología que deberán formar parte del contenido del mensaje que se envía al agente. En la **sección 1.4** ya se han presentado los elementos de la ontología que son necesarios. En este punto solo hay que especificar los siguientes elementos:

- `SubInform` : Elemento abstracto para representar las posibilidades de información que puede recibir el agente especializado. En este caso los valores pueden ser:
	-  [ `ResultadoPartida` | `IncidenciaJuego` ] contempla las posibilidades de finalización de la partida.

- `ResultadoPartida` : Representa el resultado de la partida.
	- `Partida` : datos de la partida que se ha completado.
	- `Jugador` : es un valor opcional que representa al ganador de la partida. Si no hay ganador indica que la partida ha finalizado en empate.

## 2 Diseño de la ontología

En la sección anterior se han presentado todos los elementos y relaciones que se presentan en la ontología necesaria para completar los juegos propuesto. Para el diseño de la ontología se tendrá presente su implementación con las capacidades que nos proporciona la biblioteca de agentes [Jade](https://jade.tilab.com/doc/api/jade/content/package-frame.html). De esta forma se presentarán unos diagramas de clase donde se muestran las relaciones entre ellas. Se presentan tres diagramas atendiendo a los elementos:

- `Concept` : Elementos que representan la información necesaria para representar los diferentes tipos de juegos de la ontología.
- `AgentAction` : Elementos que representas los eventos a los que responden los agentes para completar los juegos de la ontología.
- `Predicate` : Elementos que representan las respuestas a los eventos para completar los juegos de la ontología.

### 2.1 Diagrama para los elementos Concept

![][imagen9]

### 2.2 Diagrama para los elementos AgentAction

![][imagen10]

### 2.3 Diagrama para los elementos Predicate

![][imagen11]

### 2.4 Tareas para la comunicación

Como la ontología está diseñada para resolver los problemas de comunicación entre los agentes implicados en los juegos se especificarán los **protocolos FIPA** que se utilizarán.

#### Protocolo FIPA-Propose

Se utiliza este protocolo para: 

##### Localizar jugadores para un juego
![][imagen1]

##### Completar un juego con los jugadores que aceptaron
![][imagen2]

##### Completar una partida con los jugadores 
![][imagen5]

#### Protocolo FIPA-Subscribe

Se utiliza este protocolo para: 

##### Obtener la clasificación de un juego que se haya completado

![][imagen3]

##### Saber el ganador de una partida jugada

![][imagen8]

#### Protocolo FIPA-ContractNet

Se utiliza este protocolo para: 

##### Turno de juego para Tres en Raya y Quoridor

![][imagen6]

##### Turno de juego para Quatro!

![][imagen7]

### 2.5 Axiomas de la ontología

No tendrán una representación en la implementación de la ontología pero sí debemos tenerlos en cuenta para una correcta utilización de la misma:

- Origen de coordenadas para definir las posiciones en el tablero. La `Posicion(0,0)` estará localizada en la esquina superior izquierda del tablero de juego.
- Para el juego Quoridor:
	- Cuando un jugador posiciona un `Muro` en el tablero su posición hace referencia siempre a la casilla izquierda, si su orientación es `HORIZONTAL`, o a la casilla inferior, si su orientación es `VERTICAL`.  Un `Muro` bloque dos casillas del tablero.

## 3 Implementación de la ontología

Para la implementación de la ontología se han agrupado los diferentes elementos siguiendo la estructura siguiente:

- **OntoJuegoTablero** : Esta ontología agrupa todos los elementos comunes para los juegos que utilizan un tablero en dos dimensiones y que los jugadores colocan sus fichas en el tablero en turnos alternativos.
	- **OntoTresEnRaya** : Esta ontología utiliza todos los elementos de `OntoJuegoTablero` y añade sus elementos propios para completar partidas de [Tres en Raya](https://es.wikipedia.org/wiki/Tes_en_l%C3%ADnea#Reglas).
	- **OntoQuoridor** : Esta ontología utiliza todos los elementos de `OntoJuegoTablero` y añade sus elementos propios para completar partidas [Quoridor](https://drive.google.com/file/d/0B5KQ_9DlCmRec3hYVXN1Y2xnVFE/view?usp=sharing).
	- **OntoQuatro** : Esta ontología utiliza todos los elementos de `OntoJuegoTablero` y añade sus elementos propios para completar partidas [Quatro!](https://drive.google.com/file/d/0B5KQ_9DlCmReakFKQ3hPZV85Vnc/view?usp=sharing).

Para esto se crea una estructura de paquetes donde se incluyen las clases que representan a las diferentes ontologías como los elementos que las componen:

- `es.uja.ssmmaa.curso1920.ontologia` : Se incluyen las clases que representan las ontologías descritas y una interface que incluye el vocabulario que utilizan.
	- `es.uja.ssmmaa.curso1920.ontologia.juegoTablero` : Contiene los elementos de `OntoJuegoTablero`.
	- `es.uja.ssmmaa.curso1920.ontologia.tresEnRaya` : Contiene los elementos de `OntoTresEnRaya`.
	- `es.uja.ssmmaa.curso1920.ontologia.quoridor` : Contiene los elementos de `OntoQuoridor`.
	- `es.uja.ssmmaa.curso1920.ontologia.quatro` : Contiene los elementos de `OntoQuatro`.

En el repositorio del proyecto se puede repasar el código necesario para la implementación de los diferentes elementos de las ontologías.

Sí quiero comentar algunos elementos que están presentes en la interface `Vocabulario`.

```java
public static enum Puntuacion {
    VICTORIA(3), EMPATE(1), DERROTA(0);
        
    private final int valor;

    public int getValor() {
        return valor;
    }

    private Puntuacion(int valor) {
        this.valor = valor;
    }
}
```

Este elemento incluye, además del valor que representa un elemento del vocabulario, el valor para el cálculo de la clasificación de un juego.

```java
public static Ontology getOntology( TipoJuego tipoJuego ) throws BeanOntologyException {
    Ontology resultado = null;
        
    switch ( tipoJuego ) {
        case TRES_EN_RAYA:
            resultado = OntoTresEnRaya.getInstance();
            break;
        case QUORIDOR:
            resultado = OntoQuoridor.getInstance();
            break;
        case QUATRO:
            resultado = OntoQuatro.getInstance();
            break;
        default:
            resultado = OntoJuegoTablero.getInstance();
            break;
    }
        
    return resultado;
}
```

Este método `static` nos permite obtener la referencia de la ontología asociada a un `TipoJuego`. Es un método que nos permitirá trabajar con las ontologías de forma cómoda por si el agente debe tratar con más de una ontología.

## 4 Uso de la ontología en un proyecto para las prácticas

Para utilizar la ontología necesitamos acceder a las definiciones que se encuentran en la biblioteca de la ontología. Como en las prácticas estamos utilizando el gestor de dependencias [**Maven**](https://es.wikipedia.org/wiki/Maven) para nuestros proyectos Java debemos hacer las siguientes modificaciones en el fichero `pom.xml`: 

Localización del repositorio para la biblioteca donde se encuentra la definición de la ontología:

```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```

Dependencias asociadas a la biblioteca de la ontología.

```xml
<dependency>
    <groupId>com.github.PedroJSanchez</groupId>
	<artifactId>OntoJuegoTablero</artifactId>
	<version>1.2</version>
</dependency>
```



[imagen1]:https://gitlab.com/ssmmaa/curso2019-20/ontojuegotablero/-/raw/master/img/Onto1.png
[imagen2]:https://gitlab.com/ssmmaa/curso2019-20/ontojuegotablero/-/raw/master/img/Onto2.png
[imagen3]:https://gitlab.com/ssmmaa/curso2019-20/ontojuegotablero/-/raw/master/img/Onto3.png
[imagen5]:https://gitlab.com/ssmmaa/curso2019-20/ontojuegotablero/-/raw/master/img/Onto5.png
[imagen6]:https://gitlab.com/ssmmaa/curso2019-20/ontojuegotablero/-/raw/master/img/Onto6.png
[imagen7]:https://gitlab.com/ssmmaa/curso2019-20/ontojuegotablero/-/raw/master/img/Onto7.png
[imagen8]:https://gitlab.com/ssmmaa/curso2019-20/ontojuegotablero/-/raw/master/img/Onto4.png
[imagen9]:https://gitlab.com/ssmmaa/curso2019-20/ontojuegotablero/-/raw/master/img/Onto9.png
[imagen10]:https://gitlab.com/ssmmaa/curso2019-20/ontojuegotablero/-/raw/master/img/Onto10.png
[imagen11]:https://gitlab.com/ssmmaa/curso2019-20/ontojuegotablero/-/raw/master/img/Onto11.png
