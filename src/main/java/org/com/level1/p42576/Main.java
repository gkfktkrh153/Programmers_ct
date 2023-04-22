package org.com.level1.p42576;

import java.util.HashMap;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        new Solution().solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"});
    }
}

class Solution {
    public String solution(String[] participant_, String[] completion_) {
        HashMap<String,Integer> participant = new HashMap<String,Integer>();
        String answer = "";
        for(int i = 0; i < participant_.length;i++) {

            if (participant.containsKey(participant_[i]))
                participant.put(participant_[i], participant.get(participant_[i]) + 1);
            else
                participant.put(participant_[i], 1);
        }

        System.out.println(participant);

        for (String completion: completion_)
            participant.put(completion, participant.get(completion) - 1);

        System.out.println(participant);

        for( String key: participant.keySet())
            if(participant.get(key) == 1)
                answer = key;

        return answer;
    }
}
