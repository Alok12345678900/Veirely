/**
 * Veirely Project (C) 2026
 * Licensed under GPL-3.0 | See git history for contributors
 */

package com.veirely.music.ui.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.veirely.music.R
import com.veirely.music.ui.theme.AppColorTheme
import com.veirely.music.ui.theme.ThemePalette

/**
 * Color theme chooser with a live preview per option. Selecting an item is applied
 * immediately app-wide because the preference is observed by the root theme.
 */
@Composable
fun ColorThemePicker(
    selected: AppColorTheme,
    onSelect: (AppColorTheme) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier.fillMaxWidth()) {
        Text(
            text = stringResource(R.string.color_theme),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(horizontal = 4.dp),
        )
        Text(
            text = stringResource(R.string.color_theme_desc),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(start = 4.dp, end = 4.dp, bottom = 12.dp, top = 2.dp),
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 2.dp, vertical = 4.dp),
        ) {
            items(AppColorTheme.entries, key = { it.name }) { theme ->
                ColorThemeCard(
                    theme = theme,
                    isSelected = theme == selected,
                    onClick = { onSelect(theme) },
                )
            }
        }
    }
}

@Composable
private fun ColorThemeCard(
    theme: AppColorTheme,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    val scheme = MaterialTheme.colorScheme
    val palette =
        theme.palette ?: ThemePalette(
            primary = scheme.primary,
            secondary = scheme.secondary,
            background = scheme.surface,
            surface = scheme.surfaceContainer,
        )
    val borderColor by animateColorAsState(
        if (isSelected) palette.primary else scheme.outlineVariant,
        label = "themeCardBorder",
    )
    val shape = RoundedCornerShape(20.dp)

    Column(
        modifier =
            Modifier
                .width(132.dp)
                .clip(shape)
                .background(palette.background)
                .border(BorderStroke(if (isSelected) 2.dp else 1.dp, borderColor), shape)
                .clickable(onClick = onClick)
                .padding(10.dp),
    ) {
        // Mini "now playing" preview built from the palette tokens.
        Column(
            Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(palette.surface)
                .padding(8.dp),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    Modifier
                        .size(22.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(palette.primary),
                )
                Spacer(Modifier.width(6.dp))
                Column {
                    Box(Modifier.width(44.dp).height(5.dp).clip(CircleShape).background(Color.White.copy(alpha = 0.85f)))
                    Spacer(Modifier.height(3.dp))
                    Box(Modifier.width(30.dp).height(4.dp).clip(CircleShape).background(palette.secondary.copy(alpha = 0.8f)))
                }
            }
            Spacer(Modifier.height(8.dp))
            Box(Modifier.fillMaxWidth().height(4.dp).clip(CircleShape).background(Color.White.copy(alpha = 0.15f))) {
                Box(Modifier.fillMaxWidth(0.55f).height(4.dp).clip(CircleShape).background(palette.primary))
            }
        }
        Spacer(Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(Modifier.size(10.dp).clip(CircleShape).background(palette.primary))
            Spacer(Modifier.width(4.dp))
            Box(Modifier.size(10.dp).clip(CircleShape).background(palette.secondary))
            Spacer(Modifier.width(4.dp))
            Box(
                Modifier
                    .size(10.dp)
                    .clip(CircleShape)
                    .background(palette.surface)
                    .border(1.dp, Color.White.copy(alpha = 0.25f), CircleShape),
            )
        }
        Spacer(Modifier.height(6.dp))
        Text(
            text = stringResource(theme.labelRes),
            style = MaterialTheme.typography.labelMedium,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
            color = if (isSelected) palette.primary else Color.White.copy(alpha = 0.85f),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}
