

# 📋 Java Task Manager CLI

A lightweight, command-line task management application built in Java.
Supports **categories**, **priorities**, and **persistent storage** (via JSON).
Tasks are displayed in the **order they were added**.

---

## ✨ Features

* Add tasks with optional **category** and **priority**.
* Mark tasks as **done**.
* Delete tasks.
* List all tasks **in insertion order**.
* List tasks filtered by category.
* **Persistent storage** using JSON (via [Gson](https://github.com/google/gson)).
* Colored output based on priority:

  * 🔴 **HIGH** — Red
  * 🟡 **MEDIUM** — Yellow
  * 🟢 **LOW** — Green

---

## 📦 Requirements

* **Java 21** or higher (**important — older versions will fail to run**)
* **Gson 2.10.1** (or compatible version)

⚠ **If you try to run this with Java 8 or lower, you'll get:**

```
UnsupportedClassVersionError: Main has been compiled by a more recent version of the Java Runtime
```

Check your Java version before running:

```bash
java -version
```

It must show **21** or higher.

---

## 🔧 Installation

1. **Clone this repository**:

   ```bash
   git clone https://github.com/habibaesam13/ET3-Option-2-Command-Line-To-Do-App.git
   cd ET3-Option-2-Command-Line-To-Do-App
   ```

2. **Place the Gson JAR** inside your `ET3Challenge` directory:

   * Download from [Gson Releases](https://github.com/google/gson/releases)
   * Save as `ET3Challenge/gson-2.10.1.jar`

---

## 🚀 Usage

1. **Open terminal / PowerShell**
2. **Navigate to the `ET3Challenge` folder inside the cloned repository:**

   ```bash
   cd ET3Challenge
   ```
3. **Compile**:

   ```bash
   "C:\Program Files\Java\jdk-21\bin\javac.exe" -cp "gson-2.10.1.jar" -d out/production/ET3Challenge src/*.java
   ```
4. **Run the program** *(always use the Java 21 executable)*:

   ```bash
   "C:\Program Files\Java\jdk-21\bin\java.exe" -cp "out/production/ET3Challenge;gson-2.10.1.jar" Main <command> [arguments]
   ```

---

## 📜 Commands

| Command                                   | Description                                                                                         |
| ----------------------------------------- | --------------------------------------------------------------------------------------------------- |
| `add "description" [category] [priority]` | Add a new task. Category and priority are optional. Default: category=`General`, priority=`MEDIUM`. |
| `list`                                    | List all tasks in the order they were added.                                                        |
| `listcat <category>`                      | List tasks by category.                                                                             |
| `done <taskNumber>`                       | Mark a task as done (✔).                                                                            |
| `delete <taskNumber>`                     | Delete a task.                                                                                      |
| `help`                                    | Show available commands.                                                                            |

---

## 🖍 Priority Levels

| Priority | Color     | Value         |
| -------- | --------- | ------------- |
| HIGH     | 🔴 Red    | 1             |
| MEDIUM   | 🟡 Yellow | 2 *(default)* |
| LOW      | 🟢 Green  | 3             |

---

## 📂 Storage

* All tasks are saved in `tasks.json` inside `ET3Challenge`.
* The file is automatically created if it doesn’t exist.

---

## 💻 Examples

Add a task with default category/priority:

```bash
"C:\Program Files\Java\jdk-21\bin\java.exe" -cp "out/production/ET3Challenge;gson-2.10.1.jar" Main add "Buy milk"
```

Add a task with category and priority:

```bash
"C:\Program Files\Java\jdk-21\bin\java.exe" -cp "out/production/ET3Challenge;gson-2.10.1.jar" Main add "Finish report" Work HIGH
```

List all tasks:

```bash
"C:\Program Files\Java\jdk-21\bin\java.exe" -cp "out/production/ET3Challenge;gson-2.10.1.jar" Main list
```

Mark a task as done:

```bash
"C:\Program Files\Java\jdk-21\bin\java.exe" -cp "out/production/ET3Challenge;gson-2.10.1.jar" Main done 1
```

Delete a task:

```bash
"C:\Program Files\Java\jdk-21\bin\java.exe" -cp "out/production/ET3Challenge;gson-2.10.1.jar" Main delete 2
```

---
## Example Execution Output
1. **Listing All Tasks**
   
   Displays all tasks in the list with their categories, priorities, and creation timestamps.
   <img width="1504" height="754" alt="Screenshot (884)" src="https://github.com/user-attachments/assets/e9b3600d-a794-4cb8-9536-fe2fbb8d8d7d" />

2. **Listing Tasks by Category**
   
   Shows only the tasks belonging to a specific category.
   <img width="1547" height="794" alt="Screenshot 2025-08-12 205638" src="https://github.com/user-attachments/assets/c978220f-34d1-427f-a29f-923df3f784b7" />

3. **Adding Tasks**
   
   3.1 **Adding a Task with a Specific Category (default priority: Medium)**
   
     Adds a task while specifying its category, leaving the priority at the default Medium level.
     <img width="1508" height="779" alt="Screenshot 2025-08-12 210033" src="https://github.com/user-attachments/assets/c318e057-56dc-4218-bcca-d13092d590fb" />
   3.2 **Adding a Task with a Specific Priority (default category: General)**

     Adds a task while specifying the priority, leaving the category at the default General.
     <img width="1485" height="772" alt="Screenshot 2025-08-12 210118" src="https://github.com/user-attachments/assets/a9da2b09-d848-43c6-814b-151c6c97f20b" />

4. **Marking a Task as Completed**

     Marks a task as done, updating its status in the task list.
     <img width="1450" height="743" alt="Screenshot 2025-08-12 210651" src="https://github.com/user-attachments/assets/364cc3f6-983e-46b4-b9a2-a37b56e421c8" />

5. **Deleting a Task**

    Removes a task permanently from the task list.
    <img width="1469" height="755" alt="Screenshot 2025-08-12 210822" src="https://github.com/user-attachments/assets/20c22082-f6bb-4f11-b31a-c74632a7fc90" />





