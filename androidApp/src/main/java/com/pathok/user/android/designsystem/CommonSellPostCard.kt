
package com.pathok.user.android.designsystem

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pathok.user.android.PathokTheme
import com.pathok.user.android.R

data class SellPostData(
    val uploaderName: String,
    val bookTitle: String,
    val authorName: String,
    val genre: String,
    val condition: String,
    val price: String,
    val distance: String,
    val bookCoverResId: Int
)

@Composable
fun CommonSellPostCard(
    modifier: Modifier = Modifier,
    postData: SellPostData,
    showBuyButton: Boolean = true,
    onBuyButtonClick: () -> Unit = {}
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Uploaded by ${postData.uploaderName}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    InfoRow(icon = Icons.Default.AccountCircle, text = postData.bookTitle)
                    InfoRow(icon = Icons.Default.Edit, text = postData.authorName)
                    InfoRow(icon = Icons.Default.AccountCircle, text = postData.genre)
                    InfoRow(icon = Icons.Default.AccountCircle, text = postData.condition)
                    InfoRow(icon = Icons.Default.AccountCircle, text = postData.price)
                }
                Spacer(modifier = Modifier.width(16.dp))
                Image(
                    painter = painterResource(id = postData.bookCoverResId),
                    contentDescription = "Book Cover",
                    modifier = Modifier.size(width = 80.dp, height = 120.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (showBuyButton) {
                    PrimaryActionButton(
                        text = "Click to Buy",
                        onClick = onBuyButtonClick,
                        modifier = Modifier.weight(1f)
                    )
                } else {
                    Spacer(modifier = Modifier.weight(1f))
                }
                Text(
                    text = postData.distance,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}

@Composable
private fun InfoRow(icon: ImageVector, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CommonSellPostCardPreview() {
    val sampleData = SellPostData(
        uploaderName = "Md. Hasan Manhmud",
        bookTitle = "ইছামতি",
        authorName = "বিভূতিভূষণ বন্দ্যোপাধ্যায়",
        genre = "উপন্যাস",
        condition = "ব্যবহারযোগ্য",
        price = "১২০ ৳",
        distance = "8 km away",
        bookCoverResId = R.raw.img
    )
    PathokTheme {
        CommonSellPostCard(
            postData = sampleData,
            showBuyButton = true
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CommonSellPostCardNoButtonPreview() {
    val sampleData = SellPostData(
        uploaderName = "Md. Hasan Manhmud",
        bookTitle = "ইছামতি",
        authorName = "বিভূতিভূষণ বন্দ্যোপাধ্যায়",
        genre = "উপন্যাস",
        condition = "ব্যবহারযোগ্য",
        price = "১২০ ৳",
        distance = "8 km away",
        bookCoverResId = R.raw.img
    )
    PathokTheme {
        CommonSellPostCard(
            postData = sampleData,
            showBuyButton = false
        )
    }
}
