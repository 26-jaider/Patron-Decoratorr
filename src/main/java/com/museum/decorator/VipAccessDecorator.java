package com.museum.decorator;

import com.museum.model.MuseumPass;
import java.util.ArrayList;
import java.util.List;

public class VipAccessDecorator extends PassDecorator {

    public VipAccessDecorator(MuseumPass pass) {
        super(pass);
    }

    @Override
    public String getDescription() {
        return pass.getDescription() + " + VIP Access";
    }

    @Override
    public double getPrice() {
        return pass.getPrice() + 12.00;
    }

    @Override
    public List<String> getServices() {
        List<String> services = new ArrayList<>(pass.getServices());
        services.add("VIP Access");
        return services;
    }

    @Override
    public String activate() {
        return pass.activate() + " VIP access activated.";
    }
}
