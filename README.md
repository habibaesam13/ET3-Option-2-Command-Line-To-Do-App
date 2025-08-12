
# 📋 Java Task Manager CLI

A lightweight, command-line task management application built in Java.  
Supports **categories**, **priorities**, and **persistent storage** (via JSON).  
Tasks are displayed in the **order they were added**.

---

## ✨ Features

- Add tasks with optional **category** and **priority**.
- Mark tasks as **done**.
- Delete tasks.
- List all tasks **in insertion order**.
- List tasks filtered by category.
- **Persistent storage** using JSON (via [Gson](https://github.com/google/gson)).
- Colored output based on priority:
  - 🔴 **HIGH** — Red
  - 🟡 **MEDIUM** — Yellow
  - 🟢 **LOW** — Green

---

## 📦 Requirements

- **Java 21** or higher  
- **Gson 2.10.1** (or compatible version)

## 🔧 Installation

1. **Clone this repository**:

   ```bash
   git clone https://github.com/habibaesam13/ET3-Option-2-Command-Line-To-Do-App.git
   cd ET3-Option-2-Command-Line-To-Do-App
    ````

2. **Place the Gson JAR** inside your `ET3Challenge` directory:
    ```bash
       * Download from [Gson Releases](https://github.com/google/gson/releases)
       * Save as `ET3Challenge/gson-2.10.1.jar`
    ````
3. **Compile**:

   ```bash
   javac -cp "ET3Challenge/gson-2.10.1.jar" -d ET3Challenge/out/production/ET3Challenge ET3Challenge/src/*.java
   ```

---

## 🚀 Usage

Run from the project root:

```bash
java -cp "ET3Challenge/out/production/ET3Challenge;ET3Challenge/gson-2.10.1.jar" Main <command> [arguments]
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
java -cp "ET3Challenge/out/production/ET3Challenge;ET3Challenge/gson-2.10.1.jar" Main add "Buy milk"
```

Add a task with category and priority:

```bash
java -cp "ET3Challenge/out/production/ET3Challenge;ET3Challenge/gson-2.10.1.jar" Main add "Finish report" Work HIGH
```

List all tasks:

```bash
java -cp "ET3Challenge/out/production/ET3Challenge;ET3Challenge/gson-2.10.1.jar" Main list
```

Mark a task as done:

```bash
java -cp "ET3Challenge/out/production/ET3Challenge;ET3Challenge/gson-2.10.1.jar" Main done 1
```

Delete a task:

```bash
java -cp "ET3Challenge/out/production/ET3Challenge;ET3Challenge/gson-2.10.1.jar" Main delete 2
```

---

## 🛠 Development Notes

* Tasks are **not** sorted by priority in this version — they appear in the **order you added them**.
* Colored terminal output works in most Unix-based terminals and Windows PowerShell.

