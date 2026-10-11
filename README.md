# PABHomework

Mobile Application Development (Pengembangan Aplikasi Bergerak) — SIF502, Odd Semester 2026/2027

| | |
|---|---|
| **Name** | Muhammad Aufa Nabihan |
| **NIM** | 24523083 |

## Modules

| Module | Homework | Description |
|---|---|---|
| `:hw05` | Homework 5 | Functional & Idiomatic Kotlin (`task1/hw1.kt` … `task5/hw5.kt`) |
| `:app` | Homework 6 | Android Studio and Your First Jetpack Compose App (`MyFirstScreen`) |

---

# Homework 6 — My First Compose App

## Task 3: Colour and Spacing
**Colour used:** `Color(0xFFE8EEF5)` (Soft Slate Blue-Gray)  
**Padding kept:** `24.dp`  
**What changed / what stayed the same:**  
When altering the padding from `8.dp` to `48.dp`, the internal margin between the boundary of the screen and the content (greeting, app idea, and picture) expanded significantly, compressing the contents towards the center and leaving much wider empty borders around them. What remained identical was the background surface color, which continuously covered the entire display screen due to `Modifier.fillMaxSize()`, as well as the intrinsic text size and image dimensions.

## Task 4: Build Error
**First error message:**
```
ERROR: D:\semester 5\Pengambangan Mobile\app\src\main\res\drawable\My-Picture.png: Resource and asset merger: 'M' is not a valid file-based resource name character: File-based resource names must contain only lowercase a-z, 0-9, or underscore
```
**Cause:**  
The Android asset and resource packaging tool (AAPT2) enforces strict naming conventions: all file-based resource names under `res/` directories must contain exclusively lowercase letters (`a-z`), digits (`0-9`), and underscores (`_`). Uppercase characters (such as `'M'`) and hyphens (`'-'`) violate this constraint because resource filenames are directly mapped to Java/Kotlin identifier fields in the generated `R` class.

**Why other errors appear:**  
Because the resource packaging task (`:app:packageDebugResources`) aborts upon encountering an invalid resource filename, AAPT2 fails to generate the `R.java` symbol table. Consequently, downstream Kotlin compilation tasks cannot locate resource references, triggering cascading errors such as `unresolved reference: my_picture` or `unresolved reference: R`.

**Fix:**  
Renamed the file back to `my_picture.png` in `app/src/main/res/drawable/` so that it adheres strictly to the lowercase and underscore naming requirement, allowing AAPT2 and Gradle to build successfully.

## Task 5: Explore the Project
- **(a) MainActivity:**  
  Path: `app/src/main/java/com/example/myfirstcomposeapp/MainActivity.kt`  
  It serves as the main entry point activity of the application, calling `setContent` to initialize the Jetpack Compose hierarchy and display `MyFirstScreen()`.
- **(b) Gradle file:**  
  Path: `app/build.gradle.kts`  
  It configures the Android build system specifically for the `:app` module, defining the target and compile SDKs, application ID, dependencies, and Compose build features.
- **(c) Launcher image line:**  
  Code: `painter = painterResource(id = R.drawable.ic_launcher_foreground)`  
  It references and renders the default Android robot vector graphic defined in `ic_launcher_foreground.xml` before being substituted with a custom image resource.

## Task 6: Preview vs Run
When modifying text in `MyFirstScreen` and refreshing the Preview panel in Android Studio without clicking the Run button, the layout is re-rendered only inside the Android Studio IDE using the desktop Compose tooling layout engine (`androidx.compose.ui:ui-tooling`). 

The application running on the physical phone or emulator does not update because the device executes a pre-installed APK binary saved in its local storage. To reflect changes on the device, Android Studio must package a new debug APK via Gradle (`assembleDebug`), push and install the updated APK via ADB (`adb install -r`), and relaunch the Activity.

## Task 7: Views vs Compose
### 1. Imperative Views vs Declarative Compose
In the traditional **imperative Views** architecture, UI elements are defined in XML files and instantiated into long-lived stateful object graphs in memory. The developer must manually mutate each view's internal state step-by-step using getter and setter methods (e.g., finding the widget via `findViewById<TextView>(R.id.greetingText)` and explicitly invoking `textView.text = "Hi! I am Aufa."`). Any change in data requires writing imperative code to manipulate existing view instances, which frequently leads to synchronization bugs.

In contrast, **Jetpack Compose** utilizes a modern **declarative** model. Instead of mutating view widgets, functions like `MyFirstScreen()` simply describe what the UI should look like for a given set of data at any moment:
```kotlin
@Composable
fun MyFirstScreen() {
    Surface(color = Color(0xFFE8EEF5)) {
        Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
            Text(text = "Hi! I am Aufa.")
            Text(text = "My idea: a Student Task Tracker.")
            Image(painter = painterResource(id = R.drawable.my_picture), contentDescription = "...")
        }
    }
}
```
When state changes, Compose automatically re-executes (*recomposes*) only the affected composable functions with the new data, recreating the visual representation without manual view mutation.

### 2. Library Layers
| Composable | Package | Library layer |
|---|---|---|
| `Column` | `androidx.compose.foundation.layout` | Layout (Foundation) |
| `Text` | `androidx.compose.material3` | Material 3 |
| `Image` | `androidx.compose.foundation` | Foundation |
