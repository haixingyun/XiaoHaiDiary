package com.joker.kit.core.ui.component.dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.joker.kit.core.database.entity.TaskEntity
import com.joker.kit.core.designsystem.component.SpaceVerticalXXLarge
import com.joker.kit.core.designsystem.theme.ColorDanger
import com.joker.kit.core.designsystem.theme.TextTertiaryLight
import com.joker.kit.core.ui.component.text.AppText
import com.joker.kit.core.ui.component.text.TextType

@Composable
fun ToDoDialog(
    task: TaskEntity,
    onDismiss: () -> Unit = {},
    onValueChange: (String) -> Unit,
    onComplete: () -> Unit = {},
    onCancel: () -> Unit = {},
    onDeleteClick: () -> Unit = {}
) {

    Dialog(
        onDismissRequest = onDismiss, properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        // Draw a rectangle shape with rounded corners inside the dialog
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
            ) {
                SpaceVerticalXXLarge()
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = task.isCompleted,
                        onCheckedChange = {},
                        colors = CheckboxDefaults.colors(
                            TextTertiaryLight
                        )
                    )

                    BasicTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = task.text,
                        onValueChange = onValueChange,
                        textStyle = MaterialTheme.typography.bodyLarge,
                        decorationBox = { innerTextField ->
                            if (task.text.isEmpty()) {
                                AppText(
                                    text = "请输入任务",
                                    type = TextType.TERTIARY,
                                )
                            }
                            innerTextField()
                        })

                }

                SpaceVerticalXXLarge()

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    TextButton(
                        onClick = onCancel,
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text("取消")
                    }
                    if (task.text.isNotEmpty()) {
                        TextButton(
                            onClick = onDeleteClick,
                            modifier = Modifier.padding(8.dp),
                        ) {
                            Text("删除", color = ColorDanger)
                        }
                    }
                    TextButton(
                        onClick = onComplete,
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text("完成")
                    }
                }
            }
        }
    }
}


@Composable
@Preview
fun ToDoDialogPreview() {
//    ToDoDialog()
}
