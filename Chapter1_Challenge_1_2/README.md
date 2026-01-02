# Chapter1_Challenge_1_2
# 🎟️ Lottery Number Analyzer (Arrays & Strings)

**Project Name:** Chapter1_Challenge_1_2

---

## 📘 Description
This Java program analyzes a list of weekly winning lottery numbers. Each number is stored as a string in the format `"XX-XX-XX-XX-XX"`. The program:

1. Removes dashes to form a continuous string of digits.
2. Converts the string into an array of integers.
3. Calculates the sum and average of the digits.
4. Determines which winning number has the highest average digit value.
5. Displays a formatted table of analysis and announces the top ticket.

This challenge demonstrates **arrays, string manipulation, for & for-each loops, and type conversion** in Java.

---

## 🧩 Key Concepts Used
- Arrays (`String[]`, `int[]`)
- For loop & For-each loop
- `String.replace()` to remove dashes
- `Character.getNumericValue()` for converting char to int
- Calculation of sum and average
- Formatted output using `System.out.printf()`

---

## ⚙️ How to Run

1. **Compile the program:**
```bash
javac Chapter1_Challenge_1_2.java

java Chapter1_Challenge_1_2


Ticket               Digit Sum   Digit Average
-----------------------------------------------
12-34-56-78-90       45          4.50        
33-44-11-66-22       30          3.00        
01-02-03-04-05       15          1.50        

The winning number with the highest average is: 12-34-56-78-90 with an average of 4.5
