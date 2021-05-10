package cs5004.questionnaire;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class QuestionnaireImpl implements Questionnaire {

  private List<QuestionNode> questionList;

  public QuestionnaireImpl() {
    questionList = new LinkedList<>();
  }

  @Override
  public void addQuestion(String identifier, Question q) {
    if (identifier == null || identifier.equals("")) {
      throw new IllegalArgumentException("Question identifier is invalid");
    }
    if (q == null || q.equals("")) {
      throw new IllegalArgumentException("Question is invalid");
    }
    for (QuestionNode node : questionList) {
      if (node.getID().equals(identifier)) {
        throw new IllegalArgumentException("Identifier must be unique.");
      }
    }
    questionList.add(new QuestionNode(identifier, q));
  }

  @Override
  public void removeQuestion(String identifier) {
    questionList.removeIf(n -> n.getQuestion().equals(identifier));
  }

  @Override
  public Question getQuestion(int num) {
    if (num < 1 || num > questionList.size()) {
      throw new IndexOutOfBoundsException("Question number is invalid");
    }
    return questionList.get(num-1).getQuestion();
  }


  @Override
  public Question getQuestion(String identifier) {
    for (QuestionNode n : questionList) {
      if (n.getID().equals(identifier)) {
        return n.getQuestion();
      }
    }
    throw new IllegalArgumentException("Such question does not exist.");
  }


  @Override
  public List<Question> getRequiredQuestions() {
    List<Question> requiredList = new LinkedList<>();
    for (QuestionNode n : questionList) {
      if (n.getQuestion().isRequired()) {
        requiredList.add(n.getQuestion());
      }
    }
    return requiredList;
  }

  @Override
  public List<Question> getOptionalQuestions() {
    List<Question> optionalList = new LinkedList<>();
    for (QuestionNode n : questionList) {
      if (!n.getQuestion().isRequired()) {
        optionalList.add(n.getQuestion());
      }
    }
    return optionalList;
  }

  @Override
  public boolean isComplete() {
    List<Question> requiredList = getRequiredQuestions();
    for (Question q : requiredList) {
      if (q.getAnswer().equals("")) {
        return false;
      }
    }
    return true;
  }

  @Override
  public List<String> getResponses() {
    List<String> answerStr = questionList.stream().
            map(questionNode -> questionNode.getQuestion().getAnswer()).
            collect(Collectors.toList());
    return answerStr;
  }

  @Override
  public Questionnaire filter(Predicate<Question> pq) {
    //Predicate<QuestionNode> pqNode->pqNode.getQuestion();
    List<QuestionNode> copyQuestionnaire = new LinkedList<>();
    for (QuestionNode node: questionList) {
      copyQuestionnaire.add(node);
      }
    return null;
  }

  @Override
  public void sort(Comparator<Question> comp) {
    Comparator<QuestionNode> nodeComparator = (QuestionNode o1, QuestionNode o2)
            -> comp.compare(o1.getQuestion(),o2.getQuestion());
    Collections.sort(questionList,nodeComparator);
  }

  @Override
  public < R > R fold(BiFunction < Question, R, R > bf, R seed) {
    List<Question> questionOnly = questionList.stream().map(questionNode ->
            questionNode.getQuestion()).collect(Collectors.toList());
    R acc = seed;
    for (Question q: questionOnly)
      acc = bf.apply(q,acc);
    return acc;
  }

  @Override
  public String toString() {
    String str = "";
    for(QuestionNode node: questionList) {
      str += "Question: " + node.getQuestion().getPrompt() + "\n\n" +
              "Answer: " + node.getQuestion().getAnswer() + "\n\n";
    }
    return str;
  }
}

