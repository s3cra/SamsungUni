package com.example.ilearncomposehere

import android.health.connect.datatypes.Device
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Devices.AUTOMOTIVE_1024p
import androidx.compose.ui.tooling.preview.Devices.TABLET
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.UiMode
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ilearncomposehere.ui.theme.IlearncomposehereTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Hello("Павел")
        }
    }
}


//Задание 1
@Composable
fun Hello(name: String? = null){
    Text(if (name != null) "Привет, $name"  else "Имя не задано",
        modifier = Modifier.fillMaxWidth().safeContentPadding(),
        fontSize = 20.sp,
        textAlign = TextAlign.Center)
}
//Задание 2
@Composable
@Preview(device = "spec:width=200dp,height=200dp,isRound=true",
    name = "round")
fun HelloPreview1(){
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.clip(CircleShape).background(Color.Yellow).fillMaxSize()){
        Hello("Павел")
    }
}
@Composable
@Preview(device = "spec:width=200dp,height=400dp,dpi=240,orientation=landscape",
    showSystemUi = true,
    name = "landscape")
fun HelloPreview2(){
    Hello("Павел")
}
@Composable
@Preview(device = "spec:width=200dp,height=400dp,dpi=420,orientation=portrait",
    showSystemUi = true,
    name = "portrait")
fun HelloPreview3(){
    Hello("Павел")
}