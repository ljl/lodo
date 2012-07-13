package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
    	List<Entry> entries = Entry.all().fetch();
    	
    	render(entries);
    }
    
    public static void listEntries() {
    	List<Entry> entries = Entry.all().fetch();
    	
    	render(entries);
    }
    
    public static void addEntry(String content, Long parentId) {
    	Entry e = new Entry();
    	e.content = content;
    	e.parent = Entry.getEntryById(parentId);
    	
    	e.save();
    	
    	index();
    }

}