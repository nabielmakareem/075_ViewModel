package com.example.activity4

import Data.DataForm
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CobaViewModel : ViewModel() {
    var namaUsr: String by mutableStateOf( "") //revised
        private set
    var noTlp: String by mutableStateOf( "")
        private set
    var alamat: String by mutableStateOf( "")
        private set
    var jenisKl: String by mutableStateOf("")
        private set
    private val _uistate = MutableStateFlow(DataForm())
    val uiState: StateFlow<DataForm> =_uistate.asStateFlow()

    fun insertData(nm: String, tlp: String, almt: String, jk: String){
        namaUsr = nm;
        noTlp = tlp;
        alamat = almt;
        jenisKl = jk;
    }

    fun setJenisK(pilihJK: String) {
        _uistate.update { currentState -> currentState.copy(sex = pilihJK) }
    }
}