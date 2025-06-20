package Exercise_5_Task_Management_System;

class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    public String toString() {
        return "Task ID: " + taskId + ", Name: " + taskName + ", Status: " + status;
    }
}

class TaskManagement {
    private Task head = null;

    public void addTask(Task newTask) {
        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTask;
        }
        System.out.println("Task added.");
    }

    public Task searchTask(int id) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == id) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void deleteTask(int id) {
        if (head == null) {
            System.out.println("No tasks to delete.");
            return;
        }

        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task deleted.");
            return;
        }

        Task prev = head;
        Task curr = head.next;

        while (curr != null) {
            if (curr.taskId == id) {
                prev.next = curr.next;
                System.out.println("Task deleted.");
                return;
            }
            prev = curr;
            curr = curr.next;
        }

        System.out.println("Task not found.");
    }

    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Task temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

public class Exercise5 {
    public static void main(String[] args) {
        TaskManagement manager = new TaskManagement();

        manager.addTask(new Task(1, "Design UI", "Pending"));
        manager.addTask(new Task(2, "Develop Backend", "In Progress"));
        manager.addTask(new Task(3, "Testing", "Pending"));

        System.out.println("\nAll Tasks:");
        manager.displayTasks();

        System.out.println("\nSearching for Task ID 2:");
        Task result = manager.searchTask(2);
        System.out.println(result != null ? result : "Task not found");

        System.out.println("\nDeleting Task ID 1:");
        manager.deleteTask(1);

        System.out.println("\nTasks after deletion:");
        manager.displayTasks();
    }
}

