# Snake — Android Game

**Snake** — classic snake game, Android app ke roop mein (offline, full-screen).

> **Status: v0.1 — project ready (skeleton).** Saari files bani hui hain; game ka code `assets/game/` mein add hoga.

## Game (optional, `assets/game/snake.html`)

- **20×20 board** (chhota/normal/bada chun sakte hain), neon look
- **Swipe** (phone), **arrow keys / WASD** (computer), aur **on-screen D-pad**
- **Apple** khao → score +10, snake lamba
- **Har 5 apple par level** badhta hai, speed badhti hai
- **Level 3 ke baad deewarein** (obstacles) aati hain
- **Power-ups:** 🛡 shield (ek hit bacha), ✖2 double points, 🐢 slow-mo
- **Pause / resume**, **game over** + dobara khelna
- **High score + leaderboard** (phone mein save)
- **Settings:** sound, vibration, speed, board size, deewar (mar jao / aage niklo), theme (neon / classic)
- **Sound effects** (WebAudio — koi file nahi chahiye) + vibration

## Files

- Poora Android project structure (Gradle, module, manifest, resources)
- WebView + bundled HTML game (`assets/index.html`) — offline chalta hai
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
