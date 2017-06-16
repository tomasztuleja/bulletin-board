package com.ttuleja.Service;

import com.ttuleja.Dao.PrivateMessageDao;
import com.ttuleja.Entity.PrivateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Tomal on 2017-06-15.
 */
@Service
public class PrivateMessageService {

    @Autowired
    private PrivateMessageDao privateMessageDao;


    public Collection<PrivateMessage> showReceivedPrivateMessages(String user_name) {
        return this.privateMessageDao.showReceivedPrivateMessages(user_name);

    }

    public Collection<PrivateMessage> showSentPrivateMessages(String user_name) {
        try {
            return this.privateMessageDao.showSentPrivateMessages(user_name);
        } catch (NullPointerException e) {
            return null;
        }
    }

    public int checkIfMessageBelongsToUser(int id, String user_name) {
        return this.privateMessageDao.checkIfMessageBelongsToUser(id, user_name);

    }

    public PrivateMessage showPrivateMessage(int id) {
        return this.privateMessageDao.showPrivateMessage(id);

    }

    public void sendPrivateMessage(String user_name, String target_name, String topic, String content) {
        this.privateMessageDao.sendPrivateMessage(user_name, target_name, topic, content);

    }
}
