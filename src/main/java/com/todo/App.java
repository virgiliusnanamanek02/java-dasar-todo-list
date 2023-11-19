package com.todo;

// import java.lang.Integer;
import java.util.Scanner;

public class App {
    public static String[] model = new String[10];
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static void showTodoList() {
        for (int i = 0; i < model.length; i++) {
            String todo = model[i];
            int num = i + 1;

            if (todo != null) {
                System.out.println(num + ". " + todo);
            }
        }
    }

    public static void addTodoList(String todo) {

        boolean isFull = false;

        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                isFull = false;
                break;
            }
        }

        if (isFull) {
            String[] temp = model;

            model = new String[model.length * 1];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static boolean removeTodoList(Integer number) {
        if ((number - 1) >= model.length || model[number - 1] == null) {
            return false;
        }

        for (int i = number - 1; i < model.length; i++) {
            if (i == model.length - 1) {
                model[i] = null;
            } else {
                model[i] = model[i + 1];
            }
        }
        return true;
    }

    public static String input(String info) {

        System.out.print(info + ": ");
        String data = scanner.nextLine();

        return data;
    }

    public static void viewShowTodoList() {

        while (true) {
            showTodoList();

            System.out.println("MENU: ");
            System.out.println("1. Add new task");
            System.out.println("2. Remove task");
            System.out.println("x. Exit");

            String input = input("Choose the menu");

            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.err.println("Confusion choise!");
            }

        }

    }

    public static void viewAddTodoList() {

        System.err.println("Add new tasks");

        String todo = input("Add todo");

        if (!todo.equals("x")) {
            addTodoList(todo);
        }

    }

    public static void viewRemoveTodoList() {

        System.err.println("Remove new tasks");

        String number = input("Remove task");

        if (!number.equals("x")) {
            boolean success = removeTodoList(Integer.valueOf(number));

            if (!success) {
                System.err.println("Failed to remove tasks at: " + number);
            }
        }

    }

}
