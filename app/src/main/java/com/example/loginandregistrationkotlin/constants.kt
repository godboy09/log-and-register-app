package com.example.loginandregistrationkotlin

object AppConstants {
    const val DATA_BASE_EXEC_COMMAND = "create table user(id integer primary key autoincrement, " + "name varchar(3), email varchar(100), password varchar(20)"
    const val NAME = "name"
    const val EMAIL = "email"
    const val PASSWORD = "password"
    const val USER = "user"
    const val USER_DATABASE_NAME = "user_info_db"
}