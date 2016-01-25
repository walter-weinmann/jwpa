package com.jwpa.services;

public class ServiceProvider {

    public ServiceProvider() {
        // TODO Auto-generated constructor stub
    }
    
    public ContainerService getContainerService() {
        
    }
    
    private final static ServiceProvider INSTANCE = new ServiceProvider();
    
    public static final ServiceProvider getInstance() {
        return INSTANCE;
    }

}
