# Battle Ship Game P2P Model

For making the game Peer to peer model where they can interact which each other real time, Current implementation can be translated to something like Universal Chess Interface [UCI](https://en.wikipedia.org/wiki/Universal_Chess_Interface). This can be then pass over network  and can be translated by the receiver and UI can be build.

In current implementation. `Player` class have `play` funtion which return the `Position` string where player wants to put the missile. Also once the `Player` class `acceptAttack`, It returns a object encapsulated with change of myBoard states in `AttackResult`.

 These above interaction can be abstracted out to a communication interface and used to communicate within players.
 
 Example
 
 ```html
 Player 1 sends: `A2`
 Player 2 receives: `A2` -> converts to a point -> make a hit on myBoard -> build output `AttackResult`
 Player 2 send: `AttackResult`
 Player 1 receives: `AttackResult` updates the states and wait for player 2
 Player 2 send: `B2`
 Player 1 receives: `B2` -> converts to a point -> make a hit on myBoard -> build output `AttackResult`
 ....... so on
 
 ```
 
 Here `AttackResult ` can also include the next turn and then communication can be minimized
 
 User can keep the opponents myBoard as black box in the starting and keep on updating with response from the opponent side as `a hit`, `miss` or `ship sunk`

 At the same time updating its own board with opponents input.


## Implementation

- Defining a standard interface for sending and receiving commands
	-	It will have the opponent player move (no data here will defines you have to play first)
	- Previous moves result updated from opponent (For the forst move it will be empty)
	- Rest all the move other than above two case will have both the fields

- There will be sockets open on both the machine on some defined port which will be listen by counterpart machine for over the network communication.



## Author

* **Jitendra Kushwaha** - *jitendra.theta@gmail.com* 



