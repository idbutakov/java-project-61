package hexlet.code;

public final class QuestionAnswerPair {
    private final String question;
    private final String answer;

    public QuestionAnswerPair(String sQuestion, String sAnswer) {
        this.question = sQuestion;
        this.answer = sAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
