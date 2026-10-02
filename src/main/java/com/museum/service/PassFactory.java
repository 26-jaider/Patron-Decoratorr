package com.museum.service;

import com.museum.decorator.*;
import com.museum.model.BasicMuseumPass;
import com.museum.model.MuseumPass;

import java.util.Set;

public class PassFactory {

    public MuseumPass createPass(Set<String> options) {

        MuseumPass pass = new BasicMuseumPass();

        if (options.contains("audio")) {
            pass = new AudioGuideDecorator(pass);
        }

        if (options.contains("virtual")) {
            pass = new VirtualTourDecorator(pass);
        }

        if (options.contains("vip")) {
            pass = new VipAccessDecorator(pass);
        }

        if (options.contains("accessibility")) {
            pass = new AccessibilityDecorator(pass);
        }

        return pass;
    }
}
