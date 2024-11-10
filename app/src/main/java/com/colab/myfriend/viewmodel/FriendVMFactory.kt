package com.colab.myfriend.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.colab.myfriend.database.MyDatabase

class FriendVMFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FriendViewModel(MyDatabase.getInstance(context).friendDao()) as T
    }
}