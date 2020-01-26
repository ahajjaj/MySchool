package com.example.myschool;

public class QuestionLibrary {

        private String mQuestions [] = {
        "La somme de 5+4",
        "le produit de 5x4",
        "Le resultats de la division de 20/4",
        "la somme de 20+30"

};


        private String mChoices [][] = {
                {"9", "8", "7"},
                {"5", "30", "20"},
                {"3", "5", "1"},
                {"20", "500", "50"}
        };



        private String mCorrectAnswers[] = {"9", "20", "5", "50"};




        public String getQuestion(int a) {
            String question = mQuestions[a];
            return question;
        }


        public String getChoice1(int a) {
            String choice0 = mChoices[a][0];
            return choice0;
        }


        public String getChoice2(int a) {
            String choice1 = mChoices[a][1];
            return choice1;
        }

        public String getChoice3(int a) {
            String choice2 = mChoices[a][2];
            return choice2;
        }

        public String getCorrectAnswer(int a) {
            String answer = mCorrectAnswers[a];
            return answer;
        }

}
