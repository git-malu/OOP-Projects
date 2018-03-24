**Project HW08 is created by Gengwu Li and Zhaohan Jia** 

To run the program, simply run MainController.launch in the root folder.

This homework is all about creating a chat application and it also involves
a lot of communication and coorperatioin.

Two very important things.

First is having multiple MVCs in the system.
	For single MVC, we instantiate model and view and using two adapters to
	bridge the model and view and build smooth communication between these two.
	So the model and view only know a small portion of each other thus maintain
	the encapsulation. 
	
	For multiple MVC, we have one main MVC and build multiple sub MVCs in it.
	Besides connection between main model and view, between mini model and view,
	we also need to connection between mini MVCs and main MVC. Just like the
	techniques we use to connect model and view, we use adapters to build
	connection between main MVC and sub MVCs. And also like the usage of anonymous
	inner class, we use anynomous inner class inside anynomous class.
	So for mini MVC, it can access the main MVC by enclosure. And we can use
	adapters for every situation when we need to connect two independent object
	and using anonymous inner class as a result.

Second is extended visitor design pattern. 
	First we have a host, and in its execute function, we pass a algorithm,
	with the algorithm, it searches throught its data base for corrispondent
	command using case at, and with the retrieved command, we call the apply
	type, passing the host, the data type and additional parameters. 
	
	So for unknown message type, the default command is being called, the receiver
	of the message will send a request to the sender for relative command,
	the sender then marshalls the relative command to process the unknown message.
	In the receiver, the cmd to model adapter is being set first, and the message
	is then being processed.
	
DESIGN IS IMPORTANT, WITHOUT IT, YOU ARE JUST MESSING AROUND!!!!!!
	

