package com.sg.DVDLibrary.dto;

public class DVD {
    private String title;
    private int releaseDate;
    private String mpaaRating;
    private String director;
    private String studio;
    private String viewerNotes;

    public DVD(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String directorsName) {
        this.director = directorsName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getViewerNotes() {
        return viewerNotes;
    }

    public void setViewerNotes(String viewerNotes) {
        this.viewerNotes = viewerNotes;
    }
}