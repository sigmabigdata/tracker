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
        return totalSubjects == 0 ? 0 : totalScore / totalSubjects;
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
            averageScores.add(new Label(pupil.name(), totalSubjects == 0 ? 0 : totalScore / totalSubjects));
        }
        return averageScores;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScores = getSubjectScore(pupils);
        List<Label> result = new ArrayList<>();
        for (String subject : subjectScores.keySet()) {
            result.add(new Label(subject, subjectScores.get(subject) / pupils.size()));
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
        Map<String, Integer> subjectScores = getSubjectScore(pupils);
        List<Label> subjectScoresList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : subjectScores.entrySet()) {
            subjectScoresList.add(new Label(entry.getKey(), entry.getValue()));
        }
        subjectScoresList.sort(Collections.reverseOrder());
        return subjectScoresList.get(0);
    }

    private static Map<String, Integer> getSubjectScore(List<Pupil> pupils) {
        Map<String, Integer> subjectScores = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int currentScore = subjectScores.getOrDefault(subject.name(), 0);
                subjectScores.put(subject.name(), currentScore + subject.score());
            }
        }
        return subjectScores;
    }
}
