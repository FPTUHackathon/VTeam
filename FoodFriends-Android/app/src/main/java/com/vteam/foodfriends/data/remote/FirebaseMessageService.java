package com.vteam.foodfriends.data.remote;

import android.content.Context;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ServerValue;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.vteam.foodfriends.data.model.FileContent;
import com.vteam.foodfriends.data.model.MessageFrom;
import com.vteam.foodfriends.data.model.TextMessage;
import com.vteam.foodfriends.data.model.User;
import com.vteam.foodfriends.utils.Constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yukinohara on 12/3/17.
 */

public class FirebaseMessageService {
    private static final String LOG_TAG = FirebaseMessageService.class.getSimpleName();
    private Context mContext;
    private FirebaseFirestore db;

    public FirebaseMessageService(Context context){
        this.mContext = context;
        db = FirebaseFirestore.getInstance();
    }

    public Task<DocumentSnapshot> getMessagePair(String boxId){
        return db.collection(Constant.FIREBASE_MESSAGE)
                .document(boxId)
                .get();
    }

    public void setMessage(String boxId, TextMessage textMessage){
        Map<String, Object> messList = new HashMap<>();
//        List<Map<String, Object>> userMessages = listMess;
        Map<String, Object> message = new HashMap<>();
        Map<String, Object> content = new HashMap<>();
        if (textMessage.getContent() instanceof String){
            message.put(Constant.FIREBASE_MESSAGE_CONTENT, textMessage.getContent());
        } else {
            FileContent fileContent = (FileContent) textMessage.getContent();
            content.put(Constant.FIREBASE_MESSAGE_CONTENT_URL, fileContent.getUrl());
            content.put(Constant.FIREBASE_MESSAGE_CONTENT_NAME, fileContent.getName());
            content.put(Constant.FIREBASE_MESSAGE_CONTENT_TYPE, fileContent.getType());
            message.put(Constant.FIREBASE_MESSAGE_CONTENT, content);

        }
        Map<String, Object> from = new HashMap<>();
        MessageFrom messageFrom = textMessage.getMessageFrom();
        from.put(Constant.FIREBASE_MESSAGE_FROM_AVATAR, messageFrom.getAvatar());
        from.put(Constant.FIREBASE_MESSAGE_FROM_ID, messageFrom.getId());
        from.put(Constant.FIREBASE_MESSAGE_FROM_NAME, messageFrom.getName());

        message.put(Constant.FIREBASE_MESSAGE_FROM, from);
        message.put(Constant.FIREBASE_MESSAGE_TIMESTAMP, FieldValue.serverTimestamp());
        message.put(Constant.FIREBASE_MESSAGE_TYPE, textMessage.getType());
//        userMessages.add(message);
        messList.put(Constant.FIREBASE_MESSAGE_MESSLIST, message);

        db.collection(Constant.FIREBASE_MESSAGE)
                .document(boxId)
                .collection(Constant.FIREBASE_MESSAGE_MESSLIST)
                .add(message);

    }

    public void setRoomChat(String boxId, boolean isSingle, User user, boolean canJoin, List<String> joiningUsers){
        Map<String, Object> roomMap = new HashMap<>();
        Map<String, Object> userMap = new HashMap<>();
        userMap.put(Constant.FIREBASE_USER_ID, user.getId());
        userMap.put(Constant.FIREBASE_USER_USERNAME, user.getName());
        userMap.put(Constant.FIREBASE_USER_PHONE, user.getPhone());
        userMap.put(Constant.FIREBASE_USER_DOB, user.getDob());
        userMap.put(Constant.FIREBASE_USER_GENDER, user.isMale());
        userMap.put(Constant.FIREBASE_USER_AVATAR, user.getAvatar());
        roomMap.put(Constant.FIREBASE_MESSAGE_USER_CREATE, userMap);
        roomMap.put(Constant.FIREBASE_MESSAGE_CAN_JOIN, canJoin);
        roomMap.put(Constant.FIREBASE_MESSAGE_TYPE_ROOM, isSingle);
        roomMap.put(Constant.FIREBASE_MESSAGE_JOINING_USERS, joiningUsers);

        db.collection(Constant.FIREBASE_MESSAGE)
                .document(boxId)
                .set(roomMap);

    }

    public DocumentReference getRoomChat(String boxId){
        return db.collection(Constant.FIREBASE_MESSAGE)
                .document(boxId);
    }


}
