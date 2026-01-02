# Chapter1_Challenge_1_4
# ⚙️ The Robust File Config Reader (Exception Handling)

**Project Name:** Chapter1_Challenge_1_4

---

## 📘 Description
This Java program reads and validates a configuration file named **`config.txt`**. The file must contain **two lines**:
1. A number representing the **config version**.
2. A **file path** to be validated.

The program uses **exception handling** to ensure it does not crash under any circumstances. It gracefully handles errors such as missing files, invalid numbers, outdated versions, and invalid paths.

---

## 🧩 Key Concepts Used
- **File I/O** using `BufferedReader` and `FileReader`
- **Multiple Catch Blocks** for handling:
  - `FileNotFoundException`
  - `IOException`
  - `NumberFormatException`
  - Custom Exception for invalid version
- **Throwing Exceptions** (`throw new Exception(...)`)
- **Finally Block** for guaranteed execution
- **Safe Resource Closing**
- **Checked vs. Unchecked Exceptions**

---

## ⚙️ How to Run

1. **Create a file named `config.txt`** in the same directory as your Java program.  
   Example content:


2. **Compile the program:**
```bash
javac Chapter1_Challenge_1_4.java

java Chapter1_Challenge_1_4
