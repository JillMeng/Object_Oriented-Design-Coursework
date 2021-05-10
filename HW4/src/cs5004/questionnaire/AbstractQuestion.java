package cs5004.questionnaire;

/**
 * An abstract class that contains the common method from the YesNo, ShortAnswer,
 * Likert Question type.
 */
public abstract class AbstractQuestion implements Question {
  private String question;
  private boolean status;


  /**
   * A constructor that takes in the question prompt as a String and a boolean where
   * true means the question is required, and false means optional.
   * @param question the String of the question that is taken.
   * @param status a boolean expression whether the question is required(true) or optional(false)
   * @throws IllegalArgumentException when the question is null or empty string.
   */
  public AbstractQuestion(String question, boolean status) {
    if (question == null || question.equals("") ) {
      throw new IllegalArgumentException("Question is invalid");
    }
    this.question = question;
    this.status = status;
  }

  @Override
  public String getPrompt() {
    return this.question;
  }

  @Override
  public boolean isRequired() {
    return this.status;
  }

  @Override
  public String toString() {
    String str = "Question: " + this.getPrompt() + "\n\nAnswer: " + this.getAnswer();
    return str;
  }
}

