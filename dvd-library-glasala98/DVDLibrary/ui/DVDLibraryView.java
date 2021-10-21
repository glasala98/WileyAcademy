package com.sg.DVDLibrary.ui;

import com.sg.DVDLibrary.dto.DVD;

import java.util.List;

public class DVDLibraryView {
    private UserIO io = new UserIOConsoleImpl();

    public DVDLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection(){
        io.print("Main Menu");
        io.print("1. List All DVDs");
        io.print("2. Add a DVD");
        io.print("3. Remove a DVD");
        io.print("4. Edit a DVDs Information");
        io.print("5. Search and View Information by DVD Title");
        io.print("6. Exit");
        return io.readInt("Please select from the above choices.", 1, 6);
    }

    public DVD getNewDVDInfo(){
        String dvdName = io.readString("Please enter DVD Title");
        int releaseDate = io.readInt("Please enter release date",0,2018);
        String mpaaRating = io.readString("Please enter the DVD's MPAA Rating");
        String studio = io.readString("Please enter the Studio");
        String director = io.readString("Please enter the director's name");
        String viewerNotes = io.readString("Please enter your Viewer Notes and Rating");
        DVD currentDvd = new DVD(dvdName);
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setMpaaRating(mpaaRating);
        currentDvd.setStudio(studio);
        currentDvd.setDirector(director);
        currentDvd.setViewerNotes(viewerNotes);
        return currentDvd;
    }

    public DVD editDVDInfo(DVD dvd){
        if(dvd != null){
            int releaseDate = io.readInt("Please enter release date",0,2018);
            String mpaaRating = io.readString("Please enter the DVD's MPAA Rating");
            String director = io.readString("Please enter the director's name");
            String studio = io.readString("Please enter the Studio");
            String viewerNotes = io.readString("Please enter your notes and rating");
            dvd.setReleaseDate(releaseDate);
            dvd.setMpaaRating(mpaaRating);
            dvd.setStudio(studio);
            dvd.setDirector(director);
            dvd.setViewerNotes(viewerNotes);
        }
        else{
            io.print("No such DVD exists!");
        }
        return dvd;
    }

    public void displayDVDList(List<DVD> dvdList){
        for (DVD currentDvd : dvdList) {
            io.print(currentDvd.getTitle() + ": " + currentDvd.getReleaseDate() + " " + currentDvd.getMpaaRating()  + " " + currentDvd.getStudio() + " " + currentDvd.getDirector()+ " " + currentDvd.getViewerNotes());
        }
        io.readString("Hit enter to continue.");
    }

    public void displayDVD(DVD dvd){
        if (dvd != null) {
            io.print( dvd.getTitle() + ": "
                    + dvd.getReleaseDate() + " "
                    + dvd.getMpaaRating()  + " "
                    + dvd.getStudio()      + " "
                    + dvd.getDirector()+ " "
                    + dvd.getViewerNotes());
        } else {
            io.print("No such DVD exists.");
        }
        io.readString("Hit enter to continue.");
    }

    public void displayListAllDvdsBanner() {
        io.print("*** DVD Collection ***");
    }

    public void displayAddDvdBanner() {
        io.print("*** Add DVD ***");
    }

    public void displayAddDvdSuccessBanner() {
        io.readString("DVD successfully added.  Hit press enter to continue");
    }

    public void displayRemoveDvdBanner() {
        io.print("*** Remove DVD ***");
    }

    public String getDvdTitleChoice() {
        return io.readString("Hit enter the DVD Title.");
    }

    public void displayRemoveDvdSuccessBanner() {
        io.readString("DVD successfully removed.  Hit press enter to continue");
    }

    public void displayEditDvdBanner() {
        io.readString("Hit enter the DVD you wish to edit.  Then hit press enter to continue");
    }

    public void displayEditDvdSuccessBanner() {
        io.readString("DVD succcessfully edited.  Hit press enter to continue");
    }

    public void displaySearchDvdByNameBanner() {
        io.print("*** Search DVD By Name ***");
    }

    public void displayPromptToContinueBanner() {
        io.print("Hit press enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
