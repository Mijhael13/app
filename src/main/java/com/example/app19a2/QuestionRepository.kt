package com.example.app19a2

object QuestionRepository {

    private val allQuestions = listOf(
        Question(1, "¿Qué músculo es el responsable de cerrar los párpados al parpadear?", 
            listOf("Músculo Frontal", "Músculo Orbicular de los ojos", "Músculo Superciliar", "Músculo Elevador del párpado superior"), 
            1, "Es un músculo en forma de anillo que rodea la órbita y permite el cierre firme de los párpados.", 1),
        
        Question(2, "¿Qué músculo es el principal responsable de la inspiración al descender y ampliar el tórax?", 
            listOf("Músculo Diafragma", "Intercostales externos", "Serrato anterior", "Recto abdominal"), 
            0, "Es el motor principal que al bajar crea el vacío para que los pulmones se inflen.", 1),
        
        Question(3, "Músculo en forma de sierra que mantiene la escápula pegada a las costillas:", 
            listOf("Serrato anterior", "Pectoral menor", "Subclavio", "Romboides mayor"), 
            0, "Se origina en las costillas y se inserta en la borde de la escápula, evitando que esta se separe del tórax (escápula alada).", 1),
        
        Question(4, "¿Cuál es el músculo más profundo del abdomen cuyas fibras corren de forma horizontal?", 
            listOf("Oblicuo externo", "Transverso del abdomen", "Recto mayor del abdomen", "Oblicuo interno"), 
            1, "Sus fibras horizontales rodean el abdomen como un cinturón, siendo la capa más profunda.", 1),
        
        Question(5, "Músculo que permite la inclinación lateral del tronco y estabiliza la última costilla:", 
            listOf("Psoas mayor", "Cuadrado lumbar", "Ilíaco", "Erector de la columna"), 
            1, "Conecta la pelvis con la última costilla, permitiendo el movimiento lateral y fijando la costilla durante la respiración.", 1),
        
        Question(6, "¿Cómo se llama el tejido fibroso que separa verticalmente los músculos rectos del abdomen?", 
            listOf("Línea alba", "Fascia toracolumbar", "Aponeurosis oblicua", "Peritoneo parietal"), 
            0, "Es una banda de tejido conectivo que une las aponeurosis de los músculos abdominales en la línea media del cuerpo.", 1),
        
        Question(7, "Músculo de la espalda que permite “encogerse de hombros” y elevar la escápula:", 
            listOf("Trapecio (fibras superiores)", "Dorsal ancho", "Romboides", "Elevador de la escápula"), 
            0, "Sus fibras superiores tiran de la escápula hacia arriba, permitiendo el gesto de elevar los hombros hacia las orejas.", 1),
        
        Question(8, "Músculo que permite la rotación y flexión lateral de la columna (zona de la cintura):", 
            listOf("Oblicuo externo", "Recto abdominal", "Espinoso", "Transverso del abdomen"), 
            0, "Sus fibras diagonales actúan como tirantes que, al contraerse de un solo lado, hacen que el torso gire o se incline lateralmente.", 1),
        
        Question(9, "Si tocas el hueso de tu cadera por delante (la cresta ilíaca), ¿qué músculo nace ahí hacia abajo?", 
            listOf("El Tensor de la fascia lata", "El Tríceps", "El Pectoral", "El Gastrocnemio"), 
            0, "Se origina en la espina ilíaca anterosuperior y se inserta en la banda iliotibial, ayudando a estabilizar la rodilla y la cadera.", 1),
        
        Question(10, "Músculo de la espalda que permite trepar al realizar la aducción y rotación interna del brazo:", 
            listOf("Dorsal ancho", "Redondo mayor", "Supraespinoso", "Trapecio inferior"), 
            0, "Es el músculo más potente para tirar del brazo hacia abajo y atrás, permitiendo elevar todo el peso del cuerpo.", 1),
        
        Question(11, "Músculo pequeño del pecho que ayuda a tirar del hombro hacia adelante y abajo:", 
            listOf("Pectoral mayor", "Pectoral menor", "Serrato posterior", "Subclavio"), 
            1, "Se sitúa debajo del mayor y su función principal es traccionar la apófisis coracoides de la escápula hacia adelante y abajo.", 1),
        
        Question(12, "¿Qué músculo inicia la separación (abducción) del brazo los primeros 15 grados?", 
            listOf("Músculo Supraespinoso", "Músculo Deltoides", "Músculo Infraespinoso", "Músculo Redondo menor"), 
            0, "Es el encargado de iniciar el levantamiento del brazo antes de que el deltoides tenga el ángulo mecánico para tomar el relevo.", 1),
        
        Question(13, "Músculo del brazo que tiene tres cabezas y cuya función principal es extender el codo:", 
            listOf("Bíceps braquial", "Tríceps braquial", "Braquial anterior", "Coracobraquial"), 
            1, "Su nombre indica ‘tres cabezas’ y es el principal músculo encargado de estirar (extender) el brazo.", 1),
        
        Question(14, "¿Cuál es el principal músculo que permite girar la palma de la mano hacia arriba?", 
            listOf("Bíceps braquial", "Pronador redondo", "Braquiorradial", "supinador corto"), 
            0, "Además de flexionar el codo, es el supinador más potente del antebrazo, especialmente cuando el codo está flexionado.", 1),
        
        Question(15, "Músculo del antebrazo que permite cerrar el puño y flexionar los dedos:", 
            listOf("Flexor común superficial de los dedos", "Extensor común de los dedos", "Palmar largo", "Pronador cuadrado"), 
            0, "Sus tendones viajan hasta las falanges medias, permitiendo doblar los dedos hacia la palma para sujetar objetos.", 1),
        
        Question(16, "Músculo que da la forma redondeada al hombro y permite levantar el brazo hacia los lados:", 
            listOf("Deltoides", "Trapecio", "Redondo mayor", "Coracobraquial"), 
            0, "Es el músculo voluminoso que cubre la articulación del hombro y su porción media es la potencia principal para elevar el brazo lateralmente.", 1),
        
        Question(17, "Músculo encargado de mantener nivelada la pelvis al caminar sobre una sola pierna:", 
            listOf("Glúteo medio", "Glúteo mayor", "Cuadrado femoral", "Piramidal"), 
            0, "Actúa como un estabilizador lateral que evita que la pelvis caiga hacia el lado del pie que está en el aire.", 1),
        
        Question(18, "¿Cuál es el músculo más largo del cuerpo humano y permite cruzar las piernas?", 
            listOf("Músculo Sartorio", "Músculo Grácil (Recto interno)", "Músculo Pectíneo", "Músculo Recto Femoral"), 
            0, "Es una banda larga y delgada que cruza el muslo diagonalmente, permitiendo flexionar, abducir y rotar la cadera simultáneamente.", 1),
        
        Question(19, "Grupo de tres músculos en la parte posterior del muslo que flexionan la rodilla:", 
            listOf("Isquiotibiales", "Cuádriceps", "Aductores", "Gastrocnemios"), 
            0, "Este grupo (bíceps femoral, semitendinoso y semimembranoso) atraviesa la rodilla por detrás, permitiendo doblarla y también extender la cadera.", 1),
        
        Question(20, "Músculo que permite levantar la punta del pie hacia arriba (dorsiflexión):", 
            listOf("Tibial anterior", "Peroneo largo", "Gastrocnemio", "Sóleo"), 
            0, "Se sitúa en la parte frontal de la espinilla y su contacción tira del pie hacia arriba, siendo clave para no tropezar al caminar.", 1),
        
        Question(21, "¿Qué músculo se conoce como “gemelos” y permite ponerse de puntillas?", 
            listOf("Gastrocnemio", "Tibial posterior", "Flexor largo de los dedos", "Peroneo corto"), 
            0, "Es un músculo con dos cabezas (medial y lateral) que se inserta en el talón mediante el tendón de Aquiles, permitiendo la flexión plantar potente.", 1),
        
        Question(22, "Músculo lateral del muslo que ayuda a estabilizar la rodilla al correr:", 
            listOf("Tensor de la fascia lata", "Bicep femoral", "Vasto intermedio", "Glúteo menor"), 
            0, "Se une a la banda iliotibial para dar tensión a la parte externa del muslo y evitar que la rodilla colapse o oscile al impactar contra el suelo.", 1),
        
        Question(23, "Músculo profundo situado debajo de los gemelos que ayuda a la flexión del pie:", 
            listOf("Músculo Sóleo", "Músculo Poplíteo", "Plantar delgado", "Tibial anterior"), 
            0, "Es un músculo ancho y plano que se sitúa debajo de los gemelos; juntos forman el tríceps sural para potenciar la flexión del pie.", 1),
        
        Question(24, "Músculo pequeño detrás de la rodilla que ayuda a “desbloquearla” para iniciar la flexión:", 
            listOf("Músculo Poplíteo", "Bíceps femoral", "Semitendinoso", "Plantar delgado"), 
            0, "Realiza una ligera rotación de la tibia que libera la articulación cuando la rodilla está completamente extendida, permitiendo que se doble.", 1),
        
        Question(25, "¿Qué músculo forma el límite interno (medial) del hueco detrás de la rodilla?", 
            listOf("Semimembranoso", "Bíceps femoral", "Vasto medial", "Gastrocnemio lateral"), 
            0, "Junto con el semitendinoso, este músculo de los isquiotibiales delimita la parte superior e interna de este espacio romboidal.", 1),
        
        Question(26, "Músculo que forma parte del cuádriceps y se encuentra en la parte más externa del muslo:", 
            listOf("Vasto lateral", "Vasto medial", "Recto femoral", "Vasto intermedio"), 
            0, "Es la porción más grande y externa del cuádriceps, situada en la cara lateral del fémur.", 1),
        
        Question(27, "¿Qué músculo estabiliza la parte lateral de la rodilla y cadera al estar de pie?", 
            listOf("Tensor de la fascia lata", "Pectíneo", "Sóleo", "Grácil (Recto interno)"), 
            0, "Al tensar la cintilla iliotibial, actúa como un tirante lateral que estabiliza tanto la cadera como la rodilla extendida.", 1),
        
        Question(28, "¿Qué sucede en el músculo durante un calambre intenso?", 
            listOf("Una contracción involuntaria y dolorosa", "Una relajación excesiva", "Una parálisis temporal por falta de nervios", "Una ruptura total del tendón"), 
            0, "El músculo se acorta y se tensa de forma súbita sin que tú lo decidas, manteniéndose así por varios segundos o minutos debido a una fatiga o desequilibrio de sales.", 1),
        
        Question(29, "¿Cuántos músculos, aproximadamente, se necesitan para dar un solo paso al caminar?", 
            listOf("Más de 200 músculos", "Solo 10 músculos", "Menos de 100 músculos", "Alrededor de 50"), 
            0, "Caminar requiere una coordinación masiva que incluye músculos de las piernas, caderas, espalda e incluso el torso para mantener el equilibrio.", 1),
        
        Question(30, "¿Qué sistema del cuerpo controla directamente a los músculos esqueléticos?", 
            listOf("Sistema Nervioso Somático (Voluntario)", "Sistema Nervioso Autónomo", "Sistema Nervioso Parasimpático", "Sistema Endocrino"), 
            0, "Es la parte del sistema nervioso que conecta el cerebro con los músculos esqueléticos, permitiendo realizar movimientos conscientes y voluntarios.", 1),
        
        Question(31, "¿Cuál es el músculo que se encuentra en el pecho y usamos para empujar cosas?", 
            listOf("Músculo Pectoral mayor", "Músculo Glúteo mayor", "Músculo Tibial anterior", "Músculo Tríceps braquial"), 
            0, "Es el músculo más grande del pecho y su función principal es aducir y rotar el brazo, permitiendo empujar objetos lejos del cuerpo.", 1),
        
        Question(32, "¿Qué sucede con los músculos si no los usamos por mucho tiempo?", 
            listOf("Se vuelven más fuertes", "Se debilitan y se hacen pequeños", "Se transforman en tejido óseo", "Cambian de color a azul"), 
            1, "Cuando el músculo no recibe estímulo, el cuerpo reduce el tamaño de las fibras para ahorrar energía, lo que resulta en debilidad y pérdida de volumen.", 1),
        
        Question(33, "¿Dónde se encuentra el músculo Bíceps braquial?", 
            listOf("En la pierna", "En la parte delantera del brazo", "En la espalda alta", "En el pie"), 
            1, "Se ubica sobre el húmero y es el principal encargado de flexionar el codo y supinar el antebrazo.", 1),
        
        Question(35, "¿Qué parte del cuerpo movemos gracias a los músculos del antebrazo?", 
            listOf("Los dedos y la muñeca", "Los hombros", "El cuello", "Las rodillas"), 
            0, "Los músculos del antebrazo tienen tendones largos que viajan hasta la mano, permitiendo cerrar el puño, teclear y mover la muñeca en todas direcciones.", 1),
        
        Question(36, "¿Cuántos bíceps braquiales tenemos en total en el cuerpo?", 
            listOf("Uno", "Dos (uno en cada brazo)", "Tres", "Cuatro"), 
            1, "El cuerpo humano es simétrico, por lo que tenemos un bíceps braquial en el brazo derecho y otro en el brazo izquierdo.", 1),
        
        Question(37, "¿Cómo se llama la zona donde el brazo se une al tronco?", 
            listOf("Codo", "Hombro", "Muñeca", "Antebrazo"), 
            1, "Es la articulación compleja que conecta el húmero con la escápula y la clavícula, integrando el brazo al torso.", 1),
        
        Question(38, "¿Dónde están los músculos llamados Cuádriceps?", 
            listOf("En la pantorrilla", "En la parte delantera del muslo", "En la espalda", "En la planta del pie"), 
            1, "Este grupo de cuatro músculos cubre la cara anterior del fémur y es el principal extensor de la rodilla.", 1),
        
        Question(39, "¿Qué músculo usamos principalmente para dar una patada a un balón?", 
            listOf("El Cuádriceps", "El Dorsal ancho", "El Bíceps braquial", "El Trapecio"), 
            0, "Es el encargado de extender la rodilla con potencia, siendo el motor principal en la fase de impacto al patear.", 1),
        
        Question(40, "¿Dónde se encuentran los músculos Isquiotibiales?", 
            listOf("Detrás del muslo", "Delante de la rodilla", "En la parte externa de la cadera", "En el brazo"), 
            0, "Este grupo (bíceps femoral, semitendinoso y semimembranoso) recorre la parte posterior del fémur, permitiendo doblar la rodilla y extender la cadera.", 1),

        Question(41, "¿Cuál es el músculo más grande del cuerpo humano?", 
            listOf("El fémur.", "El glúteo mayor.", "El dorsal ancho.", "Fémur"), 
            1, "Es clave para mantener la postura erguida y caminar.", 1),
        
        Question(42, "¿Cómo se llaman los tejidos que unen los músculos a los huesos?", 
            listOf("Ligamentos.", "Nervios.", "Tendones.", "Rodilla"), 
            2, "Los ligamentos unen hueso con hueso; los tendones, músculo con hueso.", 1),
        
        Question(43, "¿Qué músculo trabaja de forma automática (involuntaria) para mantenernos vivos?", 
            listOf("El bíceps.", "El corazón (miocardio).", "El cuádriceps.", "Pecho"), 
            1, "Es tejido muscular cardiaco y no podemos controlar sus latidos.", 1),
        
        Question(44, "Para que el brazo se doble (flexión), el bíceps se contrae. ¿Qué hace el tríceps en ese momento?", 
            listOf("Se contrae también.", "Se relaja (extensión).", "No hace nada.", "se flexiona"), 
            1, "Los músculos trabajan en parejas opuestas.", 1),
        
        Question(45, "¿Qué nutriente es el \"ladrillo\" principal para reparar las fibras musculares?", 
            listOf("Carbohidratos.", "Grasas.", "Proteínas.", "Vegetales"), 
            2, "Los aminoácidos de las proteínas reconstruyen el tejido.", 1),
        
        Question(46, "¿Aproximadamente cuántos músculos tiene el cuerpo humano?", 
            listOf("Alrededor de 200.", "Más de 600.", "Exactamente 1000.", "Aproximadamente 230"), 
            1, "Varía según si se cuentan músculos pequeños o en grupo.", 1),
        
        Question(47, "¿Cuál es el músculo más fuerte del cuerpo en relación a su tamaño (el que ejerce más presión)?", 
            listOf("La lengua.", "El masetero (mandíbula).", "El corazón.", "El ojo"), 
            1, "Puede cerrar la mandíbula con una fuerza de hasta 90kg.", 1),
        
        Question(48, "¿Qué causa comúnmente un calambre muscular?", 
            listOf("Exceso de sueño.", "Falta de hidratación y minerales (como potasio).", "Comer demasiada proteína.", "Falta de sueño"), 
            1, "La falta de hidratación y electrolitos altera la señal eléctrica del músculo.", 1),
        
        Question(49, "¿Qué músculo es el principal responsable de la flexión del codo?", 
            listOf("Bíceps braquial", "Tríceps", "Deltoides", "Cuádriceps"), 
            0, "Es el músculo motor que tira del antebrazo hacia el hombro para doblar el codo.", 1),
        
        Question(50, "¿Qué músculo permite la extensión de la rodilla al caminar o correr?", 
            listOf("Sartorio", "Ilíaco", "Cuádriceps", "Radio Carpiana"), 
            2, "Son cuatro músculos que trabajan juntos para estirar la pierna (extensión) al dar el paso.", 1),
        
        Question(51, "Músculo que da forma al hombro y permite levantar el brazo lateralmente:", 
            listOf("Trapecio", "Deltoides", "Bíceps", "óseo"), 
            1, "Envuelve el hombro; sus fibras laterales son las que levantan el brazo hacia afuera.", 1),
        
        Question(52, "Músculo grande del pecho utilizado en movimiento de empuje:", 
            listOf("Intercostales", "Serrato", "Pectoral mayor", "Pectoral mediano"), 
            2, "Músculo potente del tórax que empuja objetos lejos del cuerpo.", 1),
        
        Question(53, "¿Qué músculo forma el límite medial del triángulo femoral?", 
            listOf("Aductor largo", "Ligamento inguinal", "Húmero cubital", "Cadera"), 
            0, "Se ubica en la cara interna del muslo, cerrando el espacio del triángulo femoral por el centro.", 1),
        
        Question(54, "¿Qué propiedad muscular permite al tejido recuperar su forma original tras un estiramiento?", 
            listOf("Extensibilidad", "Contractilidad", "Elasticidad", "Rotaciones"), 
            2, "Como una liga, permite que el músculo vuelva a su tamaño normal tras estirarse.", 1),
        
        Question(55, "El músculo “esternocleidomastoideo” se encuentra en:", 
            listOf("La espalda", "El cuello", "El brazo", "La pierna"), 
            1, "El esternocleidomastoideo une el pecho con la base del cráneo para girar la cabeza.", 1),
        
        Question(56, "¿Qué molécula proporciona la energía directa para el deslizamiento de los filamentos musculares?", 
            listOf("ATP", "Oxígeno", "Glucosa", "ARN"), 
            0, "Es el combustible químico necesario para que las fibras musculares se muevan entre sí.", 1),
        
        Question(57, "¿Qué músculo tiene forma de abanico y cubre la parte superior del pecho?", 
            listOf("Pectoral mayor", "Trapecio", "Mioglobina", "Aductor largo"), 
            0, "Su diseño ancho y abierto desde el esternón al brazo le da la forma de abanico.", 1),
        
        Question(58, "¿Cómo se denomina el tejido conectivo denso que une el músculo esquelético al hueso?", 
            listOf("Ligamento", "Tendón", "Fascia", "Goma"), 
            1, "Es el cordón resistente que ancla la fuerza del músculo al hueso.", 1),
        
        Question(59, "Los músculos que presentan una forma ancha y delgada, como el pectoral mayor o el recto abdominal, se clasifican como:", 
            listOf("Músculos circulares", "Músculos planos", "Músculos cortos", "Músculos grandes"), 
            1, "Tienen poca profundidad y mucha superficie, ideales para cubrir cavidades.", 1),
        
        Question(60, "En la terminología anatómica, ¿cuál es el punto de unión de un músculo que se desplaza durante la contracción?", 
            listOf("Inserción", "Vientre", "Origen", "Molécula"), 
            0, "Es el extremo del músculo que se engancha al hueso que realmente se mueve.", 1),
        
        Question(61, "¿Qué movimiento hacemos gracias al músculo Tríceps braquial?", 
            listOf("Doblar el codo.", "Estirar el brazo.", "Levantar el hombro.", "Girar la muñeca."), 
            1, "El tríceps se encuentra en la parte posterior del brazo y su función principal es la extensión del codo, lo que permite estirar el miembro superior.", 1)
    )

    fun getQuestionsByLevel(level: Int, excludeIds: List<Int> = emptyList()): List<Question> {
        val available = allQuestions.filter { it.id !in excludeIds }
        // Si no quedan suficientes preguntas nuevas, usamos todas de nuevo pero las mezclamos
        val pool = if (available.size < 10) allQuestions else available
        return pool.shuffled().take(10).map { shuffleOptions(it) }
    }

    fun getQuestionsByIds(ids: List<Int>): List<Question> {
        val filtered = allQuestions.filter { it.id in ids }
        return ids.mapNotNull { id -> filtered.find { it.id == id } }.map { shuffleOptions(it) }
    }

    private fun shuffleOptions(question: Question): Question {
        val correctOption = question.options[question.correctOptionIndex]
        val shuffledOptions = question.options.shuffled()
        val newCorrectIndex = shuffledOptions.indexOf(correctOption)
        return question.copy(options = shuffledOptions, correctOptionIndex = newCorrectIndex)
    }
}
