package com.example.compose_ui

import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.WithDensity
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.Image
import androidx.ui.graphics.imageFromResource
import androidx.ui.graphics.vector.DrawVector
import androidx.ui.layout.*
import androidx.ui.material.AppBarIcon
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import androidx.ui.material.surface.Surface
import androidx.ui.material.themeTextStyle
import androidx.ui.res.imageResource
import androidx.ui.res.vectorResource
import androidx.ui.text.TextStyle
import androidx.ui.tooling.preview.Preview

class ComposeActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme{
                FlexColumn {
                    inflexible {
                        TopAppBar(title = {
                            Text(text = "Compose Ui")
                        }, navigationIcon = {
                            AppBarIcon(icon = +imageResource(R.drawable.ic_back), onClick = {
                                onBackPressed()
                            })
                        })
                    }
                    flexible(flex = 1f){
                        RecipeList(defaultRecipes)
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun Greeting() {
    Column {
        Text("Hello, World!", style = TextStyle(color = Color.Red))
        Text("Hello, Second World!", style = TextStyle(color = Color.Red))
        Text("Hello, Third World!", style = TextStyle(color = Color.Red))
    }
}

@Composable
fun RecipeList(recipes: List<Recipe>) {
    VerticalScroller {
        Column {
            for (recipe in recipes) {
                Padding(16.dp) {
                    RecipeCard(recipe)
                }
            }
        }
    }
}

@Composable
fun RecipeCard(recipe: Recipe) {
    Surface(shape = RoundedCornerShape(8.dp), elevation = 8.dp) {
        val image = +imageResource(recipe.imageResource)
        Column {
            Container(expanded = true, height = 144.dp) {
                DrawImage(image = image)
            }
            Column(modifier = Spacing(16.dp)) {
                Text(recipe.title, style = +themeTextStyle { h4 })
                for (ingredient in recipe.ingredients) {
                    Text("• $ingredient")
                }
            }
        }
    }
}

@Composable
@Preview
fun DefaultRecipeCard() {
    MaterialTheme {
        RecipeCard(defaultRecipes[0])
    }
}

