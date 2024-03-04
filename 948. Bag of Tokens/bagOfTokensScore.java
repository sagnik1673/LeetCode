//  You start with an initial power of power, an initial score of 0, and a bag of tokens given as an integer array tokens, where each tokens[i] donates the value of ith token.
//  Your goal is to maximize the total score by strategically playing these tokens. In one move, you can play an unplayed token in one of the two ways (but not both for the same token):
//    > Face-up: If your current power is at least tokens[i], you may play tokeni, losing tokens[i] power and gaining 1 score.
//    > Face-down: If your current score is at least 1, you may play tokeni, gaining tokens[i] power and losing 1 score.
//  Return the maximum possible score you can achieve after playing any number of tokens.

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0;
        Arrays.sort(tokens);
        Deque<Integer> deque = new LinkedList<>();

        for (int token : tokens) {
            deque.add(token);
        }

        while (!deque.isEmpty()) {
            // When we have enough power, play token face-up
            if (power >= deque.peekFirst()) {
                power -= deque.pollFirst();
                score++;
            // We don't have enough power to play a token face-up
            // When there is at least one token remaining,
            // and we have enough score, play token face-down
            } else if (deque.size() > 1 && score > 0) {
                power += deque.pollLast();
                score--;
            // We don't have enough score, power, or tokens 
            // to play face-up or down and increase our score
            } else {
                return score;
            }
        }
        return score;
    }
}
