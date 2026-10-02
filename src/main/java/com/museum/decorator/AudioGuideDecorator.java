package com.museum.decorator;

import com.museum.model.MuseumPass;
import java.util.ArrayList;
import java.util.List;

public class AudioGuideDecorator extends PassDecorator {

    public AudioGuideDecorator(MuseumPass pass) {
        super(pass);
    }

    @Override
    public String getDescription() {
        return pass.getDescription() + " + Audio Guide";
    }

    @Override
    public double getPrice() {
        return pass.getPrice() + 4.00;
    }

    @Override
    public List<String> getServices() {
        List<String> services = new ArrayList<>(pass.getServices());
        services.add("Audio Guide");
        return services;
    }

    @Override
    public String activate() {
        return pass.activate() + " Audio guide activated.";
    }
}
