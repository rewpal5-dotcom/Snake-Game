# Snake — Android Game

**Snake** — classic snake game, Android app ke roop mein (offline, full-screen).

> **Status: v0.1 — sirf project ka dhancha (skeleton).** Game ka code agle step mein aayega.

## Abhi kya taiyar hai

- Poora Android project structure (Gradle, module, manifest, resources)
- WebView + bundled HTML (game isi ke andar chalega)
- GitHub Actions se APK build + release pipeline
- **Files ki poori documentary:** [`docs/FILES-HINDI.md`](docs/FILES-HINDI.md)
- Roadmap: [`docs/ROADMAP.md`](docs/ROADMAP.md)

## Folder structure

```
app/src/main/
├── java/com/snakegame/app/MainActivity.java   ← app ka screen
├── res/values/{strings,colors}.xml            ← text aur rang
├── assets/index.html                          ← abhi ka page
├── assets/config/app_config.json              ← game settings
└── assets/game/                               ← game ka code yahan aayega
```

## Build

```bash
./gradlew assembleDebug
# app/build/outputs/apk/debug/app-debug.apk
```

GitHub Actions har push par APK bana kar release mein daal deta hai.

## Tech

Java + WebView · HTML5 canvas game (bundled, offline) · minSdk 24 · targetSdk 35 · compileSdk 36 · AGP 8.9.3 · Gradle 8.11.1

## License

MIT
