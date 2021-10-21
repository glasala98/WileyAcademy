package com.sg.DVDLibrary.dao;

import com.sg.DVDLibrary.dto.DVD;
import java.util.List;

public interface DVDLibraryDao {
    List<DVD> getAll() throws DVDLibraryDaoEx;
    DVD addDvd(String dvdTitle, DVD dvd) throws DVDLibraryDaoEx;
    DVD removeDvd(String dvdTitle) throws DVDLibraryDaoEx;
    DVD getDvd(String dvdTitle) throws DVDLibraryDaoEx;
}
