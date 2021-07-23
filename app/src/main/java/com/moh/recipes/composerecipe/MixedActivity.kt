package com.moh.recipes.composerecipe

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.moh.recipes.composerecipe.databinding.ActivityMixedBinding
import com.moh.recipes.composerecipe.databinding.CustomLayoutBinding
import com.moh.recipes.composerecipe.theme.SampleTheme

class MixedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMixedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupComposeView(binding.composeView)
    }

    @SuppressLint("SetTextI18n")
    private fun setupComposeView(composeView: ComposeView) {
        composeView.setContent {
            SampleTheme {
                Content()
            }
        }
    }

    @Preview
    @Composable
    private fun Content() {
        Surface {
            Column {
                Text("From Compose", style = MaterialTheme.typography.h3)
                var counter by rememberSaveable {
                    mutableStateOf(0)
                }
                CounterButton(counter) { counter++ }

                AndroidViewBinding(CustomLayoutBinding::inflate) {
                    this.inputField.setText("Android view reporting: $counter")
                }
            }
        }
    }

    @Composable
    private fun CounterButton(counter: Int, onCounterUpdate: () -> Unit) {
        Button(onClick = onCounterUpdate) {
            Text("Clicked $counter times")
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MixedActivity::class.java)
        }
    }
}