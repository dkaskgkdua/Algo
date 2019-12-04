package SONG.LEVEL2.오픈채팅방;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {
		        HashMap<String, String> user = new HashMap<String, String>();
				ArrayList<String> result = new ArrayList<String>();
				ArrayList<String> matchId = new ArrayList<String>();
				for(String re : record) {
					String[] reArray = re.split(" ");
					if(reArray.length != 2) {
						user.put(reArray[1], reArray[2]);
					}
					switch(reArray[0]) {
					case "Enter" : 
						if(!user.containsKey(reArray[1])) {	//처음 들어온 회원
							result.add(user.get(reArray[1]) + "님이 들어왔습니다.");
							matchId.add(reArray[1]);
						} else {		// 처음 들어온 회원이 아님
							for(int i =0; i < matchId.size(); i++) { //List 길이만큼 
								if(reArray[1].equals(matchId.get(i))) {	// 들어온 아이디가 List의 아이디가 같다면
									StringBuilder active = new StringBuilder("");
		                        active.append(result.get(i).substring(result.get(i).indexOf("님")));  //님이 ~ 했습니다
								result.set(i, reArray[2]+active.toString());		// 닉넴 + 행동으로 바꿔줌
								}
							}
							result.add(user.get(reArray[1]) + "님이 들어왔습니다.");
							matchId.add(reArray[1]);
						}
						break;
					case "Leave" :
						result.add(user.get(reArray[1]) + "님이 나갔습니다.");
						matchId.add(reArray[1]);
						break;
					default :
						for(int i =0; i < matchId.size(); i++) { //List 길이만큼 
							if(reArray[1].equals(matchId.get(i))) {
								StringBuilder active = new StringBuilder("");
		                        active.append(result.get(i).substring(result.get(i).indexOf("님")));  //님이 ~ 했습니다
								result.set(i, reArray[2]+active.toString());		// 닉넴 + 행동으로 바꿔줌
							}
						}
						break;
					}
					/*
					if(reArray[0].equals("Enter")) {	// 입장
						
					} else if(reArray[0].equals("Leave")) { // 떠남
						
					} else {		// change
						
					}*/
				}
				String[] answer = new String[result.size()];
				answer = result.toArray(answer);
				return answer;
		    }
}