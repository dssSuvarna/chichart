package com.activ8.chichart.core.domain;

public class Snippet {

    private SnippetCode branchCode;
    private SnippetCode stemCode;

    public Snippet(SnippetCode branchCode, SnippetCode stemCode) {
        this.branchCode = branchCode;
        this.stemCode = stemCode;
    }

    public SnippetCode getBranchCode() {
        return branchCode;
    }

    public SnippetCode getStemCode() {
        return stemCode;
    }

    public String getCssClass(SnippetCode snippetCode) {
        return snippetCode.isFavourable() ? "good" : "bad";
    }

    @Override
    public String toString() {
        return "Snippet{" +
                "branchCode=" + branchCode +
                ", stemCode=" + stemCode +
                '}';
    }
}
