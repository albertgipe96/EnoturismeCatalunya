package com.development.core.data.managers

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.net.Uri
import com.development.core.domain.managers.PhoneDialManager
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AndroidPhoneDialManager @Inject constructor(
    @ApplicationContext private val context: Context
) : PhoneDialManager {
    override fun openDial(phone: String) {
        val dialIntent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phone")
            flags = FLAG_ACTIVITY_NEW_TASK
        }
        context.startActivity(dialIntent)
    }
}
