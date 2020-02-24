package com.example.demo.twilio;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import org.springframework.stereotype.Service;

@Service
public class TwilioServiceImpl {

    public boolean sendMessage(String to, String message) {
        boolean isSended = true;
        try {
            Message sendedMessage = Message
                    .creator(new PhoneNumber(to),
                            new PhoneNumber("+12564190179"),
                            message)
                    .create();
        } catch (Exception e) {
            isSended = false;
            e.printStackTrace();
        }
        return isSended;
    }
}
