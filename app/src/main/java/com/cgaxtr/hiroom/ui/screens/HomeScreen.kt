package com.cgaxtr.hiroom.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cgaxtr.hiroom.R


@Preview
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(0.dp, 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Featured cities", fontSize = 20.sp, )
        Spacer(modifier = Modifier.height(16.dp))
        FeaturesCities()
        //LatestSearch()
        SearchBar()
    }
}

@Composable
fun FeaturesCities() {

    val cities = listOf(City.Madrid, City.Barcelona, City.Valencia, City.Sevilla)

    LazyVerticalGrid(
        contentPadding = PaddingValues(8.dp),
        columns = GridCells.Fixed(2)
        ) {
        items(cities.size) {
            Card(
                modifier = Modifier
                    .height(150.dp)
                    .padding(4.dp),
            ) {

                Box(modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,) {
                    Image(
                        painterResource(id = cities[it].image),
                        contentDescription = "",
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = cities[it].name,
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(24.dp),
                        color = Color.White,
                    )
                }
            }
        }
    }
}

@Composable
fun SearchBar() {
    TextField(
        value = "Search",
        onValueChange = { /*onTextChanged(it)*/ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(50),
        singleLine = true,
        maxLines = 1,
        placeholder = {
            Text(
                text = "Search",
                color = Color.Black
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent

        ),
    )

    Button(onClick = { /*TODO*/ }) {
        Text(text = "Search")
    }
}

//Debug purpose
sealed class City(
    @DrawableRes
    val image: Int,
    val name: String,
) {
    object Madrid : City(
        image = R.drawable.madrid,
        name = "Madrid",
    )

    object Barcelona : City(
        image = R.drawable.barcelona,
        name = "Barcelona",
    )

    object Valencia : City(
        image = R.drawable.valencia,
        name = "Valencia",
    )

    object Sevilla : City(
        image = R.drawable.sevilla,
        name = "Sevilla",
    )
}