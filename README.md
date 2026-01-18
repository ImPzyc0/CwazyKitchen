A 4-People Multiplayer game, simulating a running kitchen, where you have to do orders to get points.
Connect the client to the server, then create a room, and give the room number (Top of the window) to the other players. 
Made as a final project for my CS class.

The idea is simple: In the given time, you have to work the stations, get the tickets, make the food (Dont let it get cold!), put everything on a 
tray and bring it to the ticket station - depending on your performance you will get points.
This is based on the GPanel Sprite API, and the Server/Client code given from the CS class
-> Basically just sending Strings

The code is quite a lot, but some features worth mentioning:
- Custom API for the graphics, hitboxes, positions, updating them etc. The API brings the jar for the graphics given to me by my CS teacher to its knees
- All Network traffic is handled by enumerators: The Name of the packet correlates with the enumerator, which then automatically redirects the data.
- A Constants Interface, where everything can be changed easily (Important: FPS, scale of the window and cooking times.)
- 
