package net.simplifiedcoding.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import net.simplifiedcoding.data.UserDataSource
import net.simplifiedcoding.data.repository.UserRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: UserRepository
) : ViewModel() {

    val userPager= Pager(PagingConfig(pageSize = 20)){
        UserDataSource(repo)
    }.flow.cachedIn(viewModelScope)
}