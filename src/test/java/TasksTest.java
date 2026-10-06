import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void simpleTaskShouldMatchQueryInTitle() {
        SimpleTask task = new SimpleTask(5, "Позвонить родителям");
        Assertions.assertTrue(task.matches("родителям"));
    }

    @Test
    public void simpleTaskShouldNotMatchAbsentQuery() {
        SimpleTask task = new SimpleTask(5, "Позвонить родителям");
        Assertions.assertFalse(task.matches("Хлеб"));
    }

    @Test
    public void epicShouldMatchQueryInSubtask() {
        Epic epic = new Epic(55, new String[]{"Молоко", "Яйца", "Хлеб"});
        Assertions.assertTrue(epic.matches("Яйца"));
    }

    @Test
    public void epicShouldMatchQueryInLastSubtask() {
        Epic epic = new Epic(55, new String[]{"Молоко", "Яйца", "Хлеб"});
        Assertions.assertTrue(epic.matches("Хлеб"));
    }

    @Test
    public void epicShouldNotMatchAbsentQuery() {
        Epic epic = new Epic(55, new String[]{"Молоко", "Яйца", "Хлеб"});
        Assertions.assertFalse(epic.matches("Сыр"));
    }

    @Test
    public void meetingShouldMatchQueryInTopic() {
        Meeting meeting = new Meeting(555, "Выкатка зй версии приложения", "Приложение НетоБанк", "Во вторник после обеда");
        Assertions.assertTrue(meeting.matches("Выкатка"));
    }

    @Test
    public void meetingShouldMatchQueryInProject() {
        Meeting meeting = new Meeting(555, "Выкатка зй версии приложения", "Приложение НетоБанк", "Во вторник после обеда");
        Assertions.assertTrue(meeting.matches("НетоБанк"));
    }

    @Test
    public void meetingShouldNotMatchQueryInStart() {
        Meeting meeting = new Meeting(555, "Выкатка зй версии приложения", "Приложение НетоБанк", "Во вторник после обеда");
        Assertions.assertFalse(meeting.matches("среда"));
    }
}
