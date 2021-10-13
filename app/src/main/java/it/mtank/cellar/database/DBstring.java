package it.mtank.cellar.database;

/**
 * Constant of string utils for create, update and fill the database
 *
 * @version 1.0
 * @author Matteo Tancredi <matteotank@gmail.com>
 */

public class DBstring
{
    /** Name of Database */
    public static final String DBNAME = "shelf.db";

    /** Version of Database */
    public static final int DBVERSION = 1;

    /** Name of Tables */
    public static final String TBCATEGORIES = "categories";
    public static final String TBPRODUCTS = "products";

    /** String to create Tables */
    public static final String DBCREATE_CATEGORIES = "CREATE TABLE IF NOT EXISTS " + TBCATEGORIES + " (category_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
            "category TEXT NOT NULL);";

    public static final String DBCREATE_PRODUCTS = "CREATE TABLE IF NOT EXISTS " + TBPRODUCTS + " (product_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
            "category_id INTEGER NOT NULL, " +
            "product TEXT NOT NULL, " +
            "company TEXT NOT NULL, " +
            "denomination TEXT, " +
            "year NUMERIC, " +
            "bio INTEGER NOT NULL, " +
            "minimum NUMERIC NOT NULL DEFAULT 0, " +
            "quantity NUMERIC NOT NULL DEFAULT 0, " +
            "sales NUMERIC NOT NULL DEFAULT 0, " +
            "price REAL NOT NULL DEFAULT 0.00, " +
            "pos INTEGER NOT NULL);";

    /** String to fill database */
    public static final String FILL_CATEGORIES = "INSERT INTO " + TBCATEGORIES + " VALUES (1,'Spumanti Italiani'),\n" +
            " (2,'Bianchi Toscani'),\n" +
            " (3,'Rosati Toscani'),\n" +
            " (4,'Bianchi Italiani'),\n" +
            " (5,'Chianti Classico'),\n" +
            " (6,'Montalcino e Montepulciano'),\n" +
            " (7,'Chianti'),\n" +
            " (8,'Costa e Maremma'),\n" +
            " (9,'Rossi Italiani'),\n" +
            " (10,'Supertuscan'),\n" +
            " (11,'Champagne'),\n" +
            " (12,'Vini da Dessert'),\n" +
            " (13,'Bollicine da Dessert')," +
            " (14,'Birre Artigianali');";

    public static final String FILL_PRODUCTS = "INSERT INTO " + TBPRODUCTS + " VALUES (1,1,'Pros. Valdob. Extra Dry','Le Manzane',NULL,NULL,0,0,25,0,0.00,1),\n" +
            " (2,1,'Millesimato 20.10','Le Manzane',NULL,2016,0,0,19,0,0.00,2),\n" +
            " (3,1,'Pros. Valdob. Superiore','Le Vigne di Alice',NULL,2017,0,0,6,0,0.00,3),\n" +
            " (4,1,'Franciacorta Brut','Terre Ducco',NULL,NULL,0,0,4,0,0.00,4),\n" +
            " (5,1,'Franciacorta Brut Saten','Terre Ducco',NULL,NULL,0,0,4,0,0.00,5),\n" +
            " (6,1,'Franciacorta Brut Saten','Solive',NULL,2016,0,0,4,0,0.00,6),\n" +
            " (7,1,'Franciacorta Brut Rosè','Solive',NULL,NULL,0,0,3,0,0.00,7),\n" +
            " (8,2,'Vernaccia di San Gimignano','Tenuta le Calcinaie',NULL,2016,0,0,15,0,0.00,1),\n" +
            " (9,2,'Vern. di San Gimignano Vigna ai Sassi','Tenuta le Calcinaie',NULL,2014,0,0,6,0,0.00,2),\n" +
            " (10,2,'Verm. Maremma Il Bargaglino','Provveditore',NULL,2016,0,0,10,0,0.00,3),\n" +
            " (11,2,'Verm. Maremma Il Bargaglino','Provveditore',NULL,2017,0,0,12,0,0.00,4),\n" +
            " (12,2,'Petrognano','Fattoria di Petrognano',NULL,2016,0,0,8,0,0.00,5),\n" +
            " (13,2,'Bolgheri Bianco Poggio ai Ginepri','Argentiera',NULL,2016,0,0,8,0,0.00,6),\n" +
            " (14,2,'Borgeri Bianco','Giorgio Meletti Cavallari',NULL,2016,0,0,5,0,0.00,7),\n" +
            " (15,2,'Pachar','Lavacchio',NULL,2016,0,0,5,0,0.00,8),\n" +
            " (16,3,'Paneretta Rosato','Castello della Paneretta',NULL,2016,0,0,3,0,0.00,1),\n" +
            " (17,3,'Bolgheri Rosè Poggio ai Ginepri','Argentiera',NULL,2016,0,0,12,0,0.00,2),\n" +
            " (18,3,'Bolgheri Rosè Poggio ai Ginepri','Argentiera',NULL,2017,0,0,24,0,0.00,3),\n" +
            " (19,4,'Chardonnay','Girlan',NULL,2016,0,0,0,29,0.00,1),\n" +
            " (20,4,'Muller Thurgau','Girlan',NULL,2017,0,0,3,0,0.00,2),\n" +
            " (21,4,'Pinot Bianco Plattenriegl','Girlan',NULL,2016,0,0,3,0,0.00,3),\n" +
            " (22,4,'Gewurztraminer Aimè','Girlan',NULL,2016,0,0,4,0,0.00,4),\n" +
            " (23,4,'Pinot Grigio','Di Leonardo',NULL,2017,0,0,41,0,0.00,5),\n" +
            " (24,4,'Sauvignon','Di Leonardo',NULL,2016,0,0,3,0,0.00,6),\n" +
            " (25,4,'Friuliano','Roncus',NULL,2016,0,0,2,0,0.00,7),\n" +
            " (26,4,'Ribolla Gialla','Roncus',NULL,NULL,0,0,3,0,0.00,8),\n" +
            " (27,4,'Fiano','Corte Normanna',NULL,2016,0,0,3,0,0.00,9),\n" +
            " (28,4,'Greco','Corte Normanna',NULL,2017,0,0,3,0,0.00,10),\n" +
            " (29,4,'Grillo','Masseria del Feudo',NULL,2015,0,0,1,0,0.00,11),\n" +
            " (30,4,'Grillo','Masseria del Feudo',NULL,2016,0,0,3,0,0.00,12),\n" +
            " (31,4,'Vermentino di Gallura Loe','Tenute Sa Conca',NULL,2015,0,0,1,0,0.00,13),\n" +
            " (32,4,'Vermentino di Gallura Loe','Tenute Sa Conca',NULL,2016,0,0,4,0,0.00,14),\n" +
            " (33,5,'Ch. Cl. Poggio al Prato','Tommaso Cei',NULL,2016,0,0,48,0,0.00,1),\n" +
            " (34,5,'Ch. Cl. Ceppeto','Mannucci Droandi',NULL,2014,0,0,1,0,0.00,2),\n" +
            " (35,5,'Ch. Cl. Ceppeto','Mannucci Droandi',NULL,2015,0,0,12,0,0.00,3),\n" +
            " (36,5,'Ch. Cl.','Castello della Paneretta',NULL,2014,0,0,4,0,0.00,4),\n" +
            " (37,5,'Ch. Cl. Fonterutoli','Mazzei - Fonterutoli',NULL,2014,0,0,1,0,0.00,5),\n" +
            " (38,5,'Ch. Cl. Fonterutoli','Mazzei - Fonterutoli',NULL,2015,0,0,10,0,0.00,6),\n" +
            " (39,5,'Chianti Classico','Fontodi',NULL,2014,0,0,1,0,0.00,7),\n" +
            " (40,5,'Chianti Classico','Fontodi',NULL,2015,0,0,6,0,0.00,8),\n" +
            " (41,5,'Ch. Cl. Riserva Treggiaia','Tommaso Cei',NULL,2014,0,0,3,0,0.00,9),\n" +
            " (42,5,'Ch. Cl. Riserva Treggiaia','Tommaso Cei',NULL,2015,0,0,10,0,0.00,10),\n" +
            " (43,5,'Ch. Cl. Riserva','Castello della Paneretta',NULL,2013,0,0,3,0,0.00,11),\n" +
            " (44,5,'Ch. Cl. Riserva Villa Antinori','Marchesi Antinori',NULL,2013,0,0,3,0,0.00,12),\n" +
            " (45,5,'Ch. Cl. Riserva','Capanelle',NULL,2012,0,0,1,0,0.00,13),\n" +
            " (46,5,'Ch. Cl. Riserva','Capanelle',NULL,2013,0,0,2,0,0.00,14),\n" +
            " (47,6,'Rosso di Montalcino','Sassodisole',NULL,2015,0,0,10,0,0.00,1),\n" +
            " (48,6,'Rosso di Montalcino','Claudia Ferrero',NULL,2015,0,0,3,0,0.00,2),\n" +
            " (49,6,'Rosso di Montalcino','Claudia Ferrero',NULL,2016,0,0,6,0,0.00,3),\n" +
            " (50,6,'Rosso di Montalcino','Poggio Rubino',NULL,2014,0,0,5,0,0.00,4),\n" +
            " (51,6,'Brunello di Montalcino','Sassodisole',NULL,2012,0,0,15,0,0.00,5),\n" +
            " (52,6,'Brunello di Montalcino','Claudia Ferrero',NULL,2012,0,0,7,0,0.00,6),\n" +
            " (53,6,'Brunello di Montalcino','Poggio Rubino',NULL,2013,0,0,4,0,0.00,7),\n" +
            " (54,6,'Rosso di Montepulciano','Talosa',NULL,2016,0,0,4,0,0.00,8),\n" +
            " (55,6,'Rosso di Montepulciano','Romeo',NULL,2014,0,0,2,0,0.00,9),\n" +
            " (56,6,'Nobile di Montepulciano','Talosa',NULL,2014,0,0,20,0,0.00,10),\n" +
            " (57,6,'Nobile di Montepulciano','Romeo',NULL,2013,0,0,2,0,0.00,11),\n" +
            " (58,6,'Nobile di Montepulciano','Romeo',NULL,2014,0,0,1,0,0.00,12),\n" +
            " (59,6,'Nobile di Montepulciano','Romeo',NULL,2015,0,0,2,0,0.00,13),\n" +
            " (60,7,'Chianti Colli Senesi','Talosa',NULL,2016,0,0,4,0,0.00,1),\n" +
            " (61,7,'Chianti Colli Senesi','Tenuta le Calcinaie',NULL,2015,0,0,8,0,0.00,2),\n" +
            " (62,7,'Chianti Rufina il Cedro','Lavacchio',NULL,2016,0,0,4,0,0.00,3),\n" +
            " (63,7,'Chianti Colli Aretini','Mannucci Droandi',NULL,2015,0,0,1,0,0.00,4),\n" +
            " (64,7,'Chianti Colli Aretini','Mannucci Droandi',NULL,2015,0,0,2,0,0.00,5),\n" +
            " (65,8,'Morellino di Scansano','Le Lupinaie',NULL,2015,0,0,2,0,0.00,1),\n" +
            " (66,8,'Morellino di Scansano','Le Lupinaie',NULL,2016,0,0,4,0,0.00,2),\n" +
            " (67,8,'Bolgheri Rosso Poggio ai Ginepri','Argentiera',NULL,2015,0,0,23,0,0.00,3),\n" +
            " (68,8,'Bolgheri Rosso Poggio ai Ginepri','Argentiera',NULL,2016,0,0,24,0,0.00,4),\n" +
            " (69,8,'Borgeri','Giorgio Meletti Cavallari',NULL,2015,0,0,4,0,0.00,5),\n" +
            " (70,8,'Bolgheri Rosso Villa Donoratico','Argentiera',NULL,2015,0,0,5,0,0.00,6),\n" +
            " (71,8,'Impronte','Giorgio Meletti Cavallari',NULL,2012,0,0,2,0,0.00,7),\n" +
            " (72,8,'Impronte','Giorgio Meletti Cavallari',NULL,2014,0,0,3,0,0.00,8),\n" +
            " (73,9,'Pinot Nero Patricia','Girlan',NULL,2015,0,0,2,0,0.00,1),\n" +
            " (74,9,'Ripasso le Morete','Manara',NULL,2015,0,0,3,0,0.00,2),\n" +
            " (75,9,'Amarone','Manara',NULL,2011,0,0,3,0,0.00,3),\n" +
            " (76,9,'Amarone','Manara',NULL,2013,0,0,3,0,0.00,4),\n" +
            " (77,9,'Barbaresco','Bruno Rocca',NULL,2014,0,0,3,0,0.00,5),\n" +
            " (78,9,'Barbera d''Alba Vigna Gattere','Molino',NULL,2010,0,0,1,0,0.00,6),\n" +
            " (79,9,'Barbera d''Alba Vigna Gattere','Molino',NULL,2012,0,0,2,0,0.00,7),\n" +
            " (80,9,'Barolo','Molino',NULL,2012,0,0,2,0,0.00,8),\n" +
            " (81,9,'Barolo','Molino',NULL,2013,0,0,3,0,0.00,9),\n" +
            " (82,9,'Mezzanotte Primitivo','Morella',NULL,2014,0,0,1,0,0.00,10),\n" +
            " (83,9,'Mezzanotte Primitivo','Morella',NULL,2016,0,0,2,0,0.00,11),\n" +
            " (84,9,'Il Giglio Nero d''Avola','Masseria del Feudo',NULL,2015,0,0,2,0,0.00,12),\n" +
            " (85,10,'Terrine','Castello della Paneretta',NULL,2008,0,0,2,0,0.00,1),\n" +
            " (86,10,'Flaccianello','Fontodi',NULL,2011,0,0,1,0,0.00,2),\n" +
            " (87,10,'Flaccianello','Fontodi',NULL,2014,0,0,2,0,0.00,3),\n" +
            " (88,10,'Tignanello','Tignanello',NULL,2015,0,0,2,0,0.00,4),\n" +
            " (89,10,'Bolgheri Superiore','Argentiera',NULL,2012,0,0,1,0,0.00,5),\n" +
            " (90,10,'Bolgheri Superiore','Argentiera',NULL,2014,0,0,1,0,0.00,6),\n" +
            " (91,10,'Solare','Capanelle',NULL,2005,0,0,1,0,0.00,7),\n" +
            " (92,10,'Solare','Capanelle',NULL,2010,0,0,1,0,0.00,8),\n" +
            " (93,10,'Guado al Tasso','Guado al Tasso',NULL,2014,0,0,0,0,0.00,9),\n" +
            " (94,10,'Guado al Tasso','Guado al Tasso',NULL,2015,0,0,2,0,0.00,10),\n" +
            " (95,10,'50 & 50','Capanelle',NULL,2013,0,0,2,0,0.00,11),\n" +
            " (96,10,'Sassicaia','Sassicaia',NULL,2014,0,0,2,0,0.00,12),\n" +
            " (97,10,'Ornellaia','Tenuta dell''Ornellaia',NULL,2014,0,0,2,0,0.00,13),\n" +
            " (98,11,'Cuvée Prestige','Francis Orban',NULL,NULL,0,0,2,0,0.00,1),\n" +
            " (99,11,'Brut Reserve Vieilles Vigne','Francis Orban',NULL,NULL,0,0,1,0,0.00,2),\n" +
            " (100,11,'Cuvée de Réserve','Roger Pouillon',NULL,NULL,0,0,3,0,0.00,3),\n" +
            " (101,11,'Champagne Rosè Premier Cru','Roger Pouillon',NULL,NULL,0,0,2,0,0.00,4),\n" +
            " (102,11,'Les 7 Crus Brut Blanc de Blancs','Agrapart',NULL,NULL,0,0,2,0,0.00,5),\n" +
            " (103,11,'Cuvée Brut 739','Jacquesson',NULL,NULL,0,0,1,0,0.00,6),\n" +
            " (104,11,'Cuvée Brut 741','Jacquesson',NULL,NULL,0,0,1,0,0.00,7),\n" +
            " (105,11,'Blanc de Blancs','Ruinart',NULL,NULL,0,0,2,0,0.00,8),\n" +
            " (106,11,'Grand Vintage','Moet & Chandon',NULL,2009,0,0,2,0,0.00,9),\n" +
            " (107,11,'Dom Pèrignon Blanc','Dom Pèrignon',NULL,NULL,0,0,2,0,0.00,10),\n" +
            " (108,12,'Malvasia Laus','Martinez',NULL,NULL,0,0,3,0,0.00,1),\n" +
            " (109,12,'Passito di Pantelleria Jemara','Martinez',NULL,2010,0,0,0,0,0.00,2),\n" +
            " (110,12,'Passito di Pantelleria Jemara','Martinez',NULL,2013,0,0,3,0,0.00,3),\n" +
            " (111,12,'Recioto della Valpolicella','Manara',NULL,2012,0,0,1,0,0.00,4),\n" +
            " (112,12,'Vinsanto','Lavacchio',NULL,2009,0,0,1,0,0.00,5),\n" +
            " (113,12,'Vinsanto','Lavacchio',NULL,2010,0,0,7,0,0.00,6),\n" +
            " (114,12,'Pasitea Rosa','Girlan',NULL,2014,0,0,1,0,0.00,7),\n" +
            " (115,12,'Pasitea Rosa','Girlan',NULL,2015,0,0,2,0,0.00,8),\n" +
            " (116,12,'Sauternes','Chateau Bastor Lamontagne',NULL,2010,0,0,1,0,0.00,9),\n" +
            " (117,12,'Porto Old Tawny 10 years','Burmester',NULL,NULL,0,0,0,1,0.00,10),\n" +
            " (118,13,'Mosto d''Uva El Caliè','Borgo Maragliano',NULL,2015,0,0,2,0,0.00,1),\n" +
            " (119,13,'Moscato Spumante','Borgo Maragliano',NULL,2016,0,0,3,0,0.00,2);\n";

    public static final String DBDELETE_TBCATEGORIES = "DROP TABLE IF EXISTS tb_categories";

    public static final String DBDELETE_TBPRODUCTS = "DROP TABLE IF EXISTS tb_products";
}