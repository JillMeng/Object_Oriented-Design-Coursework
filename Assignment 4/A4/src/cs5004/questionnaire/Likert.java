package cs5004.questionnaire;

import cs5004.questionnaire.AbstractQuestion;

public class Likert extends AbstractQuestion {
  String answer;

  public Likert(String question, boolean status) {
    super(question, status);
    this.answer = "";
  }
  //Strongly Agree, Agree, Neither Agree nor Disagree, Disagree, Strongly Disagree

  @Override
  public void answer(String a) {
    if (a.equals("")) {
      answer = "";
    } else if (a.equalsIgnoreCase(LikertResponseOption.STRONGLY_AGREE.getText())) {
      answer = "Strongly Agree";
    } else if (a.equalsIgnoreCase(LikertResponseOption.AGREE.getText())) {
      answer ="Agree";
    } else if (a.equalsIgnoreCase(LikertResponseOption.NEUTRAL.getText())) {
      answer = "Neither Agree nor Disagree";
    } else if (a.equalsIgnoreCase(LikertResponseOption.DISAGREE.getText())) {
      answer = "Disagree";
    } else if (a.equalsIgnoreCase(LikertResponseOption.STRONGLY_DISAGREE.getText())) {
      answer = "Strongly Disagree";
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
    Question copyQ = new Likert(this.getPrompt(),this.isRequired());
    copyQ.answer(this.answer);
    return copyQ;
  }

}
