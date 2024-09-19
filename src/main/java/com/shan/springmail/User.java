package com.shan.springmail;

public class User {
    private String name;
    private String managerName;
    private String businessName;
    private String className;

    public User(String name, String managerName, String businessName, String className) {
        this.name = name;
        this.managerName = managerName;
        this.businessName = businessName;
        this.className = className;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getManagerName() { return managerName; }
    public void setManagerName(String managerName) { this.managerName = managerName; }

    public String getBusinessName() { return businessName; }
    public void setBusinessName(String businessName) { this.businessName = businessName; }

    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }
}
