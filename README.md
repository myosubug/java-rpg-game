# LiberatePikachu
CPSC233 T06-G02

Project Name : Liberate Pikachu!

Project Description:

The game that we are planning on making is a game, where Pikachu is trying to escape from Ash and win his freedom. 
Other similar types of games include Pokemon and Zelda. Like in these games, pikachu can move around the map to collect items to help him, and has to fight enemies on the way, before finally fighting the final boss. Our game will be smaller and shorter than these games, but we want to have multiple ‘rooms’ in our map, and multiple types of enemies to fight. Our graphics will also have to be simpler than a full game such as Pokemon or Zelda.


There are two versions: text-version, GUI

Text-version is located at "text-version" folder in this git.
GUI-version is located at "GUI-version" folder in this git.

## How to start text-version:
    
    1. Download the files in https://gitlab.cpsc.ucalgary.ca/sungjong.oh/liberatepikachu/

    2. Unzip the file and locate the folder you unzipped in your command terminal.

    3. Locate your position into "text-version" folder in your command terminal.

    4. Use command "javac TextApp.java" to compile.

    5. Use command "java TextApp" to run the game.

## How to start GUI-version:
    
    1. Download the files in https://gitlab.cpsc.ucalgary.ca/sungjong.oh/liberatepikachu/

    2. Unzip the file and locate the folder you unzipped in your command terminal.

    3. Locate your position into "GUI-version" folder in your command terminal.

    4. Use command "javac GUIApp.java" to compile.

    5. Use command "java GUIApp" to run the game.

## How to run unit test:

In "GUI-version" folder, there is a folder named "testFile"

The folder contains 3 files:
- GUIAppTest.java
- hamcrest-core-1.3.jar
- junit-4.12.jar


* GUIAppTest.java contains unit tests and its descriptions about what parts of application are being tested.


To begin the unit tests for this application, copy all of the 3 files and paste it into "GUI-version" folder (One upper level from "testFile" folder). Then,

1) Locate your position into "GUI-version" folder in your terminal.

2) Copy and paste this command into your terminal and hit enter to compile.

    javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar *.java

3) Copy and paste this command into your terminal and hit enter to run tests.

    java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore GUIAppTest