---v13.7.0
# KMP status update
Veirely-KMP remains in alpha, but tester feedback has been very positive. To try it, join our Discord and donate at least $1 to support development.

## Highlights
- Migrated networking to InnerTubeX with automatic client fallback
- Reduced memory use and background work in large libraries, History, Cache, Android Auto, and audio processing
- Repaired older-version upgrades, Android Auto browsing, artist metadata, and YouTube channel switching
- Improved login, account loading, uploads, downloads, caching, metadata editing, and playlist sync
- Restored the classic app icon

## New features
- Choose whether songs are added to the start or end of playlists
- Added Zemer lyrics for Jewish music
- Added detailed, copyable playback error reports
- Added a unified update prompt for standalone and KMP releases
- Added Inception AI models and improved lyric translation output
- Restored universal x86 and x86_64 support

## Fixes and improvements
- Fixed missing or cropped artwork and improved timed and Cyrillic lyrics
- Preserved manual metadata edits during refreshes and corrected Cache Playlist contents
- Fixed repeat and shuffle with crossfade, Listen Together stutter, and paused queues restarting at the end
- Fixed per-song volume normalization and improved playback recovery
- Fixed dismissed media controls reappearing and several startup crashes
- Protected local likes from incomplete sync responses and improved uploaded-song handling
- Updated dependencies and CI

New contributors: @RizkLee (#4277), @GameOn223 (#4269), and @makro17 (#4270)

**Full changelog**: https://github.com/MetrolistGroup/Metrolist/compare/v13.6.3...v13.7.0

---v13.6.3

This is a hotfix release to fix borked lyrics and media controller. We apologize for the inconvenience.  

~ VeirelyGroup

---v13.6.2
# THE FUTURE OF VEIRELY
Veirely KMP is almost ready. We are ironing out the remaining bugs and preparing for release, but it is still at least a couple of weeks away.

# Major changes
- Fixed playback issues caused by changes that also broke official apps
- Fixed playlist sync duplication and out-of-memory crashes
- Improved automatic player configuration updates for future YouTube changes

## Notable new features
- Added handling for KMP updates and migrations

## Other improvements
- Improved Android Auto voice search matching and radio queue generation
- Added an Android Auto search limit and optimized local searches to prevent out-of-memory crashes
- Fixed podcast playback errors
- Fixed crossfade timing at non-default playback speeds
- Fixed the app lingering in the background after it was closed
- Fixed sleep timer dialog layouts and menus containing long translated text
- Fixed the persistent shuffle setting not working
- Dimmed the repeat button when repeat is disabled
- Rounded the corners of exported lyrics images
- Updated dependencies

## New Contributors
* @SimoneFelici made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/4102
* @arpitagarwal1301 made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/4178

**Full Changelog**: https://github.com/MetrolistGroup/Metrolist/compare/v13.6.1...v13.6.2

---v13.6.1
# THE FUTURE OF VEIRELY
The new Kotlin Multiplatform version of Veirely is now in a good state, and we are aiming to release it within the next month. Until then, the current app will remain in maintenance mode and receive bug fixes and minor improvements.

# Major changes
- Improved playback reliability and recovery from YouTube player failures
- Fixed black screens, startup crashes, and playback freezes
- Improved Listen Together synchronization

## Notable new features
- Added refreshed branding and an optional dynamic app icon
- Added predictive back support and improved landscape scaling

## Other improvements
- Fixed login, logout, and backup restoration issues
- Fixed incorrect artist names, song durations, podcast metadata, and missing artwork
- Fixed Android Auto freezes and playback delays
- Fixed foreground service ANRs and multiple other crashes
- Fixed sleep timer crashes and restored saved defaults
- Improved library sync performance and YouTube player compatibility

## New Contributors
* @HansHolz09 made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3837

**Full Changelog**: https://github.com/MetrolistGroup/Metrolist/compare/v13.6.0...v13.6.1

---v13.5.0
# MAINTENANCE MODE
Veirely is currently in maintenance mode. This means we will only be fixing bugs and making minor improvements. Please do not submit PRs for new features or major changes, as they will not be accepted.

# Major changes
- Rewrote the Discord RPC integration again
- Fixed random playback issues and pauses
- Fixed liked songs, playlists, albums, search results, etc. not displaying properly

## Notable new features
- Added a toggle for automatic radio queue generation
- Added automatic tablet UI scaling
- Toggle from repeat(1) to repeat(all) after song change

## Other improvements
- Fixe covers not loading sometimes
- Artist names are now split properly, and are now clickable
- Fixed multiple crashes
- Improved audio normalization
- Fixed search results not being combined properly
- Fixed 'High quality' option not choosing the highest quality option
- Fixed history sync not working

## New Contributors
- @DanielSchmerber made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3777
- @Arjuanto made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3780

---v13.4.3
# MAINTENANCE MODE
Veirely is currently in maintenance mode. This means we will only be fixing bugs and making minor improvements. Please do not submit PRs for new features or major changes, as they will not be accepted.

# Major changes
- Rewrote the Discord RPC integration
- Improved the look of playlist screens
- Added a new playlist widget

## Notable new features
- Added proper apple music lyrics support
- Added a normalization level selector
- Added the ability to hide monthly/weekly most playlists

## Other improvements
- Improve overall performance and stability
- Fixed devnagari lyrics not being displayed properly
- Improve lyrics fetching speed
- Fixed crashes and some memory leaks
- Fixed images being low resolution for some users
- Handle playlist paging properly
- Multiple smaller improvements by  <3

## New Contributors
- @Jeff0945 made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3358

---v13.4.2
# MAINTENANCE MODE
Veirely is currently in maintenance mode. This means we will only be fixing bugs and making minor improvements. Please do not submit PRs for new features or major changes, as they will not be accepted.

# Major changes
- Fixed random crashes and some memory leaks
- Fixed issues with uploading songs to YouTube
- Fixed playback for uploaded songs

## Notable new features
- EQ screen redesign and guided AutoEQ profile import
- Automatically create database backups before updates

## Other improvements
- Improved support for Android Auto
- Brought back the copy lyrics button for experimental lyrics
- Fixed the re-sync button for experimental lyrics
- Fixed listen together not working
- Added back support for choosing an account upon login
- Implemented concurrent fetching, fix lyrics fetch ordering, and optimize LyricsPlus server selection
- Corrected the play-next shuffle order
- Improved the Android Auto icon

## New Contributors
- @ndellagrotte made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3487
- @cmeka made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3534
- @punkscience made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3517

---v13.4.1
# MAINTENANCE MODE
Veirely is currently in maintenance mode. This means we will only be fixing bugs and making minor improvements. Please do not submit PRs for new features or major changes, as they will not be accepted.

# Major changes
- Fixed cached songs showing up in the downloads playlist
- Fixed multiple playback issues and prepared for YouTube's player changes

## Notable new features
- Added the ability to paste URLs to the search to play them directly
- Added a search bar to the Library screen
- Added a setting to bind pitch and speed together
- Added support for Gemini voice playback
- Added an option choose the highest possible audio quality
- Added a button to create a playlist from the Library screen

## Other improvements
- Moved the resync button to the lyrics menu
- Properly reset player on IO errors
- Multiple improvements to lyrics fetching and parsing
- Made autoplay disablable from the settings
- Fixed foreground/background service crashes
- Fixed Play next not working
- Properly handle database updates on download removal
- Use lyricsplus caching to lower server load
- Performance optimizations
- Prefetch lyrics for the next song if currently viewing lyrics
- Fixed multiple issues with Listen Together
- Fixed multiple issues with the experimental lyrics
- Fixed pause music on task clear not working

## New Contributors
* @ibratabian17 made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3474
* @sasha-melech made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3301
* @FireLion137 made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3500
* @binimum made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3493
* @stopper2408 made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3506
* @SunjeetKajla made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3505

**Full Changelog**: https://github.com/MetrolistGroup/Metrolist/compare/v13.4.0...v13.4.1
---v13.4.0
# MAINTENANCE MODE
Veirely is currently in maintenance mode. This means we will only be fixing bugs and making minor improvements. Please do not submit PRs for new features or major changes, as they will not be accepted.

No, this is not an April Fools joke, even though this update is being released on April 1st.

We are working on something big for the future of Veirely - this is not the end of the project.

# Major changes
- Multiple playback fixes and reliability improvements
- Revamped the entire Lyrics engine, improving lyric accuracy and usability
- Fixed multiple crash issues
- Multiple improvements to Android Auto support
- Fixed multiple grammar and text inconsistency issues in the project

## Notable new features
- Added support for treating cached songs as offline songs
- Added music alarm scheduling
- Added miniplayer styles
- Added a button to copy all song lyrics to the clipboard
- Added a time transfer feature to move listening time between songs in the stats page
- Added customization support for the AI prompt used for translations
- Added a notification-based music recognition for the QS tile shortcut

## Other improvements
- Fixed incorrect artist order for multi-artist songs
- Fixed playtime in the stats page not being fully visible
- Improved radio to start seamlessly when initiated from the currently playing track
- Improved the UI for tablets
- Improved the About Screen layout
- Fixed ghost adds on playlists
- Improved search focus and navigation behavior
- Added album navigation on song title click regardless of play source
- Prevented UI state reset when switching apps
- Restored the Daily Discover title in the Home screen
- Fixed listen together audio choppiness
- Redesigned romanization and account settings
- Improved the design of the sleep timer dialog
- Redesigned some components to use Material 3 Expressive
- Fixed links in the README

## New Contributors
* @AntonioDionisio05 made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3255
* @David-2765 made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3271
* @luigiwwmf made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3293
* @gergesh made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3300
* @Lolen10 made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3328

**Full Changelog**: https://github.com/MetrolistGroup/Metrolist/compare/v13.3.0...v13.3.1
---v13.3.0
# Major changes
- Implemented song upload and delete functionality
- Multiple playback fixes and reliability improvements
- Fixed proguard rules causing issues with Reproducible Builds
- Fixed proguard rules removing Listen Together protobuf classes
- Added a playlist export option to the playlist context menu

## Notable new features
- Added a Play all action for the stats page
- Added a quick settings tile for recognizing music
- Added automatic sleep timer options and integrated fade-out volume handling
- Added a profile search filter
- Added channel subscriptions for podcasts and artists

## Other improvements
- Fixed cached images not clearing properly and cached covers not showing when offline
- Removed useless and stale strings from the codebase
- Refined the song details view
- Added support for Mistral AI models
- Redesigned the lastfm integration settings
- Fixed importing csv files crashing the app
- Prevent guest playback while in listen together
- Fixed podcasts not working for logged-out users
- Updated dependencies

## New Contributors
* @isotjs made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3090

**Full Changelog**: https://github.com/MetrolistGroup/Metrolist/compare/v13.2.1...v13.3.0
---v13.2.1
>[!WARNING]
>Listen Together doesn't work in v13.2.1! Use v13.2.0 if you need it.

## Hot Fixes
- Fix interface lag issue
- Fix navigate local playlists pinned in speed dial
- Removed "cache songs only after playback has started" option

**Full Changelog**: https://github.com/MetrolistGroup/Metrolist/compare/v13.2.0...v13.2.1
---v13.2.0
# Major changes
- Fixed playback breaking due to YouTube's February 2026 n-transform changes
- Added full podcast library support
- Redesigned loading, Changelog, and About screens
- Improved app startup time via parallelized home screen loading

## Notable new features
- Added an option to cache songs only after playback has started
- Added a music recognizer home screen widget
- Rewrote music recognizer in pure Kotlin, removing NDK dependency and reducing APK size
- Overhauled lyrics: added LyricsPlus provider, AI lyric fixes, untranslation support, and provider priority settings
- Changed listen together to use protobuf, lowering latency and improving reliability
- Added auto-approve setting for listen together song requests
- Added an option to persist the sleep timer default value
- Added a dialog on logout to keep or clear library data

## Other improvements
- Fixed backup restore causing playback errors due to stale auth credentials
- The CSV import dialog is now scrollable
- Fixed Android 15 foreground service crashes
- Fixed a crash on the About screen on some devices
- Fixed home screen playlist navigation routing to wrong screen
- Fixed crash when creating local playlists

## New Contributors
*  made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/2991

**Full Changelog**: https://github.com/MetrolistGroup/Metrolist/compare/v13.1.1...v13.2.0
