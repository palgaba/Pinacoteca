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
        db.execSQL("create table Estilos(id integer primary key, nombre text)");
        db.execSQL("create table Autores(id integer primary key, nombre text, idEstilo integer)");
        db.execSQL("create table Cuadros(id integer primary key, idAutor integer, idEstilo int, titulo text, imagen text)");
        db.execSQL("create table Configuracion(id integer primary key, NumeroPreguntas integer, Dificultad text, tipo text, tiempo text)");

        //Insertamos los datos en la tabla Estilo
        db.execSQL("INSERT INTO Estilos (id, nombre) VALUES (0,'Abstracto')");
        db.execSQL("INSERT INTO Estilos (id, nombre) VALUES (1,'Posimpresionismo')");
        db.execSQL("INSERT INTO Estilos (id, nombre) VALUES (2,'Impresionista')");
        db.execSQL("INSERT INTO Estilos (id, nombre) VALUES (3,'Realismo')");
        db.execSQL("INSERT INTO Estilos (id, nombre) VALUES (4,'Cubismo')");
        db.execSQL("INSERT INTO Estilos (id, nombre) VALUES (5,'Subrealismo')");
        db.execSQL("INSERT INTO Estilos (id, nombre) VALUES (6,'Realismo americano')");
        db.execSQL("INSERT INTO Estilos (id, nombre) VALUES (7,'Luminismo')");
        db.execSQL("INSERT INTO Estilos (id, nombre) VALUES (8,'Regionalismo')");

        //Insertamos los datos en la tabla Autores
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (0,'Pablo Picasso',0)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (1,'Vincent Van Gogh',1)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (2,'Pierre-Auguste Renoir',2)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (3,'Claude Monet',2)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (4,'Edgar Degas',2)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (5,'Paul Cézanne','1')");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (6,'Joaquín Sorolla',2)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (7,'Henri de Toulouse-Lautrec',2)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (8,'Marie Bracquemond',2)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (9,'Camille Pissarro',2)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (10,'Berthe Morisot',2)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (11,'Frédéric Bazille',2)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (12,'Gustave Caillebotte',2)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (13,'Vasili Kandinski',0)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (14,'Édouard Manet',2)");
        db.execSQL("INSERT INTO Autores (id, nombre, idEstilo) VALUES (15,'Edward Hopper',3)");
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
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (76,21,8,'Gótico americano','cuadro076')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (77,19,6,'Winter','cuadro077')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (78,22,6,'Mcsorley s bar','cuadro078')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (79,23,6,'Paisaje americano','cuadro079')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (80,24,6,'Nieve New York','cuadro080')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (81,25,6,'East river park','cuadro081')");

        //Insertamos los datos en la tabla configuracion
        db.execSQL("INSERT INTO Configuracion (id, NumeroPreguntas, Dificultad, tipo, tiempo ) VALUES (1,12,'FACIL','AUTOR','NO')");

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
            db.execSQL("INSERT INTO Configuracion (id, NumeroPreguntas, Dificultad, tipo, tiempo )  VALUES (1,12,'facil','autor','no')");


        }
//        //version para AMERICA
//        if (version1 < 3) {
//
//        }

    }
}