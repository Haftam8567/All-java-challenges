# Chapter 2 Challenge: The Applet Archaeologist

## 1. SECURITY:
Based on the Java "sandbox" model, an applet cannot:
- Access local files on the user's computer (for example, reading or writing to C: drive).
- Connect to any network server other than the one it was downloaded from (to prevent malicious network access).

## 2. MODERN REPLACEMENT:
The combination of HTML, CSS, and JavaScript has completely replaced Java Applets.
Example: A simple bouncing text animation using modern web tech.

**HTML:**
```html
<p id="text">Hello World</p>
```

**CSS:**
```css
#text {
    position: relative;
    animation: bounce 2s linear infinite;
}

@keyframes bounce {
    0% { left: 0; }
    100% { left: 300px; }
}
```

JavaScript is not even required for this simple animation, but could be used for interactivity or dynamic updates.

## 3. LEGACY:
It is still important for developers to know what applets are because:
- Many older enterprise systems or educational materials reference applets.
- Understanding applets helps in learning about the history of client-side Java, browser security models, and the evolution toward web standards like HTML5 and JavaScript.
