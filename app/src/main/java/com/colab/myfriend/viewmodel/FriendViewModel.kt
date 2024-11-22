package com.colab.myfriend.viewmodel

import androidx.lifecycle.ViewModel
import com.colab.myfriend.FriendRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.colab.myfriend.adapter.FriendDao
import com.colab.myfriend.database.Friend

// Annotate the ViewModel with @HiltViewModel
@HiltViewModel
class FriendViewModel @Inject constructor(
    private val friendDao: FriendDao,
    private val repository: FriendRepository
) : ViewModel() {

    fun getFriend() = friendDao.getAll()

    fun getFriendById(id: Int) = friendDao.getItemById(id)

    // This function is suspend and must be called from a coroutine
    suspend fun insertFriend(data: Friend) {
        friendDao.insert(data)
    }

    // This function is suspend and must be called from a coroutine
    suspend fun editFriend(data: Friend) {
        friendDao.update(data)
    }

    // This function is suspend and must be called from a coroutine
    suspend fun deleteFriend(data: Friend) {
        friendDao.delete(data)
    }

    suspend fun searchFriend(keyword: String): List<Friend> {
        return repository.searchFriend(keyword)
    }
}
