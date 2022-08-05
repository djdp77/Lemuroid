package com.swordfish.lemuroid.common.flow

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun LifecycleOwner.launchOnState(state: Lifecycle.State, block: suspend () -> Unit) {
    lifecycleScope.launch {
        repeatOnLifecycle(state) {
            block()
        }
    }
}

fun LifecycleOwner.launchOnState(
    context: CoroutineContext = EmptyCoroutineContext, state: Lifecycle.State, block: suspend () -> Unit) {
    lifecycleScope.launch(context) {
        repeatOnLifecycle(state) {
            block()
        }
    }
}
