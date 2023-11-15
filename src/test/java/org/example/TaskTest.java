package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class TaskTest {
    Todos todos = new Todos();

    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    @BeforeEach
    public void setup() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
    }

    @Test
    public void searchMatchesThreeTaskTest() {


        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchMatchesOneTaskTest() {

        Task[] expected = {epic};
        Task[] actual = todos.search("Молоко");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchMatchesNullTaskTest(){
        Task[] expected = {};
        Task[] actual = todos.search("Позонить родителям");

        Assertions.assertArrayEquals(expected, actual);
    }

}
