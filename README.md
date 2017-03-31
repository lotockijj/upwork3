Write a Java application which allows to enter information about an image to be displayed. Then, it displays the image. Images for both input and output windows are below. 
Use any simple SWING layout managers, such as FlowLayout, BorderLayout, and GridLayout to create the SWING GUI of this application.  (You don’t have to position all elements in the same order)
The user will enter name, shape, what to color, color of line, color of fill. 
Use appropriate controls to request data from the user:
•	The shape should be selected from radio buttons. 
•	A combo box should display the colors for line of the shape. The user should be able to select one field only.
•	Color of the fill is in JList and it should allow user to select one value.
•	What to be colored can be selected from a group of check boxes.
•	For Background color use any color you want (user does not have a choice)
All the drawing should appear in a separate window. This window should display name, draw the image and display information about the image in the TextArea. Classes to draw shapes will be provided.
Hint: to implement colors you can create two arrays one with string values and one of the Color class. When user would select the color you can 
get the index of that element and pick up corresponding Color from the other array at the same index position.
Main window should exit application if user closes it. Response (output window) should only close/dispose itself but not exit the application.
Below are the classes I had in the end for exercise 1. You might be different depending on how you implement things. This is just an example for those who do not know where to start.

Develop the same application as in exercise 1. Use JavaFX for building the UI.
Use simple JavaFX layout managers, such as FlowPane, BorderPane, and GridPane to create the JavaFX GUI of this application.
