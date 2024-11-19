package com.colab.myfriend.di

import android.content.Context
import com.colab.myfriend.adapter.FriendDao
import com.colab.myfriend.database.MyDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideMyDatabase(@ApplicationContext context: Context): MyDatabase {
        return MyDatabase.getInstance(context)
    }

    @Provides
    fun provideFriendDao(myDatabase: MyDatabase): FriendDao {
        return myDatabase.friendDao()
    }
}
