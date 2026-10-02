package com.museum.model;

import java.util.ArrayList;
import java.util.List;

public class BasicMuseumPass implements MuseumPass {

    @Override
    public String getDescription() {
        return "Basic Museum Pass";
    }

    @Override
    public double getPrice() {
        return 15.00;
    }

    @Override
    public List<String> getServices() {
        return new ArrayList<>(List.of("Museum Entry"));
    }

    @Override
    public String activate() {
        return "Basic museum pass activated successfully.";
    }
}
