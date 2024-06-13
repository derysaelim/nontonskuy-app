//package com.widyawacana.nontonskuy.viewmodel
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.widyawacana.nontonskuy.data.Reminder
//import com.widyawacana.nontonskuy.data.Repository.ReminderRepository
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//
//class ReminderViewModel(private val repository: ReminderRepository) : ViewModel() {
//    private val _reminders = MutableStateFlow<List<Reminder>>(emptyList())
//    val reminders: StateFlow<List<Reminder>> = _reminders
//
//    init {
//        loadReminders()
//    }
//
//    private fun loadReminders() {
//        viewModelScope.launch {
//            _reminders.value = repository.getAllReminders()
//        }
//    }
//
//    fun addReminder(reminder: Reminder) {
//        viewModelScope.launch {
//            repository.insert(reminder)
//            loadReminders()
//        }
//    }
//}
//
