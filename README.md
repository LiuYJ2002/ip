# Daniel User Guide

Chatbot Daniel is a simple chatbot that helps your manage your tasks and deadline. 
The app provides you with multiple commands to add and manage your task under 3 categories : Todo, Deadline and Event.
## Table of Contents

- [Quick Start](#quick-start)
- [Features](#features)
    - [Add Todo task](#add-todo-task)
    - [Add Deadline task](#add-deadline-task)
    - [Add Event task](#add-event-task)
    - [List All Tasks](#list-all-tasks)
    - [Mark Tasks](#mark-tasks)
    - [Unmark Tasks](#unmark-tasks)
    - [Delete Tasks](#delete-tasks)
    - [Search Tasks](#search-tasks)
    - [Sort Tasks](#sort-tasks)
    - [Exiting the Program](#exiting-the-program)
    - [Saving the Data](#saving-the-data)
- [Command Summary](#command-summary)
## Quick Start
1. Ensure that you have Java 17 or above installed on your computer.
2. Download the latest .jar file from the latest release page
3. Copy the .jar file to a folder you want to use
4. Open a command terminal and navigate to the folder containing the .jar file.
5. Run the following command to start the application:
   ```bash  
   java -jar Daniel.jar  
## Features

### Add Todo task
Add a Todo task to your task list.  
**Format**  
```
todo <x>
```
x is your todo task name  
**Example**  
```
todo borrow book
```
**Expected output**  
```
Got it. I've added this task:
[T][]borrow book
Now you have 1 task in the list.
```
### Add Deadline task
Add a Deadline task to your task list.  
**Format**
```
deadline <x> /by <datetime>
```
x is your todo task name and datetime is in DD/MM/YYYY HHMM  
**Example**
```
deadline return book /by 2/12/2019 1800
```
**Expected output**
```
Got it. I've added this task:
[D][]return book (by: December 02 2019, 6:00PM)
Now you have 2 task in the list.
```
### Add Event task
Add an Event task to your task list.  
**Format**
```
event <x> /from <datetime> /to <datetime>
```
x is your event task name and datetime is in DD/MM/YYYY HHMM 
**Example**
```
event meeting /from 2/12/2019 2200 /to 2/12/2019 2300
```
**Expected output**
```
Got it. I've added this task:
[E][]meeting (from: December 02 2019, 10:00PM to: December 2019, 11:00PM)
Now you have 3 task in the list.
```

### List all tasks
List all tasks you have added
**Format**
```
list
```
**Example**
```
list
```
**Expected output**
```
Here are the tasks in your list:
1.[T][]borrow book
2.[D][]return book (by: December 02 2019, 6:00PM)
3.[E][]meeting (from: December 02 2019, 10:00PM to: December 2019, 11:00PM)
```
### mark tasks
mark tasks you have added
**Format**
```
mark <index>
```
index refers to the order in which the tasks are added. You can check the index by the list command.  
**Example**
```
mark 1
```
**Expected output**
```
Nice I have marked this task as done:
[T][X]borrow book
```
### unmark tasks
unmark tasks you have marked
**Format**
```
umark <index>
```
index refers to the order in which the tasks are added. You can check the index by the list command.  
**Example**
```
umark 1
```
**Expected output**
```
OK, I've marked this task as not done yet:
[T][]borrow book
```
### delete tasks
delete tasks you have added
**Format**
```
delete <index>
```
index refers to the order in which the tasks are added. You can check the index by the list command.  
**Example**
```
delete 1
```
**Expected output**
```
Noted. I've removed this task:
[T][]borrow book
Now you have 2 tasks in the list.
```
### Search tasks 
search for tasks you have added
**Format**
```
find <keyword>
```
keyword is what to search for in task description  
**Example**
```
search meeting
```
**Expected output**
```
Here are the tasks in your list:
1.[E][]meeting (from: December 02 2019, 10:00PM to: December 2019, 11:00PM)
```
### Sort tasks
sort task you have added by time. Todo task always appear last by index order and event task are sorted by start time.
**Format**
```
sort
```
**Example**
```
sort
```
**Expected output**
```
After sorting Here are the tasks in your list
1.[D][]return book (by: December 02 2019, 6:00PM)
2.[E][]meeting (from: December 02 2019, 10:00PM to: December 2019, 11:00PM)
```
### Exiting the program
exit the app
**Format**
```
bye
```
**Example**
```
bye
```
**Expected output**  
app will close automatically
### Saving the data
Data are saved in the data/daniel.txt automatically after any command that changes the data. There is no need to save manually.
## Command summary  
| Action            | Format                                        | Example                                          |
|-------------------|-----------------------------------------------|--------------------------------------------------|
| Add Todo task     | `todo <x>`                                    | `todo borrow book`                              |
| Add Deadline task | `deadline <x> /by <datetime>`                 | `deadline return book /by 2/12/2019 1800`       |
| Add Event task    | `event <x> /from <datetime> /to <datetime>`   | `event meeting /from 2/12/2019 2200 /to 2/12/2019 2300` |
| List all tasks    | `list`                                         | `list`                                           |
| Mark tasks        | `mark <index>`                                | `mark 1`                                        |
| Unmark tasks      | `umark <index>`                               | `umark 1`                                       |
| Delete tasks      | `delete <index>`                              | `delete 1`                                      |
| Search tasks      | `find <keyword>`                              | `find meeting`                                  |
| Sort tasks        | `sort`                                        | `sort`  
