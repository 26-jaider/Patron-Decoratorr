package com.museum.decorator;

import com.museum.model.MuseumPass;
import java.util.ArrayList;
import java.util.List;

public class VirtualTourDecorator extends PassDecorator {

    public VirtualTourDecorator(MuseumPass pass) {
        super(pass);
    }

    @Override
    public String getDescription() {
        return pass.getDescription() + " + Virtual Tour";
    }

    @Override
    public double getPrice() {
        return pass.getPrice() + 6.00;
    }

    @Override
    public List<String> getServices() {
        List<String> services = new ArrayList<>(pass.getServices());
        services.add("Virtual Tour");
        return services;
    }

    @Override
    public String activate() {
        return pass.activate() + " Virtual tour activated.";
    }
}
