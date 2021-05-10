package cs5004.questionnaire;

class QuestionNode {
  private final String ID;
  private final Question question;

  public QuestionNode(String id, Question question) {
    if ( id == null || id.equals("")) {
      throw new IllegalArgumentException("Question identifier is invalid");
    }
    if (question == null) {
      throw new IllegalArgumentException("Question is invalid");
    }
    this.ID = id;
    this.question = question;
  }

  public String getID() {
    return ID;
  }

  public Question getQuestion() {
    return question;
  }

}
