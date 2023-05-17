package com.awvgp.template.feature.helloname

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.awvgp.template.feature.helloname.navigation.HelloNameArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HelloNameViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val nameArgs: HelloNameArgs = HelloNameArgs(savedStateHandle)

    private val _nameFlow: MutableStateFlow<NameResult> = nameResultFlow()

    val nameFlow: StateFlow<NameResult> = _nameFlow

    private fun nameResultFlow(): MutableStateFlow<NameResult> {
        viewModelScope.launch {
            //Simulating loading with a faked delay
            delay(2000)
            _nameFlow.emit(NameResult.Loaded(nameArgs.name))
        }

        return MutableStateFlow(NameResult.Loading)
    }
}

sealed class NameResult {
    object Loading : NameResult()
    data class Loaded(val name: String) : NameResult()
}


