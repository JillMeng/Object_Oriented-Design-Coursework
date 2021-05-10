import org.junit.Before;
import org.junit.Test;

import cs5004.questionnaire.Likert;
import cs5004.questionnaire.Question;
import cs5004.questionnaire.ShortAnswer;
import cs5004.questionnaire.YesNo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * A Junit test for all the method that is implemented in the Question interface.
 */
public class QuestionTest {

  Question q1;
  Question q2;
  Question q3;
  Question q4;

  @Before
  public void setUp() {
    q1 = new ShortAnswer("What is your name?",true);
    q2 = new YesNo("Would you like to answer the question",true);
    q3 = new ShortAnswer("What is your favorite color?",false);
    q4 = new Likert("Do you agree with the comment?",false);
  }

  @Test
  public void getPromptTest() {
    assertEquals("What is your name?",q1.getPrompt());
    assertEquals("Would you like to answer the question",q2.getPrompt());
    assertEquals("What is your favorite color?",q3.getPrompt());
    assertEquals("Do you agree with the comment?",q4.getPrompt());
  }

  @Test
  public void isRequiredTest() {
    assertTrue(q1.isRequired());
    assertTrue(q2.isRequired());
    assertFalse(q3.isRequired());
    assertFalse(q4.isRequired());
  }

  @Test
  public void answerTest() {
    q1.answer("Andrew");
    q2.answer("yes");
    q4.answer("agree");
    assertEquals("Andrew",q1.getAnswer());
    assertEquals("yes",q2.getAnswer());
    assertEquals("agree",q4.getAnswer());
  }

  @Test
  public void getAnswerTest() {
    q1.answer("Andrew");
    q2.answer("yes");
    q4.answer("agree");
    assertEquals("Andrew",q1.getAnswer());
    assertEquals("yes",q2.getAnswer());
    assertEquals("",q3.getAnswer());
    assertEquals("agree",q4.getAnswer());
  }

  @Test
  public void copyTest() {
    Question copyQ1 = q1.copy();
    assertEquals(q1.getPrompt(),copyQ1.getPrompt());
    assertEquals(q1.getAnswer(),copyQ1.getAnswer());
    assertEquals(q1.isRequired(),copyQ1.isRequired());

    Question copyQ2 = q2.copy();
    assertEquals(q2.getPrompt(),copyQ2.getPrompt());
    assertEquals(q2.getAnswer(),copyQ2.getAnswer());
    assertEquals(q2.isRequired(),copyQ2.isRequired());

    Question copyQ4 = q4.copy();
    assertEquals(q4.getPrompt(),copyQ4.getPrompt());
    assertEquals(q4.getAnswer(),copyQ4.getAnswer());
    assertEquals(q4.isRequired(),copyQ4.isRequired());
  }
}
