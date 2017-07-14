package com.aprilsoft.pinacoteca;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by palgaba on 30/06/2017.
 */

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    //public static final int DATABASE_VERSION = 2;


    public AdminSQLiteOpenHelper(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version) {

        super(context, nombre, factory, DATABASE_VERSION);
    }

    /* personalizar con el código necesario para crear nuestra base de datos */
//    será ejecutado automáticamente por nuestra clase UsuariosDBHelper cuando sea necesaria la creación
//    de la base de datos, es decir, cuando aún no exista. Las tareas típicas que deben hacerse en este método serán la
//    creación de todas las tablas necesarias y la inserción de los datos iniciales si son necesarios.
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creamos tablas
        db.execSQL("create table Estilos(id integer primary key, nombre text, descripcion text, grupo text)");
        db.execSQL("create table Autores(id integer primary key, nombre text, idEstilo integer)");
        db.execSQL("create table Cuadros(id integer primary key, idAutor integer, idEstilo int, titulo text, imagen text)");
        db.execSQL("create table AutorEstilos(id integer primary key, idAutor integer, idEstilo int)");
        db.execSQL("create table Configuracion(id integer primary key, NumeroPreguntas integer, Dificultad text, tipo text, tiempo text,animacion text)");

        //Insertamos los datos en la tabla Estilo
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (0,'Abstracto','Se aparta de la realidad de la representación figurativa, que es sustituida por un lenguaje visual autónomo de significado propio. Sin imitar modelos o formas naturales, profundiza en los aspectos formales, estructurales y cromáticos','geometrico')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (1,'Posimpresionismo','Colores Vivos como el impresionismo, pero buscaba darle más expresión a las pinturas, con colores de más intensidad. Son temas de la vida real y presentaron una visión más subjetiva del mundo','colores')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (2,'Impresionista','El objetivo predominante era plasmar lo mejor posible el efecto de la luz en lo elegido a retratar (un modo usado era entrecerrar los ojos al observar mientras se pintaba).','colores')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (3,'Realismo','Muestra la realidad objetiva en general y crear cierta tensión emocional sin llevar a cabo ninguna idealización.','colores')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (4,'Cubismo','Descomposición de la realidad en figuras geométricas. y con el uso de colores neutros, más la falta de perspectiva y con muchos ángulos de visión del mismo objeto','geometrico')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (5,'Susrealismo','Se busca representar trasladando las imágenes oníricas de manera mentalmente libre sin la participación de la conciencia (automatismo). La forma de representación es libre.','geometrico')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (6,'Realismo americano','Como el Realismo, muestra la realidad objetiva en general pero ubicado en America','colores')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (7,'Luminismo','Es impresionismo donde el objetivo predominante era plasmar lo mejor posible el efecto de la luz','colores')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (8,'Gótico','La pintura gótica dejó de ser mural para pasar a retablos situados en los altares de las iglesias, y empezó a desarrollarse la pintura en lienzo, al temple o al óleo.','clasico')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (9,'Abstracto lirico','Expresión de la emoción pictórica del artista, individual e inmediata. Rechazan representar la realidad de forma objetiva.','geometrico')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (10,'Arte Naif','Pinturas de estilo infantil, sin utilización de técnica. Obras cargadas de ingenuidad.','colores')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (11,'Puntillismo','Técnica impresionista consistente en la yuxtaposición de los colores sobre el lienzo, de modo que producen un nuevo tono al fundirse en la retina del espectador.','colores')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (12,'Expresionismo','Su objetivo primordial era transmitir los sentimientos más profundos del artísta. La diferencia con el Fauvismo, es que usaban más variedad de colores al reflejar el mundo de modo realista y con fidelidad. La emoción debía ser expresada, dejando fluir libremente la inspiración del artísta.','colores')");

        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (13,'Neoclasicismo','Tiene la característica de situar a los personajes en forma central y siempre evocando a la mitología clásica','clasico')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (14,'Romanticismo','Se basa en representar la obra dando énfasis al sentimiento','clasico')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (15,'Futurismo','Máquina y Movimiento, son fundamentales en este estilo. Trataban de retratar algo así como una foto movida, ya sea haciéndolo por partes, pero siempre logrando dar la sensación de movimiento','geometrico')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (16,'Simbolismo','Abandonan los temas cotidianos por los contenidos simbólicos y conceptuale','neutro')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (17,'Art Nouveau','Con diseños de gran delicadeza en torno a una figura femenina, con un tratamiento erótico, se alejan de la figuración para centrarse en el mero adorno, muy cerca del diseño industrial','geometrico')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (18,'Art Decó','Revela una mezcla variada de geometría, simplicidad y abstracción combinadas con colores vibrantes y simples, todo ello sin apartarse de la tradición pictórica, sino combinándose con ella. \nLas líneas del Art Deco son rectas y angulares, pero también curvadas, circulares y ovales, figuras geométricas como el hexágono y el pentágono','geometrico')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (19,'Fauvismo','Representaba de manera más expresiva en relación a los colores muy intensos y con mucho uso del verde en su mayoría, y con poco dibujo.','colores')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (20,'Dadaísmo','Antiarte, nacido en símbolo de protesta hacia un orden establecido que se daba en la literatura básicamente. Su máximo exponente: Marcel Duchamp.','geometrico')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (21,'Pop art','se caracteriza por el empleo de imágenes de la cultura popular tomadas de los medios de comunicación, tales como anuncios publicitarios, comic books, objetos culturales «mundanos» y del mundo del cine. El arte pop, como la música pop, buscaba utilizar imágenes populares en oposición a la elitista cultura existente en las Bellas Artes, separándolas de su contexto y aislándolas o combinándolas con otras,1 además de resaltar el aspecto banal o kitsch de algún elemento cultural, a menudo a través del uso de la ironía.','neutro')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (22,'Hiperrealismo','El hiperrealismo es considerado un avance del fotorealismo por los métodos utilizados','neutro')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (23,'Renacimiento','Los artistas se inspiraron en el arte clásico grecorromano, por lo que se habló de «renacimiento» artístico tras el oscurantismo medieval. Estilo inspirado en la naturaleza, surgieron nuevos modelos de representación, como el uso de la perspectiva. Sin renunciar a la temática religiosa, cobró mayor relevancia la representación del ser humano y su entorno, apareciendo nuevas temáticas como la mitológica o la histórica, o nuevos géneros como el paisaje, el bodegón e, incluso, el desnudo. La belleza dejó de ser simbólica, como en la era medieval, para tener un componente más racional y mesurado, sobre la base de la armonía y la proporción.','clasico')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (24,'Manierismo','parte última del Renacimiento (es decir, un Bajo Renacimiento). Su caracterización es problemática','clasico')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (25,'Barroco','Se dijeron muchas cosas de este estilo, pero lo que predominó es el tema sobre el exceso de ornamentación','clasico')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (26,'Rococó','Individualista, antiformalista y cortesano. Se caracteriza por el gusto por los colores luminosos, suaves y claros.','clasico')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (27,'Neofiguración','Una vuelta a la pintura figurativa frente a la abstracción, aunque los pintores tratan el tema de una manera informal y expresionista.','neutro')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (28,'Minimalista','Las diferentes formas están reducidas a estados mínimos de orden y complejidad desde el punto de vista morfológico.','geometrico')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (29,'Abstracto Expresiva','Subjetiva y espontánea. Métodos de creación impulsivos e improvisados. Expresividad en los elementos visuales. Capacidad sensitiva y expresiva de la factura y materiales artísticos. Composición asistemática y falta de estructura. Vaguedad, ambigüedad y sugestiidad','')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (30,'Abstracto Geometrica','Objetiva y universal. Planificación de la obra sobre principios racionales, previa a la creación. Prohíbe la expresividad de los elementos visuales, defendiendo el uso de los elementos neutrales, normalmente geométricos\n" +
                "Elimina la capacidad sensitiva y expresiva de los materiales, defiende una factura impersonal. Composición sistemática y lógicamente estructural. Claridad, precisión y objetividad','geometrico')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (31,'Neoimpresionismo','Evolucionando desde el impresionismo, pero con la técnica de puntillismo.','colores')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (32,'Fotorrealismo','Se basa en hacer un cuadro a partir de una fotografía, considerada una variante del hiperrealismo.','neutro')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (33,'Op-art','En las obras de op art el observador participa activamente moviéndose o desplazándose para poder captar el efecto óptico completamente, por lo tanto se puede decir que no existe ningún aspecto emocional en las obras','neutro')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (34,'Neo-pop','Un paso mas lejos que el Pop art debido a la disponibilidad de imágenes mediáticas desde el pop-art ha crecido exponencialmente','neutro')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (35,'Constructivismo ','Incorpora a la obra artística los conceptos de espacio y tiempo, a fin de conseguir formas dinámicas (Rusia).\n Predominio de la tridimensionalidad y las líneas inclinadas, también, poseían motivos abstractos, utilizaban formas geométricas y lineales.','geometrico')");
        db.execSQL("INSERT INTO Estilos (id, nombre, descripcion, grupo) VALUES (36,'Suprematismo ','Abstracción geométrica y el arte abstracto, en búsqueda de la supremacía de la nada y la representación del universo sin objetos. El suprematismo rechazaba el arte convencional buscando la pura sensibilidad a través de la abstracción geométrica. Surgió en forma paralela al constructivismo.','geometrico')");



        //los autores suelen tener mas de un estilo pictorico
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (0,0,4)"); //Cubismo,
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (1,0,5)"); //Surrealismo
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (2,0,12)");//Expresionismo,
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (3,1,1)"); //Posimpresionismo
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (4,1,2)"); //impresionismo
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (5,1,12)");//Expresionismo,
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (6,1,19)");//fauvismo,
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (7,54,0)");//abstracto,
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (8,54,21)");//Pop art,
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (9,54,32)");//Fotorrealismo,
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (10,53,4)");//Cubismo,
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (11,52,4)");//Cubismo,
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (12,51,7)");//Luminismo,
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (13,50,7)");//Luminismo,
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (14,50,14)");//Romanticismo,
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (15,49,7)");//Luminismo,
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (16,48,7)");//Luminismo,
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (17,48,3)");//Realismo,
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (18,47,7)");//Luminismo,
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (19,46,7)");//Luminismo,
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (20,46,2)");//Impresionista,
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (21,45,7)");//Luminismo,
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (22,44,4)");//  Cubismo
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (23,44,5)");// Susrealismo
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (24,44,20)");// Dadaísmo
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (25,43,5)");// Susrealismo
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (26,43,18)");// Art Deco
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (27,43,5)");// Susrealismo
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (28,43,1)");// Posimpresionismo
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (29,42,5)");// Susrealismo
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (30,42,12)");// expresionista
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (31,42,4)");// Cubismo
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (32,42,33)");// Op-art
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (33,41,3)");// Realismo
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (34,41,2)");// impresionismo
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (35,40,1)");//
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (36,39,7)");//
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (37,39,14)");//
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (38,38,2)");//
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (39,37,2)");//
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (40,37,3)");//
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (41,36,11)");//puntillismo
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (42,35,11)");//puntillismo
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (43,35,2)");// impresionismo
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (44,35,1)");//Posimpresionismo
        db.execSQL("INSERT INTO AutorEstilos (id, idAutor, idEstilo) VALUES (45,35,3)");//Realismo

        //Insertamos los datos en la tabla Autores
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (0,'Pablo Picasso',4)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (1,'Vincent Van Gogh',1)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (2,'Pierre-Auguste Renoir',2)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (3,'Claude Monet',2)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (4,'Edgar Degas',2)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (5,'Paul Cézanne',2)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (6,'Joaquín Sorolla',1)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (7,'Henri de Toulouse-Lautrec',2)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (8,'Marie Bracquemond',2)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (9,'Camille Pissarro',2)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (10,'Berthe Morisot',2)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (11,'Frédéric Bazille',2)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (12,'Gustave Caillebotte',2)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (13,'Vasili Kandinski',0)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (14,'Édouard Manet',2)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (15,'Edward Hopper',6)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (16,'Alfred Sisley',2)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (17,'Everett Shinn',6)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (18,'George Wesley Bellows',6)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (19,'Andrew Wyeth',6)");

        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (20,'George Benjamin Luks',6)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (21,'Grant Wood',6)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (22,'John Sloan',6)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (23,'Charles Sheeler',6)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (24,'Robert Henri',6)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (25,'William Glackens',6)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (26,'Joan Miro',6)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (27,'Frida Kahlo',10)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (28,'Henri Julien Félix Rousseau',10)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (29,'Marc Chagall',10)");

        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (30,'George Seurat',11)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (31,'Paul Gauguin',1)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (32,'Paul Signac',11)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (33,'Henri Moret',11)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (34,'Henri-Edmond Cross',11)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (35,'Theo van Rysselberghe',11)");

        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (36,'Henri Person',11)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (37,'Peder Severin Krøyer',2)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (38,'Alexander Koester',2)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (39,'Thomas Moran',7)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (40,'Peter Tom-Petersen',1)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (41,'Frits Thaulow',1)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (42,'Maurits Cornelis Esche',5)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (43,'René Magritte',5)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (44,'Salvador Dalí',5)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (45,'Emile Claus',7)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (46,'Évariste Carpentier',7)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (47,'Ferdinand Hart Nibbrig',7)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (48,'Wahbi al-Hariri',7)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (49,'Fitz Hugh Lane',7)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (50,'Martin Johnson Heade',7)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (51,'James Augustus Suydam',7)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (52,'Georges Braque',4)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (53,'Juan Gris',4)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (54,'Gerhard Richter',0)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (55,'Requena Nozal',0)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (56,'Jackson Pollock',0)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (57,'Tarsila do Amaral',10)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (58,'Anna Mary Robertson Moses',10)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (59,'Andy Warhol',21)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (60,'Roy Lichtenstein',21)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (61,'Richard Hamilton',21)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (62,'Eduardo Paolozzi',21)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (63,'Robert Rauschenberg',21)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (64,'carlos saenz de tejada',18)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (65,'romain de tirtoff',18)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (66,'jose de almada negreiros',18)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (67,'Tamara de lempicka',18)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (68,'adolphe jean marie mouron',18)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (69,'john archibald austen',18)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (70,'john vassos',18)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (71,'bernardo marques',18)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (72,'Edvard Munch',12)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (73,'Ernst Ludwig Kirchner',12)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (74,'Amedeo Modigliani',12)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (75,'Otto dix',12)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (76,'Emil Nolde',12)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (77,'James Ensor',12)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (78,'Franz Marc',12)");

        //Insertamos los datos en la tabla Cuadros/Obras
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (0,0,4,'Maya à la poupée','cuadro000')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (1,0,0,'Mujer sentada','cuadro001')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (2,0,4,'El Guernica','cuadro002')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (3,1,1,'Autorretrato','cuadro003')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (4,1,1,'El dormitorio en Arlés','cuadro004')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (5,0,4,'Las señoritas de Avignon','cuadro005')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (6,0,4,'Mujer frente al espejo','cuadro006')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (7,0,4,'Autorretrato','cuadro007')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (8,0,4,'Las meninas','cuadro008')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (9,1,1,'Autorretrato','cuadro009')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (10,1,1,'La Noche Estrellada','cuadro010')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (11,2,2,'Los paraguas','cuadro011')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (12,13,0,'Several Circles','cuadro012')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (13,13,0,'Composición Ocho','cuadro013')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (14,2,2,'Baile en el Moulin de la Galette','cuadro014')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (15,2,2,'By the Seashore','cuadro015')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (16,2,2,'Oarsmen at Chatou','cuadro016')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (17,3,2,'Impresion sol nacimiente','cuadro017')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (18,3,2,'Mujer con sombrilla','cuadro018')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (19,3,2,'Londres el parlamento','cuadro019')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (20,3,2,'Crepúsculo en Venecia','cuadro020')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (21,3,2,'Bain à la Grenouillère','cuadro021')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (22,14,2,'El Bar del Folies-Bergère','cuadro022')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (23,14,2,'Boating','cuadro023')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (24,14,2,'Olimpia','cuadro024')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (25,14,2,'La música en las Tullerías','cuadro025')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (26,6,7,'El Balandrito','cuadro026')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (27,15,6,'Autorretrato','cuadro027')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (28,15,6,'Los noctámbulos','cuadro028')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (29,15,6,'Edward Hopper','cuadro029')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (30,15,6,'Casa Junto a la Vía del Tren','cuadro030')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (31,15,6,'Lighthouse at Two Lights','cuadro031')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (32,15,6,'Edward Hopper','cuadro032')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (33,15,6,'Sol de la Mañana','cuadro033')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (34,5,1,'los jugadores de cartas','cuadro034')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (35,5,1,'Cesto de manzanas','cuadro035')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (36,5,1,'Los grandes bañistas','cuadro036')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (37,0,5,'*****','cuadro037')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (38,0,5,'El Arlequin','cuadro038')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (39,4,2,'La absenta','cuadro039')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (40,1,1,'Autorretrato','cuadro040')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (41,1,1,'Trigal con cuervos','cuadro041')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (42,15,6,'Esquire','cuadro042')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (43,3,2,'Jardin Giverny','cuadro043')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (44,3,2,'Puente japones','cuadro044')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (45,3,2,'Puente charing cross','cuadro045')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (46,6,7,'Caminando por la playa','cuadro046')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (47,6,7,'Maria playa biarritz','cuadro047')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (48,16,2,'Nieve en argenteuil','cuadro048')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (49,16,2,'Primera helada','cuadro049')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (50,16,2,'Puente en villeneuve','cuadro050')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (51,15,6,'Atardecer cape cod','cuadro051')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (52,15,6,'Carretera cuatro carriles','cuadro052')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (53,15,6,'Domingo temprano','cuadro053')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (54,15,6,'Dos en gradas','cuadro054')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (55,15,6,'Etapa larga','cuadro055')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (56,15,6,'Habitacion nueva york','cuadro056')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (57,15,6,'Lobby hotel','cuadro057')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (58,15,6,'New york heaven hartford','cuadro058')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (59,15,6,'Oficina de noche','cuadro059')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (60,9,2,'El Pont Neuf','cuadro060')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (61,6,7,'Bano caballo','cuadro061')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (62,6,7,'El pescador','cuadro062')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (63,6,7,'Niña entrando bano','cuadro063')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (64,6,7,'Niñas mar','cuadro064')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (65,6,7,'Pescadoras valencia','cuadro065')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (66,6,7,'Saliendo bano','cuadro066')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (67,6,7,'Botes descanso','cuadro067')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (68,6,7,'Clotilde elena rocas','cuadro068')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (69,6,7,'Cosiendo vela','cuadro069')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (70,6,7,'jardin 1913','cuadro070')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (71,17,6,'The white ballet','cuadro071')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (72,18,6,'Dempsey firpo','cuadro072')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (73,19,6,'El mundo de Cristina','cuadro073')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (74,20,6,'Alien Street','cuadro074')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (75,20,6,'Madison square','cuadro075')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (76,21,6,'Gótico americano','cuadro076')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (77,19,6,'Winter','cuadro077')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (78,22,6,'Mcsorley s bar','cuadro078')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (79,23,6,'Paisaje americano','cuadro079')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (80,24,6,'Nieve New York','cuadro080')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (81,25,6,'East river park','cuadro081')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (82,13,0,'Composicion 8','cuadro082')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (83,13,0,'Estudio color cuadrados','cuadro083')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (84,13,0,'lineas transversas','cuadro084')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (85,26,5,'cantante melancolico','cuadro085')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (86,26,5,'mujer pajaros amanecer','cuadro086')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (87,26,10,'La masia','cuadro087')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (88,26,5,'Bodegón del zapato viejo','cuadro088')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (89,26,5,'La sonrisa de alas flameantes','cuadro089')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (90,1,1,'La avenida de los Alyscamps','cuadro090')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (91,26,5,'Carnaval arlequin','cuadro091')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (92,26,0,'Oro azul','cuadro092')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (93,26,10,'La casa de la palmera','cuadro093')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (94,27,10,'La columna rota','cuadro094')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (95,28,10,'La gitana dormida','cuadro095')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (96,28,10,'El sueño','cuadro096')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (97,28,10,'Tigre en una tormenta tropical','cuadro097')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (98,28,10,'Yo mismo: Retrato-Paisaje','cuadro098')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (99,28,10,'exotic-landscape','cuadro099')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (100,27,10,'Naturaleza muerta con fruta y perico','cuadro100')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (101,27,10,'pensando en la muerte','cuadro101')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (102,27,10,'Sin Esperanza','cuadro102')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (103,27,10,'Las dos fridas','cuadro103')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (104,29,4,'la passeggiata','cuadro104')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (105,29,4,'Los amantes verdes','cuadro105')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (106,29,4,'Los amantes azules','cuadro106')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (107,29,10,'The Birthday','cuadro107')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (108,29,10,'Bride with a Fan','cuadro108')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (109,29,4,'Homage to Apollinaire','cuadro109')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (110,16,2,'Bridge at Villeneuve la Garenne','cuadro110')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (111,16,2,'The Bridge at Moret','cuadro111')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (112,16,2,'The Seine at Argenteuil','cuadro112')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (113,16,2,'Flood at Port-Marly','cuadro113')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (114,16,2,'Molesey Weir Morning','cuadro114')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (115,19,6,'Viento del mar','cuadro115')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (116,19,6,'Autorretrato','cuadro116')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (117,19,6,'Dodges Ridge','cuadro117')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (118,9,2,'Boulevard Montmartre de noche','cuadro118')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (119,9,2,'Sunset, Rouen','cuadro119')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (120,9,2,'Boulevard Montmartre, una mañana de invierno','cuadro120')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (121,9,2,'June Morning at Pontoise','cuadro121')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (122,30,11,'The Seine at Courbevoie','cuadro122')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (123,30,11,'The river Seine at La Grande-Jatte','cuadro123')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (124,30,11,'La torre Eiffel','cuadro124')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (125,30,2,'Un baño en Asnieres','cuadro125')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (126,30,11,'The Channel of Gravelines, Petit Fort Philippe','cuadro126')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (127,7,1,'La toilette','cuadro127')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (128,7,1,'Monsieur Fourcade','cuadro128')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (129,7,1,'Cama el beso ','cuadro129')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (130,7,1,'En el Moulin-Rouge, el baile','cuadro130')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (131,31,1,'El espíritu de los muertos vela','cuadro131')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (132,31,1,'Autorretrato','cuadro132')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (133,7,1,'bailarina sentada','cuadro133')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (134,31,1,'autorretraro','cuadro134')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (135,31,1,'Mujeres de Tahití','cuadro135')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (136,31,1,'Café de noche en Arlés','cuadro136')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (137,31,1,'Cuando te casas','cuadro137')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (138,31,1,'De dónde venimos Quiénes somos Adónde vamos','cuadro138')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (139,31,1,'el cristo amarillo','cuadro139')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (140,33,11,'Campo en Bretaña','cuadro140')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (141,32,11,'El pino (St. Tropez)','cuadro141')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (142,32,11,'Paris, look to the Ile','cuadro142')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (143,32,11,'Venice, the pink cloud - Paul Signac','cuadro143')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (144,32,11,'Sailing ship in the port','cuadro144')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (145,32,11,'The Seine near Samois','cuadro145')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (146,34,11,'Channel in Venice','cuadro146')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (147,30,11,'Entry to the port','cuadro147')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (148,35,11,'Family in the orchard','cuadro148')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (149,35,11,'moonlit night in Boulogne','cuadro149')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (150,36,11,'Constantinople','cuadro150')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (151,2,2,'Amapolas en Argenteuil','cuadro151')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (152,37,1,'Noche de Verano en la playa','cuadro152')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (153,4,2,'Dancers in blue','cuadro153')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (154,37,1,'Jungen am Strand von Skagen','cuadro154')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (155,38,1,'Ducks on the sea shore','cuadro155')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (156,39,1,'Opalescent Venice','cuadro156')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (157,39,1,'Venecia','cuadro157')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (158,40,1,'Summer s day in Helsingör','cuadro158')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (159,16,1,'La Pradera','cuadro159')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (160,41,1,'Ein venezianischer Kanal','cuadro160')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (161,41,1,'The rivulet Laita in Quimperle','cuadro161')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (162,5,2,'Golfo de Marsella Vista desde Estaque','cuadro162')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (163,5,2,'autorretrato','cuadro163')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (164,5,2,'Lac d Annecy','cuadro164')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (165,5,2,'Mont Saint Victoire','cuadro165')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (166,5,2,'Naturaleza muerta con manzana','cuadro166')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (167,5,2,'Still Life with Apples and ..','cuadro167')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (168,42,5,'Cascada','cuadro168')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (169,42,5,'relatividad','cuadro169')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (170,42,5,'Escalera arriba y escalera abajo','cuadro170')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (171,42,5,'Mano con esfera reflectante','cuadro171')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (172,42,5,'Manos dibujando','cuadro172')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (173,43,5,'El espejo falso','cuadro173')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (174,43,5,'El hijo del hombre','cuadro174')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (175,43,5,'Golconda','cuadro175')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (176,43,5,'Los amantes','cuadro176')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (177,43,5,'Man in a Bowler Hat','cuadro177')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (178,43,5,'The Happy Donor','cuadro178')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (179,44,5,'Crucifixión','cuadro179')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (180,44,5,'El gran masturbador','cuadro180')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (181,44,5,'La persistencia de la memoria','cuadro181')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (182,44,5,'La tentación de San Antonio','cuadro182')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (183,44,5,'Leda atómica','cuadro183')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (184,44,5,'Lincoln en Dalivision','cuadro184')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (185,43,5,'The Voice of Space','cuadro185')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (186,44,5,'Muchacha en la ventana','cuadro186')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (187,44,5,'Los elefantes','cuadro187')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (188,44,5,'sueño causado por el vuelo de una abeja alrededor de una granada un segundo antes del despertar gala y tigres','cuadro188')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (189,45,7,'Young peasant women at the leie','cuadro189')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (190,45,7,'canal in zeeland','cuadro190')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (191,45,7,'The Old Gardener','cuadro191')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (192,45,7,'le pique nique','cuadro192')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (193,45,7,'Sunset over Waterloo Bridge','cuadro193')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (194,45,7,'Dans la Prairie','cuadro194')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (195,45,7,'Autorretrato','cuadro195')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (196,45,7,'La Faneuse','cuadro196')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (197,45,7,'Sunny Day','cuadro197')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (198,46,7,'Conversation intime','cuadro198')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (199,46,7,'girl with watering can','cuadro199')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (200,46,7,'the little goatherd','cuadro200')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (201,47,7,'Gezicht op zoutlande','cuadro201')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (202,47,7,'El valle Rummel en Constantine, Argelia','cuadro202')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (203,48,7,'capitol watercolor','cuadro203')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (204,49,7,'Brace s Rock, Eastern Point, Gloucester','cuadro204')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (205,50,7,'Newburyport Meadows','cuadro205')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (206,51,7,'Long Island','cuadro206')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (207,52,4,'Botella y peces','cuadro207')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (208,52,4,'Casas en L Estaque','cuadro208')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (209,52,4,'Hombre con guitarra','cuadro209')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (210,52,4,'Plato de frutas y vaso','cuadro210')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (211,53,4,'Botellas cuchillo','cuadro211')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (212,53,4,'Guitar on a table','cuadro212')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (213,53,4,'The Musician s Table','cuadro213')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (214,53,4,'Retrato de Pablo Picasso','cuadro214')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (215,53,4,'Guitarra sobre una silla','cuadro215')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (216,54,0,'Abstract Painting 780-1','cuadro216')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (217,54,0,'ludorff','cuadro217')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (218,54,0,'mediation','cuadro218')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (219,54,0,'station','cuadro219')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (220,54,0,'A.B. Courbet','cuadro220')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (221,31,1,'Los Alyscamps','cuadro221')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (222,56,0,'Birth','cuadro222')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (223,56,0,'Circumcision January','cuadro223')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (224,56,0,'Number 5','cuadro224')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (225,56,0,'Number 3','cuadro225')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (226,55,0,'Desorden requena','cuadro226')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (227,55,0,'Espuma vi','cuadro227')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (228,55,0,'Homenaje a gora','cuadro228')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (229,35,11,'In The Shade Of The Pines','cuadro229')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (230,35,11,'Port Entrance at Volendam','cuadro230')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (231,35,11,'The Point of Rossignol','cuadro231')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (232,57,10,'Abaporu','cuadro232')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (233,57,10,'Carnaval em Madureira','cuadro233')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (234,57,10,'Maternidade','cuadro234')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (235,57,10,'The egg','cuadro235')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (236,57,10,'A cuca','cuadro236')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (237,58,10,'','cuadro237')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (238,58,10,'','cuadro238')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (239,58,10,'A tramp on christmas day','cuadro239')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (240,58,10,'Mt nebo on the hill','cuadro240')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (241,58,10,'The Spring in Evening','cuadro241')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (242,58,10,'Catching the Turkey','cuadro242')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (243,58,10,'The quilting bee','cuadro243')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (244,59,21,'Campbell s soup can onion','cuadro244')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (245,59,21,'Che guevara','cuadro245')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (246,59,21,'Double mona lisa','cuadro246')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (247,59,21,'Liz taylor','cuadro247')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (248,59,21,'The scream after munch-5','cuadro248')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (249,59,21,'Absolut vodka','cuadro249')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (250,60,21,'forget it forget me','cuadro250')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (251,60,21,'girl with ball 1961','cuadro251')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (252,60,21,'hey you','cuadro252')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (253,60,21,'in the car 1963','cuadro253')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (254,60,21,'look mickey 1961','cuadro254')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (255,60,21,'Nude at vanity','cuadro255')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (256,61,21,'Just What Is It That Makes Today s Homes So Different, So Appealing','cuadro256')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (257,61,21,'Picasso s meninas','cuadro257')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (258,61,21,'The solomon guggenheim architect','cuadro258')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (259,60,21,'Drowning girl','cuadro259')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (260,60,21,'Kiss','cuadro260')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (261,63,21,'Meet the people','cuadro261')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (262,63,21,'trazador de lineas','cuadro262')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (263,62,21,'sack o sauce','cuadro263')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (264,62,21,'Bunk evadne in green dimension','cuadro264')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (265,63,21,'Bycicle','cuadro265')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (266,63,21,'Partitura Abierta','cuadro266')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (267,64,18,'a color sketch to suit heraclius fournier','cuadro267')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (268,65,18,'aphrodite','cuadro268')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (269,65,18,'athena','cuadro269')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (270,66,18,'black and white','cuadro270')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (271,64,18,'cover for abc','cuadro271')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (272,64,18,'cover for la moda en españa','cuadro272')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (273,64,18,'cover for verticle magazine','cuadro273')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (274,65,18,'emerald','cuadro274')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (275,67,18,'girl with gloves','cuadro275')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (276,68,18,'golden club','cuadro276')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (277,68,18,'grand spor','cuadro277')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (278,69,18,'hamlet 4','cuadro278')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (279,69,18,'hamlet 43','cuadro279')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (280,64,18,'illustration for carmen','cuadro280')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (281,70,18,'illustration for oscar wilde s salome','cuadro281')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (282,67,18,'kizette on the balcony','cuadro282')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (283,68,18,'l atlantique','cuadro283')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (284,67,18,'portrait in the green bugatti','cuadro284')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (285,67,18,'portrait of a man or mr tadeusz de lempicki','cuadro285')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (286,67,18,'portrait of madame','cuadro286')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (287,67,18,'portrait of mrs boucard','cuadro287')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (288,71,18,'sem t tulo','cuadro288')");

        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (289,4,2,'dance class at the opera','cuadro289')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (290,4,2,'place de la concorde','cuadro290')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (291,4,2,'self portrait','cuadro291')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (292,4,2,'the dancing class','cuadro292')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (293,4,2,'two ballet dancers','cuadro293')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (294,1,1,'cafe terrace place du forum arles','cuadro294')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (295,1,1,'factories at asnieres seen from the quai de clichy','cuadro295')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (296,1,1,'irises','cuadro296')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (297,1,1,'italian woman agostina segatori','cuadro297')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (298,1,1,'still life vase with fifteen sunflowers 1888 1 ','cuadro298')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (299,72,12,'madonna','cuadro299')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (300,72,12,'el grito 1893','cuadro300')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (301,72,12,'Amor y dolor','cuadro301')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (302,72,12,'Ansiedad','cuadro302')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (303,72,12,'friedrich nietzsche','cuadro303')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (304,72,12,'La danza de la vida','cuadro304')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (305,72,12,'Melancolía','cuadro305')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (306,72,12,'Muerte en la alcoba','cuadro306')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (307,72,12,'La Pubertad','cuadro307')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (308,72,12,'summer night inger on the shore 1889 ','cuadro308')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (309,72,12,'the flower of pain','cuadro309')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (310,72,12,'writer hans jaeger','cuadro310')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (311,72,12,'El grito 1893','cuadro311')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (312,72,12,'El grito 1895','cuadro312')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (313,72,12,'El grito 1896','cuadro313')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (314,72,12,'El grito 1910','cuadro314')");

        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (315,73,12,'Cinco mujeres en la calle','cuadro315')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (316,73,12,'Female Artist','cuadro316')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (317,73,12,'Escena de calle de Berlín','cuadro317')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (318,73,12,'Autorretrato','cuadro318')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (319,73,12,'Equestrienne','cuadro319')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (320,73,12,'Fränzi ante una silla tallada','cuadro320')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (321,73,12,'Erna with Cigarette','cuadro321')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (322,74,12,'head of a girl','cuadro322')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (323,74,12,'jean alexandre','cuadro323')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (324,74,12,'jeanne hebuterne in a hat','cuadro324')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (325,74,12,'portrait of a young girl','cuadro325')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (326,74,12,'portrait of chaim soutine','cuadro326')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (327,74,12,'portrait of lunia czechowska in white blouse','cuadro327')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (328,74,12,'reclining nude on a blue cushion red nude','cuadro328')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (329,74,12,'Portret van Lunia Czechowska','cuadro329')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (330,74,12,'portrait of margarita','cuadro330')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (331,74,12,'Andr rouveyre','cuadro331')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (332,74,12,'Dedicated to the dramatist frank wedekind','cuadro332')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (333,75,12,'La belleza','cuadro333')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (334,75,12,'Retrato de la periodista Sylvia von Harden','cuadro334')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (335,75,12,'Ellis','cuadro335')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (336,76,12,'dance around the golden calf','cuadro336')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (337,76,12,'mask still life 3','cuadro337')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (338,76,12,'the last supper','cuadro338')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (339,76,12,'legend saint mary of egypt death in the desert','cuadro339')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (340,77,12,'Esqueletos disputandose un arrenque','cuadro340')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (341,77,12,'death and the masks','cuadro341')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (342,78,12,'nude lying in the flowers','cuadro342')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (343,78,12,'dog lying in the snow','cuadro343')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (344,78,12,'blue horse 1','cuadro344')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (345,78,12,'blue fox','cuadro345')");


        //Insertamos los datos en la tabla configuracion
        db.execSQL("INSERT INTO Configuracion (id, NumeroPreguntas, Dificultad, tipo, tiempo,animacion ) VALUES (1,12,'NORMAL','AUTOR','NO','SI')");

    }

    //actualizar su estructura respectivamente.
    @Override
    public void onUpgrade(SQLiteDatabase db, int version1, int version2) {

        //version 2 incluye un nuevo tipo de juego
        if (version1 < 2) {

            android.util.Log.v("BBDD", "Actualizamos a versión 2");

            db.execSQL("DROP TABLE IF EXISTS Configuracion ");
            db.execSQL("create table Configuracion(id integer primary key, NumeroPreguntas integer, Dificultad text, tipo text, tiempo text)");

            //Insertamos los datos en la tabla configuracion
            db.execSQL("INSERT INTO Configuracion (id, NumeroPreguntas, Dificultad, tipo, tiempo )  VALUES (1,12,'NORMAL','AUTOR','no')");


        }
//        //version para AMERICA
//        if (version1 < 3) {
//
//        }

    }
}