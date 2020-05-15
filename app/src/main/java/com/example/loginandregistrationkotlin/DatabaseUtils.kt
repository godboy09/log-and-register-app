package com.example.loginandregistrationkotlin

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.lang.Exception

class DatabaseUtils(context: Context): SQLiteOpenHelper(context, dbname, factory, version) {

    override fun onCreate(pO: SQLiteDatabase?) {

        try {
            pO?.execSQL(AppConstants.DATA_BASE_EXEC_COMMAND)
        } catch (error: Exception) {
            error.printStackTrace()
        }
    }

    override fun onUpgrade(pO: SQLiteDatabase?, p1: Int, p2: Int) {
    }


    fun isUserPresentInDatabase(email: String, password: String): Boolean {
        val db = writableDatabase
        val query = "select * from user where email = $email and password = $password"
        val cursor = db.rawQuery(query, null)
        if (cursor.count <= 0 ) {
            cursor.close()
            return false
        }
        cursor.close();
        return true;
    }

    fun insertUserInfo(name: String, email: String, password: String) {
        val db: SQLiteDatabase = writableDatabase
        val values: ContentValues = ContentValues()
        values.put(AppConstants.NAME, name)
        values.put(AppConstants.EMAIL, email)
        values.put(AppConstants.PASSWORD, password)

        db.insert(AppConstants.USER, null, values)
        db.close()
    }


    companion object {
        internal val dbname = AppConstants.USER_DATABASE_NAME
        internal val factory = null
        internal val version = 1
    }

}