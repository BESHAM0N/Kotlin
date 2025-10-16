package com.example.avatarproject.screen.Profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {

    private val _userName = MutableStateFlow("Джураева Анастасия")
    val userName: StateFlow<String> = _userName

    private val _clickCount = MutableStateFlow(0)
    val clickCount: StateFlow<Int> = _clickCount

    fun onCardClicked() {
        viewModelScope.launch {
            _clickCount.value++
        }
    }

    fun resetClicks() {
        _clickCount.value = 0
    }
}