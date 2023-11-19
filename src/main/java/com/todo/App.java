package com.todo;

// import java.lang.Integer;

public class App {
    public static String[] model = new String[10];

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
        if((number - 1) >= model.length || model[number - 1] == null){
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

    public static void viewShowTodoList() {

    }

    public static void viewAddTodoList() {

    }

    public static void viewRemoveTodoList() {

    }
}
