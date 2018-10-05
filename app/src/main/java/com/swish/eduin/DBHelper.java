package com.swish.eduin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    ModuleClass moduleclass;

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "SchoolDB";

    private static final String TABLE_NAME = "schoolapp";

    private static final String SL_NO = "slno";

    private static final String NAME = "name";

    private static final String LOCATION = "location";

    private static final String AREA = "area";

    private static final String TYPE = "type";

    private static final String CATEGORY = "category";

    private static final String SYLLABUS = "syllabus";

    private static final String PH_NO = "phno";

    private static final String CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + "("
            + SL_NO + " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " TEXT," + LOCATION + " TEXT," + AREA + " TEXT," + TYPE + " TEXT,"
            + CATEGORY + " TEXT," + SYLLABUS + " TEXT," + PH_NO + " TEXT" + ")";

    private static final String DROP_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private static final String SELECT_QUERY = "SELECT * FROM " + TABLE_NAME;

    private static String[] columns = {SL_NO, NAME, LOCATION, AREA, TYPE, CATEGORY, SYLLABUS, PH_NO};

    ModuleClass moduleClass = new ModuleClass();

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        addDetails(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(CREATE_QUERY);
        onCreate(db);
    }

    public void addDetails(SQLiteDatabase database) {
//        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put(NAME, "AQUA SWIMMING ACADEMY");
        value.put(LOCATION, "C/O The Quorum hotel,Vinoba road,Mysore,opp to DC office-570005");
        value.put(AREA, "Vinoba road");
        value.put(TYPE, "Institute");
        value.put(CATEGORY, "Sports");
        value.put(PH_NO, "9738460417");
        database.insert(TABLE_NAME, null, value);


        ContentValues value1 = new ContentValues();
        value1.put(NAME, "ART PLANET");
        value1.put(LOCATION, "#31, above Kanva mart near Akshay Bhandar,Kuvempu Nagar Mysore-570023");
        value1.put(AREA, "Kuvempu Nagar");
        value1.put(TYPE, "Institute");
        value1.put(CATEGORY, "Drawing,Painting,Music,Dancing");
        value1.put(PH_NO, "08722799997");
        database.insert(TABLE_NAME, null, value1);


        ContentValues value2 = new ContentValues();
        value2.put(NAME, "Bollywood Studio");
        value2.put(LOCATION, "Vanivilas double road,Lakshmipuram,Mysore-570004");
        value2.put(AREA, "Lakshmipuram");
        value2.put(TYPE, "Institue");
        value2.put(CATEGORY, "Dancing,Music");
        value2.put(PH_NO, "08212331668");
        database.insert(TABLE_NAME, null, value2);


        ContentValues value3 = new ContentValues();
        value3.put(NAME, "Champaka Academy");
        value3.put(LOCATION, "1609,Vishwamanava double road,Across,3rd main,DVC layout,Ramakrishna nagara Mysore-570022");
        value3.put(AREA, "Ramakrishna nagara");
        value3.put(TYPE, "Institute");
        value3.put(CATEGORY, "Music,Dancing,Drawing,Acting");
        value3.put(PH_NO, "08212340305");
        database.insert(TABLE_NAME, null, value3);


        ContentValues value4 = new ContentValues();
        value4.put(NAME, "GSS School of music and technology");
        value4.put(LOCATION, "#1104,Udayaravi road,Kuvempu nagar,Mysore-570023");
        value4.put(AREA, "Kuvempu Nagar");
        value4.put(TYPE, "Institute");
        value4.put(CATEGORY, "Music");
        value4.put(PH_NO, "08197236500");
        database.insert(TABLE_NAME, null, value4);


        ContentValues value5 = new ContentValues();
        value5.put(NAME, "T.I.M.E");
        value5.put(LOCATION, "5487,1st floor,above SBM bank,Vijayanagar watertank circle,2nd stage,Mysore-570016");
        value5.put(AREA, "Vijayanagar");
        value5.put(TYPE, "Institute");
        value5.put(CATEGORY, "Tutorials,Abacus");
        value5.put(PH_NO, "08123572551");
        database.insert(TABLE_NAME, null, value5);


        ContentValues value6 = new ContentValues();
        value6.put(NAME, "SIP Abacus Academy");
        value6.put(LOCATION, "#56,1 floor,30th main,BSK 3rd stage,opp to KIMS,Bengaluru,Karnataka-560085");
        value6.put(AREA, "Banashankari");
        value6.put(TYPE, "Institute");
        value6.put(CATEGORY, "Abacus,Tutorials");
        value6.put(PH_NO, "9167895570");
        database.insert(TABLE_NAME, null, value6);


        ContentValues value7 = new ContentValues();
        value7.put(NAME, "Curiocity-School of creative art and design");
        value7.put(LOCATION, "#209,Tank road,7th cross,Narasimha mohala,Mysore-570007");
        value7.put(AREA, "Narasimha mohala");
        value7.put(TYPE, "Institute");
        value7.put(CATEGORY, "Music,Dancing,Drawing,Acting,Drama");
        value7.put(PH_NO, "91352789767");
        database.insert(TABLE_NAME, null, value7);


        ContentValues value8 = new ContentValues();
        value8.put(NAME, "All Stars Basketball Academy");
        value8.put(LOCATION, "JP Nagar,Mysore-570008");
        value8.put(AREA, "JP Nagar");
        value8.put(TYPE, "Institute");
        value8.put(CATEGORY, "Sports");
        value8.put(PH_NO, "9611662111");
        database.insert(TABLE_NAME, null, value8);


        ContentValues value9 = new ContentValues();
        value9.put(NAME, "Kalaspandana");
        value9.put(LOCATION, "Mahila Samaja,JLB Road,Lakshmipuram,Mysore-570004");
        value9.put(AREA, "Lakshmipuram");
        value9.put(TYPE, "Institute");
        value9.put(CATEGORY, "Music,Dancing,Acting");
        value9.put(PH_NO, "9152574920");
        database.insert(TABLE_NAME, null, value9);


        ContentValues values = new ContentValues();
        values.put(NAME, "MALAD CAMPUS");
        values.put(LOCATION, "Marve Road, opp HDFC Bank, behind Garden Court Restaurant, Malad(W), Mumbai-400064");
        values.put(AREA, "Marve Road");
        values.put(TYPE, "School");
        values.put(CATEGORY, "nursery, primary, high school");
        values.put(SYLLABUS, "icse, cbse, state");
        values.put(PH_NO, "7777016450");
        database.insert(TABLE_NAME, null, values);

        ContentValues values1 = new ContentValues();
        values1.put(NAME, "BORIVALLI CAMPUS");
        values1.put(LOCATION, "Plot no 3/3A R.S.C-5,opp Sridarshan Society,Haridas nagar,Borivali west,Mumbai-400092");
        values1.put(AREA, "Haridas nagar");
        values1.put(TYPE, "school");
        values1.put(CATEGORY, "nursery, primary, high school");
        values1.put(SYLLABUS, "icse,cbse");
        values1.put(PH_NO, "8454015666");
        database.insert(TABLE_NAME, null, values1);

        ContentValues values2 = new ContentValues();
        values2.put(NAME, "ORCHIDS THE INTERNATIONAL SCHOOL");
        values2.put(LOCATION, "C.V.O.D Jain patashaala,SVP road,#84,Samuel street,Mumbai-400009");
        values2.put(AREA, "Samuel Street");
        values2.put(TYPE, "school");
        values2.put(CATEGORY, "nursery, primary");
        values2.put(SYLLABUS, "icse, state");
        values2.put(PH_NO, "022-65017104");
        database.insert(TABLE_NAME, null, values2);

        ContentValues values3 = new ContentValues();
        values3.put(NAME, "DSB INTERNATIONAL SCHOOL");
        values3.put(LOCATION, "76,Warden road,Breach candy,Kumballa hill,Mumbai-400026");
        values3.put(AREA, "Kumballa hill");
        values3.put(TYPE, "school");
        values3.put(CATEGORY, "nursery, primary, high school");
        values3.put(SYLLABUS, "cbse");
        values3.put(PH_NO, "022-23620110");
        database.insert(TABLE_NAME, null, values3);

        ContentValues values4 = new ContentValues();
        values4.put(NAME, "BOMBAY SCOTTISH SCHOOL");
        values4.put(LOCATION, "Raheja vihar,Chandivali farmhouse,Powai,Mumbai-400072");
        values4.put(AREA, "Powai");
        values4.put(TYPE, "school");
        values4.put(CATEGORY, "primary, high school");
        values4.put(SYLLABUS, "icse, cbse, state");
        values4.put(PH_NO, "022-28573205");
        database.insert(TABLE_NAME, null, values4);

        ContentValues values5 = new ContentValues();
        values5.put(NAME, "BACHPAN PLAY SCHOOL");
        values5.put(LOCATION, "#74,L-12,7/2 cross road,Saint mary’s road,N.R. mohalla,Mysore-570007");
        values5.put(AREA, "N.R Mohalla");
        values5.put(TYPE, "school");
        values5.put(CATEGORY, "nursery, primary");
        values5.put(SYLLABUS, "icse, cbse, state");
        values5.put(PH_NO, "08214244805");
        database.insert(TABLE_NAME, null, values5);

        ContentValues values6 = new ContentValues();
        values6.put(NAME, "KANGAROO KIDS CLUB(Preschool and Day-care)");
        values6.put(LOCATION, "#1054,new Kantaraj Urs road,T.K layout 4 th stage,Mysore-570022");
        values6.put(AREA, "T.K Layout");
        values6.put(TYPE, "school");
        values6.put(CATEGORY, "nursery");
        values6.put(SYLLABUS, "state");
        values6.put(PH_NO, "09108656644");
        database.insert(TABLE_NAME, null, values6);

        ContentValues values7 = new ContentValues();
        values7.put(NAME, "KIDS CAMPUS");
        values7.put(LOCATION, "813,Contour road,Gokulam 2 nd stage,Gokulam,Mysore-570002");
        values7.put(AREA, "Gokulam");
        values7.put(TYPE, "school");
        values7.put(CATEGORY, "nursery, primary");
        values7.put(SYLLABUS, "icse, cbse");
        values7.put(PH_NO, "09900923479");
        database.insert(TABLE_NAME, null, values7);

        ContentValues values8 = new ContentValues();
        values8.put(NAME, "TOM and JERRY PLAY HOME");
        values8.put(LOCATION, "#MIG 37,HUDCO,BMT road,Gangotri layout,Mysore-570009");
        values8.put(AREA, "BMT road");
        values8.put(TYPE, "school");
        values8.put(CATEGORY, "nursery");
        values8.put(SYLLABUS, "icse, state");
        values8.put(PH_NO, "08212342134");
        database.insert(TABLE_NAME, null, values8);

        ContentValues values9 = new ContentValues();
        values9.put(NAME, "KIDDIE LAND");
        values9.put(LOCATION, "#36, behind chinmaya vidyalaya, 4th main road, Jayalakshmipuram, Mysore-570012");
        values9.put(AREA, "Jayalakshmipuram");
        values9.put(TYPE, "school");
        values9.put(CATEGORY, "nursery");
        values9.put(SYLLABUS, "state");
        values9.put(PH_NO, "23118976");
        database.insert(TABLE_NAME, null, values9);


    }

    public ArrayList<ModuleClass> retriveData(String type) {
        SQLiteDatabase database = this.getWritableDatabase();
        ArrayList<ModuleClass> arrayList = new ArrayList<>();
//        Cursor cursor = database.rawQuery("SELECT  * FROM " + TABLE_NAME + " WHERE type = "+type, null);
        Cursor cursor = database.query(TABLE_NAME, columns, "type=?", new String[]{type}, null, null, null);

        if (cursor.moveToFirst())
        //adding a contact to list
        {
            for (int i = 0; i < cursor.getCount(); i++) {
                ModuleClass moduleclass = new ModuleClass();//import line of code
                moduleclass.Slno = Integer.parseInt(cursor.getString(0));
                moduleclass.name = (cursor.getString(1));
                moduleclass.location = (cursor.getString(2));
                moduleclass.area = (cursor.getString(3));
                moduleclass.type = (cursor.getString(4));
                moduleclass.category = (cursor.getString(5));
                moduleclass.syllabus = (cursor.getString(6));
                moduleclass.phno = (cursor.getString(7));

                arrayList.add(moduleclass);
                cursor.moveToNext();
            }
        }
        cursor.close();
        database.close();
        return arrayList;
    }

    public ArrayList<ModuleClass> retriveData(String Location, String Syallabus, String Category) {
        SQLiteDatabase database = this.getWritableDatabase();
        ArrayList<ModuleClass> arrayList = new ArrayList<>();
        Cursor cursor = database.rawQuery("select * from " + TABLE_NAME + " where Location = " + Location + ",where Syallabus= " + Syallabus + ",where Category=" + Category, null);
        if (cursor.moveToFirst())
        //adding a contact to list
        {
            for (int i = 0; i < cursor.getCount(); i++) {
                ModuleClass moduleclass = new ModuleClass();//import line of code
                moduleclass.Slno = Integer.parseInt(cursor.getString(0));
                moduleclass.name = (cursor.getString(1));
                moduleclass.location = (cursor.getString(2));
                moduleclass.area = (cursor.getString(3));
                moduleclass.type = (cursor.getString(4));
                moduleclass.category = (cursor.getString(5));
                moduleclass.syllabus = (cursor.getString(6));
                moduleclass.phno = (cursor.getString(7));

                arrayList.add(moduleclass);
                cursor.moveToNext();
            }
        }
        cursor.close();
        database.close();
        return arrayList;
    }
}
