package com.solomon.eyoel.midtermexam;

public class MultipleChoice {
    private int question;
    private int choice1;
    private int choice2;
    private int radioButtonId;

    public MultipleChoice(int question, int choice1, int choice2, int radioButtonId) {
        this.question = question;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.radioButtonId = radioButtonId;
    }

    public int getQuestion() {
        return question;
    }

    public int getChoice1() {
        return choice1;
    }

    public int getChoice2() {
        return choice2;
    }

    public int getRadioButtonId() {

        return radioButtonId;
    }
}
