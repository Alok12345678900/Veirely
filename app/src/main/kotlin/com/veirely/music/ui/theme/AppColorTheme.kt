/**
 * Veirely Project (C) 2026
 * Licensed under GPL-3.0 | See git history for contributors
 */

package com.veirely.music.ui.theme

import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.graphics.luminance
import com.veirely.music.R

/** The four design tokens every palette is defined by. */
data class ThemePalette(
    val primary: Color,
    val secondary: Color,
    val background: Color,
    val surface: Color,
)

/**
 * Selectable color identities. [MATERIAL_YOU] keeps the legacy behaviour
 * (system dynamic color / artwork seed color) and has no fixed palette.
 */
enum class AppColorTheme(
    @StringRes val labelRes: Int,
    val palette: ThemePalette?,
) {
    PURPLE_NIGHT(
        R.string.color_theme_purple_night,
        ThemePalette(Color(0xFFA855F7), Color(0xFFD8B4FE), Color(0xFF100B13), Color(0xFF1B1420)),
    ),
    OCEAN_BLUE(
        R.string.color_theme_ocean_blue,
        ThemePalette(Color(0xFF3B82F6), Color(0xFF93C5FD), Color(0xFF080F1B), Color(0xFF111D30)),
    ),
    EMERALD_GREEN(
        R.string.color_theme_emerald_green,
        ThemePalette(Color(0xFF10B981), Color(0xFF6EE7B7), Color(0xFF081510), Color(0xFF10251C)),
    ),
    CRIMSON_RED(
        R.string.color_theme_crimson_red,
        ThemePalette(Color(0xFFEF4444), Color(0xFFFCA5A5), Color(0xFF170A0D), Color(0xFF251216)),
    ),
    ROSE_PINK(
        R.string.color_theme_rose_pink,
        ThemePalette(Color(0xFFEC4899), Color(0xFFF9A8D4), Color(0xFF180B14), Color(0xFF271426)),
    ),
    AMBER_GOLD(
        R.string.color_theme_amber_gold,
        ThemePalette(Color(0xFFF59E0B), Color(0xFFFCD34D), Color(0xFF171109), Color(0xFF251C10)),
    ),
    CYAN_NEON(
        R.string.color_theme_cyan_neon,
        ThemePalette(Color(0xFF06B6D4), Color(0xFF67E8F9), Color(0xFF071418), Color(0xFF102329)),
    ),
    AMOLED_BLACK(
        R.string.color_theme_amoled_black,
        ThemePalette(Color(0xFFC084FC), Color(0xFFE9D5FF), Color(0xFF000000), Color(0xFF101010)),
    ),
    MATERIAL_YOU(R.string.color_theme_material_you, null),
    ;

    companion object {
        val Default = PURPLE_NIGHT
    }
}

private val DarkOnAccent = Color(0xFF14101A)

private fun onAccent(color: Color): Color = if (color.luminance() > 0.35f) DarkOnAccent else Color.White

/** Builds a complete dark Material 3 scheme from the four palette tokens. */
fun ThemePalette.toDarkColorScheme(): ColorScheme {
    val onSurface = lerp(Color.White, primary, 0.06f)
    val containerHigh = lerp(surface, Color.White, 0.08f)
    val containerHighest = lerp(surface, Color.White, 0.12f)
    val primaryContainer = lerp(background, primary, 0.32f)
    val secondaryContainer = lerp(surface, secondary, 0.22f)
    return darkColorScheme(
        primary = primary,
        onPrimary = onAccent(primary),
        primaryContainer = primaryContainer,
        onPrimaryContainer = lerp(secondary, Color.White, 0.4f),
        inversePrimary = lerp(primary, Color.Black, 0.35f),
        secondary = secondary,
        onSecondary = onAccent(secondary),
        secondaryContainer = secondaryContainer,
        onSecondaryContainer = lerp(secondary, Color.White, 0.4f),
        tertiary = secondary,
        onTertiary = onAccent(secondary),
        tertiaryContainer = secondaryContainer,
        onTertiaryContainer = lerp(secondary, Color.White, 0.4f),
        background = background,
        onBackground = onSurface,
        surface = background,
        onSurface = onSurface,
        surfaceVariant = containerHigh,
        onSurfaceVariant = lerp(onSurface, background, 0.35f),
        surfaceTint = primary,
        inverseSurface = onSurface,
        inverseOnSurface = background,
        outline = lerp(onSurface, background, 0.6f),
        outlineVariant = lerp(surface, Color.White, 0.14f),
        scrim = Color.Black,
        surfaceBright = containerHighest,
        surfaceDim = background,
        surfaceContainerLowest = lerp(background, Color.Black, 0.4f),
        surfaceContainerLow = lerp(background, surface, 0.5f),
        surfaceContainer = surface,
        surfaceContainerHigh = containerHigh,
        surfaceContainerHighest = containerHighest,
    )
}

/** Animates every color so a theme switch fades across the whole UI instead of snapping. */
@Composable
fun ColorScheme.animated(): ColorScheme {
    val spec = tween<Color>(durationMillis = 350)
    @Composable
    fun Color.a() = animateColorAsState(this, spec, label = "themeColor").value
    return copy(
        primary = primary.a(),
        onPrimary = onPrimary.a(),
        primaryContainer = primaryContainer.a(),
        onPrimaryContainer = onPrimaryContainer.a(),
        inversePrimary = inversePrimary.a(),
        secondary = secondary.a(),
        onSecondary = onSecondary.a(),
        secondaryContainer = secondaryContainer.a(),
        onSecondaryContainer = onSecondaryContainer.a(),
        tertiary = tertiary.a(),
        onTertiary = onTertiary.a(),
        tertiaryContainer = tertiaryContainer.a(),
        onTertiaryContainer = onTertiaryContainer.a(),
        background = background.a(),
        onBackground = onBackground.a(),
        surface = surface.a(),
        onSurface = onSurface.a(),
        surfaceVariant = surfaceVariant.a(),
        onSurfaceVariant = onSurfaceVariant.a(),
        surfaceTint = surfaceTint.a(),
        inverseSurface = inverseSurface.a(),
        inverseOnSurface = inverseOnSurface.a(),
        outline = outline.a(),
        outlineVariant = outlineVariant.a(),
        surfaceBright = surfaceBright.a(),
        surfaceDim = surfaceDim.a(),
        surfaceContainerLowest = surfaceContainerLowest.a(),
        surfaceContainerLow = surfaceContainerLow.a(),
        surfaceContainer = surfaceContainer.a(),
        surfaceContainerHigh = surfaceContainerHigh.a(),
        surfaceContainerHighest = surfaceContainerHighest.a(),
    )
}
