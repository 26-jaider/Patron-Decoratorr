package com.museum.decorator;

import com.museum.model.MuseumPass;
import java.util.ArrayList;
import java.util.List;

public class AccessibilityDecorator extends PassDecorator {

    public AccessibilityDecorator(MuseumPass pass) {
        super(pass);
    }

    @Override
    public String getDescription() {
        return pass.getDescription() + " + Accessibility Mode";
    }

    @Override
    public double getPrice() {
        return pass.getPrice() + 3.00;
    }

    @Override
    public List<String> getServices() {
        List<String> services = new ArrayList<>(pass.getServices());
        services.add("Accessibility Mode");
        return services;
    }

    @Override
    public String activate() {
        return pass.activate() + " Accessibility mode activated.";
    }
}
