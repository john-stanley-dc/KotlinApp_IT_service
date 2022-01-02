package com.example.it_service_app

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast


class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,FACTORY, DATABASE_VERSION) {
    private var name1: String = "Windows installation"
    private var desc1: String = "404"

    private var name2: String = "Cleaning PC"
    private var desc2: String = "404"

    private var name3: String = "Installing software"
    private var desc3: String = "404"

    private var name4: String = "Installing antivirus"
    private var desc4: String = "404"

    private var name5: String = "Installing drivers"
    private var desc5: String = "404"

    private var name6: String = "PC components"
    private var desc6: String = "404"

    private var name7: String = "Buying a PC"
    private var desc7: String = "404"

    private var name8: String = "PC repair"
    private var desc8: String = "404"

    private var name9: String = "Overclocking"
    private var desc9: String = "404"
    companion object{
        var DATABASE_VERSION=1
        var DATABASE_NAME="IT_DB"
        var TABLE_USERS="user"
        var TABLE_CART = "cart"
        var TABLE_SHARE = "share"
        var KEY_ID="id"
        var KEY_NAME="name"
        var KEY_SURNAME="surname"
        var KEY_MAIL="mail"
        var KEY_PASSWORD="password"
        var DESCRIPTION = "description"
        var FACTORY = null
    }


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table "+ TABLE_USERS+"("+ KEY_ID+" integer primary key autoincrement,"
                + KEY_NAME+ " text,"+ KEY_SURNAME + " text,"+ KEY_MAIL+" text,"+  KEY_PASSWORD+ " text"+")")
        db?.execSQL(
            "create table " + TABLE_CART + "(" + KEY_ID + " integer primary key autoincrement,"
                    + KEY_NAME + " text," + DESCRIPTION + " text" + ")")
        db?.execSQL(
            "create table " + TABLE_SHARE + "(" + KEY_ID + " integer primary key autoincrement," + KEY_NAME + " text,"
                    + KEY_NAME + " text," + DESCRIPTION + " text" + ")")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists "+ TABLE_USERS)
        onCreate(db)
    }

    fun insertUserData(name:String, surname: String, mail:String, password:String):Long{
        val db:SQLiteDatabase=writableDatabase
        val values: ContentValues= ContentValues()
        values.put("name",name)
        values.put("surname",surname)
        values.put("mail",mail)
        values.put("password",password)
        val success= db.insert("user",null, values)
        db.close()
        return success

    }

    fun userIsInDB(login_mail: String,login_password: String):Boolean{
        val db: SQLiteDatabase=writableDatabase

//        val values1 = ContentValues().apply {
//            put(KEY_NAME, name1)
//            put(DESCRIPTION, desc1)
//        }
//        val newRowId1 = db?.insert(TABLE_CART, null, values1)
//
//        val values2 = ContentValues().apply {
//            put(KEY_NAME, name2)
//            put(DESCRIPTION, desc2)
//        }
//        val newRowId2 = db?.insert(TABLE_CART, null, values2)
//
//        val values3 = ContentValues().apply {
//            put(KEY_NAME, name3)
//            put(DESCRIPTION, desc3)
//        }
//        val newRowId3 = db?.insert(TABLE_CART, null, values3)
//
//        val values4 = ContentValues().apply {
//            put(KEY_NAME, name4)
//            put(DESCRIPTION, desc4)
//        }
//        val newRowId4 = db?.insert(TABLE_CART, null, values4)
//
//        val values5 = ContentValues().apply {
//            put(KEY_NAME, name5)
//            put(DESCRIPTION, desc5)
//        }
//        val newRowId5 = db?.insert(TABLE_CART, null, values5)
//
//        val values6 = ContentValues().apply {
//            put(KEY_NAME, name6)
//            put(DESCRIPTION, desc6)
//        }
//        val newRowId6 = db?.insert(TABLE_CART, null, values6)
//
//        val values7 = ContentValues().apply {
//            put(KEY_NAME, name7)
//            put(DESCRIPTION, desc7)
//        }
//        val newRowId7 = db?.insert(TABLE_CART, null, values7)
//
//        val values8 = ContentValues().apply {
//            put(KEY_NAME, name8)
//            put(DESCRIPTION, desc8)
//        }
//        val newRowId8 = db?.insert(TABLE_CART, null, values8)
//
//        val values9 = ContentValues().apply {
//            put(KEY_NAME, name9)
//            put(DESCRIPTION, desc9)
//        }
//        val newRowId9 = db?.insert(TABLE_CART, null, values9)

        Log.d("INFO", login_mail + login_password)
        val query="SELECT * FROM user where mail='$login_mail' and password='$login_password'"
        val cursor=db.rawQuery(query ,null)
        if (cursor.count>0){
            Log.d("INFO count", cursor.count.toString())
            if(cursor.moveToFirst())
                println(cursor.getString(1))
            return false
        }
        else {
            Log.d("INFO", cursor.count.toString())
            return true
        }
        cursor.close()
    }

    fun getData(login_mail: String,login_password: String): ArrayList<String>{
        val usrlist: ArrayList<String> = ArrayList()
        val db:SQLiteDatabase=writableDatabase
        val query="SELECT * FROM user where mail='$login_mail' and password='$login_password'"
        val cursor=db.rawQuery(query ,null)
        if(cursor.moveToFirst()){
            val name = cursor.getString(1)
            val surname = cursor.getString(2)
            val email = cursor.getString(3)
            usrlist.add(name)
            usrlist.add(surname)
            usrlist.add(email)
        }
        return usrlist
    }




}