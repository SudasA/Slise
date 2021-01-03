package by.app.slise.viewmodel

sealed class SearchState
object Loading : SearchState()
object Ready : SearchState()