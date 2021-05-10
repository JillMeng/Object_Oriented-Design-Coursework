package cs5004.questionnaire;


public abstract class AbstractQuestion implements Question{
  private String question;
  private boolean status;

  //Each of those classes should have a constructor that
  // takes in the question prompt as a String and a boolean where
  // true means the question is required, and false means optional.
  public AbstractQuestion(String question, boolean status) {
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

}
