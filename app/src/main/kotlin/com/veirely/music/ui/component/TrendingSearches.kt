/**
 * Veirely Project (C) 2026
 * Licensed under GPL-3.0 | See git history for contributors
 */

package com.veirely.music.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.veirely.innertube.YouTube
import com.veirely.innertube.pages.ChartsPage
import com.veirely.music.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private var cachedTrendingTitles: List<String>? = null

/** Trending queries taken from the YouTube Music charts (real data, cached per process). */
@Composable
fun TrendingSearches(
    onSearch: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    var titles by remember { mutableStateOf(cachedTrendingTitles.orEmpty()) }
    LaunchedEffect(Unit) {
        if (cachedTrendingTitles != null) return@LaunchedEffect
        val loaded =
            withContext(Dispatchers.IO) {
                YouTube
                    .getChartsPage()
                    .getOrNull()
                    ?.sections
                    ?.let { sections ->
                        (sections.firstOrNull { it.chartType == ChartsPage.ChartType.TRENDING } ?: sections.firstOrNull())
                            ?.items
                            ?.map { it.title }
                            ?.distinct()
                            ?.take(10)
                    }.orEmpty()
            }
        if (loaded.isNotEmpty()) {
            cachedTrendingTitles = loaded
            titles = loaded
        }
    }
    if (titles.isEmpty()) return

    Column(modifier.fillMaxWidth().padding(top = 8.dp, bottom = 4.dp)) {
        Text(
            text = stringResource(R.string.trending_searches),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = 12.dp),
            horizontalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(8.dp),
        ) {
            items(titles, key = { it }) { title ->
                AssistChip(
                    onClick = { onSearch(title) },
                    label = {
                        Text(title, maxLines = 1, overflow = TextOverflow.Ellipsis, modifier = Modifier.padding(vertical = 2.dp))
                    },
                    shape = RoundedCornerShape(50),
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
                        labelColor = MaterialTheme.colorScheme.onSurface,
                    ),
                    border = null,
                )
            }
        }
    }
}
