package cs5004.questionnaire;

/**
 * Am Yes and No answer question object that extends the AbstractQuestion.
 */
public class YesNo extends AbstractQuestion {
  String answer;

  public YesNo(String question, boolean status) {
    super(question, status);
    this.answer = "";
  }

  @Override
  public void answer(String a) {
    if (a == null) {
      throw new IllegalArgumentException("Answer cannot be null!");
    }
    if (a.equalsIgnoreCase("yes") || a.equalsIgnoreCase("no")) {
      answer = a;
    } else {
      throw new IllegalArgumentException("Invalid answer!");
    }
  }

  @Override
  public String getAnswer() {
    return this.answer;
  }

  @Override
  public Question copy() {
    Question copyQ = new YesNo(this.getPrompt(), this.isRequired());
    copyQ.answer(this.answer);
    return copyQ;
  }
}