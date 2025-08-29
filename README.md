# 🎯 Wheelie - Decision Making Wheel App

A fun and interactive Android app that helps you make decisions! Wheelie is a roulette-style spinning wheel where you can add your tasks, choices, or options, and let the wheel decide for you.

## ✨ Features

- **🎨 Colorful Wheel**: Each task gets assigned a beautiful, random color from a curated palette
- **🌪️ Smooth Animations**: Satisfying spin animations with realistic physics
- **➕ Easy Task Management**: 
  - Add new tasks with a simple dialog
  - Remove the last added task
  - Reset the entire wheel
- **🎯 Random Selection**: Fair and random decision making
- **📱 Modern UI**: Built with Material 3 design and Jetpack Compose

## 🎮 How to Use

1. **Add Tasks**: Tap the ➕ (add_circle) button to add your choices, tasks, or options to the wheel
2. **Spin the Wheel**: Tap the center 🔄 (rotate) button to rotate the wheel with a 3-second animation
3. **Get Your Decision**: Watch as the wheel spins and lands on your choice! The app uses an arrow indicator at the top
4. **Manage Tasks**: 
   - Use the ➖ (remove_circle) button to remove the last added task
   - Use the 🔄 (reset_circle) button to reset and clear all tasks

## 🎨 Visual Design

- **Color Palette**: The app uses a beautiful set of pastel colors automatically assigned to each task:
  - Soft Pink (`#FFA8A8`)
  - Mint Green (`#B5EAD7`) 
  - Sky Blue (`#9AD1D4`)
  - Peach (`#FBC4AB`)
  - Lavender (`#E4C1F9`)
  - Cream (`#FFDAC1`)
  - Rose (`#FFB5E8`)

- **UI Elements**: Custom vector drawables for all controls:
  - Arrow indicator at the top for result selection
  - Add button (add_circle.xml)
  - Remove button (remove_circle.xml) 
  - Reset button (reset_circle.xml)
  - Spin button (rotate.xml)

- **Animations**: 3-second spin duration with `FastOutSlowInEasing` for a realistic wheel experience
- **Smart Color Assignment**: The app intelligently avoids duplicate colors and assigns unused colors from the palette to new tasks

## 🛠️ Technical Details

- **Platform**: Android (API 31+, Target API 36)
- **Language**: Kotlin
- **UI Framework**: Jetpack Compose with Material 3
- **Architecture**: Modern Android development with:
  - Jetpack Compose for declarative UI
  - Compose Animation APIs for smooth wheel rotation
  - State management with `remember` and `mutableStateOf`
  - Custom Canvas drawing for the wheel sectors
  - Coroutines for animation handling
  - Vector drawables for scalable icons

## 📱 Key Components

- **Disc.kt**: Main wheel component with Canvas-based drawing
- **DialogBox.kt**: Modal dialog for adding new tasks
- **MainActivity.kt**: Entry point with Compose theme setup
- **Sector data class**: Represents individual wheel segments with text and color

## 🏗️ Building the App

### Prerequisites
- Android Studio (latest version recommended)
- JDK 11 or higher
- Android SDK with API level 31+

### Build Instructions

1. **Clone the repository**:
   ```bash
   git clone https://github.com/NikunjVashishtha/Wheelie.git
   cd Wheelie
   ```

2. **Open in Android Studio**:
   - Open Android Studio
   - Select "Open an existing Android Studio project"
   - Navigate to the cloned directory and select it

3. **Build the project**:
   ```bash
   ./gradlew build
   ```

4. **Run on device/emulator**:
   - Connect an Android device or start an emulator
   - Click the "Run" button in Android Studio or use:
   ```bash
   ./gradlew installDebug
   ```

## 🔧 Troubleshooting

- **Build Issues**: Make sure you have the correct Android SDK version (API 31+) installed
- **Gradle Sync Problems**: Try cleaning the project: `./gradlew clean`
- **Emulator Issues**: Ensure your emulator is running Android API 31 or higher
- **Memory Issues**: The app uses Canvas drawing which may require adequate device memory

## 🤝 Contributing

## 📱 App Structure

```
app/
├── src/main/java/com/wheelie/
│   ├── MainActivity.kt          # Main entry point & Sector data class
│   └── ui/theme/
│       ├── Disc.kt             # Main wheel component with Canvas drawing
│       ├── DialogBox.kt        # Task input dialog with Material 3 styling
│       └── Theme.kt            # App theming and color schemes
└── src/main/res/               
    ├── drawable/               # Vector icons (add, remove, reset, rotate, arrow)
    └── values/                 # App name and color definitions
```

## 🎯 Use Cases

Perfect for:
- **Decision Making**: Can't decide what to eat, watch, or do? Let Wheelie choose!
- **Games**: Create fun party games or icebreakers
- **Task Selection**: Randomly assign chores or responsibilities
- **Learning**: Make studying more engaging by gamifying topic selection
- **Team Activities**: Random team member selection or activity choosing

## 🤝 Contributing

Feel free to contribute to Wheelie! Whether it's bug fixes, new features, or improvements to the UI/UX, all contributions are welcome.

## 📄 License

This project is open source. Feel free to use, modify, and distribute as needed.

---

**Made with ❤️ and Jetpack Compose**

*Turn your tough decisions into fun spins! 🎡*