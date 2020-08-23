// package com.bubble.athena.client;

// import java.util.List;

// import com.bubble.athena.net.arena.AttackEvent;
// import com.bubble.athena.net.score.ScoreboardState;
// import com.bubble.net.response.Response;

// public interface IServerApi {
//     void login(String username, String password);
//     void signup(String username, String password);
//     void removeUser(String username, String password);
//     void logout();

//     void findMatch();

//     Response request(Request request);
//     Response getResponse();
//     String log();

//     void sendMessage(String from, String to);

//     List<String> getGlobalChat();
//     List<String> getUserChat();
//     String getUsername();

//     void sendFriendRequest(String user);

//     void attack(AttackEvent event);

//     ScoreboardState getScoreboard();
// }