package LabJava.fooapp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FooComponent {
    public FooComponent(String bar) { log.info("construction foo component",bar); }
}
