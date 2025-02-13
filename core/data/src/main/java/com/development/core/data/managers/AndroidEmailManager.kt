package com.development.core.data.managers

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.net.Uri
import com.development.core.domain.managers.EmailManager
import com.development.core.domain.managers.PhoneDialManager
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AndroidEmailManager @Inject constructor(
    @ApplicationContext private val context: Context
) : EmailManager {
    override fun sendEmailTo(email: String) {
        val emailIntent = Intent().apply {
            action = Intent.ACTION_SENDTO
            setDataAndType(Uri.parse("mailto:"), "text/plain")
            putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
            flags = FLAG_ACTIVITY_NEW_TASK
        }
        context.startActivity(Intent.createChooser(emailIntent, "Enviar email:").apply {
            flags = FLAG_ACTIVITY_NEW_TASK
        })
    }
}
