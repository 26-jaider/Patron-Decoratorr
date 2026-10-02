package com.museum.model;

import java.util.List;

public interface MuseumPass {
    String getDescription();
    double getPrice();
    List<String> getServices();
    String activate();
}
