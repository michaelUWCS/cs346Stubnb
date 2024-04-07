package com.example.myapplication.messaging

import com.example.myapplication.models.ChatMessage
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import org.junit.Test

open class FirebaseDatabaseWrapper {
    open fun getAllMessages(userId: String): DatabaseReference {
        return FirebaseDatabase.getInstance().getReference("messages/$userId")
    }

    open fun sendMessage(message: ChatMessage, userId: String): Task<Void> {
        return FirebaseDatabase.getInstance().getReference("messages/$userId").push().setValue(message)
    }
}

class MessagingRepository(private val firebaseDatabaseWrapper: FirebaseDatabaseWrapper) {
    fun getAllMessages(userId: String): DatabaseReference {
        return firebaseDatabaseWrapper.getAllMessages(userId)
    }

    fun sendMessage(message: ChatMessage, userId: String): Task<Void> {
        return firebaseDatabaseWrapper.sendMessage(message, userId)
    }
}

class MessagingTests {
    private val mockFirebaseDatabaseWrapper = mockk<FirebaseDatabaseWrapper>()
    private val messagingRepository = MessagingRepository(mockFirebaseDatabaseWrapper)

    @Test
    fun testSendMessage() {
        val message = ChatMessage(2023, 100, 10, 30, 45, "user1", "user2", "Hello")
        val userId = "user1"
        val mockedTask = mockk<Task<Void>>()
        every { mockFirebaseDatabaseWrapper.sendMessage(message, userId) } returns mockedTask

        val result = messagingRepository.sendMessage(message, userId)

        assertEquals(mockedTask, result)
    }

    @Test
    fun testGetAllMessages() {
        val userId = "user1"
        val mockedDatabaseReference = mockk<DatabaseReference>()
        every { mockFirebaseDatabaseWrapper.getAllMessages(userId) } returns mockedDatabaseReference

        val result = messagingRepository.getAllMessages(userId)

        assertEquals(mockedDatabaseReference, result)
    }
}