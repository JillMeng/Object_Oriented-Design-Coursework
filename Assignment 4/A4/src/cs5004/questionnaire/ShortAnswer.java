package cs5004.questionnaire;

import cs5004.questionnaire.AbstractQuestion;

public class ShortAnswer extends AbstractQuestion {
  String answer;
  public ShortAnswer(String question, boolean status) {
    super(question, status);
    this.answer = "";
  }

  @Override
  public void answer(String a) {
    if (a.equals("")) {
      answer = "";
    } else if (a.length() <= 280) {
      answer = a;
    } else {
      throw new IllegalArgumentException("Answer is too long");
    }
  }

  @Override
  public String getAnswer() {
    return this.answer;
  }

  @Override
  public Question copy() {
    Question copyQ = new ShortAnswer(this.getPrompt(),this.isRequired());
    copyQ.answer(this.answer);
    return copyQ;
  }

}
