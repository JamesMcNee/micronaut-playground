package uk.co.jamesmcnee.controller.model;

public class HelloResponse {

    private final String greeting;
    private final String recipient;

    public HelloResponse(String greeting, String recipient) {
        this.greeting = greeting;
        this.recipient = recipient;
    }

    public String getGreeting() {
        return greeting;
    }

    public String getRecipient() {
        return recipient;
    }
}
