## Installing java:

## Running your first Java program:

### Simple Hello World:

1. Create a folder on `Desktop`, lets call it `JavaApp`, so the final path would be something like
   this - `C:\Users\UserName\Desktop\JavaApp`
2. Create a text file called `Hello.java` inside folder. You can use any text editor - Notepad++ will be fine.
3. Write the following code into the file:
   ```java
   public class Hello {
      public static void main(String[] args) { 
        System.out.println("Hello world !!!"); 
      }
   }
   ```
   <b>Please note that <u>fileName.java</u> should match class <u>Name</u></b>
4. Save the file. Open terminal and navigate to the folder where the file was created. To navigate you can use two options:
    * Open RUN terminal window (WIN + R), type `cmd` hit enter. Black command prompt window should open. The opened path should be
      something like this: `C:\Users\UserName>`. Navigate to the created folder by typing command `cd ~/Desktop/JavaApp`. You will
      see that path have changed. Type `dir` command to see the content of the folder. You should see one file in the
      list - `Hello.java`
    * Navigate in Windows explorer to the folder. In folders address bar replace path with `cmd` and hit Enter. Black command
      prompt window should open. Opened path should be already in that folder something like
      this: `C:\Users\UserName\Desktop\JavaApp>`. Type `dir` command to see the content of the folder. You should see one file in
      the list - `Hello.java`
5. Call the compiler and compile the .java file with the following command `javac Hello.java`. When finished type once
   again `dir`, now you should see two Hello files with `.class` and `.java` extensions.
6. Run the .class file with the following command `java Hello`. <b>Please note you don't have to specify which Hello file
   extension to run. Java will handle this on her own</b>
7. In terminal output you should see printed line - `Hello World !!!`. Your first java app created and ran successfully.

### Java app with input arguments:

8. Create in a folder new text file called `HelloWithArguments.java`.
9. Write the following code into the file:
   ```java
   public class HelloWithArguments {
        public static void main(String[] args) {
           System.out.println("Hello " + args[0] + " !!!");
        }
   }
   ```
   <b>Please note that <u>fileName.java</u> should match class <u>Name</u></b>
10. Save file. Repeat previous steps to open folder in terminal. Now when you type `dir`, 3 files should be visible in the folder.
11. Compile new file by typing `javac HelloWithArguments.java`. The new `.class` file should be created in the folder.
12. Run the .class file with the following command `java HelloWithArguments John`. <b>Please note <u>add argument this time !</u>
    also you don't have to specify which extension to run. </b>
13. In terminal output you should see printed line - `Hello John !!!`.

## Installing Intellij IDEA:
