package com.sg.DVDLibrary.controller;

import com.sg.DVDLibrary.dao.DVDLibraryDao;
import com.sg.DVDLibrary.dao.DVDLibraryDaoEx;
import com.sg.DVDLibrary.dto.DVD;
import com.sg.DVDLibrary.ui.DVDLibraryView;

import java.util.List;

public class DVDLibraryController {
    DVDLibraryView view;
    DVDLibraryDao dao;

    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view) {
        this.view = view;
        this.dao = dao;
    }


    public void run() {
        boolean keepGoing = true;
        int menuSelect;
        try {
            while(keepGoing){
                menuSelect = getMenuSelection();
                switch (menuSelect) {
                    case 1:
                        listDVDs();
                        break;
                    case 2:
                        addDVD();
                        break;
                    case 3:
                        removeDVD();
                        break;
                    case 4:
                        editDVD();
                        break;
                    case 5:
                        searchAndDisplayDVD();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
        } catch (DVDLibraryDaoEx e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void listDVDs() throws DVDLibraryDaoEx{
        view.displayListAllDvdsBanner();
        List<DVD> dvdList = dao.getAll();
        view.displayDVDList(dvdList);
    }

    private void addDVD() throws DVDLibraryDaoEx{
        view.displayAddDvdBanner();
        DVD newDvd = view.getNewDVDInfo();
        dao.addDvd(newDvd.getTitle(), newDvd);
        view.displayAddDvdSuccessBanner();
    }

    private void removeDVD() throws DVDLibraryDaoEx{
        view.displayRemoveDvdBanner();
        String dvdTitle = view.getDvdTitleChoice();
        dao.removeDvd(dvdTitle);
        view.displayRemoveDvdSuccessBanner();
    }

    private void editDVD() throws DVDLibraryDaoEx{
        view.displayEditDvdBanner();
        String dvdTitle = view.getDvdTitleChoice();
        DVD dvd = dao.getDvd(dvdTitle);
        view.editDVDInfo(dvd);
        dao.addDvd(dvdTitle, dvd);
        view.displayEditDvdSuccessBanner();
    }

    private void searchAndDisplayDVD() throws DVDLibraryDaoEx{
        view.displaySearchDvdByNameBanner();
        String dvdTitle = view.getDvdTitleChoice();
        DVD dvd = dao.getDvd(dvdTitle);
        view.displayDVD(dvd);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}
