package Week1.DataStructures.Exercise5;

class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public String toString() {
        return "ID: " + taskId + ", Name: " + taskName + ", Status: " + status;
    }
}

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

class TaskLinkedList {
    private Node head;

    // Add task at end
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
        System.out.println("Task added.");
    }

    // Search by taskId
    public Task searchTask(int taskId) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.taskId == taskId) return temp.task;
            temp = temp.next;
        }
        return null;
    }

    // Traverse all tasks
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }

    // Delete task by taskId
    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("No tasks to delete.");
            return;
        }

        if (head.task.taskId == taskId) {
            head = head.next;
            System.out.println("Task deleted.");
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.task.taskId != taskId) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Task not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Task deleted.");
        }
    }
}

public class Exercise5 {
    public static void main(String[] args) {
        TaskLinkedList list = new TaskLinkedList();

        list.addTask(new Task(1, "Design UI", "Pending"));
        list.addTask(new Task(2, "Implement Backend", "In Progress"));
        list.addTask(new Task(3, "Write Tests", "Pending"));

        System.out.println("\nAll Tasks:");
        list.displayTasks();

        System.out.println("\nSearch for Task ID 2:");
        Task found = list.searchTask(2);
        System.out.println(found != null ? found : "Task not found");

        System.out.println("\nDelete Task ID 2:");
        list.deleteTask(2);

        System.out.println("\nTasks After Deletion:");
        list.displayTasks();
    }
}
