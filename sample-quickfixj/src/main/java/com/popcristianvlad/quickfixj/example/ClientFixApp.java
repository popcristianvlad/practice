package com.popcristianvlad.quickfixj.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quickfix.*;

@Slf4j
@Component
public class ClientFixApp implements Application {

    @Override
    public void onCreate(SessionID sessionID) {
        log.info("--------- onCreate ---------");
    }

    @Override
    public void onLogon(SessionID sessionID) {
        log.info("--------- onLogon ---------");
    }

    @Override
    public void onLogout(SessionID sessionID) {
        log.info("--------- onLogout ---------");
    }

    @Override
    public void toAdmin(Message message, SessionID sessionID) {
        log.info("--------- toAdmin ---------");
    }

    @Override
    public void fromAdmin(Message message, SessionID sessionID) {
        log.info("--------- fromAdmin ---------");
    }

    @Override
    public void toApp(Message message, SessionID sessionID) {
        log.info("--------- toApp ---------");
    }

    @Override
    public void fromApp(Message message, SessionID sessionID) {
        log.info("--------- fromApp ---------");
    }
}
