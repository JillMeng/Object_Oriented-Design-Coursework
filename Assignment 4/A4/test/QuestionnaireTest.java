import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import cs5004.questionnaire.Likert;
import cs5004.questionnaire.Question;
import cs5004.questionnaire.Questionnaire;
import cs5004.questionnaire.QuestionnaireImpl;
import cs5004.questionnaire.ShortAnswer;
import cs5004.questionnaire.YesNo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QuestionnaireTest {
  private Question Q1;
  private Question Q2;
  private Question Q3;
  private Question Q4;
  private Question Q5;

  private QuestionnaireImpl questionnaire;

  @Before
  public void addTest() {
    questionnaire = new QuestionnaireImpl();
    Q1 = new YesNo("Are you ready for the questionnaire?", true);
    Q2 = new ShortAnswer("What's your name?", true);
    Q3 = new ShortAnswer("What is your gender?", false);
    Q4 = new Likert("Do you agree with this questionnaire?", true);
    Q5 = new YesNo("Have you finished your answers?", false);

    questionnaire.addQuestion("Question 1", Q1);
    questionnaire.addQuestion("Question 2", Q2);
    questionnaire.addQuestion("Question 3", Q3);
    questionnaire.addQuestion("Question 4", Q4);
    questionnaire.addQuestion("Question 5", Q5);
  }

  @Test
  public void removeTest() {
    assertEquals(Q4, questionnaire.getQuestion(4));
    questionnaire.removeQuestion("Question 4");
    assertFalse(questionnaire.equals(Q4));
  }

  @Test
  public void getQuestionTestByNum() {
    assertEquals(Q1, questionnaire.getQuestion(1));
  }

  @Test
  public void getQuestionTestByID() {
    assertEquals(Q2, questionnaire.getQuestion("Question 2"));
  }

  @Test
  public void getRequiredQuestion() {
    List<Question> required = new LinkedList<>();
    required.add(Q1);
    required.add(Q2);
    required.add(Q4);
    assertEquals(required, questionnaire.getRequiredQuestions());
  }

  @Test
  public void getOptionalQuestion() {
    List<Question> optional = new LinkedList<>();
    optional.add(Q3);
    optional.add(Q5);
    assertEquals(optional, questionnaire.getOptionalQuestions());
  }

  @Test
  public void isCompleteTest() {
    Q1.answer("YES");
    Q2.answer("Jill");
    assertFalse(questionnaire.isComplete());

    Q4.answer("Agree");
    assertTrue(questionnaire.isComplete());
  }

  @Test
  public void getResponsesTest() {
    Q1.answer("YES");
    Q2.answer("Jill");
    Q4.answer("Agree");
    Q5.answer("Yes");

    List<String> response = new LinkedList<>();
    response.add("Yes");
    response.add("Jill");
    response.add("");
    response.add("Agree");
    response.add("Yes");
    assertEquals(response, questionnaire.getResponses());
  }

  /*@Test
  public void filterTest() {
    Questionnaire filtered = new QuestionnaireImpl();
    filtered.addQuestion("Question 1", Q1);
    filtered.addQuestion("Question 5", Q5);
    questionnaire.filter(question -> question instanceof YesNo);
    assertEquals(filtered, questionnaire);
  }*

   */

  @Test
  public void sortTest() {
    questionnaire.sort((q1, q2) -> (q1.getPrompt().length() - q2.getPrompt().length()));
    assertEquals(Q2, questionnaire.getQuestion(1));
  }

  @Test
  public void foldTest() {
    int LongestQ = questionnaire.fold((question, acc) ->
            (question.getPrompt().length() > acc) ? (question.getPrompt().length()) : acc, 0);
    assertEquals(37, LongestQ);
  }

  @Test
  public void toStringTest() {
    Q1.answer("YES");
    Q2.answer("Jill");
    Q4.answer("Agree");
    Q5.answer("Yes");

    String str =
            "Question: Are you ready for the questionnaire?\n" +
                    "\n" +
                    "Answer: Yes\n" +
                    "\n" +
                    "Question: What's your name?\n" +
                    "\n" +
                    "Answer: Jill\n" +
                    "\n" +
                    "Question: What is your gender?\n" +
                    "\n" +
                    "Answer: \n" +
                    "\n" +
                    "Question: Do you agree with this questionnaire?\n" +
                    "\n" +
                    "Answer: Agree\n" +
                    "\n" +
                    "Question: Have you finished your answers?\n" +
                    "\n" +
                    "Answer: Yes\n" +
                    "\n";

    assertEquals(str, questionnaire.toString());
  }


}





