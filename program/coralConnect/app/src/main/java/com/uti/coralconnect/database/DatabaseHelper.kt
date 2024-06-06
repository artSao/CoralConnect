////package com.uti.coralconnect.database
//
//import android.content.Context
//import android.database.sqlite.SQLiteDatabase
//import android.database.sqlite.SQLiteOpenHelper
//import com.uti.coralconnect.database.model.TaskListModel
//
//class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME,null, DB_VERSION){
//
//    companion object{
//        private val DB_NAME = "like"
//        private val DB_VERSION = 1
//        private val TABLE_NAME = "tasklist"
//        private val ID = "id"
//        private val TASK_NAME = "taskname"
//        private val TASK_DETAILS = "taskdetails"
//
//    }
//
//    override fun onCreate(db: SQLiteDatabase?) {
//        val CREATE_TABLE = "CREATE TABLE $TABLE_NAME ($ID INTEGER PRIMARY KEY,$TASK_NAME,$TASK_DETAILS)"
//        db?.execSQL(CREATE_TABLE)
//    }
//
//    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
//        val DROP_TABLE = "DROP TABLE IF EXIST $TABLE_NAME"
//        db?.execSQL(DROP_TABLE)
//        onCreate(db)
//    }
//
//    fun getAllTaskList(): List<TaskListModel>{
//        val tasklist = ArrayList<TaskListModel>()
//        val db:SQLiteDatabase! = writableDatabase
//        val selectQuery = "SELECT * FROM $TABLE_NAME"
//        val cursor = db.rawQuery(selectQuery,null)
//        if(cursor != null){
//            if (cursor.moveToFirst()){
//                /* TODO Not Implement yet */
//            }
//        }
//    }
//}