# Snake — Files ki Poori Documentary (Hindi)

**Project:** Snake (Android + HTML5 game)
**Version:** 0.1 (skeleton — sirf dhancha, game ka code baad mein)
**Yeh document kya hai:** is project ki **har file aur har folder** ka kaam, ek jagah, Hindi mein. Naya developer ise padh kar poora project samajh sakta hai.

---

## 0. Sabse pehle: Project aur APK alag cheezein hain

| | **Project** (source) | **APK** (banaya hua package) |
|---|---|---|
| Kya hai | Aapka code, files, folders | Install hone wali file |
| Kahan | Computer / GitHub | Phone |
| Andar | `.java`, `.kts`, `.xml`, `.html` | `classes.dex`, `resources.arsc`, `lib/`, `META-INF/` |
| Badal sakte hain? | Haan, jab chahein | Nahi — dobara build karna padta hai |

---

## 1. Poora folder structure

```
Snake/
├── .github/
│   └── workflows/
│       └── build-apk.yml          ← GitHub Actions: har push par APK banata hai
├── app/                           ← App module (asli app yahan hai)
│   ├── build.gradle.kts           ← App ki build settings
│   ├── proguard-rules.pro         ← Release build ke rules
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml    ← App ki pehchaan, permissions, screens
│           ├── java/com/snakegame/app/
│           │   └── MainActivity.java  ← App ka pehla (aur abhi akela) screen
│           ├── res/
│           │   └── values/
│           │       ├── strings.xml    ← App ka naam / text
│           │       └── colors.xml     ← Rang
│           └── assets/                ← Raw files (jo code se padhi jaati hain)
│               ├── index.html         ← Abhi ka placeholder page
│               ├── config/
│               │   └── app_config.json ← Game ki settings (board size, features)
│               └── game/              ← Game ka asli code yahan aayega
├── docs/
│   ├── FILES-HINDI.md             ← Yahi document
│   ├── FILE-TREE.txt              ← Sirf folder tree
│   └── ROADMAP.md                 ← Aage kya-kya banega
├── gradle/
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── build.gradle.kts               ← Project-level build file
├── settings.gradle.kts            ← Kaunse module hain + repositories
├── gradle.properties              ← Gradle ki settings
├── gradlew / gradlew.bat          ← Gradle chalane wali script (Linux/Mac / Windows)
├── .gitignore                     ← Git ko kaunsi files nahi bhejni
├── LICENSE                        ← MIT license
└── README.md                      ← Project ka parichay
```

---

## 2. Root (sabse bahar wali) files

| File | Kaam |
|---|---|
| `settings.gradle.kts` | Batata hai ki project mein kaunse module hain (`:app`) aur libraries kahan se aayengi (Google, Maven Central). |
| `build.gradle.kts` (root) | Project-level plugins — jaise Android plugin ka version (8.9.3). |
| `gradle.properties` | Gradle ki settings: memory, caching, AndroidX on/off. |
| `gradlew`, `gradlew.bat` | Gradle ko chalane wali script. `./gradlew assembleDebug` isi se chalta hai. Ye Gradle ko khud download karti hai. |
| `gradle/wrapper/*` | Wrapper ki files — batati hain kaunsa Gradle version use hoga (8.11.1). |
| `.gitignore` | Git in files ko ignore karta hai: `build/`, `.gradle/`, `local.properties`, `*.apk` wagairah. |
| `LICENSE` | MIT license — code ka istemal karne ki shartein. |
| `README.md` | Project ka parichay, install steps, links. |
| `local.properties` | **Is machine par** Android SDK ka path. Ye GitHub par nahi jaati (gitignored), har computer par alag hoti hai. |

---

## 3. `app/` — app module

| File | Kaam |
|---|---|
| `app/build.gradle.kts` | App ka `namespace`, `applicationId` (play store par permanent ID), `minSdk` 24, `targetSdk` 35, `compileSdk` 36, version, build types. |
| `app/proguard-rules.pro` | Release build mein code chhota/obfuscate karne ke rules. |
| `app/src/main/AndroidManifest.xml` | App ki pehchaan: naam, icon, theme, permissions, kaunsi activity pehle khulegi. |
| `app/src/main/java/…` | Java/Kotlin code — yahan `MainActivity` hai. |
| `app/src/main/res/…` | Android resources — text (`values/`), images (`drawable/`, `mipmap/`), layouts (`layout/`). |
| `app/src/main/assets/…` | Raw files jo app apne naam se padhta hai (yahan game ka HTML/JS). |

### AndroidManifest.xml mein kya-kya hota hai
- `<uses-permission>` — jaise INTERNET, CAMERA
- `<application>` — icon, label, theme
- `<activity>` — screens; `LAUNCHER` intent-filter wali activity app khulte hi chalti hai
- `android:exported="true"` — launcher activity ke liye zaroori

---

## 4. `res/` ke andar kaunse folder hote hain

| Folder | Kaam | Example |
|---|---|---|
| `values/` | Text, colours, styles | `strings.xml`, `colors.xml`, `themes.xml` |
| `drawable/` | Images / shapes | `bg_card.xml`, `logo.png` |
| `mipmap-*/` | App icon (har screen density ke liye alag size) | `ic_launcher.png` |
| `layout/` | Screen ka design (XML) | `activity_main.xml` |
| `xml/` | Settings files | `backup_rules.xml` |
| `raw/` | Media files | `beep.mp3` |
| `anim/` | Animations | `slide_in.xml` |

**Naming rule:** file ka naam **chhote letters**, **underscore**, aur **number se shuru nahi** — `my_icon.png` ✔, `My-Icon.png` ✘.

---

## 5. `assets/` — game ka ghar

| File | Kaam |
|---|---|
| `assets/index.html` | App khulte hi yahi page khulta hai (abhi placeholder hai). |
| `assets/config/app_config.json` | Game ki settings — board ka size, sound on/off, theme. Code badalne ke bina behaviour badal sakte hain. |
| `assets/game/` | Aage game ka asli code (JS files, sprites, sounds) yahan aayega. |

**`assets` aur `res` mein farak:** `res` ki files Android compile karta hai (R.java ke through), `assets` ki files jaisi hain waisi hi rehti hain aur code se path se padhi jaati hain (`file:///android_asset/index.html`).

---

## 6. APK ke andar kya hota hai

`app-debug.apk` ek ZIP hai, uske andar:

| Entry | Kya hai |
|---|---|
| `AndroidManifest.xml` | Compiled (binary) manifest |
| `classes.dex` | Java/Kotlin ka bytecode |
| `resources.arsc` | Compiled resources (strings, colours, ids) |
| `assets/` | Aapki raw files (game ka HTML/JS) |
| `res/` | Compiled resources |
| `lib/<abi>/*.so` | Native libraries (agar hon) |
| `META-INF/` | Signature / metadata |

Isi wajah se APK mein aap `.java` file nahi dekhenge — woh `classes.dex` ban jaati hai.

---

## 7. File extension ka catalogue

| Extension | Kya hota hai | Kahan |
|---|---|---|
| `.java` / `.kt` | Code (Java / Kotlin) | `app/src/main/java/` |
| `.xml` | Manifest, layout, values, drawable | `app/src/main/` |
| `.kts` | Gradle build script (Kotlin) | root, `app/` |
| `.properties` | Settings (key=value) | root, `gradle/wrapper/` |
| `.jar` | Java library / Gradle wrapper | `gradle/wrapper/`, `libs/` |
| `.aar` | Android library | `libs/` |
| `.so` | Native library | `lib/<abi>/` |
| `.html`, `.css`, `.js` | Web page / game | `assets/` |
| `.json` | Settings / data | `assets/config/` |
| `.png`, `.webp`, `.jpg` | Images | `res/drawable/`, `mipmap/` |
| `.ttf`, `.otf` | Fonts | `res/font/`, `assets/` |
| `.mp3`, `.ogg`, `.wav` | Sound | `res/raw/`, `assets/` |
| `.apk` | Installable app (build ke baad) | `app/build/outputs/apk/` |
| `.aab` | Play Store upload format | `app/build/outputs/bundle/` |

---

## 8. Is project ki har file — ek-ek karke

| # | File | Status | Kya karti hai |
|---|---|---|---|
| 1 | `README.md` | ✔ bani hui | Project ka parichay |
| 2 | `LICENSE` | ✔ | MIT license |
| 3 | `.gitignore` | ✔ | Build files ko Git se bahar rakhta hai |
| 4 | `settings.gradle.kts` | ✔ | Module + repositories |
| 5 | `build.gradle.kts` | ✔ | Android plugin version |
| 6 | `gradle.properties` | ✔ | Gradle settings |
| 7 | `gradlew` / `gradlew.bat` | ✔ | Build chalane wali script |
| 8 | `gradle/wrapper/gradle-wrapper.jar` | ✔ | Wrapper ka engine |
| 9 | `gradle/wrapper/gradle-wrapper.properties` | ✔ | Gradle version (8.11.1) |
| 10 | `app/build.gradle.kts` | ✔ | App ki build settings |
| 11 | `app/proguard-rules.pro` | ✔ | Release rules |
| 12 | `app/src/main/AndroidManifest.xml` | ✔ | App ki pehchaan + activity |
| 13 | `app/src/main/java/com/snakegame/app/MainActivity.java` | ✔ | App ka main screen (WebView) |
| 14 | `app/src/main/res/values/strings.xml` | ✔ | App ka naam |
| 15 | `app/src/main/res/values/colors.xml` | ✔ | Rang |
| 16 | `app/src/main/res/mipmap-*/ic_launcher.png` | ✔ | App icon (5 sizes) |
| 17 | `app/src/main/assets/index.html` | ✔ (placeholder) | Abhi ka shuruaati page |
| 17a | `app/src/main/assets/game/snake.html` | ✔ (optional) | Snake game ka code (baad mein isi jagah add hoga) |
| 18 | `app/src/main/assets/config/app_config.json` | ✔ | Game settings |
| 19 | `app/src/main/assets/game/` | ✔ | Game ka code yahan rehta hai |
| 20 | `.github/workflows/build-apk.yml` | ✔ | Har push par APK build + release |
| 21 | `docs/FILES-HINDI.md` | ✔ | Yahi document |
| 22 | `docs/FILE-TREE.txt` | ✔ | Folder tree |
| 23 | `docs/ROADMAP.md` | ✔ | Aage ka plan |

---

## 9. Naya kuch banate waqt kahan rakhein

| Aap kya bana rahe hain | Kahan rakhein |
|---|---|
| Naya screen / logic | `app/src/main/java/com/snakegame/app/` |
| Naya text / colour | `res/values/strings.xml`, `colors.xml` |
| Image / icon | `res/drawable/` (icon ke liye `mipmap-*/`) |
| Game ka JS / HTML / sprite / sound | `assets/game/` |
| Settings ka data | `assets/config/app_config.json` |
| Naya permission | `AndroidManifest.xml` |
| Nayi library | `app/build.gradle.kts` ke `dependencies { }` |
| Naya build step | `.github/workflows/build-apk.yml` |

---

## 10. Safe practices (yaad rakhein)

1. `local.properties` kabhi GitHub par na daalein — usme aapke computer ka path hota hai.
2. `build/` folder commit na karein — woh har build par dobara banta hai.
3. File ke naam chhote letters + underscore mein rakhein (`snake_food.png`), spaces aur capital letters se bachein.
4. `applicationId` ek baar tay hone ke baad na badlein — woh app ki permanent ID hoti hai.
5. APK ka size chhota rakhne ke liye images ko `.webp` mein rakhein.
6. Har badlav ke baad: `./gradlew assembleDebug` chala kar dekhein ki build pass hai.
7. Version badhate rahein: `versionCode` (number) aur `versionName` (dikhne wala) dono.

---

## 11. Build kaise chalega

```bash
# local machine par
./gradlew assembleDebug
# output: app/build/outputs/apk/debug/app-debug.apk

# GitHub par
git push  →  Actions → Build APK  →  release mein APK taiyar
```

Direct download link (build ke baad):
`https://github.com/rewpal5-dotcom/Snake-Game/releases/latest/download/app-debug.apk`

---

*Ye document project ke saath hi update hota rahega — jab bhi koi nayi file add ho, uski entry table (section 8) mein add ki jayegi.*
