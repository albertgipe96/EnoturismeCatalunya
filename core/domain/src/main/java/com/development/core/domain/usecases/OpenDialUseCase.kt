package com.development.core.domain.usecases

import com.development.core.domain.managers.PhoneDialManager
import javax.inject.Inject

class OpenDialUseCase @Inject constructor(
    private val phoneDialManager: PhoneDialManager
) {
    operator fun invoke(phone: String) {
        phoneDialManager.openDial(phone)
    }
}
