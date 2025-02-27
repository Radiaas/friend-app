package com.colab.myfriend.viewmodel

import androidx.lifecycle.ViewModel
import com.colab.myfriend.adapter.FriendDao
import com.colab.myfriend.database.Friend

// ViewModel untuk mengelola data teman dengan menggunakan FriendDao
class FriendViewModel(private val friendDao: FriendDao) : ViewModel() {

    fun getFriend() = friendDao.getAll()

    fun getFriendById(id: Int) = friendDao.getItemById(id)

    // Fungsi ini bersifat suspend dan harus dipanggil dari dalam coroutine
    suspend fun insertFriend(data: Friend) {
        friendDao.insert(data)
    }

    // Fungsi ini bersifat suspend dan harus dipanggil dari dalam coroutine
    suspend fun editFriend(data: Friend) {
        friendDao.update(data)
    }

    // Fungsi ini bersifat suspend dan harus dipanggil dari dalam coroutine
    suspend fun deleteFriend(data: Friend) {
        friendDao.delete(data)
    }
}
