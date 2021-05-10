package cs5004.questionnaire;

/**
 * A Likert question object that extends the AbstractQuestion.
 */
public class Likert extends AbstractQuestion {
  String answer;

  public Likert(String question, boolean status) {
    super(question, status);
    this.answer = "";
  }

  @Override
  public void answer(String a) {
    if (a == null ) {
      throw new IllegalArgumentException("Answer is invalid");
    }
    else if (a.equals("")
            || a.equalsIgnoreCase(LikertResponseOption.STRONGLY_AGREE.getText())
            || a.equalsIgnoreCase(LikertResponseOption.AGREE.getText())
            || a.equalsIgnoreCase(LikertResponseOption.NEUTRAL.getText())
            || a.equalsIgnoreCase(LikertResponseOption.DISAGREE.getText())
            || a.equalsIgnoreCase(LikertResponseOption.STRONGLY_DISAGREE.getText())) {
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
    Question copyQ = new Likert(this.getPrompt(), this.isRequired());
    copyQ.answer(this.answer);
    return copyQ;
  }
}

