package com.development.core.domain.usecases

import com.development.core.domain.managers.EmailManager
import javax.inject.Inject

class SendEmailUseCase @Inject constructor(
    private val emailManager: EmailManager
) {
    operator fun invoke(email: String) {
        emailManager.sendEmailTo(email)
    }
}
