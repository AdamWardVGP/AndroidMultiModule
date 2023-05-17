package com.awvgp.template.feature.nameinput

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.awvgp.template.core.ui.theme.TemplateTheme

@Composable
internal fun NameInputRoute(
    navigateToHelloName: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    NameInputScreen(
        navigateToHelloName = navigateToHelloName,
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@VisibleForTesting
@Composable
internal fun NameInputScreen(
    navigateToHelloName: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var text by remember {
        mutableStateOf("")
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                navigateToHelloName.invoke(text)
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "To Hello Name")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TemplateTheme {
        NameInputScreen({
            //No-Op
        })
    }
}