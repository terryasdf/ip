# Terry User Guide

*Terry* is a task manager that allows users to easily view and modify tasks.

## Adding a todo

Simply adds a task to the todo list.

Example: `todo laundry`

```
New task added.
	[T][ ]  laundry
```

## Adding a deadline

Adds a task with a deadline to the todo list.

Example: `ddl homework #1 -by 20250305`

```
New task added.
	[D][ ]  homework #1 <by: 20250305>
```


## Adding an event

Adds a task with a specific starting and ending time.

Example: `event meeting -from 9:00 -to 11:00`

```
New task added.
	[E][ ]  meeting <from: 9:00> <to: 11:00>
```

## Deleting a task

Removes a specific task from the list.

Example: `delete 1` (Delete the first task)
```
Removed the task for you.
	[T][ ]  laundry
```

## Checking tasks

Lists all tasks or filters tasks with a keyword.

Examples:

- `list` (List all tasks in order)
```
Here are your todos.
1.[D][X]  homework #1 <by: 20250305>
2.[E][ ]  meeting <from: 9:00> <to: 11:00>
```

- `find homework` (Find all tasks that contains the word `homework`)
```
Here are your todos.
1.[D][X]  homework #1 <by: 20250305>
```

## Marking/unmarking a task

Changes the status of a task.

Examples:

- `mark 1` (Mark the first task as done)
```
Task marked as done. Nice job.
	[D][X]  homework #1 <by: 20250305>
```

- `unmark 1` (Mark the first task as not done)
```
Task marked as not done.
	[D][ ]  homework #1 <by: 20250305>
```

## Export/Import of tasks

Saves your tasks into a JSON file, which can be modified or loaded.

Examples:
- `save` (Save the tasks into the JSON file)
- `load` (Load the JSON file and put all the tasks into the list)

# Creator
[@terryasdf](https://github.com/terryasdf) studying CS2113 XD

```
                   @                                                            
    .      *%%%%       @                                                        
       %@@%     -@@@        :%                                                  
    :@      :==:   :@@#@@-:                   =                                 
  @@@@@@@@%%% .      -%-:%%@@@@@@@@@@@@@@@=        @                            
       %@#    : %@@@%%%%%%%+             =+%%@@%.      =                        
 ::   @    :-==*@:=@%%.      .:.:::==--:. +@@%%@@@@%                            
    %@  .===   =%@#  : .-===:-:::::-::::            %@@@     -                  
   @% .:--.   @@   :-:@=::.::::::::... :.::   ::-==:    :@@:    *               
   @  --:   *@#: -=-:  % :=+=+:--::::.  .::::..::-:::.     *@@                  
  @=.=-.   @@  % :      ..   =   -: .::::::: +@.::..::---:    @@     .    .=-   
  @.=:   @%%   %  . :==-::=+      :-+*+==:  %@    :.      =-=:  #@:          .  
  @    @%@@  % @.==::::  %%-     :::      %@@  ::::-: @ :--=-=-:  #@= :==:   .  
  @ %@* @% .=% %:  .::  @#  =*+::@-:=-  @@:@= =----:: @.:=--==::-:. @@ .-=      
  @@   *%    @   .:::  %- .-  .@@* .  @@:  @ ::.::  = @...           =@   .     
  .    @% :     ::::: *% .  :@ +    @@    *%    -     @    . :-:=@+.:.:@:  @    
   -+.*@  :.  .:::--.:@   +@  -%  %@    *@@  -=:---=- % :-===-::. @.    @   +   
  :=- @+  . :--:---: %   @    @  @       %* -:::::-:  @  :::: @   .@ .:  @      
     .@  .::-----    % @%%#%@%%@%*     = %= ===-:::: %%@ .::: @  : @+ -= @@     
@@@  @% :-.      .: @=@#@%#  @%%@@#@@    @@     ... :@ @  .   @ .:  @     @   @ 
     @  :. = .::=: :%%%           %@%@%@:=   ..--.  @% @% .:: @ .   %@% : @-  @ 
    %% :-- @:.:::: %%=    @@@@@@@   :@@ :. ::-:   +@=   @ =- *% ::- *%@+  =@  . 
 =: @: ::: @: :::  @.   @@:     -@@   @%@ :=.= @@*%     @    @  . . :@ @.  @  = 
 = +@ :  . %%     @  - %    #*=- *@=    @ :: @   @   .  @ : +@ : .: .@  @ .@  @ 
   %%  .:.  @  := @  : @    ==== #@-  : @   += @%       @   @  -:-- =@  % *%    
#@@@= :-:: .@     %%@  %@****::  @*  -+:%#  % @      @@@@  @- ..:.  =%   :%     
     .=    %%@@% %%%    @@:  ..*@    ::. @ %@    @@@@%  % %@  :     %:   %%     
 ===:   @=+@    * @       :@@@@.         %:%  @@@.      %@@      :  @    %      
     *@%    @      +%@@  -            .   @    @@      %% %  ---=: %%   #       
 =@%+  *:==. @    @      * @#     =%:     %      @@:   : @+ ::::. =@            
        %. :  @  @.    .         #@ =@@@:          @@%   @  :::.  @             
         =    @%@% @@*    . .    @       @@          =  %@  .:: .@              
          @=@@@@%#    @@%       @  . ..   #              %@    +@.   @          
          @@     =%.=:   %@@#  %   :.:.  @                %@  @%   .            
                              *+.       .              #*                       
```