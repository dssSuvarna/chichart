package com.activ8.chichart.core.service.snippet;

import com.activ8.chichart.core.domain.*;

import java.util.*;

public class SnippetDescriptionProvider {
    private static Map<SnippetCode, String> descriptions = new HashMap<>();

    static {
        descriptions.put(SnippetCode.A1, "Be proactive, take your own path and gain a competitive edge!");
        descriptions.put(SnippetCode.A2, "In order to succeed, be focused, firm and direct.");
        descriptions.put(SnippetCode.A3, "To maximise opportunities, be creative annd think outside the box.");
        descriptions.put(SnippetCode.A4, "To achieve positive outcomes, be gentle and flexible.");
        descriptions.put(SnippetCode.A5, "Be conservative with your finances today.");
        descriptions.put(SnippetCode.A6, "Exercise care and control with money today.");
        descriptions.put(SnippetCode.A7, "Avoid challenging those in authority and maintain an unassuming profile to attract luck.");
        descriptions.put(SnippetCode.A8, "Take a mature approach to petty behaviour, or those who seek to control you.");
        descriptions.put(SnippetCode.A9, "Ask for assistance, or delegate tasks.");
        descriptions.put(SnippetCode.A10, "Rely on others today and seek, or spend time with your superiors.");
        descriptions.put(SnippetCode.A11, "Take care to protect your work and reputation. Be wary of competitors.");
        descriptions.put(SnippetCode.A12, "If you are focused on your tasks, you will make a great deal of headway. If you don't aim for your own goals, then others will have you working on theirs.");
        descriptions.put(SnippetCode.A13, "Seek out advancement. Sign contracts, or undertake legal proceedings.");
        descriptions.put(SnippetCode.A14, "Before accepting help, consider the hidden agendas of those willing to assist you.");
        descriptions.put(SnippetCode.A15, "Taking on responsibility is of the utmost importance, step up and power through.");
        descriptions.put(SnippetCode.A16, "There is a competitive vibe in the air today, be careful in what you say as your words could be used against you.");
        descriptions.put(SnippetCode.A17, "Review your options, reflect on where you stand, be cautious in making important decisions, or taking direct action.");
        descriptions.put(SnippetCode.A18, "Others may resist your new ideas, however, take the opportunity to demonstrate how industrious you are to work colleagues and superiors.");
        descriptions.put(SnippetCode.A19, "You may feel imposed upon, like everyone wants a little piece of you. Remain focused on your own path and avoid being taken advantage of.");
        descriptions.put(SnippetCode.A20, "Today is a good day for creating wealth, however, it's likely to be a one-off lucky break.");
        descriptions.put(SnippetCode.A21, "Focus on future financial goals, the energy of today reflects long-term income.");
    }

    public String getDescription(SnippetCode snippetCode) {
        return descriptions.get(snippetCode);
    }
}
