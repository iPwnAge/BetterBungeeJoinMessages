#BetterBungeeJoinMessages

##Or, "stop spamming my chat box, man": join messages edition.


There are quite a few Bungee plugins that broadcast to all the servers in a Bungee network when a player joins. However, because many of them only rely on the onPostLogin() event thrown by Bungee, these plugins only report a successful connection to Bungee, and before a client actually is connected to a Spigot server. Because of this, clients who come across errors mid-join often spam the chatbox with "X player joined the network, X player left the network". This plugin is two fold: A Bungee plugin, and a Spigot plugin. Together, this ensures the "X player joined the network" is only shown when a player is confirmed to connect to a server. It also mutes server-side join messages.


The plugin relies on three libraries: the Bungee API, the Spigot API, and Google Guava. 
