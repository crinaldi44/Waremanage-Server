package com.testing.warmanagespring.models;

public class AddResponse {

    protected int resourceId;

    public AddResponse(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}
