package org.example.demo

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import java.time.LocalDateTime
import kotlin.test.Test

class AuditManagerTest {
    @Test
    fun `add new visitor`() {
        val fileSystem = mockk<IFileSystem>()

        every { fileSystem.getFiles("audits") } returns listOf(
            "audits/audit_2.txt",
            "audits/audit_1.txt"
        )

        every { fileSystem.readAllLines("audits/audit_2.txt") } returns mutableListOf(
            "Peter;2023-01-01 16:00:00",
            "John;2023-01-01 16:00:00",
            "Mary;2023-01-01 16:00:00",
        )

        every { fileSystem.writeAllText(any(), any()) } returns Unit

        val auditManager = AuditManager(3, "audits", fileSystem)

        auditManager.addRecord("Alice", LocalDateTime.parse("2023-01-01T16:00:00"))

        verify { fileSystem.writeAllText("audits/audit_3.txt", "Alice;2023-01-01 16:00:00") }
    }

    @Test
    fun `add new visitor to empty file`() {
        val fileSystem = mockk<IFileSystem>()

        every { fileSystem.getFiles("audits") } returns emptyList()

        every { fileSystem.writeAllText(any(), any()) } returns Unit

        val auditManager = AuditManager(3, "audits", fileSystem)

        auditManager.addRecord("Alice", LocalDateTime.parse("2023-01-01T16:00:00"))

        verify { fileSystem.writeAllText("audits/audit_1.txt", "Alice;2023-01-01 16:00:00") }
    }

    @Test
    fun `add new visitor to existing file`() {
        val fileSystem = mockk<IFileSystem>()

        every { fileSystem.getFiles("audits") } returns listOf(
            "audits/audit_1.txt",
        )

        every { fileSystem.readAllLines("audits/audit_1.txt") } returns mutableListOf(
            "John;2023-01-01 16:00:00",
            "Mary;2023-01-01 16:00:00"
        )

        every { fileSystem.writeAllText(any(), any()) } returns Unit

        val auditManager = AuditManager(3, "audits", fileSystem)

        auditManager.addRecord("Alice", LocalDateTime.parse("2023-01-01T16:00:00"))

        verify { fileSystem.writeAllText("audits/audit_1.txt", "John;2023-01-01 16:00:00\nMary;2023-01-01 16:00:00\nAlice;2023-01-01 16:00:00") }
    }
}
