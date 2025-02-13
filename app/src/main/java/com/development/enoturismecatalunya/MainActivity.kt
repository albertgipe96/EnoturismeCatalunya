package com.development.enoturismecatalunya

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.development.core.designsystem.components.scaffold.EnoturismeCatalunyaScaffold
import com.development.core.designsystem.components.scaffold.rememberScaffoldState
import com.development.core.designsystem.theme.EnoturismeCatalunyaTheme
import com.development.enoturismecatalunya.navigation.NavigationWrapper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EnoturismeCatalunyaTheme {
                EnoturismeCatalunyaScaffold(
                    scaffoldState = rememberScaffoldState(),
                    modifier = Modifier.fillMaxSize()
                ) { scaffoldState ->
                    NavigationWrapper(scaffoldState = scaffoldState)
                }
            }
        }
    }
}
