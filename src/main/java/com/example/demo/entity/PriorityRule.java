package com.example.demo.entity;

public class PriorityRule {

    private Long id;
    private String ruleName;
    private boolean active;

    public PriorityRule() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
