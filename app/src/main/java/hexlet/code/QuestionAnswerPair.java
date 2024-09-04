package hexlet.code;

public class QuestionAnswerPair {
    private final String question;
    private final String answer;

    public QuestionAnswerPair(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
