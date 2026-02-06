package com.joker.kit.feature.main.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.joker.kit.core.database.entity.TaskEntity
import com.joker.kit.core.designsystem.theme.TextTertiaryLight


@Composable
fun ToDoItem(
    task: TaskEntity,
    onCheckChange: (Boolean) -> Unit,
    onClick: (TaskEntity) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick(task)
            }
    ) {
        Row(
            modifier = Modifier.padding(vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = task.isCompleted,
                onCheckedChange = onCheckChange,
                colors = CheckboxDefaults.colors(
                    checkedColor = if (task.isCompleted) {
                        TextTertiaryLight
                    } else {
                        Color.Unspecified
                    }
                )
            )
            Text(
                text = task.text,
                color = if (task.isCompleted) TextTertiaryLight else Color.Unspecified,
                style = MaterialTheme.typography.titleLarge,
                textDecoration = if (task.isCompleted) {
                    TextDecoration.LineThrough
                } else {
                    null
                }
            )
        }
    }
}