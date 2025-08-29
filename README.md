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

1. **Add Tasks**: Tap the ➕ button to add your choices, tasks, or options to the wheel
2. **Spin the Wheel**: Tap the center spin button to rotate the wheel
3. **Get Your Decision**: Watch as the wheel spins and lands on your choice!
4. **Manage Tasks**: 
   - Use the ➖ button to remove the last added task
   - Use the 🔄 button to reset and clear all tasks

## 🎨 Visual Design

- **Color Palette**: The app uses a beautiful set of pastel colors:
  - Soft Pink (`#FFA8A8`)
  - Mint Green (`#B5EAD7`) 
  - Sky Blue (`#9AD1D4`)
  - Peach (`#FBC4AB`)
  - Lavender (`#E4C1F9`)
  - Cream (`#FFDAC1`)
  - Rose (`#FFB5E8`)

- **Animations**: 3-second spin duration with realistic easing for a satisfying user experience

## 🛠️ Technical Details

- **Platform**: Android (API 31+)
- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: Modern Android development with:
  - Material 3 Design System
  - Compose Animation APIs
  - State management with `remember` and `mutableStateOf`

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

## 📱 App Structure

```
app/
├── src/main/java/com/wheelie/
│   ├── MainActivity.kt          # Main entry point
│   └── ui/theme/
│       ├── Disc.kt             # Main wheel component
│       ├── DialogBox.kt        # Task input dialog
│       └── Theme.kt            # App theming
└── src/main/res/               # Resources (icons, etc.)
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