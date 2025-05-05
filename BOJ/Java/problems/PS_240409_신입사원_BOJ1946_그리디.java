package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class PS_240409_신입사원_BOJ1946_그리디 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static class Score {
        private final int resumeScore;
        private final int interviewScore;

        public Score(int rScore, int iScore) {
            resumeScore = rScore;
            interviewScore = iScore;
        }

        public int getResumeScore() {
            return resumeScore;
        }

        public int getInterviewScore() {
            return interviewScore;
        }
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            List<Score> scoreList = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int rScore = Integer.parseInt(st.nextToken());
                int iScore = Integer.parseInt(st.nextToken());
                scoreList.add(new Score(rScore, iScore));
            }

            List<Score> sortedScoreList = sortScoreList(scoreList);

            int selectionNumber = selection(sortedScoreList);
            sb.append(selectionNumber).append("\n");
        }

        System.out.println(sb);
    }

    private static List<Score> sortScoreList(List<Score> scoreList) {
        return scoreList.stream().sorted(Comparator.comparing(Score::getResumeScore)).collect(Collectors.toList());
    }

    private static int selection(List<Score> sortedScoreList) {
        int markScore = sortedScoreList.get(0).getInterviewScore();
        int cnt = 1;

        for (int i = 1; i < sortedScoreList.size(); i++) {
            int currScore = sortedScoreList.get(i).getInterviewScore();
            if (markScore > currScore) {
                markScore = currScore;
                cnt++;
            }
        }
        return cnt;
    }
}

