package com.example.database

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object DBFileTable: Table<FileEntity>("file") {
    val id = int("id").primaryKey().bindTo { it.id }
    val user_id = varchar("user_id").bindTo { it.user_id }
    val file_path = varchar("file_path").bindTo { it.file_path }
    val create_timestamp = int("create_timestamp").bindTo { it.create_timestamp }
}

interface FileEntity : Entity<FileEntity> {
    companion object : Entity.Factory<FileEntity>()

    val id: Int
    val user_id: String
    val file_path: String
    val create_timestamp: Int
}