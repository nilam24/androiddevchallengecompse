/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import android.util.Log
import android.widget.TextClock
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.shapes
import com.example.androiddevchallenge.ui.theme.typography

class MainActivity : AppCompatActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@ExperimentalMaterialApi
@Composable
fun MyApp() {

    Surface(color = MaterialTheme.colors.primary) {
        WeatherPageDesign()
    }
}

@ExperimentalMaterialApi
@Composable
private fun WeatherPageDesign() {
    val weatherViewModel = WeatherViewModel()
    weatherViewModel.getDataList()
    var weatherDataList: List<WeatherDataModel> = remember { mutableListOf() }
    weatherViewModel.liveWeatherData?.observeForever { data ->
        weatherDataList = data
    }

    Column(
        modifier = Modifier
            .padding(8.dp, 8.dp, 8.dp, 8.dp)
            .fillMaxWidth()

    ) {
        TextClock(LocalContext.current)
        Text(
            text = weatherDataList[0].location, modifier = Modifier
                .padding(16.dp, 24.dp, 16.dp, 0.dp)
                .fillMaxWidth(), style = TextStyle(
                color = colorResource(
                    id = R.color.white
                ),
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold
            )
        )

        Text(
            text = weatherDataList[2].date, modifier = Modifier
                .padding(8.dp, 8.dp, 8.dp, 0.dp)
                .fillMaxWidth(),
            color = colorResource(
                id = R.color.white
            ),
            textAlign = TextAlign.Center,
            style = typography.h1

        )
        Image(
            painter = painterResource(id = R.drawable.ic_clear),
            modifier = Modifier
                .padding(135.dp, 2.dp, 16.dp, 0.dp)
                .height(75.dp)
                .width(75.dp),
            contentDescription = "weather condition summer",
            contentScale = ContentScale.FillBounds,
            alignment = Alignment.Center

        )

        ShowCardViewData(weatherDataList)

    }
}

@ExperimentalMaterialApi
@Composable
private fun ShowCardViewData(weatherDataList: List<WeatherDataModel>) {
    val bottomSheetScaffold = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)

    )
    rememberCoroutineScope()
    Surface {

        BottomSheetScaffold(backgroundColor = colorResource(id = R.color.purple_500),
            sheetPeekHeight = 100.dp,
            scaffoldState = bottomSheetScaffold,
            sheetContent = {

                Box(
                    modifier = Modifier
                        .padding(0.dp)
                        .fillMaxHeight()

                ) {
                    Column(modifier = Modifier.padding(2.dp)) {


                        Text(
                            modifier = Modifier.padding(5.dp),
                            text = "Future Data",
                            style = typography.h1,
                            textAlign = TextAlign.Center,
                            color = colorResource(id = R.color.purple_500)
                        )

                        //recycler data lazyColumn?????
                        ShowDataInCardView(weatherDataList)
                    }

                }
            }) { data ->
            Log.e("scaffolded", "" + data)
            Box(modifier = Modifier.padding(8.dp)) {
                Canvas(modifier = Modifier
                    .width(100.dp)
                    .height(50.dp)
                    .padding(2.dp, 29.dp, 0.dp, 0.dp), onDraw = {
                    drawCircle(
                        color = Color.Yellow,
                        center = Offset(x = size.width, y = size.height),
                        radius = size.minDimension / 4
                    )
                })

                Image(
                    painter = painterResource(id = R.drawable.ic_home_illos),
                    modifier = Modifier.padding(24.dp,8.dp,0.dp,0.dp),
                    contentDescription = "weather graph",
                    contentScale = ContentScale.FillBounds,
                    alignment = Alignment.Center
                )
            }
            Text(text="Forecast",modifier=Modifier.padding(16.dp,24.dp,0.dp,0.dp),style= typography.body1)
            SetCardRowWeekWeatherList(data, weatherDataList)
        }
    }

}

@Composable
private fun SetCardRowWeekWeatherList(data: PaddingValues, weatherDataList: List<WeatherDataModel>) {
    LazyRow(modifier = Modifier.padding(8.dp),
        horizontalArrangement = Arrangement.Start,
        contentPadding = data,
        reverseLayout = false,
        state = LazyListState(),
        content = {
            items(items = weatherDataList) { data ->
                SetDataList(data)
            }

        })

}

@Composable
fun SetDataList(weatherData: WeatherDataModel) {
    Column(modifier = Modifier.padding(2.dp)) {

        Text(text = weatherData.date, style = typography.h2)
        Image(
            modifier = Modifier.padding(2.dp),
            painter = painterResource(id = weatherData.image),
            contentDescription = weatherData.contentDes,
            contentScale = ContentScale.FillBounds,
            alignment = Alignment.Center
        )
        Text(text = weatherData.minTemp, style = typography.body1)
        Text(text = weatherData.maxTemp, style = typography.body1)

    }
}

@Composable
private fun ShowDataInCardView(weatherDataList: List<WeatherDataModel>) {

    Card(modifier = Modifier.padding(2.dp), shape = RoundedCornerShape(corner = CornerSize(8.dp))) {
        SetDataWeatherInList(weatherDataList)
    }
}

@Composable
private fun SetDataWeatherInList(
    weatherDataModel: List<WeatherDataModel>
) {
    LazyColumn(modifier = Modifier,
        reverseLayout = false,
        state = LazyListState(),
        verticalArrangement = Arrangement.Top,
        content = {
            items(items = weatherDataModel) { data ->
                SetItems(data)
            }

        })


}

@Composable
private fun SetItems(dataModel: WeatherDataModel) {
    Card(modifier = Modifier.padding(2.dp), shape = shapes.medium) {
        Row(
            modifier = Modifier
                .padding(2.dp)
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = dataModel.image),
                modifier = Modifier
                    .padding(16.dp, 5.dp, 8.dp, 16.dp)
                    .height(80.dp)
                    .width(80.dp),
                contentScale = ContentScale.FillBounds,
                contentDescription = dataModel.contentDes,
                alignment = Alignment.TopCenter
            )

            Column(modifier = Modifier.padding(26.dp)) {
                Text(text = dataModel.date, style = typography.h1)
                Text(text = dataModel.minTemp, style = typography.h2)
                Text(text = dataModel.maxTemp, style = typography.h2)

            }

        }
    }
}

@ExperimentalMaterialApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@ExperimentalMaterialApi
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
