import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    public void shouldMatchesSimpleTask() {
        SimpleTask quely = new SimpleTask(5, "Позвонить родителям");

        quely.matches("Позвонить родителям");

        String expected= "Позвонить родителям";
        String actual= quely.getTitle();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMathesMeeting(){
        Meeting quely = new Meeting(555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        quely.matches("Приложение НетоБанка");

        String expected= "Приложение НетоБанка";
        String actual = quely.getProject();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesEpic(){
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic quely=new Epic(55, subtasks);

        quely.matches("Молоко");

        String[] expected = {"Молоко", "Яйца","Хлеб"};
        String[] actual =quely.getSubtasks();

        Assertions.assertArrayEquals(expected, actual);
    }

}