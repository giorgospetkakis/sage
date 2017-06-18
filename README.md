 # SAGE
_A Semantics Platform for Steam_

The purpose of Sage is to gain better insight of the [Steam Community](http://community.steampowered.com/) and attempt to provide more informed game recommendations through the Steam Store.

### The Premise
Sage began as an exploratory research project in early 2017, with the task of collecting information through the Steam API and manipulating it into some useful conclusion. The initial verdict was that people tend to buy a lot more games than they play. Every game, even the ones most popular in the given community sample, had an overwhelming number of players who had bought the game and never played it. Even more so never installed it once.

### The Task
This data spawned a number of new questions. 

First, why is this happening? Why are so many people buying games that they never play? This trend not only impedes the collection of meaningful data about the game, as the outliers are, in fact, the overwhelming majority, but may also be hurting the developers who may not be getting the right people to buy their games. We all have heard of the notorious [backlog](http://www.craveonline.com/culture/181159-10-tips-for-putting-a-dent-in-your-gaming-backlog)- a personal stockpile of unplayed games that may or may not be ever played.

The task at hand is to make this game-player relationship better through Steam.

_The initial **Perl** + **bash** project can be found [here](https://github.com/giorgospetkakis/steam-scraper/)._

### Current Status
The first task at hand is to design the basic ontology that will support the entire player network. Once the data is organized in a meaningful way, the platform will be able to draw inferences and manipulate player data. Two primary concepts of the design are an efficient Player Similarity metric and through that a way to dynamically group players according to their play patterns.