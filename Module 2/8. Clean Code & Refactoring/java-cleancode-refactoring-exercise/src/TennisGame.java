public class TennisGame {

    public static String getScore(String player1Name, String player2Name, int score_p1, int score_p2) {
        String result = "";

        if (score_p1 == score_p2) {
            result = readEqualScore(score_p1);
        } else if (score_p1 >= 4 || score_p2 >= 4) {
            int minusScore = score_p1 - score_p2;

            boolean p1_advantage = minusScore == 1;
            boolean p2_advantage = minusScore == -1;
            boolean p1_win = minusScore >= 2;

            if (p1_advantage) result = "Advantage player1";
            else {
                if (p2_advantage) result = "Advantage player2";
                else {
                    if (p1_win) result = "Win for player1";
                    else result = "Win for player2";
                }
            }
        } else {
            result = readScore(score_p1) + "-" + readScore(score_p2);
        }
        return result;
    }

    public static String readScore(int tempScore) {
        String result = "";
        switch (tempScore) {
            case 0:
                result += "Love";
                break;
            case 1:
                result += "Fifteen";
                break;
            case 2:
                result += "Thirty";
                break;
            case 3:
                result += "Forty";
                break;
        }
        return result;
    }

    public static String readEqualScore(int score) {
        String result;
        switch (score) {
            case 0:
                result = "Love-All";
                break;
            case 1:
                result = "Fifteen-All";
                break;
            case 2:
                result = "Thirty-All";
                break;
            case 3:
                result = "Forty-All";
                break;
            default:
                result = "Deuce";
                break;

        }
        return result;
    }
}
