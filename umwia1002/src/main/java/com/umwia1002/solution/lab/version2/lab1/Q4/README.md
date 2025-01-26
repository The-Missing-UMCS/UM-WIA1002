# Solution Explanation

## Version 1
Contributor: Faker000000000

The idea behind this version is to use a 2-dimensional boolean array to "paint" the character out. We have created several methods in the `ConsoleCharacter.java` file, such as `.plotVerticalLine()` and `.plotHorizontalLine()`, to simplify the process.

For illustration, consider the following 2-dimensional boolean array:

```python
{{' ', ' ', ' ', ' ', ' '},
 {' ', ' ', ' ', ' ', ' '},
 {' ', ' ', ' ', ' ', ' '},
 {' ', ' ', ' ', ' ', ' '},
 {' ', ' ', ' ', ' ', ' '}}
```
If we want to print the letter "A", the boolean array will be:

```python
{{' ', ' ', '*', ' ', ' '},
 {' ', '*', ' ', '*', ' '},
 {' ', '*', '*', '*', ' '},
 {' ', '*', ' ', '*', ' '},
 {' ', '*', ' ', '*', ' '}}
```

Here, the initial value of the boolean array is false, and we use ' ' to represent false and '*' to represent true. To plot the "A", we can write the following code:

```java
arr[0][2] = true;
arr[1][1] = arr[1][3] = true;
arr[2][1] = arr[2][2] = arr[2][3] = true;
arr[3][1] = arr[3][3] = true;
arr[4][1] = arr[3][3] = true;
```
However, plotting a dot one by one is time-consuming, hence we have written some methods such as:

```java
protected void plotVerticalLine(boolean[][] buff, int startRow, int endRow, int column) {
	for(int i = startRow; i <= endRow; i++) 
		buff[i][column] = true;
}
```
`.plotVerticalLine()` takes four parameters, namely `buff`, `startRow`, `endRow`, and `column`. The method plots at the specified `column` and plots from `startRow` to `endRow`, inclusively.

## Version 2

Version 2 of the code represents a refined approach compared to Version 1. In Version 1, a 2-dimensional boolean array was used to plot the characters, whereas in Version 2, a `String` and `.toCharArray()` were utilized instead. This new approach offers several advantages such as better maintainability, readability, and improved time complexity.

For instance, consider how the character "A" was plotted in Version 1:

```java
public boolean[][] getUppercase() {
	int column = 5;
	boolean[][] buff = getBuff(column + 2);
	plotVerticalLines(buff, 1, ROW - 1, new int[] {1, 5});
	plotHorizontalLines(buff, 2, 4, new int[] {0, 2});		
	return buff;
}
```
 
In contrast, Version 2 handles the character "A" with the following code:

```java
public A() {
	this.ascii = 
		"  *  \n" +
		" * * \n" +
		"*****\n" +
		"*   *\n" +
		"*   *";
}
```
The 2-dimensional array is obtained as follows:

```java
private void initialize(int space) {
	String[] lines = ascii.split("\n");
	int size = lines[0].length();
	this.character = new char[DEFAULT_HEIGHT][size + space * 2];
	for(int i = 0; i < DEFAULT_HEIGHT; i++) 
		System.arraycopy(lines[i].toCharArray(), 0, character[i], 1, size);
}

public char[][] getCharacter() {
	if (character == null)
		initialize();
	return character;
}
```
Since it is a time-consuming task to write ASCII code for all the characters (A-Z), the generation of the ASCII code was outsourced to [ChatGPT](https://chat.openai.com/chat), which produced the code for the characters.

Furthermore, to adhere to good programming practices, the initialize method and getCharacter method have been separated from the A class as they are not part of the class but rather helper methods.

The prompt used is as followed:

```css
public A() {
	this.ascii = 
		"  *  \n" +
		" * * \n" +
		"*****\n" +
		"*   *\n" +
		"*   *";
	}
}
Can you please refer to the code and write the Java class for character B through Z?
```

## Version 3

Contributor: [Website](https://www.quickprogrammingtips.com/java/ascii-art-generator-library-in-java.html)

We referred to the website above and wrote a `Banner.java` file to simplify the use of the method. The `Banner.java` file provides better control over the size, color, and font family of the message.

</br>

# Overall Guidance

To try out different versions of code, follow these steps:

1. Copy the source file to your project location.
2. Instantiate a `Banner` object in your `Main.java` file.
3. Call the `.print(String message)` method on the `Banner` object.
4. Pass the message that you want to print to the console as an argument to the method.

For Versions 1 and 2, you need to add `commons-lang3-3.12.0.jar` to your classpath. Follow these steps to add the JAR file:

1. Download the `commons-lang3-3.12.0.jar` file included in the [Lab1Q4 folder](https://github.com/fyiernzy/UM-WIA1002/blob/main/Version2/Lab1%20-%20Object%20Oriented%20Programming/Q4/commons-lang3-3.12.0.jar).
2. Add the `commons-lang3-3.12.0.jar` file to your classpath. For more details, please refer to the following resources:
  
  a. Eclipse: [How to Import a Jar File in Eclipse](https://www.janbasktraining.com/community/sql-server/how-to-import-a-jar-file-in-eclipse)
  
  b. NetBeans: [How to Add External JAR File in NetBeans Project?](https://www.foxinfotech.org/how-to-add-external-jar-file-in-netbeans-project)
  
  c. IntelliJ: [How to Add External JAR File to an IntelliJ IDEA Project?](https://www.geeksforgeeks.org/how-to-add-external-jar-file-to-an-intellij-idea-project/)"



