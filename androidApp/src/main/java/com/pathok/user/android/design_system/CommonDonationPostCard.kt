package com.pathok.user.android.design_system

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.pathok.user.android.R

data class DonationPostData(
    val uploaderName: String,
    val bookTitle: String,
    val authorName: String,
    val genre: String,
    val condition: String,
    val price: String,
    val distanceInKm: String,
    val bookCoverUrl: String
)

@SuppressLint("ResourceType")
@Composable
fun CommonDonationPostCard(
    modifier: Modifier = Modifier,
    postData: DonationPostData,
    showAcceptDonationButton: Boolean = true,
    onClicked: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .clickable {
                onClicked.invoke()
            }
            .fillMaxWidth(),
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
                    InfoRow(
                        icon = ImageVector.vectorResource(id = R.drawable.ic_book_title),
                        text = postData.bookTitle
                    )
                    InfoRow(
                        icon = ImageVector.vectorResource(id = R.drawable.ic_writer),
                        text = postData.authorName
                    )
                    InfoRow(
                        icon = ImageVector.vectorResource(id = R.drawable.ic_book_type),
                        text = postData.genre
                    )
                    InfoRow(
                        icon = ImageVector.vectorResource(id = R.drawable.ic_book_condition),
                        text = postData.condition
                    )
                    InfoRow(
                        icon = ImageVector.vectorResource(id = R.drawable.ic_price),
                        text = postData.price
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                AsyncImage(
                    model = postData.bookCoverUrl,
                    contentDescription = "Book Cover",
                    modifier = Modifier.size(width = 80.dp, height = 120.dp),
                    placeholder = painterResource(id = R.raw.sample_book_cover),
                    error = painterResource(id = R.raw.sample_book_cover)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (showAcceptDonationButton) {
                    PrimaryActionButton(
                        text = "Click to Buy",
                        onClick = onClicked,
                        modifier = Modifier.weight(1f)
                    )
                } else {
                    Spacer(modifier = Modifier.weight(1f))
                }
                if (showAcceptDonationButton) {
                    Text(
                        text = postData.distanceInKm,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
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
fun CommonDonationPostCardPreview() {
    val sampleData = DonationPostData(
        uploaderName = "Md. Hasan Manhmud",
        bookTitle = "ইছামতি",
        authorName = "বিভূতিভূষণ বন্দ্যোপাধ্যায়",
        genre = "উপন্যাস",
        condition = "ব্যবহারযোগ্য",
        price = "১২০ ৳",
        distanceInKm = "8 km away",
        bookCoverUrl = ""
    )
    PathokTheme {
        CommonDonationPostCard(
            postData = sampleData,
            showAcceptDonationButton = true
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CommonDonationPostCardNoButtonPreview() {
    val sampleData = DonationPostData(
        uploaderName = "Md. Hasan Manhmud",
        bookTitle = "ইছামতি",
        authorName = "বিভূতিভূষণ বন্দ্যোপাধ্যায়",
        genre = "উপন্যাস",
        condition = "ব্যবহারযোগ্য",
        price = "১২০ ৳",
        distanceInKm = "8 km away",
        bookCoverUrl = ""
    )
    PathokTheme {
        CommonDonationPostCard(
            postData = sampleData,
            showAcceptDonationButton = false
        )
    }
}
