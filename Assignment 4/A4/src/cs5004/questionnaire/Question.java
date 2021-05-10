package cs5004.questionnaire;

public interface Question{

  /**
   * A method that return the text of the question.
   * @return a String value of the text content.
   */
  String getPrompt();

  /**
   * A method that returns the status of the question.
   * @return true means the question is required, and false means optional
   */
  boolean isRequired();

  /**
   * A method that allows one to enter an answer as a String and store in the question object.
   * @param answer A String that is the answer to the question depending on the type.
   */
  void answer(String answer);

  /**
   * a method getAnswer that returns the answer to the question, or empty string if
   * there is no answer.
   */
  String getAnswer();

  /**
   * A method returns a copy of the question including all its data.
   * @return a new object with all the data in the Question.
   */
  Question copy();
}
