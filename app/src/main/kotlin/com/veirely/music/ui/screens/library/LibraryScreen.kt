/**
 * Veirely Project (C) 2026
 * Licensed under GPL-3.0 | See git history for contributors
 */

package com.veirely.music.ui.screens.library

import com.veirely.music.constants.SongFilterKey
import com.veirely.music.constants.SongFilter
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.veirely.music.LocalNavController
import com.veirely.music.R
import com.veirely.music.constants.AlbumViewTypeKey
import com.veirely.music.constants.ChipSortTypeKey
import com.veirely.music.constants.LibraryFilter
import com.veirely.music.constants.LibraryViewType
import com.veirely.music.constants.PlaylistViewTypeKey
import com.veirely.music.ui.component.ChipsRow
import com.veirely.music.utils.rememberEnumPreference

@Composable
fun LibraryScreen() {
    val navController = LocalNavController.current
    var filterType by rememberEnumPreference(ChipSortTypeKey, LibraryFilter.LIBRARY)
    var libraryViewType by rememberEnumPreference(AlbumViewTypeKey, LibraryViewType.GRID)
    var playlistViewType by rememberEnumPreference(PlaylistViewTypeKey, LibraryViewType.GRID)

    var songFilter by rememberEnumPreference(SongFilterKey, SongFilter.LIKED)
    val downloadsKey = "downloads"
    val localKey = "local_music"
    val chipKey =
        when {
            filterType == LibraryFilter.SONGS && songFilter == SongFilter.DOWNLOADED -> downloadsKey
            filterType == LibraryFilter.SONGS && songFilter == SongFilter.LOCAL -> localKey
            else -> filterType.name
        }

    val filterContent = @Composable {
        Row {
            ChipsRow(
                chips = listOf(
                    LibraryFilter.PLAYLISTS.name to stringResource(R.string.filter_playlists),
                    LibraryFilter.SONGS.name to stringResource(R.string.filter_songs),
                    LibraryFilter.ALBUMS.name to stringResource(R.string.filter_albums),
                    LibraryFilter.ARTISTS.name to stringResource(R.string.filter_artists),
                    LibraryFilter.PODCASTS.name to stringResource(R.string.filter_podcasts),
                    downloadsKey to stringResource(R.string.filter_downloaded),
                    localKey to stringResource(R.string.filter_local_music),
                ),
                currentValue = chipKey,
                onValueUpdate = { key ->
                    when (key) {
                        downloadsKey, localKey -> {
                            if (chipKey == key) {
                                filterType = LibraryFilter.LIBRARY
                            } else {
                                songFilter = if (key == downloadsKey) SongFilter.DOWNLOADED else SongFilter.LOCAL
                                filterType = LibraryFilter.SONGS
                            }
                        }
                        else -> {
                            val target = LibraryFilter.valueOf(key)
                            if (target == LibraryFilter.SONGS && chipKey != key && filterType == LibraryFilter.SONGS) {
                                songFilter = SongFilter.LIKED
                            } else {
                                filterType = if (filterType == target && chipKey == key) LibraryFilter.LIBRARY else target
                            }
                        }
                    }
                },
                modifier = Modifier.weight(1f),
            )
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        when (filterType) {
            LibraryFilter.LIBRARY -> LibraryMixScreen(
                navController = navController,
                filterContent = filterContent,
                viewType = libraryViewType,
                onViewTypeChange = { libraryViewType = it },
            )
            LibraryFilter.PLAYLISTS -> LibraryPlaylistsScreen(
                navController = navController,
                filterContent = filterContent,
                viewType = playlistViewType,
                onViewTypeChange = { playlistViewType = it },
            )
            LibraryFilter.SONGS -> LibrarySongsScreen(
                navController,
                { filterType = LibraryFilter.LIBRARY },
            )
            LibraryFilter.ALBUMS -> LibraryAlbumsScreen(
                navController,
                { filterType = LibraryFilter.LIBRARY },
            )
            LibraryFilter.ARTISTS -> LibraryArtistsScreen(
                navController,
                { filterType = LibraryFilter.LIBRARY },
            )
            LibraryFilter.PODCASTS -> LibraryPodcastsScreen(
                navController,
                { filterType = LibraryFilter.LIBRARY },
            )
        }
    }
}
