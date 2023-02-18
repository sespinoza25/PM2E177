package com.example.pm2e177.transacciones;

public class Transacciones {
    // Nombre de la base de datos
    public static final String NameDatabase = "PM2E1DB";

    // Tablas de la base de datos
    public static final String tablacontactos = "contactos";

    /* Transacciones de la base de datos PM2E1DB */
    public static final String CreateTBContactos =
            "CREATE TABLE contactos (id INTEGER PRIMARY KEY AUTOINCREMENT, nombres TEXT," +
                    "telefono INTEGER, nota TEXT)";

    public static final String DropTableContactos = "DROP TABLE IF EXISTS contactos";

    //Helpers
    public static final String Empty = "";
}
