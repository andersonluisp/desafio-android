package com.picpay.desafio.android.data.repository

import androidx.room.withTransaction
import com.picpay.desafio.android.data.model.UserDatabase
import com.picpay.desafio.android.data.network.PicPayService
import com.picpay.desafio.android.util.networkBoundResource

class Repository(
    private val api: PicPayService,
    private val db: UserDatabase
) {
    private val userDao = db.userDao()

    fun getUsers() = networkBoundResource(
        query = {
            userDao.getAllUsers()
        },
        fetch = {
            api.getUsers()
        },
        saveFetchResult = { users ->
            db.withTransaction {
                userDao.deleteAllUsers()
                userDao.insertUsers(users)
            }
        }
    )
}
