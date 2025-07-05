package com.example.apireq.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage

@Composable
fun CustomCard(
    modifier: Modifier = Modifier,
    title: String = "--",
    type: String = "--",
    description: String = "--",
    cardImg: String = "--",
){
    Card (
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
//            .border(1.dp, Color.GRAY, RoundedCornerShape(8.dp))
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 16.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        )
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "$title($type)",
                modifier = Modifier
                    .padding(bottom = 8.dp),
                textAlign = TextAlign.Justify,
                maxLines = 1,
                softWrap = true,
                color = androidx.compose.ui.graphics.Color.Black,
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            AsyncImage(
                model = cardImg,
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(),
                alignment = Alignment.Center
            )
//            Image(
//                painter = painterResource(cardImg),
//                contentDescription = null,
//                modifier = Modifier
//                    .padding(bottom = 8.dp)
//                    .clip(
//                        RoundedCornerShape(8.dp)
//                    ),
//            )
            Text(
                text = description,
                modifier = Modifier.padding(bottom = 8.dp),
                textAlign = TextAlign.Justify,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            )
        }
    }
}

@Preview
@Composable
fun CustomCardPreview(){
    CustomCard()
}