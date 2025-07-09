# ⏳ Java Pomodoro Timer

A lightweight **Pomodoro-style countdown timer** built in Java using Swing. The application launches a minimalist, frameless window that displays a ticking countdown — perfect for working in focused time blocks.

---

## 🚀 Features

- ✅ 25-minute countdown by default (fully configurable)
- ✅ Minimalistic and always-on-top GUI
- ✅ Clean separation of logic (Timer) and interface (Swing)
- ✅ Timer updates every second
- ✅ Easy to modify and extend

---
## 📁 Project Structure
src/
├── org.example
│ ├── Main.java
│ ├── gui/
│ │ └── GUI.java
│ └── service/
│ └── CountdownTimer.java


---

## ⚙️ Requirements

- Java 8 or higher
- Any Java IDE (e.g. IntelliJ, Eclipse) or CLI (`javac`)

---

## ▶️ How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/MateuszSokol/SwingTimer.git
   cd SwingTimer
2. Compile the project
   javac -d out src/org/example/**/*.java
3. Run the app
  java -cp out org.example.Main

Change the duration in CountdownTimer.java:
new CountdownTimer(25); // 25 = 25 minutes



