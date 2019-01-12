# TeamWork-SpaceGame



[OOP Teamwork Assignment](https://gitlab.com/Angerfist/teamwork-spacegame/blob/master/Space%20OOP%20Teamwork%20Assignment.docx)

[Trello](https://trello.com/b/nmXMBkkk/oop-timniki)


Project Description

Background:
Over the last decade, humanity has discovered thousands of exoplanets thanks to the Keppler and TESS missions.  Some of these planets are with environmental conditions similar to those found on Earth. The James Webb Space Telescope will be launched in 2021. In a hypothetical scenario, the new telescope will find a brown dwarf star that will enter our Solar System in 80 years and push the Earth out of orbit. Our planet will become uninhabitable and die frozen as a rogue planet: a world untethered to any star, drifting through the void.

Design and implement turn-based Space Evacuation Management Game (SEMG) Console Application.
Functional Requirements
Application should support turns. Each move represents a calendar year and is called by "next", "turn" or another appropriate word at the discretion of the developers. Time is running in one direction only - forward. The game is divided into two periods. The first period is 80 moves between 2021 and 2100. During this period, ships can be developed and send to the nearby stars. After 2100, the Earth and the orbital infrastructure that produce ships will be destroyed. The second period lasts until year 2500. The goal of a player using the application is to achieve a maximum human population in more than one star system. For convenience, it is possible to introduce additional functionality for the next move (for example, "next 50" can skip 50 years ahead).


List of commands :

1  next

2  load

3  listobjects

4  listships

5  createasteroidfield      example: createasteroidfield AlfaB Alfa blue 4 true true

6  createplanet             example: createplanet AlfaB Alfa blue 1.1 0.9 5 100 4

7  createcolonialship       example: createcolonialship Sail Ark 3000 100000

8  createstarshiprobe       example: createstarshiprobe Sail Dominator 100000

9  createsystemshipguardian example: createsystemshipguardian Rocket 75000 true

10 createsystemshipminning  example: createsystemshipminning Apolo11 75000 true

11 createsystemshipsolar    example: createsystemshipsolar Apolo9 75000 true

12 send                     example: send 0 3

13 lostship                 example: lostship 1

14 listactiveships

15 listlostships

16 listplanets

17 listcolonial

18 exit

******************************************************************************

