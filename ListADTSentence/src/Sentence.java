import java.util.LinkedList;
import java.util.List;

public class Sentence {
  private List<Node> head;

  public Sentence() {
    head = new LinkedList<>();
  }

  public void add(Node node) {
    head.add(node);
  }

  public long getNumberOfWord() {
    return head.stream().filter(n -> n instanceof WordNode).count();
  }

  public long getNumberOfPun() {
    return head.stream().filter(n -> n instanceof PunNode).count();
  }

  public long countZ() {
    return head.stream().filter(n -> n.getContent().contains("Z")).count();
  }

  List<Integer> result = integerList.stream()
          .filter(for (number n : arran))
          .collect(Collectors.toList());

  public String longestWord() {
    String longest = "";
    for (Node n : head) {
      if (n.getContent().length() > longest.length()) {
        longest = n.getContent();
      }
    }
    return longest;
  }

  public String toString() {
    String str = "";
    for (Node n : head) {
      if (n instanceof WordNode) {
        str += " " + n.getContent();
      } else {
        str += n.getContent();
      }
    }
    return str;
  }
  public void merge(Sentence other) {
    head.addAll(other.head);
  }

  public Sentence clone() {
    Sentence cloneS = new Sentence();
    head.forEach(node -> {cloneS.add(node);});
    return cloneS;
  }

  public void pitLatin () {
    head.stream().filter(n -> n instanceof WordNode).forEach(w ->w.toPiglatin());
  }
}


