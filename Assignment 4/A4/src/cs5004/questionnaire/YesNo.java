package cs5004.questionnaire;


public class YesNo extends AbstractQuestion {
  String answer;

  public YesNo(String question, boolean status) {
    super(question, status);
    this.answer = "";
  }

  @Override
  public void answer(String a) {
    if (a.equals("")) {
      answer = "";
    }
    else if (a.equalsIgnoreCase("yes")) {
      answer = "Yes";
    }
    else if (a.equalsIgnoreCase("no")) {
      answer = "No";
    }
    else {
      throw new IllegalArgumentException("Invalid answer!");
    }
  }
  @Override
  public String getAnswer() {
    return this.answer;
  }

  @Override
  public Question copy() {
    Question copyQ = new YesNo(this.getPrompt(),this.isRequired());
    copyQ.answer(this.answer);
    return copyQ;
  }

}