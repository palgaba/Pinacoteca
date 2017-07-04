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

        //Insertamos los datos en la tabla Cuadros/Obras
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (0,0,4,'Maya à la poupée','cuadro000')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (1,0,0,'Mujer sentada','cuadro001')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (2,0,4,'El Guernica','cuadro002')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (3,0,1,'Autorretrato','cuadro003')");
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
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (26,6,2,'El Balandrito','cuadro026')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (27,14,3,'Autorretrato','cuadro027')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (28,15,3,'Los noctámbulos','cuadro028')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (29,15,3,'Edward Hopper','cuadro029')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (30,15,3,'Casa Junto a la Vía del Tren','cuadro030')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (31,15,3,'Lighthouse at Two Lights','cuadro031')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (32,15,3,'Edward Hopper','cuadro032')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (33,15,3,'Sol de la Mañana','cuadro033')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (34,5,1,'los jugadores de cartas','cuadro034')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (35,5,1,'Cesto de manzanas','cuadro035')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (36,5,1,'Los grandes bañistas','cuadro036')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (37,0,5,'*****','cuadro037')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (38,0,5,'El Arlequin','cuadro038')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (39,4,2,'La absenta','cuadro039')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (40,1,1,'Autorretrato','cuadro040')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (41,1,1,'Trigal con cuervos','cuadro041')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (42,15,3,'Esquire','cuadro042')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (43,3,2,'Jardin Giverny','cuadro043')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (44,3,2,'Puente japones','cuadro044')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (45,3,2,'Puente charing cross','cuadro045')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (46,6,2,'Caminando por la playa','cuadro046')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (47,6,2,'Maria playa biarritz','cuadro047')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (48,16,2,'Nieve en argenteuil','cuadro048')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (49,16,2,'Primera helada','cuadro049')");
        db.execSQL("INSERT INTO Cuadros(id, idAutor ,idEstilo ,titulo ,imagen) VALUES (50,16,2,'Puente en villeneuve','cuadro050')");

        //Insertamos los datos en la tabla configuracion
        db.execSQL("INSERT INTO Configuracion (id, NumeroPreguntas, Dificultad, tipo, tiempo ) VALUES (1,12,'facil','autor','no')");

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