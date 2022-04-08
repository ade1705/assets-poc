package com.example.database

import org.ktorm.database.Database
import org.ktorm.dsl.insert

class DatabaseManager {
    private var database: Database? = null

    init {
        val jdbcUrl = "jdbc:mysql://remotemysql.com:3306/A3KT1qVwsc?user=A3KT1qVwsc&password=cnz53lCn7N&useSSL=false"
        database = Database.connect(jdbcUrl);
    }

    fun insert(userId: String, filePath: String) {
        database?.insert(DBFileTable) {
            set(DBFileTable.file_path, filePath)
            set(DBFileTable.user_id, userId)
            set(DBFileTable.create_timestamp, 7348734)
        }
    }
}