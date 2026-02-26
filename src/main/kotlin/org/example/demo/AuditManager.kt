package org.example.demo

import java.nio.file.Paths
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

interface IFileSystem {
    fun getFiles(directory: String): List<String>

    fun readAllLines(file: String): MutableList<String>

    fun writeAllText(file: String, content: String)
}

data class AuditManager(
    val maxEntries: Int,
    val directory: String,
    val fileSystem: IFileSystem
) {
    fun addRecord(name: String, timeOfVisit: LocalDateTime) {
        val files = fileSystem.getFiles(directory).sorted()
        val datetimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val newRecord = "$name;${timeOfVisit.format(datetimeFormatter)}"

        if (files.isEmpty()) {
            val newFile = Paths.get(directory, "audit_1.txt").toString()
            fileSystem.writeAllText(newFile, newRecord)
            return
        }

        val currentFileIndex = files.size - 1
        val currentFilePath = files[currentFileIndex]
        val lines = fileSystem.readAllLines(currentFilePath)

        if (lines.size < maxEntries) {
            lines += newRecord
            val newContent = lines.joinToString(System.lineSeparator())
            fileSystem.writeAllText(currentFilePath, newContent)
            return
        }

        val newName = "audit_${currentFileIndex + 2}.txt"
        val newFile = Paths.get(directory, newName).toString()
        fileSystem.writeAllText(newFile, newRecord)
    }
}
