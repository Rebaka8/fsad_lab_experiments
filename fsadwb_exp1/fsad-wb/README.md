# SKILL - 1 : Git Version Control

## Aim

To learn basic Git commands and understand version control using Git and GitHub.

## Tools Used

* Git
* GitHub
* Java

## Description

In this experiment, Git version control commands were practiced using a simple **Task Manager Java program**.
The program allows the user to add tasks, view tasks, and mark tasks as completed.
Through this program, we explained how Git tracks files, commits changes, and manages project versions.

## Files

* `Main.java` – Task Manager program
* `notes.txt` – Notes related to Git commands

## Git Commands Used

Initialize repository

```bash
git init
```

Check repository status

```bash
git status
```

Add files to staging area

```bash
git add Main.java
git add notes.txt
```

Commit files

```bash
git commit -m "Initial commit"
```

Push to GitHub

```bash
git remote add origin <repository-url>
git push -u origin main
```

Branch creation

```bash
git branch feature-update
git branch bug-fix
```

Merge branches

```bash
git merge feature-update
git merge bug-fix
```

## Sample Output

```
--- Task Manager ---
1. Add Task
2. View Tasks
3. Mark Task Completed
4. Exit
Enter choice: 1

Enter task title: Complete Git Experiment
Task added successfully.

--- Task Manager ---
1. Add Task
2. View Tasks
3. Mark Task Completed
4. Exit
Enter choice: 2

1. [ ] Complete Git Experiment

--- Task Manager ---
Enter choice: 3
Enter task number to mark complete: 1

Task marked as completed.
```

## Result

Successfully practiced Git version control commands and pushed the project to GitHub by explaining them through a simple Task Manager program.
