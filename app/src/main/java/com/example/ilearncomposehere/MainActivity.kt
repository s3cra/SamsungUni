package com.example.ilearncomposehere

import android.os.Bundle
import android.provider.CalendarContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ilearncomposehere.ui.theme.Orange
import com.example.ilearncomposehere.ui.theme.buttonTextColor
import com.example.ilearncomposehere.ui.theme.primaryColor
import com.example.ilearncomposehere.ui.theme.secondaryColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WaterTracker()
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
//Задание 3
@Composable
@Preview(showSystemUi = true,
    device = "spec:width=400dp,height=200dp")
fun JetpackComposeIsPreview1(){
    val text = stringResource(R.string.task3)
    Text(text,
        Modifier.fillMaxWidth().systemBarsPadding(),
        Color.Green,
        fontSize = 16.sp,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center)
}
@Composable
@Preview(showSystemUi = true,
    device = "spec:width=400dp,height=200dp")
fun JetpackComposeIsPreview2(){
    val text = stringResource(R.string.task3)
    Text(text,
        Modifier.fillMaxWidth().systemBarsPadding(),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis)
}
@Composable
@Preview(showSystemUi = true,
    device = "spec:width=400dp,height=200dp")
fun JetpackComposeIsPreview3(){
    val text = stringResource(R.string.task3)
    Text(text,
        Modifier.fillMaxWidth().systemBarsPadding().background(Color.Green),
        fontSize = 24.sp,
        textDecoration = TextDecoration.Underline,
        style = TextStyle(
            textIndent = TextIndent(48.sp)
        )
        )
}
//Задание 4
@Composable
@Preview(showSystemUi = true,
    device = "spec:width=400dp,height=200dp")
fun ClickMeButton(){
    Button(
        modifier = Modifier.fillMaxWidth().systemBarsPadding(),
        shape = RoundedCornerShape(16.dp),
        onClick = {},
        border = BorderStroke(2.dp, Color.Gray),
        colors = ButtonColors(
            containerColor = Color.LightGray,
            contentColor = Color.Black,
            disabledContainerColor = Color.LightGray,
            disabledContentColor = Color.Black
        )
    ){
        Text(
            text = "Нажми на меня",
        )
    }
}
//Задание 5
@Composable
@Preview(showSystemUi = true,
    device = "spec:width=400dp,height=200dp")
fun Task5Preview(){
    Column(Modifier.fillMaxWidth()
        .systemBarsPadding()
        .background(Color.Gray)
        .height(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Column(Modifier.padding(0.dp, 16.dp)
            .fillMaxHeight()
            .aspectRatio(1f)
            .background(Orange, CircleShape),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center){

            Text(
                text = "АБ"
            )
        }
    }
}
//Задание 6
@Composable
@Preview
fun TopRightCornerCircle(){
    Column(Modifier.systemBarsPadding()
        .background(Color.Black)
        .width(240.dp)
        .height(120.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.End) {

        Image(
            imageVector = ImageVector.vectorResource(R.drawable.circle),
            contentDescription = ""
        )
    }
}
@Composable
@Preview
fun CenterScaledCircle(){
    Column(Modifier.systemBarsPadding()
        .background(Color.Blue)
        .width(240.dp)
        .height(120.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Image(
            imageVector = ImageVector.vectorResource(R.drawable.circle),
            contentDescription = "",
            colorFilter = ColorFilter.tint(Color.Magenta),
            modifier = Modifier.padding(10.dp)
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
    }
}
//Задание 7
@Composable
@Preview(showSystemUi = true)
fun Humans1(){
    val person = Person("Евгений", "Андреевич", "Лукашин",
        "+7 495 495 95 95", "г.Москва, 3-я улица Строителей, д.25, кв.12")

    Text(text = person.toString(),
        modifier = Modifier.systemBarsPadding())
}

@Composable
@Preview(showSystemUi = true)
fun Humans2(){
    val persons = listOf(Person("Евгений", "Андреевич", "Лукашин",
        "+7 495 495 95 95", "г.Москва, 3-я улица Строителей, д.25, кв.12"),
        Person("Василий", "Егорович", "Кузякин",
            "---", "Ивановская область, дер.Крутово, д.4"),
        Person("Людмила", "Прокофьевна", "Калугина",
            "+7 495 788 78 78", "Москва, Большая Никитская, д.43, кв.290"))

    Column(Modifier.systemBarsPadding().padding(10.dp,0.dp)) {
        for (person in persons){
            Column(modifier = Modifier.fillMaxWidth()
                .padding(0.dp,10.dp)
                .background(Color.Gray)
                .padding(10.dp)) {
                Text(text = person.toString(),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth())
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun Humans3(){
    val persons = listOf(Person("Евгений", "Андреевич", "Лукашин",
        "+7 495 495 95 95", "г.Москва, 3-я улица Строителей, д.25, кв.12"),
        Person("Василий", "Егорович", "Кузякин",
            "---", "Ивановская область, дер.Крутово, д.4"),
        Person("Людмила", "Прокофьевна", "Калугина",
            "+7 495 788 78 78", "Москва, Большая Никитская, д.43, кв.290"))

    Column(Modifier.systemBarsPadding().padding(10.dp,0.dp)) {
        for (person in persons){
            Row(modifier = Modifier.fillMaxWidth()
                .padding(0.dp,10.dp)
                .background(Color.Gray)
                .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {
                Text(text = person.toString(),
                    textAlign = TextAlign.Center)
                Image(Icons.Filled.Person,
                    "")
            }
        }
    }
}
//Задание 8
@Composable
fun WaterTracker() {
    var waterCount by rememberSaveable { mutableIntStateOf(0) }
    var daysCount by rememberSaveable { mutableIntStateOf(0) }
    val daysCountWord = remember { derivedStateOf {
        when{
            daysCount % 100 == 11 -> "дней"
            daysCount % 10 == 1 -> "день"
            daysCount % 10 == 2 -> "дня"
            daysCount % 10 == 3 -> "дня"
            daysCount % 10 == 4 -> "дня"
            else -> "дней"
        }
    } }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text(
            text = "Трекер воды",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = primaryColor
        )
        Spacer(modifier = Modifier.height(48.dp))
        Text(
            text = "$waterCount мл",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = secondaryColor
        )
        Spacer(modifier = Modifier.height(48.dp))
        Text(
            text = "Трекер дней",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = primaryColor
        )
        Spacer(modifier = Modifier.height(48.dp))
        Text(
            text = "$daysCount ${daysCountWord.value}",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = secondaryColor
        )
        Spacer(modifier = Modifier.height(48.dp))
        Button(
            colors = ButtonColors(
                contentColor = buttonTextColor,
                containerColor = primaryColor,
                disabledContainerColor = primaryColor,
                disabledContentColor = buttonTextColor
            ),
            onClick = { waterCount += 250 }
        ) {
            Text(
                text = "+250 мл",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = buttonTextColor
            )
        }
        Spacer(modifier = Modifier.height(48.dp))
        Button(
            colors = ButtonColors(
                contentColor = buttonTextColor,
                containerColor = primaryColor,
                disabledContainerColor = primaryColor,
                disabledContentColor = buttonTextColor
            ),
            onClick = {
                when(waterCount >= 1500){
                    true -> {
                        daysCount++
                    }
                    else -> {
                        daysCount = 0
                    }
                }
                waterCount = 0
            }
        ) {
            Text(
                text = "Завершить день",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = buttonTextColor
            )
        }
    }
}
