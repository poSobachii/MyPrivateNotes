launch application; go to http://localhost:8080/

connect by desired nickname ( existing player fetched from DB or created automatically new)

balance is persistent for saved players.

you can insert new player at http://localhost:8080/h2

login with another player in new tab. 

select same game for both players. 

matchmaking might take up to 4 sec.

the game automatically starts when there is min players for particular game

you can PLAY or FOLD based on cards you get.

you have 30 sec to decide, after you will FOLD automatically. (lost connection is not implemnted yet. 
Basically if you leave/lose connection on livegame, the game will continue without you and your choice will be auto fold each round, till the end of game. 
balance still be updated and stored in DB )

balance updates each round/step and after game is finished ( negative balance restrictions is not implemented yet)

after game is finished you can enter another game.
