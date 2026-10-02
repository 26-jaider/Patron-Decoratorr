package com.museum.decorator;

import com.museum.model.MuseumPass;
import java.util.List;

public abstract class PassDecorator implements MuseumPass {

    protected final MuseumPass pass;

    protected PassDecorator(MuseumPass pass) {
        this.pass = pass;
    }

    @Override
    public String getDescription() {
        return pass.getDescription();
    }

    @Override
    public double getPrice() {
        return pass.getPrice();
    }

    @Override
    public List<String> getServices() {
        return pass.getServices();
    }

    @Override
    public String activate() {
        return pass.activate();
    }
}
