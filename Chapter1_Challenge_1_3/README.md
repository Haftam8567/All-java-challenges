# Chapter1_Challenge_1_3
# 🏰 The Dungeon Game (Decision & Repetition)

**Project Name:** Chapter1_Challenge_1_3

---

## 📘 Description
This Java program simulates a simple **text-based dungeon adventure**. The player navigates through **5 rooms**, facing random events in each room. The goal is to survive all rooms and finish the dungeon with positive health.

**Gameplay Mechanics:**
1. Player starts with **100 health**.
2. Each room triggers a **random event**:
   - **Trap**: Player loses 20 health.
   - **Healing potion**: Player gains 15 health (capped at 100).
   - **Monster**: Player must guess a number (1-5) to defeat it. Uses a `do-while` loop to keep guessing until correct.
3. Player’s health is updated after each room.
4. If health reaches 0 or below, the player is **defeated**.
5. Surviving all 5 rooms results in **victory**, showing final health.

---

## 🧩 Key Concepts Used
- `for` loop for navigating rooms.
- `switch` statement for handling events.
- `do-while` loop for monster guessing.
- Random number generation using `Random`.
- Input handling with `Scanner`.
- Conditional logic and `break` statement for early exit.

---

## ⚙️ How to Run

1. **Compile the program:**
```bash
javac Chapter1_Challenge_1_3.java

java Chapter1_Challenge_1_3


Entering room 1...
You found a healing potion! Health is now 100.
Current health: 100

Entering room 2...
A monster appears! Guess a number (1-5) to defeat it: 3
Wrong! Try again: 2
Wrong! Try again: 5
You defeated the monster!

Entering room 3...
A trap sprung! Health is now 80.
Current health: 80

Entering room 4...
You found a healing potion! Health is now 95.
Current health: 95

Entering room 5...
A monster appears! Guess a number (1-5) to defeat it: 1
You defeated the monster!

You cleared the dungeon! Victorious with 95 health!
