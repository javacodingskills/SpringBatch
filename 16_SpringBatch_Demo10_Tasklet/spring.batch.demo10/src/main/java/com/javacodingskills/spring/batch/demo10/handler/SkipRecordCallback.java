package com.javacodingskills.spring.batch.demo10.handler;

import org.springframework.batch.item.file.LineCallbackHandler;



public class SkipRecordCallback implements LineCallbackHandler {



    @Override
    public void handleLine(String s) {
        System.out.println("##### First record data ####" + s);
    }
}
