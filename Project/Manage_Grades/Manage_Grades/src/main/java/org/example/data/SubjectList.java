package org.example.data;

import org.example.constants.CommonConstants;
import org.example.configuration.Subject;

public class SubjectList {

    private SubjectList() {}
    private static final Subject[] list = { // 27 Subjects
            new Subject("Art and Globalization", 3, CommonConstants.getType(1)),
            new Subject("Emerging Humanity", 3, CommonConstants.getType(1)),
            new Subject("Peoples and Cultures of Africa", 3, CommonConstants.getType(1)),
            new Subject("Politics and Statemaking in Latin America", 3, CommonConstants.getType(1)),
            new Subject("The Making of Modern East Asia", 3, CommonConstants.getType(1)),
            new Subject("Healing Justice", 3, CommonConstants.getType(1)),
            new Subject("Education, Media, and Society", 3, CommonConstants.getType(1)),
            new Subject("Earthquakes", 3, CommonConstants.getType(1)),
            new Subject("Syntactic Structures", 3, CommonConstants.getType(1)),
            new Subject("Robot Automation: Intelligence through Feedback Control", 3, CommonConstants.getType(1)),
            new Subject("Calculus with Applications", 3, CommonConstants.getType(1)),
            new Subject("Precalculus", 3, CommonConstants.getType(1)),
            new Subject("Vector Calculus", 3, CommonConstants.getType(1)),
            new Subject("Introduction to Biological Anthropology", 3, CommonConstants.getType(1)),
            new Subject("Environmental Physiology", 3, CommonConstants.getType(1)),
            new Subject("General Chemistry", 3, CommonConstants.getType(1)),
            new Subject("Physiology of Disease", 3, CommonConstants.getType(1)),
            new Subject("Introduction to Population Health", 3, CommonConstants.getType(1)),
            new Subject("Reason, Logic, and the Idols of Thought", 3, CommonConstants.getType(1)),
            new Subject("What is Revolution?", 3, CommonConstants.getType(1)),
            new Subject("Advanced Japanese.", 3, CommonConstants.getType(1)),
            new Subject("Monsters and Literature.", 3, CommonConstants.getType(1)),
            new Subject("Understanding Shakespeare", 3, CommonConstants.getType(1)),
            new Subject("Floods, Epidemics, and Famine: Environmental History of the Early Modern Atlantic World", 3, CommonConstants.getType(1)),
            new Subject("Elementary Physics of Energy.", 3, CommonConstants.getType(1)),
            new Subject("Music, Politics, and Protest", 3, CommonConstants.getType(1)),
            new Subject("Digital Tools for Contemporary Art Practice", 3, CommonConstants.getType(1))
    };
    public static Subject[] getList() {
        return list;
    }
    // Reference : https://registrar.ucsc.edu/enrollment/general-education-requirements.html
}
