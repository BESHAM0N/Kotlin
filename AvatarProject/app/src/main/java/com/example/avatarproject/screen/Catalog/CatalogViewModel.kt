package com.example.avatarproject.screen.Catalog

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CatalogViewModel : ViewModel() {

    private val _items = MutableStateFlow(
        listOf("Поставить задачу", "Проверить задачи")
    )

    val items: StateFlow<List<String>> = _items

    fun addItem(item: String){
        _items.value = _items.value + item
    }

    fun removeItem(index: Int){
        if(index in _items.value.indices){
            _items.value = _items.value.toMutableList().also {it.removeAt(index)}
        }
    }
}