package com.development.dos.presentation.internal.mappers

import com.development.dos.domain.model.Do
import com.development.dos.presentation.internal.model.DoListItem

internal class DoUiMapper {
    fun Do.toDoListItem(): DoListItem {
        return DoListItem(
            id = id, name = name, logoUrl = logoUrl
        )
    }
}
