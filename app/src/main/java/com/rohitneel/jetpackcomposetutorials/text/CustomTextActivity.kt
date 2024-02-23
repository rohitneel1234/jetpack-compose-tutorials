package com.rohitneel.jetpackcomposetutorials.text

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class CustomTextActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier.verticalScroll(scrollState)
            ) {
                SimpleText()

                TextWithColor()

                TextWithBiggerFontSize()

                BoldText()

                ItalicText()

                TextWithCustomFontFamily()

                TextWithUnderline()

                TextWithStrikeThrough()

                JustifyTextAlign()

                ModifiedTextIntent()

                ModifiedLineHeightText()

                CustomAnnotatedText()

                Divider(color = Color.Gray)

                TextWithBackground()
            }
        }
    }

    @Composable
    private fun SimpleText() {
        CustomStyledText(
            "This is the default text style"
        )
    }

    @Composable
    private fun TextWithColor() {
        CustomStyledText(
            "This text is blue in color",
            style = TextStyle(
                color = Color.Blue
            )
        )
    }

    @Composable
    private fun TextWithBiggerFontSize() {
        CustomStyledText(
            "This text has a bigger font size",
            style = TextStyle(
                fontSize = 30.sp
            )
        )
    }

    @Composable
    private fun BoldText() {
        CustomStyledText(
            "This text is bold",
            style = TextStyle(
                fontWeight = FontWeight.W700
            )
        )
    }

    @Composable
    private fun ItalicText() {
        CustomStyledText(
            "This text is italic",
            style = TextStyle(
                fontStyle = FontStyle.Italic
            )
        )
    }

    @Composable
    private fun TextWithCustomFontFamily() {
        CustomStyledText(
            "This text is using a custom font family",
            style = TextStyle(
                fontFamily = FontFamily.Cursive
            )
        )
    }

    @Composable
    private fun TextWithUnderline() {
        CustomStyledText(
            "This text has an underline",
            style = TextStyle(
                textDecoration = TextDecoration.Underline
            )
        )
    }

    @Composable
    private fun TextWithStrikeThrough() {
        CustomStyledText(
            "This text has a strikethrough line",
            style = TextStyle(
                textDecoration = TextDecoration.LineThrough
            )
        )
    }

    @Composable
    private fun CenterTextAlign() {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "This text is center aligned",
                style = TextStyle(
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.padding(16.dp)
            )
        }
    }

    @Composable
    private fun JustifyTextAlign() {
        CustomStyledText(
            "This text will demonstrate how to justify " +
                    "your paragraph to ensure that the text that ends with a soft " +
                    "line break spreads and takes the entire width of the container",
            style = TextStyle(
                textAlign = TextAlign.Justify
            )
        )
    }

    @Composable
    private fun ModifiedTextIntent() {
        CustomStyledText(
            "This text will demonstrate how to add " +
                    "indentation to your text. In this example, indentation was only " +
                    "added to the first line. You also have the option to add " +
                    "indentation to the rest of the lines if you'd like",
            style = TextStyle(
                textAlign = TextAlign.Justify,
                textIndent = TextIndent(firstLine = 30.sp)
            )
        )
    }

    @Composable
    private fun ModifiedLineHeightText() {
        CustomStyledText(
            "The line height of this text has been " +
                    "increased hence you will be able to see more space between each " +
                    "line in this paragraph.",
            style = TextStyle(
                textAlign = TextAlign.Justify,
                lineHeight = 20.sp
            )
        )
    }

    @Composable
    private fun CustomAnnotatedText() {
        val annotatedString = buildAnnotatedString {
            append("This string has style spans")
            addStyle(style = SpanStyle(color = Color.Red), start = 0, end = 4)
            addStyle(style = SpanStyle(color = Color.Green), start = 5, end = 21)
            addStyle(style = SpanStyle(color = Color.Blue), start = 22, end = 27)
        }
        Text(annotatedString, modifier = Modifier.padding(16.dp))
    }

    @Composable
    private fun TextWithBackground() {
        Surface(color = Color.Yellow) {
            Text(
                text = "This text has a background color",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun CustomStyledText(displayText: String, style: TextStyle? = null, maxLines: Int? = null) {
    Text(
        text = displayText,
        modifier = Modifier.padding(16.dp),
        style = style ?: TextStyle.Default,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines ?: Int.MAX_VALUE
    )
    Divider(color = Color.Gray)
}

@Preview
@Composable
fun CustomStyledTextPreview() {
    CustomStyledText(
        "This is preview text",
        maxLines = 2,
        style = TextStyle(
            color = Color.Red,
            fontWeight = FontWeight.W900,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.Serif,
            fontSize = 20.sp,
            textAlign = TextAlign.Justify
        )
    )
}