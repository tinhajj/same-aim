# same-aim

A tool to help find relative mouse sensitivities between two 3d games

![Screenshot](https://i.imgur.com/K5qtWSP.png "Application Screenshot")



Install Instructions
* Ensure you have java installed and it is in your path/environment variables somewhere
* Go to the releases page and download the latest release.  The zip is generally for windows and the tar is generally for mac/linux.
* Run same-aim.bat for windows or same-aim for mac/linux.
    * If you are on windows and you only see a prompt open and close very quickly, then you most likely do not have java in your path
    * You can execute same-aim.bat from a terminal like powershell or cmd to see exactly what the error is

Primarily works by:
* setting up a hotkey to move left, down, and reseting the counter.
* using the left hotkey to move counter clockwise 360 degrees in one game and noting the counter
* doing the same process in another game with the goal of getting the same counter value from first game adjusting ingame sensitivity as necessary

Ex.  I do a 360 in turn in game 1 and note my counter value is 500.  I go into game 2 and do a 360 and note my counter value is 600.  This means my sensitivity in game 1 is higher than my sensitivity in game 2 (this slightly unintuitive).  If I increase my ingame sensitivity in game 2 and do another 360 my counter value will be lower than the previous 600 value.  I repeat this process until my counter values are both 500.

This same process can be done for the y axix using the down hotkey.  In this case you would be doing 180 degree turns on the y axis, but this can only work between games that allow you to aim directly above and below your character
