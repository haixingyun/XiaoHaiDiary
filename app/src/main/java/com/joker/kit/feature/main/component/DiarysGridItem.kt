package com.joker.kit.feature.main.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.joker.kit.core.designsystem.component.SpaceVerticalXSmall
import com.joker.kit.core.designsystem.theme.TextQuaternaryLight
import com.joker.kit.core.designsystem.theme.TextTertiaryLight
import com.joker.kit.core.model.entity.Diary

@Composable
fun DiaryGridItem(
    diary: Diary,
    onClick: (Long) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick(diary.id)
            }
    ) {
        Column {
            if (diary.pics.isNotEmpty()) {
                Image(
                    painter = rememberAsyncImagePainter(diary.pics.first()),
                    contentDescription = "第一张图片",
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
            }
            SpaceVerticalXSmall()
            Text(
                text = diary.title,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(horizontal = 4.dp)
            )
            SpaceVerticalXSmall()
            Text(
                text = diary.content,
                style = MaterialTheme.typography.bodySmall,
                color = TextTertiaryLight,
                maxLines = 4,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(horizontal = 4.dp)
            )
            SpaceVerticalXSmall()
            Text(
                text = diary.time,
                color = TextQuaternaryLight,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(horizontal = 4.dp)
            )
            SpaceVerticalXSmall()
        }
    }
}

@Composable
@Preview
fun DiaryGridItemPreview() {
}
