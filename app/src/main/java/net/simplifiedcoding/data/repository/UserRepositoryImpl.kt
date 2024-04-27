package net.simplifiedcoding.data.repository

import kotlinx.coroutines.delay
import net.simplifiedcoding.data.network.UsersApi
import net.simplifiedcoding.data.network.UsersResponse

class UserRepositoryImpl(
    private val api: UsersApi
) : UserRepository {
var error=0
    override suspend fun getUsers(page: Int, limit: Int): UsersResponse {
        delay(3000L)
        error++
        if(error==4){
            throw IndexOutOfBoundsException()
        }
        return api.getUsers(page, limit)
    }
}