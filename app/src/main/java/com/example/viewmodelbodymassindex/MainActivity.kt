package com.example.viewmodelbodymassindex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.viewmodelbodymassindex.ui.theme.ViewModelBodyMassIndexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewModelBodyMassIndexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp(myViewModel: BMIViewModel = viewModel()) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(16.dp)) {
        OutlinedTextFieldTemplate(
            value = myViewModel.heightInput,
            onChange = { myViewModel.changeHeight(it) },
            label = stringResource(R.string.heightLabel)
        )
        OutlinedTextFieldTemplate(
            value = myViewModel.weightInput,
            onChange = { myViewModel.changeWeight(it) },
            label = stringResource(R.string.weightLabel)
        )
//        OutlinedTextField(
//            value = "",
//            onValueChange = {},
//            label = { Text(text = stringResource(R.string.weightLabel)) },
//            singleLine = true,
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
//        )
//        OutlinedTextField(
//            value = "",
//            onValueChange = {},
//            label = { Text(text = stringResource(R.string.heightLabel)) },
//            singleLine = true,
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
//        )
        Text(text = stringResource(R.string.result, myViewModel.result))
    }
}

@Composable
fun OutlinedTextFieldTemplate(value: String, onChange: (String) -> Unit, label: String) {
    OutlinedTextField(
        value = value,
        onValueChange = onChange,
        label = { Text(text = label) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ViewModelBodyMassIndexTheme {
        MyApp()
    }
}