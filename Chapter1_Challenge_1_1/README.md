# Chapter1_Challenge_1_1
# 🕵️ Secret Agent Decryption

This Java program simulates a **secret agent decryption system** that takes a secret number as input and generates a decrypted code based on digit manipulation.

## 📘 Description
The program reads a secret number, extracts specific digits, performs mathematical operations, and outputs a decrypted code. It multiplies the **first and last digits**, adds the **second and second-last digits**, and combines the two results to form the final code.

## 🧮 Example
**Input:**
Enter the secret number: 57342


**Process:**
- First digit = 5  
- Last digit = 2  
- Second digit = 7  
- Second-last digit = 4  
- Product = 5 × 2 = 10  
- Sum = 7 + 4 = 11  

**Output:**


## ⚙️ How It Works
1. Input the secret number.
2. Count the number of digits.
3. Extract the first, second, second-last, and last digits.
4. Multiply the first and last digits.
5. Add the second and second-last digits.
6. Combine both results as a string to form the decrypted code.

## 🖥️ How to Run
### 1. Compile the program
```bash
javac SecretAgentDecryption.java

java SecretAgentDecryption


