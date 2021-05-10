import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import cs5004.questionnaire.Likert;
import cs5004.questionnaire.Question;
import cs5004.questionnaire.Questionnaire;
import cs5004.questionnaire.QuestionnaireImpl;
import cs5004.questionnaire.ShortAnswer;
import cs5004.questionnaire.YesNo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * A Junit test for all the method that is implemented in QuestionnaireImpl.
 */
public class QuestionnaireTest {
  private Question question1;
  private Question question2;
  private Question question3;
  private Question question4;
  private Question question5;

  private QuestionnaireImpl questionnaire;

  @Before
  public void addTest() {
    questionnaire = new QuestionnaireImpl();
    question1 = new YesNo("Are you ready for the questionnaire?", true);
    question2 = new ShortAnswer("What's your name?", true);
    question3 = new ShortAnswer("What is your gender?", false);
    question4 = new Likert("Do you agree with this questionnaire?", true);
    question5 = new YesNo("Have you finished your answers?", false);

    questionnaire.addQuestion("Question 1", question1);
    questionnaire.addQuestion("Question 2", question2);
    questionnaire.addQuestion("Question 3", question3);
    questionnaire.addQuestion("Question 4", question4);
    questionnaire.addQuestion("Question 5", question5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalAddNull() throws IllegalArgumentException {
    questionnaire.addQuestion("Question 6", new YesNo(null, true));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalAddEmpty() throws IllegalArgumentException {
    questionnaire.addQuestion("Question 6", null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalAddUnique() throws IllegalArgumentException {
    questionnaire.addQuestion("Question 5", new YesNo("Answer Yes/No.", true));
  }

  @Test
  public void removeTest() {
    assertEquals(question4, questionnaire.getQuestion(4));
    questionnaire.removeQuestion("Question 4");
    assertFalse(questionnaire.equals(question4));
  }

  @Test(expected = NoSuchElementException.class)
  public void removeIllegalTest() throws NoSuchElementException {
    questionnaire.removeQuestion("Question 10");
  }

  @Test
  public void getQuestionTestByNum() {
    assertEquals(question1, questionnaire.getQuestion(1));
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void getQuestionIllegalTest() throws IndexOutOfBoundsException {
    questionnaire.getQuestion(9);
  }

  @Test
  public void getQuestionTestByID() {
    assertEquals(question2, questionnaire.getQuestion("Question 2"));
  }

  @Test(expected = NoSuchElementException.class)
  public void getQuestionIllegalTest2() throws NoSuchElementException {
    questionnaire.getQuestion("Question 6");
  }

  @Test
  public void getRequiredQuestion() {
    List<Question> required = new LinkedList<>();
    required.add(question1);
    required.add(question2);
    required.add(question4);
    assertEquals(required, questionnaire.getRequiredQuestions());
  }

  @Test
  public void getOptionalQuestion() {
    List<Question> optional = new LinkedList<>();
    optional.add(question3);
    optional.add(question5);
    assertEquals(optional, questionnaire.getOptionalQuestions());
  }

  @Test
  public void isCompleteTest() {
    question1.answer("YES");
    question2.answer("Jill");
    assertFalse(questionnaire.isComplete());

    question4.answer("Agree");
    assertTrue(questionnaire.isComplete());
  }

  @Test
  public void getResponsesTest() {
    question1.answer("YES");
    question2.answer("Jill");
    question4.answer("Agree");
    question5.answer("Yes");

    List<String> response = new LinkedList<>();
    response.add("YES");
    response.add("Jill");
    response.add("");
    response.add("Agree");
    response.add("Yes");
    assertEquals(response, questionnaire.getResponses());
  }

  @Test
  public void filterTest() {
    question1.answer("YES");
    question2.answer("Jill");
    question4.answer("Agree");
    question5.answer("Yes");

    Questionnaire filtered = new QuestionnaireImpl();
    filtered.addQuestion("Question 1", question1);
    filtered.addQuestion("Question 5", question5);

    assertEquals(filtered.toString(), questionnaire.filter(question ->
            question.getAnswer().equalsIgnoreCase("yes")).toString());
  }

  @Test
  public void sortTest() {
    questionnaire.sort((q1, q2) -> (q1.getPrompt().length() - q2.getPrompt().length()));
    assertEquals(question2, questionnaire.getQuestion(1));
  }

  @Test
  public void foldTest() {
    int longestQ = questionnaire.fold((question, acc) ->
            (question.getPrompt().length() > acc) ? (question.getPrompt().length()) : acc, 0);
    assertEquals(37, longestQ);
  }

  @Test
  public void toStringTest() {
    question1.answer("YES");
    question2.answer("Jill");
    question4.answer("Agree");
    question5.answer("Yes");

    String str =
            "Question: Are you ready for the questionnaire?\n"
                    + "\n" +
                    "Answer: YES\n"
                    + "\n" +
                    "Question: What's your name?\n"
                    + "\n" +
                    "Answer: Jill\n"
                    + "\n" +
                    "Question: What is your gender?\n"
                    + "\n" +
                    "Answer: \n"
                    + "\n" +
                    "Question: Do you agree with this questionnaire?\n"
                    + "\n" +
                    "Answer: Agree\n"
                    + "\n" +
                    "Question: Have you finished your answers?\n"
                    + "\n" +
                    "Answer: Yes";

    assertEquals(str, questionnaire.toString());
  }


}






