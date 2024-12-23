package com.scm.helpers;

public class Message {
    public String getContent() {
        return content;
    }

    public Message() {
    }

    public Message(String content, MessageType type) {
        this.content = content;
        this.type = type;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    private String content;
    private MessageType type=MessageType.blue;

    // Private constructor to restrict object creation directly
    private Message(MessageBuilder builder) {
        this.content = builder.content;
        this.type = builder.type;
    }

    // Static inner builder class
    public static class MessageBuilder {
        private String content;
        private MessageType type = MessageType.blue;

        public MessageBuilder() {
        }

        // Setter for content
        public MessageBuilder setContent(String content) {
            this.content = content;
            return this;
        }

        // Setter for type
        public MessageBuilder setType(MessageType type) {
            this.type = type;
            return this;
        }

        // Build method
        public Message build() {
            return new Message(this);
        }
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                ", type=" + type +
                '}';
    }


}
