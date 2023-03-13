package com.cgaxtr.hiroom.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cgaxtr.hiroom.R

@Composable
fun AdCard() {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .fillMaxWidth(),
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Carrousel(
                Modifier
                    .weight(2f)
                    .fillMaxWidth()
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
            ) {
                Title()
                Price()
            }
        }
    }
}

@Composable
fun Carrousel(modifier: Modifier) {
    Image(
        modifier = modifier.fillMaxWidth(),
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "",
        contentScale = ContentScale.Crop
    )
}


@Composable
fun Title() {
    Text(
        modifier = Modifier.padding(8.dp),
        text = "Titulo 1",
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    )
}

@Composable
fun Price() {
    Text(text = "")
}

@Preview
@Composable
fun PreviewAdCard() {
    AdCard()
}