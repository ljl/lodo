package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index(boolean all) {
    	List<Entry> entries = null;
    	if  (all) {
    		 entries = Entry.all().fetch();
    	} else {
    		entries = Entry.all().filter("parent", null).fetch();
    	}
    	
    	
    	render(entries);
    }
    
    public static void showEntry(Long id) {
    	Entry entry = Entry.getEntryById(id);
    	List<Entry> children = Entry.all().filter("parent", entry).fetch();
    	
    	render(entry, children);
    }
    
    public static void removeEntry(Long id, String redirect) {
    	Entry entry = Entry.getEntryById(id);
    	entry.delete();
    	redirect(redirect);
    }
    
    public static void addEntry(String content, Long parentId, String redirect) {
    	Entry e = new Entry();    	
    	e.content = content;
    	if (parentId != null) {
    		e.parent = Entry.getEntryById(parentId);
   
    	}
    	
    	e.save();
    	
    	redirect(redirect);
    }
    
    public static void completeEntry(Long id, String redirect) {
    	Entry e = Entry.getEntryById(id);
    	e.complete = true;
    	e.update();
    	
    	redirect(redirect);
    }
    
    public static void uncompleteEntry(Long id, String redirect) {
    	Entry e = Entry.getEntryById(id);
    	e.complete = false;
    	e.update();
    	
    	redirect(redirect);
    }

}