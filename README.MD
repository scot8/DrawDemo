# Draw Demo

DrawDemo is a customizable drawing application for Android. It allows users to draw on the screen with different colors, stroke widths, and styles. The app supports dotted and dashed lines through the use of a `DashPathEffect`.

## Features

- Customizable drawing canvas
- Support for different colors, stroke widths, and styles
- Dotted and dashed lines
- Clear canvas functionality

## Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/Scot8/DrawDemo.git
    ```
2. Open the project in Android Studio.
3. Build and run the project on an Android device or emulator.

## Usage

### Drawing

- Touch the screen to start drawing.
- Move your finger to draw lines.
- Lift your finger to stop drawing.

### Changing Color

- Use the color buttons to change the drawing color.
- Use the custom color input fields to set a specific color.

### Changing Stroke Width

- Use the stroke width buttons to change the drawing stroke width.

### Changing Style

- Use the style buttons to change between fill and stroke styles.
- Use the line style buttons to switch between solid, dashed, and dotted lines.

### Clearing the Canvas

- Use the clear button to clear the drawing canvas.

## Code Overview

### `DrawView.java`

- Custom `View` class for drawing.
- Manages the drawing paths, colors, stroke widths, and styles.

### `PathX.java`

- Custom `Path` class that includes a `Paint` object for styling.

### `MainActivity.java`

- Main activity that sets up the user interface and handles user interactions.

## License

This project is licensed under the MIT License.
```
