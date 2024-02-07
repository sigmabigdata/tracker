package ru.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double totalScore = 0;
        int totalSubjects = 0;

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
                totalSubjects++;
            }
        }

        if (totalSubjects == 0) {
            return 0;
        }

        return totalScore / totalSubjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> averageScores = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double totalScore = 0;
            int totalSubjects = 0;
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
                totalSubjects++;
            }
            if (totalSubjects == 0) {
                averageScores.add(new Label(pupil.name(), 0));
            } else {
                averageScores.add(new Label(pupil.name(), totalScore / totalSubjects));
            }
        }
        return averageScores;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScores = new LinkedHashMap<>();
        List<Label> result = new ArrayList<>();
        int totalScore = 0;

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                String subjectName = subject.name();
                int subjectScore = subject.score();

                if (subjectScores.containsKey(subjectName)) {
                    int score = subjectScores.get(subjectName) + subjectScore;
                    subjectScores.put(subjectName, score);
                } else {
                    subjectScores.put(subjectName, subjectScore);
                }

                totalScore += subjectScore;
            }
        }

        for (String subject : subjectScores.keySet()) {
            int averageScore = subjectScores.get(subject) / pupils.size();
            result.add(new Label(subject, averageScore));
        }

        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> studentScores = new ArrayList<>();

        for (Pupil pupil : pupils) {
            double totalScore = 0;

            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            studentScores.add(new Label(pupil.name(), totalScore));
        }
        studentScores.sort(Collections.reverseOrder());
        return studentScores.get(0);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScores = new LinkedHashMap<>();
        List<Label> subjectScoresList = new ArrayList<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectScores.put(subject.name(), subjectScores.getOrDefault(subject.name(), 0) + subject.score());
            }
        }

        for (Map.Entry<String, Integer> entry : subjectScores.entrySet()) {
            String subjectName = entry.getKey();
            double totalScore = entry.getValue();
            subjectScoresList.add(new Label(subjectName, totalScore));
        }
        subjectScoresList.sort(Collections.reverseOrder());

        return subjectScoresList.get(0);
    }
}
