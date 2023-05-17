package com.awvgp.template.feature.helloname

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.awvgp.template.core.ui.theme.TemplateTheme

@Composable
internal fun HelloNameRoute(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HelloNameViewModel = hiltViewModel(),
) {
    val nameState: NameResult by viewModel.nameFlow.collectAsStateWithLifecycle()

    NameScreen(
        nameState = nameState,
        modifier = modifier,
        onBackClick = onBackClick
    )
}

@VisibleForTesting
@Composable
internal fun NameScreen(
    nameState: NameResult,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (nameState) {
            is NameResult.Loading -> {
                Text(stringResource(R.string.loading))
            }
            is NameResult.Loaded -> {
                Text(stringResource(R.string.hello_name, nameState.name))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TemplateTheme {
        NameScreen(NameResult.Loaded("Android")) {

        }
    }
}