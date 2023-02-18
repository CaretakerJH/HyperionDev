TO RUN ISBNValidator CODE ON A PC, FOLLOW THE STEPS BELOW:


    1. Install a Java Development Kit (JDK) on your PC. If you do not have a JDK installed, you can download the latest version from the Oracle website at https://www.oracle.com/java/technologies/javase-downloads.html. 
       Follow the installation instructions to install the JDK.

    2. Open a text editor or an Integrated Development Environment (IDE) such as Eclipse, Visual Studio Code, or any IDE depending on your preferences.

    3. Open the folder SectionC in the Hyperion folder.

    4. Click on the file "ISBNValidator.java" within the IDE.

    5. Open a command prompt or terminal and navigate to the directory where "ISBNValidator.java" file is located using the cd [Path] command if it isn't already allocated.

    6. Compile the code by entering the command "javac ISBNValidator.java". This will create a class file named "ISBNValidator.class".

    7. Run the code by entering the command "java ISBNValidator" in the command prompt or terminal. The output of the code will be displayed in the console.


ANALYSIS OF WORST-CASE TIME COMPLEXITY OF ISBNCHECK


The worst-case space complexity of this code is O(1), meaning that the amount of memory the program requires does not increase with the size of the input.

This is because the amount of memory used by the program is independent of the size of the input. The only variables used in the program are of fixed size, regardless of the length of the input string. 
In addition, the program only creates a single instance of the HashMap and the totalSum and partialSum variables, which do not increase in size as the input grows.

Therefore, the space complexity of this code is constant, or O(1).