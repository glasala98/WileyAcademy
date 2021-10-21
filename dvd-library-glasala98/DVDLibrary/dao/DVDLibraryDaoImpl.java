package com.sg.DVDLibrary.dao;

import com.sg.DVDLibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class DVDLibraryDaoImpl implements  DVDLibraryDao{
    public static final String DVDLIBRARY_FILE = "DVDlibrary.txt";
    public static final String DELIMITER = "::";
    private Map<String, DVD> dvds = new HashMap<>();

    private void loadLibrary() throws DVDLibraryDaoEx {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(DVDLIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoEx("Error Could not load data to memory!", e);
        }

        String currentLine;

        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            DVD currentDvd = new DVD(currentTokens[0]);

            currentDvd.setReleaseDate(Integer.parseInt(currentTokens[1]));
            currentDvd.setMpaaRating(currentTokens[2]);
            currentDvd.setStudio(currentTokens[3]);
            currentDvd.setDirector((currentTokens[4]));
            currentDvd.setViewerNotes(currentTokens[5]);

            dvds.put(currentDvd.getTitle(), currentDvd);
        }
        scanner.close();
    }

    private void writeLibrary() throws DVDLibraryDaoEx{

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DVDLIBRARY_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoEx("Could not save dvd data.", e);
        }

        List<DVD> dvdList = this.getAll();
        for (DVD currentDvd : dvdList) {

            out.println(currentDvd.getTitle() + DELIMITER
                    + currentDvd.getReleaseDate() + DELIMITER
                    + currentDvd.getMpaaRating() + DELIMITER
                    + currentDvd.getStudio() + DELIMITER
                    + currentDvd.getDirector() + DELIMITER
                    + currentDvd.getViewerNotes());
            out.flush();
        }
        out.close();
    }

    @Override
    public List<DVD> getAll() throws DVDLibraryDaoEx {
        loadLibrary();
        return new ArrayList<>(dvds.values());
    }

    @Override
    public DVD addDvd(String dvdTitle, DVD dvd) throws DVDLibraryDaoEx {
        DVD newDvd = dvds.put(dvdTitle, dvd);
        writeLibrary();
        return newDvd;
    }

    @Override
    public DVD removeDvd(String dvdTitle) throws DVDLibraryDaoEx {
        DVD removedDvd = dvds.remove(dvdTitle);
        writeLibrary();
        return removedDvd;
    }

    @Override
    public DVD getDvd(String dvdTitle) throws DVDLibraryDaoEx {
        loadLibrary();
        return dvds.get(dvdTitle);
    }
}
